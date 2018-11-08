package com.javampire.openscad.settings;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessHandler;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OpenSCADSettingsUtil {

    public static final int MINUTE = 60 * 1000;

    private static List<String> getLibraryPaths() {
        final OpenSCADInfo openSCADInfo = getOpenSCADInfo();
        return openSCADInfo == null ? Collections.emptyList() : openSCADInfo.getLibraryPaths();
    }

    public static OpenSCADInfo getOpenSCADInfo() {
        // run the OpenSCAD executable and parse the returned info
        if (! OpenSCADSettings.hasExecutable()) {
            return null;
        }
        final String openSCADExecutable = OpenSCADSettings.getInstance().getOpenSCADExecutable();
        try {
            String infoString = new CapturingProcessHandler(
                new GeneralCommandLine(openSCADExecutable, "--info")
            ).runProcess(5 * MINUTE).getStdout().trim();

            if (!infoString.isEmpty()) {
                return new OpenSCADInfo(infoString);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final static String[] UNIX_EXECUTABLE_NAMES = {"OpenSCAD", "openscad"};

    private final static String[] WINDOWS_EXECUTABLE_NAMES = {"OpenSCAD.exe"};

    private final static List<String> MACOS_PATH_OPTIONS = Arrays.asList(
            "/Applications/MacPorts/OpenSCAD.app/Contents/MacOS",
            "/Applications/OpenSCAD.app/Contents/MacOS",
            "/usr/local/bin",
            "/usr/bin"
    );

    private final static List<String> LINUX_PATH_OPTIONS = Arrays.asList(
            "/usr/local/bin",
            "/usr/bin"
    );

    private final static List<String> WINDOWS_PATH_OPTIONS = Arrays.asList(
            "C:\\Program Files\\OpenSCAD",
            "\\Program Files\\OpenSCAD"
    );

    public static String suggestExecutablePath() {
        if (SystemInfo.isWindows) {
            // try first to detect if the executable is on the PATH
            final String path = System.getenv("PATH");
            String result = filterWindowsPathOptions(StringUtil.split(path, ";"));
            if (result != null) {
                return result;
            }
            // if not check common windows locations
            return filterWindowsPathOptions(WINDOWS_PATH_OPTIONS);
        }
        // try to detect from environment (i.e. PATH) on non-windows systems
        for (String executableName : UNIX_EXECUTABLE_NAMES) {
            try {
                String result = new CapturingProcessHandler(
                        new GeneralCommandLine("which", executableName)
                ).runProcess(5 * MINUTE).getStdout().trim();

                if (! result.isEmpty()) {
                    return result;
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // if not on PATH check common locations
        if (SystemInfo.isMac) {
            return filterUnixPathOptions(MACOS_PATH_OPTIONS);

        } else if (SystemInfo.isUnix) {
            return filterUnixPathOptions(LINUX_PATH_OPTIONS);
        }
        return null;
    }

    private static String filterWindowsPathOptions(List<String> pathOptions) {
        for (String pathEntry : pathOptions) {
            if (pathEntry.startsWith("\"") && pathEntry.endsWith("\"")) {
                if (pathEntry.length() < 2) continue;
                pathEntry = pathEntry.substring(1, pathEntry.length() - 1);
            }
            for (String executableName : WINDOWS_EXECUTABLE_NAMES) {
                File f = new File(pathEntry, executableName);
                if (f.exists()) {
                    try {
                        return f.getCanonicalPath();
                    } catch (IOException e) {
                        return f.getPath();
                    }
                }
            }
        }
        return null;
    }

    private static String filterUnixPathOptions(List<String> pathOptions) {
        for (String pathEntry : pathOptions) {
            for (String executableName : UNIX_EXECUTABLE_NAMES) {
                File f = new File(pathEntry, executableName);
                if (f.isFile() && f.canExecute()) {
                    try {
                        return f.getCanonicalPath();
                    } catch (IOException e) {
                        return f.getPath();
                    }
                }
            }
        }
        return null;
    }
}
