package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ab.r;
import com.tencent.mm.plugin.ab.s;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0015H\u0002J4\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0015H\u0016J \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "localData", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getLocalData", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "localData$delegate", "Lkotlin/Lazy;", "create", "", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "inject", "", "type", "", "script", "onCallback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "domain", "Companion", "plugin-brandservice_release"})
public final class l extends com.tencent.mm.plugin.ad.d {
    public static final a pCE = new a((byte) 0);
    private String jzY = "__Mp_Prefetcher_FakeAppId";
    private final kotlin.f pCD = kotlin.g.ah(d.pCI);

    static {
        AppMethodBeat.i(195619);
        AppMethodBeat.o(195619);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x> {
        final /* synthetic */ String pCF;
        final /* synthetic */ kotlin.g.a.b pCG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, kotlin.g.a.b bVar) {
            super(1);
            this.pCF = str;
            this.pCG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.m.g gVar) {
            AppMethodBeat.i(195604);
            com.tencent.mm.plugin.appbrand.m.g gVar2 = gVar;
            p.h(gVar2, "jsContext");
            gVar2.evaluateJavascript(this.pCF, new ValueCallback<String>(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.b.AnonymousClass1 */
                final /* synthetic */ b pCH;

                {
                    this.pCH = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(195603);
                    String str2 = str;
                    Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "inject callback:".concat(String.valueOf(str2)));
                    kotlin.g.a.b bVar = this.pCH.pCG;
                    p.g(str2, LocaleUtil.ITALIAN);
                    bVar.invoke(str2);
                    AppMethodBeat.o(195603);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(195604);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class c<T> implements ValueCallback<String> {
        final /* synthetic */ kotlin.g.a.b pCG;

        c(kotlin.g.a.b bVar) {
            this.pCG = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(195605);
            String str2 = str;
            Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "inject callback:".concat(String.valueOf(str2)));
            kotlin.g.a.b bVar = this.pCG;
            p.g(str2, LocaleUtil.ITALIAN);
            bVar.invoke(str2);
            AppMethodBeat.o(195605);
        }
    }

    public l() {
        AppMethodBeat.i(195618);
        AppMethodBeat.o(195618);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
    public static final class e implements com.tencent.mm.plugin.ab.q {
        private final String id;
        final /* synthetic */ String pAl;

        e(String str) {
            this.pAl = str;
            this.id = str;
        }

        @Override // com.tencent.mm.plugin.ab.q
        public final String getId() {
            return this.id;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "cacheVideo", "", "data", "", "plugin-brandservice_release"})
    public static final class f implements s {
        f() {
        }

        @Override // com.tencent.mm.plugin.ab.s
        public final void cacheVideo(String str) {
            AppMethodBeat.i(195608);
            p.h(str, "data");
            Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] cacheVideo, data = ".concat(String.valueOf(str)));
            e eVar = e.pAN;
            p.h(str, "data");
            try {
                com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f(str);
                int length = fVar.length();
                for (int i2 = 0; i2 < length; i2++) {
                    i pY = fVar.pY(i2);
                    String optString = pY.optString("url");
                    long optLong = pY.optLong("position");
                    int optInt = pY.optInt("preloadType");
                    long aM = j.aM(j.aN(pY.optLong("length"), 10485760), 512000);
                    if (Util.isNullOrNil(optString)) {
                        Log.w("MicroMsg.BizVideoPreloadLogic", "cacheVideo url is null");
                        AppMethodBeat.o(195608);
                        return;
                    }
                    String str2 = optInt == 0 ? ToolsMpProcessIPCService.dkO : Appbrand0IPCService.dkO;
                    p.g(str2, "processName");
                    p.g(optString, "url");
                    eVar.c(str2, optString, optLong, aM);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.BizVideoPreloadLogic", "cacheVideo ex " + e2.getMessage());
            }
            AppMethodBeat.o(195608);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0017J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0017J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
    public static final class g implements k {
        private final int pCJ;
        final /* synthetic */ l pCK;
        final /* synthetic */ String pCL;

        g(l lVar, String str) {
            this.pCK = lVar;
            this.pCL = str;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBasePkgVersion() {
            AppMethodBeat.i(195609);
            int version = this.pCK.fXo().fWz().version();
            AppMethodBeat.o(195609);
            return version;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBizPkgVersion() {
            return this.pCJ;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final boolean aD(int i2, String str) {
            AppMethodBeat.i(195610);
            p.h(str, "cgiUrl");
            AppMethodBeat.o(195610);
            return false;
        }

        @Override // com.tencent.mm.plugin.ab.k
        @JavascriptInterface
        public final void setLocalData(String str, String str2) {
            AppMethodBeat.i(195611);
            p.h(str, "key");
            p.h(str2, "data");
            Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] setLocalData key = " + str + ", data = " + str2);
            ((MultiProcessMMKV) l.a(this.pCK).getSlot()).encode(this.pCL + ':' + str, str2);
            AppMethodBeat.o(195611);
        }

        @Override // com.tencent.mm.plugin.ab.k
        @JavascriptInterface
        public final String getLocalData(String str) {
            AppMethodBeat.i(195612);
            p.h(str, "key");
            String decodeString = ((MultiProcessMMKV) l.a(this.pCK).getSlot()).decodeString(this.pCL + ':' + str);
            if (decodeString == null) {
                decodeString = "";
            }
            Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] getLocalData key = " + str + ", data = " + decodeString);
            AppMethodBeat.o(195612);
            return decodeString;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$3$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", UserDataStore.CITY, "Landroid/content/Context;", "plugin-brandservice_release"})
        public static final class a implements com.tencent.mm.plugin.webview.d.d {
            a() {
            }

            @Override // com.tencent.mm.plugin.webview.d.d
            public final void eQ(Context context) {
            }

            @Override // com.tencent.mm.plugin.webview.d.d
            public final void a(n nVar, com.tencent.mm.plugin.webview.d.b bVar) {
            }
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final com.tencent.mm.plugin.webview.d.d cna() {
            AppMethodBeat.i(195613);
            a aVar = new a();
            AppMethodBeat.o(195613);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final void fe(String str, String str2) {
            AppMethodBeat.i(195614);
            p.h(str, "func");
            p.h(str2, "message");
            AppMethodBeat.o(195614);
        }

        @Override // com.tencent.mm.plugin.ab.c
        public final void b(String str, String str2, ValueCallback<String> valueCallback) {
            AppMethodBeat.i(195615);
            p.h(str, "eventType");
            p.h(str2, "event");
            this.pCK.fXo().b(str, str2, valueCallback);
            AppMethodBeat.o(195615);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$4", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "plugin-brandservice_release"})
    public static final class h implements com.tencent.mm.plugin.ab.c {
        final /* synthetic */ l pCK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(l lVar) {
            this.pCK = lVar;
        }

        @Override // com.tencent.mm.plugin.ab.c
        public final void b(String str, String str2, ValueCallback<String> valueCallback) {
            AppMethodBeat.i(195616);
            p.h(str, "eventType");
            p.h(str2, "event");
            this.pCK.fXo().b(str, str2, valueCallback);
            AppMethodBeat.o(195616);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<MMKVSlotManager> {
        public static final d pCI = new d();

        static {
            AppMethodBeat.i(195607);
            AppMethodBeat.o(195607);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMKVSlotManager invoke() {
            AppMethodBeat.i(195606);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("PrefechLocalData");
            p.g(mmkv, "MultiProcessMMKV.getMMKV(\"PrefechLocalData\")");
            MMKVSlotManager mMKVSlotManager = new MMKVSlotManager(mmkv, 2592000);
            AppMethodBeat.o(195606);
            return mMKVSlotManager;
        }
    }

    @Override // com.tencent.mm.plugin.ad.d
    public final boolean a(com.tencent.mm.plugin.ad.a aVar, String str, kotlin.g.a.b<? super String, x> bVar) {
        AppMethodBeat.i(195617);
        p.h(aVar, "manifest");
        p.h(str, "script");
        p.h(bVar, "onCallback");
        String str2 = aVar.ICt.LQV;
        p.g(str2, "manifest.manifest.ManifestUrl");
        String aWU = com.tencent.mm.plugin.ad.e.aWU(str2);
        if (!fXp().containsKey(aWU)) {
            b bVar2 = new b(str, bVar);
            String str3 = aVar.ICs.LQP;
            Log.i("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "create domain:" + str3 + '#' + aWU);
            try {
                com.tencent.mm.plugin.appbrand.m.g bME = fXo().bME();
                p.g(bME, "this");
                com.tencent.mm.plugin.appbrand.m.g gVar = bME;
                p.g(str3, "domain");
                new com.tencent.mm.plugin.ab.p(new e(aWU)).f(gVar);
                new r(new f()).f(gVar);
                new com.tencent.mm.plugin.ab.j(new g(this, str3)).f(gVar);
                new com.tencent.mm.plugin.ab.i(new h(this)).f(gVar);
                com.tencent.mm.plugin.ac.c.a(fXo(), bME, "MpWebPrefetcherManifest#".concat(String.valueOf(aWU)), "manifest", (kotlin.g.a.b) null, lE("manifest", this.jzY), 8);
                fXp().put(aWU, Integer.valueOf(bME.bMC()));
                bVar2.invoke(bME);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MpWebPrefetcherJsEngineInterceptor", e2, "create id=".concat(String.valueOf(aWU)), new Object[0]);
            }
        } else {
            com.tencent.mm.plugin.ac.c fXo = fXo();
            Integer num = fXp().get(aWU);
            if (num == null) {
                p.hyc();
            }
            p.g(num, "contextMap[id]!!");
            fXo.xX(num.intValue()).evaluateJavascript(str, new c(bVar));
        }
        AppMethodBeat.o(195617);
        return true;
    }

    public static final /* synthetic */ MMKVSlotManager a(l lVar) {
        AppMethodBeat.i(195620);
        MMKVSlotManager mMKVSlotManager = (MMKVSlotManager) lVar.pCD.getValue();
        AppMethodBeat.o(195620);
        return mMKVSlotManager;
    }
}
