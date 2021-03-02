package com.tencent.mm.plugin.finder.report;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.n.n;

public final class af {
    public static final af viA = new af();
    private static final ConcurrentHashMap<String, a> viz = new ConcurrentHashMap<>();

    public static final class a {
        String mediaId = "";
        int tCE;
        String type = "";
        String url = "";
        String viB = "";
        long viC;
        long viD;
        long viE;
        long viF;
        long viG;
        boolean viH = true;
        boolean viI;
    }

    static {
        AppMethodBeat.i(250865);
        AppMethodBeat.o(250865);
    }

    private af() {
    }

    public static /* synthetic */ void j(String str, String str2, long j2) {
        AppMethodBeat.i(250849);
        a(str, str2, 1, j2, 0);
        AppMethodBeat.o(250849);
    }

    public static void a(String str, String str2, int i2, long j2, int i3) {
        AppMethodBeat.i(250848);
        p.h(str, "clickId");
        p.h(str2, ShareConstants.RESULT_POST_ID);
        dk dkVar = new dk();
        dkVar.oK(str);
        dkVar.oL(str2);
        dkVar.jG((long) i2);
        dkVar.jH(j2);
        dkVar.jI((long) i3);
        dkVar.bfK();
        k kVar = k.vfA;
        k.a(dkVar);
        AppMethodBeat.o(250848);
    }

    public static void a(String str, String str2, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(250850);
        p.h(str, "feedId");
        p.h(str2, "megaVideoId");
        fv fvVar = new fv();
        fvVar.sO(str);
        fvVar.sP(str2);
        fvVar.pz((long) i2);
        fvVar.pA((long) i3);
        fvVar.pB(j2);
        fvVar.pC((long) i4);
        fvVar.bfK();
        k kVar = k.vfA;
        k.a(fvVar);
        AppMethodBeat.o(250850);
    }

    public static void a(String str, String str2, int i2, int i3, String str3, String str4, String str5) {
        AppMethodBeat.i(250851);
        p.h(str, "feedId");
        p.h(str2, "megaVideoId");
        p.h(str3, "sessionId");
        p.h(str4, "contextId");
        p.h(str5, "clickTabContextId");
        fx fxVar = new fx();
        fxVar.sV(str);
        fxVar.sW(str2);
        fxVar.pG((long) i2);
        fxVar.pH((long) i3);
        fxVar.sX(str3);
        fxVar.sY(str4);
        fxVar.sZ(str5);
        fxVar.bfK();
        k kVar = k.vfA;
        k.a(fxVar);
        AppMethodBeat.o(250851);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j2, boolean z, long j3) {
        AppMethodBeat.i(250852);
        p.h(str, "feedId");
        p.h(str2, "megaVideoId");
        p.h(str3, "sessionId");
        p.h(str4, "contextId");
        p.h(str5, "clickTabContextId");
        fw fwVar = new fw();
        fwVar.sQ(str);
        fwVar.sR(str2);
        fwVar.sS(str3);
        fwVar.sT(str4);
        fwVar.sU(str5);
        fwVar.agH();
        fwVar.pD(j2);
        fwVar.pE(z ? 1 : 2);
        fwVar.pF(j3);
        fwVar.bfK();
        k kVar = k.vfA;
        k.a(fwVar);
        AppMethodBeat.o(250852);
    }

    public static void a(long j2, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(250853);
        p.h(str, "megaVideoId");
        p.h(str2, "miniSessionId");
        p.h(str3, "sessionId");
        p.h(str4, "contextId");
        p.h(str5, "clickTabContextId");
        p.h(str6, "feedId");
        fz fzVar = new fz();
        fzVar.tf(String.valueOf(j2));
        fzVar.pJ((long) i2);
        fzVar.agK();
        fzVar.tg(str2);
        fzVar.pK((long) i3);
        fzVar.th(str);
        fzVar.ti(str3);
        fzVar.tj(str4);
        fzVar.tk(str5);
        fzVar.tl(str6);
        fzVar.bfK();
        k kVar = k.vfA;
        k.a(fzVar);
        AppMethodBeat.o(250853);
    }

    public static void a(String str, int i2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(250854);
        p.h(str, "miniSessionId");
        p.h(str2, "megaVideoId");
        p.h(str3, "sessionId");
        p.h(str4, "contextId");
        p.h(str5, "clickTabContextId");
        fy fyVar = new fy();
        fyVar.agI();
        fyVar.agJ();
        fyVar.ta(str);
        fyVar.pI((long) i2);
        fyVar.tb(str2);
        fyVar.tc(str3);
        fyVar.td(str4);
        fyVar.te(str5);
        fyVar.bfK();
        k kVar = k.vfA;
        k.a(fyVar);
        AppMethodBeat.o(250854);
    }

    public static void p(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(250855);
        p.h(str, "feedId");
        p.h(str2, "sessionId");
        p.h(str3, "contextId");
        p.h(str4, "clickTabContextId");
        h.INSTANCE.a(21412, str, str2, str3, str4);
        AppMethodBeat.o(250855);
    }

