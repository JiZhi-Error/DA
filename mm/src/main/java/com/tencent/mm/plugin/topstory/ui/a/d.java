package com.tencent.mm.plugin.topstory.ui.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.ag;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class d extends ac {
    private c Gqx;
    private eii eel;

    public d(eii eii, c cVar) {
        this.eel = eii;
        this.Gqx = cVar;
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(126574);
        c.c(this.eel, "pageStart", System.currentTimeMillis());
        Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str, bitmap);
        AppMethodBeat.o(126574);
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(126575);
        Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str);
        c.c(this.eel, "pageFinish", System.currentTimeMillis());
        AppMethodBeat.o(126575);
    }

    @Override // com.tencent.xweb.ac
    public final boolean a(WebView webView, String str) {
        AppMethodBeat.i(126576);
        Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", str);
        boolean a2 = super.a(webView, str);
        AppMethodBeat.o(126576);
        return a2;
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(236404);
        WebResourceResponse j2 = j(webView, webResourceRequest.getUrl().toString());
        if (j2 != null) {
            AppMethodBeat.o(236404);
            return j2;
        }
        WebResourceResponse a2 = super.a(webView, webResourceRequest);
        AppMethodBeat.o(236404);
        return a2;
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(236405);
        WebResourceResponse j2 = j(webView, webResourceRequest.getUrl().toString());
        if (j2 != null) {
            AppMethodBeat.o(236405);
            return j2;
        }
        WebResourceResponse a2 = super.a(webView, webResourceRequest, bundle);
        AppMethodBeat.o(236405);
        return a2;
    }

    private static WebResourceResponse j(WebView webView, String str) {
        AppMethodBeat.i(236406);
        if (!((b) g.ah(b.class)).openJsAccelerate()) {
            AppMethodBeat.o(236406);
            return null;
        } else if (!webView.supportFeature(2002)) {
            AppMethodBeat.o(236406);
            return null;
        } else {
            at afr = ai.afr(1);
            if (str.startsWith("file://" + afr.fYw())) {
                String fYx = afr.fYx();
                if (!Util.isNullOrNil(fYx)) {
                    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "hit js xweb script %s", fYx);
                    ag agVar = new ag(2, 0, webView);
                    agVar.cacheKey = afr.fYw() + "." + fYx;
                    agVar.oc(afr.fYw(), "path");
                    WebResourceResponse webResourceResponse = new WebResourceResponse(null, MimeTypeUtil.ContentType.DEFAULT_CHARSET, new ByteArrayInputStream(agVar.toString().getBytes(StandardCharsets.UTF_8)));
                    AppMethodBeat.o(236406);
                    return webResourceResponse;
                }
                AppMethodBeat.o(236406);
                return null;
            }
            AppMethodBeat.o(236406);
            return null;
        }
    }
}
