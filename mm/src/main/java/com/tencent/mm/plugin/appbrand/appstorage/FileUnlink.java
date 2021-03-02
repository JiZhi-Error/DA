package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;

public final class FileUnlink {
    public static native int unlink(String str);

    public static int Wg(String str) {
        AppMethodBeat.i(175574);
        int unlink = unlink(s.k(str, true));
        AppMethodBeat.o(175574);
        return unlink;
    }
}
