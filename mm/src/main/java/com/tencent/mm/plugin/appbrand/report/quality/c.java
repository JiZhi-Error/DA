package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lv;
import com.tencent.mm.g.b.a.lz;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.g.b.a.mp;
import com.tencent.mm.g.b.a.mz;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends d {
    public static void a(boolean z, String str, long j2, o oVar) {
        AppMethodBeat.i(48200);
        mz mzVar = new mz();
        if (!z) {
            QualitySessionRuntime aeU = b.aeU(str);
            if (aeU == null) {
                AppMethodBeat.o(48200);
                return;
            }
            mzVar.Aj(aeU.appId);
            mzVar.Ai(aeU.kEY);
            mzVar.ffI = mz.a.mL(aeU.nJE);
            mzVar.eYW = (long) aeU.apptype;
            mzVar.eXc = (long) aeU.nLk;
            mzVar.erW = (long) aeU.scene;
            mzVar.eZK = aeU.bVg();
        } else {
            mzVar.eZK = 1;
        }
        mzVar.xv(j2);
        mzVar.ajn();
        mzVar.xu(mzVar.fae - j2);
        switch (oVar) {
            case X5:
                mzVar.evl = 2;
                break;
            case Sys:
                mzVar.evl = 4;
                break;
            case XWalk:
                mzVar.evl = 3;
                break;
            default:
                mzVar.evl = 2147483647L;
                break;
        }
        mzVar.ffJ = bVa();
        mzVar.Ak(new StringBuilder().append(bVa()).toString());
        mzVar.bfK();
        AppMethodBeat.o(48200);
    }

    public static void a(g gVar, String str, long j2, e eVar) {
        long j3 = 0;
        AppMethodBeat.i(48201);
        lz lzVar = new lz();
        if (!(gVar != null)) {
            QualitySessionRuntime aeU = b.aeU(str);
            if (aeU == null) {
                AppMethodBeat.o(48201);
                return;
            }
            lzVar.zj(aeU.appId);
            lzVar.zi(aeU.kEY);
            lzVar.faG = lz.a.ml(aeU.nJE);
            lzVar.eYW = (long) aeU.apptype;
            lzVar.eXc = (long) aeU.nLk;
            lzVar.erW = (long) aeU.scene;
            lzVar.eZK = aeU.bVg();
            if (aeU.cuy) {
                j3 = 1;
            }
            lzVar.faH = j3;
        } else {
            lzVar.eZK = 1;
            if (gVar == g.WAGAME) {
                j3 = 1;
            }
            lzVar.faH = j3;
        }
        lzVar.vA(j2);
        lzVar.aiU();
        lzVar.vz(lzVar.fae - j2);
        switch (eVar) {
            case X5:
                lzVar.evl = 1;
                break;
            case MMV8:
                lzVar.evl = 2;
                break;
            case WebViewBased:
                lzVar.evl = 3;
                break;
            case NativeScript:
                lzVar.evl = 4;
                break;
            case J2V8:
                lzVar.evl = 5;
                break;
            case NodeJS:
                lzVar.evl = 6;
                break;
            default:
                lzVar.evl = 2147483647L;
                break;
        }
        lzVar.zk(V8.getV8Version());
        lzVar.bfK();
        AppMethodBeat.o(48201);
    }

    public final mj r(boolean z, String str) {
        AppMethodBeat.i(227388);
        mj a2 = a(z, str, (i) null);
        AppMethodBeat.o(227388);
        return a2;
    }

    public final mj l(d dVar) {
        AppMethodBeat.i(48202);
        mj a2 = a(dVar.bsW(), dVar.getAppId(), dVar.getJsRuntime());
        if (a2 == null) {
            AppMethodBeat.o(48202);
            return null;
        }
        a2.zz(dVar.bqZ().bvb());
        AppMethodBeat.o(48202);
        return a2;
    }

    private static mj a(boolean z, String str, i iVar) {
        AppMethodBeat.i(48203);
        mj mjVar = new mj();
        if (!z) {
            QualitySessionRuntime aeU = b.aeU(str);
            if (aeU == null) {
                AppMethodBeat.o(48203);
                return null;
            }
            mjVar.zx(aeU.appId);
            mjVar.zw(aeU.kEY);
            mjVar.fbC = (long) aeU.nJE;
            mjVar.eYW = (long) aeU.apptype;
            mjVar.eXc = (long) aeU.nLk;
            mjVar.erW = (long) aeU.scene;
            mjVar.eZK = aeU.bVg();
        } else {
            mjVar.eZK = 1;
        }
        a(mjVar, iVar);
        AppMethodBeat.o(48203);
        return mjVar;
    }

    private static void a(mj mjVar, i iVar) {
        int i2;
        AppMethodBeat.i(48204);
        if (iVar != null) {
            switch (e.d(iVar)) {
                case X5:
                    i2 = 1;
                    break;
                case MMV8:
                    i2 = 2;
                    break;
                case WebViewBased:
                    i2 = 3;
                    break;
                case NativeScript:
                    i2 = 4;
                    break;
                case J2V8:
                    i2 = 5;
                    break;
                case NodeJS:
                    i2 = 6;
                    break;
                case WebViewX5:
                    i2 = 102;
                    break;
                case WebViewXW:
                    i2 = 103;
                    break;
                case WebViewSystem:
                    i2 = 104;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            mjVar.fbF = (long) i2;
            if (iVar instanceof bb) {
                mjVar.zA(new StringBuilder().append(bVa()).toString());
            }
        }
        AppMethodBeat.o(48204);
    }

    public static void a(d dVar, String str, long j2, long j3, boolean z, long j4) {
        String str2;
        long j5;
        AppMethodBeat.i(175062);
        if (!dVar.isRunning()) {
            AppMethodBeat.o(175062);
            return;
        }
        mj mjVar = new mj();
        QualitySessionRuntime aeU = b.aeU(dVar.getAppId());
        if (aeU == null) {
            AppMethodBeat.o(175062);
            return;
        }
        mjVar.zx(aeU.appId);
        mjVar.zw(aeU.kEY);
        mjVar.fbC = (long) aeU.nJE;
        mjVar.eYW = (long) aeU.apptype;
        mjVar.eXc = (long) aeU.nLk;
        mjVar.erW = (long) aeU.scene;
        a(mjVar, dVar.getJsRuntime());
        if (dVar instanceof ac) {
            str2 = "WebView-wxConfigReady";
        } else if (((q) dVar.getRuntime()).NA()) {
            str2 = "GameMainContext-wxConfigReady";
        } else {
            str2 = "MainContext-wxConfigReady";
        }
        mjVar.zy(str2);
        mjVar.fbD = (long) Util.nullAsNil(str).length();
        mjVar.zz(dVar.bqZ().bvb());
        if (z) {
            j5 = 1;
        } else {
            j5 = 0;
        }
        mjVar.fbH = j5;
        mjVar.vX(j2);
        mjVar.vY(j3);
        mjVar.vW(mjVar.fae - mjVar.fad);
        mjVar.fbI = j4;
        mjVar.bfK();
        AppMethodBeat.o(175062);
    }

    public static void aeV(String str) {
        AppMethodBeat.i(48206);
        QualitySessionRuntime aeU = b.aeU(str);
        if (aeU == null) {
            AppMethodBeat.o(48206);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = aeU.nLr;
        if (DebuggerShell.bAx()) {
            com.tencent.mm.plugin.appbrand.performance.c.b(str, "FirstRenderToGameInteractive", j2, currentTimeMillis);
        }
        AppMethodBeat.o(48206);
    }

    public static void a(String str, n nVar) {
        int i2 = 1;
        AppMethodBeat.i(48207);
        QualitySessionRuntime aeU = b.aeU(str);
        if (aeU == null) {
            AppMethodBeat.o(48207);
            return;
        }
        mp mpVar = new mp();
        mpVar.eJx = mpVar.x("AppId", aeU.appId, true);
        mpVar.eWb = mpVar.x("InstanceId", aeU.kEY, true);
        mpVar.fcP = mp.a.mA(aeU.nJE);
        mpVar.eYW = (long) aeU.apptype;
        mpVar.eXc = (long) aeU.nLk;
        mpVar.erW = (long) aeU.scene;
        mpVar.fde = (long) aeU.nLx.get();
        mpVar.aji();
        mpVar.ajj();
        mpVar.ajh();
        mpVar.fcQ = (long) nVar.fps;
        mpVar.fcR = (long) Math.round(nVar.nLP);
        if (nVar.nLJ != m.a._2D) {
            if (nVar.nLJ == m.a.WEBGL) {
                i2 = 2;
            } else {
                i2 = 0;
            }
        }
        mpVar.fcZ = (long) i2;
        mpVar.fda = (long) nVar.nLQ;
        mpVar.fdb = (long) nVar.nLR;
        mpVar.fdc = (long) nVar.nLS;
        mpVar.fcV = (long) nVar.cvE;
        mpVar.fcW = (long) nVar.cvF;
        mpVar.fcT = (long) nVar.cvD;
        mpVar.fcU = (long) nVar.nLT;
        mpVar.fcX = (long) (nVar.nLU / 1000);
        mpVar.fcY = (long) nVar.lsk;
        mpVar.fcS = (long) nVar.nLV;
        mpVar.fdd = (long) nVar.nLW;
        mpVar.fdf = (long) nVar.nLX;
        mpVar.fdg = (long) nVar.nLY;
        mpVar.fdh = (long) nVar.nLZ;
        mpVar.fdi = (long) nVar.nMa;
        mpVar.fdj = (long) nVar.nMb;
        mpVar.bfK();
        AppMethodBeat.o(48207);
    }

    public static void a(boolean z, String str, long j2) {
        long j3;
        AppMethodBeat.i(48208);
        lv lvVar = new lv();
        if (!z) {
            QualitySessionRuntime aeU = b.aeU(str);
            if (aeU == null) {
                AppMethodBeat.o(48208);
                return;
            }
            lvVar.zh(aeU.appId);
            lvVar.zg(aeU.kEY);
            lvVar.fak = lv.a.mh(aeU.nJE);
            lvVar.eYW = (long) aeU.apptype;
            lvVar.erW = (long) aeU.scene;
        }
        lvVar.vp(j2);
        lvVar.aiT();
        lvVar.vo(lvVar.fae - lvVar.fad);
        if (z) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        lvVar.fal = j3;
        lvVar.bfK();
        AppMethodBeat.o(48208);
    }
}