    public static void dB(String str, int i2) {
        AppMethodBeat.i(250856);
        p.h(str, "mediaId");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(250856);
            return;
        }
        a aVar = new a();
        p.h(str, "<set-?>");
        aVar.mediaId = str;
        viz.put(str, aVar);
        aVar.viC = cl.aWA();
        aVar.tCE = i2;
        AppMethodBeat.o(250856);
    }

    public static void q(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(250857);
        p.h(str, "mediaId");
        p.h(str2, "type");
        p.h(str3, "url");
        p.h(str4, "urlToken");
        a aVar = viz.get(str);
        if (aVar != null) {
            if (!(aVar.viD == 0)) {
                aVar = null;
            }
            if (aVar != null) {
                aVar.viD = cl.aWA();
                p.h(str2, "<set-?>");
                aVar.type = str2;
                p.h(str3, "<set-?>");
                aVar.url = str3;
                p.h(str4, "<set-?>");
                aVar.viB = str4;
                AppMethodBeat.o(250857);
                return;
            }
        }
        AppMethodBeat.o(250857);
    }

    public static void auN(String str) {
        AppMethodBeat.i(250858);
        p.h(str, "mediaId");
        a aVar = viz.get(str);
        if (aVar != null) {
            aVar.viE = cl.aWA();
            AppMethodBeat.o(250858);
            return;
        }
        AppMethodBeat.o(250858);
    }

    public static void bp(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(250859);
        p.h(str, "mediaId");
        a aVar = viz.get(str);
        if (aVar != null) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.viH = z2;
            aVar.viG = cl.aWA();
            AppMethodBeat.o(250859);
            return;
        }
        AppMethodBeat.o(250859);
    }

    public static /* synthetic */ void auO(String str) {
        AppMethodBeat.i(250861);
        bq(str, false);
        AppMethodBeat.o(250861);
    }

    public static void bq(String str, boolean z) {
        a remove;
        AppMethodBeat.i(250860);
        p.h(str, "mediaId");
        a aVar = viz.get(str);
        if (aVar != null) {
            if (!(aVar.viF == 0)) {
                aVar = null;
            }
            if (aVar != null) {
                if (z) {
                    aVar.viI = true;
                } else {
                    aVar.viF = cl.aWA();
                }
            }
        }
        if (z || (remove = viz.remove(str)) == null) {
            AppMethodBeat.o(250860);
            return;
        }
        p.g(remove, "this");
        a(remove, false);
        AppMethodBeat.o(250860);
    }

    public static void doU() {
        AppMethodBeat.i(250862);
        for (Map.Entry<String, a> entry : viz.entrySet()) {
            if (!entry.getValue().viI) {
                a(entry.getValue(), true);
            }
        }
        viz.clear();
        AppMethodBeat.o(250862);
    }

    private static void a(a aVar, boolean z) {
        AppMethodBeat.i(250863);
        cg cgVar = new cg();
        cgVar.adb();
        cgVar.fS(3);
        String iVar = b(aVar, z).toString();
        p.g(iVar, "buildJson(data, isExit).toString()");
        cgVar.lH(n.j(iVar, ",", ";", false));
        cgVar.bfK();
        Log.i("MegaVideoReporter", "report21680 info:" + cgVar.abW());
        AppMethodBeat.o(250863);
    }

    private static i b(a aVar, boolean z) {
        long j2;
        long j3;
        long j4;
        AppMethodBeat.i(250864);
        if (!z || aVar.viF != 0) {
            j2 = aVar.viF - aVar.viC;
        } else {
            j2 = cl.aWA() - aVar.viC;
        }
        long j5 = aVar.viD > 0 ? aVar.viD - aVar.viC : 0;
        if (aVar.viD <= 0 || aVar.viG <= aVar.viD) {
            j3 = 0;
        } else {
            j3 = aVar.viG - aVar.viD;
        }
        if (!z || aVar.viF != 0) {
            j4 = aVar.viF - aVar.viD;
        } else {
            j4 = cl.aWA() - aVar.viD;
        }
        long max = aVar.viE > 0 ? Math.max(aVar.viF - aVar.viE, 0L) : 0;
        i iVar = new i();
        iVar.U("commentScene", aVar.tCE);
        iVar.v("totalTime", j2);
        iVar.w("isExit", z);
        iVar.v("enterToViewInit", j5);
        iVar.w("isMoovReadyBeforeEnter", aVar.viH);
        iVar.v("viewInitToMoovDownloaded", j3);
        iVar.v("viewInitToFirstFrame", Math.max(j4, 0L));
        iVar.v("seekToFirstFrame", max);
        iVar.h("mediaId", aVar.mediaId);
        iVar.h("type", aVar.type);
        iVar.h("url", aVar.url);
        iVar.h("urlToken", aVar.viB);
        AppMethodBeat.o(250864);
        return iVar;
    }
}
