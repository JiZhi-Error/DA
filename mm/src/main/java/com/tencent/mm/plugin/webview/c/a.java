package com.tencent.mm.plugin.webview.c;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;
import kotlin.Result;
import kotlin.a.e;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002JA\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J6\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "canDebug", "", "fetchPage", "", "", "", "url", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "overrideProcessResult", "reason", "", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideRequestAuthCurrentUrl", "overrideUrlRedirect", "forceRedirect", "fullUrl", "callback", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "", "Companion", "webview-sdk_release"})
public final class a extends k {
    public static final C1944a IQQ = new C1944a((byte) 0);

    static {
        AppMethodBeat.i(225099);
        AppMethodBeat.o(225099);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "conn", "invoke", "com/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor$fetchPage$2$1"})
    public static final class c extends q implements kotlin.g.a.b<z, z> {
        final /* synthetic */ Map IQR;
        final /* synthetic */ kotlin.d.d IQS;
        final /* synthetic */ a IQT;
        final /* synthetic */ String pFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.d.d dVar, a aVar, String str, Map map) {
            super(1);
            this.IQS = dVar;
            this.IQT = aVar;
            this.pFh = str;
            this.IQR = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ z invoke(z zVar) {
            AppMethodBeat.i(225089);
            z zVar2 = zVar;
            p.h(zVar2, "conn");
            z a2 = a.a(zVar2, this.IQR, new kotlin.g.a.b<CronetLogic.CronetTaskResult, x>(this) {
                /* class com.tencent.mm.plugin.webview.c.a.c.AnonymousClass1 */
                final /* synthetic */ c IQU;

                {
                    this.IQU = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(CronetLogic.CronetTaskResult cronetTaskResult) {
                    AppMethodBeat.i(225088);
                    CronetLogic.CronetTaskResult cronetTaskResult2 = cronetTaskResult;
                    if (cronetTaskResult2 == null) {
                        kotlin.d.d dVar = this.IQU.IQS;
                        Result.Companion companion = Result.Companion;
                        dVar.resumeWith(Result.m46constructorimpl(null));
                    } else if (cronetTaskResult2.statusCode != 200 || cronetTaskResult2.getHeaderMapList() == null) {
                        kotlin.d.d dVar2 = this.IQU.IQS;
                        Result.Companion companion2 = Result.Companion;
                        dVar2.resumeWith(Result.m46constructorimpl(null));
                    } else {
                        kotlin.d.d dVar3 = this.IQU.IQS;
                        Result.Companion companion3 = Result.Companion;
                        dVar3.resumeWith(Result.m46constructorimpl(cronetTaskResult2.getHeaderMapList()));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(225088);
                    return xVar;
                }
            });
            AppMethodBeat.o(225089);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor$Companion;", "", "()V", "DEFAULT_DOWNLOAD_PATH", "", "HEADER_SET_COOKIE", "REQ_HEADER_REQUEST_COOKIE", "TAG", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.webview.c.a$a  reason: collision with other inner class name */
    public static final class C1944a {
        private C1944a() {
        }

        public /* synthetic */ C1944a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ BaseWebViewController a(a aVar) {
        AppMethodBeat.i(225100);
        BaseWebViewController controller = aVar.getController();
        AppMethodBeat.o(225100);
        return controller;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean gag() {
        boolean z;
        AppMethodBeat.i(225096);
        String currentUrl = getController().getCurrentUrl();
        if (currentUrl == null || !n.J(currentUrl, "https", false)) {
            AppMethodBeat.o(225096);
            return false;
        }
        String currentUrl2 = getController().getCurrentUrl();
        String str = currentUrl2;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(225096);
            return false;
        }
        Log.i("MicroMsg.BizMpVideoInterceptor", "RequestAuthCurrentUrl startGetA8Key:".concat(String.valueOf(currentUrl2)));
        getController().k(currentUrl2, true, 11);
        AppMethodBeat.o(225096);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean a(int i2, boolean z, String str, String str2) {
        AppMethodBeat.i(225097);
        p.h(str, "reqUrl");
        p.h(str2, "fullUrl");
        if (z || i2 != 11) {
            AppMethodBeat.o(225097);
            return false;
        }
        AppMethodBeat.o(225097);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean a(int i2, String str, bhj bhj) {
        boolean z;
        AppMethodBeat.i(225098);
        p.h(str, "reqUrl");
        p.h(bhj, "resp");
        if (i2 != 11) {
            AppMethodBeat.o(225098);
            return false;
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || (Log.getLogLevel() == 0 && WeChatEnvironment.hasDebugger())) {
            z = true;
        } else {
            z = false;
        }
        if (!(z ? true : (bhj.LRK.LQC & TPMediaCodecProfileLevel.HEVCHighTierLevel6) > 0)) {
            AppMethodBeat.o(225098);
            return false;
        }
        Log.i("MicroMsg.BizMpVideoInterceptor", "on spa auth resp handle start");
        f.b(bn.TUK, (kotlin.d.f) null, new d(this, bhj, null), 3);
        AppMethodBeat.o(225098);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webview/interceptor/SpaAuthInterceptor$callback$1$2", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskCallback;", "onCronetReceiveHeader", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Lcom/tencent/mars/cdn/CronetLogic$ResponseHeader;", "status_code", "onCronetTaskCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CronetLogic$CronetTaskResult;", "onDownloadProgressChanged", "progress", "Lcom/tencent/mars/cdn/CronetLogic$CronetDownloadProgress;", "webview-sdk_release"})
    public static final class b implements CronetLogic.CronetTaskCallback {
        final /* synthetic */ Map IQR;
        final /* synthetic */ kotlin.g.a.b pAj;

        b(Map map, kotlin.g.a.b bVar) {
            this.IQR = map;
            this.pAj = bVar;
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult) {
            CronetLogic.HeaderMap[] headerMapArr;
            String str2 = null;
            AppMethodBeat.i(225086);
            this.pAj.invoke(cronetTaskResult);
            StringBuilder sb = new StringBuilder("onCronetTaskCompleted: ");
            if (!(cronetTaskResult == null || (headerMapArr = cronetTaskResult.headers) == null)) {
                str2 = e.a(headerMapArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            }
            Log.i("MicroMsg.BizMpVideoInterceptor", sb.append(str2).toString());
            AppMethodBeat.o(225086);
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
        public final int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i2) {
            CronetLogic.HeaderMap[] headerMapArr;
            String str = null;
            AppMethodBeat.i(225087);
            StringBuilder sb = new StringBuilder("onCronetReceiveHeader: ");
            if (!(responseHeader == null || (headerMapArr = responseHeader.headers) == null)) {
                str = e.a(headerMapArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            }
            Log.i("MicroMsg.BizMpVideoInterceptor", sb.append(str).toString());
            AppMethodBeat.o(225087);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.webview.interceptor.SpaAuthInterceptor$overrideProcessResult$1", f = "SpaAuthInterceptor.kt", hxM = {72, com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX}, m = "invokeSuspend")
    public static final class d extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ a IQT;
        final /* synthetic */ bhj IQV;
        Object L$0;
        int label;
        private ai p$;
        Object pED;
        Object pEE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, bhj bhj, kotlin.d.d dVar) {
            super(2, dVar);
            this.IQT = aVar;
            this.IQV = bhj;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(225094);
            p.h(dVar, "completion");
            d dVar2 = new d(this.IQT, this.IQV, dVar);
            dVar2.p$ = (ai) obj;
            AppMethodBeat.o(225094);
            return dVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(225095);
            Object invokeSuspend = ((d) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(225095);
            return invokeSuspend;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x00c6  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0185  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
            // Method dump skipped, instructions count: 418
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.c.a.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final /* synthetic */ z a(z zVar, Map map, kotlin.g.a.b bVar) {
        AppMethodBeat.i(225101);
        zVar.bjR();
        zVar.setUseCaches(false);
        zVar.setRequestMethod("GET");
        zVar.bjT();
        zVar.bjS();
        for (Map.Entry entry : map.entrySet()) {
            zVar.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        zVar.setSavePath(new o("wcf://WebPrefetchContent/spa/auth").getPath());
        zVar.a(new b(map, bVar));
        zVar.setReadTimeout(10000);
        zVar.setConnectTimeout(3000);
        zVar.connect();
        AppMethodBeat.o(225101);
        return zVar;
    }
}
