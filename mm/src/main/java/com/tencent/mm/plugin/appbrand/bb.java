package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;

public final class bb {

    public static class a extends s {
        public static final int CTRL_INDEX = -2;
        public static final String NAME = "onBottomBannerButtonClicked";
    }

    public static boolean r(q qVar) {
        AppMethodBeat.i(180181);
        if (qVar.bsC().launchMode == 1) {
            AppMethodBeat.o(180181);
            return true;
        }
        AppMethodBeat.o(180181);
        return false;
    }

    static void Uv(String str) {
        AppMethodBeat.i(180182);
        ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(str).Y(2, str);
        AppMethodBeat.o(180182);
    }
}
