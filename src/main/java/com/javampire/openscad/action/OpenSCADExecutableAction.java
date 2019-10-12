package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.psi.PsiFile;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.settings.OpenSCADSettings;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class OpenSCADExecutableAction extends AnAction {

    private static Logger LOG = Logger.getInstance("#com.javampire.openscad.action.OpenSCADExecutableAction");

    public OpenSCADExecutableAction() {
        super();
    }

    public OpenSCADExecutableAction(Icon icon) {
        super(null, null, icon);
    }

    public OpenSCADExecutableAction(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text) {
        super(text, null, null);
    }

    public OpenSCADExecutableAction(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, @Nullable @Nls(capitalization = Nls.Capitalization.Sentence) String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        if (ActionPlaces.isPopupPlace(event.getPlace())) {
            PsiFile psiFile = event.getData(CommonDataKeys.PSI_FILE);
            event.getPresentation().setEnabledAndVisible(psiFile.getLanguage().isKindOf(OpenSCADLanguage.INSTANCE));
        }
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {

        // Check configuration
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        if (openSCADSettings == null || openSCADSettings.openSCADExecutable == null) {
            Messages.showErrorDialog("Can not find OpenSCAD executable path. Please configure it in Settings -> Languages & Frameworks -> OpenSCAD Language and retry.", "OpenSCAD executable not set");
            return;
        }

        // Create external command
        List<String> commandWrapper = new ArrayList<>();
        if (SystemInfo.isWindows) {
            commandWrapper.add("cmd.exe");
            commandWrapper.add("/c");
        } else {
            commandWrapper.add("bash");
            commandWrapper.add("-c");
        }
        commandWrapper.add("\"" + openSCADSettings.openSCADExecutable + "\" " + getArguments(event));

        ApplicationManager.getApplication().executeOnPooledThread(() -> {
            StringBuilder stderr = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(commandWrapper);
            try {
                Process process = processBuilder.start();
                BufferedReader stdErrorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line;
                while ((line = stdErrorBufferReader.readLine()) != null) {
                    stderr.append(line + "\n");
                }
                int returnCode = process.waitFor();
                if (returnCode != 0) {
                    LOG.error("Execution of " + commandWrapper.toString() + " failed. Return code:" + returnCode + ". Stderr:\n" + stderr.toString());
                    ApplicationManager.getApplication().invokeLater(() -> Messages.showErrorDialog("Execution of " + commandWrapper.toString() + " failed:\n" + stderr.toString(), "OpenSCAD return code " + returnCode));
                }
            } catch (IOException | InterruptedException e) {
                LOG.error("Execution of " + commandWrapper.toString() + " failed.", e);
                ApplicationManager.getApplication().invokeLater(() -> Messages.showErrorDialog("Execution of " + commandWrapper.toString() + " failed: \n" + ExceptionUtils.getFullStackTrace(e) + "\nYou can report an issue with this message in the GitHub repository of this plugin.", "OpenSCAD execution triggered an internal exception."));
            }
        });
    }

    abstract protected String getArguments(@NotNull AnActionEvent event);
}
