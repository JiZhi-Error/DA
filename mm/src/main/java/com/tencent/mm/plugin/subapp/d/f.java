package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static String b(String str, long j2, boolean z) {
        AppMethodBeat.i(28962);
        String str2 = str + ":" + j2 + ":" + (z ? 1 : 0) + "\n";
        AppMethodBeat.o(28962);
        return str2;
    }
}
