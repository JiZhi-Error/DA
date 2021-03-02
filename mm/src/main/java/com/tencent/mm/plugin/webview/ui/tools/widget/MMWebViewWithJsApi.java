package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ac;

public class MMWebViewWithJsApi extends MMWebView {
    private k Jza;
    private boolean Jzb;

    static /* synthetic */ void bQ(Context context) {
        AppMethodBeat.i(82244);
        kI(context);
        AppMethodBeat.o(82244);
    }

    public static class a {
        public static MMWebViewWithJsApi hY(Context context) {
            AppMethodBeat.i(259802);
            MMWebViewWithJsApi hZ = hZ(context);
            AppMethodBeat.o(259802);
            return hZ;
        }

        public static MMWebViewWithJsApi hZ(Context context) {
            AppMethodBeat.i(82237);
            MMWebViewWithJsApi.bQ(context);
            MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(context);
            mMWebViewWithJsApi.gKM = true;
            AppMethodBeat.o(82237);
            return mMWebViewWithJsApi;
        }
    }

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(82238);
        this.Jzb = true;
        gYV();
        getSettings().setJavaScriptEnabled(true);
        getSettings().hsW();
        setWebChromeClient(new i(this));
        setWebViewClient(new k(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!z.bfF(userAgentString)) {
            getSettings().setUserAgentString(z.cr(getContext(), userAgentString));
        }
        AppMethodBeat.o(82238);
    }

    public h getJsapi() {
        if (this.Jza != null) {
            return this.Jza.JpW;
        }
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void setWebViewClient(ac acVar) {
        AppMethodBeat.i(82239);
        super.setWebViewClient(acVar);
        if (acVar instanceof k) {
            this.Jza = (k) acVar;
            AppMethodBeat.o(82239);
            return;
        }
        this.Jza = null;
        AppMethodBeat.o(82239);
    }

    @Override // com.tencent.mm.ui.widget.MMWebView
    public void setCleanOnDetached(boolean z) {
        this.Jzb = z;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(82240);
        super.onDetachedFromWindow();
        if (this.Jza != null && this.Jzb) {
            this.Jza.cleanup();
        }
        AppMethodBeat.o(82240);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(82241);
        if (this.Jza != null) {
            this.Jza.zv(true);
            this.Jza.baG("");
        }
        super.loadData(str, str2, str3);
        AppMethodBeat.o(82241);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(82242);
        if (this.Jza != null) {
            this.Jza.zv(true);
            this.Jza.baG("");
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(82242);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if (r3.Jza.baG(r4) == false) goto L_0x0018;
     */
    @Override // com.tencent.mm.ui.widget.MMWebView, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUrl(java.lang.String r4) {
        /*
            r3 = this;
            r2 = 82243(0x14143, float:1.15247E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.plugin.webview.ui.tools.widget.k r0 = r3.Jza
            if (r0 == 0) goto L_0x0018
            com.tencent.mm.plugin.webview.ui.tools.widget.k r0 = r3.Jza
            r1 = 0
            r0.zv(r1)
            com.tencent.mm.plugin.webview.ui.tools.widget.k r0 = r3.Jza
            boolean r0 = r0.baG(r4)
            if (r0 != 0) goto L_0x001b
        L_0x0018:
            super.loadUrl(r4)
        L_0x001b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.loadUrl(java.lang.String):void");
    }
}
