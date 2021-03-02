package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.o;

public final class d implements e {
    WebViewClient SEe = new WebViewClient();
    WebView SEf;
    WebChromeClient mChromeClient = new WebChromeClient();

    public d(WebView webView) {
        AppMethodBeat.i(153668);
        this.SEf = webView;
        AppMethodBeat.o(153668);
    }

    @Override // com.tencent.xweb.internal.e
    public final void y(String str, Bitmap bitmap) {
        AppMethodBeat.i(153669);
        this.SEe.onPageStarted(this.SEf, str, bitmap);
        AppMethodBeat.o(153669);
    }

    @Override // com.tencent.xweb.internal.e
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
    }

    @Override // com.tencent.xweb.internal.e
    public final void onHideCustomView() {
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
