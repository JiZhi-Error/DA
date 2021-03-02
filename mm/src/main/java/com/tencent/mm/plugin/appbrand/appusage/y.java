package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.TimeUnit;

public final class y extends c<buw> {
    private static final long kVD = TimeUnit.MINUTES.toSeconds(5);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, buw buw, q qVar) {
        AppMethodBeat.i(44637);
        buw buw2 = buw;
        super.a(i2, i3, str, buw2, qVar);
        e NL = n.NL();
        com.tencent.mm.plugin.appbrand.ab.a buP = n.buP();
        if (NL == null || buP == null) {
            Log.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", NL, buP);
            AppMethodBeat.o(44637);
            return;
        }
        NL.cN("GetSearchShowOutWxaApp_interval", String.valueOf((i2 == 0 && i3 == 0 && buw2 != null) ? (long) buw2.Mbm : kVD));
        if (i2 == 0 && i3 == 0 && buw2 != null) {
            try {
                buP.l("GetSearchShowOutWxaApp_resp", buw2.toByteArray());
                AppMethodBeat.o(44637);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", e2);
            }
        }
        AppMethodBeat.o(44637);
    }

    public enum a {
        DAILY,
        SEARCH;

        public static a valueOf(String str) {
            AppMethodBeat.i(44633);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44633);
            return aVar;
        }

        static {
            AppMethodBeat.i(44634);
            AppMethodBeat.o(44634);
        }
    }

    public static void bys() {
        AppMethodBeat.i(44635);
        if (!g.aAf().hpY) {
            AppMethodBeat.o(44635);
            return;
        }
        g.af(l.class);
        AppMethodBeat.o(44635);
    }

    static {
        AppMethodBeat.i(44638);
        AppMethodBeat.o(44638);
    }
}
