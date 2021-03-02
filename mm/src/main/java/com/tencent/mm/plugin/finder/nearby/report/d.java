package com.tencent.mm.plugin.finder.nearby.report;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J0\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\u0012J\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyTabLifecycleReporter;", "", "()V", "CLICK_TAB_CONTEXT_LIVE", "", "CLICK_TAB_CONTEXT_LIVE_MORE", "CLICK_TAB_CONTEXT_PERSON", "CLICK_TAB_CONTEXT_VIDEO", "TAG", "contextId", "kotlin.jvm.PlatformType", "currentClickTabContextID", "enterClickTabContextID", "enterNearbyTabMs", "", "lastSwitchClickTabContextID", "lastSwitchTabMs", "enterNearbyTab", "", "exitNearbyTab", "getContextId", "getCurrentClickTabContextID", "getEnterClickTabContextID", "getLastSwitchClickTabContextID", "report", "pageName", "enterTimeMs", "exitTimeMs", "clickTabContextId", "reportType", "resetSwitchTabTime", "switchInNearbyTab", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "switchOutNearbyTab", "plugin-finder_release"})
public final class d {
    private static String sGQ = ((aj) g.ah(aj.class)).fillContextIdToIntent(12, 1, 76, new Intent());
    private static long uTl = cl.aWA();
    private static String uTm = "";
    private static long uTn = cl.aWA();
    private static String uTo = "";
    private static String uTp = "1001";
    public static final d uTq = new d();

    static {
        AppMethodBeat.i(249356);
        AppMethodBeat.o(249356);
    }

    private d() {
    }

    public static String acj() {
        AppMethodBeat.i(249349);
        String str = sGQ;
        p.g(str, "contextId");
        AppMethodBeat.o(249349);
        return str;
    }

    public static String dlz() {
        return uTo;
    }

    public static String dlA() {
        return uTp;
    }

    public static void gO(String str, String str2) {
        AppMethodBeat.i(249350);
        p.h(str, "contextId");
        p.h(str2, "enterClickTabContextID");
        sGQ = str;
        uTm = str2;
        long aWA = cl.aWA();
        uTl = aWA;
        uTn = aWA;
        AppMethodBeat.o(249350);
    }

    public static void dlB() {
        AppMethodBeat.i(249351);
        uTn = cl.aWA();
        AppMethodBeat.o(249351);
    }

    public static void b(AbsNearByFragment absNearByFragment) {
        AppMethodBeat.i(249352);
        uTp = (absNearByFragment != null ? absNearByFragment.ack() : "") + "-" + cl.aWA();
        AppMethodBeat.o(249352);
    }

    public static void c(AbsNearByFragment absNearByFragment) {
        String str;
        AppMethodBeat.i(249353);
        if (absNearByFragment == null || (str = absNearByFragment.afB()) == null) {
            str = "";
        }
        String ack = absNearByFragment != null ? absNearByFragment.ack() : "";
        long aWA = cl.aWA();
        String str2 = ack + "-" + cl.aWA();
        b.aoW(sGQ);
        b.aoV(str2);
        a(str, uTn, aWA, str2, 0);
        uTo = str2;
        uTn = aWA;
        AppMethodBeat.o(249353);
    }

    public static void dlC() {
        AppMethodBeat.i(249354);
        a("all", uTl, cl.aWA(), uTp, 1);
        AppMethodBeat.o(249354);
    }

    private static void a(String str, long j2, long j3, String str2, long j4) {
        AppMethodBeat.i(249355);
        gl glVar = new gl();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        glVar.uf(cMD);
        glVar.ug(str);
        long j5 = j3 - j2;
        if (j5 <= 0) {
            j5 = 0;
        }
        glVar.qp(j5);
        glVar.qq(j2);
        glVar.qr(j3);
        glVar.uh(str2);
        glVar.ui("");
        glVar.qs(j4);
        glVar.uj(sGQ);
        Log.i("NearbyTabLifecycleReporter", "report " + glVar.abW());
        glVar.bfK();
        AppMethodBeat.o(249355);
    }
}
