package com.javampire.openscad.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class OpenSCADSettingsConfigurable implements SearchableConfigurable.Parent, Configurable.NoScroll {
    private final Project myProject;

    private JPanel settingsPanel;

    private TextFieldWithBrowseButton openSCADExecutableField;

    OpenSCADSettingsConfigurable(Project project) {
        myProject = project;
    }

    @NotNull
    @Override
    public String getId() {
        return getClass().getName();
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "OpenSCAD";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return settingsPanel;
    }

    @Override
    public boolean isModified() {
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        return !Objects.equals(openSCADSettings.getOpenSCADExecutable(), openSCADExecutableField.getText());
    }

    @Override
    public void apply() {
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        final String openSCADExecutable = openSCADExecutableField.getText();

        openSCADSettings.setOpenSCADExecutable(openSCADExecutable);

        LibraryUtil.updateOpenSCADLibraries(myProject);
    }

    @Override
    public void reset() {
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();

        final String openSCADExecutable = openSCADSettings.getOpenSCADExecutable();
        openSCADExecutableField.setText(openSCADExecutable != null ? openSCADExecutable : "");
    }

    @Override
    public void disposeUIResources() {
    }

    private void createUIComponents() {
        openSCADExecutableField = new TextFieldWithBrowseButton();

        final FileChooserDescriptor executableDescriptor = FileChooserDescriptorFactory.createSingleLocalFileDescriptor().withFileFilter(
                virtualFile -> virtualFile.isInLocalFileSystem() && new File(virtualFile.getPath()).canExecute()
        );
        openSCADExecutableField.addBrowseFolderListener(
                "Choose OpenSCAD Executable",
                "Choose OpenSCAD executable",
                myProject,
                executableDescriptor
        );
    }

    @NotNull
    @Override
    public Configurable[] getConfigurables() {
        return new Configurable[0];
    }


    @Override
    public boolean hasOwnContent() {
        return true;
    }
}
