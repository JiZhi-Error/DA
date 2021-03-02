package com.tencent.mm.vfs;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.List;
import java.util.Map;

public interface k {
    FileSystem.b boT(String str);

    Pair<FileSystem.b, String> boU(String str);

    Map<String, FileSystem> hec();

    Map<String, String> hej();

    List<a> hek();

    public static class a {
        public final String Rdc;
        public final String basePath;

        a(String str, String str2) {
            this.basePath = str;
            this.Rdc = str2;
        }

        public String toString() {
            AppMethodBeat.i(187731);
            String str = this.basePath + " -> " + this.Rdc;
            AppMethodBeat.o(187731);
            return str;
        }
    }
}
