package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.content.Context;
import android.webkit.ValueCallback;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016J.\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "", "appId", "url", "event", "data", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "Companion", "plugin-brandservice_release"})
public final class a extends com.tencent.mm.plugin.ad.d {
    public static final C0883a pAc = new C0883a((byte) 0);
    private static final kotlin.f pwa = kotlin.g.ah(b.pAd);
    private String jzY = "wxa06c02b5c00ff39b";
    private final MMKVSlotManager pvV;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
    public static final class c extends q implements kotlin.g.a.q<Integer, Integer, p, Boolean> {
        final /* synthetic */ a pAe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(3);
            this.pAe = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ Boolean d(Integer num, Integer num2, p pVar) {
            boolean z;
            AppMethodBeat.i(195522);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            p pVar2 = pVar;
            kotlin.g.b.p.h(pVar2, "resPkg");
            if (intValue2 > intValue) {
                m mVar = m.IAG;
                if (m.a(pVar2, this.pAe.fXo().fWz())) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(195522);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(195522);
            return valueOf2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.q<c.EnumC0515c, Integer, String, x> {
        public static final d pAf = new d();

        static {
            AppMethodBeat.i(195524);
            AppMethodBeat.o(195524);
        }

        d() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(c.EnumC0515c cVar, Integer num, String str) {
            AppMethodBeat.i(195523);
            num.intValue();
            kotlin.g.b.p.h(cVar, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(195523);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ String oBM;
        final /* synthetic */ a pAe;
        final /* synthetic */ String pAk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar, String str, String str2, String str3) {
            super(1);
            this.pAe = aVar;
            this.oBM = str;
            this.kPQ = str2;
            this.pAk = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.m.g gVar) {
            AppMethodBeat.i(195527);
            kotlin.g.b.p.h(gVar, "cxt");
            c.a.a(this.pAe.fXo(), this.oBM, "{target:'" + this.kPQ + '\'' + this.pAk + '}', null, 4);
            x xVar = x.SXb;
            AppMethodBeat.o(195527);
            return xVar;
        }
    }

    public a() {
        AppMethodBeat.i(195542);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__WebJsEngineLocalData__");
        kotlin.g.b.p.g(mmkv, "MultiProcessMMKV.getMMKV…_WebJsEngineLocalData__\")");
        this.pvV = new MMKVSlotManager(mmkv, 15552000);
        AppMethodBeat.o(195542);
    }

    @Override // com.tencent.mm.plugin.ad.d
    public final p cnt() {
        String aWH;
        AppMethodBeat.i(195540);
        c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
        m mVar = m.IAG;
        boolean z = m.fWJ() == 1;
        m mVar2 = m.IAG;
        if (m.fWJ() == 1) {
            m mVar3 = m.IAG;
            aWH = m.aWI(this.jzY);
        } else {
            aWH = m.IAG.aWH(this.jzY);
        }
        p a2 = c.b.a(c.b.a("prefetcher/bizAd.wspkg", z, aWH, this.jzY), (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) new c(this), (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) d.pAf, true);
        AppMethodBeat.o(195540);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
    public static final class h implements com.tencent.mm.plugin.ab.q {
        private final String id;
        final /* synthetic */ String pAl;

        h(String str) {
            this.pAl = str;
            this.id = str;
        }

        @Override // com.tencent.mm.plugin.ab.q
        public final String getId() {
            return this.id;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "plugin-brandservice_release"})
    public static final class i implements k {
        final /* synthetic */ a pAe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(a aVar) {
            this.pAe = aVar;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBasePkgVersion() {
            AppMethodBeat.i(195528);
            int version = this.pAe.fXo().fWz().version();
            AppMethodBeat.o(195528);
            return version;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBizPkgVersion() {
            AppMethodBeat.i(195529);
            p cnt = this.pAe.cnt();
            if (cnt != null) {
                int version = cnt.version();
                AppMethodBeat.o(195529);
                return version;
            }
            AppMethodBeat.o(195529);
            return 0;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final boolean aD(int i2, String str) {
            AppMethodBeat.i(195530);
            kotlin.g.b.p.h(str, "cgiUrl");
            C0883a aVar = a.pAc;
            kotlin.f fVar = a.pwa;
            C0883a aVar2 = a.pAc;
            if (!n.a((CharSequence) ((String) fVar.getValue()), (CharSequence) str, false)) {
                Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "do cgi cmdId=" + i2 + ", cgiUrl=" + str + " not allowed!!");
                AppMethodBeat.o(195530);
                return false;
            }
            AppMethodBeat.o(195530);
            return true;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final void setLocalData(String str, String str2) {
            AppMethodBeat.i(195531);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(str2, "data");
            try {
                ((MultiProcessMMKV) this.pAe.pvV.getSlot()).encode(str, str2);
                Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "setLocalData:" + str + ", " + str2);
                AppMethodBeat.o(195531);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", e2, "setLocalData:" + str + ", " + str2, new Object[0]);
                AppMethodBeat.o(195531);
            }
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final String getLocalData(String str) {
            String str2;
            AppMethodBeat.i(195532);
            kotlin.g.b.p.h(str, "key");
            try {
                str2 = ((MultiProcessMMKV) this.pAe.pvV.getSlot()).decodeString(str, "");
                Log.d("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "getLocalData:" + str + ", " + str2);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", e2, "getLocalData:".concat(String.valueOf(str)), new Object[0]);
                str2 = null;
            }
            AppMethodBeat.o(195532);
            return str2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$2$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", UserDataStore.CITY, "Landroid/content/Context;", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a$i$a  reason: collision with other inner class name */
        public static final class C0884a implements com.tencent.mm.plugin.webview.d.d {
            C0884a() {
            }

            @Override // com.tencent.mm.plugin.webview.d.d
            public final void eQ(Context context) {
            }

            @Override // com.tencent.mm.plugin.webview.d.d
            public final void a(com.tencent.mm.plugin.webview.d.n nVar, com.tencent.mm.plugin.webview.d.b bVar) {
            }
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final com.tencent.mm.plugin.webview.d.d cna() {
            AppMethodBeat.i(195533);
            C0884a aVar = new C0884a();
            AppMethodBeat.o(195533);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final void fe(String str, String str2) {
            AppMethodBeat.i(195534);
            kotlin.g.b.p.h(str, "func");
            kotlin.g.b.p.h(str2, "message");
            AppMethodBeat.o(195534);
        }

        @Override // com.tencent.mm.plugin.ab.c
        public final void b(String str, String str2, ValueCallback<String> valueCallback) {
            AppMethodBeat.i(195535);
            kotlin.g.b.p.h(str, "eventType");
            kotlin.g.b.p.h(str2, "event");
            this.pAe.fXo().b(str, str2, valueCallback);
            AppMethodBeat.o(195535);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "key", "replaceAdData", "data", "plugin-brandservice_release"})
    public static final class j implements com.tencent.mm.plugin.ab.e {
        j() {
        }

        @Override // com.tencent.mm.plugin.ab.e
        public final /* synthetic */ Object getInfo(String str) {
            AppMethodBeat.i(195539);
            kotlin.g.b.p.h(str, "key");
            switch (str.hashCode()) {
                case 1196431011:
                    if (str.equals("testAdInfo")) {
                        a.C0860a aVar = com.tencent.mm.plugin.brandservice.a.pma;
                        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                        com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                        iVar.U("AdTestMode", singleMMKV.decodeInt("BizTimeLineAdTestMode", 0));
                        iVar.h("AdTestExtInfo", singleMMKV.decodeString("BizTimeLineAdTestExtInfo", ""));
                        String iVar2 = iVar.toString();
                        kotlin.g.b.p.g(iVar2, "JSONObject().apply {\n   …\n            }.toString()");
                        AppMethodBeat.o(195539);
                        return iVar2;
                    }
                    break;
                case 1700095397:
                    if (str.equals("insertedAdData")) {
                        List<z> kL = ag.ban().kL(637534257, 5);
                        if (kL != null) {
                            com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f();
                            for (T t : kL) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("msgId", String.valueOf(((z) t).field_msgId));
                                kotlin.g.b.p.g(t, "info");
                                jSONObject.put("data", t.acx());
                                fVar.bv(jSONObject);
                            }
                            String fVar2 = fVar.toString();
                            AppMethodBeat.o(195539);
                            return fVar2;
                        }
                        AppMethodBeat.o(195539);
                        return "[]";
                    }
                    break;
            }
            AppMethodBeat.o(195539);
            return null;
        }

        @Override // com.tencent.mm.plugin.ab.e
        public final void replaceAdData(String str) {
            AppMethodBeat.i(195536);
            kotlin.g.b.p.h(str, "data");
            r rVar = r.NPl;
            r.replaceAdData(str);
            AppMethodBeat.o(195536);
        }

        @Override // com.tencent.mm.plugin.ab.e
        public final String getAdContext(int i2) {
            AppMethodBeat.i(195537);
            r rVar = r.NPl;
            String ajQ = r.ajQ(i2);
            AppMethodBeat.o(195537);
            return ajQ;
        }

        @Override // com.tencent.mm.plugin.ab.e
        public final void deleteAd(String str, boolean z) {
            AppMethodBeat.i(195538);
            kotlin.g.b.p.h(str, "msgId");
            long safeParseLong = Util.safeParseLong(str);
            if (safeParseLong == 0) {
                AppMethodBeat.o(195538);
            } else if (z) {
                ag.ban().MX(safeParseLong);
                AppMethodBeat.o(195538);
            } else {
                z MM = ag.ban().MM(safeParseLong);
                if (MM != null) {
                    if (MM.field_isRead != 1) {
                        ag.ban().MX(safeParseLong);
                    }
                    AppMethodBeat.o(195538);
                    return;
                }
                AppMethodBeat.o(195538);
            }
        }
    }

    @Override // com.tencent.mm.plugin.ad.d
    public final boolean S(String str, String str2, String str3) {
        String concat;
        AppMethodBeat.i(195541);
        kotlin.g.b.p.h(str2, "event");
        if (str == null) {
            AppMethodBeat.o(195541);
            return false;
        } else if (!Util.isEqual(this.jzY, str)) {
            AppMethodBeat.o(195541);
            return false;
        } else {
            String str4 = str3;
            if (str4 == null || n.aL(str4)) {
                concat = "";
            } else {
                concat = ",".concat(String.valueOf(str3));
            }
            if (!fXp().containsKey(str)) {
                g gVar = new g(this, str2, str, concat);
                kotlin.g.b.p.h(str, "id");
                kotlin.g.b.p.h(gVar, "onCompleted");
                try {
                    com.tencent.mm.plugin.appbrand.m.g bME = fXo().bME();
                    com.tencent.mm.plugin.ab.p pVar = new com.tencent.mm.plugin.ab.p(new e(this, str));
                    kotlin.g.b.p.g(bME, "this");
                    pVar.f(bME);
                    com.tencent.mm.plugin.ac.c.a(fXo(), bME, "AdWebPrefetcherManifest#".concat(String.valueOf(str)), "manifest", (kotlin.g.a.b) null, lE("manifest", this.jzY), 8);
                    fXp().put(str, Integer.valueOf(bME.bMC()));
                    p cnt = cnt();
                    if (cnt != null) {
                        com.tencent.mm.plugin.appbrand.m.g bME2 = fXo().bME();
                        kotlin.g.b.p.g(bME2, "this");
                        com.tencent.mm.plugin.appbrand.m.g gVar2 = bME2;
                        new com.tencent.mm.plugin.ab.p(new h(str)).f(gVar2);
                        new com.tencent.mm.plugin.ab.j(new i(this)).f(gVar2);
                        new com.tencent.mm.plugin.ab.d(new j()).f(gVar2);
                        com.tencent.mm.plugin.ac.c.a(fXo(), bME2, "AdWebPrefetcher#".concat(String.valueOf(str)), "prefetcher", (kotlin.g.a.b) null, lE("prefetcher", this.jzY), 8);
                        Log.i("MicroMsg.AdWebPrefetcherJsEngineInterceptor", "configPreFetcher ".concat(String.valueOf("/prefetcher.js")));
                        c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
                        bME2.evaluateJavascript(c.b.a(cnt, "/prefetcher.js"), new f(bME2, this, str, cnt, gVar));
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AdWebPrefetcherJsEngineInterceptor", e2, "configPreFetcher id=".concat(String.valueOf(str)), new Object[0]);
                }
            } else {
                c.a.a(fXo(), str2, "{target:'" + str + '\'' + concat + '}', null, 4);
            }
            AppMethodBeat.o(195541);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configPreFetcher$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "plugin-brandservice_release"})
    public static final class e implements com.tencent.mm.plugin.ab.q {
        private final String id = this.pAg;
        final /* synthetic */ a pAe;
        final /* synthetic */ String pAg;

        e(a aVar, String str) {
            this.pAe = aVar;
            this.pAg = str;
            AppMethodBeat.i(195525);
            AppMethodBeat.o(195525);
        }

        @Override // com.tencent.mm.plugin.ab.q
        public final String getId() {
            return this.id;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "TAG", "", "cgiAllowList", "getCgiAllowList", "()Ljava/lang/String;", "cgiAllowList$delegate", "Lkotlin/Lazy;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a$a  reason: collision with other inner class name */
    public static final class C0883a {
        private C0883a() {
        }

        public /* synthetic */ C0883a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(195543);
        AppMethodBeat.o(195543);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$configPreFetcher$2$1"})
    static final class f<T> implements ValueCallback<String> {
        final /* synthetic */ a pAe;
        final /* synthetic */ String pAg;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.m.g pAh;
        final /* synthetic */ p pAi;
        final /* synthetic */ kotlin.g.a.b pAj;

        f(com.tencent.mm.plugin.appbrand.m.g gVar, a aVar, String str, p pVar, kotlin.g.a.b bVar) {
            this.pAh = gVar;
            this.pAe = aVar;
            this.pAg = str;
            this.pAi = pVar;
            this.pAj = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(195526);
            kotlin.g.a.b bVar = this.pAj;
            com.tencent.mm.plugin.appbrand.m.g gVar = this.pAh;
            kotlin.g.b.p.g(gVar, "this@apply");
            bVar.invoke(gVar);
            AppMethodBeat.o(195526);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<String> {
        public static final b pAd = new b();

        static {
            AppMethodBeat.i(195521);
            AppMethodBeat.o(195521);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ String invoke() {
            return "/cgi-bin/mmbiz-bin/recommend/timelinecard";
        }
    }
}
