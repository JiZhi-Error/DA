package com.tencent.wework.api.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.a;

public class H5Activity extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(199028);
        super.onCreate(bundle);
        if (getIntent() == null || !getIntent().hasExtra("url")) {
            finish();
            AppMethodBeat.o(199028);
            return;
        }
        setContentView(R.layout.ccn);
        findViewById(R.id.xo).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.wework.api.view.H5Activity.AnonymousClass1 */

            public void onClick(View view) {
                AppMethodBeat.i(199018);
                H5Activity.this.finish();
                AppMethodBeat.o(199018);
            }
        });
        WebView webView = (WebView) findViewById(R.id.jki);
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setSupportMultipleWindows(false);
        webView.setDownloadListener(new DownloadListener() {
            /* class com.tencent.wework.api.view.H5Activity.AnonymousClass2 */

            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                AppMethodBeat.i(199019);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    H5Activity h5Activity = H5Activity.this;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(h5Activity, bl.axQ(), "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h5Activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(h5Activity, "com/tencent/wework/api/view/H5Activity$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(199019);
                } catch (Throwable th) {
                    AppMethodBeat.o(199019);
                }
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            /* class com.tencent.wework.api.view.H5Activity.AnonymousClass3 */

            public void onProgressChanged(WebView webView, int i2) {
                AppMethodBeat.i(199020);
                super.onProgressChanged(webView, i2);
                AppMethodBeat.o(199020);
            }

            public void onReceivedTitle(WebView webView, String str) {
                AppMethodBeat.i(199021);
                super.onReceivedTitle(webView, str);
                ((TextView) H5Activity.this.findViewById(R.id.ipm)).setText(str);
                AppMethodBeat.o(199021);
            }

            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                AppMethodBeat.i(199022);
                super.onReceivedIcon(webView, bitmap);
                AppMethodBeat.o(199022);
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                AppMethodBeat.i(199023);
                boolean onJsPrompt = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                AppMethodBeat.o(199023);
                return onJsPrompt;
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            /* class com.tencent.wework.api.view.H5Activity.AnonymousClass4 */

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                AppMethodBeat.i(199024);
                try {
                    if (!Uri.parse(str).getScheme().toLowerCase().contains("http")) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        H5Activity h5Activity = H5Activity.this;
                        a bl = new a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(h5Activity, bl.axQ(), "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        h5Activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(h5Activity, "com/tencent/wework/api/view/H5Activity$4", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(199024);
                        return true;
                    }
                } catch (Throwable th) {
                }
                boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
                AppMethodBeat.o(199024);
                return shouldOverrideUrlLoading;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(199025);
                super.onPageStarted(webView, str, bitmap);
                AppMethodBeat.o(199025);
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                AppMethodBeat.i(199026);
                super.onReceivedError(webView, i2, str, str2);
                AppMethodBeat.o(199026);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                AppMethodBeat.i(199027);
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                AppMethodBeat.o(199027);
            }

            public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            }

            public void onPageFinished(WebView webView, String str) {
            }
        });
        webView.loadUrl(getIntent().getStringExtra("url"));
        AppMethodBeat.o(199028);
    }
}
