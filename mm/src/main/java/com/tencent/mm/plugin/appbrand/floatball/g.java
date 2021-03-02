package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mmkv.MMKV;

public final class g extends f implements n {
    private static e lqt = new e() {
        /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(226582);
            g.f(ballInfo);
            AppMethodBeat.o(226582);
        }

        @Override // com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
            AppMethodBeat.i(226583);
            if (ballInfo != null && ballInfo.type == 19) {
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
                String string = ballInfo.jkf.getString("appId");
                AppBrandVoIP1v1FloatBallEvent appBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
                appBrandVoIP1v1FloatBallEvent.dRq = 1;
                com.tencent.mm.plugin.appbrand.ipc.e.b(string, appBrandVoIP1v1FloatBallEvent);
            }
            AppMethodBeat.o(226583);
        }

        @Override // com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.e
        public final void g(BallInfo ballInfo) {
        }
    };
    private Handler handler;
    q kGW;
    private com.tencent.mm.plugin.appbrand.backgroundrunning.f lqJ;
    private f.b lqK = new f.b() {
        /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f.b
        public final void b(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
            AppMethodBeat.i(226584);
            if (appBrandBackgroundRunningOperationParcel != null && g.this.kGW != null && g.this.kGW.mAppId.equals(appBrandBackgroundRunningOperationParcel.appId) && g.this.kGW.kAq.eix == appBrandBackgroundRunningOperationParcel.iOo && appBrandBackgroundRunningOperationParcel.beL == 16 && appBrandBackgroundRunningOperationParcel.dDe == 1) {
                g.h(g.this);
            }
            AppMethodBeat.o(226584);
        }
    };
    private final String lqM = "has_shown_appbrand_voip_1v1_tip";

    public interface a {
        void bCH();
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(226603);
        gVar.bCO();
        AppMethodBeat.o(226603);
    }

    static /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(226601);
        gVar.wy(i2);
        AppMethodBeat.o(226601);
    }

    static /* synthetic */ void b(g gVar, int i2) {
        AppMethodBeat.i(226602);
        gVar.wv(i2);
        AppMethodBeat.o(226602);
    }

    static /* synthetic */ int e(g gVar) {
        AppMethodBeat.i(226604);
        int bCP = gVar.bCP();
        AppMethodBeat.o(226604);
        return bCP;
    }

    public g(com.tencent.mm.plugin.ball.a.f fVar, q qVar) {
        super(fVar);
        AppMethodBeat.i(226585);
        this.kGW = qVar;
        qVar.a(this);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        this.lqJ = (com.tencent.mm.plugin.appbrand.backgroundrunning.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class);
        this.handler = new Handler(Looper.getMainLooper());
        AppMethodBeat.o(226585);
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
        AppMethodBeat.i(226586);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        if (this.lqJ != null) {
            this.lqJ.a(this.lqK);
        }
        AppMethodBeat.o(226586);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(final int i2) {
        AppMethodBeat.i(226587);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (ciq()) {
            if (bCL()) {
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onClose, should show voip tip");
                a(this.oXA.getActivity(), new a() {
                    /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.floatball.g.a
                    public final void bCH() {
                        AppMethodBeat.i(226575);
                        g.a(g.this, i2);
                        AppMethodBeat.o(226575);
                    }
                });
            } else {
                wy(i2);
            }
        }
        AppMethodBeat.o(226587);
        return false;
    }

    public final boolean bCL() {
        AppMethodBeat.i(226588);
        boolean decodeBool = MMKV.defaultMMKV().decodeBool("has_shown_appbrand_voip_1v1_tip", false);
        if (!ciq() || decodeBool) {
            AppMethodBeat.o(226588);
            return false;
        }
        AppMethodBeat.o(226588);
        return true;
    }

    public final void a(Context context, final a aVar) {
        AppMethodBeat.i(226589);
        f.a aVar2 = new f.a(context);
        aVar2.bow(context.getString(R.string.a3u));
        aVar2.JnN = true;
        aVar2.apa(R.string.a3v);
        aVar2.b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(226576);
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "showVOIPTip, has shown tip");
                MMKV.defaultMMKV().encode("has_shown_appbrand_voip_1v1_tip", true);
                if (aVar != null) {
                    aVar.bCH();
                }
                AppMethodBeat.o(226576);
            }
        });
        aVar2.show();
        AppMethodBeat.o(226589);
    }

    private void wy(final int i2) {
        AppMethodBeat.i(226590);
        if (!b.cx(this.oXA.getActivity())) {
            AppBrandFloatBallPermissionHelper.a(this.oXA.getActivity(), 19, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.ball.f.c.a
                public final void ha(boolean z) {
                    AppMethodBeat.i(226577);
                    Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, checkFloatBallPermission isOK:%b", Boolean.valueOf(z));
                    if (z) {
                        g.b(g.this, i2);
                        AppMethodBeat.o(226577);
                        return;
                    }
                    Log.w("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseAfterCheckingTip, refuse permission, remove ball and stop voip");
                    g.this.cir();
                    g.a(g.this);
                    g.this.oXA.hb(true);
                    AppMethodBeat.o(226577);
                }
            });
            AppMethodBeat.o(226590);
            return;
        }
        wv(i2);
        AppMethodBeat.o(226590);
    }

    private void wv(int i2) {
        AppMethodBeat.i(226591);
        ciw().opType = BI(i2);
        cit();
        com.tencent.mm.plugin.ball.ui.c.a(this.oXA, this.oWG.getBallPosition(), new com.tencent.mm.plugin.ball.d.a() {
            /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void onAnimationEnd() {
                AppMethodBeat.i(226578);
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation end");
                g.this.oXA.hb(false);
                AppMethodBeat.o(226578);
            }

            @Override // com.tencent.mm.plugin.ball.d.a
            public final void awJ() {
                AppMethodBeat.i(226579);
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onCloseInternal, transform to float ball animation cancel");
                g.this.oXA.hb(true);
                AppMethodBeat.o(226579);
            }
        });
        AppMethodBeat.o(226591);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(226592);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onDestroy, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.onDestroy();
        if (this.lqJ != null) {
            this.lqJ.b(this.lqK);
        }
        AppMethodBeat.o(226592);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(226593);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onEnterPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(false);
        }
        AppMethodBeat.o(226593);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(226594);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onExitPage, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        if (cin() != null) {
            U(true);
            u.makeText(AndroidContextUtil.castActivityOrNull(this.kGW.mContext), (int) R.string.a3w, 0).show();
        }
        if (this.oWG != null) {
            this.oWG.q(this.oWE);
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(226581);
                final int e2 = g.e(g.this);
                if (g.this.handler != null) {
                    g.this.handler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.floatball.g.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(226580);
                            g.this.BH(e2);
                            AppMethodBeat.o(226580);
                        }
                    });
                }
                AppMethodBeat.o(226581);
            }
        }, "");
        AppMethodBeat.o(226594);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(226595);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        this.oXA.hb(true);
        AppMethodBeat.o(226595);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(226596);
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onReceivedBallInfoRemovedEvent, runtime:%s", Integer.valueOf(this.kGW.hashCode()));
        super.bCB();
        bCO();
        AppMethodBeat.o(226596);
    }

    static {
        AppMethodBeat.i(226607);
        AppMethodBeat.o(226607);
    }

    public static void bCM() {
        AppMethodBeat.i(226597);
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(19, lqt);
        }
        AppMethodBeat.o(226597);
    }

    public static void bCN() {
        AppMethodBeat.i(226598);
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(19, lqt);
        }
        AppMethodBeat.o(226598);
    }

    private void bCO() {
        AppMethodBeat.i(226599);
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class) != null) {
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
            mMBackgroundRunningOperationParcel.appId = this.kGW.mAppId;
            mMBackgroundRunningOperationParcel.beL = 16;
            mMBackgroundRunningOperationParcel.dDe = 2;
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "stopVOIP, appId:%s", this.kGW.mAppId);
            ((com.tencent.mm.plugin.appbrand.backgroundrunning.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.f.class)).a(mMBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(226599);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int bCP() {
        /*
            r8 = this;
            r3 = 32
            r1 = 1
            r2 = 0
            r7 = 226600(0x37528, float:3.17534E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.mm.plugin.appbrand.q r0 = r8.kGW
            if (r0 == 0) goto L_0x0043
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q r0 = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q$d r4 = r0.qth
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q$d r5 = com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.d.InRoom
            if (r4 != r5) goto L_0x0039
            com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f r0 = r0.qte
            com.tencent.mm.audio.b.c r4 = r0.qrH
            if (r4 == 0) goto L_0x0039
            boolean r0 = r0.qrU
        L_0x001e:
            if (r0 != 0) goto L_0x003b
            r0 = r1
        L_0x0021:
            java.lang.String r4 = "MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper"
            java.lang.String r5 = "getCurrentVOIPState, enableMic:%s"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r1[r2] = r6
            com.tencent.mm.sdk.platformtools.Log.i(r4, r5, r1)
            if (r0 == 0) goto L_0x003d
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r3
        L_0x0038:
            return r0
        L_0x0039:
            r0 = r2
            goto L_0x001e
        L_0x003b:
            r0 = r2
            goto L_0x0021
        L_0x003d:
            r0 = 64
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            goto L_0x0038
        L_0x0043:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r3
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.floatball.g.bCP():int");
    }

    static /* synthetic */ void f(BallInfo ballInfo) {
        r rVar;
        AppMethodBeat.i(226605);
        if (ballInfo != null && ballInfo.type == 19) {
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
            String string = ballInfo.jkf.getString("appId");
            String string2 = ballInfo.jkf.getString(ch.COL_USERNAME);
            int i2 = ballInfo.jkf.getInt("versionType");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1131;
            if ((!Util.isNullOrNil(string2) || !Util.isNullOrNil(string)) && (rVar = (r) com.tencent.mm.kernel.g.af(r.class)) != null) {
                Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "openAppBrand, launch:%s#%s", string, Integer.valueOf(i2));
                rVar.a(MMApplicationContext.getContext(), string2, string, i2, -1, (String) null, appBrandStatObject);
            }
        }
        AppMethodBeat.o(226605);
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(226606);
        if (!gVar.ciq()) {
            Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onVOIPStateChanged, add passive float ball");
            gVar.jT(true);
            gVar.jU(false);
            gVar.BH(gVar.bCP());
            gVar.cis();
            AppMethodBeat.o(226606);
            return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "onVOIPStateChanged, already add this float ball, so update state");
        gVar.BH(gVar.bCP());
        AppMethodBeat.o(226606);
    }
}
