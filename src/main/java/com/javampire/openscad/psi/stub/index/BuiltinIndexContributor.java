package com.javampire.openscad.psi.stub.index;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.IndexableSetContributor;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuiltinIndexContributor extends IndexableSetContributor {

    @NotNull
    @Override
    public Set<VirtualFile> getAdditionalRootsToIndex() {
        final HashSet<VirtualFile> result = new HashSet<>();
        final List<String> builtinFiles = Arrays.asList(
                "builtin_functions.scad",
                "builtin_modules.scad"
        );
        for (String fileName : builtinFiles) {
            final URL builtinFunctions = this.getClass().getResource(
                    "/com/javampire/openscad/skeletons/" + fileName
            );
            final VirtualFile builtinFunctionsFile = VfsUtil.findFileByURL(builtinFunctions);
            result.add(builtinFunctionsFile);
        }
        return result;
    }

}
