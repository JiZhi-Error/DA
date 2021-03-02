package com.tencent.mm.plugin.ad;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mapsdk.rastercore.tools.IO;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.WebResourceResponse;
import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Result;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004H&J,\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001c0*H\u0002J,\u0010,\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004H\u0016J\u0010\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\u0004H\u0014J\u0016\u00103\u001a\u0002042\u0006\u00102\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\b\u00105\u001a\u00020\u0004H\u0016J2\u00106\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0*J7\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00042\u0012\b\u0002\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<H@ø\u0001\u0000¢\u0006\u0002\u0010>J>\u00109\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00042\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<2\u0014\u0010?\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u001c0*J \u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020B2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0004H\u0014R\u0010\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0004\n\u0002\b\u0005R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "()V", "TAG", "", "TAG$1", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "getInterceptors", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg$delegate", "Lkotlin/Lazy;", "addInterceptor", "", "interceptor", "bizPkg", "appId", "hasAssets", "", "clearAll", "clearCache", "domain", "create", "id", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "url", "event", "data", "getClientConfig", "Lcom/tencent/mm/json/JSONObject;", "type", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "getEngineName", "inject", "script", "onCallback", "invoke", "func", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "onConfigClient", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "onTransferMessage", "message", "targetOrigin", "Companion", "webview-sdk_release"})
public abstract class c extends com.tencent.mm.plugin.ac.c {
    public static final a ICA = new a((byte) 0);
    private static final kotlin.f ICv = kotlin.g.ah(b.ICG);
    private static final b ICw = new b("wcf://WebPrefetchContent/");
    private static final b ICx = new b("wcf://WebPrefetchResource/");
    private static final b ICy = new b("wcf://WebPrefetchManifest/");
    private static final Map<String, String> ICz = ae.e(s.U("js", "application/javascript"), s.U("json", "application/json"));
    private static final String TAG = TAG;
    private static final Set<String> pFb = ak.setOf("transfer-encoding");
    private static final MMKVSlotManager pvV;
    public final HashMap<String, Integer> IBO;
    public final ConcurrentLinkedDeque<d> ICu = new ConcurrentLinkedDeque<>();
    private final com.tencent.mm.plugin.ac.g IzE = new com.tencent.mm.plugin.ac.g();
    private final kotlin.f IzH = kotlin.g.ah(l.ICN);
    private final String gVB = TAG;

    public abstract void aer(String str);

