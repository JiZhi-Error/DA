package com.tencent.midas.jsbridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import com.tencent.mm.hellhoundlib.b.a;
import java.lang.reflect.Method;

public class APWebView {
    private static final String TAG = "APWebView";
    private IAPWebViewCallback callback = null;
    private WebChromeClient mChromeClient = new WebChromeClient() {
        /* class com.tencent.midas.jsbridge.APWebView.AnonymousClass1 */

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(192812);
            APLog.e("inner onJsAlert message", str2);
            APLog.e(APWebView.TAG, " url = ".concat(String.valueOf(str)));
            APLog.e(APWebView.TAG, " message = ".concat(String.valueOf(str2)));
            if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APWebView.this.mContext, str2)) {
                APLog.d(APWebView.TAG, "onJsAlert is pure h5 update! Cancel alert!");
                jsResult.cancel();
                AppMethodBeat.o(192812);
                return true;
            }
            APLog.d(APWebView.TAG, "onJsAlert not pure h5 update!");
            if (APWebProtocol.hookH5Method(APWebView.this.mContext, APWebView.this.mWebview, str, str2, jsResult, APWebView.this.callback)) {
                APLog.d(APWebView.TAG, "hookH5Method is processed");
                jsResult.cancel();
                AppMethodBeat.o(192812);
                return true;
            } else if (APMidasPayAPI.h5PayHook(APWebView.this.mContext, APWebView.this.mWebview, str, str2, jsResult) == 0) {
                APWebView.this.callback.WebChromeClientJsAlert(webView, str, str2, jsResult);
                jsResult.cancel();
                AppMethodBeat.o(192812);
                return true;
            } else {
                boolean onJsAlert = super.onJsAlert(webView, str, str2, jsResult);
                AppMethodBeat.o(192812);
                return onJsAlert;
            }
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.i(192813);
            boolean WebChromeClientJsPrompt = APWebView.this.callback.WebChromeClientJsPrompt(webView, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(192813);
            return WebChromeClientJsPrompt;
        }
    };
    private Activity mContext = null;
    private WebViewClient mWebViewClient = new WebViewClient() {
        /* class com.tencent.midas.jsbridge.APWebView.AnonymousClass2 */
        private byte _hellAccFlag_;

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AppMethodBeat.i(192842);
            APLog.d(APWebView.TAG, "shouldOverrideUrlLoading url = ".concat(String.valueOf(str)));
            if (!str.startsWith("http://unipay.sdk.android/?") && !str.startsWith("wsj://") && !str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                webView.loadUrl(str);
                APLog.d(APWebView.TAG, "shouldOverrideUrlLoading loadUrl = ");
            }
            if (str.startsWith("mqqapi://") || str.startsWith("weixin://") || str.startsWith("sms://")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (intent.resolveActivity(APWebView.this.mContext.getPackageManager()) != null) {
                    Context context = webView.getContext();
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/midas/jsbridge/APWebView$2", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/midas/jsbridge/APWebView$2", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(192842);
                    return true;
                }
                Toast.makeText(APWebView.this.mContext, "抱歉，你未安装相应客户端", 1).show();
                APLog.w(APWebView.TAG, "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
                AppMethodBeat.o(192842);
                return false;
            }
            AppMethodBeat.o(192842);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            AppMethodBeat.i(192843);
            super.onPageFinished(webView, str);
            APLog.d(APWebView.TAG, "onPageFinished!");
            APLog.i("APWebView url == ", str);
            APWebView.this.mWebview.setVisibility(0);
            APMidasPayAPI.InnerH5PayInit(APWebView.this.mContext, APWebView.this.mWebview);
            APWebView.this.callback.WebViewClientPageFinished(webView, str);
            AppMethodBeat.o(192843);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(192844);
            super.onPageStarted(webView, str, bitmap);
            APLog.d(APWebView.TAG, "onPageStarted!");
            APWebView.this.callback.WebViewClientPageStarted(webView, str, bitmap);
            AppMethodBeat.o(192844);
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(192845);
            super.onReceivedError(webView, i2, str, str2);
            APLog.d(APWebView.TAG, "onReceivedError!");
            APWebView.this.callback.WebViewClientReceivedError(webView, i2, str, str2);
            AppMethodBeat.o(192845);
        }
    };
    private WebView mWebview = null;

    public APWebView(Activity activity, WebView webView, IAPWebViewCallback iAPWebViewCallback) {
        AppMethodBeat.i(192869);
        this.mContext = activity;
        this.mWebview = webView;
        this.callback = iAPWebViewCallback;
        InitWebView();
        AppMethodBeat.o(192869);
    }

    @SuppressLint({"NewApi"})
    private void InitWebView() {
        AppMethodBeat.i(192870);
        WebSettings settings = this.mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            APMidasPayAPI.env.equals(APMidasPayAPI.ENV_TEST);
        }
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(this.mContext.getApplicationContext().getDir("cache", 0).getPath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        this.mWebview.setScrollBarStyle(0);
        this.mWebview.setWebChromeClient(this.mChromeClient);
        this.mWebview.setWebViewClient(this.mWebViewClient);
        removeInterface();
        AppMethodBeat.o(192870);
    }

    private void removeInterface() {
        AppMethodBeat.i(192871);
        try {
            Method method = this.mWebview.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this.mWebview, "searchBoxJavaBridge_");
                method.invoke(this.mWebview, "accessibility");
                method.invoke(this.mWebview, "accessibilityTraversal");
            }
            AppMethodBeat.o(192871);
        } catch (Exception e2) {
            APLog.i("removeJavascriptInterface", e2.toString());
            AppMethodBeat.o(192871);
        }
    }

    public WebView getWebView() {
        return this.mWebview;
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(192872);
        this.mWebview.loadUrl(str);
        AppMethodBeat.o(192872);
    }
}
