package com.javampire.openscad.references;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OpenSCADResolver {

    public static List<PsiFile> findModuleContentFile(@NotNull Module module, @NotNull String fileRelativePath) {
        return findFilesByRelativePath(module.getProject(), module.getModuleContentScope(), fileRelativePath);
    }

    public static List<PsiFile> findModuleLibrary(@NotNull Module module, @NotNull String fileRelativePath) {
        return findFilesByRelativePath(module.getProject(), module.getModuleWithLibrariesScope(), fileRelativePath);
    }

    public static List<PsiFile> findProjectContentFile(@NotNull Project project, @NotNull String fileRelativePath) {
        return findFilesByRelativePath(project, ProjectScope.getContentScope(project), fileRelativePath);
    }

    public static List<PsiFile> findProjectLibrary(@NotNull Project project, @NotNull String fileRelativePath) {
        return findFilesByRelativePath(project, ProjectScope.getLibrariesScope(project), fileRelativePath);
    }

    public static List<PsiFile> findFilesByRelativePath(@NotNull Project project, @NotNull GlobalSearchScope scope, @NotNull String fileRelativePath) {
        String name = new File(fileRelativePath).getName();
        final PsiFile[] candidates = FilenameIndex.getFilesByName(project, name, scope);
        final List<PsiFile> fileList = new ArrayList<>();
        final String relativePath = fileRelativePath.startsWith("/") ? fileRelativePath : "/" + fileRelativePath;
        for (PsiFile f : candidates) {
            if (f.getVirtualFile().getPath().endsWith(relativePath)) {
                fileList.add(f);
            }
        }
        return fileList;
    }
}
