package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* access modifiers changed from: package-private */
public class j extends X5ProxyWebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private WebView f2068a;

    /* renamed from: b  reason: collision with root package name */
    private WebChromeClient f2069b;

    public j(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.f2068a = webView;
        this.f2069b = webChromeClient;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(188042);
        this.f2069b.onExceededDatabaseQuota(str, str2, j2, j3, j4, new a(quotaUpdater));
        AppMethodBeat.o(188042);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.i(188043);
        Bitmap defaultVideoPoster = this.f2069b.getDefaultVideoPoster();
        AppMethodBeat.o(188043);
        return defaultVideoPoster;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(188044);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onCloseWindow(this.f2068a);
        AppMethodBeat.o(188044);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(String str, int i2, String str2) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(188045);
        boolean onConsoleMessage = this.f2069b.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(188045);
        return onConsoleMessage;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final Message message) {
        AppMethodBeat.i(188046);
        WebView webView = this.f2068a;
        webView.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() {
            /* class com.tencent.smtt.sdk.j.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(188388);
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView.c());
                }
                message.sendToTarget();
                AppMethodBeat.o(188388);
            }
        });
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.f2069b.onCreateWindow(this.f2068a, z, z2, obtain);
        AppMethodBeat.o(188046);
        return onCreateWindow;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(188047);
        this.f2069b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(188047);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.i(188048);
        this.f2069b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        AppMethodBeat.o(188048);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        AppMethodBeat.i(188049);
        this.f2069b.onHideCustomView();
        AppMethodBeat.o(188049);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(188050);
        this.f2068a.a(iX5WebViewBase);
        boolean onJsAlert = this.f2069b.onJsAlert(this.f2068a, str, str2, jsResult);
        AppMethodBeat.o(188050);
        return onJsAlert;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(188051);
        this.f2068a.a(iX5WebViewBase);
        boolean onJsConfirm = this.f2069b.onJsConfirm(this.f2068a, str, str2, jsResult);
        AppMethodBeat.o(188051);
        return onJsConfirm;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(188052);
        this.f2068a.a(iX5WebViewBase);
        boolean onJsPrompt = this.f2069b.onJsPrompt(this.f2068a, str, str2, str3, jsPromptResult);
        AppMethodBeat.o(188052);
        return onJsPrompt;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(188053);
        this.f2068a.a(iX5WebViewBase);
        boolean onJsBeforeUnload = this.f2069b.onJsBeforeUnload(this.f2068a, str, str2, jsResult);
        AppMethodBeat.o(188053);
        return onJsBeforeUnload;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        AppMethodBeat.i(188054);
        boolean onJsTimeout = this.f2069b.onJsTimeout();
        AppMethodBeat.o(188054);
        return onJsTimeout;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i2) {
        AppMethodBeat.i(188055);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onProgressChanged(this.f2068a, i2);
        AppMethodBeat.o(188055);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j2, long j3, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(188056);
        this.f2069b.onReachedMaxAppCacheSize(j2, j3, new a(quotaUpdater));
        AppMethodBeat.o(188056);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        AppMethodBeat.i(188057);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onReceivedIcon(this.f2068a, bitmap);
        AppMethodBeat.o(188057);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(188058);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onReceivedTouchIconUrl(this.f2068a, str, z);
        AppMethodBeat.o(188058);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(188059);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onReceivedTitle(this.f2068a, str);
        AppMethodBeat.o(188059);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(188060);
        this.f2068a.a(iX5WebViewBase);
        this.f2069b.onRequestFocus(this.f2068a);
        AppMethodBeat.o(188060);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(188061);
        this.f2069b.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(188061);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, int i2, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(188062);
        this.f2069b.onShowCustomView(view, i2, customViewCallback);
        AppMethodBeat.o(188062);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(final ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        AppMethodBeat.i(188063);
        this.f2069b.openFileChooser(new ValueCallback<Uri>() {
            /* class com.tencent.smtt.sdk.j.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
            public /* synthetic */ void onReceiveValue(Uri uri) {
                AppMethodBeat.i(188184);
                a(uri);
                AppMethodBeat.o(188184);
            }

            public void a(Uri uri) {
                AppMethodBeat.i(188183);
                valueCallback.onReceiveValue(new Uri[]{uri});
                AppMethodBeat.o(188183);
            }
        }, str, str2);
        AppMethodBeat.o(188063);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final ValueCallback<Uri[]> valueCallback, final IX5WebChromeClient.FileChooserParams fileChooserParams) {
        AppMethodBeat.i(188064);
        AnonymousClass3 r0 = new ValueCallback<Uri[]>() {
            /* class com.tencent.smtt.sdk.j.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
            public /* synthetic */ void onReceiveValue(Uri[] uriArr) {
                AppMethodBeat.i(188304);
                a(uriArr);
                AppMethodBeat.o(188304);
            }

            public void a(Uri[] uriArr) {
                AppMethodBeat.i(188303);
                valueCallback.onReceiveValue(uriArr);
                AppMethodBeat.o(188303);
            }
        };
        AnonymousClass4 r1 = new WebChromeClient.FileChooserParams() {
            /* class com.tencent.smtt.sdk.j.AnonymousClass4 */

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                AppMethodBeat.i(188177);
                int mode = fileChooserParams.getMode();
                AppMethodBeat.o(188177);
                return mode;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                AppMethodBeat.i(188178);
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                AppMethodBeat.o(188178);
                return acceptTypes;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                AppMethodBeat.i(188179);
                boolean isCaptureEnabled = fileChooserParams.isCaptureEnabled();
                AppMethodBeat.o(188179);
                return isCaptureEnabled;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                AppMethodBeat.i(188180);
                CharSequence title = fileChooserParams.getTitle();
                AppMethodBeat.o(188180);
                return title;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                AppMethodBeat.i(188181);
                String filenameHint = fileChooserParams.getFilenameHint();
                AppMethodBeat.o(188181);
                return filenameHint;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                AppMethodBeat.i(188182);
                Intent createIntent = fileChooserParams.createIntent();
                AppMethodBeat.o(188182);
                return createIntent;
            }
        };
        this.f2068a.a(iX5WebViewBase);
        boolean onShowFileChooser = this.f2069b.onShowFileChooser(this.f2068a, r0, r1);
        AppMethodBeat.o(188064);
        return onShowFileChooser;
    }

    class a implements WebStorage.QuotaUpdater {

        /* renamed from: a  reason: collision with root package name */
        QuotaUpdater f2079a;

        a(QuotaUpdater quotaUpdater) {
            this.f2079a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j2) {
            AppMethodBeat.i(188069);
            this.f2079a.updateQuota(j2);
            AppMethodBeat.o(188069);
        }
    }
}
