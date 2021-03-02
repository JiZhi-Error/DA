package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends s {
    private static final int CTRL_INDEX = 633;
    private static final String NAME = "onCustomRightButtonClick";

    public static void h(ac acVar) {
        AppMethodBeat.i(135321);
        Log.i("OnCustomRightButtonClickEvent", "OnCustomRightButtonClickEvent dispatch");
        new d().g(acVar.NY()).bEo();
        AppMethodBeat.o(135321);
    }
}
