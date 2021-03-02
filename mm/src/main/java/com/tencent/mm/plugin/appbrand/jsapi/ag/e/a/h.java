package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.BottomSheetBehavior;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.g.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.Map;
import kotlin.a.ae;
import rx.d;

public final class h {
    public static final a mMx = new a((byte) 0);
    private final com.tencent.mm.plugin.appbrand.jsapi.ag.e.b cJc;
    private final Context context;
    public int dYn = -1;
    private final com.tencent.luggage.xweb_ext.extendplugin.a mKR;
    public final j mLW = new j();
    private g mMl;
    private c mMm = ((c) com.tencent.luggage.a.e.M(c.class));
    public kotlin.g.a.a<kotlin.x> mMn;
    private int mMo;
    private boolean mMp;
    private final MTimerHandler mMq;
    private kotlin.g.a.a<kotlin.x> mMr;
    private final x mMs;
    final MTimerHandler mMt;
    private boolean mMu;
    private final MTimerHandler mMv;
    public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a mMw;

    static {
        AppMethodBeat.i(139781);
        AppMethodBeat.o(139781);
    }

    public static final class g extends kotlin.g.b.q implements kotlin.g.a.b<e.a, kotlin.x> {
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(h hVar) {
            super(1);
            this.mMz = hVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(e.a aVar) {
            AppMethodBeat.i(139721);
            b(aVar);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(139721);
            return xVar;
        }

        public final void b(e.a aVar) {
            AppMethodBeat.i(139722);
            kotlin.g.b.p.h(aVar, "state");
            this.mMz.mLW.bMs().a(aVar);
            AppMethodBeat.o(139722);
        }
    }

    public static final class i extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        public static final i mMB = new i();

        static {
            AppMethodBeat.i(139727);
            AppMethodBeat.o(139727);
        }

