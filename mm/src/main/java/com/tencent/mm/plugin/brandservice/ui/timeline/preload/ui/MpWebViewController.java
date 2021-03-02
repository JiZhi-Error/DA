package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wxmm.v2helper;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.b.aa;
import kotlin.g.b.z;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bn;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u00012\u00020\u0001:\u000e\u0001\u0001\u0001\u0001\u0001\u0001\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\bH\u0014J\u0012\u0010J\u001a\u00020\u00182\b\u0010I\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010K\u001a\u00020GH\u0002J\b\u0010L\u001a\u00020GH\u0002J\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020GH\u0014J\b\u0010P\u001a\u00020\u0018H\u0016J\u000e\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020SJ\u0018\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\b2\b\b\u0002\u0010V\u001a\u00020\u0018J\b\u0010W\u001a\u00020GH\u0002J\u0010\u0010X\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0002J\b\u0010Y\u001a\u00020\u0018H\u0014J\u0010\u0010Z\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010Z\u001a\u00020G2\u0006\u0010]\u001a\u00020\bH\u0002J0\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020\bH\u0016J\u001c\u0010e\u001a\u00020G2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010I\u001a\u0004\u0018\u00010\bH\u0016J(\u0010h\u001a\u00020G2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020GH\u0014J\u0010\u0010l\u001a\u00020G2\b\u0010N\u001a\u0004\u0018\u00010\bJ,\u0010m\u001a\u00020\u00182\u0006\u0010a\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0oH\u0002J\u000e\u0010p\u001a\u00020\u00182\u0006\u0010R\u001a\u00020SJ\u0018\u0010q\u001a\u00020G2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020uH\u0002J\b\u0010v\u001a\u00020GH\u0002J\u0010\u0010w\u001a\u00020G2\u0006\u0010I\u001a\u00020\bH\u0002J\u0018\u0010x\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u0018H\u0014J\b\u0010z\u001a\u00020GH\u0002J\b\u0010{\u001a\u00020GH\u0002J\u0010\u0010|\u001a\u00020G2\u0006\u0010}\u001a\u00020\u0018H\u0002J\b\u0010~\u001a\u00020GH\u0002J\u001e\u0010~\u001a\u00020G2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000fJ\b\u0010\u001a\u00020GH\u0002J\u0011\u0010\u0001\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\\H\u0002J-\u0010\u0001\u001a\u00020G2\u0006\u0010a\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0oH\u0002J\u0011\u0010\u0001\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\bH\u0014J\u0011\u0010\u0001\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\bH\u0014J\t\u0010\u0001\u001a\u00020\u0018H\u0014J\t\u0010\u0001\u001a\u00020\u0018H\u0014R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188TX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001a\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010'R\u0011\u0010*\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u001a\u0010+\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010'R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010'R\u0014\u00104\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u000bR\u001a\u00106\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\r\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u00109R\u001a\u0010C\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController extends com.tencent.mm.plugin.webview.core.i {
    private static final int pFV = -101;
    static final int pFW = -102;
    private static final int pFX = -103;
    private static final int pFY = -111;
    private static final int pFZ = -112;
    private static final int pGa = -113;
    private static final int pGb = -121;
    private static final int pGc = -122;
    private static final int pGd = -123;
    private static final int pGe = -124;
    private static final int pGf = pGf;
    public static final f pGg = new f((byte) 0);
    private final eic pBf;
    private final kotlin.f pFA = kotlin.g.ah(new h(this));
    final com.tencent.mm.plugin.brandservice.ui.timeline.preload.i pFB;
    private long pFC;
    private long pFD;
    private long pFE;
    private boolean pFF;
    private boolean pFG;
    private final long pFH;
    private final kotlin.f pFI;
    private String pFJ;
    String pFK;
    private boolean pFL;
    private boolean pFM;
    private final String pFN;
    private final List<BaseWebViewController.e> pFO;
    private final String pFP;
    boolean pFQ;
    private final HashSet<String> pFR;
    boolean pFS;
    boolean pFT;
    private final Runnable pFU;

    private dei coW() {
        AppMethodBeat.i(195823);
        dei dei = (dei) this.pFI.getValue();
        AppMethodBeat.o(195823);
        return dei;
    }

    /* access modifiers changed from: package-private */
    public final String getTAG() {
        AppMethodBeat.i(195822);
        String str = (String) this.pFA.getValue();
        AppMethodBeat.o(195822);
        return str;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<String, Boolean> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MpWebViewController mpWebViewController) {
            super(1);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(String str) {
            AppMethodBeat.i(195774);
            String str2 = str;
            MpWebViewController mpWebViewController = this.pGh;
            if (str2 == null) {
                str2 = "";
            }
            Boolean valueOf = Boolean.valueOf(mpWebViewController.aix(str2));
            AppMethodBeat.o(195774);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final /* synthetic */ class i extends kotlin.g.b.n implements kotlin.g.a.a<kotlin.x> {
        i(MpWebViewController mpWebViewController) {
            super(0, mpWebViewController);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(195794);
            kotlin.l.b bp = aa.bp(MpWebViewController.class);
            AppMethodBeat.o(195794);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "updateData";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "updateData()V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195793);
            MpWebViewController.n((MpWebViewController) this.SYl);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195793);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final /* synthetic */ class j extends kotlin.g.b.n implements kotlin.g.a.a<kotlin.x> {
        j(MpWebViewController mpWebViewController) {
            super(0, mpWebViewController);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(195796);
            kotlin.l.b bp = aa.bp(MpWebViewController.class);
            AppMethodBeat.o(195796);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "tryPreloadNextWebView";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "tryPreloadNextWebView()V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195795);
            MpWebViewController.o((MpWebViewController) this.SYl);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195795);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(MpWebViewController mpWebViewController) {
            super(1);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(195797);
            String str2 = str;
            kotlin.g.b.p.h(str2, "value");
            Log.i(MpWebViewController.e(this.pGh), "load pageFrame : ".concat(String.valueOf(str2)));
            this.pGh.IKa.bN("onTmplLoadEnd", MMSlotKt.now());
            boolean a2 = kotlin.n.n.a((CharSequence) str2, (CharSequence) "ok", false);
            if (!this.pGh.pFM) {
                this.pGh.pFM = true;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b bVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.pFr;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.a(this.pGh.pBf, a2);
            }
            if (a2) {
                MpWebViewController.b(this.pGh, MpWebViewController.pFW);
                com.tencent.mm.plugin.webview.h.a.gH(this.pGh.pBf.reportId, 114);
            } else {
                MpWebViewController mpWebViewController = this.pGh;
                f fVar = MpWebViewController.pGg;
                MpWebViewController.b(mpWebViewController, MpWebViewController.pFX);
                com.tencent.mm.plugin.webview.h.a.gH(this.pGh.pBf.reportId, 115);
            }
            this.pGh.pFL = false;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195797);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.webview.d.n, String> {
        public static final p pGl = new p();

        static {
            AppMethodBeat.i(195808);
            AppMethodBeat.o(195808);
        }

        p() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(com.tencent.mm.plugin.webview.d.n nVar) {
            AppMethodBeat.i(195806);
            String c2 = c(nVar);
            AppMethodBeat.o(195806);
            return c2;
        }

        public static String c(com.tencent.mm.plugin.webview.d.n nVar) {
            AppMethodBeat.i(195807);
            kotlin.g.b.p.h(nVar, "msg");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("performance", (String) nVar.params.get("performance"));
            jSONObject.put("injectPageDataResult", (String) nVar.params.get("injectPageDataResult"));
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.p.g(jSONObject2, "pageInfo.toString()");
            AppMethodBeat.o(195807);
            return jSONObject2;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.q<String, String, List<? extends kotlin.o<? extends String, ? extends String>>, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(MpWebViewController mpWebViewController) {
            super(3);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(String str, String str2, List<? extends kotlin.o<? extends String, ? extends String>> list) {
            AppMethodBeat.i(195812);
            String str3 = str;
            String str4 = str2;
            List<? extends kotlin.o<? extends String, ? extends String>> list2 = list;
            kotlin.g.b.p.h(str3, "titles");
            kotlin.g.b.p.h(str4, "data");
            kotlin.g.b.p.h(list2, "performance");
            com.tencent.mm.plugin.webview.k.j.a(str3, str4, this.pGh.pGj, list2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195812);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.q<String, String, List<? extends kotlin.o<? extends String, ? extends String>>, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(MpWebViewController mpWebViewController) {
            super(3);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(String str, String str2, List<? extends kotlin.o<? extends String, ? extends String>> list) {
            AppMethodBeat.i(195813);
            String str3 = str;
            String str4 = str2;
            List<? extends kotlin.o<? extends String, ? extends String>> list2 = list;
            kotlin.g.b.p.h(str3, "titles");
            kotlin.g.b.p.h(str4, "data");
            kotlin.g.b.p.h(list2, "performance");
            com.tencent.mm.plugin.webview.k.j.a(str3, str4, this.pGh.pGj, list2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195813);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.q<WeakReference<Object>, m.c, fn, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(MpWebViewController mpWebViewController) {
            super(3);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(WeakReference<Object> weakReference, m.c cVar, fn fnVar) {
            AppMethodBeat.i(195814);
            m.c cVar2 = cVar;
            fn fnVar2 = fnVar;
            kotlin.g.b.p.h(weakReference, "contextRef");
            kotlin.g.b.p.h(cVar2, "result");
            kotlin.g.b.p.h(fnVar2, "appMsgContext");
            MpWebViewController.a(this.pGh, cVar2, fnVar2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195814);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<dei> {
        final /* synthetic */ MpWebViewController pGh;
        final /* synthetic */ MMWebView pGm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(MpWebViewController mpWebViewController, MMWebView mMWebView) {
            super(0);
            this.pGh = mpWebViewController;
            this.pGm = mMWebView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ dei invoke() {
            AppMethodBeat.i(195815);
            dei cpr = cpr();
            AppMethodBeat.o(195815);
            return cpr;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.tencent.mm.protocal.protobuf.dei cpr() {
            /*
            // Method dump skipped, instructions count: 225
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.u.cpr():com.tencent.mm.protocal.protobuf.dei");
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(MpWebViewController mpWebViewController) {
            super(1);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(195817);
            String str2 = str;
            kotlin.g.b.p.h(str2, LocaleUtil.ITALIAN);
            Log.i(MpWebViewController.e(this.pGh), str2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195817);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "invoke"})
    public static final class w extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(MpWebViewController mpWebViewController) {
            super(1);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(195818);
            String str2 = str;
            kotlin.g.b.p.h(str2, "value");
            Log.i(MpWebViewController.e(this.pGh), "terry trace 2.2.1 updateAuth ret:".concat(String.valueOf(str2)));
            Log.i(MpWebViewController.e(this.pGh), "onPageAuthOK, jsContent evaluateJavascript cb, ret = " + str2 + ", view " + this.pGh.pGj.getRandomStr());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195818);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "invoke"})
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(MpWebViewController mpWebViewController) {
            super(1);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(195819);
            String str2 = str;
            kotlin.g.b.p.h(str2, "value");
            Log.i(MpWebViewController.e(this.pGh), "onPageAuthFail, jsContent evaluateJavascript cb, ret = " + str2 + ", view " + this.pGh.pGj.getRandomStr());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195819);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "value", "", "invoke"})
    public static final class y extends kotlin.g.b.q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ long ipR;
        final /* synthetic */ MpWebViewController pGh;
        final /* synthetic */ long pGn;
        final /* synthetic */ z.a pGo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(MpWebViewController mpWebViewController, long j2, z.a aVar, long j3) {
            super(1);
            this.pGh = mpWebViewController;
            this.pGn = j2;
            this.pGo = aVar;
            this.ipR = j3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00e7  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.String r10) {
            /*
            // Method dump skipped, instructions count: 394
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.y.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpWebViewController(eic eic, MMWebView mMWebView) {
        super(mMWebView);
        MMWebView mMWebView2;
        kotlin.g.b.p.h(eic, "tmplParams");
        kotlin.g.b.p.h(mMWebView, "viewWV");
        AppMethodBeat.i(195849);
        this.pBf = eic;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.i iVar = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.i();
        iVar.a(this.pBf);
        this.pFB = iVar;
        this.pFF = true;
        this.pFH = 5000;
        this.pFI = kotlin.g.ah(new u(this, mMWebView));
        this.pFN = "__tmpl_webview_inject_data";
        if (!(mMWebView instanceof a.C0890a)) {
            mMWebView2 = null;
        } else {
            mMWebView2 = mMWebView;
        }
        a.C0890a aVar = (a.C0890a) mMWebView2;
        if (aVar != null) {
            aVar.setValidUrlProxy(new d(this));
            aVar.setCurrentUrlProxy(new e(this));
        }
        List<BaseWebViewController.e> cpb = super.cpb();
        cpb.addAll(kotlin.a.j.listOf((Object[]) new BaseWebViewController.e[]{new BaseWebViewController.e(aa.bp(UpdateData.class), new i(this)), new BaseWebViewController.e(aa.bp(StartPreload.class), new a(this)), new BaseWebViewController.e(aa.bp(PreloadNext.class), new j(this)), new BaseWebViewController.e(aa.bp(NotifyAuth.class), new b(this)), new BaseWebViewController.e(aa.bp(ForceUrl.class), new c(this))}));
        this.pFO = cpb;
        this.pFP = this.pFN + ".__getString()";
        this.pFR = new HashSet<>();
        this.pFU = new l(this);
        AppMethodBeat.o(195849);
    }

    public static final /* synthetic */ void a(MpWebViewController mpWebViewController, String str, String str2, Map map) {
        AppMethodBeat.i(195859);
        mpWebViewController.a(str, str2, map);
        AppMethodBeat.o(195859);
    }

    public static final /* synthetic */ boolean a(MpWebViewController mpWebViewController, int i2) {
        AppMethodBeat.i(195851);
        boolean afI = mpWebViewController.afI(i2);
        AppMethodBeat.o(195851);
        return afI;
    }

    public static final /* synthetic */ boolean a(MpWebViewController mpWebViewController, com.tencent.mm.plugin.webview.d.n nVar) {
        AppMethodBeat.i(195857);
        boolean a2 = mpWebViewController.a(nVar);
        AppMethodBeat.o(195857);
        return a2;
    }

    public static final /* synthetic */ String aiC(String str) {
        AppMethodBeat.i(195853);
        String aiB = aiB(str);
        AppMethodBeat.o(195853);
        return aiB;
    }

    public static final /* synthetic */ void b(MpWebViewController mpWebViewController, int i2) {
        AppMethodBeat.i(195860);
        mpWebViewController.afH(i2);
        AppMethodBeat.o(195860);
    }

    public static final /* synthetic */ String c(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195852);
        String str = mpWebViewController.pFJ;
        if (str == null) {
            kotlin.g.b.p.btv("fullUrl");
        }
        AppMethodBeat.o(195852);
        return str;
    }

    public static final /* synthetic */ String e(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195854);
        String tag = mpWebViewController.getTAG();
        AppMethodBeat.o(195854);
        return tag;
    }

    public static final /* synthetic */ void f(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195855);
        mpWebViewController.cpf();
        AppMethodBeat.o(195855);
    }

    public static final /* synthetic */ String g(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195856);
        String str = mpWebViewController.pFK;
        if (str == null) {
            kotlin.g.b.p.btv("contentId");
        }
        AppMethodBeat.o(195856);
        return str;
    }

    public static final /* synthetic */ Intent m(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195862);
        Intent intent = mpWebViewController.getIntent();
        AppMethodBeat.o(195862);
        return intent;
    }

    public static final /* synthetic */ void p(MpWebViewController mpWebViewController) {
        AppMethodBeat.i(195866);
        mpWebViewController.cpg();
        AppMethodBeat.o(195866);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.webview.f.a, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final /* bridge */ /* synthetic */ void a(int i2, String str, String str2, bhj bhj) {
        AppMethodBeat.i(195842);
        a(i2, str, str2, bhj);
        AppMethodBeat.o(195842);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final String coX() {
        AppMethodBeat.i(195824);
        String by = kotlin.n.n.by(BaseWebViewController.b.bj(getIntent()), HttpWrapperBase.PROTOCAL_HTTP, HttpWrapperBase.PROTOCAL_HTTPS);
        AppMethodBeat.o(195824);
        return by;
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean coY() {
        AppMethodBeat.i(195826);
        if (afI(pFZ) || afI(pGa)) {
            AppMethodBeat.o(195826);
            return true;
        }
        AppMethodBeat.o(195826);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean cpa() {
        AppMethodBeat.i(195828);
        if (!fZz() || !afI(pGb)) {
            AppMethodBeat.o(195828);
            return false;
        }
        AppMethodBeat.o(195828);
        return true;
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
    protected static final class UpdateData extends BaseWebViewController.ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(195792);
            if (getController() == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
                AppMethodBeat.o(195792);
                throw tVar;
            } else if (!waitFor(MpWebViewController.pFW) || !waitFor(MpWebViewController.pFY)) {
                AppMethodBeat.o(195792);
                return false;
            } else {
                AppMethodBeat.o(195792);
                return true;
            }
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
    protected static final class NotifyAuth extends BaseWebViewController.ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(195788);
            BaseWebViewController controller = getController();
            if (controller == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
                AppMethodBeat.o(195788);
                throw tVar;
            }
            MpWebViewController mpWebViewController = (MpWebViewController) controller;
            if (!waitFor(MpWebViewController.pFW) || ((!waitFor(mpWebViewController.IKj) || !waitFor(MpWebViewController.pGb)) && !waitFor(MpWebViewController.pGc))) {
                AppMethodBeat.o(195788);
                return false;
            }
            AppMethodBeat.o(195788);
            return true;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
    protected static final class PreloadNext extends BaseWebViewController.ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(195789);
            if (getController() == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
                AppMethodBeat.o(195789);
                throw tVar;
            }
            boolean waitFor = waitFor(MpWebViewController.pGf);
            AppMethodBeat.o(195789);
            return waitFor;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
    protected static final class StartPreload extends BaseWebViewController.ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(195790);
            BaseWebViewController controller = getController();
            if (controller == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
                AppMethodBeat.o(195790);
                throw tVar;
            }
            boolean waitFor = waitFor(((MpWebViewController) controller).IKk);
            AppMethodBeat.o(195790);
            return waitFor;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
    protected static final class ForceUrl extends BaseWebViewController.ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(195777);
            BaseWebViewController controller = getController();
            if (controller == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
                AppMethodBeat.o(195777);
                throw tVar;
            }
            MpWebViewController mpWebViewController = (MpWebViewController) controller;
            f fVar = MpWebViewController.pGg;
            if ((waitFor(MpWebViewController.pFX) || waitFor(MpWebViewController.pGa) || waitFor(MpWebViewController.pGe)) && waitFor(mpWebViewController.IKk)) {
                AppMethodBeat.o(195777);
                return true;
            }
            AppMethodBeat.o(195777);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final List<BaseWebViewController.e> cpb() {
        return this.pFO;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"})
    static final class g extends com.tencent.mm.plugin.webview.core.k {
        private final eic pBf;
        private final MMWebView pGj;

        public g(eic eic, MMWebView mMWebView) {
            kotlin.g.b.p.h(eic, "tmplParams");
            kotlin.g.b.p.h(mMWebView, "viewWV");
            AppMethodBeat.i(195787);
            this.pBf = eic;
            this.pGj = mMWebView;
            AppMethodBeat.o(195787);
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final boolean a(int i2, boolean z, String str, String str2) {
            AppMethodBeat.i(195783);
            kotlin.g.b.p.h(str, "reqUrl");
            kotlin.g.b.p.h(str2, "fullUrl");
            if (i2 != 0 || !UrlExKt.isMpUrl(str2) || !kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(str), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(str2))) {
                boolean a2 = super.a(i2, z, str, str2);
                AppMethodBeat.o(195783);
                return a2;
            }
            AppMethodBeat.o(195783);
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
            a aVar;
            AppMethodBeat.i(195784);
            kotlin.g.b.p.h(webView, "webview");
            kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            String uri = webResourceRequest.getUrl().toString();
            kotlin.g.b.p.g(uri, "request.url.toString()");
            if (!(!kotlin.g.b.p.j(uri, this.pBf.ISo)) || kotlin.n.n.J(uri, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), false)) {
                Log.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", uri, this.pBf.Nhr);
                if (webResourceRequest.isForMainFrame()) {
                    String str = this.pBf.Nhr;
                    kotlin.g.b.p.g(str, "tmplParams.initFilePath");
                    aVar = new a(str, false);
                } else if (kotlin.n.n.J(uri, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT(), false)) {
                    int i2 = this.pBf.pCV;
                    String str2 = this.pBf.hFF;
                    kotlin.g.b.p.g(str2, "tmplParams.uid");
                    aVar = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i2, str2, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT()).f(uri, "")), true);
                } else if (kotlin.n.n.J(uri, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), false)) {
                    int i3 = this.pBf.pCV;
                    String str3 = this.pBf.hFF;
                    kotlin.g.b.p.g(str3, "tmplParams.uid");
                    aVar = new a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.t.u(i3, str3, new kotlin.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()).f(uri, "")), true);
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    Log.v("MicroMsg.WebViewController", "response path: " + aVar.path);
                    f fVar = MpWebViewController.pGg;
                    WebResourceResponse g2 = f.g(this.pGj, aVar.path);
                    if (g2 != null) {
                        Log.i("MicroMsg.WebViewController", "return intercepted success");
                        AppMethodBeat.o(195784);
                        return g2;
                    }
                    Log.e("MicroMsg.WebViewController", "return intercepted null");
                    com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 126);
                    if (aVar.kwO) {
                        com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
                    }
                }
                AppMethodBeat.o(195784);
                return null;
            }
            Log.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
            AppMethodBeat.o(195784);
            return null;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\"\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-brandservice_release"})
        public static final class a {
            final boolean kwO;
            final String path;

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
                if (r3.kwO == r4.kwO) goto L_0x001e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 195781(0x2fcc5, float:2.74348E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x001e
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.g.a
                    if (r0 == 0) goto L_0x0023
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$g$a r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.g.a) r4
                    java.lang.String r0 = r3.path
                    java.lang.String r1 = r4.path
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0023
                    boolean r0 = r3.kwO
                    boolean r1 = r4.kwO
                    if (r0 != r1) goto L_0x0023
                L_0x001e:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0022:
                    return r0
                L_0x0023:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0022
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.g.a.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                AppMethodBeat.i(195780);
                String str = this.path;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z = this.kwO;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = i2 + hashCode;
                AppMethodBeat.o(195780);
                return i5;
            }

            public final String toString() {
                AppMethodBeat.i(195779);
                String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.kwO + ")";
                AppMethodBeat.o(195779);
                return str;
            }

            public a(String str, boolean z) {
                kotlin.g.b.p.h(str, "path");
                AppMethodBeat.i(195778);
                this.path = str;
                this.kwO = z;
                AppMethodBeat.o(195778);
            }
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final boolean aiD(String str) {
            AppMethodBeat.i(195785);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!(controller instanceof MpWebViewController)) {
                controller = null;
            }
            MpWebViewController mpWebViewController = (MpWebViewController) controller;
            if (mpWebViewController == null || (((!MpWebViewController.a(mpWebViewController, mpWebViewController.IKk) || !kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(str), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(mpWebViewController.coX()))) && (!MpWebViewController.a(mpWebViewController, MpWebViewController.pGb) || !kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(str), com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(MpWebViewController.c(mpWebViewController))))) || !getController().fZF())) {
                AppMethodBeat.o(195785);
                return false;
            }
            for (com.tencent.mm.plugin.webview.core.j jVar : mpWebViewController.IKd) {
                com.tencent.mm.ac.d.h(new b(jVar));
            }
            mpWebViewController.IKf = true;
            mpWebViewController.k(MpWebViewController.aiC(str), true, 8);
            AppMethodBeat.o(195785);
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final k.a c(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(195786);
            kotlin.g.b.p.h(webView, "webView");
            kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            BaseWebViewController controller = getController();
            if (!(controller instanceof MpWebViewController)) {
                controller = null;
            }
            MpWebViewController mpWebViewController = (MpWebViewController) controller;
            if (!(mpWebViewController == null || !webResourceRequest.isForMainFrame() || webResourceRequest.getUrl() == null)) {
                Log.i(MpWebViewController.e(mpWebViewController), "edw opt, shouldOverride url isForMainFrame");
                String uri = webResourceRequest.getUrl().toString();
                kotlin.g.b.p.g(uri, "request.url.toString()");
                String str = com.tencent.mm.plugin.webview.h.a.pFm;
                kotlin.g.b.p.g(str, "ConstantsPreload.HARDCODE_URL");
                if (!kotlin.n.n.J(uri, str, false) && getController().fZF()) {
                    Log.i(MpWebViewController.e(mpWebViewController), "edw opt, shouldOverride url exitTmpl");
                    MpWebViewController.f(mpWebViewController);
                    mpWebViewController.IKf = true;
                }
            }
            k.a c2 = super.c(webView, webResourceRequest);
            AppMethodBeat.o(195786);
            return c2;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ com.tencent.mm.plugin.webview.core.j pGk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(com.tencent.mm.plugin.webview.core.j jVar) {
                super(0);
                this.pGk = jVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(195782);
                this.pGk.gae();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(195782);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.webview.core.i, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void cpc() {
        AppMethodBeat.i(195829);
        a(new g(this.pBf, this.pGj));
        super.cpc();
        this.pGj.addJavascriptInterface(new m(this), this.pFN);
        getJsapi().gaT();
        getJsapi().a(new n(this));
        String str = this.pBf.ISo;
        Log.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", str, this.pBf.Nhr);
        String str2 = this.pBf.Nhr;
        kotlin.g.b.p.g(str2, "tmplParams.initFilePath");
        o oVar = new o(str2);
        Log.v(getTAG(), "response path:" + Util.nullAs(oVar.path, BuildConfig.COMMAND));
        if (f.g(this.pGj, oVar.path) != null) {
            Log.i(getTAG(), "return intercepted success");
            afH(this.IKm);
            this.pGj.loadUrl(str);
            afH(this.IKl);
            AppMethodBeat.o(195829);
            return;
        }
        Log.e(getTAG(), "return intercepted null");
        com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 126);
        if (oVar.kwO) {
            com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        }
        AppMethodBeat.o(195829);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0007¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
    public static final class m {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(MpWebViewController mpWebViewController) {
            this.pGh = mpWebViewController;
        }

        @JavascriptInterface
        @org.xwalk.core.JavascriptInterface
        public final void __log(String str) {
            JSONObject jSONObject;
            AppMethodBeat.i(195799);
            MpWebViewController mpWebViewController = this.pGh;
            if (str == null || (jSONObject = new JSONObject(str).getJSONObject("err")) == null) {
                AppMethodBeat.o(195799);
                return;
            }
            int i2 = jSONObject.getInt("errCode");
            String string = jSONObject.getString("msg");
            String tag = mpWebViewController.getTAG();
            StringBuilder sb = new StringBuilder("onWebLog:");
            String str2 = mpWebViewController.pFK;
            if (str2 == null) {
                kotlin.g.b.p.btv("contentId");
            }
            Log.e(tag, sb.append(str2).append(',').append(i2).append(',').append(string).toString());
            com.tencent.mm.plugin.webview.h.a.agi(114);
            AppMethodBeat.o(195799);
        }

        @JavascriptInterface
        @org.xwalk.core.JavascriptInterface
        public final String __getString() {
            String str;
            AppMethodBeat.i(195800);
            String g2 = MpWebViewController.g(this.pGh);
            kotlin.g.b.p.h(g2, "$this$getContent");
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m mVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.pCU;
            com.tencent.mm.vfs.o b2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.coe(), g2);
            if (b2 == null || (str = com.tencent.mm.vfs.p.an(b2)) == null) {
                str = "";
            }
            AppMethodBeat.o(195800);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
    static final class n implements h.a {
        final /* synthetic */ MpWebViewController pGh;

        n(MpWebViewController mpWebViewController) {
            this.pGh = mpWebViewController;
        }

        @Override // com.tencent.mm.plugin.webview.d.h.a
        public final boolean b(com.tencent.mm.plugin.webview.d.n nVar) {
            AppMethodBeat.i(195801);
            if (kotlin.g.b.p.j(nVar.mhO, "notifyPageInfo")) {
                Log.v(MpWebViewController.e(this.pGh), "handleMsg " + nVar.mhO);
                MpWebViewController mpWebViewController = this.pGh;
                kotlin.g.b.p.g(nVar, "msg");
                MpWebViewController.a(mpWebViewController, nVar);
                AppMethodBeat.o(195801);
                return true;
            } else if (kotlin.g.b.p.j(nVar.mhO, "updatePageAuth")) {
                Log.v(MpWebViewController.e(this.pGh), "handleMsg " + nVar.mhO);
                MpWebViewController mpWebViewController2 = this.pGh;
                kotlin.g.b.p.g(nVar, "msg");
                MpWebViewController.b(mpWebViewController2, nVar);
                AppMethodBeat.o(195801);
                return true;
            } else {
                AppMethodBeat.o(195801);
                return false;
            }
        }
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean aiw(String str) {
        AppMethodBeat.i(195830);
        kotlin.g.b.p.h(str, "url");
        if (!super.aix(str) || !(!kotlin.g.b.p.j(str, this.pBf.ISo))) {
            AppMethodBeat.o(195830);
            return false;
        }
        AppMethodBeat.o(195830);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean aix(String str) {
        AppMethodBeat.i(195831);
        kotlin.g.b.p.h(str, "url");
        if (!super.aix(str) || !(!kotlin.g.b.p.j(str, this.pBf.ISo))) {
            AppMethodBeat.o(195831);
            return false;
        }
        AppMethodBeat.o(195831);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.i, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void cpd() {
        int i2;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(195832);
        Log.i(getTAG(), "onStartLoad");
        Intent intent = getIntent();
        kotlin.g.b.p.h(intent, "intent");
        Log.v(getTAG(), "processData");
        setIntent(intent);
        this.pFD = MMSlotKt.now();
        this.pFF = intent.getBooleanExtra(e.p.Ozr, true);
        this.pFC = intent.getLongExtra(e.p.Ozs, 0);
        com.tencent.mm.kernel.b.h azG = com.tencent.mm.kernel.g.aAe().azG();
        kotlin.g.b.p.g(azG, "MMKernel.process().current()");
        g.a aBa = azG.aBa();
        String stringExtra = intent.getStringExtra(e.p.Ozu);
        if (intent.getStringExtra("rawUrl") == null || stringExtra == null) {
            Log.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag(intent));
            com.tencent.mm.plugin.webview.h.a.agi(151);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17260, 1, com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.ag(intent));
            z3 = false;
        } else {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.i iVar = this.pFB;
            if (aBa.hty < this.pFC) {
                z2 = true;
            } else {
                z2 = false;
            }
            iVar.pCc = z2;
            com.tencent.mm.plugin.webview.h.a.agi(this.pFB.pCc ? 104 : 103);
            switch (com.tencent.mm.plugin.brandservice.ui.timeline.preload.u.a(intent.getIntExtra(e.p.Ozz, -1), this.pFC, Process.myPid(), aBa.htq)) {
                case 1:
                    this.pFB.pCd = 1;
                    this.pFC = aBa.htq;
                    break;
                case 2:
                    this.pFB.pCd = 2;
                    this.pFC = -1;
                    break;
            }
            this.pFB.kwO = coW().MJt;
            this.pFB.pBZ = coW().MJu;
            this.pFB.pCa = com.tencent.mm.plugin.webview.d.k.b(this.pGj);
            this.pFB.pCb = coW().pCb;
            this.pFB.pBL = aBa.htq;
            this.pFB.pBM = aBa.htr;
            this.pFB.pBN = aBa.hts;
            this.pFB.pBO = aBa.htt;
            this.pFB.pBP = aBa.htu;
            this.pFB.pBQ = aBa.htv;
            this.pFB.pBR = aBa.htw;
            this.pFB.pBS = aBa.htx;
            this.pFB.pBT = aBa.hty;
            this.pFB.pBm = this.pFC;
            this.pFB.pBs = this.pFD;
            this.pFB.pmM = coW().pmM;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.pCU.a(this, stringExtra, coW(), new t(this));
        }
        if (!z3) {
            onFinish();
            AppMethodBeat.o(195832);
            return;
        }
        this.pFB.a(this.pBf);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.i iVar2 = this.pFB;
        String coX = coX();
        kotlin.g.b.p.h(coX, "<set-?>");
        iVar2.url = coX;
        boolean afI = afI(pFW);
        this.pFB.pBV = afI;
        this.pFB.pBU = this.pFG;
        this.pFB.pCs = this.pGj.getWebCoreType().name();
        if (afI) {
            i2 = 106;
        } else {
            i2 = 105;
        }
        com.tencent.mm.plugin.webview.h.a.agi(i2);
        boolean unused = aK(coX(), false);
        if (!this.pFS) {
            cpf();
            Log.i(getTAG(), "check notifyPage");
            this.pFT = false;
            bkj().postUIDelayed(this.pFU, this.pFH);
        }
        AppMethodBeat.o(195832);
    }

    @Override // com.tencent.mm.plugin.webview.core.i, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean cpe() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.core.i
    public final boolean aiy(String str) {
        AppMethodBeat.i(195833);
        if (kotlin.g.b.p.j(str, this.pBf.ISo) || (str != null && kotlin.n.n.J(str, "file://", false))) {
            AppMethodBeat.o(195833);
            return true;
        }
        AppMethodBeat.o(195833);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\"\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class o {
        final boolean kwO = false;
        final String path;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.kwO == r4.kwO) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 195805(0x2fcdd, float:2.74381E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.o
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$o r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.o) r4
                java.lang.String r0 = r3.path
                java.lang.String r1 = r4.path
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                boolean r0 = r3.kwO
                boolean r1 = r4.kwO
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.o.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(195804);
            String str = this.path;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.kwO;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 + hashCode;
            AppMethodBeat.o(195804);
            return i5;
        }

        public final String toString() {
            AppMethodBeat.i(195803);
            String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.kwO + ")";
            AppMethodBeat.o(195803);
            return str;
        }

        public o(String str) {
            kotlin.g.b.p.h(str, "path");
            AppMethodBeat.i(195802);
            this.path = str;
            AppMethodBeat.o(195802);
        }
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean aK(String str, boolean z2) {
        AppMethodBeat.i(195834);
        kotlin.g.b.p.h(str, "url");
        if (!(!kotlin.g.b.p.j(str, this.pBf.ISo)) || !super.aK(str, z2)) {
            AppMethodBeat.o(195834);
            return false;
        }
        AppMethodBeat.o(195834);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.i, com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(195835);
        super.b(webView, str);
        if (kotlin.g.b.p.j(str, this.pBf.ISo)) {
            if (afI(pFW) || afI(pFV)) {
                AppMethodBeat.o(195835);
                return;
            }
            Log.i(getTAG(), "checkInject start");
            com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 113);
            n("JSON.stringify(window.__appmsg_skeleton_success__)", new k(this));
            int jn = com.tencent.mm.cb.a.jn(this.pGj.getContext());
            float density = com.tencent.mm.cb.a.getDensity(this.pGj.getContext());
            Log.i(getTAG(), "adjustInnerWidth() screenWidth:" + jn + ", density:" + density);
            if (jn > 0 && density > 0.0f) {
                int i2 = (int) (((float) jn) / density);
                Log.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i2)));
                n("window.innerWidth = ".concat(String.valueOf(i2)), (kotlin.g.a.b<? super String, kotlin.x>) null);
            }
            Log.i(getTAG(), "[onPageReady]");
        }
        AppMethodBeat.o(195835);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    public static final class z implements IPCRunCgi.a {
        final /* synthetic */ MpWebViewController pGh;
        final /* synthetic */ String pGq;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n pGr;

        z(MpWebViewController mpWebViewController, String str, com.tencent.mm.plugin.webview.d.n nVar) {
            this.pGh = mpWebViewController;
            this.pGq = str;
            this.pGr = nVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(195821);
            this.pGh.pFR.remove(this.pGq);
            kotlin.g.b.p.g(dVar, "rr");
            if (!(dVar.aYK() instanceof bhj)) {
                AppMethodBeat.o(195821);
                return;
            }
            com.tencent.mm.bw.a aYK = dVar.aYK();
            if (aYK == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
                AppMethodBeat.o(195821);
                throw tVar;
            }
            bhj bhj = (bhj) aYK;
            if (Util.isNullOrNil(bhj.LRH)) {
                Log.e(MpWebViewController.e(this.pGh), "updatePageAuth fail fullurl is null");
                com.tencent.mm.plugin.webview.h.a.pl(82);
                com.tencent.mm.plugin.webview.d.h jsapi = this.pGh.getJsapi();
                if (jsapi != null) {
                    jsapi.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
                    AppMethodBeat.o(195821);
                    return;
                }
                AppMethodBeat.o(195821);
            } else if (i2 == 0 && i3 == 0) {
                try {
                    this.pGh.mHi.a(bhj.LRH, new JsapiPermissionWrapper(com.tencent.mm.platformtools.z.a(bhj.LRQ)), new GeneralControlWrapper(bhj.LRK));
                    MpWebViewController mpWebViewController = this.pGh;
                    String str2 = this.pGq;
                    String str3 = bhj.LRH;
                    kotlin.g.b.p.g(str3, "resp.FullURL");
                    Map<String, String> ij = com.tencent.mm.plugin.webview.f.c.ij(bhj.LRq);
                    kotlin.g.b.p.g(ij, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
                    MpWebViewController.a(mpWebViewController, str2, str3, ij);
                    com.tencent.mm.plugin.webview.h.a.agi(109);
                    HashMap hashMap = new HashMap();
                    String str4 = bhj.LRH;
                    kotlin.g.b.p.g(str4, "resp.FullURL");
                    hashMap.put("fullUrl", str4);
                    Log.i(MpWebViewController.e(this.pGh), "updatePageAuth values:%s", hashMap);
                    com.tencent.mm.plugin.webview.h.a.pl(81);
                    com.tencent.mm.plugin.webview.d.h jsapi2 = this.pGh.getJsapi();
                    if (jsapi2 != null) {
                        jsapi2.h(this.pGr.ISe, this.pGr.mhO + ":ok", hashMap);
                        AppMethodBeat.o(195821);
                        return;
                    }
                    AppMethodBeat.o(195821);
                } catch (Exception e2) {
                    com.tencent.mm.plugin.webview.h.a.pl(82);
                    com.tencent.mm.plugin.webview.d.h jsapi3 = this.pGh.getJsapi();
                    if (jsapi3 != null) {
                        jsapi3.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
                        AppMethodBeat.o(195821);
                        return;
                    }
                    AppMethodBeat.o(195821);
                }
            } else {
                com.tencent.mm.plugin.webview.h.a.pl(82);
                com.tencent.mm.plugin.webview.d.h jsapi4 = this.pGh.getJsapi();
                if (jsapi4 != null) {
                    jsapi4.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
                    AppMethodBeat.o(195821);
                    return;
                }
                AppMethodBeat.o(195821);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0109, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x010a, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(getTAG(), r0, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0119, code lost:
        getJsapi().h(r12.ISe, "notifyPageInfo:fail", null);
        com.tencent.mm.plugin.webview.h.a.pl(91);
        com.tencent.matrix.trace.core.AppMethodBeat.o(195836);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0133, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0134, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(getTAG(), r0, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0133 A[ExcHandler: RemoteException (r0v2 'e' android.os.RemoteException A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(com.tencent.mm.plugin.webview.d.n r12) {
        /*
        // Method dump skipped, instructions count: 324
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.a(com.tencent.mm.plugin.webview.d.n):boolean");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ MpWebViewController pGh;

        l(MpWebViewController mpWebViewController) {
            this.pGh = mpWebViewController;
        }

        public final void run() {
            AppMethodBeat.i(195798);
            Log.v(MpWebViewController.e(this.pGh), "checkNotifyPageTimer isNotifyPageSuccess=" + this.pGh.pFS + ", isStopCheckNotifyPage=" + this.pGh.pFT);
            if (!this.pGh.pFS && !this.pGh.pFT) {
                com.tencent.mm.plugin.webview.h.a.pl(92);
                this.pGh.pFB.pCu = true;
                this.pGh.pFB.pCv = true;
                MpWebViewController.p(this.pGh);
                MpWebViewController.b(this.pGh, MpWebViewController.pGe);
                Log.e(MpWebViewController.e(this.pGh), "check notifyPage timeout");
            }
            AppMethodBeat.o(195798);
        }
    }

    private final void cpf() {
        AppMethodBeat.i(195837);
        Log.d(getTAG(), "stopCheckNotifyPage");
        bkj().removeCallbacks(this.pFU);
        this.pFT = true;
        AppMethodBeat.o(195837);
    }

    private final void cpg() {
        AppMethodBeat.i(195838);
        Log.v(getTAG(), "terry trace updateKV");
        this.pFB.pBA = this.IKa.bO("onInjectStart", 0);
        this.pFB.pBB = this.IKa.bO("onInjectEnd", 0);
        this.pFB.pBD = this.IKa.bO("onTmplLoadStart", 0);
        this.pFB.pBE = this.IKa.bO("onTmplLoadEnd", 0);
        this.pFB.pBy = this.IKa.bO("onCreateStart", 0);
        this.pFB.pBz = this.IKa.bO("onCreateEnd", 0);
        this.pFB.pBW = this.pFQ;
        this.pFB.pBC = this.IKa.bO("onWebInjectEnd", 0);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.i iVar = this.pFB;
        String randomStr = this.pGj.getRandomStr();
        kotlin.g.b.p.g(randomStr, "viewWV.randomStr");
        iVar.setKey(randomStr);
        this.pFB.pBX = afI(pFW);
        AppMethodBeat.o(195838);
    }

    private void t(String str, long j2, long j3) {
        AppMethodBeat.i(195840);
        kotlin.g.b.p.h(str, "contentId");
        Log.v(getTAG(), "[updateData] " + coX());
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.aij(coX());
        aiz(coX());
        this.pFK = str;
        this.pFC = j2;
        this.pFE = j3;
        afH(pFY);
        AppMethodBeat.o(195840);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void a(int i2, String str, String str2, bhj bhj) {
        AppMethodBeat.i(195841);
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "fullUrl");
        kotlin.g.b.p.h(bhj, "response");
        if (i2 == 0) {
            aiz(str2);
        }
        super.a(i2, str, str2, bhj);
        if (i2 == 0) {
            this.pFJ = str2;
            Map<String, String> ij = com.tencent.mm.plugin.webview.f.c.ij(bhj.LRq);
            kotlin.g.b.p.g(ij, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
            com.tencent.mm.plugin.webview.h.a.gH(this.pBf.reportId, 117);
            this.pFB.pBx = MMSlotKt.now();
            this.pFB.pCe = true;
            cpg();
            this.pFB.b(new s(this));
            a(str, str2, ij);
            afH(pGb);
        }
        AppMethodBeat.o(195841);
    }

    @Override // com.tencent.mm.plugin.webview.f.a, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void a(int i2, String str, int i3, int i4, String str2) {
        AppMethodBeat.i(195844);
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "errMsg");
        super.a(i2, str, i3, i4, str2);
        if (i2 == 0) {
            this.pFJ = str;
            afH(pGc);
        }
        AppMethodBeat.o(195844);
    }

    private final void a(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(195845);
        Log.i(getTAG(), "[updatePageAuth]reqUrl:" + str + " fullUrl:" + str2 + " httpHeader:" + map);
        com.tencent.xweb.z settings = this.pGj.getSettings();
        kotlin.g.b.p.g(settings, "viewWV.settings");
        String userAgentString = settings.getUserAgentString();
        kotlin.g.b.p.g(userAgentString, "viewWV.settings.userAgentString");
        map.put("User-agent", userAgentString);
        com.tencent.mm.plugin.webview.d.h jsapi = getJsapi();
        if (map == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(195845);
            throw tVar;
        }
        jsapi.aYb(new JSONObject(map).toString());
        getJsapi().aYa(Uri.parse(str2).getQueryParameter("pass_ticket"));
        AppMethodBeat.o(195845);
    }

    public static /* synthetic */ void a(MpWebViewController mpWebViewController, String str) {
        AppMethodBeat.i(195847);
        mpWebViewController.aiA(str);
        AppMethodBeat.o(195847);
    }

    private void aiA(String str) {
        AppMethodBeat.i(195846);
        kotlin.g.b.p.h(str, "forceUrl");
        cpf();
        j.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
        if (j.a.coa()) {
            AppMethodBeat.o(195846);
            return;
        }
        fZF();
        this.IKf = true;
        k(aiB(str), true, 8);
        AppMethodBeat.o(195846);
    }

    private static String aiB(String str) {
        AppMethodBeat.i(195848);
        String appendUrlParam = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(UrlExKt.clearUrlParam$default(str, "fasttmpl_flag", false, 2, null), "fasttmpl_type", false, 2, null), "fasttmpl_fullversion", false, 2, null), "forceh5", "1");
        AppMethodBeat.o(195848);
        return appendUrlParam;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", DownloadInfo.FILENAME, "", "plugin-brandservice_release"})
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(byte b2) {
            this();
        }

        static WebResourceResponse g(WebView webView, String str) {
            FileInputStream fileInputStream;
            String str2;
            WebResourceResponse webResourceResponse;
            AppMethodBeat.i(195776);
            if (!com.tencent.mm.vfs.s.YS(str)) {
                Log.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(str)));
                AppMethodBeat.o(195776);
                return null;
            }
            String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str);
            if (!kotlin.n.n.nm(str, ".js") || !com.tencent.mm.plugin.webview.d.k.b(webView)) {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (FileNotFoundException e2) {
                    Log.printErrStackTrace("MicroMsg.WebViewController", e2, "", new Object[0]);
                    fileInputStream = null;
                }
                if (fileInputStream == null) {
                    Log.e("MicroMsg.WebViewController", "stream is null, err");
                    AppMethodBeat.o(195776);
                    return null;
                }
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeTypeByFilePath, MimeTypeUtil.ContentType.DEFAULT_CHARSET, fileInputStream);
                str2 = null;
                webResourceResponse = webResourceResponse2;
            } else {
                ag agVar = new ag(3, 256, webView);
                agVar.bso(str);
                String agVar2 = agVar.toString();
                Charset charset = StandardCharsets.UTF_8;
                kotlin.g.b.p.g(charset, "StandardCharsets.UTF_8");
                if (agVar2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(195776);
                    throw tVar;
                }
                byte[] bytes = agVar2.getBytes(charset);
                kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                webResourceResponse = new WebResourceResponse(mimeTypeByFilePath, MimeTypeUtil.ContentType.DEFAULT_CHARSET, new ByteArrayInputStream(bytes));
                str2 = agVar2;
            }
            HashMap hashMap = new HashMap();
            String hexString = Integer.toHexString(str.hashCode() & -1);
            kotlin.g.b.p.g(hexString, "Integer.toHexString(file…Code() and (-1).ushr(32))");
            if (hexString == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(195776);
                throw tVar2;
            }
            String lowerCase = hexString.toLowerCase();
            kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            hashMap.put("Cache-Control", "max-age=31536000");
            hashMap.put("ETag", lowerCase);
            if (str2 != null) {
                hashMap.put("RunLocalJS", str2);
            }
            webResourceResponse.setResponseHeaders(hashMap);
            Log.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", str, lowerCase);
            AppMethodBeat.o(195776);
            return webResourceResponse;
        }
    }

    static {
        AppMethodBeat.i(195850);
        AppMethodBeat.o(195850);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f = "MpWebViewController.kt", hxM = {v2helper.EMethodSetSendToNetworkOn}, m = "invokeSuspend")
    public static final class q extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object> {
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(MpWebViewController mpWebViewController, kotlin.d.d dVar) {
            super(2, dVar);
            this.pGh = mpWebViewController;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(195810);
            kotlin.g.b.p.h(dVar, "completion");
            q qVar = new q(this.pGh, dVar);
            qVar.p$ = (ai) obj;
            AppMethodBeat.o(195810);
            return qVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(195811);
            Object invokeSuspend = ((q) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(195811);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(195809);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = this.p$;
                    this.label = 1;
                    if (au.a(300, this) == aVar) {
                        AppMethodBeat.o(195809);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(195809);
                    throw illegalStateException;
            }
            MpWebViewController.b(this.pGh, MpWebViewController.pGf);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(195809);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MpWebViewController mpWebViewController) {
            super(0);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(195791);
            String str = "MicroMsg.MpWebViewController:" + this.pGh.fZu();
            AppMethodBeat.o(195791);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$2"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MpWebViewController mpWebViewController) {
            super(0);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(195775);
            String currentUrl = this.pGh.getCurrentUrl();
            AppMethodBeat.o(195775);
            return currentUrl;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ MpWebViewController pGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MpWebViewController mpWebViewController) {
            super(0);
            this.pGh = mpWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(195771);
            kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new kotlin.g.a.m<ai, kotlin.d.d<? super kotlin.x>, Object>(this, null) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController.a.AnonymousClass1 */
                Object L$0;
                int label;
                private ai p$;
                final /* synthetic */ a pGi;

                {
                    this.pGi = r2;
                }

                @Override // kotlin.d.b.a.a
                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                    AppMethodBeat.i(195769);
                    kotlin.g.b.p.h(dVar, "completion");
                    AnonymousClass1 r0 = 

                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
                    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
                        final /* synthetic */ MpWebViewController pGh;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        b(MpWebViewController mpWebViewController) {
                            super(0);
                            this.pGh = mpWebViewController;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            boolean z;
                            AppMethodBeat.i(195772);
                            MpWebViewController mpWebViewController = this.pGh;
                            if (!MpWebViewController.a(this.pGh, MpWebViewController.pGc)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            MpWebViewController.b(mpWebViewController, z);
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(195772);
                            return xVar;
                        }
                    }

                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
                    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
                        final /* synthetic */ MpWebViewController pGh;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        c(MpWebViewController mpWebViewController) {
                            super(0);
                            this.pGh = mpWebViewController;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(195773);
                            MpWebViewController.a(this.pGh, this.pGh.coX());
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(195773);
                            return xVar;
                        }
                    }

                    public final boolean ah(Intent intent) {
                        AppMethodBeat.i(195825);
                        kotlin.g.b.p.h(intent, "intent");
                        if (this.IJR) {
                            String stringExtra = intent.getStringExtra("rawUrl");
                            kotlin.g.b.p.g(stringExtra, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
                            if (kotlin.g.b.p.j(kotlin.n.n.by(stringExtra, HttpWrapperBase.PROTOCAL_HTTP, HttpWrapperBase.PROTOCAL_HTTPS), coX())) {
                                AppMethodBeat.o(195825);
                                return true;
                            }
                        }
                        AppMethodBeat.o(195825);
                        return false;
                    }

                    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
                    public final boolean coZ() {
                        AppMethodBeat.i(195827);
                        if (!afI(this.IKl) || !afI(pFW)) {
                            AppMethodBeat.o(195827);
                            return false;
                        }
                        AppMethodBeat.o(195827);
                        return true;
                    }

                    private final void aiz(String str) {
                        AppMethodBeat.i(195839);
                        this.IJM = str;
                        aXx(str);
                        aXy(str);
                        kotlin.g.b.p.h(str, "<set-?>");
                        this.djt = str;
                        AppMethodBeat.o(195839);
                    }

                    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
                    public final boolean cph() {
                        AppMethodBeat.i(195843);
                        boolean afI = afI(this.IKl);
                        AppMethodBeat.o(195843);
                        return afI;
                    }

                    public static final /* synthetic */ boolean b(MpWebViewController mpWebViewController, com.tencent.mm.plugin.webview.d.n nVar) {
                        AppMethodBeat.i(195858);
                        com.tencent.mm.plugin.webview.h.a.pl(80);
                        String coX = mpWebViewController.coX();
                        if (mpWebViewController.pFR.contains(coX)) {
                            Log.e(mpWebViewController.getTAG(), "updatePageAuth fail, url:%s already run");
                            com.tencent.mm.plugin.webview.d.h jsapi = mpWebViewController.getJsapi();
                            if (jsapi != null) {
                                jsapi.h(nVar.ISe, nVar.mhO + ":fail updating", null);
                            }
                            com.tencent.mm.plugin.webview.h.a.pl(82);
                            AppMethodBeat.o(195858);
                            return false;
                        }
                        mpWebViewController.pFR.add(coX);
                        mpWebViewController.fZr().a(coX, 8, new z(mpWebViewController, coX, nVar));
                        AppMethodBeat.o(195858);
                        return true;
                    }

                    public static final /* synthetic */ void a(MpWebViewController mpWebViewController, m.c cVar, fn fnVar) {
                        AppMethodBeat.i(195861);
                        Log.i(mpWebViewController.getTAG(), "processGetAppContext isCached " + cVar.bGq);
                        int i2 = mpWebViewController.pBf.reportId;
                        mpWebViewController.pFG = cVar.bGq;
                        com.tencent.mm.plugin.webview.h.a.gH(mpWebViewController.pBf.reportId, cVar.bGq ? 121 : 122);
                        mpWebViewController.pFB.pBu = cVar.start;
                        mpWebViewController.pFB.pBv = cVar.boX;
                        mpWebViewController.pFB.pBg = fnVar.KIQ;
                        if (cVar.bGq) {
                            mpWebViewController.pFE = MMSlotKt.now();
                            mpWebViewController.pFB.pBt = mpWebViewController.pFE;
                            mpWebViewController.t(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(fnVar), mpWebViewController.pFC, mpWebViewController.pFE);
                            AppMethodBeat.o(195861);
                            return;
                        }
                        if (cVar.isSuccess) {
                            String str = fnVar.KIR;
                            com.tencent.mm.plugin.webview.h.a.gH(i2, 123);
                            if (str != null) {
                                if (!kotlin.n.n.aL(str)) {
                                    com.tencent.mm.plugin.webview.h.a.gH(i2, 120);
                                    mpWebViewController.aiA(UrlExKt.appendStats(str, mpWebViewController.coW()));
                                    AppMethodBeat.o(195861);
                                    return;
                                }
                            }
                            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.n.b(fnVar)) {
                                com.tencent.mm.plugin.webview.h.a.gH(i2, 124);
                                mpWebViewController.pFE = MMSlotKt.now();
                                mpWebViewController.pFB.pBt = mpWebViewController.pFE;
                                mpWebViewController.t(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(fnVar), mpWebViewController.pFC, mpWebViewController.pFE);
                                mpWebViewController.pFB.pBY = cVar.pBY;
                                AppMethodBeat.o(195861);
                                return;
                            }
                        }
                        com.tencent.mm.plugin.webview.h.a.gH(i2, 125);
                        mpWebViewController.pFB.pCu = true;
                        mpWebViewController.cpg();
                        AppMethodBeat.o(195861);
                    }

                    public static final /* synthetic */ void n(MpWebViewController mpWebViewController) {
                        Object obj;
                        int i2;
                        String str;
                        String str2;
                        Object obj2 = null;
                        AppMethodBeat.i(195863);
                        long now = MMSlotKt.now();
                        mpWebViewController.IKa.bN("onInjectStart", now);
                        String tag = mpWebViewController.getTAG();
                        StringBuilder sb = new StringBuilder("[updateData]data contentId:");
                        String str3 = mpWebViewController.pFK;
                        if (str3 == null) {
                            kotlin.g.b.p.btv("contentId");
                        }
                        Log.i(tag, sb.append(str3).append(" startLoadPage:").append(mpWebViewController.pFC).append(" receivePageData:").append(mpWebViewController.pFE).toString());
                        JSONObject put = new JSONObject().put("data", "@param").put(AppMeasurement.Param.TIMESTAMP, new JSONObject().put("startLoadPage", mpWebViewController.pFC).put("receivePageData", mpWebViewController.pFE)).put("url", mpWebViewController.coX()).put("key", mpWebViewController.pGj.getRandomStr());
                        com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
                        if (!com.tencent.mm.plugin.webview.ui.tools.video.a.gic()) {
                            str = "";
                        } else {
                            Log.i("MicroMsg.MPVideoPreviewDataMgr", "getOnReceiveNativeData");
                            JSONObject jSONObject = new JSONObject();
                            String string = ((MultiProcessMMKV) com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot()).getString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
                            if (Util.isNullOrNil(string)) {
                                Log.i("MicroMsg.MPVideoPreviewDataMgr", "getOnReceiveNativeData vid null");
                                str = "";
                            } else {
                                ((MultiProcessMMKV) com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
                                Map<String, Object> bbj = com.tencent.mm.plugin.webview.ui.tools.video.a.bbj(string);
                                if (bbj != null) {
                                    obj = bbj.get("videoInitialSnapshot");
                                } else {
                                    obj = null;
                                }
                                if (!(obj instanceof String)) {
                                    obj = null;
                                }
                                String str4 = (String) obj;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                if (Util.isNullOrNil(str4)) {
                                    Log.i("MicroMsg.MPVideoPreviewDataMgr", "getOnReceiveNativeData snap null");
                                    str = "";
                                } else {
                                    if (bbj == null || (i2 = bbj.get("videoInitialTime")) == null) {
                                        i2 = 0;
                                    }
                                    jSONObject.put("videoInitialTime", i2);
                                    if (bbj != null) {
                                        obj2 = bbj.get("videoInitialSnapshot");
                                    }
                                    jSONObject.put("videoInitialSnapshot", obj2);
                                    str = ",window.onReceiveNativeData(" + jSONObject + ')';
                                    Log.v("MicroMsg.MPVideoPreviewDataMgr", "getOnReceiveNativeData result = ".concat(String.valueOf(str)));
                                }
                            }
                        }
                        String jSONObject2 = put.toString();
                        kotlin.g.b.p.g(jSONObject2, "jsonObj.toString()");
                        String str5 = "[window.onReceivePageData(" + jSONObject2 + "),Date.now()" + str + "].join(',')";
                        String by = kotlin.n.n.by(str5, "\"@param\"", mpWebViewController.pFP);
                        long currentTimeMillis = System.currentTimeMillis();
                        z.a aVar2 = new z.a();
                        aVar2.SYB = false;
                        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m mVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.pCU;
                        MMFileSlotManager coe = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.coe();
                        String str6 = mpWebViewController.pFK;
                        if (str6 == null) {
                            kotlin.g.b.p.btv("contentId");
                        }
                        com.tencent.mm.vfs.o b2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b(coe, str6);
                        if (mpWebViewController.pGj.supportFeature(2008) && b2 != null) {
                            String by2 = kotlin.n.n.by(str5, "\"@param\"", "@param");
                            Log.i(mpWebViewController.getTAG(), "onReceivePageData buff parse native:".concat(String.valueOf(by2)));
                            ag agVar = new ag(0, 0, mpWebViewController.pGj);
                            agVar.bsp(by2);
                            agVar.bsq(b2.getPath());
                            agVar.bsr((mpWebViewController.pFN + ".__log(JSON.stringify(" + "{err:window['___xweb_script_err']}" + "));console.log('__log', " + "{err:window['___xweb_script_err']}" + ");") + '\n' + by);
                            str5 = agVar.toString();
                            kotlin.g.b.p.g(str5, "XWebScript(\n            …\n            }.toString()");
                            aVar2.SYB = true;
                            com.tencent.mm.plugin.webview.h.a.aP(120, System.currentTimeMillis() - currentTimeMillis);
                        }
                        if (!aVar2.SYB) {
                            str2 = "javascript:".concat(String.valueOf(by));
                        } else {
                            str2 = str5;
                        }
                        mpWebViewController.n(str2, new y(mpWebViewController, now, aVar2, currentTimeMillis));
                        AppMethodBeat.o(195863);
                    }

                    public static final /* synthetic */ void o(MpWebViewController mpWebViewController) {
                        AppMethodBeat.i(195864);
                        Log.i(mpWebViewController.getTAG(), "[preloadNextWebView] " + mpWebViewController.pFF);
                        if (mpWebViewController.pFF) {
                            a aVar = a.pGQ;
                            a.DH(mpWebViewController.coW().pCV);
                        }
                        AppMethodBeat.o(195864);
                    }

                    public static final /* synthetic */ void b(MpWebViewController mpWebViewController, boolean z2) {
                        AppMethodBeat.i(195865);
                        StringBuilder sb = new StringBuilder("history.replaceState({},\"\",\"");
                        String str = mpWebViewController.pFJ;
                        if (str == null) {
                            kotlin.g.b.p.btv("fullUrl");
                        }
                        mpWebViewController.n(sb.append(str).append("\");").toString(), new v(mpWebViewController));
                        if (z2) {
                            String str2 = mpWebViewController.pFJ;
                            if (str2 == null) {
                                kotlin.g.b.p.btv("fullUrl");
                            }
                            String appendStats = UrlExKt.appendStats(str2, mpWebViewController.coW());
                            Log.i(mpWebViewController.getTAG(), "terry trace 2.2 updateAuth");
                            Log.i(mpWebViewController.getTAG(), "[updateAuth]ok fullUrl:%s", appendStats);
                            mpWebViewController.n("window.onPageAuthOK(" + new JSONObject().put("fullUrl", appendStats) + ')', new w(mpWebViewController));
                            com.tencent.mm.plugin.webview.h.a.gH(mpWebViewController.pBf.reportId, 133);
                            AppMethodBeat.o(195865);
                            return;
                        }
                        Log.i(mpWebViewController.getTAG(), "[updateAuth]fail");
                        mpWebViewController.n("window.onPageAuthFail()", new x(mpWebViewController));
                        com.tencent.mm.plugin.webview.h.a.gH(mpWebViewController.pBf.reportId, com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX);
                        AppMethodBeat.o(195865);
                    }
                }
