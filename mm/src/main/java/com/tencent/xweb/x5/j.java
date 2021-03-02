package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.o;

public final class j implements e {
    c SFp = new c();
    b SFq = new b();
    WebView SFr;

    public j(WebView webView) {
        AppMethodBeat.i(153868);
        this.SFr = webView;
        AppMethodBeat.o(153868);
    }

    @Override // com.tencent.xweb.internal.e
    public final void y(String str, Bitmap bitmap) {
        AppMethodBeat.i(153869);
        this.SFp.b(this.SFr, str, bitmap);
        AppMethodBeat.o(153869);
    }

    @Override // com.tencent.xweb.internal.e
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
    }

    @Override // com.tencent.xweb.internal.e
    public final void onHideCustomView() {
        AppMethodBeat.i(153870);
        this.SFq.huJ();
        AppMethodBeat.o(153870);
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean a(String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean b(String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean a(String str, String str2, String str3, o oVar) {
        return false;
    }
}
