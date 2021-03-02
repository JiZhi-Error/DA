package com.tencent.mm.plugin.webview.l;

import android.webkit.ValueCallback;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.app.o;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.webview.l.g;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.faf;
import com.tencent.mm.protocal.protobuf.fag;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.d.f;
import kotlin.g.b.z;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ai;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0005UVWXYB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J.\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0007J \u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0016\u001a\u00020\u001eJ4\u0010&\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*J&\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001e2\u0014\b\u0002\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00150/H\u0002J#\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001e2\b\b\u0002\u00103\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u00104J$\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e062\u0006\u00107\u001a\u0002082\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010=\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001eJ\u0016\u0010?\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eJ\u000e\u0010@\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001eJ8\u0010A\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001e2\u0014\b\u0002\u0010B\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00150/2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00150/J&\u0010E\u001a\u00020\u0015*\u00020%2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u0007H\u0002J\u0014\u0010J\u001a\u00020\u0015*\u00020\u00192\u0006\u0010K\u001a\u00020LH\u0002J\u0014\u0010M\u001a\u00020\u0015*\u00020%2\u0006\u0010-\u001a\u00020\u001eH\u0002J\u0014\u0010N\u001a\u00020\u0015*\u00020%2\u0006\u0010O\u001a\u000201H\u0002J\u001a\u0010P\u001a\u00020\u001e*\u00020\u00192\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020L0RH\u0002J\u0014\u0010S\u001a\u00020\u0015*\u00020\u00192\u0006\u0010K\u001a\u00020LH\u0002J\f\u0010T\u001a\u00020\u001e*\u000201H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "", "weakJsapi", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Ljava/lang/ref/WeakReference;)V", "inited", "", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getReporter", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "getWeakJsapi", "()Ljava/lang/ref/WeakReference;", "workerManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "getWorkerManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "workerManager$delegate", "Lkotlin/Lazy;", "appendTags", "", "webCompt", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "cleanMainFrame", "clear", "createJsContext", "appId", "", "url", "launchMainFrame", "dispatchEvent", "event", "message", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "errReport", "errMsg", "errStack", "errLine", "", "errCol", "evaluateMainFrame", "script", "callback", "Lkotlin/Function1;", "getA8Key", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "a8KeyUrl", "webComptName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppScript", "Lkotlin/Pair;", "paramsObject", "Lcom/tencent/mm/json/JSONObject;", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "performance", "frontEndPerformance", "postToBack", "postToFront", "refreshA8Key", "onerror", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "onsuccess", "config", "webComptInfo", "configTimeStamps", "", "resume", "end", "step", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "evaluate", "launch", "a8key", "records", "steps", "", "start", "toJson", "A8KeyResp", "Companion", "CreateJSContextException", "PerformanceSteps", "WebComptWorkerManager", "webview-sdk_release"})
public final class c {
    private static final kotlin.f IBP = kotlin.g.ah(g.JDG);
    private static final String JCV = JCV;
    private static final kotlin.f JCW = kotlin.g.ah(d.JDD);
    static final kotlin.f JCX = kotlin.g.ah(f.JDF);
    static final kotlin.f JCY = kotlin.g.ah(i.JDI);
    private static final kotlin.f JCZ = kotlin.g.ah(e.JDE);
    private static String JDa = "";
    private static final LinkedList<l> JDb = new LinkedList<>();
    private static final kotlin.f JDc = kotlin.g.ah(h.JDH);
    private static final String JDd = (com.tencent.mm.loader.j.b.aKJ() + "webcompt_debug/");
    private static final kotlin.f JDe = kotlin.g.ah(C1962c.JDB);
    public static final b JDf = new b((byte) 0);
    static final String TAG = TAG;
    private static boolean VhT;
    final j JCS = new j();
    private final kotlin.f JCT;
    final WeakReference<com.tencent.mm.plugin.webview.d.h> JCU;
    private boolean gKM;

    public static final String getScheme() {
        return JCV;
    }

    public static final void giT() {
        AppMethodBeat.i(82923);
        b.zA(false);
        AppMethodBeat.o(82923);
    }

