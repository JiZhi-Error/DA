package com.tencent.mm.plugin.appbrand.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.floatball.f;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class b extends f {
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.plugin.appbrand.floatball.b.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(226532);
            b.a(ballInfo);
            AppMethodBeat.o(226532);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    };
    q kGW;

    public b(com.tencent.mm.plugin.ball.a.f fVar, q qVar) {
        super(fVar);
        AppMethodBeat.i(44964);
        this.kGW = qVar;
        Log.i("MicroMsg.AppBrandFloatBallHelper", "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        AppMethodBeat.o(44964);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        AppMethodBeat.i(44965);
        if (!this.kGW.bsC().ldN) {
            AppMethodBeat.o(44965);
            return true;
        }
        AppMethodBeat.o(44965);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(44966);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        AppMethodBeat.o(44966);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(int i2) {
        AppMethodBeat.i(44967);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onClose, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        boolean wu = super.wu(i2);
        AppMethodBeat.o(44967);
        return wu;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(44968);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onDestroy, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.onDestroy();
        AppMethodBeat.o(44968);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(44969);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onEnterPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (AppBrandRuntimeWCAccessible.isGame(this.kGW)) {
            super.aGf();
            AppMethodBeat.o(44969);
            return;
        }
        super.bCA();
        AppMethodBeat.o(44969);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(44970);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onExitPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.aGj();
        AppMethodBeat.o(44970);
    }

    @Override // com.tencent.mm.plugin.ball.service.f
    public final void a(final f.a aVar) {
        AppMethodBeat.i(226533);
        f fVar = (f) this.kGW.aw(f.class);
        if (fVar == null || !fVar.bCL()) {
            Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, not show vpip tip");
            aVar.proceed();
            AppMethodBeat.o(226533);
            return;
        }
        fVar.a(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), new f.a() {
            /* class com.tencent.mm.plugin.appbrand.floatball.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.floatball.f.a
            public final void bCH() {
                AppMethodBeat.i(226531);
                Log.i("MicroMsg.AppBrandFloatBallHelper", "beforeOnMenuFloatBallSelected, afterShowVOIPTip");
                if (aVar != null) {
                    aVar.proceed();
                }
                AppMethodBeat.o(226531);
            }
        });
        AppMethodBeat.o(226533);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(44971);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        this.oXA.hb(true);
        AppMethodBeat.o(44971);
    }

    static {
        AppMethodBeat.i(44975);
        AppMethodBeat.o(44975);
    }

    public static void bCE() {
        AppMethodBeat.i(44972);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(1, lqt);
        }
        AppMethodBeat.o(44972);
    }

    public static void bCF() {
        AppMethodBeat.i(44973);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(1, lqt);
        }
        AppMethodBeat.o(44973);
    }

    public static int b(h.d dVar) {
        if (dVar == h.d.BACK) {
            return 2;
        }
        if (dVar == h.d.CLOSE) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        AppMethodBeat.i(226534);
        Log.i("MicroMsg.AppBrandFloatBallHelper", "alvinluo enableMessageFloatBall %b, %s", Boolean.valueOf(aGh()), this);
        boolean aGh = aGh();
        AppMethodBeat.o(226534);
        return aGh;
    }

    static /* synthetic */ void a(BallInfo ballInfo) {
        r rVar;
        AppMethodBeat.i(44974);
        if (!(ballInfo == null || ballInfo.jkf == null)) {
            Log.i("MicroMsg.AppBrandFloatBallHelper", "handleBallInfoClicked, openAppBrand ballInfo:%s", ballInfo);
            String string = ballInfo.jkf.getString("appId");
            String string2 = ballInfo.jkf.getString(ch.COL_USERNAME);
            int i2 = ballInfo.jkf.getInt("versionType");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1131;
            if ((!Util.isNullOrNil(string2) || !Util.isNullOrNil(string)) && (rVar = (r) g.af(r.class)) != null) {
                Log.i("MicroMsg.AppBrandFloatBallHelper", "openAppBrand, launch:%s#%s", string, Integer.valueOf(i2));
                rVar.a(MMApplicationContext.getContext(), string2, string, i2, -1, (String) null, appBrandStatObject);
            }
        }
        AppMethodBeat.o(44974);
    }
}
