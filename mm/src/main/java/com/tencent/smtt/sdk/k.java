package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;

/* access modifiers changed from: package-private */
public class k extends X5ProxyWebViewClient {

    /* renamed from: c  reason: collision with root package name */
    private static String f2081c = null;
    private byte _hellAccFlag_;

    /* renamed from: a  reason: collision with root package name */
    private WebViewClient f2082a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f2083b;

    public k(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f2083b = webView;
        this.f2082a = webViewClient;
        this.f2082a.f1939a = this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(188151);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.doUpdateVisitedHistory(this.f2083b, str, z);
        AppMethodBeat.o(188151);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.i(188152);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onFormResubmission(this.f2083b, message, message2);
        AppMethodBeat.o(188152);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188153);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onLoadResource(this.f2083b, str);
        AppMethodBeat.o(188153);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i2, int i3, String str) {
        o a2;
        AppMethodBeat.i(188154);
        TbsLog.v("TbsPerfTest", "PageLoadFinished!");
        if (f2081c == null && (a2 = o.a()) != null) {
            a2.a(false);
            f2081c = Boolean.toString(false);
        }
        this.f2083b.a(iX5WebViewBase);
        this.f2083b.f1914a++;
        this.f2082a.onPageFinished(this.f2083b, str);
        TbsLog.d("sdkreport", "SmttWebViewclient.onPageFinished--Pv=" + this.f2083b.f1914a);
        if (TbsConfig.APP_QZONE.equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.f2083b.a(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i2, i3, str);
        } catch (Exception e2) {
        }
        WebView.d();
        if (!TbsShareManager.mHasQueryed && this.f2083b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f2083b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() {
                /* class com.tencent.smtt.sdk.k.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(188306);
                    if (!TbsShareManager.forceLoadX5FromTBSDemo(k.this.f2083b.getContext()) && TbsDownloader.needDownload(k.this.f2083b.getContext(), false)) {
                        TbsDownloader.startDownload(k.this.f2083b.getContext());
                    }
                    AppMethodBeat.o(188306);
                }
            }).start();
        }
        if (this.f2083b.getContext() != null && !TbsLogReport.getInstance(this.f2083b.getContext()).getShouldUploadEventReport()) {
            TbsLogReport.getInstance(this.f2083b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.f2083b.getContext()).dailyReport();
        }
        AppMethodBeat.o(188154);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i2, int i3, String str, Bitmap bitmap) {
        AppMethodBeat.i(188155);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onPageStarted(this.f2083b, str, bitmap);
        AppMethodBeat.o(188155);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AppMethodBeat.i(188156);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedError(this.f2083b, webResourceRequest, webResourceError);
        AppMethodBeat.o(188156);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i2, String str, String str2) {
        AppMethodBeat.i(188157);
        if (i2 < -15) {
            if (i2 == -17) {
                i2 = -1;
            } else {
                AppMethodBeat.o(188157);
                return;
            }
        }
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedError(this.f2083b, i2, str, str2);
        AppMethodBeat.o(188157);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(188158);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedHttpError(this.f2083b, webResourceRequest, webResourceResponse);
        AppMethodBeat.o(188158);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.i(188159);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedHttpAuthRequest(this.f2083b, httpAuthHandler, str, str2);
        AppMethodBeat.o(188159);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        AppMethodBeat.i(188160);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedSslError(this.f2083b, sslErrorHandler, sslError);
        AppMethodBeat.o(188160);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(188161);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedClientCertRequest(this.f2083b, clientCertRequest);
        AppMethodBeat.o(188161);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f2, float f3) {
        AppMethodBeat.i(188162);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onScaleChanged(this.f2083b, f2, f3);
        AppMethodBeat.o(188162);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.i(188163);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onUnhandledKeyEvent(this.f2083b, keyEvent);
        AppMethodBeat.o(188163);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.i(188164);
        this.f2083b.a(iX5WebViewBase);
        boolean shouldOverrideKeyEvent = this.f2082a.shouldOverrideKeyEvent(this.f2083b, keyEvent);
        AppMethodBeat.o(188164);
        return shouldOverrideKeyEvent;
    }

    public void a(String str) {
        AppMethodBeat.i(55321);
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.f2083b.getContext() != null) {
                Context context = this.f2083b.getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(55321);
        } catch (Exception e2) {
            AppMethodBeat.o(55321);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188165);
        if (str == null || this.f2083b.showDebugView(str)) {
            AppMethodBeat.o(188165);
            return true;
        }
        this.f2083b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f2082a.shouldOverrideUrlLoading(this.f2083b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(WebView.SCHEME_TEL + str.substring(13)));
                Context context = this.f2083b.getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(188165);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                a(str);
                AppMethodBeat.o(188165);
                return true;
            }
        }
        AppMethodBeat.o(188165);
        return shouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.i(188166);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onTooManyRedirects(this.f2083b, message, message2);
        AppMethodBeat.o(188166);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String str;
        AppMethodBeat.i(188167);
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            str = null;
        } else {
            str = webResourceRequest.getUrl().toString();
        }
        if (str == null || this.f2083b.showDebugView(str)) {
            AppMethodBeat.o(188167);
            return true;
        }
        this.f2083b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f2082a.shouldOverrideUrlLoading(this.f2083b, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(WebView.SCHEME_TEL + str.substring(13)));
                Context context = this.f2083b.getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(188167);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                a(str);
                AppMethodBeat.o(188167);
                return true;
            }
        }
        AppMethodBeat.o(188167);
        return shouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188168);
        this.f2083b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f2082a.shouldInterceptRequest(this.f2083b, str);
        AppMethodBeat.o(188168);
        return shouldInterceptRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(188169);
        this.f2083b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f2082a.shouldInterceptRequest(this.f2083b, webResourceRequest);
        AppMethodBeat.o(188169);
        return shouldInterceptRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(188170);
        this.f2083b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f2082a.shouldInterceptRequest(this.f2083b, webResourceRequest, bundle);
        AppMethodBeat.o(188170);
        return shouldInterceptRequest;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        AppMethodBeat.i(188171);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onReceivedLoginRequest(this.f2083b, str, str2, str3);
        AppMethodBeat.o(188171);
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(188172);
        super.onPageStarted(this.f2083b.c(), 0, 0, str, bitmap);
        AppMethodBeat.o(188172);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i2) {
        AppMethodBeat.i(188173);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onDetectedBlankScreen(str, i2);
        AppMethodBeat.o(188173);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188174);
        onPageFinished(iX5WebViewBase, 0, 0, str);
        AppMethodBeat.o(188174);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        AppMethodBeat.i(188175);
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
        AppMethodBeat.o(188175);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void countPVContentCacheCallBack(String str) {
        this.f2083b.f1914a++;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient, com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void onPageCommitVisible(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188176);
        this.f2083b.a(iX5WebViewBase);
        this.f2082a.onPageCommitVisible(this.f2083b, str);
        AppMethodBeat.o(188176);
    }
}
