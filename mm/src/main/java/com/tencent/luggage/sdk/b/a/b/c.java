package com.tencent.luggage.sdk.b.a.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(J \u0010*\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020,J \u0010-\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020,J\u0018\u0010.\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0002J\f\u00102\u001a\u00020&*\u00020(H\u0002J\f\u00102\u001a\u00020&*\u000203H\u0002J\f\u00104\u001a\u00020&*\u00020(H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u00065"}, hxF = {"Lcom/tencent/luggage/sdk/jsapi/component/page/AppBrandPageViewMemoryRecycleStrategy;", "", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;)V", "appId", "", "kotlin.jvm.PlatformType", "checkPauseRenderingDelayAfterBackground", "", "getCheckPauseRenderingDelayAfterBackground", "()J", "checkPauseRenderingDelayAfterBackground$delegate", "Lkotlin/Lazy;", "checkPauseRenderingTimerAfterBackground", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckPauseRenderingTimerAfterBackground", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkPauseRenderingTimerAfterBackground$delegate", "keepInvisbileTabbarPagesActive", "", "getKeepInvisbileTabbarPagesActive", "()Z", "setKeepInvisbileTabbarPagesActive", "(Z)V", "maxKeepRenderingPageCount", "", "getMaxKeepRenderingPageCount", "()I", "setMaxKeepRenderingPageCount", "(I)V", "maxKeepRenderingPageCountOnBackground", "getMaxKeepRenderingPageCountOnBackground", "setMaxKeepRenderingPageCountOnBackground", "pauseWhenAppBackground", "getPauseWhenAppBackground", "setPauseWhenAppBackground", "onNavigateBack", "", "out", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPage;", LocaleUtil.INDONESIAN_NEWNAME, "onNavigateEnd", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "onNavigateStart", "tryPauseRenderingOfInvisiblePages", "tryPauseRenderingOfInvisibleTabbarPages", "tryReloadNearestInvisiblePage", "tryRestoreRenderingOfNearestInvisiblePage", "tryPauseRendering", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "tryRestoreRendering", "luggage-wechat-full-sdk_release"})
public final class c {
    public final String appId = this.cAt.getAppId();
    public int cAn = 2;
    public boolean cAo = true;
    public boolean cAp = true;
    int cAq = 1;
    private final f cAr = g.ah(new a(this));
    private final f cAs = g.ah(new b(this));
    public final w cAt;

    public c(w wVar) {
        p.h(wVar, "pageContainer");
        AppMethodBeat.i(147849);
        this.cAt = wVar;
        com.tencent.luggage.sdk.g.g gVar = com.tencent.luggage.sdk.g.g.cCM;
        AppBrandRuntime runtime = this.cAt.getRuntime();
        p.g(runtime, "pageContainer.runtime");
        com.tencent.luggage.sdk.g.g.a(runtime, new kotlin.g.a.b<com.tencent.luggage.sdk.g.d, x>(this) {
            /* class com.tencent.luggage.sdk.b.a.b.c.AnonymousClass1 */
            final /* synthetic */ c cAu;

            {
                this.cAu = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.luggage.sdk.g.d dVar) {
                AppMethodBeat.i(147837);
                com.tencent.luggage.sdk.g.d dVar2 = dVar;
                p.h(dVar2, "$receiver");
                dVar2.b(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.luggage.sdk.b.a.b.c.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 cAv;

                    {
                        this.cAv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(147833);
                        c.a(this.cAv.cAu).startTimer(c.b(this.cAv.cAu), c.b(this.cAv.cAu));
                        x xVar = x.SXb;
                        AppMethodBeat.o(147833);
                        return xVar;
                    }
                });
                AnonymousClass2 r0 = new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.luggage.sdk.b.a.b.c.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 cAv;

                    {
                        this.cAv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(147834);
                        c.a(this.cAv.cAu).stopTimer();
                        try {
                            Log.i("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onSuspend appId[" + this.cAv.cAu.appId + "] try pause all pages's rendering");
                            Iterator<t> bQQ = this.cAv.cAu.cAt.bQQ();
                            p.g(bQQ, "pageContainer.stackIterator()");
                            while (bQQ.hasNext()) {
                                t next = bQQ.next();
                                p.g(next, "page");
                                c.b(next);
                            }
                        } catch (Throwable th) {
                            Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]onSuspend appId[" + this.cAv.cAu.appId + ']', new Object[0]);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(147834);
                        return xVar;
                    }
                };
                p.h(r0, "callback");
                dVar2.a(com.tencent.mm.plugin.appbrand.a.b.SUSPEND, r0);
                dVar2.a(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.luggage.sdk.b.a.b.c.AnonymousClass1.AnonymousClass3 */
                    final /* synthetic */ AnonymousClass1 cAv;

                    {
                        this.cAv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(147835);
                        c.a(this.cAv.cAu).stopTimer();
                        try {
                            Log.i("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onForeground appId[" + this.cAv.cAu.appId + "] try restore top[" + this.cAv.cAu.cAn + "] pages's rendering");
                            Iterator<t> bQQ = this.cAv.cAu.cAt.bQQ();
                            p.g(bQQ, "pageContainer.stackIterator()");
                            int i2 = 0;
                            while (bQQ.hasNext()) {
                                t next = bQQ.next();
                                i2++;
                                if (i2 <= this.cAv.cAu.cAn) {
                                    p.g(next, "page");
                                    c.c(next);
                                }
                            }
                        } catch (Throwable th) {
                            Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]onForeground appId[" + this.cAv.cAu.appId + ']', new Object[0]);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(147835);
                        return xVar;
                    }
                });
                dVar2.c(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.luggage.sdk.b.a.b.c.AnonymousClass1.AnonymousClass4 */
                    final /* synthetic */ AnonymousClass1 cAv;

                    {
                        this.cAv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(147836);
                        c.a(this.cAv.cAu).stopTimer();
                        x xVar = x.SXb;
                        AppMethodBeat.o(147836);
                        return xVar;
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(147837);
                return xVar;
            }
        });
        AppMethodBeat.o(147849);
    }

    public static final /* synthetic */ void c(t tVar) {
        AppMethodBeat.i(147855);
        a(tVar);
        AppMethodBeat.o(147855);
    }

    private static void a(t tVar) {
        com.tencent.mm.plugin.appbrand.page.a.e eVar;
        com.tencent.mm.plugin.appbrand.page.a.e eVar2;
        AppMethodBeat.i(147845);
        if (tVar instanceof m) {
            Iterator<ac> bQJ = ((m) tVar).bQJ();
            p.g(bQJ, "this.pagesIterator()");
            while (bQJ.hasNext()) {
                ac next = bQJ.next();
                if (!(next == null || (eVar2 = (com.tencent.mm.plugin.appbrand.page.a.e) next.S(com.tencent.mm.plugin.appbrand.page.a.e.class)) == null)) {
                    eVar2.bLp();
                }
            }
            AppMethodBeat.o(147845);
            return;
        }
        ac currentPageView = tVar.getCurrentPageView();
        if (currentPageView == null || (eVar = (com.tencent.mm.plugin.appbrand.page.a.e) currentPageView.S(com.tencent.mm.plugin.appbrand.page.a.e.class)) == null) {
            AppMethodBeat.o(147845);
            return;
        }
        eVar.bLp();
        AppMethodBeat.o(147845);
    }

    public static void a(t tVar, bx bxVar) {
        AppMethodBeat.i(147846);
        p.h(tVar, LocaleUtil.INDONESIAN_NEWNAME);
        p.h(bxVar, "type");
        a(tVar);
        AppMethodBeat.o(147846);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ c cAu;
        final /* synthetic */ bx cAx;

        public d(c cVar, bx bxVar) {
            this.cAu = cVar;
            this.cAx = bxVar;
        }

        public final void run() {
            AppMethodBeat.i(147842);
            c.a(this.cAu, this.cAx);
            AppMethodBeat.o(147842);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.luggage.sdk.b.a.b.c$c  reason: collision with other inner class name */
    public static final class RunnableC0180c implements Runnable {
        final /* synthetic */ c cAu;

        public RunnableC0180c(c cVar) {
            this.cAu = cVar;
        }

        public final void run() {
            AppMethodBeat.i(147841);
            this.cAu.a(bx.NAVIGATE_BACK);
            c.a(this.cAu, bx.NAVIGATE_BACK);
            AppMethodBeat.o(147841);
        }
    }

    public final void Oc() {
        AppMethodBeat.i(147847);
        try {
            if (this.cAo) {
                AppMethodBeat.o(147847);
                return;
            }
            t currentPage = this.cAt.getCurrentPage();
            if (currentPage instanceof m) {
                ac currentPageView = ((m) currentPage).getCurrentPageView();
                if (currentPageView == null) {
                    AppMethodBeat.o(147847);
                    return;
                }
                Iterator<ac> bQJ = ((m) currentPage).bQJ();
                p.g(bQJ, "page.pagesIterator()");
                while (bQJ.hasNext()) {
                    ac next = bQJ.next();
                    if (p.j(currentPageView, next)) {
                        AppMethodBeat.o(147847);
                        return;
                    }
                    p.g(next, "pv");
                    com.tencent.mm.plugin.appbrand.page.a.e eVar = (com.tencent.mm.plugin.appbrand.page.a.e) next.S(com.tencent.mm.plugin.appbrand.page.a.e.class);
                    if (eVar != null) {
                        eVar.bLq();
                    }
                }
                AppMethodBeat.o(147847);
                return;
            }
            AppMethodBeat.o(147847);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]tryPauseRenderingOfInvisibleTabbarPages appId[" + this.appId + "], switch[" + this.cAo + ']', new Object[0]);
        }
    }

    public final void a(bx bxVar) {
        AppMethodBeat.i(147848);
        try {
            t k = this.cAt.k(this.cAt.getCurrentPage());
            if (k != null) {
                a(k);
                AppMethodBeat.o(147848);
                return;
            }
            AppMethodBeat.o(147848);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]tryRestoreRenderingOfNearestInvisiblePage appId[" + this.appId + "] type[" + bxVar + ']', new Object[0]);
            AppMethodBeat.o(147848);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ c cAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(0);
            this.cAu = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(147838);
            AppBrandRuntime runtime = this.cAu.cAt.getRuntime();
            p.g(runtime, "pageContainer.runtime");
            Long valueOf = Long.valueOf((((long) runtime.OT().leC) * 1000) + 100);
            AppMethodBeat.o(147838);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MTimerHandler> {
        final /* synthetic */ c cAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(0);
            this.cAu = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MTimerHandler invoke() {
            AppMethodBeat.i(147840);
            MTimerHandler mTimerHandler = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack(this) {
                /* class com.tencent.luggage.sdk.b.a.b.c.b.AnonymousClass1 */
                final /* synthetic */ b cAw;

                {
                    this.cAw = r1;
                }

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(147839);
                    try {
                        Log.i("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]onBackground appId[" + this.cAw.cAu.appId + "] try pause all pages's rendering, delay[" + c.b(this.cAw.cAu) + "] switch[" + this.cAw.cAu.cAp + ']');
                        if (this.cAw.cAu.cAp) {
                            Iterator<t> bQQ = this.cAw.cAu.cAt.bQQ();
                            p.g(bQQ, "pageContainer.stackIterator()");
                            int i2 = 0;
                            while (bQQ.hasNext()) {
                                t next = bQQ.next();
                                i2++;
                                if (i2 > this.cAw.cAu.cAq) {
                                    p.g(next, "page");
                                    c.b(next);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]onBackground appId[" + this.cAw.cAu.appId + ']', new Object[0]);
                    }
                    AppMethodBeat.o(147839);
                    return false;
                }
            }, false);
            AppMethodBeat.o(147840);
            return mTimerHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c cAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c cVar) {
            super(0);
            this.cAu = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(169542);
            Iterator<t> bQQ = this.cAu.cAt.bQQ();
            p.g(bQQ, "pageContainer.stackIterator()");
            int i2 = 0;
            while (bQQ.hasNext()) {
                t next = bQQ.next();
                int i3 = i2 + 1;
                if (i2 >= this.cAu.cAn) {
                    p.g(next, "page");
                    c.b(next);
                }
                i2 = i3;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(169542);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(c cVar, bx bxVar) {
        AppMethodBeat.i(147850);
        try {
            t k = cVar.cAt.k(cVar.cAt.getCurrentPage());
            if (k == null) {
                AppMethodBeat.o(147850);
                return;
            }
            com.tencent.luggage.sdk.b.a.b.a.a aVar = (com.tencent.luggage.sdk.b.a.b.a.a) k.getCurrentPageView().S(com.tencent.luggage.sdk.b.a.b.a.a.class);
            if (aVar != null) {
                Log.i("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", "[wxa_reload]tryReloadNearestInvisiblePage appId[" + cVar.appId + "] reload[" + aVar.Og() + "] type[" + bxVar + ']');
                AppMethodBeat.o(147850);
                return;
            }
            AppMethodBeat.o(147850);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.WXA.AppBrandPageViewMemoryRecycleStrategy", th, "[wxa_reload]tryReloadNearestInvisiblePage appId[" + cVar.appId + "] type[" + bxVar + ']', new Object[0]);
            AppMethodBeat.o(147850);
        }
    }

    public static final /* synthetic */ void b(t tVar) {
        com.tencent.mm.plugin.appbrand.page.a.e eVar;
        com.tencent.mm.plugin.appbrand.page.a.e eVar2;
        AppMethodBeat.i(147854);
        if (tVar instanceof m) {
            Iterator<ac> bQJ = ((m) tVar).bQJ();
            p.g(bQJ, "this.pagesIterator()");
            while (bQJ.hasNext()) {
                ac next = bQJ.next();
                if (!(next == null || (eVar2 = (com.tencent.mm.plugin.appbrand.page.a.e) next.S(com.tencent.mm.plugin.appbrand.page.a.e.class)) == null)) {
                    eVar2.bLq();
                }
            }
            AppMethodBeat.o(147854);
            return;
        }
        ac currentPageView = tVar.getCurrentPageView();
        if (currentPageView == null || (eVar = (com.tencent.mm.plugin.appbrand.page.a.e) currentPageView.S(com.tencent.mm.plugin.appbrand.page.a.e.class)) == null) {
            AppMethodBeat.o(147854);
            return;
        }
        eVar.bLq();
        AppMethodBeat.o(147854);
    }

    public static final /* synthetic */ MTimerHandler a(c cVar) {
        AppMethodBeat.i(147852);
        MTimerHandler mTimerHandler = (MTimerHandler) cVar.cAs.getValue();
        AppMethodBeat.o(147852);
        return mTimerHandler;
    }

    public static final /* synthetic */ long b(c cVar) {
        AppMethodBeat.i(147853);
        long longValue = ((Number) cVar.cAr.getValue()).longValue();
        AppMethodBeat.o(147853);
        return longValue;
    }
}
