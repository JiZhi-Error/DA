package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.game.c.h;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    Handler handler;
    final b nKB = new b(this, (byte) 0);
    QualitySessionRuntime nKC;
    private com.tencent.mm.plugin.appbrand.performance.f nKD;

    public f() {
        AppMethodBeat.i(48213);
        AppMethodBeat.o(48213);
    }

    public enum a {
        Light,
        Full;

        public static a valueOf(String str) {
            AppMethodBeat.i(48210);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48210);
            return aVar;
        }

        static {
            AppMethodBeat.i(48211);
            AppMethodBeat.o(48211);
        }
    }

    public final void a(QualitySessionRuntime qualitySessionRuntime, int i2, a aVar, boolean z) {
        AppMethodBeat.i(48214);
        this.nKC = qualitySessionRuntime;
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
            this.nKB.dqS = (long) (i2 * 1000);
            this.nKB.nKH = aVar;
            this.nKB.nKI = z;
            this.handler.post(this.nKB);
        }
        this.nKD = new com.tencent.mm.plugin.appbrand.performance.f();
        this.nKD.mInterval = 200;
        this.nKD.nwI = null;
        this.nKD.start();
        AppMethodBeat.o(48214);
    }

    public final synchronized boolean bVb() {
        return this.nKC != null;
    }

    public final synchronized void destroy() {
        AppMethodBeat.i(48215);
        Log.i("MicroMsg.AppBrandRuntimeEventReporter", "dl: destroyed");
        this.nKC = null;
        if (this.handler != null) {
            this.handler.removeCallbacks(this.nKB);
            this.handler = null;
        }
        if (this.nKD != null) {
            this.nKD.stop();
            this.nKD = null;
        }
        AppMethodBeat.o(48215);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(a aVar, boolean z) {
        int i2;
        n nVar;
        int i3;
        boolean z2;
        e eVar = null;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(48216);
            if (this.nKC == null) {
                AppMethodBeat.o(48216);
            } else {
                QualitySessionRuntime qualitySessionRuntime = this.nKC;
                if (qualitySessionRuntime == null) {
                    nVar = null;
                } else {
                    q qVar = qualitySessionRuntime.kGW;
                    n.a aVar2 = new n.a();
                    if (aVar == a.Full) {
                        h hVar = h.INST;
                        h.a Md = h.Md();
                        aVar2.cvD = Md.cvD;
                        aVar2.nLT = Md.cvD - qualitySessionRuntime.nLu;
                        aVar2.cvE = Md.cvE;
                        aVar2.cvF = Md.cvF;
                        aVar2.nLV = (int) Math.round(h.INST.nwG.bSU());
                        aVar2.nLY = Md.cvG;
                    } else {
                        aVar2.cvD = -1;
                        aVar2.nLT = -1;
                        aVar2.cvE = -1;
                        aVar2.cvF = -1;
                        aVar2.nLV = -1;
                        aVar2.nLY = -1;
                    }
                    aVar2.lsk = al(qVar);
                    aVar2.nLU = (int) (System.currentTimeMillis() - qualitySessionRuntime.nLo);
                    if (qualitySessionRuntime.cuy) {
                        q qVar2 = qualitySessionRuntime.kGW;
                        try {
                            eVar = ((com.tencent.luggage.game.d.a.a.b) qVar2.bsE().S(com.tencent.luggage.game.d.a.a.b.class)).getMagicBrush();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", e2, "get QualityEvent of WAGame but fail. [%s]", qVar2);
                        }
                        if (eVar == null) {
                            Log.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
                        } else {
                            com.tencent.magicbrush.a QP = eVar.cxx.QP();
                            aVar2.fps = Math.round(QP.cKu);
                            aVar2.nLX = Math.round(QP.cKv);
                            aVar2.nLP = eVar.cxx.QT();
                            aVar2.nLR = eVar.cxx.QW();
                            aVar2.nLS = eVar.cxx.QX();
                            aVar2.nLQ = eVar.cxx.QY();
                            aVar2.nLJ = qualitySessionRuntime.nLy.nLJ;
                            if (eVar.Rk().use_command_buffer) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            aVar2.nLW = i3;
                            aVar2.nLZ = eVar.Rk().cmd_pool_type;
                            d.a QQ = eVar.cxx.QQ();
                            aVar2.nMa = QQ.cKY;
                            aVar2.nMb = QQ.cKZ;
                        }
                    } else {
                        f fVar = qualitySessionRuntime.nLw;
                        if (fVar.nKD == null) {
                            i2 = 0;
                        } else {
                            i2 = (int) (fVar.nKD.nxa + 0.5d);
                        }
                        aVar2.fps = i2;
                    }
                    nVar = new n(aVar2, (byte) 0);
                }
                if (nVar == null) {
                    AppMethodBeat.o(48216);
                } else if (!this.nKC.cuy) {
                    b.bUZ();
                    c.a(this.nKC.appId, nVar);
                    com.tencent.mm.plugin.appbrand.game.d.b bVar = new com.tencent.mm.plugin.appbrand.game.d.b(this.nKC, nVar);
                    if (aVar == a.Full) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bVar.hd(z2);
                    AppMethodBeat.o(48216);
                } else if (z) {
                    b.bUZ();
                    c.a(this.nKC.appId, nVar);
                    AppMethodBeat.o(48216);
                } else {
                    com.tencent.mm.plugin.appbrand.game.d.b bVar2 = new com.tencent.mm.plugin.appbrand.game.d.b(this.nKC, nVar);
                    if (aVar != a.Full) {
                        z3 = false;
                    }
                    bVar2.hd(z3);
                    AppMethodBeat.o(48216);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private long dqS;
        private a nKH;
        private boolean nKI;

        private b() {
            this.dqS = 0;
            this.nKH = null;
            this.nKI = false;
        }

        /* synthetic */ b(f fVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(48212);
            if (f.this.nKC == null) {
                AppMethodBeat.o(48212);
                return;
            }
            if (this.nKH == null) {
                Log.e("MicroMsg.AppBrandRuntimeEventReporter", "hy: null type! could not happen");
            }
            f.this.a(this.nKH, this.nKI);
            f.this.handler.postDelayed(f.this.nKB, this.dqS);
            AppMethodBeat.o(48212);
        }
    }

    private static int al(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(48217);
        try {
            int stackSize = appBrandRuntime.kAl.getStackSize();
            AppMethodBeat.o(48217);
            return stackSize;
        } catch (Exception e2) {
            AppMethodBeat.o(48217);
            return 0;
        }
    }
}
