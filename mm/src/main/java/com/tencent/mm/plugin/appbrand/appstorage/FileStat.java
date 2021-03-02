package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;

public class FileStat {
    public static native int stat(String str, FileStructStat fileStructStat);

    public static int b(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(175567);
        int stat = stat(s.k(str, false), fileStructStat);
        AppMethodBeat.o(175567);
        return stat;
    }
}
