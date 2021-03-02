package com.tencent.mm.plugin.webview.core;

import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import java.net.URLEncoder;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u0013*\u0004\u0018\u00010\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "", OpenSDKTool4Assistant.EXTRA_UIN, "", "(J)V", "realUin", "getRealUin", "()J", "realUin$delegate", "Lkotlin/Lazy;", "sampleRate", "getSampleRate", "sampleRate$delegate", "getUin", "reportReceivedError", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "description", "", "failingUrl", "reportReceivedHttpError", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "response", "Lcom/tencent/xweb/WebResourceResponse;", "reportReceivedReceivedSslError", "error", "Landroid/net/http/SslError;", "shouldReport", "", "urlEncode", "Companion", "webview-sdk_release"})
public final class e {
    public static final a ILt = new a((byte) 0);
    private final kotlin.f ILr = g.ah(new b(this));
    private final kotlin.f ILs = g.ah(f.ILA);
    final long uin;

    static {
        AppMethodBeat.i(225041);
        AppMethodBeat.o(225041);
    }

    private final long fZN() {
        AppMethodBeat.i(225037);
        long longValue = ((Number) this.ILr.getValue()).longValue();
        AppMethodBeat.o(225037);
        return longValue;
    }

    private final long getSampleRate() {
        AppMethodBeat.i(225038);
        long longValue = ((Number) this.ILs.getValue()).longValue();
        AppMethodBeat.o(225038);
        return longValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ e ILu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.ILu = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(225030);
            Long valueOf = Long.valueOf(fZO());
            AppMethodBeat.o(225030);
            return valueOf;
        }

        private long fZO() {
            AppMethodBeat.i(225031);
            long j2 = 0;
            try {
                String string = p.getString((int) this.ILu.uin);
                kotlin.g.b.p.g(string, "UIN.getString(uin.toInt())");
                j2 = Long.parseLong(string);
            } catch (Exception e2) {
                Log.i("MicroMsg.WebPageErrorMonitor", "uin parse error");
            }
            AppMethodBeat.o(225031);
            return j2;
        }
    }

    public e(long j2) {
        AppMethodBeat.i(225040);
        this.uin = j2;
        AppMethodBeat.o(225040);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor$Companion;", "", "()V", "DEFAULT_REPORT_SAMPLE_RATE", "", "DEFAULT_UIN", "DEFAULT_UN_LOGIN_UIN", "ERROR_TYPE_HTTP", "", "ERROR_TYPE_NORMAL", "ERROR_TYPE_SSL", "LOG_ID", "PAGE_ICON_SUFFIX", "", "TAG", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ e ILu;
        final /* synthetic */ String ILv;
        final /* synthetic */ String ILw;
        final /* synthetic */ int tyb;

        c(e eVar, String str, int i2, String str2) {
            this.ILu = eVar;
            this.ILv = str;
            this.tyb = i2;
            this.ILw = str2;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(225032);
            Uri uri = null;
            try {
                uri = Uri.parse(this.ILv);
            } catch (Throwable th) {
                Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:" + this.ILv);
            }
            if (uri == null || (str = uri.getHost()) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "uri?.host ?: \"\"");
            h.INSTANCE.a(22086, 1, Integer.valueOf(this.tyb), str, e.aXE(this.ILv), e.aXE(this.ILw));
            AppMethodBeat.o(225032);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ e ILu;
        final /* synthetic */ WebResourceRequest ILx;
        final /* synthetic */ WebResourceResponse ILy;

        d(e eVar, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.ILu = eVar;
            this.ILx = webResourceRequest;
            this.ILy = webResourceResponse;
        }

        public final void run() {
            String str;
            Uri url;
            String path;
            String str2 = null;
            AppMethodBeat.i(225033);
            if (this.ILx.isForMainFrame() || (url = this.ILx.getUrl()) == null || (path = url.getPath()) == null || !n.nm(path, ".ico")) {
                Uri url2 = this.ILx.getUrl();
                kotlin.g.b.p.g(url2, "request.url");
                String host = url2.getHost();
                if (host == null) {
                    host = "";
                }
                kotlin.g.b.p.g(host, "request.url.host ?: \"\"");
                Uri url3 = this.ILx.getUrl();
                if (url3 != null) {
                    str = url3.toString();
                } else {
                    str = null;
                }
                String aXE = e.aXE(str);
                WebResourceResponse webResourceResponse = this.ILy;
                int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
                WebResourceResponse webResourceResponse2 = this.ILy;
                if (webResourceResponse2 != null) {
                    str2 = webResourceResponse2.getReasonPhrase();
                }
                h.INSTANCE.a(22086, 2, Integer.valueOf(statusCode), host, aXE, e.aXE(str2));
                AppMethodBeat.o(225033);
                return;
            }
            AppMethodBeat.o(225033);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.webview.core.e$e  reason: collision with other inner class name */
    public static final class RunnableC1945e implements Runnable {
        final /* synthetic */ e ILu;
        final /* synthetic */ SslError ILz;

        RunnableC1945e(e eVar, SslError sslError) {
            this.ILu = eVar;
            this.ILz = sslError;
        }

        public final void run() {
            Uri uri;
            String str;
            String str2 = null;
            AppMethodBeat.i(225034);
            String url = this.ILz.getUrl();
            if (url == null) {
                url = "";
            }
            try {
                uri = Uri.parse(url);
            } catch (Throwable th) {
                Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:".concat(String.valueOf(url)));
                uri = null;
            }
            if (uri == null || (str = uri.getHost()) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "uri?.host ?: \"\"");
            int primaryError = this.ILz.getPrimaryError();
            SslCertificate certificate = this.ILz.getCertificate();
            if (certificate != null) {
                str2 = certificate.toString();
            }
            h.INSTANCE.a(22086, 3, Integer.valueOf(primaryError), str, e.aXE(url), e.aXE(str2));
            AppMethodBeat.o(225034);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bVc() {
        AppMethodBeat.i(225039);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || (Log.getLogLevel() <= 1 && WeChatEnvironment.hasDebugger())) {
            AppMethodBeat.o(225039);
            return true;
        } else if (fZN() == 0 || fZN() == -1) {
            AppMethodBeat.o(225039);
            return true;
        } else if (fZN() <= 0 || getSampleRate() <= 0) {
            AppMethodBeat.o(225039);
            return false;
        } else if (fZN() % getSampleRate() == 0) {
            AppMethodBeat.o(225039);
            return true;
        } else {
            AppMethodBeat.o(225039);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Long> {
        public static final f ILA = new f();

        static {
            AppMethodBeat.i(225036);
            AppMethodBeat.o(225036);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            long j2;
            AppMethodBeat.i(225035);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar != null) {
                j2 = bVar.a(b.a.clicfg_webview_page_error_report_rate, 50L);
            } else {
                j2 = 50;
            }
            Log.i("MicroMsg.WebPageErrorMonitor", "WebPageErrorMonitor sample rate= ".concat(String.valueOf(j2)));
            Long valueOf = Long.valueOf(j2);
            AppMethodBeat.o(225035);
            return valueOf;
        }
    }

    public static final /* synthetic */ String aXE(String str) {
        AppMethodBeat.i(225042);
        if (str == null) {
            AppMethodBeat.o(225042);
            return "";
        }
        String encode = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        kotlin.g.b.p.g(encode, "URLEncoder.encode(this, \"UTF-8\")");
        AppMethodBeat.o(225042);
        return encode;
    }
}
