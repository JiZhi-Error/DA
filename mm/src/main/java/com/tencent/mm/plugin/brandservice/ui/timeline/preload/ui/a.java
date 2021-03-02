package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0007H\u0007J*\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020#H\u0007J\u000e\u0010%\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0007J\u0010\u0010&\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\f\u0010'\u001a\u00020#*\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "clear", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "MPWebView", "plugin-brandservice_release"})
public final class a {
    private static final String TAG = TAG;
    private static final ConcurrentHashMap<Integer, MpWebViewController> pGM = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, MpWebViewController> pGN = new ConcurrentHashMap<>();
    private static boolean pGO;
    private static MultiProcessMMKV.NativeBuffer pGP = new MultiProcessMMKV.NativeBuffer(0, 0);
    public static final a pGQ = new a();

    static {
        AppMethodBeat.i(6940);
        AppMethodBeat.o(6940);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(6941);
        aVar.DI(i2);
        AppMethodBeat.o(6941);
    }

    public static final void cpJ() {
        AppMethodBeat.i(6929);
        DH(-1);
        AppMethodBeat.o(6929);
    }

    public static void DH(int i2) {
        AppMethodBeat.i(6930);
        j.a aVar = j.pCC;
        if (j.a.cob()) {
            AppMethodBeat.o(6930);
        } else if (pGO) {
            AppMethodBeat.o(6930);
        } else {
            Log.i(TAG, "tryPreloadTmplWebview:".concat(String.valueOf(i2)));
            d.h(new c(i2));
            AppMethodBeat.o(6930);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int pGV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(int i2) {
            super(0);
            this.pGV = i2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a$c$a  reason: collision with other inner class name */
        public static final class C0891a implements MessageQueue.IdleHandler {
            final /* synthetic */ c pGW;

            public C0891a(c cVar) {
                this.pGW = cVar;
            }

            public final boolean queueIdle() {
                AppMethodBeat.i(195871);
                Looper.myQueue().removeIdleHandler(this);
                if (this.pGW.pGV == -1) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b bVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.pFr;
                    for (Integer num : com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coQ()) {
                        a.a(a.pGQ, num.intValue());
                    }
                } else {
                    a.a(a.pGQ, this.pGW.pGV);
                }
                AppMethodBeat.o(195871);
                return false;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195872);
            Looper.myQueue().addIdleHandler(new C0891a(this));
            x xVar = x.SXb;
            AppMethodBeat.o(195872);
            return xVar;
        }
    }

    private final synchronized void DI(int i2) {
        AppMethodBeat.i(6931);
        Log.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(i2)));
        eic DE = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DE(i2);
        if (DE == null) {
            AppMethodBeat.o(6931);
        } else if (!pGM.containsKey(Integer.valueOf(i2))) {
            MpWebViewController a2 = a(DE, new MutableContextWrapper(MMApplicationContext.getContext()));
            if (a2 != null) {
                pGM.put(Integer.valueOf(i2), a2);
                MpWebViewController.f fVar = MpWebViewController.pGg;
                int cpq = MpWebViewController.cpq();
                b bVar = new b(a2, i2);
                p.h(bVar, "callback");
                a2.afG(cpq).add(bVar);
                Log.i(TAG, "preload:" + i2 + ", " + a2.fZu());
                AppMethodBeat.o(6931);
            } else {
                AppMethodBeat.o(6931);
            }
        } else {
            Log.i(TAG, "preload skip when exist:".concat(String.valueOf(i2)));
            AppMethodBeat.o(6931);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void ai(android.content.Intent r8) {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.ai(android.content.Intent):void");
    }

    private final synchronized MpWebViewController c(int i2, Intent intent) {
        MpWebViewController mpWebViewController;
        AppMethodBeat.i(195874);
        mpWebViewController = pGN.get(Integer.valueOf(i2));
        if (mpWebViewController == null || !mpWebViewController.ah(intent)) {
            mpWebViewController = pGM.get(Integer.valueOf(i2));
            if (mpWebViewController != null) {
                if (mpWebViewController.afI(MpWebViewController.pFW)) {
                    pGM.remove(Integer.valueOf(i2));
                    Log.i(TAG, "pick cached:" + i2 + ", " + mpWebViewController.fZu());
                    AppMethodBeat.o(195874);
                } else {
                    Log.w(TAG, "pick null when tmpl not ready:" + i2 + ", " + mpWebViewController.fZu());
                }
            }
            Log.w(TAG, "pick null:".concat(String.valueOf(i2)));
            mpWebViewController = null;
            AppMethodBeat.o(195874);
        } else {
            Log.i(TAG, "pick started:" + i2 + ", " + mpWebViewController.fZu());
            pGN.remove(Integer.valueOf(i2));
            AppMethodBeat.o(195874);
        }
        return mpWebViewController;
    }

    private static MpWebViewController a(eic eic, MutableContextWrapper mutableContextWrapper) {
        AppMethodBeat.i(195875);
        if (eic.pCV == -1) {
            Log.w(TAG, "[preloadWebViewInner] empty tmplType %d", Integer.valueOf(eic.pCV));
            AppMethodBeat.o(195875);
            return null;
        } else if (Util.isNullOrNil(eic.ISo)) {
            Log.w(TAG, "[preloadWebViewInner] initUrl " + eic.ISo + " is empty");
            AppMethodBeat.o(195875);
            return null;
        } else if (!s.YS(eic.Nhr)) {
            Log.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", eic.Nhr);
            AppMethodBeat.o(195875);
            return null;
        } else {
            MpWebViewController mpWebViewController = new MpWebViewController(eic, eR(mutableContextWrapper));
            mpWebViewController.init();
            AppMethodBeat.o(195875);
            return mpWebViewController;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016R$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "validUrlProxy", "Lkotlin/Function1;", "", "getValidUrlProxy", "()Lkotlin/jvm/functions/Function1;", "setValidUrlProxy", "(Lkotlin/jvm/functions/Function1;)V", "getUrl", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a$a  reason: collision with other inner class name */
    public static final class C0890a extends MMWebView {
        private kotlin.g.a.a<String> pGR;
        private kotlin.g.a.b<? super String, Boolean> pGS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0890a(Context context) {
            super(context);
            p.h(context, "context");
            AppMethodBeat.i(195869);
            this.gKM = true;
            this.isX5Kernel = getIsX5Kernel();
            AppMethodBeat.o(195869);
        }

        public final kotlin.g.a.a<String> getCurrentUrlProxy() {
            return this.pGR;
        }

        public final void setCurrentUrlProxy(kotlin.g.a.a<String> aVar) {
            this.pGR = aVar;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.String, java.lang.Boolean>, kotlin.g.a.b<java.lang.String, java.lang.Boolean> */
        public final kotlin.g.a.b<String, Boolean> getValidUrlProxy() {
            return this.pGS;
        }

        public final void setValidUrlProxy(kotlin.g.a.b<? super String, Boolean> bVar) {
            this.pGS = bVar;
        }

        @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
        public final String getUrl() {
            AppMethodBeat.i(195868);
            String url = super.getUrl();
            if (!(this.pGR == null || this.pGS == null)) {
                kotlin.g.a.b<? super String, Boolean> bVar = this.pGS;
                if (bVar == null) {
                    p.hyc();
                }
                if (!bVar.invoke(url).booleanValue()) {
                    kotlin.g.a.a<String> aVar = this.pGR;
                    if (aVar == null) {
                        p.hyc();
                    }
                    String invoke = aVar.invoke();
                    AppMethodBeat.o(195868);
                    return invoke;
                }
            }
            AppMethodBeat.o(195868);
            return url;
        }
    }

    private static MMWebView eR(Context context) {
        String str;
        AppMethodBeat.i(195876);
        WebView.c cVar = MMWebView.QDR;
        if (MMApplicationContext.isMainProcess()) {
            str = "mm";
        } else if (MMApplicationContext.isToolsMpProcess()) {
            str = "toolsmp";
        } else {
            str = "tools";
        }
        WebView.initWebviewCore(context, cVar, str, null);
        C0890a aVar = new C0890a(context);
        AppMethodBeat.o(195876);
        return aVar;
    }

    public static final synchronized MpWebViewController a(Context context, eic eic, Intent intent) {
        MpWebViewController c2;
        synchronized (a.class) {
            AppMethodBeat.i(195877);
            p.h(context, "context");
            p.h(eic, "tmplParams");
            p.h(intent, "intent");
            long now = MMSlotKt.now();
            Log.v(TAG, "[obtainPreloadWebview]tmplParams:" + eic.pCV);
            c2 = pGQ.c(eic.pCV, intent);
            if (c2 != null) {
                Log.v(TAG, "[obtainPreloadWebview] preloadWebviews");
                MMWebView mMWebView = c2.pGj;
                mMWebView.getPerformanceHelper().bN("onCreateStart", now);
                mMWebView.aG(context);
                mMWebView.getPerformanceHelper().bN("onCreateEnd", MMSlotKt.now());
                AppMethodBeat.o(195877);
            } else {
                c2 = null;
                AppMethodBeat.o(195877);
            }
        }
        return c2;
    }

    public static final synchronized MpWebViewController a(Context context, eic eic) {
        MpWebViewController a2;
        synchronized (a.class) {
            AppMethodBeat.i(195878);
            p.h(context, "context");
            p.h(eic, "tmplParams");
            long now = MMSlotKt.now();
            Log.v(TAG, "[obtainTmplWebView]tmplParams:" + eic.pCV);
            a2 = a(eic, new MutableContextWrapper(context));
            if (a2 != null) {
                a2.pGj.getPerformanceHelper().bN("onCreateStart", now);
                a2.pGj.getPerformanceHelper().bN("onCreateEnd", MMSlotKt.now());
                AppMethodBeat.o(195878);
            } else {
                a2 = null;
                AppMethodBeat.o(195878);
            }
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$preloadWebViewInner$1$1$1", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$$special$$inlined$also$lambda$1"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MpWebViewController pGT;
        final /* synthetic */ int pGU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MpWebViewController mpWebViewController, int i2) {
            super(0);
            this.pGT = mpWebViewController;
            this.pGU = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195870);
            a aVar = a.pGQ;
            if (p.j((MpWebViewController) a.pGM.get(Integer.valueOf(this.pGU)), this.pGT)) {
                a aVar2 = a.pGQ;
                a.pGM.remove(Integer.valueOf(this.pGU));
                this.pGT.destroy();
                a aVar3 = a.pGQ;
                Log.e(a.TAG, "remove preload when tmpl fail:" + this.pGU + ", " + this.pGT.fZu());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195870);
            return xVar;
        }
    }
}
