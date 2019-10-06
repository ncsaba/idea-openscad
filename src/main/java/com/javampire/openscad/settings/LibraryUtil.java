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
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.CommonProcessors;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUtil implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        final OpenSCADSettings settings = OpenSCADSettings.getInstance();
        if (settings.openSCADExecutable == null) {
            final String suggestedExecutablePath = OpenSCADSettingsUtil.suggestExecutablePath();
            if (suggestedExecutablePath == null) {
                // warn user
                DialogBuilder db = new DialogBuilder();
                db.setTitle("Could not find the OpenSCAD executable");
                db.setCenterPanel(new JLabel("No OpenSCAD executable defined. You can set one under Settings -> Languages & Frameworks -> OpenSCAD Language"));
                db.addOkAction();
                db.show();
            } else {
                settings.setOpenSCADExecutable(suggestedExecutablePath);
                updateOpenSCADLibraries(project);
            }
        }
    }

    public static void updateOpenSCADLibraries(Project project) {
        final OpenSCADInfo info = OpenSCADSettingsUtil.getOpenSCADInfo();
        if (info != null) {
            final List<String> libraryPaths = info.getLibraryPaths();
            if (! libraryPaths.isEmpty()) {
                createLibrary(project, "OpenSCAD Libraries", libraryPaths, true);
            }
        }
    }

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
