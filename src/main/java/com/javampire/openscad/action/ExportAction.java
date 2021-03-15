package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.fileChooser.FileChooserFactory;
import com.intellij.openapi.fileChooser.FileSaverDescriptor;
import com.intellij.openapi.fileChooser.FileSaverDialog;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ExportAction extends OpenSCADExecutableAction {

    private final String[] extensions = {"stl", "png", "svg"};

    @Override
    protected List<String> getArguments(@NotNull AnActionEvent event) {
        final VirtualFile sourceFile = event.getData(CommonDataKeys.VIRTUAL_FILE);
        if (sourceFile == null) {
            return null;
        }
        final String sourceFilePath = sourceFile.getPath();

        // Choose target file, to be generated
        final FileSaverDescriptor fileSaverDescriptor = new FileSaverDescriptor("Save File", "Choose destination file.", this.extensions);
        final FileSaverDialog dialog = FileChooserFactory.getInstance().createSaveFileDialog(fileSaverDescriptor, event.getProject());
        final VirtualFileWrapper vfw = dialog.save(sourceFile.getParent(), sourceFile.getNameWithoutExtension());
        if (vfw == null) {
            return null;
        }

        return Arrays.asList("-o", vfw.getVirtualFile(true).getPath(), sourceFilePath);
    }
}
