package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;

public final class r extends s {
    private static final int CTRL_INDEX = 156;
    private static final String NAME = "onTapStatusBar";
    private static r noH = new r();

    static {
        AppMethodBeat.i(135003);
        AppMethodBeat.o(135003);
    }

    public static void h(ac acVar) {
        AppMethodBeat.i(135002);
        noH.g(acVar).bEo();
        AppMethodBeat.o(135002);
    }
}
