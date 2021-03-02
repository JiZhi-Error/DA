package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c {
    private static j oBR;
    private static b oBS;
    public static final c oBT = new c();

    static {
        AppMethodBeat.i(229660);
        AppMethodBeat.o(229660);
    }

    private c() {
    }

    public final synchronized j ccP() {
        j jVar;
        ah ahVar;
        AppMethodBeat.i(229656);
        if (oBR == null && (ahVar = (ah) g.af(ah.class)) != null) {
            oBR = new j(ahVar);
        }
        jVar = oBR;
        AppMethodBeat.o(229656);
        return jVar;
    }

    public final synchronized b ccQ() {
        b bVar;
        ag agVar;
        AppMethodBeat.i(229657);
        if (oBS == null && (agVar = (ag) g.af(ag.class)) != null) {
            oBS = new b(agVar);
        }
        bVar = oBS;
        AppMethodBeat.o(229657);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a oBU = new a();

        static {
            AppMethodBeat.i(229655);
            AppMethodBeat.o(229655);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(229654);
            j ccP = c.oBT.ccP();
            if (ccP != null) {
                ccP.ccN();
            }
            b ccQ = c.oBT.ccQ();
            if (ccQ != null) {
                ccQ.ccN();
                AppMethodBeat.o(229654);
                return;
            }
            AppMethodBeat.o(229654);
        }
    }

    public static void ccR() {
        AppMethodBeat.i(229658);
        h.RTc.aY(a.oBU);
        AppMethodBeat.o(229658);
    }

    public static void release() {
        AppMethodBeat.i(229659);
        Log.i("MicroMsg.AppBrandDesktopDataHelper", "onAccountRelease");
        oBR = null;
        oBS = null;
        AppMethodBeat.o(229659);
    }
}
