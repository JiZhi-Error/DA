package com.tencent.mm.plugin.appbrand.performance;

import android.os.Build;
import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.luggage.game.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.c;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends AppBrandPerformanceManager {

    public enum a {
        INST;
        
        private volatile HandlerThread mThread;

        public static a valueOf(String str) {
            AppMethodBeat.i(227351);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(227351);
            return aVar;
        }

        static {
            AppMethodBeat.i(227353);
            AppMethodBeat.o(227353);
        }

        public final HandlerThread bSR() {
            AppMethodBeat.i(227352);
            if (this.mThread == null) {
                synchronized (this) {
                    try {
                        if (this.mThread == null) {
                            this.mThread = d.bqr("MicroMsg.AppBrandPerformanceManager.DumpTraceThread");
                            this.mThread.start();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(227352);
                        throw th;
                    }
                }
            }
            HandlerThread handlerThread = this.mThread;
            AppMethodBeat.o(227352);
            return handlerThread;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.performance.b$b  reason: collision with other inner class name */
    public static class C0778b extends AppBrandPerformanceManager.a {
        C0778b(q qVar) {
            super(qVar);
            AppMethodBeat.i(47978);
            this.nwF = qVar.NA();
            AppMethodBeat.o(47978);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSK() {
            AppMethodBeat.i(47979);
            super.bSK();
            if (this.nwF) {
                h hVar = h.INST;
                h.a Md = h.Md();
                c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", (double) Md.cvE);
                if (Build.VERSION.SDK_INT >= 23) {
                    AppBrandPerformanceManager.a(this.cBE, 105, Md.cvN);
                    c.a(this.mAppId, "Hardware", "SYSTEM_MEMORY", (double) Md.cvH);
                    c.a(this.mAppId, "Hardware", "TOTAL_SWAP_MEMORY", (double) Md.cvI);
                    c.a(this.mAppId, "Hardware", "JAVA_HEAP_MEMORY", (double) Md.cvJ);
                    c.a(this.mAppId, "Hardware", "PRIVATE_OTHER_MEMORY", (double) Md.cvK);
                    c.a(this.mAppId, "Hardware", "CODE_MEMORY", (double) Md.cvL);
                    c.a(this.mAppId, "Hardware", "STACK_MEMORY", (double) Md.cvM);
                    c.a(this.mAppId, "Hardware", "GRAPHICS_MEMORY", (double) Md.cvG);
                }
                c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", (double) Md.cvF);
            }
            AppMethodBeat.o(47979);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSL() {
            int i2;
            AppMethodBeat.i(47980);
            if (!this.nwF) {
                AppMethodBeat.o(47980);
            } else if (this.cBE.isDestroyed()) {
                AppMethodBeat.o(47980);
            } else {
                QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
                if (aeU != null) {
                    i2 = Util.getSelfMemInMB(MMApplicationContext.getContext()) - aeU.nLu;
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                if (i2 != Integer.MAX_VALUE) {
                    AppBrandPerformanceManager.a(this.cBE, 103, i2 + "m");
                }
                AppMethodBeat.o(47980);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSM() {
            AppMethodBeat.i(47981);
            if (!this.nwF) {
                AppMethodBeat.o(47981);
                return;
            }
            com.tencent.magicbrush.a bSS = bSS();
            if (bSS == null) {
                AppMethodBeat.o(47981);
                return;
            }
            c.a(this.mAppId, "Game", "FPS_GAME_RT", (double) bSS.cKu);
            c.a(this.mAppId, "Game", "FPS_GAME_EX", (double) bSS.cKv);
            try {
                c cVar = (c) com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE();
                c.a(this.mAppId, "Game", "FPS_GAME_LAG", (double) cVar.bCX().cxx.QR());
                c.a(this.mAppId, "Game", "FPS_GAME_LOW", (double) cVar.bCX().cxx.QS());
                AppMethodBeat.o(47981);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e2, "get QualityEvent of WAGame but fail.", new Object[0]);
                AppMethodBeat.o(47981);
            }
        }

        private com.tencent.magicbrush.a bSS() {
            com.tencent.magicbrush.a aVar;
            AppMethodBeat.i(47982);
            try {
                com.tencent.luggage.game.d.a.a.b bVar = (com.tencent.luggage.game.d.a.a.b) com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE().S(com.tencent.luggage.game.d.a.a.b.class);
                if (bVar != null) {
                    aVar = bVar.getMagicBrush().cxx.QP();
                    AppMethodBeat.o(47982);
                    return aVar;
                }
                com.tencent.luggage.game.d.a.a.d dVar = new com.tencent.luggage.game.d.a.a.d();
                AppMethodBeat.o(47982);
                throw dVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e2, "get QualityEvent of WAGame but fail.", new Object[0]);
                aVar = null;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSN() {
            AppMethodBeat.i(47983);
            if (!this.nwF) {
                AppMethodBeat.o(47983);
                return;
            }
            try {
                c.a(this.mAppId, "Game", "DRAW_CALLS", (double) ((c) com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QW());
                AppMethodBeat.o(47983);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e2, "get QualityEvent of WAGame but fail.", new Object[0]);
                AppMethodBeat.o(47983);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSO() {
            AppMethodBeat.i(47984);
            if (!this.nwF) {
                AppMethodBeat.o(47984);
                return;
            }
            try {
                c.a(this.mAppId, "Game", "VERTEXES", (double) ((c) com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QX());
                AppMethodBeat.o(47984);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e2, "get QualityEvent of WAGame but fail.", new Object[0]);
                AppMethodBeat.o(47984);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a
        public final void bSP() {
            AppMethodBeat.i(47985);
            if (!this.nwF) {
                AppMethodBeat.o(47985);
                return;
            }
            try {
                c.a(this.mAppId, "Game", "TRIANGLES", (double) ((c) com.tencent.mm.plugin.appbrand.a.TQ(this.mAppId).bsE()).bCX().cxx.QY());
                AppMethodBeat.o(47985);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e2, "get QualityEvent of WAGame but fail.", new Object[0]);
                AppMethodBeat.o(47985);
            }
        }
    }

    public static void E(q qVar) {
        AppMethodBeat.i(47986);
        String str = qVar.mAppId;
        Log.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", str);
        AppBrandPerformanceManager.a aVar = (AppBrandPerformanceManager.a) nwB.get(str.hashCode());
        if (!(aVar instanceof C0778b)) {
            if (aVar != null) {
                aVar.stop();
            }
            aVar = new C0778b(qVar);
            nwB.put(str.hashCode(), aVar);
        }
        aVar.start();
        AppMethodBeat.o(47986);
    }
}
