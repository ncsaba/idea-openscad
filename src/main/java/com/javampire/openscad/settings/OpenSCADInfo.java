package com.javampire.openscad.settings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenSCADInfo {

    private final String infoString;

    private final Map<String, String> stringInfoMap = new HashMap<>();
    private final Map<String, List<String>> listInfoMap = new HashMap<>();
    private final List<String> infoLines = new ArrayList<>();

    public OpenSCADInfo(String infoString) {
        this.infoString = infoString;
        String listInfoName = null;
        List<String> valueList = null;
        Matcher matcher;
        final Pattern indentedLinePattern = Pattern.compile("^\\s+(.*)$");
        final Pattern oneLineInfoPattern = Pattern.compile("^([^(,):]+):\\s*([^\\s].*)$");
        final Pattern listInfoPattern = Pattern.compile("^([^(,):]+):$");
        for (String line : infoString.split("\\R")) {
            System.out.println("Line: " + line);
            if (valueList != null) {
                matcher = indentedLinePattern.matcher(line);
                if (matcher.matches()) {
                    valueList.add(matcher.group(1));
                    continue;
                }
                if (line.length() == 0) {
                    continue;
                }
                listInfoMap.put(listInfoName, valueList);
                listInfoName = null;
                valueList = null;
            }
            matcher = oneLineInfoPattern.matcher(line);
            if (matcher.matches()) {
                stringInfoMap.put(matcher.group(1), matcher.group(2));
                continue;
            }
            matcher = listInfoPattern.matcher(line);
            if (matcher.matches()) {
                listInfoName = matcher.group(1);
                valueList = new ArrayList<>();
                continue;
            }
            if (line.length() > 0) {
                infoLines.add(line);
            }
        }
    }

    public String getInfoString() {
        return infoString;
    }

    public List<String> getLibraryPaths() {
        return listInfoMap.get("OpenSCAD library path");
    }

    public String getOpenSCADVersion() {
        return stringInfoMap.get("OpenSCAD Version");
    }

    public String getStringInfo(String key) {
        return stringInfoMap.get(key);
    }

    public List<String> getListInfo(String key) {
        return listInfoMap.get(key);
    }

    public Set<String> getStringKeys() {
        return Collections.unmodifiableSet(stringInfoMap.keySet());
    }

    public Set<String> getListKeys() {
        return Collections.unmodifiableSet(listInfoMap.keySet());
    }

    public List<String> getInfoLines() {
        return Collections.unmodifiableList(infoLines);
    }

    public static void main(String[] args) {
        OpenSCADInfo oi = new OpenSCADInfo(
                "OpenSCAD Version: 2015.03-1\n" +
                        "System information: Linux 4.15.0-36-generic #39~16.04.1-Ubuntu SMP Tue Sep 25 08:59:23 UTC 2018 x86_64 Ubuntu 16.04.4 LTS 1 CPU 3.85 GB RAM\n" +
                        "Compiler: GCC \"5.2.1 20151028\" 64bit\n" +
                        "Boost version: 1_58\n" +
                        "Eigen version: 3.2.5\n" +
                        "CGAL version, kernels: 4.7, Cartesian<Gmpq>, Extended_cartesian<Gmpq>, Epeck\n" +
                        "OpenCSG version: OpenCSG 1.4.0\n" +
                        "Qt version: 5.5.1\n" +
                        "QScintilla version: 2.9.1\n" +
                        "MingW build: No\n" +
                        "GLib version: 2.47.1\n" +
                        "Application Path: /usr/bin\n" +
                        "Documents Path: /home/csaba/.local/share\n" +
                        "Resource Path: /usr/share/openscad\n" +
                        "User Library Path: /home/csaba/.local/share/OpenSCAD/libraries\n" +
                        "User Config Path:\n" +
                        "Backup Path: /home/csaba/.local/share/OpenSCAD/backups\n" +
                        "OPENSCADPATH: <not set>\n" +
                        "OpenSCAD library path:\n" +
                        "  /home/csaba/.local/share/OpenSCAD/libraries\n" +
                        "  /usr/share/openscad/libraries\n" +
                        "\n" +
                        "OPENSCAD_FONT_PATH: <not set>\n" +
                        "OpenSCAD font path:\n" +
                        "\n" +
                        "\n" +
                        "GLEW version: 1.13.0\n" +
                        "OpenGL Version: 3.0 Mesa 17.2.8\n" +
                        "GL Renderer: llvmpipe (LLVM 5.0, 256 bits)\n" +
                        "GL Vendor: VMware, Inc.\n" +
                        "RGBA(8888), depth(24), stencil(8)\n" +
                        "GL_ARB_framebuffer_object: yes\n" +
                        "GL_EXT_framebuffer_object: yes\n" +
                        "GL_EXT_packed_depth_stencil: yes\n" +
                        "GL context creator: GLX\n" +
                        "PNG generator: lodepng\n" +
                        "GLX version: 1.4\n" +
                        "OS info: Linux 4.15.0-36-generic #39~16.04.1-Ubuntu SMP Tue Sep 25 08:59:23 UTC 2018\n" +
                        "Machine: x86_64\n"
        );
        System.out.println("String info map: " + oi.stringInfoMap);
        System.out.println("List info map: " + oi.listInfoMap);
        System.out.println("Info lines: " + oi.infoLines);
        System.out.println("Library paths: " + oi.getLibraryPaths());
        System.out.println("OpenSCAD version: " + oi.getOpenSCADVersion());
    }
}
