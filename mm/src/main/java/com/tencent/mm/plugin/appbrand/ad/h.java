package com.tencent.mm.plugin.appbrand.ad;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.a.b;
import com.tencent.mm.plugin.appbrand.page.a.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.x;

public final class h implements j {
    public q kGW;
    public c kGX;
    public int kGY = 9;
    public MTimerHandler kGZ;
    private HandlerThread kHa;
    public i kHb;
    public long kHc;
    volatile boolean kHd = false;
    private volatile boolean kHe = false;
    volatile boolean kHf = false;

    public h(q qVar) {
        this.kGW = qVar;
    }

    /* access modifiers changed from: package-private */
    public final ac btP() {
        AppMethodBeat.i(226265);
        if (this.kGW.brK() instanceof ac) {
            ac acVar = (ac) this.kGW.brK();
            AppMethodBeat.o(226265);
            return acVar;
        }
        AppMethodBeat.o(226265);
        return null;
    }

    public final c btQ() {
        AppMethodBeat.i(226266);
        if (this.kGX != null) {
            c cVar = this.kGX;
            AppMethodBeat.o(226266);
            return cVar;
        } else if (this.kGW != null) {
            c bsE = this.kGW.bsE();
            AppMethodBeat.o(226266);
            return bsE;
        } else {
            AppMethodBeat.o(226266);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.j
    public final void btR() {
        AppMethodBeat.i(226267);
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, isSplashAdFinished:%s, isLoadingSplashFinished:%s", Boolean.valueOf(this.kHe), Boolean.valueOf(this.kHf));
        ac btP = btP();
        if (!(btP == null || btP.getInternalLoadingSplash() == null)) {
            btP.getInternalLoadingSplash().z(new a<x>() {
                /* class com.tencent.mm.plugin.appbrand.ad.h.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(226261);
                    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideLoadingSplashFromRuntime, LoadingSplash hide");
                    h.this.kHf = true;
                    h.this.btV();
                    AppMethodBeat.o(226261);
                    return null;
                }
            });
        }
        AppMethodBeat.o(226267);
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.j
    public final void btS() {
        AppMethodBeat.i(226268);
        b bVar = new b();
        bVar.source = "launch";
        bVar.type = "close";
        bVar.d(btQ());
        m(true, "launch");
        AppMethodBeat.o(226268);
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.j
    public final void UC(String str) {
        d dVar;
        AppMethodBeat.i(226269);
        if ("launch".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.appbrand.ad.a.d dVar2 = new com.tencent.mm.plugin.appbrand.ad.a.d();
            dVar2.source = str;
            dVar2.d(btQ());
            com.tencent.mm.plugin.appbrand.ad.a.c cVar = new com.tencent.mm.plugin.appbrand.ad.a.c();
            cVar.source = str;
            cVar.d(btQ());
            q qVar = this.kGW;
            Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, reset orientation", qVar.mAppId);
            if (!(qVar.brh() == null || qVar.brh().getPageView() == null || (dVar = (d) qVar.brh().getPageView().S(d.class)) == null)) {
                String MZ = dVar.MZ();
                Log.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientation[AppBrandSplashAd], appId:%s, request orientation:%s", qVar.mAppId, MZ);
                if (!Util.isNullOrNil(MZ)) {
                    dVar.a(null);
                }
            }
            btW();
            com.tencent.mm.plugin.appbrand.report.quality.b.K(this.kGW);
            Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onSplashAdViewContainerHide");
            this.kHe = true;
            btf();
            btV();
        }
        AppMethodBeat.o(226269);
    }

    public final void btT() {
        AppMethodBeat.i(226270);
        this.kHc = Util.nowMilliSecond();
        this.kHa = new HandlerThread("checkShowAdThread");
        this.kHa.start();
        this.kGZ = new MTimerHandler(this.kHa.getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.ad.h.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(226262);
                if (h.this.kHd) {
                    Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer, timer already stopped");
                    AppMethodBeat.o(226262);
                } else {
                    Log.e("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer timeOut, realTime:%s", Long.valueOf(Util.nowMilliSecond() - h.this.kHc));
                    h.this.btW();
                    h.this.btU();
                    h.this.btX();
                    AppMethodBeat.o(226262);
                }
                return false;
            }
        }, false);
        int bsK = q.bsK();
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", Integer.valueOf(bsK));
        this.kHd = false;
        this.kGZ.startTimer((long) bsK);
        AppMethodBeat.o(226270);
    }

    public final void m(final boolean z, final String str) {
        AppMethodBeat.i(226271);
        this.kGW.i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ad.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(226263);
                ac btP = h.this.btP();
                if (btP != null) {
                    btP.k(z, str);
                }
                AppMethodBeat.o(226263);
            }
        }, 0);
        AppMethodBeat.o(226271);
    }

    public final void btU() {
        AppMethodBeat.i(226272);
        ac btP = btP();
        if (btP != null) {
            btP.bWI();
        }
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "hideSplashAdImmediately");
        this.kHe = true;
        btf();
        btV();
        AppMethodBeat.o(226272);
    }

    private void btf() {
        AppMethodBeat.i(226273);
        if (btQ() != null) {
            Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "destroyServiceAdComponentView");
            btQ().btf();
        }
        AppMethodBeat.o(226273);
    }

    /* access modifiers changed from: package-private */
    public final void btV() {
        ac btP;
        AppMethodBeat.i(226274);
        Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, isSplashAdFinished:%s, isLoadingSplashFinished:%s", Boolean.valueOf(this.kHe), Boolean.valueOf(this.kHf));
        if (this.kHe && this.kHf && (btP = btP()) != null) {
            Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkAllFinished, remove AdLoadingSplash");
            btP.bWJ();
        }
        AppMethodBeat.o(226274);
    }

    public final void btW() {
        AppMethodBeat.i(226275);
        if (this.kHb != null) {
            this.kGW.S(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ad.h.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(226264);
                    if (h.this.kHb != null) {
                        h.this.kHb.KY();
                    }
                    AppMethodBeat.o(226264);
                }
            });
        }
        AppMethodBeat.o(226275);
    }

    public final void UD(String str) {
        AppMethodBeat.i(226276);
        if (this.kGZ != null) {
            Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "stopCheckShowAdTimeoutTick, appId:%s, reason:%s, realTime:%s", this.kGW.mAppId, str, Long.valueOf(Util.nowMilliSecond() - this.kHc));
            this.kHd = true;
            this.kGZ.stopTimer();
            this.kGZ = null;
        }
        btX();
        AppMethodBeat.o(226276);
    }

    /* access modifiers changed from: package-private */
    public final void btX() {
        AppMethodBeat.i(226277);
        if (this.kHa != null) {
            this.kHa.quitSafely();
            this.kHa = null;
        }
        AppMethodBeat.o(226277);
    }
}
