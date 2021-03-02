package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007J0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewPreloadManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "createWebViewHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enablePreloadNextWebViewAfterGet", "", "enablePreloadWebView", "enablePreloadWebViewFromFindTab", "syncObject", "createBoxWebView", "fetchBoxWebView", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function3;", "", "getCachedBoxWebView", "preloadBoxWebView", "delay", "", "preloadBoxWebViewInner", "runTask", "block", "Lkotlin/Function0;", "startPreloadBoxWebView", "scene", "", "Scene", "plugin-scan_release"})
public final class h {
    private static volatile BoxWebView CCp;
    private static boolean CCq;
    private static boolean CCr;
    private static boolean CCs;
    private static Object CCt = new Object();
    private static MMHandler CCu = new MMHandler(Looper.getMainLooper());
    public static final h CCv = new h();

    static {
        boolean z;
        AppMethodBeat.i(240252);
        CCr = CCq;
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_goods_enable_preload_webview, 0);
        int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_goods_enable_preload_webview_from_find_tab, 0);
        CCq = a2 == 1 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED;
        if (a3 == 1 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
            z = true;
        } else {
            z = false;
        }
        CCs = z;
        CCr = CCq;
        Log.i("MicroMsg.BoxWebViewPreloadManager", "init enablePreloadWebView config: %d, configFindTab: %d, enablePreload: %b, enablePreloadAfterGet: %b, enablePreloadFromFindTab: %b", Integer.valueOf(a2), Integer.valueOf(a3), Boolean.valueOf(CCq), Boolean.valueOf(CCr), Boolean.valueOf(CCs));
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.BoxWebViewPreloadManager", "createWebViewHandlerThread start cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(240252);
    }

    private h() {
    }

    public static final /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(240253);
        hVar.ePm();
        AppMethodBeat.o(240253);
    }

    public static final void aC(int i2, long j2) {
        AppMethodBeat.i(240248);
        if (!CCq) {
            AppMethodBeat.o(240248);
            return;
        }
        if ((i2 == 1 && CCr) || (i2 == 2 && CCs)) {
            Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo preloadBoxWebView delay: %d", Long.valueOf(j2));
            a aVar = a.CCw;
            MMHandler mMHandler = CCu;
            if (mMHandler != null) {
                mMHandler.postDelayed(new b(aVar), j2);
                AppMethodBeat.o(240248);
                return;
            }
        }
        AppMethodBeat.o(240248);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ kotlin.g.a.a hvp;

        b(kotlin.g.a.a aVar) {
            this.hvp = aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
        public static final class a implements MessageQueue.IdleHandler {
            final /* synthetic */ kotlin.g.a.a hvp;

            public a(kotlin.g.a.a aVar) {
                this.hvp = aVar;
            }

            public final boolean queueIdle() {
                AppMethodBeat.i(240246);
                Looper.myQueue().removeIdleHandler(this);
                this.hvp.invoke();
                AppMethodBeat.o(240246);
                return false;
            }
        }

        public final void run() {
            AppMethodBeat.i(240247);
            Looper.myQueue().addIdleHandler(new a(this.hvp));
            AppMethodBeat.o(240247);
        }
    }

    public static final BoxWebView a(Context context, q<? super Boolean, ? super Boolean, ? super Boolean, x> qVar) {
        boolean z;
        AppMethodBeat.i(240249);
        p.h(context, "context");
        p.h(qVar, "callback");
        BoxWebView ePl = ePl();
        if (ePl == null) {
            ePl = new BoxWebView(context);
            z = false;
        } else {
            ePl.aG(context);
            z = true;
        }
        qVar.d(Boolean.valueOf(CCq), Boolean.valueOf(CCs), Boolean.valueOf(z));
        if (CCr) {
            aC(1, 1500);
        }
        AppMethodBeat.o(240249);
        return ePl;
    }

    private static BoxWebView ePl() {
        BoxWebView boxWebView = null;
        AppMethodBeat.i(240250);
        synchronized (CCt) {
            try {
                if (CCp != null) {
                    BoxWebView boxWebView2 = CCp;
                    if (boxWebView2 == null) {
                        p.hyc();
                    }
                    if (!boxWebView2.isDestroyed()) {
                        Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo fetchBoxWebView use preload webView");
                        boxWebView = CCp;
                        CCp = null;
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(240250);
            }
        }
        return boxWebView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0.isDestroyed() != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void ePm() {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.h.ePm():void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final a CCw = new a();

        static {
            AppMethodBeat.i(240245);
            AppMethodBeat.o(240245);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(240244);
            h.a(h.CCv);
            x xVar = x.SXb;
            AppMethodBeat.o(240244);
            return xVar;
        }
    }
}
