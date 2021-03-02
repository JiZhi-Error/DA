package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public static String Yg(String str) {
        AppMethodBeat.i(159021);
        String replace = str.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("'", "&apos;");
        AppMethodBeat.o(159021);
        return replace;
    }
}
