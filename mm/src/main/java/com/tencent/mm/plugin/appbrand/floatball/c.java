package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c {
    public a lqA;
    public b lqw;
    public e lqx;
    public f lqy;
    public g lqz;

    public final void v(final q qVar) {
        AppMethodBeat.i(226539);
        Log.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", qVar.mAppId);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.floatball.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(226536);
                if (qVar.isDestroyed() || qVar.SO) {
                    Log.w("MicroMsg.AppBrandFloatBallLogic", "initFloatBallHelper in work thread, but runtime finished");
                    AppMethodBeat.o(226536);
                    return;
                }
                if (c.this.lqw != null) {
                    c.this.lqw.onDestroy();
                }
                d dVar = new d(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.lqw = new b(dVar, qVar);
                c.this.lqw.G(1, b.cA(qVar.mAppId, qVar.kAq.eix));
                b bVar = c.this.lqw;
                AppBrandInitConfigWC bsC = qVar.bsC();
                if (bsC != null) {
                    Log.i("MicroMsg.AppBrandFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", bsC);
                    bVar.oWE.icon = bVar.kGW.bsC().iconUrl;
                    bVar.oWE.name = bVar.kGW.bsC().brandName;
                    if (bVar.kGW.kAq.eix == 1) {
                        bVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.id);
                    } else if (bVar.kGW.kAq.eix == 2) {
                        bVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.ic);
                    } else {
                        bVar.oWE.tag = null;
                    }
                    bVar.oWE.eS("appId", bVar.kGW.bsC().appId);
                    bVar.oWE.eS(ch.COL_USERNAME, bVar.kGW.bsC().username);
                    bVar.oWE.cy("versionType", bVar.kGW.bsC().eix);
                    c.a(bVar, bsC);
                    bVar.ciw().hDa = 6;
                    bVar.cit();
                }
                if (c.this.lqx != null) {
                    c.this.lqx.onDestroy();
                }
                d dVar2 = new d(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.lqx = new e(dVar2, qVar);
                c.this.lqx.G(7, b.cB(qVar.mAppId, qVar.kAq.eix));
                e eVar = c.this.lqx;
                AppBrandInitConfigWC bsC2 = qVar.bsC();
                if (bsC2 != null) {
                    Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", bsC2);
                    eVar.oWE.icon = eVar.kGW.bsC().iconUrl;
                    eVar.oWE.name = eVar.kGW.bsC().brandName;
                    if (eVar.kGW.kAq.eix == 1) {
                        eVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.id);
                    } else if (eVar.kGW.kAq.eix == 2) {
                        eVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.ic);
                    } else {
                        eVar.oWE.tag = null;
                    }
                    c.a(eVar, bsC2);
                    eVar.ciw().hDa = 2;
                    eVar.cit();
                }
                if (c.this.lqy != null) {
                    c.this.lqy.onDestroy();
                }
                d dVar3 = new d(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.lqy = new f(dVar3, qVar);
                c.this.lqy.G(17, b.cB(qVar.mAppId, qVar.kAq.eix));
                f fVar = c.this.lqy;
                AppBrandInitConfigWC bsC3 = qVar.bsC();
                if (bsC3 != null) {
                    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", bsC3);
                    fVar.oWE.icon = fVar.kGW.bsC().iconUrl;
                    fVar.oWE.name = fVar.kGW.bsC().brandName;
                    if (fVar.kGW.kAq.eix == 1) {
                        fVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.id);
                    } else if (fVar.kGW.kAq.eix == 2) {
                        fVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.ic);
                    } else {
                        fVar.oWE.tag = null;
                    }
                    fVar.oWE.eS("appId", fVar.kGW.bsC().appId);
                    fVar.oWE.eS(ch.COL_USERNAME, fVar.kGW.bsC().username);
                    fVar.oWE.cy("versionType", fVar.kGW.bsC().eix);
                    c.a(fVar, bsC3);
                    fVar.ciw().hDa = 12;
                    fVar.cit();
                }
                if (c.this.lqA != null) {
                    c.this.lqA.onDestroy();
                }
                d dVar4 = new d(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.lqA = new a(dVar4, qVar);
                c.this.lqA.G(18, b.cA(qVar.mAppId, qVar.kAq.eix));
                a aVar = c.this.lqA;
                AppBrandInitConfigWC bsC4 = qVar.bsC();
                if (bsC4 != null) {
                    Log.i(aVar.cDW, "updateBallInfoWithInitConfig, initConfig:%s", bsC4);
                    aVar.oWE.icon = aVar.kBw.bsC().iconUrl;
                    aVar.oWE.name = aVar.bCD();
                    if (aVar.kBw.kAq.eix == 1) {
                        aVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.id);
                    } else if (aVar.kBw.kAq.eix == 2) {
                        aVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.ic);
                    } else {
                        aVar.oWE.tag = null;
                    }
                    aVar.cit();
                }
                if (c.this.lqz != null) {
                    c.this.lqz.onDestroy();
                }
                h hVar = new h(AndroidContextUtil.castActivityOrNull(qVar.mContext), qVar);
                c.this.lqz = new g(hVar, qVar);
                c.this.lqz.G(19, b.cB(qVar.mAppId, qVar.kAq.eix));
                g gVar = c.this.lqz;
                AppBrandInitConfigWC bsC5 = qVar.bsC();
                if (bsC5 != null) {
                    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "updateBallInfoWithInitConfig, initConfig:%s", bsC5);
                    gVar.oWE.icon = gVar.kGW.bsC().iconUrl;
                    gVar.oWE.name = gVar.kGW.bsC().brandName;
                    if (gVar.kGW.kAq.eix == 1) {
                        gVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.id);
                    } else if (gVar.kGW.kAq.eix == 2) {
                        gVar.oWE.tag = MMApplicationContext.getContext().getString(R.string.ic);
                    } else {
                        gVar.oWE.tag = null;
                    }
                    gVar.oWE.eS("appId", gVar.kGW.bsC().appId);
                    gVar.oWE.eS(ch.COL_USERNAME, gVar.kGW.bsC().username);
                    gVar.oWE.cy("versionType", gVar.kGW.bsC().eix);
                    c.a(gVar, bsC5);
                    gVar.ciw().hDa = 14;
                    gVar.cit();
                }
                qVar.O(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.floatball.c.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(226535);
                        if (c.this.lqw != null) {
                            c.this.lqw.bCA();
                        }
                        if (c.this.lqx != null) {
                            c.this.lqx.bCA();
                        }
                        if (c.this.lqy != null) {
                            c.this.lqy.bCA();
                        }
                        if (c.this.lqA != null) {
                            c.this.lqA.bCA();
                        }
                        if (c.this.lqz != null) {
                            c.this.lqz.bCA();
                        }
                        AppMethodBeat.o(226535);
                    }
                });
                AppMethodBeat.o(226536);
            }
        }, "FloatBallHelperThread");
        AppMethodBeat.o(226539);
    }

    public final boolean ww(int i2) {
        AppMethodBeat.i(226540);
        if (this.lqw != null && this.lqw.wu(i2)) {
            AppMethodBeat.o(226540);
            return true;
        } else if (this.lqx != null && this.lqx.wu(i2)) {
            AppMethodBeat.o(226540);
            return true;
        } else if (this.lqy != null && this.lqy.wu(i2)) {
            AppMethodBeat.o(226540);
            return true;
        } else if (this.lqA != null && this.lqA.wu(i2)) {
            AppMethodBeat.o(226540);
            return true;
        } else if (this.lqz == null || !this.lqz.wu(i2)) {
            AppMethodBeat.o(226540);
            return false;
        } else {
            AppMethodBeat.o(226540);
            return true;
        }
    }

    public final void w(q qVar) {
        AppMethodBeat.i(226541);
        Log.i("MicroMsg.AppBrandFloatBallLogic", "destroy, runtime:%s", qVar.mAppId);
        if (this.lqw != null) {
            this.lqw.onDestroy();
        }
        if (this.lqx != null) {
            this.lqx.onDestroy();
        }
        if (this.lqy != null) {
            this.lqy.onDestroy();
        }
        if (this.lqA != null) {
            this.lqA.onDestroy();
        }
        if (this.lqz != null) {
            this.lqz.onDestroy();
        }
        AppMethodBeat.o(226541);
    }

    public static void a(FloatBallHelper floatBallHelper, AppBrandInitConfig appBrandInitConfig) {
        int i2 = 0;
        AppMethodBeat.i(226542);
        if (!(appBrandInitConfig instanceof AppBrandInitConfigWC)) {
            AppMethodBeat.o(226542);
            return;
        }
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) appBrandInitConfig;
        Log.i("MicroMsg.AppBrandFloatBallLogic", "setReportInfo, floatBallHelper:%s, configAppName:%s", floatBallHelper, appBrandInitConfigWC.brandName);
        floatBallHelper.ciw().dPJ = appBrandInitConfigWC.appId;
        floatBallHelper.ciw().iNV = appBrandInitConfigWC.brandName;
        floatBallHelper.ciw().oWy = String.valueOf(appBrandInitConfigWC.cyo);
        BallReportInfo ciw = floatBallHelper.ciw();
        if (appBrandInitConfigWC.cyA != null) {
            i2 = appBrandInitConfigWC.cyA.scene;
        }
        ciw.oWx = i2;
        AppMethodBeat.o(226542);
    }
}
