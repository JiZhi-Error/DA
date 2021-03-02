package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.am;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.mm.plugin.appbrand.jsapi.p.j;
import com.tencent.mm.plugin.appbrand.jsapi.p.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.s;

public enum bx {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(j.NAME),
    NAVIGATE_BACK(i.NAME),
    REDIRECT_TO(r.NAME),
    REWRITE_ROUTE(s.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB(am.NAME),
    DISMISS_PIP("dismissPip");
    
    private final String type;

    public static bx valueOf(String str) {
        AppMethodBeat.i(135282);
        bx bxVar = (bx) Enum.valueOf(bx.class, str);
        AppMethodBeat.o(135282);
        return bxVar;
    }

    static {
        AppMethodBeat.i(135283);
        AppMethodBeat.o(135283);
    }

    private bx(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
