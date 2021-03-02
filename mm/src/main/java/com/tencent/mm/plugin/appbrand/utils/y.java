package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y {
    public static String afI(String str) {
        AppMethodBeat.i(140859);
        if (str == null) {
            AppMethodBeat.o(140859);
            return null;
        }
        String replace = str.replace(" ", "\\n").replace(" ", "\\n");
        AppMethodBeat.o(140859);
        return replace;
    }
}
