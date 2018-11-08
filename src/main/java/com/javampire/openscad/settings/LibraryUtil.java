package com.javampire.openscad.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.CommonProcessors;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUtil {

    public static void createLibrary(@NotNull final Project project,
                                     final String libraryName,
                                     @NotNull final List<String> paths,
                                     final boolean isGlobal)
    {
        ModifiableModelsProvider modelsProvider = ModifiableModelsProvider.SERVICE.getInstance();

        ApplicationManager.getApplication().runWriteAction(() -> {
            // add all paths to library
            LibraryTable.ModifiableModel model = isGlobal ?
                    LibraryTablesRegistrar.getInstance().getLibraryTable().getModifiableModel() :
                    modelsProvider.getLibraryTableModifiableModel(project);

            Library library = model.getLibraryByName(libraryName);

            if (library == null) {
                library = model.createLibrary(libraryName);
            }

            fillLibrary(library, paths);
            model.commit();

            Library.ModifiableModel libModel = library.getModifiableModel();
            libModel.commit();

            // attach to modules if not yet present
            for (Module module : ModuleManager.getInstance(project).getModules()) {
                // https://intellij-support.jetbrains.com/hc/en-us/community/posts/115000160370-How-to-list-module-dependencies-
                List<Library> moduleLibraries = new ArrayList<>();
                OrderEnumerator.orderEntries(module).forEachLibrary(new CommonProcessors.CollectProcessor<>(moduleLibraries));

                if (moduleLibraries.stream().anyMatch(it -> Objects.equals(libraryName, it.getName()))) {
                    continue;
                }

                final ModifiableRootModel modifiableModel = modelsProvider.getModuleModifiableModel(module);

                modifiableModel.addLibraryEntry(library);
                modelsProvider.commitModuleModifiableModel(modifiableModel);
            }

        });
    }

    private static void fillLibrary(@NotNull final Library lib, @NotNull final List<String> paths) {
        Library.ModifiableModel modifiableModel = lib.getModifiableModel();
        for (String root : lib.getUrls(OrderRootType.CLASSES)) {
            modifiableModel.removeRoot(root, OrderRootType.CLASSES);
        }
        for (String dir : paths) {
            final VirtualFile pathEntry = LocalFileSystem.getInstance().findFileByPath(dir);
            if (pathEntry != null) {
                modifiableModel.addRoot(pathEntry, OrderRootType.CLASSES);
            } else {
                modifiableModel.addRoot("file://" + dir, OrderRootType.CLASSES);
            }
        }
        modifiableModel.commit();
    }

}
