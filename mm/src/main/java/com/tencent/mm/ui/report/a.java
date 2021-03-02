package com.tencent.mm.ui.report;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\nH\u0007J\b\u0010\u0013\u001a\u00020\nH\u0007J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0007J\b\u0010\u0016\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/ui/report/FindMoreFriendsReporter;", "", "()V", "TAG", "", "contextId", "discoverNearbyDotExpose", "", "getContextId", "report20411", "", NativeProtocol.WEB_DIALOG_ACTION, "", "showInfoCount", "", "redDotShowInfoType", "reportDiscoverNearbyDotClick", "reportDiscoverNearbyDotExpose", "reportDiscoverNearbyNewDotClick", "reportDiscoverNearbyNewDotExpose", "reportNearByLiveFriends", "reportNearByLiveFriendsClick", "reportNearByLiveFriendsExpose", "app_release"})
public final class a {
    private static boolean QnJ;
    public static final a QnK = new a();
    private static String sGQ = "";

    static {
        AppMethodBeat.i(231380);
        AppMethodBeat.o(231380);
    }

    private a() {
    }

    public static final void gWZ() {
        AppMethodBeat.i(231373);
        sGQ = "";
        NY(1);
        AppMethodBeat.o(231373);
    }

    public static final void gXa() {
        AppMethodBeat.i(231374);
        NY(2);
        AppMethodBeat.o(231374);
    }

    private static void NY(long j2) {
        AppMethodBeat.i(231375);
        ak akVar = new ak();
        akVar.cb(cl.aWA());
        akVar.cc(j2);
        akVar.ir(acj());
        akVar.iq(Util.nullAsNil(((c) g.af(c.class)).cMD()));
        akVar.bfK();
        Log.d("FindMoreFriendsReporter", "report " + akVar.abW());
        AppMethodBeat.o(231375);
    }

    public static final void NZ(long j2) {
        long j3;
        long j4 = 1;
        AppMethodBeat.i(231376);
        sGQ = "";
        if (j2 != 0) {
            j3 = 2;
        } else {
            j3 = 1;
        }
        dt dtVar = new dt();
        dtVar.pN("1");
        dtVar.pQ(Util.nullAsNil(((c) g.af(c.class)).cMD()));
        dtVar.pO(acj());
        dtVar.kA(1011);
        dtVar.pI("FinderLocal_" + ((((float) cl.aWA()) * 1.0f) / 100000.0f));
        dtVar.pJ("NearbyEntrance");
        dtVar.pK("Discovery");
        dtVar.kB(j3);
        dtVar.kC(j2);
        dtVar.pL("");
        dtVar.pM("");
        dtVar.kD(1);
        dtVar.pP("1011-" + cl.aWA());
        dtVar.kE(1);
        dtVar.kF(1);
        dtVar.kG(1);
        dtVar.afg();
        dtVar.kH(cl.aWA() / 1000);
        dtVar.pR("");
        dtVar.kI(1);
        y yVar = y.vXH;
        if (!y.dCB()) {
            j4 = 2;
        }
        dtVar.kJ(j4);
        dtVar.bfK();
        Log.d("FindMoreFriendsReporter", "report " + dtVar.abW());
        QnJ = true;
        AppMethodBeat.o(231376);
    }

    public static final void gXb() {
        sGQ = "";
        QnJ = true;
    }

    public static final String acj() {
        AppMethodBeat.i(231379);
        if (TextUtils.isEmpty(sGQ)) {
            com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
            p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(12, 1, ((aj) ah).getFinderUtilApi().dli(), new Intent());
            p.g(fillContextIdToIntent, "MMKernel.plugin(IPluginF…, commentScene, Intent())");
            sGQ = fillContextIdToIntent;
        }
        String str = sGQ;
        AppMethodBeat.o(231379);
        return str;
    }
}
