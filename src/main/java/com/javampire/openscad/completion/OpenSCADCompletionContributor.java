package com.javampire.openscad.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.PlatformIcons;
import com.intellij.util.ProcessingContext;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class OpenSCADCompletionContributor extends CompletionContributor {

    private static final String BUILT_IN_MISSING_FUNCTION = "select";

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

                        // Add builtin modules and functions
                        result.addAllElements(getBuiltinModules(project));
                        result.addAllElements(getBuiltinFunctions(project));

                        // Add libraries modules and functions
                        result.addAllElements(getLibrariesModulesAndFunctions(project));

                        // Add all accessible variables
                        result.addAllElements(getAccessibleVariables(elementPosition));

                        // Add custom modules
                        result.addAllElements(getModules(elementPosition));

                        // Add custom functions
                        result.addAllElements(getFunctions(elementPosition));

                        // Add missing builtin function
                        result.addElement(LookupElementBuilder.create(BUILT_IN_MISSING_FUNCTION).withIcon(OpenSCADIcons.FUNCTION));
                    }
                }
        );
    }

    public List<LookupElement> getBuiltinModules(Project project) {
        PsiFile[] builtinModuleResults = FilenameIndex.getFilesByName(project, "builtin_modules.scad", GlobalSearchScope.everythingScope(project));
        return getModules(builtinModuleResults[0]);
    }

    public List<LookupElement> getBuiltinFunctions(Project project) {
        PsiFile[] builtinModuleResults = FilenameIndex.getFilesByName(project, "builtin_functions.scad", GlobalSearchScope.everythingScope(project));
        return getFunctions(builtinModuleResults[0]);
    }

    public List<LookupElement> getLibrariesModulesAndFunctions(Project project) {
        PsiManager psiManager = PsiManager.getInstance(project);
        ModifiableModelsProvider modelsProvider = ModifiableModelsProvider.SERVICE.getInstance();
        Library[] libraries = modelsProvider.getLibraryTableModifiableModel().getLibraries();

        return Arrays.stream(libraries)
                .map(library -> library.getFiles(OrderRootType.CLASSES))
                .flatMap(Arrays::stream)
                .map(VfsUtil::collectChildrenRecursively)
                .flatMap(List::stream)
                .map(psiManager::findFile)
                .filter(psiFile -> psiFile != null && psiFile.getFileType() == OpenSCADFileType.INSTANCE && psiFile.isValid())
                .map(openSCADPsiFile -> {
                    List<LookupElement> list = getModules(openSCADPsiFile);
                    list.addAll(getFunctions(openSCADPsiFile));
                    return list;
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * Get accessible variables declarations for the current element.
     *
     * @param element Psi element.
     * @return List of variable declaration element.
     */
    private List<LookupElement> getAccessibleVariables(PsiElement element) {
        final List<OpenSCADVariableDeclaration> variableDeclarations = OpenSCADPsiImplUtil.getAccessibleVariableDeclaration(element);
        return variableDeclarations.stream()
                .filter(var -> var.getNameIdentifier() != null)
                .map(var -> LookupElementBuilder.create(var.getNameIdentifier().getText()).withIcon(PlatformIcons.VARIABLE_ICON))
                .collect(Collectors.toList());
    }

    /**
     * Get module declarations.
     *
     * @param element Psi element.
     * @return List of modules.
     */
    private List<LookupElement> getModules(PsiElement element) {
        final List<OpenSCADModuleDeclaration> moduleDeclarations = OpenSCADPsiImplUtil.getModuleDeclarations(element);
        return moduleDeclarations.stream()
                .filter(mod -> mod.getNameIdentifier() != null)
                .map(mod -> LookupElementBuilder.create(mod.getNameIdentifier().getText()).withIcon(OpenSCADIcons.MODULE))
                .collect(Collectors.toList());
    }

    /**
     * Get function declarations.
     *
     * @param element Psi element.
     * @return List of functions.
     */
    private List<LookupElement> getFunctions(PsiElement element) {
        final List<OpenSCADFunctionDeclaration> functionDeclarations = OpenSCADPsiImplUtil.getFunctionDeclarations(element);
        return functionDeclarations.stream()
                .filter(fund -> fund.getNameIdentifier() != null)
                .map(func -> LookupElementBuilder.create(func.getNameIdentifier().getText()).withIcon(OpenSCADIcons.FUNCTION))
                .collect(Collectors.toList());
    }
}
