package com.tencent.mm.plugin.websearch.webview;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/WebSearchClient;", "Lcom/tencent/xweb/WebViewClient;", "templateType", "", "(I)V", "TAG", "", "handleRequest", "Lcom/tencent/xweb/WebResourceResponse;", "view", "Lcom/tencent/xweb/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "shouldInterceptRequest", "bundle", "Landroid/os/Bundle;", "wrapResponse", "url", "ui-websearch_release"})
public class f extends ac {
    private final String TAG;
    private final int jyz;

    public f(byte b2) {
        this();
    }

    public /* synthetic */ f() {
        this(-1);
    }

    public f(int i2) {
        this.jyz = i2;
        this.TAG = "MicroMsg.WebSearch.WebSearchClient";
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(198059);
        WebResourceResponse d2 = d(webView, webResourceRequest);
        if (d2 == null) {
            d2 = super.a(webView, webResourceRequest);
        }
        AppMethodBeat.o(198059);
        return d2;
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(198060);
        WebResourceResponse d2 = d(webView, webResourceRequest);
        if (d2 == null) {
            d2 = super.a(webView, webResourceRequest, bundle);
        }
        AppMethodBeat.o(198060);
        return d2;
    }

    private final WebResourceResponse d(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        String str;
        AppMethodBeat.i(198061);
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null) {
            AppMethodBeat.o(198061);
            return null;
        }
        p.g(uri, LocaleUtil.ITALIAN);
        if (n.J(uri, "weixin://fts", false)) {
            str = uri;
        } else {
            str = null;
        }
        if (str != null) {
            p.g(str, LocaleUtil.ITALIAN);
            WebResourceResponse aXq = aXq(str);
            AppMethodBeat.o(198061);
            return aXq;
        }
        if (this.jyz >= 0) {
            at afr = ai.afr(this.jyz);
            p.g(uri, LocaleUtil.ITALIAN);
            StringBuilder sb = new StringBuilder("file://");
            p.g(afr, "webSearchTemplate");
            if (!n.J(uri, sb.append(afr.fYw()).toString(), false)) {
                uri = null;
            }
            if (uri != null) {
                String fYx = afr.fYx();
                if (!Util.isNullOrNil(fYx)) {
                    Log.i(this.TAG, "hit js xweb script %s", fYx);
                    ag agVar = new ag(2, 0, webView);
                    agVar.setCacheKey(afr.fYw() + "." + fYx);
                    agVar.bso(afr.fYw());
                    String agVar2 = agVar.toString();
                    p.g(agVar2, "script.toString()");
                    Charset charset = StandardCharsets.UTF_8;
                    p.g(charset, "StandardCharsets.UTF_8");
                    if (agVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(198061);
                        throw tVar;
                    }
                    byte[] bytes = agVar2.getBytes(charset);
                    p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    WebResourceResponse webResourceResponse = new WebResourceResponse(null, MimeTypeUtil.ContentType.DEFAULT_CHARSET, new ByteArrayInputStream(bytes));
                    AppMethodBeat.o(198061);
                    return webResourceResponse;
                }
                AppMethodBeat.o(198061);
                return null;
            }
        }
        AppMethodBeat.o(198061);
        return null;
    }

    private final WebResourceResponse aXq(String str) {
        InputStream inputStream;
        AppMethodBeat.i(198062);
        String str2 = this.TAG;
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        Log.i(str2, "url=%s | thread=%d", str, Long.valueOf(currentThread.getId()));
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("path");
            if (queryParameter == null) {
                p.hyc();
            }
            inputStream = s.openRead(queryParameter);
        } catch (Exception e2) {
            inputStream = null;
        }
        if (inputStream != null) {
            WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", "utf8", inputStream);
            AppMethodBeat.o(198062);
            return webResourceResponse;
        }
        AppMethodBeat.o(198062);
        return null;
    }
}
