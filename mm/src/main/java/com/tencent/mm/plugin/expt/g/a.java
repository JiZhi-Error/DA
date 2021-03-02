package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static boolean cRq() {
        AppMethodBeat.i(122354);
        c.cSa();
        if (Util.getInt(c.c(b.a.clicfg_weixin_rpt_mm_app_mgr, ""), 0) > 0) {
            AppMethodBeat.o(122354);
            return true;
        }
        AppMethodBeat.o(122354);
        return false;
    }

    public static boolean cRr() {
        AppMethodBeat.i(122355);
        c.cSa();
        if (Util.getInt(c.c(b.a.clicfg_weixin_rpt_mm_life_call, ""), 0) > 0) {
            AppMethodBeat.o(122355);
            return true;
        }
        AppMethodBeat.o(122355);
        return false;
    }

    public static boolean cRs() {
        AppMethodBeat.i(122356);
        c.cSa();
        if (Util.getInt(c.c(b.a.clicfg_weixin_rpt_mm_hell_hound, ""), 0) > 0) {
            AppMethodBeat.o(122356);
            return true;
        }
        AppMethodBeat.o(122356);
        return false;
    }

    public static int b(b.a aVar) {
        AppMethodBeat.i(122357);
        c.cSa();
        int i2 = Util.getInt(c.c(aVar, ""), 0);
        AppMethodBeat.o(122357);
        return i2;
    }
}
