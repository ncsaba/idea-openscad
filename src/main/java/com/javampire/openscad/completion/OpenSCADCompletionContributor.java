package com.javampire.openscad.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.keymap.KeymapUtil;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.parser.OpenSCADParserDefinition;
import com.javampire.openscad.psi.*;
import com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil;
import com.javampire.openscad.references.OpenSCADResolver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class OpenSCADCompletionContributor extends CompletionContributor {

    private static final String _FROM_ = " from ";
    private static final String BUILT_IN_MISSING_FUNCTION = "select";
    private static final String BUILT_IN_MODULES_FILENAME = "builtin_modules.scad";
    private static final String BUILT_IN_FUNCTIONS_FILENAME = "builtin_functions.scad";

    private static List<LookupElement> builtinModulesAndFunctions;
    private static List<LookupElement> globalLibrariesModulesAndFunctions;

    public OpenSCADCompletionContributor() {
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(OpenSCADLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(
                            @NotNull CompletionParameters parameters,
                            @NotNull ProcessingContext context,
                            @NotNull CompletionResultSet result) {

                        final Project project = parameters.getOriginalFile().getProject();
                        final PsiElement elementPosition = parameters.getPosition();

                        // No autocompletion when editing argument lists
                        if (OpenSCADTypes.ARG_DECLARATION == elementPosition.getParent().getNode().getElementType()) {
                            return;
                        }

                        // Add all accessible variables in the current file
                        addAccessibleVariables(result, elementPosition, null);
                        ProgressManager.checkCanceled();

                        // Add all parent arguments (from declaration lists)
                        addAccessibleArgumentDeclarations(result, elementPosition);
                        ProgressManager.checkCanceled();

                        // Add all accessible variables in includes
                        addIncludesAccessibleVariables(result, elementPosition);
                        ProgressManager.checkCanceled();

                        // Add local custom modules
                        addModules(result, elementPosition, null);
                        ProgressManager.checkCanceled();

                        // Add local custom functions
                        addFunctions(result, elementPosition, null);
                        ProgressManager.checkCanceled();

                        // Add builtin modules and functions
                        addBuiltinModulesAndFunctions(result, project);
                        ProgressManager.checkCanceled();

                        // Add declared library methods and functions
                        addLocalLibrariesModulesAndFunctions(result, elementPosition);
                        ProgressManager.checkCanceled();

                        // Second completion case
                        if (parameters.getInvocationCount() % 2 == 0) {
                            // Add all possible functions and method from global libraries
                            addGlobalLibrariesModulesAndFunctions(result, project);
                            result.addLookupAdvertisement("Press " + KeymapUtil.getFirstKeyboardShortcutText(ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION)) + " to see accessible variables, functions and methods.");
                        } else {
                            result.addLookupAdvertisement("Press " + KeymapUtil.getFirstKeyboardShortcutText(ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION)) + " to add non-imported functions and methods.");
                        }
                    }
                }
        );
    }

    /**
     * Get accessible variables declarations for the current element.
     *
     * @param result   Result set.
     * @param element  Psi element.
     * @param tailText Tail text to show in the result.
     */
    private void addAccessibleVariables(final CompletionResultSet result, final PsiElement element, final String tailText) {
        final List<OpenSCADVariableDeclaration> variableDeclarations = OpenSCADPsiImplUtil.getAccessibleVariableDeclaration(element);
        result.addAllElements(convertToLookupElements(variableDeclarations, null));
    }

    /**
     * Get accessible variables declarations from parent argument list declarations, i.e. variables declared in function or module parameters.
     *
     * @param result  Result set.
     * @param element Psi element.
     */
    private void addAccessibleArgumentDeclarations(final CompletionResultSet result, final PsiElement element) {
        // Parents with ARG_DECLARATION_LIST : modules and functions
        final List<PsiElement> parentsWithArgDeclarationList = OpenSCADPsiImplUtil.getParentsOfType(element, OpenSCADParserDefinition.WITH_ARG_DECLARATION_LIST);
        final List<OpenSCADArgDeclaration> argDeclarations = parentsWithArgDeclarationList.stream()
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADArgDeclarationList.class))
                .filter(Objects::nonNull)
                .flatMap(e -> PsiTreeUtil.getChildrenOfTypeAsList(e, OpenSCADArgDeclaration.class).stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        result.addAllElements(convertToLookupElements(argDeclarations, null));

        // Parents with FULL_ARG_DECLARATION_LIST : for loop
        final List<PsiElement> parentsWithFullArgDeclarationList = OpenSCADPsiImplUtil.getParentsOfType(element, OpenSCADParserDefinition.WITH_FULL_ARG_DECLARATION_LIST);
        final List<PsiElement> fullArgDeclarations = parentsWithFullArgDeclarationList.stream()
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADFullArgDeclarationList.class))
                .filter(Objects::nonNull)
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADFullArgDeclaration.class))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        result.addAllElements(convertToLookupElements(fullArgDeclarations, null));
    }

    /**
     * Get accessible variables declaration from included files for the current element.
     *
     * @param result  Result set.
     * @param element Psi elements.
     */
    private void addIncludesAccessibleVariables(final CompletionResultSet result, final PsiElement element) {
        final Module module = ModuleUtil.findModuleForPsiElement(element);

        // Loop through declarations
        final List<PsiElement> includes = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADIncludeItem.class);
        for (PsiElement include : includes) {
            // Get relative paths
            final String importPath = OpenSCADPsiImplUtil.getPresentation(include).getPresentableText();
            if (importPath == null) continue;

            // Get psi file
            final List<PsiFile> psiFiles;
            if (module != null) {
                psiFiles = OpenSCADResolver.findModuleContentFile(module, importPath);
            } else {
                psiFiles = OpenSCADResolver.findProjectLibrary(element.getProject(), importPath);
            }
            if (psiFiles.isEmpty()) continue;

            // Get all variable declaration
            final List<OpenSCADVariableDeclaration> varDeclarations = PsiTreeUtil.getChildrenOfTypeAsList(psiFiles.get(0), OpenSCADVariableDeclaration.class);

            // Add all include variables
            result.addAllElements(convertToLookupElements(varDeclarations, _FROM_ + importPath));
        }
    }

    /**
     * Get module declarations.
     *
     * @param result   Result set.
     * @param element  Psi element.
     * @param tailText Tail text to display with completion result.
     */
    private void addModules(final CompletionResultSet result, final PsiElement element, final String tailText) {
        result.addAllElements(getModules(element, tailText));
    }

    /**
     * Get module declarations.
     *
     * @param element  Psi element.
     * @param tailText Tail text to display with completion result.
     * @return List of modules.
     */
    private List<LookupElement> getModules(final PsiElement element, final String tailText) {
        final List<OpenSCADModuleDeclaration> moduleDeclarations = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADModuleDeclaration.class);
        return convertToLookupElements(moduleDeclarations, tailText);
    }

    /**
     * Get function declarations.
     *
     * @param result   Result set.
     * @param element  Psi element.
     * @param tailText Tail text to display with completion result.
     */
    private void addFunctions(final CompletionResultSet result, final PsiElement element, final String tailText) {
        result.addAllElements(getFunctions(element, tailText));
    }

    /**
     * Get function declarations.
     *
     * @param element  Psi element.
     * @param tailText Tail text to display with completion result.
     * @return List of functions.
     */
    private List<LookupElement> getFunctions(final PsiElement element, final String tailText) {
        final List<OpenSCADFunctionDeclaration> functionDeclarations = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADFunctionDeclaration.class);
        return convertToLookupElements(functionDeclarations, tailText);
    }

    private void addBuiltinModulesAndFunctions(final CompletionResultSet result, final Project project) {
        if (builtinModulesAndFunctions == null) {
            // Add builtin modules
            PsiFile[] builtinModuleResults = FilenameIndex.getFilesByName(project, BUILT_IN_MODULES_FILENAME, GlobalSearchScope.everythingScope(project));
            builtinModulesAndFunctions = getModules(builtinModuleResults[0], null);
            // Add builtin functions
            PsiFile[] builtinFunctionResults = FilenameIndex.getFilesByName(project, BUILT_IN_FUNCTIONS_FILENAME, GlobalSearchScope.everythingScope(project));
            builtinModulesAndFunctions.addAll(getFunctions(builtinFunctionResults[0], null));
            builtinModulesAndFunctions.add(LookupElementBuilder.create(BUILT_IN_MISSING_FUNCTION).withIcon(OpenSCADIcons.FUNCTION));
        }
        result.addAllElements(builtinModulesAndFunctions);
    }

    /**
     * Get edited file include and use declaration targets.
     *
     * @param result  Result set.
     * @param element Current element.
     */
    private void addLocalLibrariesModulesAndFunctions(final CompletionResultSet result, final PsiElement element) {
        result.addAllElements(addLocalLibrariesModulesAndFunctions(new ArrayList<>(), element.getContainingFile()));
    }

    /**
     * Add local libraries recursively starting from file.
     *
     * @param addedFiles File already added, to avoid infinite loops, in case of cyclic dependencies.
     * @param file       File to analyze.
     * @return List of modules and functions lookups.
     */
    private List<LookupElement> addLocalLibrariesModulesAndFunctions(final List<PsiFile> addedFiles, final PsiFile file) {
        final List<LookupElement> imports = new ArrayList<>();

        // Loop through declarations
        final List<PsiElement> declarations = new ArrayList<>();
        declarations.addAll(PsiTreeUtil.getChildrenOfTypeAsList(file, OpenSCADUseItem.class));
        declarations.addAll(PsiTreeUtil.getChildrenOfTypeAsList(file, OpenSCADIncludeItem.class));
        final Module module = ModuleUtil.findModuleForFile(file.getOriginalFile());
        for (PsiElement declaration : declarations) {
            // Get relative paths
            final String importPath = OpenSCADPsiImplUtil.getPresentation(declaration).getPresentableText();
            if (importPath == null) continue;

            // Get psi file
            final List<PsiFile> psiFiles;
            if (module != null) {
                psiFiles = OpenSCADResolver.findModuleContentFile(module, importPath);
            } else {
                psiFiles = OpenSCADResolver.findProjectLibrary(file.getProject(), importPath);
            }
            if (psiFiles.isEmpty()) continue;
            final PsiFile dependency = psiFiles.get(0);

            imports.addAll(getFunctions(dependency, _FROM_ + importPath));
            imports.addAll(getModules(dependency, _FROM_ + importPath));

            // Recursive call to get sub dependencies
            if (!addedFiles.contains(dependency)) {
                addedFiles.add(dependency);
                imports.addAll(addLocalLibrariesModulesAndFunctions(addedFiles, dependency));
            }
        }
        return imports;
    }

    private void addGlobalLibrariesModulesAndFunctions(final CompletionResultSet result, final Project project) {
        if (globalLibrariesModulesAndFunctions == null) {
            // List global libraries paths
            PsiManager psiManager = PsiManager.getInstance(project);
            ModifiableModelsProvider modelsProvider = ModifiableModelsProvider.SERVICE.getInstance();
            Library[] librariesPathRoots = modelsProvider.getLibraryTableModifiableModel().getLibraries();
            final List<VirtualFile> librariesPaths = Arrays.stream(librariesPathRoots)
                    .map(libraryPathsRoot -> libraryPathsRoot.getFiles(OrderRootType.CLASSES))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());

            // For each global library path
            globalLibrariesModulesAndFunctions = new ArrayList<>();
            for (VirtualFile librariesPath : librariesPaths) {
                // List libraries files
                final List<PsiFile> libraries = VfsUtil.collectChildrenRecursively(librariesPath).stream()
                        .map(psiManager::findFile)
                        .filter(Objects::nonNull)
                        .filter(PsiElement::isValid)
                        .filter(psiFile -> psiFile.getFileType() == OpenSCADFileType.INSTANCE)
                        .collect(Collectors.toList());

                for (PsiFile library : libraries) {
                    final String libraryRelPath = library.getVirtualFile().getCanonicalPath().substring(librariesPath.getCanonicalPath().length() + 1);
                    globalLibrariesModulesAndFunctions.addAll(getModules(library, _FROM_ + libraryRelPath));
                    globalLibrariesModulesAndFunctions.addAll(getFunctions(library, _FROM_ + libraryRelPath));
                }
            }
        }
        result.addAllElements(globalLibrariesModulesAndFunctions);
    }

    private <T extends PsiElement> List<LookupElement> convertToLookupElements(final List<T> elements, final String tailText) {
        return elements.parallelStream()
                .map(OpenSCADPsiImplUtil::getPresentation)
                .map(presentation -> {
                    final String text = presentation.getPresentableText();
                    if (text == null) return null;
                    LookupElementBuilder builder = LookupElementBuilder.create(presentation.getPresentableText()).withIcon(presentation.getIcon(true));
                    if (tailText != null) {
                        builder = builder.appendTailText(tailText, true);
                    }
                    return builder;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
