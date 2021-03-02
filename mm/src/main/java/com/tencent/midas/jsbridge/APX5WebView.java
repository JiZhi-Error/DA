package com.tencent.midas.jsbridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.lang.reflect.Method;

public class APX5WebView {
    private static final String TAG = "APX5WebView";
    private IAPX5WebViewCallback callback = null;
    private WebChromeClient mChromeClient = new WebChromeClient() {
        /* class com.tencent.midas.jsbridge.APX5WebView.AnonymousClass1 */

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(192809);
            APLog.e("inner onJsAlert message", str2);
            APLog.e(APX5WebView.TAG, " url = ".concat(String.valueOf(str)));
            APLog.e(APX5WebView.TAG, " message = ".concat(String.valueOf(str2)));
            if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APX5WebView.this.mContext, str2)) {
                APLog.d(APX5WebView.TAG, "onJsAlert is pure h5 update! Cancel alert!");
                jsResult.cancel();
                AppMethodBeat.o(192809);
                return true;
            }
            APLog.d(APX5WebView.TAG, "onJsAlert not pure h5 update!");
            if (APWebProtocol.hookH5Method(APX5WebView.this.mContext, APX5WebView.this.mWebview, str, str2, jsResult, APX5WebView.this.callback)) {
                APLog.d(APX5WebView.TAG, "hookH5Method is processed");
                jsResult.cancel();
                AppMethodBeat.o(192809);
                return true;
            } else if (APMidasPayAPI.h5PayHookX5(APX5WebView.this.mContext, APX5WebView.this.mWebview, str, str2, jsResult) == 0) {
                APX5WebView.this.callback.WebChromeClientJsAlert(webView, str, str2, jsResult);
                jsResult.cancel();
                AppMethodBeat.o(192809);
                return true;
            } else {
                boolean onJsAlert = super.onJsAlert(webView, str, str2, jsResult);
                AppMethodBeat.o(192809);
                return onJsAlert;
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.i(192810);
            boolean WebChromeClientJsPrompt = APX5WebView.this.callback.WebChromeClientJsPrompt(webView, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(192810);
            return WebChromeClientJsPrompt;
        }
    };
    private Activity mContext = null;
    private WebViewClient mWebViewClient = new WebViewClient() {
        /* class com.tencent.midas.jsbridge.APX5WebView.AnonymousClass2 */
        private byte _hellAccFlag_;

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AppMethodBeat.i(192805);
            APLog.d(APX5WebView.TAG, "shouldOverrideUrlLoading url = ".concat(String.valueOf(str)));
            if (!str.startsWith("http://unipay.sdk.android/?") && !str.startsWith("wsj://") && !str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                webView.loadUrl(str);
                APLog.d(APX5WebView.TAG, "shouldOverrideUrlLoading loadUrl = ");
            }
            if (str.startsWith("mqqapi://") || str.startsWith("weixin://") || str.startsWith("sms://")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (intent.resolveActivity(APX5WebView.this.mContext.getPackageManager()) != null) {
                    Context context = webView.getContext();
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/midas/jsbridge/APX5WebView$2", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/midas/jsbridge/APX5WebView$2", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(192805);
                    return true;
                }
                Toast.makeText(APX5WebView.this.mContext, "抱歉，你未安装相应客户端", 1).show();
                APLog.w(APX5WebView.TAG, "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
                AppMethodBeat.o(192805);
                return false;
            }
            AppMethodBeat.o(192805);
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AppMethodBeat.i(192806);
            super.onPageFinished(webView, str);
            APLog.d(APX5WebView.TAG, "onPageFinished!");
            APLog.i("APWebView url == ", str);
            APX5WebView.this.mWebview.setVisibility(0);
            APMidasPayAPI.InnerH5PayInitX5(APX5WebView.this.mContext, APX5WebView.this.mWebview);
            APX5WebView.this.callback.WebViewClientPageFinished(webView, str);
            AppMethodBeat.o(192806);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(192807);
            super.onPageStarted(webView, str, bitmap);
            APLog.d(APX5WebView.TAG, "onPageStarted!");
            APX5WebView.this.callback.WebViewClientPageStarted(webView, str, bitmap);
            AppMethodBeat.o(192807);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(192808);
            super.onReceivedError(webView, i2, str, str2);
            APLog.d(APX5WebView.TAG, "onReceivedError!");
            APX5WebView.this.callback.WebViewClientReceivedError(webView, i2, str, str2);
            AppMethodBeat.o(192808);
        }
    };
    private WebView mWebview = null;

    public APX5WebView(Activity activity, WebView webView, IAPX5WebViewCallback iAPX5WebViewCallback) {
        AppMethodBeat.i(192830);
        this.mContext = activity;
        this.mWebview = webView;
        this.callback = iAPX5WebViewCallback;
        InitWebView();
        AppMethodBeat.o(192830);
    }

    @SuppressLint({"NewApi"})
    private void InitWebView() {
        AppMethodBeat.i(192831);
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
        AppMethodBeat.o(192831);
    }

    private void removeInterface() {
        AppMethodBeat.i(192832);
        try {
            Method method = this.mWebview.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this.mWebview, "searchBoxJavaBridge_");
                method.invoke(this.mWebview, "accessibility");
                method.invoke(this.mWebview, "accessibilityTraversal");
            }
            AppMethodBeat.o(192832);
        } catch (Exception e2) {
            APLog.i("removeJavascriptInterface", e2.toString());
            AppMethodBeat.o(192832);
        }
    }

    public WebView getWebView() {
        return this.mWebview;
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(192833);
        this.mWebview.loadUrl(str);
        AppMethodBeat.o(192833);
    }
}
