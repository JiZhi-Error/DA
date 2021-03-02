package com.tencent.mm.plugin.appbrand;

import android.os.Build;
import android.os.StatFs;
import android.system.ErrnoException;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.b.a.lq;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.m.ab;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class l {
    private static final IListener<d> kAj = new IListener<d>() {
        /* class com.tencent.mm.plugin.appbrand.l.AnonymousClass1 */

        {
            AppMethodBeat.i(160523);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(160523);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            AppMethodBeat.i(43795);
            if (dVar.dBP.dBQ) {
                n.c.interrupt();
                AppMethodBeat.o(43795);
            } else if (!g.aAc()) {
                AppMethodBeat.o(43795);
            } else {
                l.brc();
                AppMethodBeat.o(43795);
            }
            return false;
        }
    };

    static {
        AppMethodBeat.i(43798);
        AppMethodBeat.o(43798);
    }

    /* access modifiers changed from: package-private */
    public class a implements c, Runnable {
        private volatile boolean kAk = false;
        private final Runnable mRunnable;

        a(Runnable runnable) {
            AppMethodBeat.i(226131);
            this.mRunnable = runnable;
            com.tencent.mm.kernel.a.c.aAu().add(this);
            AppMethodBeat.o(226131);
        }

        @Override // com.tencent.mm.kernel.api.c
        public final void onAccountInitialized(e.c cVar) {
        }

        @Override // com.tencent.mm.kernel.api.c
        public final void onAccountRelease() {
            this.kAk = true;
        }

        public final void run() {
            AppMethodBeat.i(226132);
            try {
                this.mRunnable.run();
                AppMethodBeat.o(226132);
            } catch (Throwable th) {
                if (th instanceof ErrnoException) {
                    AppMethodBeat.o(226132);
                    return;
                }
                Log.printErrStackTrace("MicroMsg.AppBrandPruner", th, "caught exception while prune", new Object[0]);
                if (!g.aAf().hpY || this.kAk) {
                    AppMethodBeat.o(226132);
                } else {
                    AppMethodBeat.o(226132);
                    throw th;
                }
            }
        }
    }

    public static void brc() {
        AppMethodBeat.i(226134);
        h.RTc.b(new a(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.l.AnonymousClass2 */

            public final void run() {
                long blockSize;
                AppMethodBeat.i(226133);
                if (!g.aAf().hpY) {
                    AppMethodBeat.o(226133);
                    return;
                }
                long j2 = AppBrandGlobalSystemConfig.bzP().ldk.ldB;
                long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, (Object) 0L)).longValue();
                long nowSecond = Util.nowSecond();
                if (nowSecond >= longValue) {
                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(j2 + nowSecond));
                    ((bp) g.af(bp.class)).bvD();
                    n.c.bvr().run();
                    if (com.tencent.mm.plugin.appbrand.app.n.buy() == null) {
                        Log.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
                    } else {
                        lq lqVar = new lq();
                        StatFs statFs = new StatFs(az.bwm());
                        long blockCountLong = Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                        long bvq = n.b.bvq();
                        if (Build.VERSION.SDK_INT >= 18) {
                            blockSize = statFs.getBlockSizeLong();
                        } else {
                            blockSize = (long) statFs.getBlockSize();
                        }
                        lqVar.eZm = bvq;
                        lqVar.eZn = Math.round((((double) (bvq / blockSize)) / ((double) blockCountLong)) * 100.0d);
                        StatFs statFs2 = new StatFs(b.aKB());
                        lqVar.eZo = Math.round((((double) (Build.VERSION.SDK_INT >= 18 ? statFs2.getAvailableBlocksLong() : (long) statFs2.getAvailableBlocks())) / ((double) (Build.VERSION.SDK_INT >= 18 ? statFs2.getBlockCountLong() : (long) statFs2.getBlockCount()))) * 100.0d);
                        lqVar.eZp = 1;
                        lqVar.eZq = (long) n.e.bvx();
                        Log.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", lqVar.abW());
                        lqVar.bfK();
                    }
                    ab.bMJ();
                    ae.bMJ();
                    com.tencent.mm.plugin.appbrand.appstorage.g.kSf.run();
                    ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a) com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).bwV();
                    com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bSG();
                }
                AppMethodBeat.o(226133);
            }
        }), "MicroMsg.AppBrandPruner");
        AppMethodBeat.o(226134);
    }

    public static void setup() {
        AppMethodBeat.i(43796);
        kAj.alive();
        AppMethodBeat.o(43796);
    }

    public static void release() {
        AppMethodBeat.i(43797);
        kAj.dead();
        AppMethodBeat.o(43797);
    }
}
