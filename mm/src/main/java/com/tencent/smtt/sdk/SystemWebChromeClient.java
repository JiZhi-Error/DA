package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* access modifiers changed from: package-private */
public class SystemWebChromeClient extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private WebView f1727a;

    /* renamed from: b  reason: collision with root package name */
    private WebChromeClient f1728b;

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f1727a = webView;
        this.f1728b = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.i(54842);
        Bitmap defaultVideoPoster = this.f1728b.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    defaultVideoPoster = BitmapFactory.decodeResource(this.f1727a.getResources(), 17301540);
                    AppMethodBeat.o(54842);
                    return defaultVideoPoster;
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(54842);
        return defaultVideoPoster;
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(54843);
        View videoLoadingProgressView = this.f1728b.getVideoLoadingProgressView();
        AppMethodBeat.o(54843);
        return videoLoadingProgressView;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final ValueCallback<String[]> valueCallback) {
        AppMethodBeat.i(54844);
        this.f1728b.getVisitedHistory(new ValueCallback<String[]>() {
            /* class com.tencent.smtt.sdk.SystemWebChromeClient.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
            public /* synthetic */ void onReceiveValue(String[] strArr) {
                AppMethodBeat.i(54567);
                a(strArr);
                AppMethodBeat.o(54567);
            }

            public void a(String[] strArr) {
                AppMethodBeat.i(54566);
                valueCallback.onReceiveValue(strArr);
                AppMethodBeat.o(54566);
            }
        });
        AppMethodBeat.o(54844);
    }

    public void onCloseWindow(WebView webView) {
        AppMethodBeat.i(54845);
        this.f1727a.a(webView);
        this.f1728b.onCloseWindow(this.f1727a);
        AppMethodBeat.o(54845);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(54846);
        boolean onConsoleMessage = this.f1728b.onConsoleMessage(new a(consoleMessage));
        AppMethodBeat.o(54846);
        return onConsoleMessage;
    }

    public void onConsoleMessage(String str, int i2, String str2) {
        AppMethodBeat.i(54847);
        this.f1728b.onConsoleMessage(new a(str, str2, i2));
        AppMethodBeat.o(54847);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, final Message message) {
        AppMethodBeat.i(54848);
        WebView webView2 = this.f1727a;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() {
            /* class com.tencent.smtt.sdk.SystemWebChromeClient.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(54353);
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(webView.b());
                }
                message.sendToTarget();
                AppMethodBeat.o(54353);
            }
        });
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.f1728b.onCreateWindow(this.f1727a, z, z2, obtain);
        AppMethodBeat.o(54848);
        return onCreateWindow;
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(54849);
        this.f1728b.onExceededDatabaseQuota(str, str2, j2, j3, j4, new f(quotaUpdater));
        AppMethodBeat.o(54849);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(54850);
        this.f1728b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(54850);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        AppMethodBeat.i(54851);
        this.f1728b.onGeolocationPermissionsShowPrompt(str, new c(callback));
        AppMethodBeat.o(54851);
    }

    @TargetApi(7)
    public void onHideCustomView() {
        AppMethodBeat.i(54852);
        this.f1728b.onHideCustomView();
        AppMethodBeat.o(54852);
    }

    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(54853);
        this.f1727a.a(webView);
        boolean onJsAlert = this.f1728b.onJsAlert(this.f1727a, str, str2, new e(jsResult));
        AppMethodBeat.o(54853);
        return onJsAlert;
    }

    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(54854);
        this.f1727a.a(webView);
        boolean onJsBeforeUnload = this.f1728b.onJsBeforeUnload(this.f1727a, str, str2, new e(jsResult));
        AppMethodBeat.o(54854);
        return onJsBeforeUnload;
    }

    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(54855);
        this.f1727a.a(webView);
        boolean onJsConfirm = this.f1728b.onJsConfirm(this.f1727a, str, str2, new e(jsResult));
        AppMethodBeat.o(54855);
        return onJsConfirm;
    }

    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(54856);
        this.f1727a.a(webView);
        boolean onJsPrompt = this.f1728b.onJsPrompt(this.f1727a, str, str2, str3, new d(jsPromptResult));
        AppMethodBeat.o(54856);
        return onJsPrompt;
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        AppMethodBeat.i(54857);
        boolean onJsTimeout = this.f1728b.onJsTimeout();
        AppMethodBeat.o(54857);
        return onJsTimeout;
    }

    public void onProgressChanged(android.webkit.WebView webView, int i2) {
        AppMethodBeat.i(54858);
        this.f1727a.a(webView);
        this.f1728b.onProgressChanged(this.f1727a, i2);
        AppMethodBeat.o(54858);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(54859);
        this.f1728b.onReachedMaxAppCacheSize(j2, j3, new f(quotaUpdater));
        AppMethodBeat.o(54859);
    }

    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        AppMethodBeat.i(54860);
        this.f1727a.a(webView);
        this.f1728b.onReceivedIcon(this.f1727a, bitmap);
        AppMethodBeat.o(54860);
    }

    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        AppMethodBeat.i(54861);
        this.f1727a.a(webView);
        this.f1728b.onReceivedTitle(this.f1727a, str);
        AppMethodBeat.o(54861);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        AppMethodBeat.i(54862);
        this.f1727a.a(webView);
        this.f1728b.onReceivedTouchIconUrl(this.f1727a, str, z);
        AppMethodBeat.o(54862);
    }

    public void onRequestFocus(android.webkit.WebView webView) {
        AppMethodBeat.i(54863);
        this.f1727a.a(webView);
        this.f1728b.onRequestFocus(this.f1727a);
        AppMethodBeat.o(54863);
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(54864);
        this.f1728b.onShowCustomView(view, new b(customViewCallback));
        AppMethodBeat.o(54864);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(54865);
        this.f1728b.onShowCustomView(view, i2, new b(customViewCallback));
        AppMethodBeat.o(54865);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.i(54866);
        openFileChooser(valueCallback, null, null);
        AppMethodBeat.o(54866);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.i(54867);
        openFileChooser(valueCallback, str, null);
        AppMethodBeat.o(54867);
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(54868);
        this.f1728b.openFileChooser(new ValueCallback<Uri>() {
            /* class com.tencent.smtt.sdk.SystemWebChromeClient.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
            public /* synthetic */ void onReceiveValue(Uri uri) {
                AppMethodBeat.i(54334);
                a(uri);
                AppMethodBeat.o(54334);
            }

            public void a(Uri uri) {
                AppMethodBeat.i(54333);
                valueCallback.onReceiveValue(uri);
                AppMethodBeat.o(54333);
            }
        }, str, str2);
        AppMethodBeat.o(54868);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        AppMethodBeat.i(54869);
        AnonymousClass4 r0 = new ValueCallback<Uri[]>() {
            /* class com.tencent.smtt.sdk.SystemWebChromeClient.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
            public /* synthetic */ void onReceiveValue(Uri[] uriArr) {
                AppMethodBeat.i(54941);
                a(uriArr);
                AppMethodBeat.o(54941);
            }

            public void a(Uri[] uriArr) {
                AppMethodBeat.i(54940);
                valueCallback.onReceiveValue(uriArr);
                AppMethodBeat.o(54940);
            }
        };
        AnonymousClass5 r1 = new WebChromeClient.FileChooserParams() {
            /* class com.tencent.smtt.sdk.SystemWebChromeClient.AnonymousClass5 */

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                AppMethodBeat.i(54057);
                int mode = fileChooserParams.getMode();
                AppMethodBeat.o(54057);
                return mode;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                AppMethodBeat.i(54058);
                String[] acceptTypes = fileChooserParams.getAcceptTypes();
                AppMethodBeat.o(54058);
                return acceptTypes;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                AppMethodBeat.i(54059);
                boolean isCaptureEnabled = fileChooserParams.isCaptureEnabled();
                AppMethodBeat.o(54059);
                return isCaptureEnabled;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                AppMethodBeat.i(54060);
                CharSequence title = fileChooserParams.getTitle();
                AppMethodBeat.o(54060);
                return title;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                AppMethodBeat.i(54061);
                String filenameHint = fileChooserParams.getFilenameHint();
                AppMethodBeat.o(54061);
                return filenameHint;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                AppMethodBeat.i(54062);
                Intent createIntent = fileChooserParams.createIntent();
                AppMethodBeat.o(54062);
                return createIntent;
            }
        };
        this.f1727a.a(webView);
        boolean onShowFileChooser = this.f1728b.onShowFileChooser(this.f1727a, r0, r1);
        AppMethodBeat.o(54869);
        return onShowFileChooser;
    }

    public void setupAutoFill(Message message) {
    }

    class e implements com.tencent.smtt.export.external.interfaces.JsResult {

        /* renamed from: a  reason: collision with root package name */
        JsResult f1750a;

        e(JsResult jsResult) {
            this.f1750a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            AppMethodBeat.i(54319);
            this.f1750a.cancel();
            AppMethodBeat.o(54319);
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            AppMethodBeat.i(54320);
            this.f1750a.confirm();
            AppMethodBeat.o(54320);
        }
    }

    class d implements com.tencent.smtt.export.external.interfaces.JsPromptResult {

        /* renamed from: a  reason: collision with root package name */
        JsPromptResult f1748a;

        d(JsPromptResult jsPromptResult) {
            this.f1748a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            AppMethodBeat.i(54065);
            this.f1748a.cancel();
            AppMethodBeat.o(54065);
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            AppMethodBeat.i(54066);
            this.f1748a.confirm();
            AppMethodBeat.o(54066);
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            AppMethodBeat.i(54067);
            this.f1748a.confirm(str);
            AppMethodBeat.o(54067);
        }
    }

    static class a implements com.tencent.smtt.export.external.interfaces.ConsoleMessage {

        /* renamed from: a  reason: collision with root package name */
        private ConsoleMessage.MessageLevel f1740a;

        /* renamed from: b  reason: collision with root package name */
        private String f1741b;

        /* renamed from: c  reason: collision with root package name */
        private String f1742c;

        /* renamed from: d  reason: collision with root package name */
        private int f1743d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            AppMethodBeat.i(54870);
            this.f1740a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f1741b = consoleMessage.message();
            this.f1742c = consoleMessage.sourceId();
            this.f1743d = consoleMessage.lineNumber();
            AppMethodBeat.o(54870);
        }

        a(String str, String str2, int i2) {
            this.f1740a = ConsoleMessage.MessageLevel.LOG;
            this.f1741b = str;
            this.f1742c = str2;
            this.f1743d = i2;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.f1740a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.f1741b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.f1742c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.f1743d;
        }
    }

    class f implements WebStorage.QuotaUpdater {

        /* renamed from: a  reason: collision with root package name */
        WebStorage.QuotaUpdater f1752a;

        f(WebStorage.QuotaUpdater quotaUpdater) {
            this.f1752a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j2) {
            AppMethodBeat.i(54871);
            this.f1752a.updateQuota(j2);
            AppMethodBeat.o(54871);
        }
    }

    class b implements IX5WebChromeClient.CustomViewCallback {

        /* renamed from: a  reason: collision with root package name */
        WebChromeClient.CustomViewCallback f1744a;

        b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.f1744a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            AppMethodBeat.i(55132);
            this.f1744a.onCustomViewHidden();
            AppMethodBeat.o(55132);
        }
    }

    class c implements GeolocationPermissionsCallback {

        /* renamed from: a  reason: collision with root package name */
        GeolocationPermissions.Callback f1746a;

        c(GeolocationPermissions.Callback callback) {
            this.f1746a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(54335);
            this.f1746a.invoke(str, z, z2);
            AppMethodBeat.o(54335);
        }
    }
}
