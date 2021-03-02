package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.sdk.b.a.b.c;
import com.tencent.luggage.sdk.b.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.a;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public class x extends w implements w.a {
    private FrameLayout npY;
    private volatile f npZ = bOw();
    private l nqa;
    public boolean nqb = false;
    public boolean nqc = false;
    public boolean nqd = false;
    private long nqe;
    private long nqf;
    private long nqg;
    private String nqh;
    public String nqi;
    private final c nqj;
    public final Deque<ag> nqk = new LinkedList();
    private String nql;
    private IListener<a> nqm = new IListener<a>() {
        /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass1 */

        {
            AppMethodBeat.i(160610);
            this.__eventId = a.class.getName().hashCode();
            AppMethodBeat.o(160610);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(a aVar) {
            AppMethodBeat.i(47799);
            if (aVar != null) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] receive weishi play event");
                x.a(x.this);
                g.bZS();
            }
            AppMethodBeat.o(47799);
            return false;
        }
    };
    private long nqn = 0;

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public /* synthetic */ ac a(w wVar) {
        AppMethodBeat.i(175031);
        ag bOx = bOx();
        AppMethodBeat.o(175031);
        return bOx;
    }

    static /* synthetic */ void a(x xVar) {
        AppMethodBeat.i(47835);
        xVar.bQY();
        AppMethodBeat.o(47835);
    }

    static /* synthetic */ void a(x xVar, String str, bx bxVar, w.d dVar) {
        AppMethodBeat.i(47836);
        xVar.a(str, bxVar, dVar, true);
        AppMethodBeat.o(47836);
    }

    public x(Context context, q qVar) {
        super(context, qVar);
        AppMethodBeat.i(47811);
        super.setDelegate(this);
        if (qVar.NA()) {
            this.nqj = null;
            AppMethodBeat.o(47811);
            return;
        }
        this.nqj = new c(this);
        ab.ih(((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_appbrand_page_reload_eanble, true));
        AppMethodBeat.o(47811);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Context context, q qVar, w.a aVar) {
        super(context, qVar);
        boolean z = false;
        AppMethodBeat.i(47812);
        super.setDelegate(aVar);
        if (qVar.NA()) {
            this.nqj = null;
            AppMethodBeat.o(47812);
            return;
        }
        this.nqj = new c(this);
        this.nqj.cAn = com.tencent.mm.plugin.appbrand.xweb_ext.c.cdC();
        this.nqj.cAo = !com.tencent.mm.plugin.appbrand.xweb_ext.c.cdD() ? true : z;
        this.nqj.cAp = com.tencent.mm.plugin.appbrand.xweb_ext.c.cdB();
        AppMethodBeat.o(47812);
    }

    public void setWAAutoWebViewJs(String str) {
        this.nql = str;
    }

    /* access modifiers changed from: protected */
    public f bOw() {
        AppMethodBeat.i(47813);
        com.tencent.mm.plugin.appbrand.report.model.a aVar = new com.tencent.mm.plugin.appbrand.report.model.a(getRuntime());
        AppMethodBeat.o(47813);
        return aVar;
    }

    private void bQY() {
        AppMethodBeat.i(47814);
        if (this.npY != null) {
            Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed");
            final FrameLayout frameLayout = this.npY;
            q runtime = getRuntime();
            runtime.i(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(47801);
                    frameLayout.setVisibility(8);
                    if (frameLayout.getParent() instanceof ViewGroup) {
                        ((ViewGroup) frameLayout.getParent()).removeView(frameLayout);
                    }
                    AppMethodBeat.o(47801);
                }
            }, 300);
            this.npY = null;
            ab brK = runtime.brK();
            if (brK instanceof af) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] hideWeishiCoverImageIfNeed, hide");
                ((af) brK).k(true, "");
            }
        }
        AppMethodBeat.o(47814);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public q getRuntime() {
        AppMethodBeat.i(47815);
        q qVar = (q) super.getRuntime();
        AppMethodBeat.o(47815);
        return qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x006d, code lost:
        if (com.tencent.mm.plugin.appbrand.q.kDg != false) goto L_0x006f;
     */
    @Override // com.tencent.mm.plugin.appbrand.page.w
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.x.init(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void onBackPressed() {
        AppMethodBeat.i(47817);
        if (this.nqa != null) {
            this.nqa.dismiss();
            this.nqa = null;
            AppMethodBeat.o(47817);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(47817);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final boolean a(String str, bx bxVar, w wVar, final w.d dVar) {
        AppMethodBeat.i(47818);
        com.tencent.mm.plugin.appbrand.p.a aVar = getRuntime().kAI;
        if (!aVar.bPn()) {
            aVar.a(str, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.p.a.b
                public final void a(a.d dVar) {
                    AppMethodBeat.i(47809);
                    x.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(47804);
                            dVar.proceed();
                            AppMethodBeat.o(47804);
                        }
                    });
                    AppMethodBeat.o(47809);
                }
            });
        } else {
            a(str, bxVar, dVar, false);
        }
        AppMethodBeat.o(47818);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final boolean MX() {
        return false;
    }

    private void a(final String str, final bx bxVar, final w.d dVar, final boolean z) {
        AppMethodBeat.i(47819);
        h.INSTANCE.dN(937, z ? 5 : 1);
        getRuntime().kAI.a(str, new a.b() {
            /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.appbrand.p.a.b
            public final void a(a.d dVar) {
                AppMethodBeat.i(227274);
                switch (AnonymousClass7.mfu[dVar.ordinal()]) {
                    case 1:
                        h.INSTANCE.dN(937, z ? 6 : 2);
                        x.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(227269);
                                if (z) {
                                    dVar.bQX();
                                }
                                dVar.proceed();
                                AppMethodBeat.o(227269);
                            }
                        });
                        AppMethodBeat.o(227274);
                        return;
                    case 2:
                        h.INSTANCE.dN(937, z ? 8 : 4);
                        x.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(227270);
                                if (z && x.this.nqa != null) {
                                    x.this.nqa.cancel();
                                    x.this.nqa = null;
                                }
                                dVar.cancel();
                                AppMethodBeat.o(227270);
                            }
                        });
                        AppMethodBeat.o(227274);
                        return;
                    case 3:
                        h.INSTANCE.dN(937, z ? 7 : 3);
                        x.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6.AnonymousClass3 */

                            public final void run() {
                                String str;
                                String str2;
                                AppMethodBeat.i(227273);
                                final l lVar = x.this.nqa;
                                x.this.nqa = new l(x.this.getContext());
                                AnonymousClass1 r1 = new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6.AnonymousClass3.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(227271);
                                        switch (i2) {
                                            case -1:
                                                x.a(x.this, str, bxVar, dVar);
                                                break;
                                        }
                                        AppMethodBeat.o(227271);
                                    }
                                };
                                x.this.nqa.setPositiveButton(r1);
                                x.this.nqa.setNegativeButton(r1);
                                l lVar2 = x.this.nqa;
                                x xVar = x.this;
                                AnonymousClass2 r4 = new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass6.AnonymousClass3.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(227272);
                                        if (lVar != null) {
                                            lVar.bQE();
                                        }
                                        AppMethodBeat.o(227272);
                                    }
                                };
                                p.h(xVar, "pageContainer");
                                lVar2.cAt = xVar;
                                xVar.addView(lVar2, new FrameLayout.LayoutParams(-1, -1));
                                lVar2.bringToFront();
                                AppBrandRuntime runtime = xVar.getRuntime();
                                if (runtime == null) {
                                    p.hyc();
                                }
                                com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar = lVar2.kGn;
                                if (bVar != null) {
                                    AppBrandInitConfig OU = runtime.OU();
                                    bVar.setMainTitle((OU == null || (str2 = OU.brandName) == null) ? "" : str2);
                                    bVar.setBackgroundColor(0);
                                    bVar.setForegroundStyle(true);
                                    bVar.gz(true);
                                }
                                ImageView imageView = lVar2.nok;
                                if (imageView != null) {
                                    ColorMatrix colorMatrix = new ColorMatrix();
                                    colorMatrix.setSaturation(0.0f);
                                    imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                                    com.tencent.mm.modelappbrand.a.b aXY = com.tencent.mm.modelappbrand.a.b.aXY();
                                    AppBrandInitConfig OU2 = runtime.OU();
                                    if (OU2 != null) {
                                        str = OU2.iconUrl;
                                    } else {
                                        str = null;
                                    }
                                    aXY.a(imageView, str, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                                }
                                Animation animation = lVar2.noi;
                                if (animation != null) {
                                    animation.cancel();
                                }
                                lVar2.noi = AnimationUtils.loadAnimation(lVar2.getContext(), MMFragmentActivity.a.ogm);
                                Animation animation2 = lVar2.noi;
                                if (animation2 == null) {
                                    p.hyc();
                                }
                                animation2.setAnimationListener(new l.d(lVar2, r4));
                                Animation animation3 = lVar2.noi;
                                if (animation3 == null) {
                                    p.hyc();
                                }
                                lVar2.startAnimation(animation3);
                                AppMethodBeat.o(227273);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(227274);
            }
        });
        AppMethodBeat.o(47819);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.x$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] mfu = new int[a.d.values().length];

        static {
            AppMethodBeat.i(227275);
            try {
                mfu[a.d.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mfu[a.d.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mfu[a.d.FAIL.ordinal()] = 3;
                AppMethodBeat.o(227275);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(227275);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final w.h a(t tVar, t tVar2) {
        e eVar;
        AppMethodBeat.i(175028);
        w.h a2 = super.a(tVar, tVar2);
        this.npZ.bOy();
        this.npZ.a((ag) tVar2.getCurrentPageView(), (ag) tVar.getCurrentPageView(), bx.NAVIGATE_BACK);
        getRuntime().bsq().Uo(tVar2.getCurrentUrl());
        if (this.nqj != null) {
            c cVar = this.nqj;
            p.h(tVar, "out");
            p.h(tVar2, LocaleUtil.INDONESIAN_NEWNAME);
            cVar.cAt.post(new c.RunnableC0180c(cVar));
            ac currentPageView = tVar2.getCurrentPageView();
            if (!(currentPageView == null || (eVar = (e) currentPageView.S(e.class)) == null)) {
                eVar.bLp();
            }
        }
        AppMethodBeat.o(175028);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final w.h a(t tVar, t tVar2, bx bxVar, String str, boolean z) {
        AppMethodBeat.i(227276);
        w.h a2 = super.a(tVar, tVar2, bxVar, str, z);
        this.nqn = System.currentTimeMillis();
        if ((tVar2 instanceof m) && bb.r(getRuntime())) {
            com.tencent.mm.plugin.appbrand.widget.tabbar.a tabBar = ((m) tVar2).getTabBar();
            if (tabBar == null) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic tab null");
            } else {
                Log.i("MicroMsg.AppBrandPageContainerWC", "checkSinglePageModeLogic set tab gone");
                if (tabBar.getVisibility() == 0) {
                    tabBar.setVisibility(8);
                }
            }
        }
        if (g.an(getRuntime())) {
            ac currentPageView = tVar2.getCurrentPageView();
            bQY();
            try {
                FrameLayout frameLayout = currentPageView.noq;
                this.npY = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.e6, (ViewGroup) null);
                frameLayout.addView(this.npY, -1, new FrameLayout.LayoutParams(-1, -1));
                Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, showLaunchThumb");
                g.a(getRuntime(), (ImageView) this.npY.findViewById(R.id.im6), new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.x.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(47800);
                        q runtime = x.this.getRuntime();
                        if (runtime == null) {
                            AppMethodBeat.o(47800);
                            return;
                        }
                        ab brK = runtime.brK();
                        if (brK instanceof af) {
                            Log.i("MicroMsg.AppBrandPageContainerWC", "[weishi] revealWeishiCoverImageIfNeed, hide");
                            ((af) brK).k(true, "");
                        }
                        AppMethodBeat.o(47800);
                    }
                });
            } catch (NullPointerException e2) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "revealWeishiCoverImageIfNeed, exception, hide without animation");
                bQY();
            }
        }
        if (this.nqj != null) {
            c.a(tVar2, bxVar);
        }
        AppMethodBeat.o(227276);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void a(t tVar, t tVar2, bx bxVar) {
        String str;
        e eVar;
        ag agVar = null;
        AppMethodBeat.i(47822);
        super.a(tVar, tVar2, bxVar);
        long currentTimeMillis = System.currentTimeMillis() - this.nqn;
        this.npZ.a(currentTimeMillis, bxVar);
        Log.i("MicroMsg.AppBrandPageContainerWC", "onNavigateEnd received, appId:%s, time: %d", getAppId(), Long.valueOf(currentTimeMillis));
        if (this.nqa != null) {
            this.nqa.bQE();
            this.nqa = null;
        }
        f fVar = this.npZ;
        ag agVar2 = (ag) tVar2.getCurrentPageView();
        if (tVar != null) {
            agVar = (ag) tVar.getCurrentPageView();
        }
        fVar.a(agVar2, agVar, bxVar);
        getRuntime().bsq().Uo(tVar2.getCurrentUrl());
        if (this.nqj != null) {
            c cVar = this.nqj;
            p.h(tVar2, LocaleUtil.INDONESIAN_NEWNAME);
            p.h(bxVar, "type");
            if (bx.NAVIGATE_TO == bxVar) {
                cVar.a(bxVar);
                try {
                    if (cVar.cAt.getPageCount() > cVar.cAn) {
                        tVar2.af(new d(new c.e(cVar)));
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]tryPauseRenderingOfInvisiblePages appId[" + cVar.appId + "] type[" + bxVar + "] maxKeepPageCount[" + cVar.cAn + "] keepInvisbileTabbarPagesActive[" + cVar.cAo + ']', new Object[0]);
                }
            } else if (bx.SWITCH_TAB == bxVar) {
                cVar.Oc();
            }
            ac currentPageView = tVar2.getCurrentPageView();
            if (!(currentPageView == null || (eVar = (e) currentPageView.S(e.class)) == null)) {
                eVar.bLp();
            }
            if (!(bx.SWITCH_TAB == bxVar || bx.NAVIGATE_TO == bxVar)) {
                cVar.cAt.post(new c.d(cVar, bxVar));
            }
        }
        if (tVar != null && bxVar == bx.NAVIGATE_TO && getRuntime().ON().cyA.scene == 1118 && this.nqb && !this.nqc) {
            if (tVar.getCurrentPageView() == null) {
                str = "";
            } else {
                str = tVar.getCurrentPageView().nna;
            }
            if (this.nqh != null && this.nqh.equals(str)) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime");
                this.nqe = ((ag) tVar.getCurrentPageView()).nrs.bUE();
                this.nqc = true;
            }
        }
        AppMethodBeat.o(47822);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void onReady() {
        AppMethodBeat.i(47823);
        super.onReady();
        ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
        reportStorageSizeTask.appId = getRuntime().mAppId;
        AppBrandMainProcessService.a(reportStorageSizeTask);
        AppMethodBeat.o(47823);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void onDestroy() {
        AppMethodBeat.i(47824);
        super.onDestroy();
        if (getPageCount() > 0) {
            this.npZ.c((ag) getCurrentPage().getCurrentPageView());
        }
        if (this.nqa != null) {
            this.nqa.cleanup();
            this.nqa = null;
        }
        if (this.nqm != null) {
            this.nqm.dead();
        }
        AppMethodBeat.o(47824);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void onForeground() {
        AppMethodBeat.i(47825);
        super.onForeground();
        if (getPageCount() > 0) {
            this.npZ.e((ag) getCurrentPage().getCurrentPageView());
        }
        bQZ();
        AppMethodBeat.o(47825);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final void onBackground() {
        AppMethodBeat.i(47826);
        super.onBackground();
        if (getPageCount() > 0) {
            this.npZ.d((ag) getCurrentPage().getCurrentPageView());
        }
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null)) {
            if (getRuntime().ON().cyA.scene == 1118) {
                if (this.nqb && !this.nqc) {
                    String str = getCurrentPage().getCurrentPageView().nna;
                    if (this.nqh != null && this.nqh.equals(str)) {
                        Log.i("MicroMsg.AppBrandPageContainerWC", "statPageTime onBackground");
                        com.tencent.mm.plugin.appbrand.report.h hVar = ((ag) getCurrentPage().getCurrentPageView()).nrs;
                        this.nqe = hVar == null ? 0 : hVar.bUE();
                        this.nqc = true;
                    }
                }
                this.nqg = System.currentTimeMillis() - this.nqf;
                if (this.nqb && this.nqc && getRuntime().ON().cyA != null) {
                    Log.i("MicroMsg.AppBrandPageContainerWC", "report pageStayTime:%d, appStayTime:%d", Long.valueOf(this.nqe), Long.valueOf(this.nqg));
                    i.b(1, this.nqe, this.nqg, getRuntime().ON().cyA.nHv);
                }
            }
            if (this.nqd && getRuntime().ON().cyA.scene == 1162 && System.currentTimeMillis() - this.nqf >= 3000) {
                AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer = getRuntime().bsC().kHI;
                String str2 = appBrandLaunchFromNotifyReferrer.appId;
                int i2 = appBrandLaunchFromNotifyReferrer.lej;
                String str3 = appBrandLaunchFromNotifyReferrer.lek;
                String str4 = appBrandLaunchFromNotifyReferrer.content;
                int i3 = appBrandLaunchFromNotifyReferrer.lel;
                String str5 = appBrandLaunchFromNotifyReferrer.lem;
                if (!Util.nullAsNil(this.nqi).equals(str3)) {
                    h.INSTANCE.a(19724, 4, 0, 0, Integer.valueOf(i3), 0, null, 0, 0, 0, str2, null, null, str3, 0, null, str4, Integer.valueOf(i2), null, null, str5);
                    this.nqi = str3;
                }
            }
        }
        AppMethodBeat.o(47826);
    }

    public f getReporter() {
        return this.npZ;
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(47827);
        super.onViewAdded(view);
        if (view instanceof t) {
            cb.cE((t) view);
        }
        AppMethodBeat.o(47827);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w.a
    public final t a(String str, bx bxVar, w wVar, Callable<t> callable) {
        return null;
    }

    public ag bOx() {
        ag pollFirst;
        boolean z;
        AppMethodBeat.i(175030);
        synchronized (this.nqk) {
            try {
                pollFirst = this.nqk.pollFirst();
            } catch (Throwable th) {
                AppMethodBeat.o(175030);
                throw th;
            }
        }
        Object[] objArr = new Object[2];
        if (pollFirst != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = getAppId();
        Log.i("MicroMsg.AppBrandPageContainerWC", "onCreatePageView preloaded[%b] appId[%s]", objArr);
        if (!TextUtils.isEmpty(this.nql)) {
            if (pollFirst instanceof bs) {
                AppMethodBeat.o(175030);
                return pollFirst;
            }
            bs bsVar = new bs(this.nql);
            AppMethodBeat.o(175030);
            return bsVar;
        } else if (pollFirst != null) {
            AppMethodBeat.o(175030);
            return pollFirst;
        } else {
            ag agVar = new ag();
            AppMethodBeat.o(175030);
            return agVar;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.w
    public boolean e(t tVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(227277);
        boolean[] zArr = new boolean[5];
        zArr[0] = super.e(tVar);
        zArr[1] = !getRuntime().bsr();
        if (!getRuntime().NA()) {
            z = true;
        } else {
            z = false;
        }
        zArr[2] = z;
        if (!g.an(getRuntime())) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[3] = z2;
        if (!bb.r(getRuntime())) {
            z3 = true;
        } else {
            z3 = false;
        }
        zArr[4] = z3;
        int i2 = 0;
        while (true) {
            if (i2 >= 5) {
                z4 = true;
                break;
            } else if (!zArr[i2]) {
                Log.i("MicroMsg.AppBrandPageContainerWC", "[%s,%s]->shouldShowActionBarHomeButton: test fail cause #[%d] condition", tVar.getAppId(), tVar.getCurrentUrl(), Integer.valueOf(i2));
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(227277);
        return z4;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final Object m(t tVar) {
        AppMethodBeat.i(47829);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.eq);
        AppMethodBeat.o(47829);
        return loadAnimation;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final Object n(t tVar) {
        AppMethodBeat.i(47830);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.en);
        AppMethodBeat.o(47830);
        return loadAnimation;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final Object o(t tVar) {
        AppMethodBeat.i(47831);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.em);
        AppMethodBeat.o(47831);
        return loadAnimation;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w
    public final Object p(t tVar) {
        AppMethodBeat.i(47832);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.er);
        AppMethodBeat.o(47832);
        return loadAnimation;
    }

    private void bQZ() {
        AppMethodBeat.i(227278);
        if (!(getCurrentPage() == null || getCurrentPage().getCurrentPageView() == null)) {
            if (getRuntime().ON().cyA.scene == 1118) {
                AppBrandRecommendStatObj appBrandRecommendStatObj = getRuntime().ON().cyA == null ? null : getRuntime().ON().cyA.nHv;
                if (appBrandRecommendStatObj != null) {
                    Log.i("MicroMsg.AppBrandPageContainerWC", "recommendStatObj is got");
                    if (!TextUtils.isEmpty(appBrandRecommendStatObj.nHf) && !TextUtils.isEmpty(appBrandRecommendStatObj.nHg)) {
                        this.nqh = appBrandRecommendStatObj.nHf + "?" + appBrandRecommendStatObj.nHg;
                    } else if (!TextUtils.isEmpty(appBrandRecommendStatObj.nHf)) {
                        this.nqh = appBrandRecommendStatObj.nHf;
                    } else {
                        this.nqh = getRuntime().brs();
                    }
                    this.nqb = true;
                    this.nqf = System.currentTimeMillis();
                }
            }
            if (getRuntime().ON().cyA.scene == 1162) {
                this.nqd = true;
                this.nqf = System.currentTimeMillis();
            }
        }
        AppMethodBeat.o(227278);
    }

    public final boolean post(Runnable runnable) {
        AppMethodBeat.i(227279);
        if (runnable == null) {
            AppMethodBeat.o(227279);
            return false;
        } else if (u.aD(this) || getRuntime() == null || !getRuntime().OS()) {
            boolean post = super.post(runnable);
            AppMethodBeat.o(227279);
            return post;
        } else {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(227279);
            return true;
        }
    }

    public final boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(227280);
        if (runnable == null) {
            AppMethodBeat.o(227280);
            return false;
        } else if (u.aD(this) || getRuntime() == null || !getRuntime().OS()) {
            boolean postDelayed = super.postDelayed(runnable, j2);
            AppMethodBeat.o(227280);
            return postDelayed;
        } else {
            MMHandlerThread.postToMainThreadDelayed(runnable, j2);
            AppMethodBeat.o(227280);
            return true;
        }
    }

    static {
        AppMethodBeat.i(175032);
        e.c.ngP = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: SPUT  
              (wrap: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1 : 0x0008: CONSTRUCTOR  (r0v0 com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1) =  call: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1.<init>():void type: CONSTRUCTOR)
             com.tencent.mm.plugin.appbrand.p.e.c.ngP com.tencent.mm.plugin.appbrand.p.e$c in method: com.tencent.mm.plugin.appbrand.page.x.<clinit>():void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r0v0 com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1) =  call: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.page.x.<clinit>():void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:439)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 18 more
            */
        /*
            r1 = 175032(0x2abb8, float:2.45272E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1 r0 = new com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$1
            r0.<init>()
            com.tencent.mm.plugin.appbrand.p.e.c.ngP = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.x.<clinit>():void");
    }
}
