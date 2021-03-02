package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.d.b;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.x;

public class AppBrandRuntimeContainerWC extends b {
    private boolean kCy = false;
    private final Class[] kCz = {l.class};

    static /* synthetic */ void b(Configuration configuration) {
        AppMethodBeat.i(226175);
        a(configuration);
        AppMethodBeat.o(226175);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime, com.tencent.mm.plugin.appbrand.AppBrandRuntime, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final /* synthetic */ void a(d dVar, d dVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(43850);
        d dVar3 = dVar;
        final d dVar4 = dVar2;
        if (dVar3 != null) {
            h.a(dVar3.mAppId, h.d.LAUNCH_MINI_PROGRAM);
        }
        if (dVar3 == null || !com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.l.a((q) dVar3, (q) dVar4, (AppBrandInitConfigWC) appBrandInitConfig)) {
            if (AppBrandRuntimeWCAccessible.g(appBrandInitConfig)) {
                bsk();
            }
            f(appBrandInitConfig);
            this.kCy = true;
            if (AppBrandRuntimeWCAccessible.g(appBrandInitConfig)) {
                a.e(dVar4);
            }
            if (dVar4.mInitialized) {
                Log.i("MicroMsg.AppBrandRuntimeContainerWC", "loadNew(), runtime[%s] initialized, should be persistent, use loadExisted() instead", dVar4.mAppId);
                super.b(dVar3, dVar4, appBrandInitConfig);
                if (g.an(dVar4)) {
                    Log.i("MicroMsg.AppBrandRuntimeContainerWC", "[weishi] loadExisted, showSplash");
                    dVar4.brp();
                    ab brK = dVar4.brK();
                    AnonymousClass2 r1 = new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* bridge */ /* synthetic */ x invoke() {
                            AppMethodBeat.i(174650);
                            dVar4.kAu = null;
                            AppMethodBeat.o(174650);
                            return null;
                        }
                    };
                    if (brK instanceof af) {
                        ((af) brK).B(r1);
                    } else if (brK != null) {
                        brK.z(r1);
                    }
                }
                if (dVar4.kAl == this) {
                    w wVar = w.nHZ;
                    w.h((AppBrandInitConfigWC) appBrandInitConfig);
                }
            } else {
                super.a(dVar3, dVar4, appBrandInitConfig);
                if (dVar4.kAl == this) {
                    w wVar2 = w.nHZ;
                    w.i((AppBrandInitConfigWC) appBrandInitConfig);
                }
            }
            this.kCy = false;
            if (dVar3 != null) {
                ((ah) e.M(ah.class)).a(dVar4, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(174651);
                        ((q) dVar4).onEnterAnimationComplete();
                        AppMethodBeat.o(174651);
                    }
                }, dVar3);
            }
        }
        AppMethodBeat.o(43850);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime, com.tencent.mm.plugin.appbrand.AppBrandRuntime, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final /* synthetic */ void b(d dVar, d dVar2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(43848);
        d dVar3 = dVar;
        final d dVar4 = dVar2;
        if (dVar3 != null) {
            h.a(dVar3.mAppId, h.d.LAUNCH_MINI_PROGRAM);
        }
        if (AppBrandRuntimeWCAccessible.g(appBrandInitConfig)) {
            bsk();
        }
        f(appBrandInitConfig);
        int indexOf = bse().indexOf(dVar4);
        if (indexOf > 0) {
            LinkedList linkedList = new LinkedList();
            ListIterator listIterator = bse().listIterator(indexOf);
            while (listIterator.hasPrevious()) {
                d dVar5 = (d) listIterator.previous();
                if (!(dVar5 == dVar4 || dVar5 == dVar3 || !AppBrandRuntimeWCAccessible.D(dVar5))) {
                    linkedList.add(dVar5);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                AppBrandRuntime appBrandRuntime = (AppBrandRuntime) it.next();
                appBrandRuntime.kAO = false;
                super.A(appBrandRuntime);
                super.w(appBrandRuntime);
            }
        }
        super.b(dVar3, dVar4, appBrandInitConfig);
        if (dVar4.kAl == this) {
            w wVar = w.nHZ;
            w.h((AppBrandInitConfigWC) appBrandInitConfig);
        }
        if (dVar3 != null) {
            ((ah) e.M(ah.class)).a(dVar4, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(226165);
                    ((q) dVar4).onEnterAnimationComplete();
                    AppMethodBeat.o(226165);
                }
            }, dVar3);
        }
        AppMethodBeat.o(43848);
    }

    static {
        AppMethodBeat.i(43852);
        r.a.a(com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.nav);
        AppMethodBeat.o(43852);
    }

    public AppBrandRuntimeContainerWC(k kVar) {
        super(kVar, q.class);
        AppMethodBeat.i(43841);
        if (Build.VERSION.SDK_INT >= 21) {
            getContext();
            if (com.tencent.mm.plugin.appbrand.widget.input.a.caQ()) {
                com.tencent.mm.plugin.appbrand.widget.l.a(AndroidContextUtil.castActivityOrNull(this.mContext), AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView());
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass1 */

                public final void onSystemUiVisibilityChange(int i2) {
                    Activity castActivityOrNull;
                    AppMethodBeat.i(174649);
                    if (!(!u.aD(AppBrandRuntimeContainerWC.this.mContentView) || (castActivityOrNull = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainerWC.this.mContext)) == null || castActivityOrNull.getWindow() == null)) {
                        ao.e(castActivityOrNull.getWindow(), !ar.aln(castActivityOrNull.getWindow().getNavigationBarColor()));
                    }
                    AppMethodBeat.o(174649);
                }
            });
        }
        AppMethodBeat.o(43841);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o
    public final void a(WindowManager.LayoutParams layoutParams) {
        AppMethodBeat.i(43842);
        super.a(layoutParams);
        if (!(AndroidContextUtil.castActivityOrNull(this.mContext) == null || AndroidContextUtil.castActivityOrNull(this.mContext).getWindow() == null)) {
            View decorView = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getDecorView();
            if ((decorView.getWindowSystemUiVisibility() & 2) == 0) {
                Drawable background = decorView.getBackground();
                if (background instanceof com.tencent.mm.plugin.appbrand.widget.l) {
                    com.tencent.mm.plugin.appbrand.widget.l lVar = (com.tencent.mm.plugin.appbrand.widget.l) background;
                    int navigationBarColor = AndroidContextUtil.castActivityOrNull(this.mContext).getWindow().getNavigationBarColor();
                    boolean z = navigationBarColor != lVar.olB;
                    lVar.olB = navigationBarColor;
                    if (z) {
                        lVar.invalidateSelf();
                    }
                }
            }
        }
        AppMethodBeat.o(43842);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.mm.plugin.appbrand.widget.input.w] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig r4) {
        /*
            r3 = this;
            r2 = 43843(0xab43, float:6.1437E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r4 != 0) goto L_0x000c
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x000b:
            return
        L_0x000c:
            boolean r0 = r4 instanceof com.tencent.luggage.sdk.config.AppBrandInitConfigLU
            if (r0 == 0) goto L_0x0039
            com.tencent.luggage.sdk.config.AppBrandInitConfigLU r4 = (com.tencent.luggage.sdk.config.AppBrandInitConfigLU) r4
            boolean r0 = r4.NA()
            if (r0 == 0) goto L_0x0039
            r0 = 1
        L_0x0019:
            if (r0 == 0) goto L_0x003b
            android.widget.FrameLayout r0 = r3.mContentView
            com.tencent.mm.plugin.appbrand.widget.input.w r0 = com.tencent.mm.plugin.appbrand.widget.input.w.dc(r0)
            r1 = r0
        L_0x0022:
            if (r1 == 0) goto L_0x0035
            android.view.ViewParent r0 = r1.getParent()
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0035
            android.view.ViewParent r0 = r1.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r0.removeView(r1)
        L_0x0035:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x000b
        L_0x0039:
            r0 = 0
            goto L_0x0019
        L_0x003b:
            android.widget.FrameLayout r0 = r3.mContentView
            com.tencent.luggage.game.widget.input.a r0 = com.tencent.luggage.game.widget.input.a.cd(r0)
            r1 = r0
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.f(com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig):void");
    }

    public enum a {
        Finish,
        OnDestroy;

        public static a valueOf(String str) {
            AppMethodBeat.i(226169);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(226169);
            return aVar;
        }

        static {
            AppMethodBeat.i(226170);
            AppMethodBeat.o(226170);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(226172);
        d dVar = (d) getActiveRuntime();
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.kCb);
        linkedList.addAll(this.kCc.values());
        Iterator it = linkedList.iterator();
        if (it.hasNext() && i.a(this)) {
            Log.i("MicroMsg.AppBrandRuntimeContainerWC", "stashPersistentRuntimesWhenActivityMayDestroy hash[%d], reason[%s]", Integer.valueOf(hashCode()), aVar);
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (dVar2.mInitialized && !dVar2.isDestroyed() && !dVar2.SO && !org.apache.commons.b.a.contains(this.kCz, dVar2.getClass())) {
                    if (aVar == a.Finish && dVar2 == dVar) {
                        try {
                            if (!dVar2.brh().getCurrentPage().mSwiping) {
                                FrameLayout frameLayout = new FrameLayout(getContext());
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dVar2.kAt.getWidth(), dVar2.kAt.getHeight(), 81);
                                frameLayout.setBackground(new BitmapDrawable(getContext().getResources(), ca.cD(dVar2.kAt)));
                                frameLayout.setWillNotDraw(false);
                                this.mContentView.addView(frameLayout, layoutParams);
                                this.mContentView.bringChildToFront(frameLayout);
                            }
                        } catch (NullPointerException e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", e2, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
                        } catch (OutOfMemoryError e3) {
                            Log.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", e3, "stashPersistentRuntimesWhenActivityMayDestroy", new Object[0]);
                        }
                    }
                    if (dVar2.mResumed) {
                        WeAppOpenUICallbackIPCProxy weAppOpenUICallbackIPCProxy = dVar2.ON() instanceof AppBrandInitConfigWC ? ((AppBrandInitConfigWC) dVar2.ON()).leh : null;
                        if (weAppOpenUICallbackIPCProxy != null) {
                            weAppOpenUICallbackIPCProxy.mXw = true;
                        }
                        dVar2.dispatchPause();
                        if (weAppOpenUICallbackIPCProxy != null) {
                            weAppOpenUICallbackIPCProxy.mXw = false;
                            weAppOpenUICallbackIPCProxy.hY(true);
                        }
                    }
                    c cVar = dVar2.kAt;
                    if (cVar.getParent() instanceof ViewGroup) {
                        ((ViewGroup) cVar.getParent()).removeView(cVar);
                    }
                    B(dVar2);
                    ((q) dVar2).bsA();
                    k.c((q) dVar2);
                }
            }
        }
        AppMethodBeat.o(226172);
    }

    @Override // com.tencent.luggage.sdk.d.b, com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final void b(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, final Runnable runnable) {
        AppMethodBeat.i(43844);
        super.b(appBrandRuntime, appBrandRuntime2, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(226166);
                runnable.run();
                if (AppBrandRuntimeContainerWC.this.getActiveRuntime() != null && !AppBrandRuntimeWCAccessible.isGame(AppBrandRuntimeContainerWC.this.getActiveRuntime())) {
                    AppBrandRuntimeContainerWC.b(AppBrandRuntimeContainerWC.this);
                }
                AppMethodBeat.o(226166);
            }
        });
        AppMethodBeat.o(43844);
    }

    @Override // com.tencent.luggage.sdk.d.b
    public final boolean OH() {
        AppMethodBeat.i(43846);
        if (getStackSize() <= 0) {
            bY(false);
            AppMethodBeat.o(43846);
            return true;
        }
        AppMethodBeat.o(43846);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r0.brh().getCurrentPage().mSwiping != false) goto L_0x004c;
     */
    @Override // com.tencent.luggage.sdk.d.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bY(boolean r7) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.bY(boolean):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.i(180170);
        a(configuration);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(226167);
                AppBrandRuntimeContainerWC.b(configuration);
                AppMethodBeat.o(226167);
            }
        });
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(180170);
    }

    private static void a(Configuration configuration) {
        AppMethodBeat.i(180171);
        if (Build.VERSION.SDK_INT < 29) {
            AppMethodBeat.o(180171);
            return;
        }
        configuration.uiMode &= -49;
        if (!ao.isDarkMode()) {
            configuration.uiMode |= 16;
        } else {
            configuration.uiMode |= 32;
        }
        MMApplicationContext.getContext().getResources().updateConfiguration(configuration, MMApplicationContext.getResources().getDisplayMetrics());
        AppMethodBeat.o(180171);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final void a(int i2, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(226173);
        super.a(i2, appBrandRuntime);
        if (((q) appBrandRuntime).bsC().kHL.isEnable()) {
            com.tencent.mm.ui.base.b.a(AndroidContextUtil.castActivityOrNull(this.mContext), null);
            AppMethodBeat.o(226173);
            return;
        }
        if (AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI) {
            com.tencent.mm.ui.base.b.bp(AndroidContextUtil.castActivityOrNull(this.mContext));
        }
        AppMethodBeat.o(226173);
    }

    public final void bsl() {
        long j2;
        long longValue;
        AppMethodBeat.i(226174);
        Iterator it = bse().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar instanceof q) {
                q qVar = (q) dVar;
                if (qVar.kDy != null) {
                    com.tencent.mm.plugin.appbrand.report.model.r rVar = qVar.kDy;
                    n nVar = new n();
                    Long l = rVar.nKj;
                    if (l != null) {
                        j2 = l.longValue();
                    } else {
                        j2 = -1;
                    }
                    nVar.ekC = j2;
                    nVar.hR(rVar.appId);
                    a.C0792a aVar = com.tencent.mm.plugin.appbrand.report.quality.a.nKn;
                    nVar.hS(a.C0792a.getFlags());
                    nVar.ekE = 2;
                    nVar.hT(rVar.sessionId);
                    if (rVar.nKk == null) {
                        longValue = 0;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        Long l2 = rVar.nKk;
                        if (l2 == null) {
                            p.hyc();
                        }
                        longValue = currentTimeMillis - l2.longValue();
                    }
                    nVar.ekD = longValue;
                    Log.d("MicroMsg.kv_21804", "onFinishReport: process[%s]" + nVar.abW(), MMApplicationContext.getProcessName());
                    nVar.bfK();
                }
            }
        }
        AppMethodBeat.o(226174);
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final void cleanup() {
        long j2;
        long longValue;
        AppMethodBeat.i(226171);
        Iterator it = bse().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar instanceof q) {
                q qVar = (q) dVar;
                if (qVar.kDy != null) {
                    com.tencent.mm.plugin.appbrand.report.model.r rVar = qVar.kDy;
                    n nVar = new n();
                    Long l = rVar.nKj;
                    if (l != null) {
                        j2 = l.longValue();
                    } else {
                        j2 = -1;
                    }
                    nVar.ekC = j2;
                    nVar.hR(rVar.appId);
                    a.C0792a aVar = com.tencent.mm.plugin.appbrand.report.quality.a.nKn;
                    nVar.hS(a.C0792a.getFlags());
                    nVar.ekE = 1;
                    nVar.hT(rVar.sessionId);
                    if (rVar.nKk == null) {
                        longValue = 0;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        Long l2 = rVar.nKk;
                        if (l2 == null) {
                            p.hyc();
                        }
                        longValue = currentTimeMillis - l2.longValue();
                    }
                    nVar.ekD = longValue;
                    Log.d("MicroMsg.kv_21804", "onDestroyReport: process[%s]" + nVar.abW(), MMApplicationContext.getProcessName());
                    nVar.bfK();
                }
            }
        }
        super.cleanup();
        if (getContext() instanceof com.tencent.mm.plugin.appbrand.ui.n) {
            ((com.tencent.mm.plugin.appbrand.ui.n) getContext()).setBaseContext(MMApplicationContext.getContext());
        }
        super.aG(MMApplicationContext.getContext());
        AppMethodBeat.o(226171);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.platform.window.c
    public void setWindowDescription(c.a aVar) {
        AppMethodBeat.i(174652);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        if (castActivityOrNull == null) {
            AppMethodBeat.o(174652);
            return;
        }
        if ((castActivityOrNull instanceof AppBrandUI) && ((AppBrandUI) castActivityOrNull).bsc()) {
            super.setWindowDescription(aVar);
        }
        AppMethodBeat.o(174652);
    }

    private void bsk() {
        AppMethodBeat.i(43845);
        if ((AndroidContextUtil.castActivityOrNull(this.mContext) instanceof AppBrandPluginUI) && ((Boolean) s.lrT.aLT()).booleanValue()) {
            com.tencent.mm.ui.base.b.bp(AndroidContextUtil.castActivityOrNull(this.mContext));
        }
        AppMethodBeat.o(43845);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.appbrand.AppBrandRuntime' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final /* synthetic */ d e(final AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(43849);
        d dVar = (d) com.tencent.luggage.sdk.g.c.a("AppBrandRuntimeProfile|createRuntime-" + appBrandInitConfig.appId, new kotlin.g.a.a<d>() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ d invoke() {
                AppMethodBeat.i(226164);
                for (r rVar : r.a.bsU()) {
                    q b2 = rVar.b((AppBrandInitConfigWC) appBrandInitConfig, AppBrandRuntimeContainerWC.this);
                    if (b2 != null) {
                        AppMethodBeat.o(226164);
                        return b2;
                    }
                }
                q a2 = k.a((AppBrandInitConfigWC) appBrandInitConfig, AppBrandRuntimeContainerWC.this);
                if (a2 != null) {
                    AppMethodBeat.o(226164);
                    return a2;
                }
                q TQ = a.TQ(appBrandInitConfig.appId);
                if (TQ != null) {
                    if ((((AppBrandInitConfigWC) appBrandInitConfig).kHL.isEnable() || ((AppBrandInitConfigWC) appBrandInitConfig).leg) && (TQ.kAl instanceof AppBrandRuntimeContainerWC)) {
                        Log.i("MicroMsg.AppBrandRuntimeContainerWC", "createRuntime hit halfScreenCondition, runtime(%s) will be detached", TQ.mAppId);
                        AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC) TQ.kAl;
                        com.tencent.mm.plugin.appbrand.ui.l.cG(TQ.kAt);
                        appBrandRuntimeContainerWC.B(TQ);
                        appBrandRuntimeContainerWC.OH();
                        TQ.bsA();
                        TQ.a((ak) AppBrandRuntimeContainerWC.this);
                        AppMethodBeat.o(226164);
                        return TQ;
                    }
                }
                q qVar = new q(AppBrandRuntimeContainerWC.this);
                AppMethodBeat.o(226164);
                return qVar;
            }
        });
        AppMethodBeat.o(43849);
        return dVar;
    }

    static /* synthetic */ void b(AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        AppMethodBeat.i(43851);
        if (appBrandRuntimeContainerWC.getContext() instanceof AppBrandPluginUI) {
            com.tencent.mm.ui.base.b.a(AndroidContextUtil.castActivityOrNull(appBrandRuntimeContainerWC.mContext), null);
            Log.i("MicroMsg.AppBrandRuntimeContainerWC", "reset convertActivityToTranslucent");
        }
        AppMethodBeat.o(43851);
    }
}