    @Override // com.tencent.mm.plugin.ac.c
    public final p fWz() {
        return (p) this.IzH.getValue();
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "assetsVersion", "", "resVersion", "resPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.ad.c$c  reason: collision with other inner class name */
    public static final class C0526c extends q implements kotlin.g.a.q<Integer, Integer, p, Boolean> {
        final /* synthetic */ c ICB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0526c(c cVar) {
            super(3);
            this.ICB = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ Boolean d(Integer num, Integer num2, p pVar) {
            boolean z;
            AppMethodBeat.i(224929);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            p pVar2 = pVar;
            kotlin.g.b.p.h(pVar2, "resPkg");
            if (intValue2 > intValue) {
                m mVar = m.IAG;
                if (m.a(pVar2, this.ICB.fWz())) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(224929);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(224929);
            return valueOf2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.q<c.EnumC0515c, Integer, String, x> {
        public static final d ICH = new d();

        static {
            AppMethodBeat.i(224931);
            AppMethodBeat.o(224931);
        }

        d() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(c.EnumC0515c cVar, Integer num, String str) {
            AppMethodBeat.i(224930);
            num.intValue();
            kotlin.g.b.p.h(cVar, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(224930);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "cxt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "invoke"})
    public static final class h extends q implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.m.g, x> {
        final /* synthetic */ c ICB;
        final /* synthetic */ String ICL;
        final /* synthetic */ List ICM;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ String pAl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar, String str, String str2, List list, kotlin.g.a.b bVar) {
            super(1);
            this.ICB = cVar;
            this.pAl = str;
            this.ICL = str2;
            this.ICM = list;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.m.g gVar) {
            AppMethodBeat.i(224935);
            kotlin.g.b.p.h(gVar, "cxt");
            this.ICB.a((c) this.pAl, this.ICL, (String) this.ICM, (List) this.gWe);
            x xVar = x.SXb;
            AppMethodBeat.o(224935);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class i extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ kotlin.d.d iCb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(kotlin.d.d dVar) {
            super(1);
            this.iCb = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(224936);
            kotlin.d.d dVar = this.iCb;
            Result.Companion companion = Result.Companion;
            dVar.resumeWith(Result.m46constructorimpl(str));
            x xVar = x.SXb;
            AppMethodBeat.o(224936);
            return xVar;
        }
    }

    public c() {
        com.tencent.mm.plugin.ab.i iVar = new com.tencent.mm.plugin.ab.i(this);
        com.tencent.mm.plugin.appbrand.m.g bMD = bMD();
        kotlin.g.b.p.g(bMD, "mainJsContext");
        iVar.f(bMD);
        P(null);
        new o.a(this) {
            /* class com.tencent.mm.plugin.ad.c.AnonymousClass1 */
            final /* synthetic */ c ICB;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ICB = r1;
            }

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(String str) {
                AppMethodBeat.i(224913);
                kotlin.g.b.p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                Log.i(this.ICB.gVB, "jsEngine resume");
                this.ICB.resume();
                AppMethodBeat.o(224913);
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(String str) {
                AppMethodBeat.i(224914);
                kotlin.g.b.p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                Log.i(this.ICB.gVB, "jsEngine pause");
                this.ICB.pause();
                AppMethodBeat.o(224914);
            }
        }.alive();
        this.IBO = new HashMap<>();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final p byw(String str) {
        boolean z;
        String aWH;
        String str2 = "prefetcher/" + str + ".wspkg";
        m mVar = m.IAG;
        if (m.fWJ() == 1) {
            z = true;
        } else {
            z = false;
        }
        m mVar2 = m.IAG;
        if (m.fWJ() == 1) {
            m mVar3 = m.IAG;
            aWH = m.aWI(str);
        } else {
            aWH = m.IAG.aWH(str);
        }
        return c.b.a(c.b.a(str2, z, aWH, str), (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) new C0526c(this), (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) d.ICH, false);
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final com.tencent.mm.plugin.ac.g fWy() {
        return this.IzE;
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final void ly(String str, String str2) {
        kotlin.g.b.p.h(str, "message");
        kotlin.g.b.p.h(str2, "targetOrigin");
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final String fXf() {
        return "WebPrefetcherJsEngine";
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final c.a aWx(String str) {
        kotlin.g.b.p.h(str, "type");
        return new c.a("wx97b7aebac2183fd2", aWQ(str).getLong("idKey"));
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final com.tencent.mm.ab.i aWQ(String str) {
        kotlin.g.b.p.h(str, "type");
        com.tencent.mm.ab.i FJ = fWB().FJ("client").FJ(str);
        kotlin.g.b.p.g(FJ, "vmConfig.getJSONObject(\"…ent\").getJSONObject(type)");
        return FJ;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "webview-sdk_release"})
    public static final class e implements com.tencent.mm.plugin.ab.q {
        final /* synthetic */ c ICB;
        final /* synthetic */ z.f ICI;
        final /* synthetic */ z.f ICJ;
        final /* synthetic */ String ICK;
        private final String id = this.pAg;
        final /* synthetic */ String pAg;
        final /* synthetic */ kotlin.g.a.b pAj;

        e(c cVar, String str, z.f fVar, z.f fVar2, String str2, kotlin.g.a.b bVar) {
            this.ICB = cVar;
            this.pAg = str;
            this.ICI = fVar;
            this.ICJ = fVar2;
            this.ICK = str2;
            this.pAj = bVar;
            AppMethodBeat.i(224932);
            AppMethodBeat.o(224932);
        }

        @Override // com.tencent.mm.plugin.ab.q
        public final String getId() {
            return this.id;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$1", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "id", "", "getId", "()Ljava/lang/String;", "webview-sdk_release"})
    public static final class j implements com.tencent.mm.plugin.ab.q {
        private final String id;
        final /* synthetic */ String pAl;

        j(String str) {
            this.pAl = str;
            this.id = str;
        }

        @Override // com.tencent.mm.plugin.ab.q
        public final String getId() {
            return this.id;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "getLocalData", "key", "onInvoke", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"})
    public static final class k implements com.tencent.mm.plugin.ab.k {
        final /* synthetic */ c ICB;
        final /* synthetic */ String kPQ;

        k(c cVar, String str) {
            this.ICB = cVar;
            this.kPQ = str;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBasePkgVersion() {
            AppMethodBeat.i(224937);
            int version = this.ICB.fWz().version();
            AppMethodBeat.o(224937);
            return version;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final int getBizPkgVersion() {
            AppMethodBeat.i(224938);
            p byw = this.ICB.byw(this.kPQ);
            int intValue = (byw != null ? Integer.valueOf(byw.version()) : null).intValue();
            AppMethodBeat.o(224938);
            return intValue;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final boolean aD(int i2, String str) {
            AppMethodBeat.i(224939);
            kotlin.g.b.p.h(str, "cgiUrl");
            AppMethodBeat.o(224939);
            return false;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final void setLocalData(String str, String str2) {
            AppMethodBeat.i(224940);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(str2, "data");
            try {
                a aVar = c.ICA;
                ((MultiProcessMMKV) c.pvV.getSlot()).encode(this.kPQ + '-' + str, str2);
                Log.d(this.ICB.gVB, "setLocalData:" + str + ", " + str2);
                AppMethodBeat.o(224940);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ICB.gVB, e2, "setLocalData:" + str + ", " + str2, new Object[0]);
                AppMethodBeat.o(224940);
            }
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final String getLocalData(String str) {
            String str2;
            AppMethodBeat.i(224941);
            kotlin.g.b.p.h(str, "key");
            try {
                a aVar = c.ICA;
                str2 = ((MultiProcessMMKV) c.pvV.getSlot()).decodeString(this.kPQ + '-' + str, "");
                Log.d(this.ICB.gVB, "getLocalData:" + str + ", " + str2);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.ICB.gVB, e2, "getLocalData:".concat(String.valueOf(str)), new Object[0]);
                str2 = null;
            }
            AppMethodBeat.o(224941);
            return str2;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$onConfigClient$2$jsApiHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "dealMsg", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "callbackHandler", "Lcom/tencent/mm/plugin/webview/jsapi/ICallbackHandler;", "setJsEngineContext", UserDataStore.CITY, "Landroid/content/Context;", "webview-sdk_release"})
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
            AppMethodBeat.i(224942);
            a aVar = new a();
            AppMethodBeat.o(224942);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.ab.k
        public final void fe(String str, String str2) {
            AppMethodBeat.i(224943);
            kotlin.g.b.p.h(str, "func");
            kotlin.g.b.p.h(str2, "message");
            AppMethodBeat.o(224943);
        }

        @Override // com.tencent.mm.plugin.ab.c
        public final void b(String str, String str2, ValueCallback<String> valueCallback) {
            AppMethodBeat.i(224944);
            kotlin.g.b.p.h(str, "eventType");
            kotlin.g.b.p.h(str2, "event");
            this.ICB.b(str, str2, valueCallback);
            AppMethodBeat.o(224944);
        }
    }

    public final Object a(a aVar, String str, List<? extends Object> list, kotlin.d.d<? super String> dVar) {
        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
        a(aVar, str, list, new i(hVar));
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            kotlin.g.b.p.h(dVar, "frame");
        }
        return hxK;
    }

    public final void a(d dVar) {
        kotlin.g.b.p.h(dVar, "interceptor");
        dVar.b(this);
        this.ICu.add(dVar);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000bJ\u0012\u0010&\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u001a\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$Companion;", "", "()V", "HEADER_TRANSFER_ENCODING", "", "TAG", "WEB_PREFECHER_INVALID_HEADERS", "", "getWEB_PREFECHER_INVALID_HEADERS", "()Ljava/util/Set;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "manifestContent", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "getManifestContent", "()Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherFile;", "mimeMap", "", "prefetchBasePkgAppId", "prefetchUsePkgOpen", "", "getPrefetchUsePkgOpen", "()Z", "prefetchUsePkgOpen$delegate", "Lkotlin/Lazy;", "resContent", "getResContent", "webContent", "getWebContent", "getMimeType", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "match", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "settingManager", "matchDebugManifest", "host", "matchResource", "Lcom/tencent/xweb/WebResourceResponse;", "appId", "webview-sdk_release"})
    public static final class a {
        public static boolean fXn() {
            AppMethodBeat.i(224925);
            kotlin.f fVar = c.ICv;
            a aVar = c.ICA;
            boolean booleanValue = ((Boolean) fVar.getValue()).booleanValue();
            AppMethodBeat.o(224925);
            return booleanValue;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.ad.c$a$a  reason: collision with other inner class name */
        public static final class C0524a extends q implements kotlin.g.a.q<Integer, Integer, p, Boolean> {
            public static final C0524a ICC = new C0524a();

            static {
                AppMethodBeat.i(224916);
                AppMethodBeat.o(224916);
            }

            C0524a() {
                super(3);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ Boolean d(Integer num, Integer num2, p pVar) {
                AppMethodBeat.i(224915);
                num.intValue();
                num2.intValue();
                kotlin.g.b.p.h(pVar, "<anonymous parameter 2>");
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(224915);
                return bool;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke"})
        public static final class b extends q implements kotlin.g.a.q<c.EnumC0515c, Integer, String, x> {
            public static final b ICD = new b();

            static {
                AppMethodBeat.i(224918);
                AppMethodBeat.o(224918);
            }

            b() {
                super(3);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(c.EnumC0515c cVar, Integer num, String str) {
                AppMethodBeat.i(224917);
                num.intValue();
                kotlin.g.b.p.h(cVar, "<anonymous parameter 0>");
                x xVar = x.SXb;
                AppMethodBeat.o(224917);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.ad.c$a$c  reason: collision with other inner class name */
        static final class C0525c extends q implements kotlin.g.a.q<Integer, Integer, p, Boolean> {
            public static final C0525c ICE = new C0525c();

            static {
                AppMethodBeat.i(224920);
                AppMethodBeat.o(224920);
            }

            C0525c() {
                super(3);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ Boolean d(Integer num, Integer num2, p pVar) {
                AppMethodBeat.i(224919);
                num.intValue();
                num2.intValue();
                kotlin.g.b.p.h(pVar, "<anonymous parameter 2>");
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(224919);
                return bool;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "invoke"})
        static final class d extends q implements kotlin.g.a.q<c.EnumC0515c, Integer, String, x> {
            public static final d ICF = new d();

            static {
                AppMethodBeat.i(224922);
                AppMethodBeat.o(224922);
            }

            d() {
                super(3);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(c.EnumC0515c cVar, Integer num, String str) {
                AppMethodBeat.i(224921);
                num.intValue();
                kotlin.g.b.p.h(cVar, "<anonymous parameter 0>");
                x xVar = x.SXb;
                AppMethodBeat.o(224921);
                return xVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static a a(String str, MMKVSlotManager mMKVSlotManager) {
            Object obj;
            String path;
            byte[] decodeBytes;
            AppMethodBeat.i(224926);
            kotlin.g.b.p.h(str, "url");
            kotlin.g.b.p.h(mMKVSlotManager, "settingManager");
            Uri parse = Uri.parse(str);
            kotlin.g.b.p.g(parse, ShareConstants.MEDIA_URI);
            a aWT = aWT(parse.getHost());
            if (aWT != null) {
                Log.i(c.TAG, "matchDebug:".concat(String.valueOf(parse)));
                AppMethodBeat.o(224926);
                return aWT;
            }
            String aWU = e.aWU(String.valueOf(parse.getHost()));
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) mMKVSlotManager.findSlot(aWU);
            if (multiProcessMMKV != null) {
                if (multiProcessMMKV.containsKey(aWU) && (decodeBytes = multiProcessMMKV.decodeBytes(aWU)) != null) {
                    if (!(decodeBytes.length == 0)) {
                        try {
                            Object newInstance = bhc.class.newInstance();
                            ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                            obj = (com.tencent.mm.bw.a) newInstance;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                        }
                    }
                }
                obj = null;
            } else {
                obj = null;
            }
            bhc bhc = (bhc) obj;
            if (bhc != null) {
                LinkedList<bhd> linkedList = bhc.LQU;
                kotlin.g.b.p.g(linkedList, "ResInfos");
                for (T t : linkedList) {
                    if (!(parse == null || (path = parse.getPath()) == null)) {
                        String str2 = t.xut;
                        kotlin.g.b.p.g(str2, "res.Path");
                        if (com.tencent.luggage.h.c.B(path, str2)) {
                            a aVar = c.ICA;
                            b bVar = c.ICy;
                            String str3 = t.LQV;
                            kotlin.g.b.p.g(str3, "res.ManifestUrl");
                            if (bVar.aWR(e.aWU(str3)).exists()) {
                                Log.v(c.TAG, "match:#" + aWU + ", " + t.xut + ", " + str);
                                kotlin.g.b.p.g(t, com.tencent.tinker.loader.shareutil.ShareConstants.RES_PATH);
                                a aVar2 = new a(bhc, t, false, 60);
                                AppMethodBeat.o(224926);
                                return aVar2;
                            }
                            Log.w(c.TAG, "manifest lost:#" + aWU + ", " + t.xut);
                        } else {
                            continue;
                        }
                    }
                }
            }
            Log.v(c.TAG, "not match:#" + aWU + ", " + str);
            AppMethodBeat.o(224926);
            return null;
        }

        public static a aWT(String str) {
            AppMethodBeat.i(224927);
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
                c.b.a a2 = c.b.a("prefetcher/" + str + ".wspkg", true, "", "matchDebugManifest");
                if (com.tencent.mm.vfs.s.YS(a2.cHM)) {
                    Log.i(c.TAG, "matchDebugManifest " + str + " path=" + a2.cHM);
                    c.b bVar2 = com.tencent.mm.plugin.ac.c.IBU;
                    p a3 = c.b.a(a2, (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) C0524a.ICC, (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) b.ICD, false);
                    c.b bVar3 = com.tencent.mm.plugin.ac.c.IBU;
                    com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(c.b.a(a3, "/config.json"));
                    bhc bhc = new bhc();
                    bhc.LQP = iVar.optString("domain");
                    bhd bhd = new bhd();
                    bhd.xut = iVar.optString("path");
                    bhd.jfi = str;
                    bhd.LQV = iVar.optString("manifest");
                    a aVar = new a(bhc, bhd, true, 28);
                    AppMethodBeat.o(224927);
                    return aVar;
                }
                AppMethodBeat.o(224927);
                return null;
            }
            AppMethodBeat.o(224927);
            return null;
        }

        public static WebResourceResponse lD(String str, String str2) {
            String aWH;
            String str3;
            String str4;
            String oD;
            boolean z = false;
            AppMethodBeat.i(224928);
            kotlin.g.b.p.h(str2, "url");
            if (!fXn()) {
                AppMethodBeat.o(224928);
                return null;
            }
            String str5 = str;
            if (str5 == null || kotlin.n.n.aL(str5)) {
                Log.d(c.TAG, "matchResource fail appId=".concat(String.valueOf(str)));
                AppMethodBeat.o(224928);
                return null;
            }
            Uri parse = Uri.parse(str2);
            Log.i(c.TAG, "matchResource appId=".concat(String.valueOf(str)));
            try {
                c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
                String str6 = "prefetcher/" + str + ".wspkg";
                m mVar = m.IAG;
                if (m.fWJ() == 1) {
                    z = true;
                }
                m mVar2 = m.IAG;
                if (m.fWJ() == 1) {
                    m mVar3 = m.IAG;
                    aWH = m.aWI(str);
                } else {
                    aWH = m.IAG.aWH(str);
                }
                c.b.a a2 = c.b.a(str6, z, aWH, str);
                if (com.tencent.mm.vfs.s.YS(a2.cHM)) {
                    c.b bVar2 = com.tencent.mm.plugin.ac.c.IBU;
                    p a3 = c.b.a(a2, (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) C0525c.ICE, (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) d.ICF, false);
                    StringBuilder sb = new StringBuilder("/resources/");
                    kotlin.g.b.p.g(parse, ShareConstants.MEDIA_URI);
                    WxaPkg.Info openReadPartialInfo = a3.openReadPartialInfo(sb.append(parse.getHost()).append(parse.getPath()).toString());
                    if (openReadPartialInfo != null) {
                        a aVar = c.ICA;
                        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(parse.toString());
                        if (fileExtensionFromUrl == null || (str3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl)) == null) {
                            String path = parse.getPath();
                            str3 = (path == null || (oD = kotlin.n.n.oD(path, ".")) == null) ? null : (String) c.ICz.get(oD);
                        }
                        if (str3 == null) {
                            str3 = "text/plain";
                        }
                        HashMap hashMap = new HashMap();
                        WxaPkg.Info openReadPartialInfo2 = a3.openReadPartialInfo(openReadPartialInfo.fileName + ".headers");
                        if (openReadPartialInfo2 != null) {
                            c.b bVar3 = com.tencent.mm.plugin.ac.c.IBU;
                            String str7 = openReadPartialInfo2.fileName;
                            kotlin.g.b.p.g(str7, "it.fileName");
                            String str8 = str3;
                            for (T t : kotlin.n.n.aR(c.b.a(a3, str7))) {
                                String oz = kotlin.n.n.oz(t, ":");
                                if (oz == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                                    AppMethodBeat.o(224928);
                                    throw tVar;
                                }
                                String obj = kotlin.n.n.trim(oz).toString();
                                if (obj == null) {
                                    t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(224928);
                                    throw tVar2;
                                }
                                String lowerCase = obj.toLowerCase();
                                kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
                                String oB = kotlin.n.n.oB(t, ":");
                                if (oB == null) {
                                    t tVar3 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                                    AppMethodBeat.o(224928);
                                    throw tVar3;
                                }
                                String obj2 = kotlin.n.n.trim(oB).toString();
                                a aVar2 = c.ICA;
                                if (!c.pFb.contains(lowerCase)) {
                                    hashMap.put(lowerCase, obj2);
                                }
                                if (kotlin.g.b.p.j(lowerCase, "content-type")) {
                                    str4 = obj2;
                                } else {
                                    str4 = str8;
                                }
                                str8 = str4;
                            }
                            str3 = str8;
                        }
                        WebResourceResponse webResourceResponse = new WebResourceResponse(str3, null, 200, "OK", hashMap, a3.UR(openReadPartialInfo.fileName));
                        IO.safeClose((Closeable) (!(a3 instanceof Closeable) ? null : a3));
                        AppMethodBeat.o(224928);
                        return webResourceResponse;
                    }
                }
            } catch (Exception e2) {
                Log.e(c.TAG, "matchResource ex " + e2.getMessage());
            }
            AppMethodBeat.o(224928);
            return null;
        }
    }

    static {
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__WebPrefetchLocalData__");
        kotlin.g.b.p.g(mmkv, "MultiProcessMMKV.getMMKV…_WebPrefetchLocalData__\")");
        pvV = new MMKVSlotManager(mmkv, 15552000);
    }

    public final void a(a aVar, String str, List<? extends Object> list, kotlin.g.a.b<? super String, x> bVar) {
        boolean z;
        kotlin.g.b.p.h(aVar, "manifest");
        kotlin.g.b.p.h(str, "func");
        kotlin.g.b.p.h(bVar, "callback");
        String str2 = aVar.ICt.jfi;
        if (str2 == null) {
            str2 = aVar.ICt.LQV;
            kotlin.g.b.p.g(str2, "manifest.manifest.ManifestUrl");
        }
        String aWU = e.aWU(str2);
        if (!this.IBO.containsKey(aWU)) {
            h hVar = new h(this, aWU, str, list, bVar);
            String str3 = aVar.ICs.LQP;
            z.f fVar = new z.f();
            com.tencent.mm.vfs.o aWR = ICy.aWR(aWU);
            fVar.SYG = aWR.exists() ? (T) com.tencent.mm.vfs.p.an(aWR) : (T) "";
            Log.i(this.gVB, "create domain:" + str3 + '#' + aWU);
            try {
                z.f fVar2 = new z.f();
                fVar2.SYG = null;
                String str4 = aVar.ICt.jfi;
                String str5 = str4;
                if (str5 == null || kotlin.n.n.aL(str5)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    try {
                        String str6 = aVar.ICt.jfi;
                        kotlin.g.b.p.g(str6, "manifest.manifest.AppId");
                        fVar2.SYG = (T) byw(str6);
                    } catch (Exception e2) {
                        Log.e(this.gVB, "create bizPkg ex:" + str4 + '#' + aWU + ' ' + e2.getMessage());
                    }
                }
                com.tencent.mm.plugin.appbrand.m.g bME = bME();
                com.tencent.mm.plugin.ab.p pVar = new com.tencent.mm.plugin.ab.p(new e(this, aWU, fVar, fVar2, str3, hVar));
                kotlin.g.b.p.g(bME, "this");
                pVar.f(bME);
                com.tencent.mm.plugin.ac.c.a(this, bME, "WebPrefetcherManifest#".concat(String.valueOf(aWU)), "manifest", (kotlin.g.a.b) null, (c.a) null, 24);
                StringBuilder append = new StringBuilder().append((String) fVar.SYG);
                T t = fVar2.SYG;
                fVar.SYG = (T) append.append(t != null ? c.b.b(t, "/manifest.js") : "").toString();
                bME.evaluateJavascript(fVar.SYG, new f(bME, this, aWU, fVar, fVar2, str3, hVar));
                String str7 = str4;
                if (!(str7 == null || kotlin.n.n.aL(str7)) && fVar2.SYG != null) {
                    com.tencent.mm.plugin.appbrand.m.g bME2 = bME();
                    kotlin.g.b.p.g(bME2, "this");
                    com.tencent.mm.plugin.appbrand.m.g gVar = bME2;
                    new com.tencent.mm.plugin.ab.p(new j(aWU)).f(gVar);
                    new com.tencent.mm.plugin.ab.j(new k(this, str4)).f(gVar);
                    kotlin.g.b.p.h("prefetcher", "type");
                    kotlin.g.b.p.h(str4, "appId");
                    com.tencent.mm.plugin.ac.c.a(this, bME2, "WebPrefetcher#" + str4 + '#' + aWU, "prefetcher", (kotlin.g.a.b) null, new c.a(str4, aWQ("prefetcher").getLong("idKey")), 8);
                    Log.i(this.gVB, "configPreFetcher ".concat(String.valueOf("/prefetcher.js")));
                    bME2.evaluateJavascript(c.b.b(fVar2.SYG, "/prefetcher.js"), new g(this, aWU, str4, fVar2));
                }
            } catch (Exception e3) {
                Log.printErrStackTrace(this.gVB, e3, "create id=".concat(String.valueOf(aWU)), new Object[0]);
            }
        } else {
            a(aWU, str, list, bVar);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
    static final class l extends q implements kotlin.g.a.a<p> {
        public static final l ICN = new l();

        static {
            AppMethodBeat.i(224950);
            AppMethodBeat.o(224950);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ p invoke() {
            String aWH;
            AppMethodBeat.i(224949);
            c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
            m mVar = m.IAG;
            boolean z = m.fWJ() == 1;
            m mVar2 = m.IAG;
            if (m.fWJ() == 1) {
                m mVar3 = m.IAG;
                aWH = m.aWI("wx97b7aebac2183fd2");
            } else {
                aWH = m.IAG.aWH("wx97b7aebac2183fd2");
            }
            p a2 = c.b.a(c.b.a("prefetcher.wspkg", z, aWH, "wx97b7aebac2183fd2"), (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) AnonymousClass1.ICO, (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) AnonymousClass2.ICP, true);
            AppMethodBeat.o(224949);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$1$2"})
    public static final class f<T> implements ValueCallback<String> {
        final /* synthetic */ c ICB;
        final /* synthetic */ z.f ICI;
        final /* synthetic */ z.f ICJ;
        final /* synthetic */ String ICK;
        final /* synthetic */ String pAg;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.m.g pAh;
        final /* synthetic */ kotlin.g.a.b pAj;

        f(com.tencent.mm.plugin.appbrand.m.g gVar, c cVar, String str, z.f fVar, z.f fVar2, String str2, kotlin.g.a.b bVar) {
            this.pAh = gVar;
            this.ICB = cVar;
            this.pAg = str;
            this.ICI = fVar;
            this.ICJ = fVar2;
            this.ICK = str2;
            this.pAj = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(224933);
            this.ICB.IBO.put(this.pAg, Integer.valueOf(this.pAh.bMC()));
            c cVar = this.ICB;
            String str2 = this.ICK;
            kotlin.g.b.p.g(str2, "domain");
            cVar.aer(str2);
            kotlin.g.a.b bVar = this.pAj;
            com.tencent.mm.plugin.appbrand.m.g gVar = this.pAh;
            kotlin.g.b.p.g(gVar, "this@apply");
            bVar.invoke(gVar);
            Log.v(this.ICB.gVB, "create domain:" + this.ICK + '#' + this.pAg + " end");
            AppMethodBeat.o(224933);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine$create$2$1"})
    public static final class g<T> implements ValueCallback<String> {
        final /* synthetic */ c ICB;
        final /* synthetic */ z.f ICJ;
        final /* synthetic */ String nwh;
        final /* synthetic */ String pAg;

        g(c cVar, String str, String str2, z.f fVar) {
            this.ICB = cVar;
            this.pAg = str;
            this.nwh = str2;
            this.ICJ = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(224934);
            Log.v(this.ICB.gVB, "create prefetcher:" + this.nwh + '#' + this.pAg + " end");
            AppMethodBeat.o(224934);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b ICG = new b();

        static {
            AppMethodBeat.i(224924);
            AppMethodBeat.o(224924);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            int i2;
            boolean z = true;
            AppMethodBeat.i(224923);
            g.a aVar = com.tencent.mm.plugin.webview.core.g.ILB;
            MultiProcessMMKV cdi = com.tencent.mm.plugin.webview.core.h.cdi();
            if (g.a.KB()) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            int i3 = cdi.getInt("prefetchUsePkg", i2);
            if (i3 != 1) {
                if (i3 == 0) {
                    z = false;
                } else {
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_prefetcher_use_pkg, 0) != 1) {
                        z = false;
                    }
                    Log.i(c.TAG, "prefetchUsePkgOpen open ".concat(String.valueOf(z)));
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(224923);
            return valueOf;
        }
    }
}
