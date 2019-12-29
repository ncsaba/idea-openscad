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

                        // Add all accessible variables
                        result.addAllElements(getAccessibleVariables(elementPosition));
                        ProgressManager.checkCanceled();

                        // Add all parent arguments (from declaration lists)
                        result.addAllElements(getAccessibleArgumentDeclarations(elementPosition));
                        ProgressManager.checkCanceled();

                        // Add local custom modules
                        result.addAllElements(getModules(elementPosition, null));
                        ProgressManager.checkCanceled();

                        // Add local custom functions
                        result.addAllElements(getFunctions(elementPosition, null));
                        ProgressManager.checkCanceled();

                        // Add builtin modules and functions
                        result.addAllElements(getBuiltinModulesAndFunctions(project));
                        ProgressManager.checkCanceled();

                        // Second completion case
                        if (parameters.getInvocationCount() % 2 == 0) {
                            // Add all possible functions and method from global libraries
                            result.addAllElements(getGlobalLibrariesModulesAndFunctions(project));
                            result.addLookupAdvertisement("Press " + KeymapUtil.getFirstKeyboardShortcutText(ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION)) + " to see accessible variables, functions and methods.");
                        } else {
                            // Add declared library methods and functions
                            result.addAllElements(getLocalLibrariesModulesAndFunctions(elementPosition));
                            result.addLookupAdvertisement("Press " + KeymapUtil.getFirstKeyboardShortcutText(ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION)) + " to add non-imported functions and methods.");
                        }
                    }
                }
        );
    }

    private List<LookupElement> getBuiltinModulesAndFunctions(final Project project) {
        if (builtinModulesAndFunctions == null) {
            // Add builtin modules
            PsiFile[] builtinModuleResults = FilenameIndex.getFilesByName(project, BUILT_IN_MODULES_FILENAME, GlobalSearchScope.everythingScope(project));
            builtinModulesAndFunctions = getModules(builtinModuleResults[0], null);
            // Add builtin functions
            PsiFile[] builtinFunctionResults = FilenameIndex.getFilesByName(project, BUILT_IN_FUNCTIONS_FILENAME, GlobalSearchScope.everythingScope(project));
            builtinModulesAndFunctions.addAll(getFunctions(builtinFunctionResults[0], null));
            builtinModulesAndFunctions.add(LookupElementBuilder.create(BUILT_IN_MISSING_FUNCTION).withIcon(OpenSCADIcons.FUNCTION));
        }
        return builtinModulesAndFunctions;
    }

    private List<LookupElement> getGlobalLibrariesModulesAndFunctions(final Project project) {
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
            final List<LookupElement> result = new ArrayList<>();
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
                    result.addAll(getModules(library, " from " + libraryRelPath));
                    result.addAll(getFunctions(library, " from " + libraryRelPath));
                }
            }

            globalLibrariesModulesAndFunctions = result;
        }
        return globalLibrariesModulesAndFunctions;
    }

    /**
     * Get edited file include and use declaration targets.
     *
     * @param element Current element.
     * @return List of completion elements.
     */
    private List<LookupElement> getLocalLibrariesModulesAndFunctions(final PsiElement element) {
        final Module module = ModuleUtil.findModuleForPsiElement(element);
        final List<LookupElement> imports = new ArrayList<>();

        // Loop through declarations
        final List<PsiElement> declarations = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADUseItem.class);
        declarations.addAll(PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADIncludeItem.class));
        for (PsiElement declaration : declarations) {
            // Get relative paths
            final String importPath = OpenSCADPsiImplUtil.getPresentation(declaration).getPresentableText();
            if (importPath == null) continue;

            // Get psi file
            final List<PsiFile> psiFiles;
            if (module != null) {
                psiFiles = OpenSCADResolver.findModuleContentFile(module, importPath);
            } else {
                psiFiles = OpenSCADResolver.findProjectLibrary(element.getProject(), importPath);
            }
            if (psiFiles.isEmpty()) continue;

            imports.addAll(getFunctions(psiFiles.get(0), " from " + importPath));
            imports.addAll(getModules(psiFiles.get(0), " from " + importPath));
        }

        return imports;
    }

    /**
     * Get accessible variables declarations for the current element.
     *
     * @param element Psi element.
     * @return List of variable declaration elements.
     */
    private List<LookupElement> getAccessibleVariables(final PsiElement element) {
        final List<OpenSCADVariableDeclaration> variableDeclarations = OpenSCADPsiImplUtil.getAccessibleVariableDeclaration(element);
        return convertToLookupElements(variableDeclarations, null);
    }

    /**
     * Get accessible variables declarations from parent argument list declarations, i.e. variables declared in function or module parameters.
     *
     * @param element Psi element.
     * @return List of argument declaration elements.
     */
    private List<LookupElement> getAccessibleArgumentDeclarations(PsiElement element) {

        // Parents with ARG_DECLARATION_LIST : modules and functions
        final List<PsiElement> parentsWithArgDeclarationList = OpenSCADPsiImplUtil.getParentsOfType(element, OpenSCADParserDefinition.WITH_ARG_DECLARATION_LIST);
        final List<OpenSCADArgDeclaration> argDeclarations = parentsWithArgDeclarationList.stream()
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADArgDeclarationList.class))
                .filter(Objects::nonNull)
                .flatMap(e -> PsiTreeUtil.getChildrenOfTypeAsList(e, OpenSCADArgDeclaration.class).stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        final List<LookupElement> lookupElements = new ArrayList<>(convertToLookupElements(argDeclarations, null));

        // Parents with FULL_ARG_DECLARATION_LIST : for loop
        final List<PsiElement> parentsWithFullArgDeclarationList = OpenSCADPsiImplUtil.getParentsOfType(element, OpenSCADParserDefinition.WITH_FULL_ARG_DECLARATION_LIST);
        final List<PsiElement> fullArgDeclarations = parentsWithFullArgDeclarationList.stream()
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADFullArgDeclarationList.class))
                .filter(Objects::nonNull)
                .map(e -> PsiTreeUtil.getChildOfType(e, OpenSCADFullArgDeclaration.class))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        lookupElements.addAll(convertToLookupElements(fullArgDeclarations, null));

        return lookupElements;
    }

    /**
     * Get module declarations.
     *
     * @param element Psi element.
     * @return List of modules.
     */
    private List<LookupElement> getModules(final PsiElement element, final String tailText) {
        final List<OpenSCADModuleDeclaration> moduleDeclarations = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADModuleDeclaration.class);
        return convertToLookupElements(moduleDeclarations, tailText);
    }

    /**
     * Get function declarations.
     *
     * @param element Psi element.
     * @return List of functions.
     */
    private List<LookupElement> getFunctions(final PsiElement element, final String tailText) {
        final List<OpenSCADFunctionDeclaration> functionDeclarations = PsiTreeUtil.getChildrenOfTypeAsList(element.getContainingFile(), OpenSCADFunctionDeclaration.class);
        return convertToLookupElements(functionDeclarations, tailText);
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