    /* access modifiers changed from: package-private */
    public final l giJ() {
        AppMethodBeat.i(82899);
        l lVar = (l) this.JCT.getValue();
        AppMethodBeat.o(82899);
        return lVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"})
    public static final class n extends kotlin.d.a implements CoroutineExceptionHandler {
        final /* synthetic */ c JEe;
        final /* synthetic */ z.f JEf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(f.c cVar, c cVar2, z.f fVar) {
            super(cVar);
            this.JEe = cVar2;
            this.JEf = fVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(kotlin.d.f fVar, Throwable th) {
            AppMethodBeat.i(82863);
            this.JEe.JCS.a(b.CREATE_JS_CONTEXT_ERR);
            if (th instanceof j) {
                this.JEf.SYG.invoke(th);
                AppMethodBeat.o(82863);
                return;
            }
            AppMethodBeat.o(82863);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.webview.webcompt.WebComponent$createJsContext$2", f = "WebComponent.kt", hxM = {TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 336, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, e.a.CTRL_INDEX}, m = "invokeSuspend")
    public static final class o extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ c JEe;
        final /* synthetic */ boolean JEg;
        final /* synthetic */ com.tencent.mm.pluginsdk.r JEh;
        final /* synthetic */ cel JEi;
        final /* synthetic */ z.f JEj;
        Object L$0;
        final /* synthetic */ String kPQ;
        int label;
        final /* synthetic */ String mkH;
        final /* synthetic */ String naX;
        private ai p$;
        Object pED;
        Object pEE;
        Object pEF;
        Object pEG;
        Object pEH;
        Object pEI;
        Object pEJ;
        Object pEK;
        Object pEL;
        Object pEM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(c cVar, boolean z, com.tencent.mm.pluginsdk.r rVar, String str, cel cel, String str2, String str3, z.f fVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.JEe = cVar;
            this.JEg = z;
            this.JEh = rVar;
            this.mkH = str;
            this.JEi = cel;
            this.naX = str2;
            this.kPQ = str3;
            this.JEj = fVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(82875);
            kotlin.g.b.p.h(dVar, "completion");
            o oVar = new o(this.JEe, this.JEg, this.JEh, this.mkH, this.JEi, this.naX, this.kPQ, this.JEj, dVar);
            oVar.p$ = (ai) obj;
            AppMethodBeat.o(82875);
            return oVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(82876);
            Object invokeSuspend = ((o) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(82876);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", "ex", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$2"})
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.b<j, kotlin.x> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ l.a JEk;
            final /* synthetic */ o JEl;
            final /* synthetic */ String JEm;
            final /* synthetic */ com.tencent.mm.ab.i JEn;
            final /* synthetic */ com.tencent.mm.plugin.appbrand.m.g pAh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(com.tencent.mm.plugin.appbrand.m.g gVar, l.a aVar, o oVar, ai aiVar, String str, com.tencent.mm.ab.i iVar) {
                super(1);
                this.pAh = gVar;
                this.JEk = aVar;
                this.JEl = oVar;
                this.GPo = aiVar;
                this.JEm = str;
                this.JEn = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(j jVar) {
                AppMethodBeat.i(225191);
                j jVar2 = jVar;
                kotlin.g.b.p.h(jVar2, "ex");
                com.tencent.mm.plugin.appbrand.m.g gVar = this.pAh;
                StringBuilder sb = new StringBuilder("WeixinWebCompt.onError(");
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                iVar.U("retCode", jVar2.retCode);
                iVar.h("webComptName", a.bbs(jVar2.JDJ));
                iVar.h("error", a.bbs(jVar2.errMsg));
                String iVar2 = iVar.toString();
                kotlin.g.b.p.g(iVar2, "JSONObject().apply {\n   …\n            }.toString()");
                b bVar = c.JDf;
                Log.e(c.TAG, "CreateJSContextException:".concat(String.valueOf(iVar2)));
                c.d(gVar, sb.append(iVar2).append(')').toString());
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(225191);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, hxF = {"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$1"})
        public static final class a implements com.tencent.mm.plugin.appbrand.m.h {
            final /* synthetic */ ai GPo;
            final /* synthetic */ l.a JEk;
            final /* synthetic */ o JEl;
            final /* synthetic */ String JEm;
            final /* synthetic */ com.tencent.mm.ab.i JEn;

            a(l.a aVar, o oVar, ai aiVar, String str, com.tencent.mm.ab.i iVar) {
                this.JEk = aVar;
                this.JEl = oVar;
                this.GPo = aiVar;
                this.JEm = str;
                this.JEn = iVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(225190);
                b bVar = c.JDf;
                Log.e(c.TAG, "engine " + this.JEl.naX + " exception: " + str + " \nstackTrace:\n" + str2);
                c cVar = this.JEl.JEe;
                String str3 = this.JEl.naX;
                kotlin.g.b.p.g(str3, "name");
                kotlin.g.b.p.g(str, "message");
                c.a(cVar, str3, str, str2);
                this.JEl.JEe.JCS.a(b.EX_JS_CONTEXT);
                AppMethodBeat.o(225190);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncA8Key$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$3"})
        /* renamed from: com.tencent.mm.plugin.webview.l.c$o$c  reason: collision with other inner class name */
        public static final class C1963c extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super a>, Object> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ l.a JEk;
            final /* synthetic */ o JEl;
            final /* synthetic */ String JEm;
            final /* synthetic */ com.tencent.mm.ab.i JEn;
            Object L$0;
            int label;
            private ai p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1963c(kotlin.d.d dVar, l.a aVar, o oVar, ai aiVar, String str, com.tencent.mm.ab.i iVar) {
                super(2, dVar);
                this.JEk = aVar;
                this.JEl = oVar;
                this.GPo = aiVar;
                this.JEm = str;
                this.JEn = iVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(82868);
                kotlin.g.b.p.h(dVar, "completion");
                C1963c cVar = new C1963c(dVar, this.JEk, this.JEl, this.GPo, this.JEm, this.JEn);
                cVar.p$ = (ai) obj;
                AppMethodBeat.o(82868);
                return cVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super a> dVar) {
                AppMethodBeat.i(82869);
                Object invokeSuspend = ((C1963c) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
                AppMethodBeat.o(82869);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(82867);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        ai aiVar = this.p$;
                        c.c(this.JEl.JEh, k.STEP_GET_A8KEY);
                        c cVar = this.JEl.JEe;
                        String str = this.JEm;
                        String str2 = this.JEl.JEi.name;
                        kotlin.g.b.p.g(str2, "webCompt.name");
                        this.L$0 = aiVar;
                        this.label = 1;
                        obj = cVar.b(str, str2, this);
                        if (obj == aVar) {
                            AppMethodBeat.o(82867);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(82867);
                        throw illegalStateException;
                }
                c.b(this.JEl.JEh, k.STEP_GET_A8KEY);
                AppMethodBeat.o(82867);
                return obj;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$1$1$asyncAppScript$1", "com/tencent/mm/plugin/webview/webcompt/WebComponent$createJsContext$2$$special$$inlined$apply$lambda$4"})
        public static final class d extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.o<? extends String, ? extends String>>, Object> {
            final /* synthetic */ ai GPo;
            final /* synthetic */ l.a JEk;
            final /* synthetic */ o JEl;
            final /* synthetic */ String JEm;
            final /* synthetic */ com.tencent.mm.ab.i JEn;
            Object L$0;
            int label;
            private ai p$;
            final /* synthetic */ com.tencent.mm.plugin.appbrand.m.g pAh;
            Object pED;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(com.tencent.mm.plugin.appbrand.m.g gVar, kotlin.d.d dVar, l.a aVar, o oVar, ai aiVar, String str, com.tencent.mm.ab.i iVar) {
                super(2, dVar);
                this.pAh = gVar;
                this.JEk = aVar;
                this.JEl = oVar;
                this.GPo = aiVar;
                this.JEm = str;
                this.JEn = iVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(82872);
                kotlin.g.b.p.h(dVar, "completion");
                d dVar2 = new d(this.pAh, dVar, this.JEk, this.JEl, this.GPo, this.JEm, this.JEn);
                dVar2.p$ = (ai) obj;
                AppMethodBeat.o(82872);
                return dVar2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super kotlin.o<? extends String, ? extends String>> dVar) {
                AppMethodBeat.i(82873);
                Object invokeSuspend = ((d) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
                AppMethodBeat.o(82873);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(82871);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        ai aiVar = this.p$;
                        c.c(this.JEl.JEh, k.STEP_GET_APP_SCRIPT);
                        this.L$0 = aiVar;
                        this.pED = this;
                        this.label = 1;
                        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(this));
                        final kotlin.d.h hVar2 = hVar;
                        b bVar = c.JDf;
                        com.tencent.mm.ac.d.b(c.TAG, new kotlin.g.a.a<kotlin.x>() {
                            /* class com.tencent.mm.plugin.webview.l.c.o.d.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ kotlin.x invoke() {
                                AppMethodBeat.i(82870);
                                try {
                                    kotlin.o a2 = c.a(this.JEl.JEe, this.JEn, this.JEl.JEi);
                                    kotlin.d.d dVar = hVar2;
                                    Result.Companion companion = Result.Companion;
                                    dVar.resumeWith(Result.m46constructorimpl(a2));
                                } catch (Exception e2) {
                                    if (e2 instanceof j) {
                                        this.JEl.JEj.SYG.invoke(e2);
                                    } else {
                                        c.d(this.pAh, "WeixinWebCompt.onError(" + e2.getMessage() + ')');
                                    }
                                    kotlin.d.d dVar2 = hVar2;
                                    Result.Companion companion2 = Result.Companion;
                                    dVar2.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(e2)));
                                }
                                kotlin.x xVar = kotlin.x.SXb;
                                AppMethodBeat.o(82870);
                                return xVar;
                            }
                        });
                        obj = hVar.hxK();
                        if (obj == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                            kotlin.g.b.p.h(this, "frame");
                        }
                        if (obj == aVar) {
                            AppMethodBeat.o(82871);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(82871);
                        throw illegalStateException;
                }
                c.b(this.JEl.JEh, k.STEP_GET_APP_SCRIPT);
                AppMethodBeat.o(82871);
                return obj;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x018e  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x025a  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x03cd  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x048d  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x04d2  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x04e7  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
            // Method dump skipped, instructions count: 1290
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.l.c.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, hxF = {"buildMatrix", "", "", "matrix", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.b<List<? extends Integer>, List<? extends String>> {
        public static final w JEA = new w();

        static {
            AppMethodBeat.i(82892);
            AppMethodBeat.o(82892);
        }

        w() {
            super(1);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
        public static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Byte, String> {
            public static final a JEB = new a();

            static {
                AppMethodBeat.i(82889);
                AppMethodBeat.o(82889);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(Byte b2) {
                AppMethodBeat.i(82888);
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2.byteValue())}, 1));
                kotlin.g.b.p.g(format, "java.lang.String.format(this, *args)");
                AppMethodBeat.o(82888);
                return format;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ List<? extends String> invoke(List<? extends Integer> list) {
            AppMethodBeat.i(82890);
            List<String> in = in(list);
            AppMethodBeat.o(82890);
            return in;
        }

        public static List<String> in(List<Integer> list) {
            AppMethodBeat.i(82891);
            kotlin.g.b.p.h(list, "matrix");
            SecureRandom secureRandom = new SecureRandom();
            List<Integer> list2 = list;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                byte[] bArr = new byte[it.next().intValue()];
                secureRandom.nextBytes(bArr);
                arrayList.add(kotlin.a.e.a(bArr, "", a.JEB));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(82891);
            return arrayList2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"toJsonStringArray", "", "", "invoke"})
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<List<? extends String>, String> {
        public static final m JEd = new m();

        static {
            AppMethodBeat.i(82862);
            AppMethodBeat.o(82862);
        }

        m() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(List<? extends String> list) {
            AppMethodBeat.i(82861);
            List<? extends String> list2 = list;
            kotlin.g.b.p.h(list2, "$this$toJsonStringArray");
            String a2 = kotlin.a.j.a(list2, "','", "['", "']", 0, (CharSequence) null, (kotlin.g.a.b) null, 56);
            AppMethodBeat.o(82861);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.b<j, kotlin.x> {
        public static final p JEp = new p();

        static {
            AppMethodBeat.i(82878);
            AppMethodBeat.o(82878);
        }

        p() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(j jVar) {
            AppMethodBeat.i(82877);
            kotlin.g.b.p.h(jVar, LocaleUtil.ITALIAN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(82877);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        public static final s JEv = new s();

        static {
            AppMethodBeat.i(82881);
            AppMethodBeat.o(82881);
        }

        s() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(82880);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(82880);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0002H\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f"}, hxF = {"readText", "Lkotlin/Pair;", "", "T", "type", "errCode", "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "invoke", "(Ljava/lang/Object;Ljava/lang/String;ILcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)Lkotlin/Pair;"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.s<T, String, Integer, b.EnumC1961c, b.a, kotlin.o<? extends String, ? extends String>> {
        final /* synthetic */ c JEe;
        final /* synthetic */ cel JEi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(c cVar, cel cel) {
            super(5);
            this.JEe = cVar;
            this.JEi = cel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ kotlin.o<? extends String, ? extends String> a(Object obj, String str, Integer num, b.EnumC1961c cVar, b.a aVar) {
            AppMethodBeat.i(164018);
            kotlin.o<String, String> a2 = a(obj, str, num.intValue(), cVar, aVar);
            AppMethodBeat.o(164018);
            return a2;
        }

        public static /* synthetic */ kotlin.o a(v vVar, Object obj, String str, int i2, b.EnumC1961c cVar, b.a aVar, int i3) {
            AppMethodBeat.i(82887);
            kotlin.o<String, String> a2 = vVar.a(obj, str, i2, (i3 & 4) != 0 ? b.EnumC1961c.NA : cVar, (i3 & 8) != 0 ? b.a.NA : aVar);
            AppMethodBeat.o(82887);
            return a2;
        }

        private <T> kotlin.o<String, String> a(T t, String str, int i2, b.EnumC1961c cVar, b.a aVar) {
            kotlin.o<String, String> oVar;
            AppMethodBeat.i(82886);
            kotlin.g.b.p.h(str, "type");
            kotlin.g.b.p.h(cVar, "resType");
            kotlin.g.b.p.h(aVar, "debugType");
            b bVar = c.JDf;
            Log.d(c.TAG, "createJsContext appScript " + str + ", " + ((Object) t));
            try {
                if (t instanceof com.tencent.mm.vfs.o) {
                    oVar = new kotlin.o<>(t.getAbsolutePath(), com.tencent.mm.vfs.p.an(t));
                } else if (t instanceof URL) {
                    kotlin.o<String, String> oVar2 = new kotlin.o<>(t.toString(), new String(kotlin.f.d.e(t), kotlin.n.d.UTF_8));
                    this.JEe.JCS.a(b.APP_SCRIPT_DOWNLOAD);
                    oVar = oVar2;
                } else {
                    oVar = new kotlin.o<>("", "");
                }
                this.JEe.JCS.a(b.LOAD_APP_SCRIPT_SUCC);
                b bVar2 = c.JDf;
                LinkedList<b.d> linkedList = b.giV().JDp;
                A a2 = oVar.first;
                kotlin.g.b.p.g(a2, "it.first");
                linkedList.add(new b.d(kotlin.n.n.by(a2, c.JDd, ""), cVar, aVar));
                AppMethodBeat.o(82886);
                return oVar;
            } catch (Exception e2) {
                if (t instanceof URL) {
                    this.JEe.JCS.a(b.APP_SCRIPT_DOWNLOAD_ERR);
                }
                this.JEe.JCS.a(b.LOAD_APP_SCRIPT_ERR);
                this.JEe.JCS.a(b.EX_APP_SCRIPT);
                String str2 = this.JEi.name;
                kotlin.g.b.p.g(str2, "webCompt.name");
                j jVar = new j(i2, str2, "load " + str + " fail:" + ((Object) t) + ", " + e2);
                AppMethodBeat.o(82886);
                throw jVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ c JEe;
        final /* synthetic */ com.tencent.mm.pluginsdk.r JEh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(c cVar, com.tencent.mm.pluginsdk.r rVar) {
            super(1);
            this.JEe = cVar;
            this.JEh = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(82893);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            c.b(this.JEh, k.STEP_EVAL_MAIN_FRAME);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(82893);
            return xVar;
        }
    }

    public c(WeakReference<com.tencent.mm.plugin.webview.d.h> weakReference) {
        kotlin.g.b.p.h(weakReference, "weakJsapi");
        AppMethodBeat.i(225204);
        this.JCU = weakReference;
        b.giV().clear();
        this.JCT = kotlin.g.ah(new z(this));
        AppMethodBeat.o(225204);
    }

    public static final /* synthetic */ l a(c cVar) {
        AppMethodBeat.i(82918);
        l giJ = cVar.giJ();
        AppMethodBeat.o(82918);
        return giJ;
    }

    public static final /* synthetic */ String a(c cVar, a aVar) {
        AppMethodBeat.i(82922);
        String a2 = cVar.a(aVar);
        AppMethodBeat.o(82922);
        return a2;
    }

    public static final /* synthetic */ kotlin.o a(c cVar, com.tencent.mm.ab.i iVar, cel cel) {
        AppMethodBeat.i(82920);
        kotlin.o<String, String> a2 = cVar.a(iVar, cel);
        AppMethodBeat.o(82920);
        return a2;
    }

    public static final /* synthetic */ void b(com.tencent.mm.plugin.appbrand.m.g gVar, cel cel, long j2) {
        AppMethodBeat.i(225205);
        a(gVar, cel, j2, true);
        AppMethodBeat.o(225205);
    }

    public static final /* synthetic */ void c(com.tencent.mm.pluginsdk.r rVar, k kVar) {
        AppMethodBeat.i(82917);
        a(rVar, kVar);
        AppMethodBeat.o(82917);
    }

    public static final /* synthetic */ void d(com.tencent.mm.plugin.appbrand.m.g gVar, String str) {
        AppMethodBeat.i(225206);
        c(gVar, str);
        AppMethodBeat.o(225206);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u0000`\u0004:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0005J\"\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u0000`\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "Lkotlin/collections/HashMap;", "()V", "id", "", "getId", "()I", "preloadDebugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "preloadId", "recycleWorkers", "fetch", "appId", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "preload", "", "recycle", "reporter", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "WebComptWorker", "webview-sdk_release"})
    public static final class l extends HashMap<String, a> {
        int JDQ = -1;
        b.f JDR = new b.f(this.id, true, false, 4);
        final HashMap<String, a> JDS = new HashMap<>();
        final int id = ((int) (System.currentTimeMillis() % 1000));

        public l() {
            AppMethodBeat.i(82849);
            AppMethodBeat.o(82849);
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            AppMethodBeat.i(82852);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(82852);
                return false;
            }
            boolean containsKey = super.containsKey((String) obj);
            AppMethodBeat.o(82852);
            return containsKey;
        }

        public final /* bridge */ boolean containsValue(Object obj) {
            AppMethodBeat.i(82850);
            if (!(obj instanceof a)) {
                AppMethodBeat.o(82850);
                return false;
            }
            boolean containsValue = super.containsValue((a) obj);
            AppMethodBeat.o(82850);
            return containsValue;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ a get(Object obj) {
            AppMethodBeat.i(82853);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(82853);
                return null;
            }
            a aVar = (a) super.get((String) obj);
            AppMethodBeat.o(82853);
            return aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, java.util.HashMap
        public final /* bridge */ a getOrDefault(Object obj, a aVar) {
            AppMethodBeat.i(82851);
            if (!(obj != null ? obj instanceof String : true)) {
                AppMethodBeat.o(82851);
                return aVar;
            }
            a aVar2 = (a) super.getOrDefault((String) obj, aVar);
            AppMethodBeat.o(82851);
            return aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ a remove(Object obj) {
            AppMethodBeat.i(82854);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(82854);
                return null;
            }
            a aVar = (a) super.remove((String) obj);
            AppMethodBeat.o(82854);
            return aVar;
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            boolean z = true;
            AppMethodBeat.i(82855);
            if (obj != null ? obj instanceof String : true) {
                if (obj2 != null) {
                    z = obj2 instanceof a;
                }
                if (z) {
                    boolean remove = super.remove((String) obj, (a) obj2);
                    AppMethodBeat.o(82855);
                    return remove;
                }
            }
            AppMethodBeat.o(82855);
            return false;
        }

        public final synchronized a a(String str, cel cel, c cVar) {
            b.f fVar;
            int create;
            a aVar;
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.i(225189);
                kotlin.g.b.p.h(str, "appId");
                kotlin.g.b.p.h(cel, "webComptInfo");
                kotlin.g.b.p.h(cVar, "webCompt");
                String str2 = cel.name;
                if (!this.JDS.containsKey(str2) || (aVar = this.JDS.get(str2)) == null || !kotlin.g.b.p.j(aVar.appId, str)) {
                    if (this.JDQ != -1) {
                        z = true;
                    }
                    if (z) {
                        b bVar = c.JDf;
                        Log.i(c.TAG, "use preload workerManager#" + this.id);
                        fVar = this.JDR;
                    } else {
                        b bVar2 = c.JDf;
                        Log.i(c.TAG, "create new workerManager#" + this.id);
                        fVar = new b.f(this.id, false, false, 4);
                    }
                    b bVar3 = c.JDf;
                    b.giV().JDo.add(fVar);
                    b bVar4 = c.JDf;
                    b.giV().ltW = z;
                    if (z) {
                        create = this.JDQ;
                    } else {
                        b bVar5 = c.JDf;
                        e.AnonymousClass1 giW = b.giW();
                        b bVar6 = c.JDf;
                        create = giW.create(b.f("/wxwebcompt.js", fVar.JDp));
                    }
                    a aVar2 = new a(this, create, cel, cVar);
                    this.JDQ = -1;
                    kotlin.g.b.p.g(str2, "webComptName");
                    put(str2, aVar2);
                    AppMethodBeat.o(225189);
                    aVar = aVar2;
                } else {
                    this.JDS.remove(str2);
                    kotlin.g.b.p.g(str2, "webComptName");
                    kotlin.g.b.p.g(aVar, LocaleUtil.ITALIAN);
                    put(str2, aVar);
                    b bVar7 = c.JDf;
                    b.giV().JDo.add(new b.f(this.id, false, true, 2));
                    AppMethodBeat.o(225189);
                }
            }
            return aVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001a\u00103\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager$WebComptWorker;", "", "workerId", "", "webComptInfo", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "webCompt", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;ILcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;)V", "a8KeyUrl", "", "getA8KeyUrl", "()Ljava/lang/String;", "setA8KeyUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appScriptMD5", "getAppScriptMD5", "setAppScriptMD5", "appScriptUrl", "getAppScriptUrl", "setAppScriptUrl", "engine", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "getEngine", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isRecycled", "", "()Z", "setRecycled", "(Z)V", "jsapi", "Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;", "setJsapi", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComptContextJsApiHandler;)V", "launched", "getLaunched", "setLaunched", "performanceHelper", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "setPerformanceHelper", "(Lcom/tencent/mm/pluginsdk/PerformanceHelper;)V", "refer", "getRefer", "setRefer", "used", "getUsed", "setUsed", "getWebCompt", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "getWebComptInfo", "()Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getWorkerId", "()I", "recycle", "", "reuse", "webview-sdk_release"})
        public final class a {
            boolean JDT;
            String JDU = "";
            String JDV = "";
            String JDW = "";
            com.tencent.mm.pluginsdk.r JDX;
            i JDY;
            final int JDZ;
            final cel JEa;
            final c JEb;
            final /* synthetic */ l JEc;
            boolean aHN;
            String appId = "";
            String pDH = "";
            boolean used;

            public a(l lVar, int i2, cel cel, c cVar) {
                kotlin.g.b.p.h(cel, "webComptInfo");
                kotlin.g.b.p.h(cVar, "webCompt");
                this.JEc = lVar;
                AppMethodBeat.i(82848);
                this.JDZ = i2;
                this.JEa = cel;
                this.JEb = cVar;
                c cVar2 = this.JEb;
                String str = this.JEa.name;
                kotlin.g.b.p.g(str, "webComptInfo.name");
                this.JDY = new i(cVar2, str);
                giZ().addJavascriptInterface(this.JDY, "__webcompt");
                AppMethodBeat.o(82848);
            }

            public final void bbw(String str) {
                AppMethodBeat.i(82846);
                kotlin.g.b.p.h(str, "<set-?>");
                this.JDV = str;
                AppMethodBeat.o(82846);
            }

            public final com.tencent.mm.plugin.appbrand.m.g giZ() {
                AppMethodBeat.i(225188);
                b bVar = c.JDf;
                com.tencent.mm.plugin.appbrand.m.g xX = b.giW().xX(this.JDZ);
                kotlin.g.b.p.g(xX, "manager.getJsContext(workerId)");
                AppMethodBeat.o(225188);
                return xX;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Set<Map.Entry<String, a>> entrySet() {
            AppMethodBeat.i(82856);
            Set<Map.Entry<String, a>> entrySet = super.entrySet();
            AppMethodBeat.o(82856);
            return entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Set<String> keySet() {
            AppMethodBeat.i(82857);
            Set<String> keySet = super.keySet();
            AppMethodBeat.o(82857);
            return keySet;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Collection<a> values() {
            AppMethodBeat.i(82858);
            Collection<a> values = super.values();
            AppMethodBeat.o(82858);
            return values;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(82859);
            int size = super.size();
            AppMethodBeat.o(82859);
            return size;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$PerformanceSteps;", "", "stepName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStepName", "()Ljava/lang/String;", "STEP_CREATE_JS_CXT", "STEP_EVAL_MAIN_FRAME", "STEP_GET_A8KEY", "STEP_FETCH_WORKER", "STEP_GET_APP_SCRIPT", "webview-sdk_release"})
    public enum k {
        STEP_CREATE_JS_CXT("createJsContext"),
        STEP_EVAL_MAIN_FRAME("evalMainFrame"),
        STEP_GET_A8KEY("GetA8Key"),
        STEP_FETCH_WORKER("FetchWorker"),
        STEP_GET_APP_SCRIPT("GetAppScript");
        
        final String mPw;

        public static k valueOf(String str) {
            AppMethodBeat.i(82845);
            k kVar = (k) Enum.valueOf(k.class, str);
            AppMethodBeat.o(82845);
            return kVar;
        }

        private k(String str) {
            this.mPw = str;
        }

        static {
            AppMethodBeat.i(82843);
            AppMethodBeat.o(82843);
        }
    }

    static void a(com.tencent.mm.pluginsdk.r rVar, k kVar) {
        AppMethodBeat.i(82901);
        rVar.bN(kVar.mPw + "_START", System.currentTimeMillis());
        AppMethodBeat.o(82901);
    }

    static String a(com.tencent.mm.pluginsdk.r rVar, List<? extends k> list) {
        AppMethodBeat.i(82902);
        LinkedList linkedList = new LinkedList();
        for (T t2 : list) {
            linkedList.add(String.valueOf(rVar.bO(t2.mPw + "_START", rVar.getStartTime()) - rVar.getStartTime()));
            linkedList.add(String.valueOf(rVar.bO(t2.mPw + "_END", rVar.getStartTime()) - rVar.getStartTime()));
        }
        String str = kotlin.a.j.a(linkedList, ",", (CharSequence) null, ",", 0, (CharSequence) null, (kotlin.g.a.b) null, 58) + kotlin.n.n.r("0,", (9 - list.size()) * 2);
        AppMethodBeat.o(82902);
        return str;
    }

    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.m.g gVar, cel cel, long j2) {
        AppMethodBeat.i(225199);
        a(gVar, cel, j2, false);
        AppMethodBeat.o(225199);
    }

    private static void a(com.tencent.mm.plugin.appbrand.m.g gVar, cel cel, long j2, boolean z2) {
        AppMethodBeat.i(225198);
        m mVar = m.JEd;
        StringBuilder append = new StringBuilder("WeixinWebCompt.config({resume:").append(z2).append(", debug:");
        g.a aVar = g.JEH;
        c(gVar, append.append(g.a.getDebug()).append(", iframeUrlPattern:'").append((String) JCW.getValue()).append("', configFinishTs:").append(j2).append(", bizReportId:").append(cel.MjV).append(", options:").append(cel.MjW).append("})").toString());
        Log.i(TAG, "WeixinWebCompt.config:" + cel.MjW);
        AppMethodBeat.o(225198);
    }

    static void c(com.tencent.mm.plugin.appbrand.m.g gVar, String str) {
        AppMethodBeat.i(225200);
        gVar.evaluateJavascript(str, null);
        AppMethodBeat.o(225200);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$A8KeyResp;", "", "a8key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "fullUrl", "", "httpHeaders", "", "(Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;Ljava/lang/String;Ljava/util/Map;)V", "getFullUrl", "()Ljava/lang/String;", "getHttpHeaders", "()Ljava/util/Map;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "webview-sdk_release"})
    public static final class a {
        final com.tencent.mm.plugin.webview.f.c JDg;
        final Map<String, String> JDh;
        final String pFJ;

        public a(com.tencent.mm.plugin.webview.f.c cVar, String str, Map<String, String> map) {
            kotlin.g.b.p.h(cVar, "a8key");
            kotlin.g.b.p.h(str, "fullUrl");
            kotlin.g.b.p.h(map, "httpHeaders");
            AppMethodBeat.i(225177);
            this.JDg = cVar;
            this.pFJ = str;
            this.JDh = map;
            AppMethodBeat.o(225177);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$CreateJSContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "retCode", "", "webComptName", "", "errMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "toJsonString", "webview-sdk_release"})
    public static final class j extends Exception {
        final String JDJ;
        final String errMsg;
        final int retCode;

        public j(int i2, String str, String str2) {
            kotlin.g.b.p.h(str, "webComptName");
            kotlin.g.b.p.h(str2, "errMsg");
            AppMethodBeat.i(82842);
            this.retCode = i2;
            this.JDJ = str;
            this.errMsg = str2;
            AppMethodBeat.o(82842);
        }
    }

    static /* synthetic */ Object a(c cVar, String str, kotlin.d.d dVar) {
        AppMethodBeat.i(82907);
        Object b2 = cVar.b(str, "", dVar);
        AppMethodBeat.o(82907);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(String str, String str2, kotlin.d.d<? super a> dVar) {
        AppMethodBeat.i(82906);
        kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
        kotlin.d.h hVar2 = hVar;
        this.JCS.a(b.GET_A8KEY);
        Log.i(TAG, "start geta8key:".concat(String.valueOf(str)));
        com.tencent.mm.plugin.webview.f.c cVar = new com.tencent.mm.plugin.webview.f.c();
        com.tencent.mm.plugin.webview.d.h hVar3 = this.JCU.get();
        cVar.setUsername(hVar3 != null ? hVar3.getUsername() : null);
        cVar.a(str, new u(cVar, hVar2, this, str, str2));
        Object hxK = hVar.hxK();
        if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            kotlin.g.b.p.h(dVar, "frame");
        }
        AppMethodBeat.o(82906);
        return hxK;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000«\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¨\u0006\u0017¸\u0006\u0018"}, hxF = {"com/tencent/mm/plugin/webview/webcompt/WebComponent$getA8Key$2$1$1", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "", "onUrlRedirect", "forceRedirect", "webview-sdk_release", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$apply$lambda$1"})
    public static final class u implements com.tencent.mm.plugin.webview.f.a<bhj> {
        final /* synthetic */ c JEe;
        final /* synthetic */ String JEm;
        final /* synthetic */ com.tencent.mm.plugin.webview.f.c JEx;
        final /* synthetic */ kotlin.d.d JEy;
        final /* synthetic */ String JEz;

        u(com.tencent.mm.plugin.webview.f.c cVar, kotlin.d.d dVar, c cVar2, String str, String str2) {
            this.JEx = cVar;
            this.JEy = dVar;
            this.JEe = cVar2;
            this.JEm = str;
            this.JEz = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* synthetic */ void a(int i2, String str, String str2, bhj bhj) {
            AppMethodBeat.i(225196);
            kotlin.g.b.p.h(str, "reqUrl");
            kotlin.g.b.p.h(str2, "fullUrl");
            kotlin.g.b.p.h(bhj, "response");
            AppMethodBeat.o(225196);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, java.lang.String, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* synthetic */ void a(int i2, boolean z, String str, String str2, bhj bhj) {
            AppMethodBeat.i(225197);
            bhj bhj2 = bhj;
            kotlin.g.b.p.h(str, "reqUrl");
            kotlin.g.b.p.h(str2, "fullUrl");
            kotlin.g.b.p.h(bhj2, "response");
            b bVar = c.JDf;
            Log.i(c.TAG, "finish geta8key:".concat(String.valueOf(str2)));
            kotlin.d.d dVar = this.JEy;
            com.tencent.mm.plugin.webview.f.c cVar = this.JEx;
            LinkedList<ccc> linkedList = bhj2.LRq;
            kotlin.g.b.p.g(linkedList, "response.HttpHeader");
            LinkedList<ccc> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            for (T t : linkedList2) {
                arrayList.add(kotlin.s.U(t.xMX, t.Cyk));
            }
            a aVar = new a(cVar, str2, ae.a(arrayList, new HashMap()));
            Result.Companion companion = Result.Companion;
            dVar.resumeWith(Result.m46constructorimpl(aVar));
            this.JEe.JCS.a(b.GET_A8KEY_SUCC);
            AppMethodBeat.o(225197);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.Object] */
        @Override // com.tencent.mm.plugin.webview.f.a
        public final /* synthetic */ boolean b(int i2, String str, bhj bhj) {
            AppMethodBeat.i(225195);
            kotlin.g.b.p.h(str, "reqUrl");
            kotlin.g.b.p.h(bhj, "response");
            AppMethodBeat.o(225195);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void by(int i2, String str) {
            AppMethodBeat.i(225193);
            kotlin.g.b.p.h(str, "reqUrl");
            AppMethodBeat.o(225193);
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void bx(int i2, String str) {
            AppMethodBeat.i(225194);
            kotlin.g.b.p.h(str, "reqUrl");
            AppMethodBeat.o(225194);
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void C(int i2, String str, String str2) {
        }

        @Override // com.tencent.mm.plugin.webview.f.a
        public final void a(int i2, String str, int i3, int i4, String str2) {
            AppMethodBeat.i(82885);
            kotlin.g.b.p.h(str, "reqUrl");
            kotlin.g.b.p.h(str2, "errMsg");
            kotlin.d.d dVar = this.JEy;
            Result.Companion companion = Result.Companion;
            dVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(new j(20001, this.JEz, "getA8Key error:" + i3 + ", " + i4 + ", " + str2))));
            this.JEe.JCS.a(b.GET_A8KEY_ERR);
            AppMethodBeat.o(82885);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x01ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.o<java.lang.String, java.lang.String> a(com.tencent.mm.ab.i r12, com.tencent.mm.protocal.protobuf.cel r13) {
        /*
        // Method dump skipped, instructions count: 881
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.l.c.a(com.tencent.mm.ab.i, com.tencent.mm.protocal.protobuf.cel):kotlin.o");
    }

    public final void bi(String str, String str2, String str3) {
        AppMethodBeat.i(225201);
        kotlin.g.b.p.h(str, "webCompt");
        kotlin.g.b.p.h(str2, "event");
        if (Util.isNullOrNil(str2)) {
            Log.w(TAG, "dispatch event is null");
            AppMethodBeat.o(225201);
            return;
        }
        Log.v(TAG, "dispatch event=%s, value=%s", str2, str3);
        com.tencent.mm.ac.d.h(new q(this, str, str2, str3));
        this.JCS.a(b.SEND_EVENT_TO_JS_CONTEXT);
        AppMethodBeat.o(225201);
    }

    public final com.tencent.mm.plugin.appbrand.m.g bbt(String str) {
        AppMethodBeat.i(225202);
        kotlin.g.b.p.h(str, "webCompt");
        l.a aVar = (l.a) giJ().get(str);
        if (aVar != null) {
            com.tencent.mm.plugin.appbrand.m.g giZ = aVar.giZ();
            AppMethodBeat.o(225202);
            return giZ;
        }
        AppMethodBeat.o(225202);
        return null;
    }

    public static /* synthetic */ void a(c cVar, String str, String str2, String str3) {
        AppMethodBeat.i(82911);
        cVar.h(str, str2, str3, 0, 0);
        AppMethodBeat.o(82911);
    }

    public final void h(String str, String str2, String str3, int i2, int i3) {
        String str4;
        com.tencent.xweb.z settings;
        AppMethodBeat.i(82910);
        kotlin.g.b.p.h(str, "webCompt");
        kotlin.g.b.p.h(str2, "errMsg");
        l.a aVar = (l.a) giJ().get(str);
        if (aVar != null) {
            faf faf = new faf();
            faf.dOL = str2;
            faf.Nwa = str3;
            faf.Nwb = i2;
            faf.Nwc = i3;
            com.tencent.mm.plugin.webview.d.h hVar = this.JCU.get();
            if (hVar == null || (settings = hVar.getSettings()) == null || (str4 = settings.getUserAgentString()) == null) {
                str4 = "";
            }
            faf.Ntl = str4;
            faf.pDH = aVar.pDH;
            faf.dNI = aVar.appId;
            faf.Nwd = str;
            faf.Nwe = b.giU().getVersion();
            faf.Nwf = aVar.JDV;
            faf.Nwg = aVar.JDW;
            this.JCS.a(b.REQUEST_JS_ERR_REPORT);
            d.a aVar2 = new d.a();
            aVar2.c(faf);
            aVar2.d(new fag());
            aVar2.MB("/cgi-bin/mmbiz-bin/webcompt/reportjserr");
            aVar2.sG(2914);
            aVar2.sI(0);
            aVar2.sJ(0);
            IPCRunCgi.a(aVar2.aXF(), new r(this, str2, str3, i2, i3, str));
            AppMethodBeat.o(82910);
            return;
        }
        AppMethodBeat.o(82910);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n¨\u0006\f"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/webview/webcompt/WebComponent$errReport$1$2$2", "com/tencent/mm/plugin/webview/webcompt/WebComponent$$special$$inlined$let$lambda$1"})
    public static final class r implements IPCRunCgi.a {
        final /* synthetic */ c JEe;
        final /* synthetic */ String JEr;
        final /* synthetic */ int JEs;
        final /* synthetic */ int JEt;
        final /* synthetic */ String JEu;
        final /* synthetic */ String uLg;

        r(c cVar, String str, String str2, int i2, int i3, String str3) {
            this.JEe = cVar;
            this.uLg = str;
            this.JEr = str2;
            this.JEs = i2;
            this.JEt = i3;
            this.JEu = str3;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(82879);
            if (!(i2 == 0 && i3 == 0)) {
                this.JEe.JCS.a(b.REQUEST_JS_ERR_REPORT_ERR);
            }
            AppMethodBeat.o(82879);
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(82913);
        cVar.o(str, s.JEv);
        AppMethodBeat.o(82913);
    }

    private final void o(String str, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        AppMethodBeat.i(82912);
        com.tencent.mm.ac.d.h(new t(this, str, bVar));
        AppMethodBeat.o(82912);
    }

    public final void giK() {
        AppMethodBeat.i(225203);
        if (this.gKM) {
            a(this, "window.WeixinOpenTags && window.WeixinOpenTags.onClean()");
            this.JCS.a(b.AUTH_WITH_APP_CHANGE);
        }
        AppMethodBeat.o(225203);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u001b\b\u0003\u0018\u00002\u00020\u0001:\u0006STUVWXB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00122\b\b\u0002\u0010F\u001a\u00020\u0012J\u0011\u0010G\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020DJ\"\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010+H\u0002J\u000e\u0010N\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004J\b\u0010O\u001a\u00020DH\u0002J\u0012\u0010P\u001a\u00020D2\b\b\u0002\u0010Q\u001a\u00020\u0012H\u0007J\u0014\u0010R\u001a\u00020\u0004*\u00020@2\u0006\u0010K\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0002\u001a\u0004\b/\u0010\u0007R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b6\u0010\u0007R\u0018\u00108\u001a\u00020\u0004*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020\u0004*\u00020<8BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0018\u0010?\u001a\u00020!*\u00020@8BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion;", "", "()V", "PREFIX_DEBUG_PATH", "", "TAG", "getTAG$webview_sdk_release", "()Ljava/lang/String;", "_cachedFilePath", "debugInfo", "getDebugInfo", "debugger", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "getDebugger", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "debugger$delegate", "Lkotlin/Lazy;", "hasInitBackForegroundListener", "", "getHasInitBackForegroundListener", "()Z", "setHasInitBackForegroundListener", "(Z)V", "iframeUrlPattern", "getIframeUrlPattern", "iframeUrlPattern$delegate", "manager", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "getManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;", "manager$delegate", "matrix", "", "", "getMatrix", "()Ljava/util/List;", "matrix$delegate", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "preloadWorkers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "scheme", "scheme$annotations", "getScheme", "scriptManager", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "getScriptManager", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "scriptManager$delegate", "skeleton", "getSkeleton", "skeleton$delegate", "debugPath", "getDebugPath", "(Ljava/lang/String;)Ljava/lang/String;", "savePath", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "getSavePath", "(Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;)Ljava/lang/String;", "version", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "clearDebugPath", "", "jsapiOnly", "appOnly", "getCachedFilePath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedfilePathInMain", "getLocalScript", "path", "scripts", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScript", "initBackForegroundListener", "preloadWorker", "force", "readText", "DebugType", "Debugger", "ResType", "Script", "ScriptManager", "Worker", "webview-sdk_release"})
    public static final class b {

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "", "(Ljava/lang/String;I)V", "NA", "PARAM", "SDCARD", "SDCARD_PKG", "COMMAND", "webview-sdk_release"})
        public enum a {
            NA,
            PARAM,
            SDCARD,
            SDCARD_PKG,
            COMMAND;

            static {
                AppMethodBeat.i(82775);
                AppMethodBeat.o(82775);
            }

            public static a valueOf(String str) {
                AppMethodBeat.i(82777);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(82777);
                return aVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "", "(Ljava/lang/String;I)V", "NA", "CACHE", "NETWORK", "ASSETS", "webview-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.webview.l.c$b$c  reason: collision with other inner class name */
        public enum EnumC1961c {
            NA,
            CACHE,
            NETWORK,
            ASSETS;

            static {
                AppMethodBeat.i(82781);
                AppMethodBeat.o(82781);
            }

            public static EnumC1961c valueOf(String str) {
                AppMethodBeat.i(82783);
                EnumC1961c cVar = (EnumC1961c) Enum.valueOf(EnumC1961c.class, str);
                AppMethodBeat.o(82783);
                return cVar;
            }
        }

        static e giU() {
            AppMethodBeat.i(82827);
            kotlin.f fVar = c.JDc;
            b bVar = c.JDf;
            e eVar = (e) fVar.getValue();
            AppMethodBeat.o(82827);
            return eVar;
        }

        static C1960b giV() {
            AppMethodBeat.i(82830);
            kotlin.f fVar = c.JDe;
            b bVar = c.JDf;
            C1960b bVar2 = (C1960b) fVar.getValue();
            AppMethodBeat.o(82830);
            return bVar2;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"deleteChildJs", "", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
        public static final class g extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.vfs.o, kotlin.x> {
            public static final g JDz = new g();

            static {
                AppMethodBeat.i(82798);
                AppMethodBeat.o(82798);
            }

            g() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(com.tencent.mm.vfs.o oVar) {
                AppMethodBeat.i(82796);
                Z(oVar);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(82796);
                return xVar;
            }

            public static void Z(com.tencent.mm.vfs.o oVar) {
                AppMethodBeat.i(175715);
                kotlin.g.b.p.h(oVar, "$this$deleteChildJs");
                com.tencent.mm.vfs.o[] a2 = oVar.a(AnonymousClass1.JDA);
                if (a2 == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(a2, "listFiles { filter ->\n  …on\"))\n                }!!");
                for (com.tencent.mm.vfs.o oVar2 : a2) {
                    oVar2.delete();
                }
                AppMethodBeat.o(175715);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
        public static final class i extends kotlin.g.b.q implements kotlin.g.a.b<IPCString, kotlin.x> {
            final /* synthetic */ kotlin.d.d iCb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(kotlin.d.d dVar) {
                super(1);
                this.iCb = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(IPCString iPCString) {
                AppMethodBeat.i(225178);
                IPCString iPCString2 = iPCString;
                kotlin.g.b.p.h(iPCString2, LocaleUtil.ITALIAN);
                String str = iPCString2.value;
                if (str == null) {
                    str = "";
                }
                c.JDa = str;
                kotlin.d.d dVar = this.iCb;
                String str2 = c.JDa;
                Result.Companion companion = Result.Companion;
                dVar.resumeWith(Result.m46constructorimpl(str2));
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(225178);
                return xVar;
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$initBackForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "isPaused", "", "()Z", "setPaused", "(Z)V", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "webview-sdk_release"})
        public static final class k extends o.a {
            private boolean isPaused;

            k() {
            }

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(String str) {
                AppMethodBeat.i(263541);
                synchronized (this) {
                    try {
                        if (this.isPaused) {
                            b bVar = c.JDf;
                            Log.i(c.TAG, "jsEngine resume");
                            this.isPaused = false;
                            b bVar2 = c.JDf;
                            b.giW().resume();
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                    } finally {
                        AppMethodBeat.o(263541);
                    }
                }
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(String str) {
                AppMethodBeat.i(263542);
                synchronized (this) {
                    try {
                        if (!this.isPaused) {
                            b bVar = c.JDf;
                            Log.i(c.TAG, "jsEngine pause");
                            this.isPaused = true;
                            b bVar2 = c.JDf;
                            b.giW().pause();
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                    } finally {
                        AppMethodBeat.o(263542);
                    }
                }
            }
        }

        static /* synthetic */ Object b(kotlin.d.d<? super String> dVar) {
            AppMethodBeat.i(82821);
            kotlin.d.h hVar = new kotlin.d.h(kotlin.d.a.b.e(dVar));
            kotlin.d.h hVar2 = hVar;
            if (!kotlin.n.n.aL(c.JDa)) {
                String str = c.JDa;
                Result.Companion companion = Result.Companion;
                hVar2.resumeWith(Result.m46constructorimpl(str));
            } else {
                String str2 = MainProcessIPCService.dkO;
                kotlin.g.b.p.g(str2, "MainProcessIPCService.PROCESS_NAME");
                com.tencent.mm.ipcinvoker.a.a(str2, IPCVoid.hnE, h.JDC, new i(hVar2));
            }
            Object hxK = hVar.hxK();
            if (hxK == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                kotlin.g.b.p.h(dVar, "frame");
            }
            AppMethodBeat.o(82821);
            return hxK;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
            if ((!com.tencent.mm.plugin.webview.l.c.JDb.isEmpty()) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void zA(boolean r5) {
            /*
                r4 = 82822(0x14386, float:1.16058E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                java.util.LinkedList r0 = com.tencent.mm.plugin.webview.l.c.giM()
                int r0 = r0.size()
                r1 = 3
                if (r0 >= r1) goto L_0x0022
                if (r5 != 0) goto L_0x0028
                java.util.LinkedList r0 = com.tencent.mm.plugin.webview.l.c.giM()
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x0026
                r0 = 1
            L_0x0020:
                if (r0 == 0) goto L_0x0028
            L_0x0022:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0025:
                return
            L_0x0026:
                r0 = 0
                goto L_0x0020
            L_0x0028:
                kotlinx.coroutines.bn r0 = kotlinx.coroutines.bn.TUK
                kotlinx.coroutines.ai r0 = (kotlinx.coroutines.ai) r0
                kotlinx.coroutines.ad r1 = kotlinx.coroutines.ba.hMW()
                kotlin.d.f r1 = (kotlin.d.f) r1
                com.tencent.mm.plugin.webview.l.c$b$j r2 = new com.tencent.mm.plugin.webview.l.c$b$j
                r3 = 0
                r2.<init>(r3)
                kotlin.g.a.m r2 = (kotlin.g.a.m) r2
                r3 = 2
                kotlinx.coroutines.f.b(r0, r1, r2, r3)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0025
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.l.c.b.zA(boolean):void");
        }

        private static String c(com.tencent.mm.plugin.appbrand.appcache.p pVar, String str) {
            Throwable th;
            Throwable th2 = null;
            AppMethodBeat.i(82826);
            InputStream UR = pVar.UR(str);
            if (UR != null) {
                InputStream inputStream = UR;
                try {
                    String str2 = new String(kotlin.f.a.U(inputStream), kotlin.n.d.UTF_8);
                    kotlin.f.b.a(inputStream, null);
                    AppMethodBeat.o(82826);
                    return str2;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    kotlin.f.b.a(inputStream, th2);
                    AppMethodBeat.o(82826);
                    throw th;
                }
            } else {
                AppMethodBeat.o(82826);
                return "";
            }
        }

        static int a(com.tencent.mm.plugin.appbrand.appcache.p pVar) {
            int i2;
            AppMethodBeat.i(225185);
            try {
                b bVar = c.JDf;
                String c2 = c(pVar, "/meta.json");
                if (c2.length() == 0) {
                    AppMethodBeat.o(225185);
                    return 0;
                }
                i2 = new com.tencent.mm.ab.i(c2).optInt("version");
                AppMethodBeat.o(225185);
                return i2;
            } catch (Exception e2) {
                b bVar2 = c.JDf;
                Log.e(c.TAG, "parse IWxaPkg.version Error:" + e2.getMessage());
                i2 = 0;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)V", "version", "", "getVersion", "()I", "version$delegate", "Lkotlin/Lazy;", "getScript", "", "path", "webview-sdk_release"})
        public static final class e {
            final com.tencent.mm.plugin.appbrand.appcache.p IAs;
            private final kotlin.f IBQ = kotlin.g.ah(new a(this));

            public final int getVersion() {
                AppMethodBeat.i(82789);
                int intValue = ((Number) this.IBQ.getValue()).intValue();
                AppMethodBeat.o(82789);
                return intValue;
            }

            public e(com.tencent.mm.plugin.appbrand.appcache.p pVar) {
                kotlin.g.b.p.h(pVar, "wxaPkg");
                AppMethodBeat.i(82790);
                this.IAs = pVar;
                AppMethodBeat.o(82790);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
                final /* synthetic */ e JDy;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(e eVar) {
                    super(0);
                    this.JDy = eVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ Integer invoke() {
                    AppMethodBeat.i(82787);
                    b bVar = c.JDf;
                    Integer valueOf = Integer.valueOf(b.a(this.JDy.IAs));
                    AppMethodBeat.o(82787);
                    return valueOf;
                }
            }
        }

        static String bbv(String str) {
            AppMethodBeat.i(82828);
            String str2 = c.JDd + str;
            AppMethodBeat.o(82828);
            return str2;
        }

        static String a(cel cel) {
            AppMethodBeat.i(225186);
            String str = com.tencent.mm.loader.j.b.aKB() + "webcompt/" + cel.name + '/' + cel.md5;
            AppMethodBeat.o(225186);
            return str;
        }

        public static /* synthetic */ void e(boolean z, boolean z2, int i2) {
            AppMethodBeat.i(82829);
            if ((i2 & 1) != 0) {
                z = true;
            }
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            g gVar = g.JDz;
            if (z) {
                g.Z(new com.tencent.mm.vfs.o(c.JDd + "jsapi/"));
            }
            if (z2) {
                g.Z(new com.tencent.mm.vfs.o(c.JDd));
            }
            AppMethodBeat.o(82829);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "", ShareConstants.MEDIA_URI, "", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "debugType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;)V", "getDebugType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$DebugType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getUri", "()Ljava/lang/String;", "toString", "webview-sdk_release"})
        public static final class d {
            private final EnumC1961c JDq;
            private final a JDx;
            private final String uri;

            public d(String str, EnumC1961c cVar, a aVar) {
                kotlin.g.b.p.h(str, ShareConstants.MEDIA_URI);
                kotlin.g.b.p.h(cVar, "resType");
                kotlin.g.b.p.h(aVar, "debugType");
                AppMethodBeat.i(82785);
                this.uri = str;
                this.JDq = cVar;
                this.JDx = aVar;
                AppMethodBeat.o(82785);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ d(String str, EnumC1961c cVar, a aVar, int i2) {
                this(str, (i2 & 2) != 0 ? EnumC1961c.NA : cVar, (i2 & 4) != 0 ? a.NA : aVar);
                AppMethodBeat.i(82786);
                AppMethodBeat.o(82786);
            }

            public final String toString() {
                String str;
                AppMethodBeat.i(82784);
                StringBuilder sb = new StringBuilder("[script]\n                ");
                if (this.JDq != EnumC1961c.NA) {
                    str = "resType: " + this.JDq;
                } else {
                    str = "debugType: " + this.JDx;
                }
                String buv = kotlin.n.n.buv(sb.append(str).append("\n                ").append(this.uri).append("\n                ").toString());
                AppMethodBeat.o(82784);
                return buv;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "", "id", "", "isPreload", "", "isRecycled", "(IZZ)V", "getId", "()I", "()Z", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "toString", "", "webview-sdk_release"})
        public static final class f {
            final LinkedList<d> JDp;
            private final boolean aHN;
            private final int id;
            private final boolean ltW;

            private f(int i2, boolean z, boolean z2) {
                AppMethodBeat.i(82792);
                this.id = i2;
                this.ltW = z;
                this.aHN = z2;
                this.JDp = new LinkedList<>();
                AppMethodBeat.o(82792);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ f(int i2, boolean z, boolean z2, int i3) {
                this(i2, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? false : z2);
                AppMethodBeat.i(82793);
                AppMethodBeat.o(82793);
            }

            public final String toString() {
                AppMethodBeat.i(82791);
                String buv = kotlin.n.n.buv("[worker #" + this.id + "]\n                preload: " + this.ltW + "\n                recycled: " + this.aHN + "\n\n                " + kotlin.a.j.a(this.JDp, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "\n                ");
                AppMethodBeat.o(82791);
                return buv;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "resType", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "getResType", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;", "setResType", "(Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ResType;)V", "scripts", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Script;", "getScripts", "()Ljava/util/LinkedList;", "verion", "", "getVerion", "()I", "setVerion", "(I)V", "workers", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Worker;", "getWorkers", "clear", "", "webview-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.webview.l.c$b$b  reason: collision with other inner class name */
        public static final class C1960b {
            final LinkedList<f> JDo = new LinkedList<>();
            final LinkedList<d> JDp = new LinkedList<>();
            EnumC1961c JDq = EnumC1961c.NA;
            int JDr;
            boolean ltW;

            public C1960b() {
                AppMethodBeat.i(82780);
                AppMethodBeat.o(82780);
            }

            public final void a(EnumC1961c cVar) {
                AppMethodBeat.i(82778);
                kotlin.g.b.p.h(cVar, "<set-?>");
                this.JDq = cVar;
                AppMethodBeat.o(82778);
            }

            public final void clear() {
                AppMethodBeat.i(82779);
                this.JDo.clear();
                this.JDp.clear();
                AppMethodBeat.o(82779);
            }
        }

        public static String ejA() {
            AppMethodBeat.i(82831);
            b bVar = c.JDf;
            C1960b giV = giV();
            StringBuilder sb = new StringBuilder("\n            [debug]\n            debug: ");
            g.a aVar = g.JEH;
            String buv = kotlin.n.n.buv(sb.append(g.a.getDebug()).append("\n\n            [lib]\n            version: ").append(giV.JDr).append("\n            res: ").append(giV.JDq).append("\n\n            ").append(kotlin.a.j.a(giV.JDp, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)).append("\n\n            ").append(kotlin.a.j.a(giV.JDo, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)).append("\n            ").toString());
            AppMethodBeat.o(82831);
            return buv;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.webview.webcompt.WebComponent$Companion$preloadWorker$1", f = "WebComponent.kt", hxM = {com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.a.CTRL_INDEX}, m = "invokeSuspend")
        public static final class j extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object> {
            Object L$0;
            int label;
            private ai p$;

            j(kotlin.d.d dVar) {
                super(2, dVar);
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(82813);
                kotlin.g.b.p.h(dVar, "completion");
                j jVar = new j(dVar);
                jVar.p$ = (ai) obj;
                AppMethodBeat.o(82813);
                return jVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
                AppMethodBeat.i(82814);
                Object invokeSuspend = ((j) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
                AppMethodBeat.o(82814);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                AppMethodBeat.i(82812);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        ai aiVar = this.p$;
                        b bVar = c.JDf;
                        this.L$0 = aiVar;
                        this.label = 1;
                        if (b.b(this) == aVar) {
                            AppMethodBeat.o(82812);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(82812);
                        throw illegalStateException;
                }
                l lVar = new l();
                if (lVar.JDQ == -1) {
                    b bVar2 = c.JDf;
                    e.AnonymousClass1 giW = b.giW();
                    b bVar3 = c.JDf;
                    lVar.JDQ = giW.create(b.f("/wxwebcompt.js", lVar.JDR.JDp));
                    b bVar4 = c.JDf;
                    Log.i(c.TAG, "preload workerManager#" + lVar.id);
                } else {
                    b bVar5 = c.JDf;
                    Log.w(c.TAG, "preload twice #" + lVar.id);
                }
                c.JDb.offerFirst(lVar);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(82812);
                return xVar;
            }
        }

        static String f(String str, LinkedList<d> linkedList) {
            Throwable th;
            Throwable th2 = null;
            AppMethodBeat.i(82824);
            Log.i(c.TAG, "getLocalScript: %s", str);
            g.a aVar = g.JEH;
            if (g.a.getDebug()) {
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(bbv("jsapi".concat(String.valueOf(str))));
                if (oVar.exists()) {
                    if (linkedList != null) {
                        linkedList.add(new d(str, null, a.SDCARD, 2));
                    }
                    String an = com.tencent.mm.vfs.p.an(oVar);
                    AppMethodBeat.o(82824);
                    return an;
                }
                com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(bbv("jsapi/webcompt.wcpkg"));
                if (oVar2.exists()) {
                    if (linkedList != null) {
                        linkedList.add(new d(str, null, a.SDCARD_PKG, 2));
                    }
                    WxaPkg wxaPkg = new WxaPkg(oVar2);
                    try {
                        WxaPkg wxaPkg2 = wxaPkg;
                        wxaPkg2.bvf();
                        b bVar = c.JDf;
                        String c2 = c(wxaPkg2, str);
                        kotlin.f.b.a(wxaPkg, null);
                        AppMethodBeat.o(82824);
                        return c2;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        kotlin.f.b.a(wxaPkg, th2);
                        AppMethodBeat.o(82824);
                        throw th;
                    }
                }
            }
            e giU = giU();
            kotlin.g.b.p.h(str, "path");
            b bVar2 = c.JDf;
            String c3 = c(giU.IAs, str);
            if (linkedList != null) {
                b bVar3 = c.JDf;
                linkedList.add(new d(str, giV().JDq, null, 4));
            }
            AppMethodBeat.o(82824);
            return c3;
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
        public static final class h<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString> {
            public static final h JDC = new h();

            static {
                AppMethodBeat.i(82802);
                AppMethodBeat.o(82802);
            }

            h() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
                AppMethodBeat.i(82801);
                com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                dVar.bn(new IPCString(com.tencent.mm.pluginsdk.j.a.a.b.kC(63, 1)));
                AppMethodBeat.o(82801);
            }
        }

        public static final /* synthetic */ e.AnonymousClass1 giW() {
            AppMethodBeat.i(225187);
            kotlin.f fVar = c.JCZ;
            b bVar = c.JDf;
            e.AnonymousClass1 r0 = (e.AnonymousClass1) fVar.getValue();
            AppMethodBeat.o(225187);
            return r0;
        }

        public static final /* synthetic */ com.tencent.mm.ab.i giX() {
            AppMethodBeat.i(82841);
            kotlin.f fVar = c.IBP;
            b bVar = c.JDf;
            com.tencent.mm.ab.i iVar = (com.tencent.mm.ab.i) fVar.getValue();
            AppMethodBeat.o(82841);
            return iVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$ScriptManager;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<b.e> {
        public static final h JDH = new h();

        static {
            AppMethodBeat.i(82816);
            AppMethodBeat.o(82816);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b.e invoke() {
            AppMethodBeat.i(82815);
            b.e giY = giY();
            AppMethodBeat.o(82815);
            return giY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: com.tencent.mm.plugin.appbrand.appcache.WxaPkg */
        /* JADX WARN: Multi-variable type inference failed */
        private static b.e giY() {
            com.tencent.mm.plugin.appbrand.appcache.f fVar;
            AppMethodBeat.i(225184);
            com.tencent.mm.plugin.appbrand.appcache.f fVar2 = new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), "jsapi/webcompt.wcpkg");
            fVar2.bvf();
            try {
                b bVar = c.JDf;
                int a2 = b.a(fVar2);
                if ((!kotlin.n.n.aL(c.JDa)) && com.tencent.mm.vfs.s.YS(c.JDa)) {
                    WxaPkg wxaPkg = new WxaPkg(c.JDa);
                    wxaPkg.bvf();
                    b bVar2 = c.JDf;
                    int a3 = b.a(wxaPkg);
                    if (a3 > a2) {
                        b bVar3 = c.JDf;
                        Log.i(c.TAG, "ScriptManager use pkg res:".concat(String.valueOf(a3)));
                        b bVar4 = c.JDf;
                        b.giV().a(b.EnumC1961c.NETWORK);
                        b bVar5 = c.JDf;
                        b.giV().JDr = a3;
                        fVar = wxaPkg;
                        b.e eVar = new b.e(fVar);
                        AppMethodBeat.o(225184);
                        return eVar;
                    }
                }
                b bVar6 = c.JDf;
                Log.i(c.TAG, "ScriptManager use assets res".concat(String.valueOf(a2)));
                b bVar7 = c.JDf;
                b.giV().a(b.EnumC1961c.ASSETS);
                b bVar8 = c.JDf;
                b.giV().JDr = a2;
            } catch (Exception e2) {
                b bVar9 = c.JDf;
                Log.e(c.TAG, "pkg handle error: " + e2.getMessage());
                new j().a(b.PARSE_RES_VERSION_ERR);
            }
            fVar = fVar2;
            b.e eVar2 = new b.e(fVar);
            AppMethodBeat.o(225184);
            return eVar2;
        }
    }

    static {
        AppMethodBeat.i(82898);
        AppMethodBeat.o(82898);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1", "invoke", "()Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$manager$2$1;"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<AnonymousClass1> {
        public static final e JDE = new e();

        static {
            AppMethodBeat.i(225183);
            AppMethodBeat.o(225183);
        }

        e() {
            super(0);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            public static final a VhU = new a();

            static {
                AppMethodBeat.i(263544);
                AppMethodBeat.o(263544);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(263543);
                b bVar = c.JDf;
                if (!c.VhT) {
                    c.VhT = true;
                    new b.k().alive();
                }
                AppMethodBeat.o(263543);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnonymousClass1 invoke() {
            AppMethodBeat.i(225182);
            AnonymousClass1 r1 = new com.tencent.mm.plugin.appbrand.m.a() {
                /* class com.tencent.mm.plugin.webview.l.c.e.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.m.a
                public final IJSRuntime g(IJSRuntime.Config config) {
                    AppMethodBeat.i(225179);
                    com.tencent.mm.appbrand.v8.y c2 = com.tencent.mm.appbrand.v8.f.c(config);
                    AppMethodBeat.o(225179);
                    return c2;
                }

                @Override // com.tencent.mm.plugin.appbrand.m.a
                public final com.tencent.mm.appbrand.v8.m a(IJSRuntime iJSRuntime, int i2) {
                    AppMethodBeat.i(225180);
                    kotlin.g.b.p.h(iJSRuntime, "jsRuntime");
                    com.tencent.mm.appbrand.v8.m iP = iJSRuntime.iP(i2);
                    AppMethodBeat.o(225180);
                    return iP;
                }

                public final int create(String str) {
                    AppMethodBeat.i(225181);
                    kotlin.g.b.p.h(str, "script");
                    com.tencent.mm.plugin.appbrand.m.g bME = bME();
                    bME.evaluateJavascript(str, null);
                    kotlin.g.b.p.g(bME, "context");
                    int bMC = bME.bMC();
                    AppMethodBeat.o(225181);
                    return bMC;
                }
            };
            com.tencent.f.h.RTc.aV(a.VhU);
            AppMethodBeat.o(225182);
            return r1;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/webview/webcompt/WebComponent$refreshA8Key$2$1"})
    static final class y extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ l.a JEC;
        final /* synthetic */ kotlin.g.a.b JED;
        final /* synthetic */ kotlin.g.a.b JEE;
        final /* synthetic */ c JEe;
        Object L$0;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(l.a aVar, kotlin.d.d dVar, c cVar, kotlin.g.a.b bVar, kotlin.g.a.b bVar2) {
            super(2, dVar);
            this.JEC = aVar;
            this.JEe = cVar;
            this.JED = bVar;
            this.JEE = bVar2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(82895);
            kotlin.g.b.p.h(dVar, "completion");
            y yVar = new y(this.JEC, dVar, this.JEe, this.JED, this.JEE);
            yVar.p$ = (ai) obj;
            AppMethodBeat.o(82895);
            return yVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(82896);
            Object invokeSuspend = ((y) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(82896);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            AppMethodBeat.i(82894);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    try {
                        c cVar = this.JEe;
                        String str = this.JEC.JDU;
                        this.L$0 = aiVar;
                        this.label = 1;
                        Object a2 = c.a(cVar, str, this);
                        if (a2 != aVar) {
                            obj2 = a2;
                            this.JED.invoke(c.a(this.JEe, (a) obj2));
                            break;
                        } else {
                            AppMethodBeat.o(82894);
                            return aVar;
                        }
                    } catch (j e2) {
                        this.JEE.invoke(e2);
                        break;
                    }
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    this.JED.invoke(c.a(this.JEe, (a) obj2));
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(82894);
                    throw illegalStateException;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(82894);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$WebComptWorkerManager;", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<l> {
        final /* synthetic */ c JEe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(c cVar) {
            super(0);
            this.JEe = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ l invoke() {
            AppMethodBeat.i(82897);
            l lVar = (l) c.JDb.poll();
            if (lVar == null) {
                lVar = new l();
            }
            this.JEe.gKM = true;
            AppMethodBeat.o(82897);
            return lVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ c JEe;
        final /* synthetic */ String JEq;
        final /* synthetic */ String oBM;
        final /* synthetic */ String yiu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(c cVar, String str, String str2, String str3) {
            super(0);
            this.JEe = cVar;
            this.JEq = str;
            this.oBM = str2;
            this.yiu = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(225192);
            com.tencent.mm.plugin.appbrand.m.g bbt = this.JEe.bbt(this.JEq);
            if (bbt != null) {
                c.d(bbt, "WeixinWebCompt._dispatch('" + this.oBM + "', " + this.yiu + ')');
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(225192);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ c JEe;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ String pCF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(c cVar, String str, kotlin.g.a.b bVar) {
            super(0);
            this.JEe = cVar;
            this.pCF = str;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(82883);
            com.tencent.mm.plugin.webview.d.h hVar = this.JEe.JCU.get();
            if (hVar != null) {
                hVar.evaluateJavascript(this.pCF, new ValueCallback<String>(this) {
                    /* class com.tencent.mm.plugin.webview.l.c.t.AnonymousClass1 */
                    final /* synthetic */ t JEw;

                    {
                        this.JEw = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(82882);
                        String str2 = str;
                        kotlin.g.a.b bVar = this.JEw.gWe;
                        kotlin.g.b.p.g(str2, LocaleUtil.ITALIAN);
                        bVar.invoke(str2);
                        AppMethodBeat.o(82882);
                    }
                });
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(82883);
            return xVar;
        }
    }

    public final synchronized void clear() {
        AppMethodBeat.i(82900);
        b.giV().clear();
        if (this.gKM) {
            l giJ = giJ();
            j jVar = this.JCS;
            kotlin.g.b.p.h(jVar, "reporter");
            Log.i(TAG, "clear workerManager#" + giJ.id);
            int i2 = -1;
            for (Map.Entry entry : giJ.entrySet()) {
                l.a aVar = (l.a) entry.getValue();
                if (!aVar.used && aVar.JDT && !giJ.JDS.containsKey(entry.getKey())) {
                    aVar.aHN = true;
                    aVar.JDX = null;
                    Log.i(TAG, "WebComptWorker.recycle " + aVar.appId + '@' + aVar.JEa.name + ':' + aVar.JDZ);
                    giJ.JDS.put(entry.getKey(), aVar);
                    jVar.a(b.RECYCLE_JS_CXT);
                } else if (aVar.used || aVar.JDZ != giJ.JDQ) {
                    c cVar = aVar.JEb;
                    String str = aVar.JEa.name;
                    kotlin.g.b.p.g(str, "webComptInfo.name");
                    cVar.bi(str, "onWebComptDestroy", "{}");
                    aVar.giZ().destroy();
                } else {
                    i2 = giJ.JDQ;
                }
            }
            giJ.JDQ = i2;
            giJ.clear();
        }
        AppMethodBeat.o(82900);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.ab.i> {
        public static final g JDG = new g();

        static {
            AppMethodBeat.i(82811);
            AppMethodBeat.o(82811);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.ab.i invoke() {
            AppMethodBeat.i(82810);
            b bVar = c.JDf;
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(b.f("/meta.json", null));
            AppMethodBeat.o(82810);
            return iVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final d JDD = new d();

        static {
            AppMethodBeat.i(82805);
            AppMethodBeat.o(82805);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(82804);
            StringBuilder sb = new StringBuilder();
            b bVar = c.JDf;
            StringBuilder append = sb.append(c.JCV);
            b bVar2 = c.JDf;
            String sb2 = append.append(b.giX().getString("iframeUrlPattern")).toString();
            AppMethodBeat.o(82804);
            return sb2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends Integer>> {
        public static final f JDF = new f();

        static {
            AppMethodBeat.i(82809);
            AppMethodBeat.o(82809);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends Integer> invoke() {
            AppMethodBeat.i(82808);
            b bVar = c.JDf;
            com.tencent.mm.ab.f FH = b.giX().FH("matrix");
            kotlin.g.b.p.g(FH, "meta.getJSONArray(\"matrix\")");
            LinkedList linkedList = new LinkedList();
            int length = FH.length();
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.add(Integer.valueOf(FH.getInt(i2)));
            }
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(82808);
            return linkedList2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final i JDI = new i();

        static {
            AppMethodBeat.i(82818);
            AppMethodBeat.o(82818);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(82817);
            b bVar = c.JDf;
            String f2 = b.f("/skeleton.html", null);
            AppMethodBeat.o(82817);
            return f2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent$Companion$Debugger;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webview.l.c$c  reason: collision with other inner class name */
    static final class C1962c extends kotlin.g.b.q implements kotlin.g.a.a<b.C1960b> {
        public static final C1962c JDB = new C1962c();

        static {
            AppMethodBeat.i(82800);
            AppMethodBeat.o(82800);
        }

        C1962c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b.C1960b invoke() {
            AppMethodBeat.i(82799);
            b.C1960b bVar = new b.C1960b();
            AppMethodBeat.o(82799);
            return bVar;
        }
    }

    private final String a(a aVar) {
        String str;
        com.tencent.xweb.z settings;
        AppMethodBeat.i(82905);
        Map<String, String> map = aVar.JDh;
        com.tencent.mm.plugin.webview.d.h hVar = this.JCU.get();
        if (hVar == null || (settings = hVar.getSettings()) == null || (str = settings.getUserAgentString()) == null) {
            str = "";
        }
        map.put("User-agent", str);
        String iVar = new com.tencent.mm.ab.i(map).toString();
        kotlin.g.b.p.g(iVar, "JSONObject(httpHeaders.a… \"\"\n        }).toString()");
        StringBuilder sb = new StringBuilder("{clientVersion:");
        String str2 = BuildInfo.CLIENT_VERSION;
        kotlin.g.b.p.g(str2, "BuildInfo.CLIENT_VERSION");
        String sb2 = sb.append(a.bbs(str2)).append(",headers:").append(iVar).append(",fullUrl:").append(a.bbs(aVar.pFJ)).append('}').toString();
        AppMethodBeat.o(82905);
        return sb2;
    }

    public static final /* synthetic */ void a(c cVar, com.tencent.mm.pluginsdk.r rVar) {
        b bVar;
        AppMethodBeat.i(82915);
        a(rVar, k.STEP_EVAL_MAIN_FRAME);
        cVar.o(b.f("/wxtags.js", b.giV().JDp), new x(cVar, rVar));
        Log.i(TAG, "launchMainFrame");
        j jVar = cVar.JCS;
        switch (d.$EnumSwitchMapping$0[b.giV().JDq.ordinal()]) {
            case 1:
                bVar = b.PKG_SCRIPT_FROM_PACKAGE;
                break;
            default:
                bVar = b.PKG_SCRIPT_FROM_ASSESTS;
                break;
        }
        jVar.a(bVar);
        cVar.JCS.a(b.EVAL_MAIN_FRAME);
        AppMethodBeat.o(82915);
    }

    public static final /* synthetic */ void b(com.tencent.mm.pluginsdk.r rVar, k kVar) {
        AppMethodBeat.i(82916);
        rVar.bN(kVar.mPw + "_END", System.currentTimeMillis());
        AppMethodBeat.o(82916);
    }

    public static final /* synthetic */ void a(c cVar, com.tencent.mm.plugin.appbrand.m.g gVar, a aVar) {
        AppMethodBeat.i(225207);
        c(gVar, "WeixinWebCompt.launch(" + cVar.a(aVar) + ");");
        Log.i(TAG, "WeixinWebCompt.launch");
        AppMethodBeat.o(225207);
    }
}
