package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af {
    public static boolean p(q qVar) {
        AppMethodBeat.i(226245);
        if (qVar == null || !qVar.NA() || qVar.bsC().kHw == null || !qVar.bsC().kHw.startsWith("__wx__")) {
            AppMethodBeat.o(226245);
            return false;
        }
        AppMethodBeat.o(226245);
        return true;
    }

    public static boolean Ut(String str) {
        AppMethodBeat.i(226246);
        if (str == null || !str.startsWith("__wx__")) {
            AppMethodBeat.o(226246);
            return false;
        }
        AppMethodBeat.o(226246);
        return true;
    }
}