        i() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(139726);
            bool.booleanValue();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(139726);
            return xVar;
        }
    }

    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(h hVar) {
            super(1);
            this.mMz = hVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(139747);
            boolean booleanValue = bool.booleanValue();
            Log.i("MicroMsg.VideoCast.VideoCastController", "reconnect: isSuccess = ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                this.mMz.es(this.mMz.mMo, 5);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(139747);
            return xVar;
        }
    }

    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        public static final v mMR = new v();

        static {
            AppMethodBeat.i(184882);
            AppMethodBeat.o(184882);
        }

        v() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(184881);
            bool.booleanValue();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(184881);
            return xVar;
        }
    }

    public h(com.tencent.luggage.xweb_ext.extendplugin.a aVar, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a aVar2, com.tencent.mm.plugin.appbrand.jsapi.ag.e.b bVar) {
        kotlin.g.b.p.h(aVar, "invokeContext");
        kotlin.g.b.p.h(aVar2, "eventHandler");
        kotlin.g.b.p.h(bVar, "videoCastHandler");
        AppMethodBeat.i(139780);
        this.mKR = aVar;
        this.mMw = aVar2;
        this.cJc = bVar;
        Context context2 = this.mKR.getContext();
        kotlin.g.b.p.g(context2, "invokeContext.context");
        this.context = context2;
        this.mMq = new MTimerHandler(new n(this), false);
        this.mMs = new x(this);
        this.mMt = new MTimerHandler(new o(this), true);
        this.mMv = new MTimerHandler(new C0618h(this), true);
        AppMethodBeat.o(139780);
    }

    public static final /* synthetic */ g e(h hVar) {
        AppMethodBeat.i(139782);
        g gVar = hVar.mMl;
        if (gVar == null) {
            kotlin.g.b.p.btv("selectDeviceBottomSheet");
        }
        AppMethodBeat.o(139782);
        return gVar;
    }

    public static final /* synthetic */ void n(h hVar) {
        AppMethodBeat.i(139785);
        hVar.bMp();
        AppMethodBeat.o(139785);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public class c implements com.tencent.mm.plugin.appbrand.g.c.a.a {
        public c() {
            h.this = r1;
        }

        @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
        public void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139714);
            kotlin.g.b.p.h(eVar, "response");
            AppMethodBeat.o(139714);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
        public void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
        }
    }

    public static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(139769);
        hVar.x(true, false);
        AppMethodBeat.o(139769);
    }

    public static final class q implements Runnable {
        final /* synthetic */ boolean mMK;
        final /* synthetic */ boolean mML;
        final /* synthetic */ h mMz;

        q(h hVar, boolean z, boolean z2) {
            this.mMz = hVar;
            this.mMK = z;
            this.mML = z2;
        }

        public final void run() {
            View decorView;
            BottomSheetBehavior<?> bottomSheetBehavior;
            View decorView2;
            boolean z = false;
            AppMethodBeat.i(139752);
            this.mMz.mMl = new g(this.mMz.context, this.mMz.cJc, this.mMz.mLW, this.mMK, (byte) 0);
            h.e(this.mMz).mLU = new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.q.AnonymousClass1 */
                final /* synthetic */ q mMM;

                {
                    this.mMM = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(139748);
                    c cVar = this.mMM.mMz.mMm;
                    if (cVar != null) {
                        cVar.xV(7);
                    }
                    String str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/readtemplate?t=weapp/airplay_intro_tmpl&appid=" + d.A(this.mMM.mMz.mKR).getAppId();
                    b bVar = (b) com.tencent.luggage.a.e.M(b.class);
                    if (bVar != null) {
                        com.tencent.mm.plugin.appbrand.jsapi.f NN = this.mMM.mMz.mKR.NN();
                        kotlin.g.b.p.g(NN, "invokeContext.component");
                        Context context = this.mMM.mMz.mKR.getContext();
                        kotlin.g.b.p.g(context, "invokeContext.context");
                        bVar.a(NN, str, context);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(139748);
                    return xVar;
                }
            };
            g e2 = h.e(this.mMz);
            AnonymousClass2 r0 = new kotlin.g.a.b<Integer, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.q.AnonymousClass2 */
                final /* synthetic */ q mMM;

                {
                    this.mMM = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(Integer num) {
                    AppMethodBeat.i(139749);
                    int intValue = num.intValue();
                    int i2 = this.mMM.mMK ? 4 : 2;
                    c cVar = this.mMM.mMz.mMm;
                    if (cVar != null) {
                        cVar.er(intValue, i2);
                    }
                    this.mMM.mMz.mLW.mMX.clear();
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(139749);
                    return xVar;
                }
            };
            kotlin.g.b.p.h(r0, "<set-?>");
            e2.mLT = r0;
            h.e(this.mMz).mLR = new kotlin.g.a.m<com.tencent.mm.plugin.appbrand.g.b.c, Integer, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.q.AnonymousClass3 */
                final /* synthetic */ q mMM;

                {
                    this.mMM = r2;
                }

                @Override // kotlin.g.a.m
                public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.appbrand.g.b.c cVar, Integer num) {
                    kotlin.g.a.a<kotlin.x> aVar;
                    AppMethodBeat.i(139751);
                    com.tencent.mm.plugin.appbrand.g.b.c cVar2 = cVar;
                    num.intValue();
                    if (cVar2 == null) {
                        this.mMM.mMz.mMw.ch(false);
                        h.e(this.mMM.mMz).mLR = null;
                        h.e(this.mMM.mMz).bMo();
                    } else {
                        this.mMM.mMz.mMw.ch(true);
                        if (!(this.mMM.mMz.mMn == null || (aVar = this.mMM.mMz.mMn) == null)) {
                            aVar.invoke();
                        }
                        this.mMM.mMz.mLW.g(cVar2);
                        this.mMM.mMz.dYn = 3;
                        if (this.mMM.mML) {
                            com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new Runnable(this) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.q.AnonymousClass3.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass3 mMN;

                                {
                                    this.mMN = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(139750);
                                    h.e(this.mMN.mMM.mMz).bMo();
                                    AppMethodBeat.o(139750);
                                }
                            });
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(139751);
                    return xVar;
                }
            };
            g e3 = h.e(this.mMz);
            e3.mLL = e3.isLandscape();
            e3.mLM = e3.getRotation();
            if (e3.mLH != null) {
                View view = e3.lJI;
                if (view == null) {
                    kotlin.g.b.p.btv("rootView");
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    AppMethodBeat.o(139752);
                    throw tVar;
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (e3.mLP) {
                    e3.mLJ = (int) (((double) at.aH(e3.mContext, R.dimen.u2)) * 6.5d);
                }
                layoutParams2.height = e3.mLJ;
                if (e3.mLL && e3.qK != null) {
                    Rect rect = new Rect();
                    View view2 = e3.qK;
                    if (view2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    view2.getWindowVisibleDisplayFrame(rect);
                    if (e3.mLP) {
                        layoutParams2.width = (int) (((((float) rect.right) * 1.0f) * 4.0f) / 10.0f);
                        if (e3.mLQ != 0) {
                            layoutParams2.width = e3.mLQ;
                        }
                        if (au.jX(e3.mContext)) {
                            layoutParams2.height = rect.bottom - au.ay(e3.mContext);
                        } else {
                            layoutParams2.height = rect.bottom;
                        }
                    } else {
                        layoutParams2.width = rect.right;
                    }
                }
                View view3 = e3.lJI;
                if (view3 == null) {
                    kotlin.g.b.p.btv("rootView");
                }
                view3.setLayoutParams(layoutParams2);
                if (Build.VERSION.SDK_INT >= 21) {
                    Dialog dialog = e3.mLH;
                    if (dialog == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.addFlags(Integer.MIN_VALUE);
                    }
                }
                if (e3.mLN) {
                    Dialog dialog2 = e3.mLH;
                    if (dialog2 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window2 = dialog2.getWindow();
                    if (window2 != null) {
                        window2.addFlags(1024);
                    }
                }
                if (e3.mLO) {
                    Dialog dialog3 = e3.mLH;
                    if (dialog3 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window3 = dialog3.getWindow();
                    if (window3 != null) {
                        window3.setFlags(8, 8);
                    }
                    Dialog dialog4 = e3.mLH;
                    if (dialog4 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window4 = dialog4.getWindow();
                    if (window4 != null) {
                        window4.addFlags(131200);
                    }
                    Dialog dialog5 = e3.mLH;
                    if (dialog5 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window5 = dialog5.getWindow();
                    if (!(window5 == null || (decorView2 = window5.getDecorView()) == null)) {
                        decorView2.setSystemUiVisibility(6);
                    }
                } else {
                    Dialog dialog6 = e3.mLH;
                    if (dialog6 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window6 = dialog6.getWindow();
                    if (window6 != null) {
                        window6.clearFlags(8);
                    }
                    Dialog dialog7 = e3.mLH;
                    if (dialog7 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window7 = dialog7.getWindow();
                    if (window7 != null) {
                        window7.clearFlags(131072);
                    }
                    Dialog dialog8 = e3.mLH;
                    if (dialog8 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window8 = dialog8.getWindow();
                    if (window8 != null) {
                        window8.clearFlags(128);
                    }
                    Dialog dialog9 = e3.mLH;
                    if (dialog9 == null) {
                        kotlin.g.b.p.btv("mBottomSheetDialog");
                    }
                    Window window9 = dialog9.getWindow();
                    if (!(window9 == null || (decorView = window9.getDecorView()) == null)) {
                        decorView.setSystemUiVisibility(0);
                    }
                }
                if (!(e3.mLK == null || (bottomSheetBehavior = e3.mLK) == null)) {
                    bottomSheetBehavior.u(false);
                }
                if (e3.qK != null) {
                    if (e3.afI == null) {
                        z = true;
                    }
                    View view4 = e3.qK;
                    if (view4 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    e3.afI = view4.getViewTreeObserver();
                    if (z) {
                        ViewTreeObserver viewTreeObserver = e3.afI;
                        if (viewTreeObserver == null) {
                            kotlin.g.b.p.hyc();
                        }
                        viewTreeObserver.addOnGlobalLayoutListener(e3);
                    }
                }
                if (e3.mContext instanceof Activity) {
                    Context context = e3.mContext;
                    if (context == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(139752);
                        throw tVar2;
                    } else if (!((Activity) context).isFinishing()) {
                        Dialog dialog10 = e3.mLH;
                        if (dialog10 == null) {
                            kotlin.g.b.p.btv("mBottomSheetDialog");
                        }
                        dialog10.show();
                    }
                }
            }
            AppMethodBeat.o(139752);
        }
    }

    public final void x(boolean z, boolean z2) {
        AppMethodBeat.i(139768);
        MMHandlerThread.postToMainThread(new q(this, z2, z));
        if (!z2) {
            this.mLW.clear();
        }
        this.mLW.mMW = new r(this);
        if (!com.tencent.luggage.h.h.aO(MMApplicationContext.getContext())) {
            Toast.makeText(this.context, com.tencent.mm.cb.a.aI(this.context, R.string.sm), 0).show();
            Log.w("MicroMsg.VideoCast.VideoCastController", "searchDevice: wifi is not connected");
        }
        this.mLW.bMt();
        AppMethodBeat.o(139768);
    }

    /* access modifiers changed from: package-private */
    public static final class n implements MTimerHandler.CallBack {
        final /* synthetic */ h mMz;

        n(h hVar) {
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(139745);
            if (this.mMz.mMp) {
                AppMethodBeat.o(139745);
                return false;
            }
            this.mMz.mMw.cg(false);
            AppMethodBeat.o(139745);
            return true;
        }
    }

    public static /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(139771);
        hVar.es(-1, -1);
        AppMethodBeat.o(139771);
    }

    public final void es(int i2, int i3) {
        AppMethodBeat.i(139770);
        this.dYn = i3;
        this.mMp = false;
        e.a bBp = this.mLW.bMs().bBp();
        k kVar = new k(this, i2);
        l lVar = new l(this, kVar, i3);
        m mVar = new m(this, kVar, i3);
        if (bBp == e.a.Paused) {
            Log.i("MicroMsg.VideoCast.VideoCastController", "play: continue");
            lVar.invoke();
            this.mMw.onVideoWaiting();
            AppMethodBeat.o(139770);
            return;
        }
        Log.i("MicroMsg.VideoCast.VideoCastController", "play: playNew");
        mVar.invoke();
        this.mMw.onVideoWaiting();
        AppMethodBeat.o(139770);
    }

    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int mMC;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(h hVar, int i2) {
            super(0);
            this.mMz = hVar;
            this.mMC = i2;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(139732);
            if (this.mMC <= 0) {
                AppMethodBeat.o(139732);
                return;
            }
            this.mMz.mMr = new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.k.AnonymousClass1 */
                final /* synthetic */ k mMD;

                {
                    this.mMD = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(139730);
                    h hVar = this.mMD.mMz;
                    b.c cVar = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.mKS;
                    hVar.abP(b.c.xU(this.mMD.mMC));
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(139730);
                    return xVar;
                }
            };
            AppMethodBeat.o(139732);
        }
    }

    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ k mME;
        final /* synthetic */ int mMF;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(h hVar, k kVar, int i2) {
            super(0);
            this.mMz = hVar;
            this.mME = kVar;
            this.mMF = i2;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(139736);
            this.mMz.mLW.bMs().a(new c(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.l.AnonymousClass1 */
                final /* synthetic */ l mMG;

                {
                    this.mMG = r2;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(139733);
                    kotlin.g.b.p.h(eVar, "response");
                    Log.i("MicroMsg.VideoCast.VideoCastController", "play success, url = [%s]", this.mMG.mMz.cJc.videoPath);
                    this.mMG.mME.invoke();
                    AppMethodBeat.o(139733);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(139734);
                    super.a(eVar);
                    Log.e("MicroMsg.VideoCast.VideoCastController", "play fail");
                    b bVar = new b(a.ACTION_ERROR);
                    bVar.obj = Integer.valueOf(this.mMG.mMF);
                    h.a(this.mMG.mMz, bVar);
                    AppMethodBeat.o(139734);
                }
            });
            AppMethodBeat.o(139736);
        }
    }

    public static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ k mME;
        final /* synthetic */ int mMF;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(h hVar, k kVar, int i2) {
            super(0);
            this.mMz = hVar;
            this.mME = kVar;
            this.mMF = i2;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(139744);
            this.mMz.mLW.bMs().c(new c(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.m.AnonymousClass1 */
                final /* synthetic */ m mMH;

                {
                    this.mMH = r2;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(139741);
                    kotlin.g.b.p.h(eVar, "response");
                    Log.i("MicroMsg.VideoCast.VideoCastController", "playNew: stop success");
                    this.mMH.mMz.mLW.bMs().a(e.a.Stopped);
                    this.mMH.mMz.mLW.bMs().a(this.mMH.mMz.cJc.videoPath, new a(this));
                    AppMethodBeat.o(139741);
                }

                /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h$m$1$a */
                public static final class a extends c {
                    final /* synthetic */ AnonymousClass1 mMI;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(AnonymousClass1 r2) {
                        super();
                        this.mMI = r2;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                    public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                        AppMethodBeat.i(139739);
                        kotlin.g.b.p.h(eVar, "response");
                        Log.i("MicroMsg.VideoCast.VideoCastController", "playNew: setAvTransUrl success");
                        this.mMI.mMH.mMz.mLW.bMs().a(e.a.Transitioning);
                        this.mMI.mMH.mMz.mLW.bMs().a(new C0619a(this));
                        AppMethodBeat.o(139739);
                    }

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h$m$1$a$a */
                    public static final class C0619a extends c {
                        final /* synthetic */ a mMJ;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        C0619a(a aVar) {
                            super();
                            this.mMJ = aVar;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                            AppMethodBeat.i(139737);
                            kotlin.g.b.p.h(eVar, "response");
                            Log.i("MicroMsg.VideoCast.VideoCastController", "play new success");
                            this.mMJ.mMI.mMH.mMz.mLW.bMs().a(this.mMJ.mMI.mMH.mMz.mMs);
                            this.mMJ.mMI.mMH.mMz.mLW.bMs().a(e.a.Playing);
                            this.mMJ.mMI.mMH.mMz.mLW.bMs().bBq();
                            this.mMJ.mMI.mMH.mMz.mLW.bMs().bBr();
                            this.mMJ.mMI.mMH.mME.invoke();
                            AppMethodBeat.o(139737);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                            AppMethodBeat.i(139738);
                            super.a(eVar);
                            Log.e("MicroMsg.VideoCast.VideoCastController", "play new fail" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
                            b bVar = new b(a.ACTION_ERROR);
                            bVar.obj = Integer.valueOf(this.mMJ.mMI.mMH.mMF);
                            h.a(this.mMJ.mMI.mMH.mMz, bVar);
                            AppMethodBeat.o(139738);
                        }
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                    public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                        AppMethodBeat.i(139740);
                        super.a(eVar);
                        Log.e("MicroMsg.VideoCast.VideoCastController", "set AVTransportURI fail" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
                        b bVar = new b(a.ACTION_ERROR);
                        bVar.obj = Integer.valueOf(this.mMI.mMH.mMF);
                        h.a(this.mMI.mMH.mMz, bVar);
                        AppMethodBeat.o(139740);
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(139742);
                    super.a(eVar);
                    Log.e("MicroMsg.VideoCast.VideoCastController", "stop fail before play new" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
                    AppMethodBeat.o(139742);
                }
            });
            AppMethodBeat.o(139744);
        }
    }

    public static final class x implements com.tencent.mm.plugin.appbrand.g.b.d {
        final /* synthetic */ h mMz;

        x(h hVar) {
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void d(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(139762);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_PLAYING));
            }
            AppMethodBeat.o(139762);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void e(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(139763);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_PAUSED));
            }
            AppMethodBeat.o(139763);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void f(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(139764);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_STOPPED));
            }
            AppMethodBeat.o(139764);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void a(com.tencent.mm.plugin.appbrand.g.b.c cVar, int i2) {
            AppMethodBeat.i(139765);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_VOLUME, Integer.valueOf(i2)));
            }
            AppMethodBeat.o(139765);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void a(com.tencent.mm.plugin.appbrand.g.b.c cVar, boolean z) {
            AppMethodBeat.i(139766);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_MUTE, Boolean.valueOf(z)));
            }
            AppMethodBeat.o(139766);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.d
        public final void b(com.tencent.mm.plugin.appbrand.g.b.c cVar, int i2) {
            AppMethodBeat.i(139767);
            kotlin.g.b.p.h(cVar, "device");
            if (kotlin.g.b.p.j(cVar, this.mMz.mLW.bMs())) {
                h.a(this.mMz, new b(a.ACTION_PROGRESS, Integer.valueOf(i2)));
            }
            AppMethodBeat.o(139767);
        }
    }

    public static final class t implements rx.b.a {
        final /* synthetic */ b mMQ;
        final /* synthetic */ h mMz;

        t(h hVar, b bVar) {
            this.mMz = hVar;
            this.mMQ = bVar;
        }

        @Override // rx.b.a
        public final void call() {
            AppMethodBeat.i(139757);
            h.b(this.mMz, this.mMQ);
            AppMethodBeat.o(139757);
        }
    }

    public static final class s extends c {
        final /* synthetic */ String mMP;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(h hVar, String str) {
            super();
            this.mMz = hVar;
            this.mMP = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139755);
            kotlin.g.b.p.h(eVar, "response");
            Log.i("MicroMsg.VideoCast.VideoCastController", "seek to " + this.mMP + " success");
            AppMethodBeat.o(139755);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139756);
            super.a(eVar);
            Log.i("MicroMsg.VideoCast.VideoCastController", "seek fail");
            AppMethodBeat.o(139756);
        }
    }

    public final void abP(String str) {
        AppMethodBeat.i(139772);
        kotlin.g.b.p.h(str, "moment");
        this.mLW.bMs().b(str, new s(this, str));
        AppMethodBeat.o(139772);
    }

    /* access modifiers changed from: package-private */
    public static final class o implements MTimerHandler.CallBack {
        final /* synthetic */ h mMz;

        o(h hVar) {
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(139746);
            h.q(this.mMz);
            AppMethodBeat.o(139746);
            return true;
        }
    }

    public static final class e extends c {
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super();
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139717);
            kotlin.g.b.p.h(eVar, "response");
            Map map = eVar.llq;
            if (map == null || map.isEmpty()) {
                AppMethodBeat.o(139717);
                return;
            }
            if (map.containsKey("RelTime") && map.containsKey("TrackDuration")) {
                String value = ((com.tencent.mm.plugin.appbrand.g.c.b.a) ae.e(map, "RelTime")).getValue();
                String value2 = ((com.tencent.mm.plugin.appbrand.g.c.b.a) ae.e(map, "TrackDuration")).getValue();
                Log.i("MicroMsg.VideoCast.VideoCastController", "getProgressTimeMs: relTime = " + value + ", duration =  " + value2);
                b.c cVar = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.mKS;
                int abN = (int) b.c.abN(value);
                b.c cVar2 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.mKS;
                int abN2 = (int) b.c.abN(value2);
                this.mMz.mMo = abN;
                this.mMz.mMw.bZ(abN, abN2);
                this.mMz.mMw.ie((int) ((((double) abN) / ((double) abN2)) * 100.0d));
                StringBuilder sb = new StringBuilder("get position success, relTime: ");
                b.c cVar3 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.mKS;
                StringBuilder append = sb.append((int) b.c.abN(value)).append(' ').append("duration: ");
                b.c cVar4 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.mKS;
                Log.i("MicroMsg.VideoCast.VideoCastController", append.append((int) b.c.abN(value2)).toString());
            }
            AppMethodBeat.o(139717);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139718);
            super.a(eVar);
            Log.e("MicroMsg.VideoCast.VideoCastController", "get position  fail" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
            b bVar = new b(a.ACTION_ERROR);
            this.mMz.mMt.stopTimer();
            h.a(this.mMz, bVar);
            AppMethodBeat.o(139718);
        }
    }

    public static final class j extends c {
        final /* synthetic */ kotlin.g.a.b hSE;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(h hVar, kotlin.g.a.b bVar) {
            super();
            this.mMz = hVar;
            this.hSE = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139728);
            kotlin.g.b.p.h(eVar, "response");
            Log.i("MicroMsg.VideoCast.VideoCastController", "pause success");
            this.mMz.mLW.bMs().a(e.a.Paused);
            this.hSE.invoke(Boolean.TRUE);
            AppMethodBeat.o(139728);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139729);
            super.a(eVar);
            Log.e("MicroMsg.VideoCast.VideoCastController", "pause fail" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
            this.hSE.invoke(Boolean.FALSE);
            AppMethodBeat.o(139729);
        }
    }

    public static /* synthetic */ void c(h hVar) {
        AppMethodBeat.i(139773);
        i iVar = i.mMB;
        kotlin.g.b.p.h(iVar, NativeProtocol.WEB_DIALOG_ACTION);
        hVar.mLW.bMs().b(new j(hVar, iVar));
        AppMethodBeat.o(139773);
    }

    public static final class w extends c {
        final /* synthetic */ kotlin.g.a.b hSE;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(h hVar, kotlin.g.a.b bVar) {
            super();
            this.mMz = hVar;
            this.hSE = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(184883);
            kotlin.g.b.p.h(eVar, "response");
            Log.i("MicroMsg.VideoCast.VideoCastController", "stop success");
            this.mMz.mLW.bMs().a(e.a.Stopped);
            h.n(this.mMz);
            this.mMz.mMt.stopTimer();
            this.hSE.invoke(Boolean.TRUE);
            AppMethodBeat.o(184883);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(184884);
            super.a(eVar);
            Log.e("MicroMsg.VideoCast.VideoCastController", "stop fail" + (eVar != null ? Integer.valueOf(eVar.responseCode) : ""));
            this.hSE.invoke(Boolean.FALSE);
            AppMethodBeat.o(184884);
        }
    }

    public static /* synthetic */ void d(h hVar) {
        AppMethodBeat.i(184886);
        hVar.t(v.mMR);
        AppMethodBeat.o(184886);
    }

    public final void t(kotlin.g.a.b<? super Boolean, kotlin.x> bVar) {
        AppMethodBeat.i(184885);
        kotlin.g.b.p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        this.mLW.bMs().c(new w(this, bVar));
        AppMethodBeat.o(184885);
    }

    private final void bMp() {
        AppMethodBeat.i(139774);
        this.mLW.bMs().bBs();
        this.mLW.bMs().bBt();
        this.mLW.bMs().a((com.tencent.mm.plugin.appbrand.g.b.d) null);
        AppMethodBeat.o(139774);
    }

    public final void destroy() {
        AppMethodBeat.i(139775);
        Log.i("MicroMsg.VideoCast.VideoCastController", "onDestroy");
        MMHandlerThread.postToMainThread(new d(this));
        bMp();
        this.mMt.stopTimer();
        this.mLW.clear();
        bMr();
        this.mMq.stopTimer();
        AppMethodBeat.o(139775);
    }

    public static final class d implements Runnable {
        final /* synthetic */ h mMz;

        d(h hVar) {
            this.mMz = hVar;
        }

        public final void run() {
            AppMethodBeat.i(139716);
            if (this.mMz.mMl != null) {
                h.e(this.mMz).bMo();
            }
            AppMethodBeat.o(139716);
        }
    }

    public static final class u extends c {
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(h hVar) {
            super();
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139758);
            kotlin.g.b.p.h(eVar, "response");
            Log.i("MicroMsg.VideoCast.VideoCastController", "setVolume success");
            AppMethodBeat.o(139758);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139759);
            super.a(eVar);
            if (eVar != null) {
                Log.e("MicroMsg.VideoCast.VideoCastController", "setVolume fail:" + eVar.responseCode);
                Log.e("MicroMsg.VideoCast.VideoCastController", "setVolume fail:" + eVar.responseCode);
            }
            AppMethodBeat.o(139759);
        }
    }

    public final void setVolume(int i2) {
        AppMethodBeat.i(139776);
        Log.i("MicroMsg.VideoCast.VideoCastController", "setVolume: ".concat(String.valueOf(i2)));
        this.mLW.bMs().a(i2, new u(this));
        AppMethodBeat.o(139776);
    }

    public static final class f extends c {
        final /* synthetic */ kotlin.g.a.b hSE;
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(h hVar, kotlin.g.a.b bVar) {
            super();
            this.mMz = hVar;
            this.hSE = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            com.tencent.mm.plugin.appbrand.g.c.b.a aVar;
            AppMethodBeat.i(139719);
            kotlin.g.b.p.h(eVar, "response");
            Map map = eVar.llq;
            String value = (map == null || (aVar = (com.tencent.mm.plugin.appbrand.g.c.b.a) map.get("CurrentVolume")) == null) ? null : aVar.getValue();
            if (!TextUtils.isEmpty(value)) {
                f fVar = new f();
                if (value == null) {
                    kotlin.g.b.p.hyc();
                }
                fVar.value = (T) Integer.valueOf(Integer.parseInt(value));
                this.hSE.invoke(fVar);
            }
            Log.i("MicroMsg.VideoCast.VideoCastController", "get volume success : ".concat(String.valueOf(value)));
            AppMethodBeat.o(139719);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.c, com.tencent.mm.plugin.appbrand.g.c.a.a
        public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
            AppMethodBeat.i(139720);
            super.a(eVar);
            if (eVar != null) {
                Log.e("MicroMsg.VideoCast.VideoCastController", "get volume  fail" + eVar.responseCode);
            }
            AppMethodBeat.o(139720);
        }
    }

    public final void u(kotlin.g.a.b<? super f<Integer>, kotlin.x> bVar) {
        AppMethodBeat.i(139777);
        kotlin.g.b.p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        this.mLW.bMs().d(new f(this, bVar));
        AppMethodBeat.o(139777);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h$h */
    public static final class C0618h implements MTimerHandler.CallBack {
        final /* synthetic */ h mMz;

        C0618h(h hVar) {
            this.mMz = hVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(139725);
            this.mMz.mLW.bMs().f(new com.tencent.mm.plugin.appbrand.g.c.a.a(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.C0618h.AnonymousClass1 */
                final /* synthetic */ C0618h mMA;

                {
                    this.mMA = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    Map map;
                    com.tencent.mm.plugin.appbrand.g.c.b.a aVar;
                    AppMethodBeat.i(139723);
                    if (this.mMA.mMz.mMu) {
                        AppMethodBeat.o(139723);
                        return;
                    }
                    String valueOf = String.valueOf((eVar == null || (map = eVar.llq) == null || (aVar = (com.tencent.mm.plugin.appbrand.g.c.b.a) map.get("CurrentURI")) == null) ? null : aVar.getValue());
                    Log.i("MicroMsg.VideoCast.VideoCastController", "getMediaInfo: currentUrl = ".concat(String.valueOf(valueOf)));
                    if (valueOf == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(139723);
                        throw tVar;
                    } else if (kotlin.n.n.aL(kotlin.n.n.trim(valueOf).toString()) || kotlin.g.b.p.j(valueOf, BuildConfig.COMMAND)) {
                        AppMethodBeat.o(139723);
                    } else {
                        if (!kotlin.g.b.p.j(valueOf, this.mMA.mMz.cJc.videoPath)) {
                            this.mMA.mMz.mMw.QB();
                        }
                        AppMethodBeat.o(139723);
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(139724);
                    Log.i("MicroMsg.VideoCast.VideoCastController", "getMediaInfo fail");
                    this.mMA.mMz.mMu = true;
                    AppMethodBeat.o(139724);
                }
            });
            AppMethodBeat.o(139725);
            return true;
        }
    }

    public final void bMq() {
        AppMethodBeat.i(139778);
        if (this.mMv.stopped()) {
            this.mMu = false;
            this.mMv.startTimer(5000);
        }
        AppMethodBeat.o(139778);
    }

    public final void bMr() {
        AppMethodBeat.i(139779);
        if (this.mMv.stopped()) {
            AppMethodBeat.o(139779);
            return;
        }
        this.mMv.stopTimer();
        this.mMu = true;
        AppMethodBeat.o(139779);
    }

    public static final class b {
        a mMy;
        Object obj;

        public b(a aVar) {
            kotlin.g.b.p.h(aVar, "eventType");
            AppMethodBeat.i(139712);
            this.mMy = aVar;
            AppMethodBeat.o(139712);
        }

        public b(a aVar, Object obj2) {
            kotlin.g.b.p.h(aVar, "eventType");
            kotlin.g.b.p.h(obj2, "obj");
            AppMethodBeat.i(139713);
            this.mMy = aVar;
            this.obj = obj2;
            AppMethodBeat.o(139713);
        }
    }

    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ h mMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(h hVar) {
            super(0);
            this.mMz = hVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(139754);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h.r.AnonymousClass1 */
                final /* synthetic */ r mMO;

                {
                    this.mMO = r1;
                }

                public final void run() {
                    AppMethodBeat.i(139753);
                    g e2 = h.e(this.mMO.mMz);
                    if (e2.isShowing() && e2.mLH != null) {
                        g.b bVar = e2.mLI;
                        if (bVar == null) {
                            kotlin.g.b.p.btv("recycleViewAdapter");
                        }
                        bVar.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(139753);
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(139754);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(h hVar, b bVar) {
        AppMethodBeat.i(139783);
        synchronized (h.class) {
            try {
                rx.d.a(new rx.internal.util.a(rx.b.c.hQD(), rx.internal.util.c.Une, rx.b.c.hQD()), rx.internal.a.b.hQF().a(com.tencent.mm.plugin.appbrand.g.d.a.bBF()).a((d.b) new rx.internal.a.i(new rx.internal.util.a(rx.b.c.hQD(), rx.b.c.hQD(), new t(hVar, bVar)))));
            } finally {
                AppMethodBeat.o(139783);
            }
        }
    }

    public static final /* synthetic */ void b(h hVar, b bVar) {
        c cVar;
        String str;
        String str2;
        c cVar2;
        String str3;
        String str4;
        int i2 = -1;
        AppMethodBeat.i(139784);
        Log.i("MicroMsg.VideoCast.VideoCastController", "handleBroadcast: " + bVar.mMy.name());
        g gVar = new g(hVar);
        switch (i.$EnumSwitchMapping$0[bVar.mMy.ordinal()]) {
            case 1:
                AppMethodBeat.o(139784);
                return;
            case 2:
                hVar.mLW.bMs().a(e.a.Playing);
                hVar.bMq();
                gVar.b(e.a.Playing);
                hVar.mMq.stopTimer();
                hVar.mMp = true;
                hVar.mMw.onVideoPlay();
                hVar.mMt.startTimer(1000);
                hVar.cJc.hV(true);
                hVar.mMw.cg(true);
                hVar.mLW.bMy();
                if (hVar.mMr != null) {
                    kotlin.g.a.a<kotlin.x> aVar = hVar.mMr;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    hVar.mMr = null;
                }
                if (hVar.dYn == 3) {
                    c cVar3 = hVar.mMm;
                    if (cVar3 != null) {
                        com.tencent.mm.plugin.appbrand.g.b.b bBo = hVar.mLW.bMs().bBo();
                        if (bBo == null || (str3 = bBo.ljR) == null) {
                            str3 = "";
                        }
                        com.tencent.mm.plugin.appbrand.g.b.b bBo2 = hVar.mLW.bMs().bBo();
                        if (bBo2 == null || (str4 = bBo2.ljQ) == null) {
                            str4 = "";
                        }
                        cVar3.a(true, str3, str4, hVar.dYn);
                    }
                } else if (hVar.dYn == 5 || hVar.dYn == 8) {
                    c cVar4 = hVar.mMm;
                    if (cVar4 != null) {
                        c.a.a(cVar4, true, hVar.dYn);
                    }
                } else if (hVar.dYn == 8 && (cVar2 = hVar.mMm) != null) {
                    c.a.a(cVar2, true, hVar.dYn);
                }
                hVar.dYn = -1;
                AppMethodBeat.o(139784);
                return;
            case 3:
                hVar.mLW.bMs().a(e.a.Paused);
                gVar.b(e.a.Paused);
                hVar.mMw.onVideoPause();
                hVar.cJc.hV(true);
                AppMethodBeat.o(139784);
                return;
            case 4:
                hVar.mLW.bMs().a(e.a.Stopped);
                gVar.b(e.a.Stopped);
                hVar.mMw.onVideoEnded();
                hVar.cJc.hV(false);
                AppMethodBeat.o(139784);
                return;
            case 5:
                if (bVar.obj != null && (bVar.obj instanceof Integer)) {
                    Object obj = bVar.obj;
                    if (obj == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(139784);
                        throw tVar;
                    }
                    Log.i("MicroMsg.VideoCast.VideoCastController", "Receive Action : Volume = ".concat(String.valueOf(((Integer) obj).intValue())));
                    AppMethodBeat.o(139784);
                    return;
                }
            case 6:
                if (bVar.obj != null && (bVar.obj instanceof Boolean)) {
                    Object obj2 = bVar.obj;
                    if (obj2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
                        AppMethodBeat.o(139784);
                        throw tVar2;
                    }
                    Log.i("MicroMsg.VideoCast.VideoCastController", "Receive Action : Mute = ".concat(String.valueOf(((Boolean) obj2).booleanValue())));
                    AppMethodBeat.o(139784);
                    return;
                }
            case 7:
                if (hVar.mLW.bMs().bBp() != e.a.Stopped) {
                    hVar.mMw.cg(false);
                    gVar.b(e.a.Stopped);
                    hVar.mLW.bMx();
                    if (bVar.obj != null && (bVar.obj instanceof Integer)) {
                        Object obj3 = bVar.obj;
                        if (obj3 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(139784);
                            throw tVar3;
                        }
                        i2 = ((Integer) obj3).intValue();
                    }
                    if (i2 == 3) {
                        c cVar5 = hVar.mMm;
                        if (cVar5 != null) {
                            com.tencent.mm.plugin.appbrand.g.b.b bBo3 = hVar.mLW.bMs().bBo();
                            if (bBo3 == null || (str = bBo3.ljR) == null) {
                                str = "";
                            }
                            com.tencent.mm.plugin.appbrand.g.b.b bBo4 = hVar.mLW.bMs().bBo();
                            if (bBo4 == null || (str2 = bBo4.ljQ) == null) {
                                str2 = "";
                            }
                            cVar5.a(false, str, str2, i2);
                        }
                    } else if (i2 == 5 || i2 == 8) {
                        c cVar6 = hVar.mMm;
                        if (cVar6 != null) {
                            c.a.a(cVar6, false, i2);
                        }
                    } else if (i2 == 8 && (cVar = hVar.mMm) != null) {
                        c.a.a(cVar, false, i2);
                    }
                    hVar.mLW.bMs().bBs();
                    hVar.mLW.bMs().bBt();
                    hVar.mLW.bMs().a((com.tencent.mm.plugin.appbrand.g.b.d) null);
                    hVar.cJc.hV(false);
                    hVar.mMt.stopTimer();
                    hVar.mMv.stopTimer();
                    hVar.mMq.stopTimer();
                    break;
                }
                break;
        }
        AppMethodBeat.o(139784);
    }

    public static final /* synthetic */ void q(h hVar) {
        AppMethodBeat.i(139786);
        hVar.mLW.bMs().e(new e(hVar));
        AppMethodBeat.o(139786);
    }
}
