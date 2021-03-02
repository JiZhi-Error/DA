package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.storage.ar;

public final class c {
    public static boolean bYQ() {
        AppMethodBeat.i(49292);
        if (bYT()) {
            AppMethodBeat.o(49292);
            return false;
        } else if (((b) g.af(b.class)).a(b.a.clicfg_app_brand_recommend_enter_switch, 0) > 0) {
            AppMethodBeat.o(49292);
            return true;
        } else {
            AppMethodBeat.o(49292);
            return false;
        }
    }

    public static boolean bYR() {
        AppMethodBeat.i(49293);
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, (Object) 0)).intValue() == 1) {
            AppMethodBeat.o(49293);
            return true;
        }
        AppMethodBeat.o(49293);
        return false;
    }

    public static boolean bYS() {
        AppMethodBeat.i(49294);
        if (bYT()) {
            AppMethodBeat.o(49294);
            return false;
        } else if (((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_recommend_use_fake_native, -1) == 1) {
            AppMethodBeat.o(49294);
            return true;
        } else {
            AppMethodBeat.o(49294);
            return false;
        }
    }

    private static boolean bYT() {
        AppMethodBeat.i(227735);
        if (!((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            AppMethodBeat.o(227735);
            return false;
        } else if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp() != 1) {
            AppMethodBeat.o(227735);
            return true;
        } else {
            AppMethodBeat.o(227735);
            return false;
        }
    }
}
