package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.fac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e extends k {
    private final String TAG = "MicroMsg.WebComponentInterceptor";

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean aXP(String str) {
        AppMethodBeat.i(225208);
        p.h(str, "url");
        c.b bVar = c.JDf;
        if (n.J(str, c.JCV, false)) {
            AppMethodBeat.o(225208);
            return true;
        }
        AppMethodBeat.o(225208);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final k.a o(WebView webView, String str) {
        AppMethodBeat.i(225209);
        p.h(webView, "webView");
        p.h(str, "url");
        c.b bVar = c.JDf;
        if (n.J(str, c.JCV, false)) {
            k.a aVar = new k.a(true, false);
            AppMethodBeat.o(225209);
            return aVar;
        }
        k.a o = super.o(webView, str);
        AppMethodBeat.o(225209);
        return o;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
        k gbi;
        String str;
        AppMethodBeat.i(225210);
        p.h(webView, "webview");
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        String uri = webResourceRequest.getUrl().toString();
        p.g(uri, "request.url.toString()");
        c.b bVar = c.JDf;
        if (!n.J(uri, c.JCV, false) || (gbi = getController().getJsapi().gbi()) == null) {
            AppMethodBeat.o(225210);
            return null;
        }
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        c cVar = gbi.JEJ;
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        c.w wVar = c.w.JEA;
        Uri url = webResourceRequest.getUrl();
        p.g(url, "url");
        String host = url.getHost();
        if (host == null) {
            str = "";
        } else {
            str = host;
        }
        p.g(str, "url.host ?: \"\"");
        Log.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(url)));
        cVar.JCS.a(b.IFRAME_INTERCEPT);
        c.l.a aVar = (c.l.a) cVar.giJ().get(str);
        if (aVar != null) {
            StringBuilder sb = new StringBuilder("['");
            c.w wVar2 = c.w.JEA;
            c.b bVar2 = c.JDf;
            f fVar = c.JCX;
            c.b bVar3 = c.JDf;
            String sb2 = sb.append(j.a(c.w.in((List) fVar.getValue()), "','", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62)).append("']").toString();
            Log.i(c.TAG, "buildMatrix " + sb2 + ", " + url);
            c.b bVar4 = c.JDf;
            f fVar2 = c.JCY;
            c.b bVar5 = c.JDf;
            String by = n.by((String) fVar2.getValue(), "$__IFRAME_MATRIX__$", sb2);
            String str2 = aVar.JEa.name;
            p.g(str2, "worker.webComptInfo.name");
            String by2 = n.by(by, "$__WEB_COMPT_NAME__$", str2);
            c.c(aVar.giZ(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + sb2 + ')');
            Log.i(c.TAG, "ready to response ".concat(String.valueOf(url)));
            Charset charset = d.UTF_8;
            if (by2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(225210);
                throw tVar;
            }
            byte[] bytes = by2.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "utf8", new ByteArrayInputStream(bytes));
            aVar.used = true;
            cVar.JCS.a(b.IFRAME_INTERCEPT_SUCC);
            AppMethodBeat.o(225210);
            return webResourceResponse;
        }
        cVar.JCS.a(b.IFRAME_INTERCEPT_ERR);
        String str3 = "webCompt: " + str + " not found";
        Charset charset2 = d.UTF_8;
        if (str3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(225210);
            throw tVar2;
        }
        byte[] bytes2 = str3.getBytes(charset2);
        p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
        WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/html", "utf8", new ByteArrayInputStream(bytes2));
        AppMethodBeat.o(225210);
        return webResourceResponse2;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean a(int i2, String str, bhj bhj) {
        byte[] a2;
        AppMethodBeat.i(225211);
        p.h(str, "reqUrl");
        p.h(bhj, "resp");
        SKBuiltinBuffer_t sKBuiltinBuffer_t = bhj.LRT;
        if (!(sKBuiltinBuffer_t == null || (a2 = z.a(sKBuiltinBuffer_t)) == null)) {
            try {
                fac fac = new fac();
                fac.parseFrom(a2);
                String str2 = bhj.LRH;
                p.g(str2, "resp.FullURL");
                f.g(str2, fac.MjS);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "parse WebComponentInfo", new Object[0]);
            }
        }
        AppMethodBeat.o(225211);
        return false;
    }
}
