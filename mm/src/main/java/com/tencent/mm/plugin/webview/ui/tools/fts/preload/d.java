package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.net.Uri;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.d.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u001d\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "getBiz", "()I", "proxy", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "getProxy", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;", "setProxy", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandlerProxy;)V", "scene", "getScene", "setScene", "(I)V", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getUrl", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "getWebView", "()Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "setWebView", "(Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;)V", "webViewReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWebViewReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWebViewReady", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-webview_release"})
public final class d {
    public WebSearchWebView Gqy;
    public i IFj;
    AtomicBoolean JpC = new AtomicBoolean(false);
    final int mrG;
    private int scene;
    private String sessionId = "";
    private final String url;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.url, r4.url) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 210532(0x33664, float:2.95018E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.webview.ui.tools.fts.preload.d
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.webview.ui.tools.fts.preload.d r4 = (com.tencent.mm.plugin.webview.ui.tools.fts.preload.d) r4
            int r0 = r3.mrG
            int r1 = r4.mrG
            if (r0 != r1) goto L_0x0023
            java.lang.String r0 = r3.url
            java.lang.String r1 = r4.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.preload.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(210531);
        int i2 = this.mrG * 31;
        String str = this.url;
        int hashCode = (str != null ? str.hashCode() : 0) + i2;
        AppMethodBeat.o(210531);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(210530);
        String str = "WebSearchPreloadObj(biz=" + this.mrG + ", url=" + this.url + ")";
        AppMethodBeat.o(210530);
        return str;
    }

    public d(int i2, String str) {
        d dVar;
        int i3 = 0;
        p.h(str, "url");
        AppMethodBeat.i(210529);
        this.mrG = i2;
        this.url = str;
        Uri parse = Uri.parse(this.url);
        try {
            String queryParameter = parse.getQueryParameter("scene");
            if (queryParameter != null) {
                i3 = Integer.parseInt(queryParameter);
                dVar = this;
            } else {
                dVar = this;
            }
            dVar.scene = i3;
        } catch (Exception e2) {
        }
        String queryParameter2 = parse.getQueryParameter("sessionId");
        if (queryParameter2 != null) {
            p.g(queryParameter2, LocaleUtil.ITALIAN);
            this.sessionId = queryParameter2;
            AppMethodBeat.o(210529);
            return;
        }
        AppMethodBeat.o(210529);
    }
}
