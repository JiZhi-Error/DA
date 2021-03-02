package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mmkv.MMKV;

public class f extends com.tencent.mm.plugin.ball.service.f implements n {
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(226551);
            f.e(ballInfo);
            AppMethodBeat.o(226551);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    };
    q kGW;
    private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
    private f.b lqK = new f.b() {
        /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f.b
        public final void b(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
            AppMethodBeat.i(226552);
            if (appBrandBackgroundRunningOperationParcel != null && f.this.kGW != null && f.this.kGW.mAppId.equals(appBrandBackgroundRunningOperationParcel.appId) && f.this.kGW.kAq.eix == appBrandBackgroundRunningOperationParcel.iOo && appBrandBackgroundRunningOperationParcel.beL == 4 && appBrandBackgroundRunningOperationParcel.dDe == 1) {
                f.f(f.this);
            }
            AppMethodBeat.o(226552);
        }
    };
    private final String lqM = "has_shown_appbrand_voip_tip";

    public interface a {
        void bCH();
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(226571);
        fVar.bCO();
        AppMethodBeat.o(226571);
    }

    static /* synthetic */ void a(f fVar, int i2) {
        AppMethodBeat.i(226569);
        fVar.wy(i2);
        AppMethodBeat.o(226569);
    }

    static /* synthetic */ void b(f fVar, int i2) {
        AppMethodBeat.i(226570);
        fVar.wv(i2);
        AppMethodBeat.o(226570);
    }

    public f(com.tencent.mm.plugin.ball.a.f fVar, q qVar) {
        super(fVar);
        AppMethodBeat.i(226553);
        this.kGW = qVar;
        qVar.a(this);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        this.lqJ = (com.tencent.mm.plugin.appbrand.backgroundrunning.f) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
        AppMethodBeat.o(226553);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(226554);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        if (this.lqJ != null) {
            this.lqJ.a(this.lqK);
        }
        AppMethodBeat.o(226554);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(final int i2) {
        AppMethodBeat.i(226555);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (ciq()) {
            if (bCL()) {
                Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onClose, should show voip tip");
                a(this.oXA.getActivity(), new a() {
                    /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.floatball.f.a
                    public final void bCH() {
                        AppMethodBeat.i(226546);
                        f.a(f.this, i2);
                        AppMethodBeat.o(226546);
                    }
                });
            } else {
                wy(i2);
            }
        }
        AppMethodBeat.o(226555);
        return false;
    }

    public final boolean bCL() {
        AppMethodBeat.i(226556);
        boolean decodeBool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_tip", false);
        if (!ciq() || decodeBool) {
            AppMethodBeat.o(226556);
            return false;
        }
        AppMethodBeat.o(226556);
        return true;
    }

    public final void a(Context context, final a aVar) {
        AppMethodBeat.i(226557);
        f.a aVar2 = new f.a(context);
        aVar2.bow(context.getString(R.string.a3u));
        aVar2.JnN = true;
        aVar2.apa(R.string.a3v);
        aVar2.b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(226547);
                Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "showVOIPTip, has shown tip");
                MMKV.defaultMMKV().encode("has_shown_appbrand_voip_tip", true);
                if (aVar != null) {
                    aVar.bCH();
                }
                AppMethodBeat.o(226547);
            }
        });
        aVar2.show();
        AppMethodBeat.o(226557);
    }

    private void wy(final int i2) {
        AppMethodBeat.i(226558);
        if (!b.cx(this.oXA.getActivity())) {
            AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 17, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.ball.f.c.a
                public final void ha(boolean z) {
                    AppMethodBeat.i(226548);
                    Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", Boolean.valueOf(z));
                    if (z) {
                        f.b(f.this, i2);
                        AppMethodBeat.o(226548);
                        return;
                    }
                    Log.w("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
                    f.this.cir();
                    f.a(f.this);
                    f.this.oXA.hb(true);
                    AppMethodBeat.o(226548);
                }
            });
            AppMethodBeat.o(226558);
            return;
        }
        wv(i2);
        AppMethodBeat.o(226558);
    }

    private void wv(int i2) {
        AppMethodBeat.i(226559);
        ciw().opType = BI(i2);
        cit();
        com.tencent.mm.plugin.ball.ui.c.a(this.oXA, this.oWG.getBallPosition(), new com.tencent.mm.plugin.ball.d.a() {
            /* class com.tencent.mm.plugin.appbrand.floatball.f.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(226549);
                Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation end");
                f.this.oXA.hb(false);
                AppMethodBeat.o(226549);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(226550);
                Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
                f.this.oXA.hb(true);
                AppMethodBeat.o(226550);
            }
        });
        AppMethodBeat.o(226559);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(226560);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onDestroy, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.onDestroy();
        if (this.lqJ != null) {
            this.lqJ.b(this.lqK);
        }
        AppMethodBeat.o(226560);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(226561);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onEnterPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(false);
        }
        AppMethodBeat.o(226561);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(226562);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onExitPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(true);
            u.makeText(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), (int) R.string.a3w, 0).show();
        }
        if (this.oWG != null) {
            this.oWG.q(this.oWE);
        }
        AppMethodBeat.o(226562);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(226563);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        this.oXA.hb(true);
        AppMethodBeat.o(226563);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(226564);
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.bCB();
        bCO();
        AppMethodBeat.o(226564);
    }

    static {
        AppMethodBeat.i(226574);
        AppMethodBeat.o(226574);
    }

    public static void bCM() {
        AppMethodBeat.i(226565);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(17, lqt);
        }
        AppMethodBeat.o(226565);
    }

    public static void bCN() {
        AppMethodBeat.i(226566);
        if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(17, lqt);
        }
        AppMethodBeat.o(226566);
    }

    private void bCO() {
        AppMethodBeat.i(226567);
        if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null) {
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
            mMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
            mMBackgroundRunningOperationParcel.beL = 4;
            mMBackgroundRunningOperationParcel.dDe = 2;
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "stopVOIP, appId:%s", this.kGW.mAppId);
            ((com.tencent.mm.plugin.appbrand.backgroundrunning.f) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(mMBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(226567);
    }

    private int bCP() {
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.e eVar;
        AppMethodBeat.i(226568);
        if (this.kGW == null || (eVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e) this.kGW.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class)) == null) {
            AppMethodBeat.o(226568);
            return 32;
        }
        boolean z = eVar.mJN;
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "getCurrentVOIPState, enableMic:%s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(226568);
            return 32;
        }
        AppMethodBeat.o(226568);
        return 64;
    }

    static /* synthetic */ void e(BallInfo ballInfo) {
        r rVar;
        AppMethodBeat.i(226572);
        if (ballInfo != null && ballInfo.type == 17) {
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
            String string = ballInfo.jkf.getString("appId");
            String string2 = ballInfo.jkf.getString(ch.COL_USERNAME);
            int i2 = ballInfo.jkf.getInt("versionType");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1131;
            if ((!Util.isNullOrNil(string2) || !Util.isNullOrNil(string)) && (rVar = (r) g.af(r.class)) != null) {
                Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "openAppBrand, launch:%s#%s", string, Integer.valueOf(i2));
                rVar.a(MMApplicationContext.getContext(), string2, string, i2, -1, (String) null, appBrandStatObject);
            }
        }
        AppMethodBeat.o(226572);
    }

    static /* synthetic */ void f(f fVar) {
        AppMethodBeat.i(226573);
        if (!fVar.ciq()) {
            Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onVOIPStateChanged, add passive float ball");
            fVar.jT(true);
            fVar.jU(true);
            fVar.BH(fVar.bCP());
            fVar.cis();
            AppMethodBeat.o(226573);
            return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandVOIPFloatBallHelper", "onVOIPStateChanged, already add this float ball, so update state");
        fVar.BH(fVar.bCP());
        AppMethodBeat.o(226573);
    }
}
