package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.Messages;
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
        super((String) null, (String) null, icon);
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
        // Check arguments
        final List<String> arguments = getArguments(event);
        if (arguments == null) {
            return;
        }

        // Check configuration
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        if (openSCADSettings == null || openSCADSettings.getOpenSCADExecutable() == null) {
            Messages.showErrorDialog("Can not find OpenSCAD executable path. Please configure it in Settings -> Languages & Frameworks -> OpenSCAD Language and retry.", "OpenSCAD executable not set");
            return;
        }

        // Create full command
        final List<String> command = new ArrayList<>();
        command.add(openSCADSettings.getOpenSCADExecutable());
        command.addAll(arguments);

        ApplicationManager.getApplication().executeOnPooledThread(() -> {
            StringBuilder stderr = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(command);
            try {
                Process process = processBuilder.start();
                BufferedReader stdErrorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line;
                while ((line = stdErrorBufferReader.readLine()) != null) {
                    stderr.append(line + "\n");
                }
                int returnCode = process.waitFor();
                if (returnCode != 0) {
                    LOG.error("Execution of " + command.toString() + " failed. Return code:" + returnCode + ". Stderr:\n" + stderr.toString());
                    ApplicationManager.getApplication().invokeLater(() -> Messages.showErrorDialog("Execution of " + command.toString() + " failed with error " + returnCode + " :\n" + stderr.toString(), "OpenSCAD Execution Error"));
                }
            } catch (IOException | InterruptedException e) {
                LOG.error("Execution of " + command.toString() + " failed.", e);
                ApplicationManager.getApplication().invokeLater(() -> Messages.showErrorDialog("Execution of " + command.toString() + " failed: \n" + ExceptionUtils.getFullStackTrace(e) + "\nYou can report an issue with this message in the GitHub repository of this plugin.", "OpenSCAD Execution Exception."));
            }
        });
    }

    /**
     * Arguments specific to an action.
     * If null, no command will be executed.
     *
     * @param event Event.
     * @return Arguments.
     */
    abstract protected List<String> getArguments(@NotNull AnActionEvent event);
}
