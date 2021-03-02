package com.tencent.xweb.x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ae;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.u;
import com.tencent.xweb.util.h;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.a;
import com.tencent.xweb.x5.g;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import com.tencent.xweb.xwalk.d;
import com.tencent.xweb.z;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 20001, fComment = "checked", lastDate = "20171020", reviewer = 20001, vComment = {EType.JSEXECUTECHECK})
public final class m implements IWebView {
    WebView SEl;
    ac SEn;
    x SEo;
    long SEr = 0;
    String SFA = "";
    private b SFB = new b() {
        /* class com.tencent.xweb.x5.m.AnonymousClass2 */

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i2) {
            AppMethodBeat.i(207204);
            if (m.this.SEo != null) {
                m.this.SEo.a(m.this.SEl, i2);
                AppMethodBeat.o(207204);
                return;
            }
            super.onProgressChanged(webView, i2);
            AppMethodBeat.o(207204);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207205);
            Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(str)));
            if (m.this.SEo != null) {
                m.this.SEo.d(m.this.SEl, str);
                AppMethodBeat.o(207205);
                return;
            }
            super.onReceivedTitle(webView, str);
            AppMethodBeat.o(207205);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            AppMethodBeat.i(207206);
            Log.i("X5WebView", "onShowCustomView");
            if (m.this.SEo != null) {
                m.this.SEo.onShowCustomView(view, new g.c(customViewCallback));
                AppMethodBeat.o(207206);
                return;
            }
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(207206);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onHideCustomView() {
            AppMethodBeat.i(207207);
            Log.i("X5WebView", "onHideCustomView");
            if (m.this.SEo != null) {
                m.this.SEo.onHideCustomView();
                AppMethodBeat.o(207207);
                return;
            }
            super.onHideCustomView();
            AppMethodBeat.o(207207);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(207208);
            Log.i("X5WebView", "onJsAlert");
            if (m.this.SEo != null) {
                boolean a2 = m.this.SEo.a(m.this.SEl, str, str2, new g.C2234g(jsResult));
                AppMethodBeat.o(207208);
                return a2;
            }
            boolean onJsAlert = super.onJsAlert(webView, str, str2, jsResult);
            AppMethodBeat.o(207208);
            return onJsAlert;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(207209);
            Log.i("X5WebView", "onJsConfirm");
            if (m.this.SEo != null) {
                boolean b2 = m.this.SEo.b(m.this.SEl, str, str2, new g.C2234g(jsResult));
                AppMethodBeat.o(207209);
                return b2;
            }
            boolean onJsConfirm = super.onJsConfirm(webView, str, str2, jsResult);
            AppMethodBeat.o(207209);
            return onJsConfirm;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.i(207210);
            Log.i("X5WebView", "onJsPrompt");
            if (m.this.SEo != null) {
                boolean a2 = m.this.SEo.a(m.this.SEl, str, str2, str3, new g.h(jsPromptResult));
                AppMethodBeat.o(207210);
                return a2;
            }
            boolean onJsPrompt = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(207210);
            return onJsPrompt;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            AppMethodBeat.i(207211);
            Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
            if (m.this.SEo != null) {
                m.this.SEo.onGeolocationPermissionsShowPrompt(str, new g.e(geolocationPermissionsCallback));
                AppMethodBeat.o(207211);
                return;
            }
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            AppMethodBeat.o(207211);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void onGeolocationPermissionsHidePrompt() {
            AppMethodBeat.i(207212);
            Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
            if (m.this.SEo != null) {
                m.this.SEo.onGeolocationPermissionsHidePrompt();
                AppMethodBeat.o(207212);
                return;
            }
            super.onGeolocationPermissionsHidePrompt();
            AppMethodBeat.o(207212);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            android.webkit.ConsoleMessage consoleMessage2;
            AppMethodBeat.i(207213);
            Log.i("X5WebView", "onConsoleMessage " + consoleMessage.message());
            if (m.this.SEo != null) {
                x xVar = m.this.SEo;
                if (consoleMessage == null) {
                    consoleMessage2 = null;
                } else {
                    ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.DEBUG;
                    switch (g.AnonymousClass1.SFb[consoleMessage.messageLevel().ordinal()]) {
                        case 1:
                            messageLevel = ConsoleMessage.MessageLevel.DEBUG;
                            break;
                        case 2:
                            messageLevel = ConsoleMessage.MessageLevel.ERROR;
                            break;
                        case 3:
                            messageLevel = ConsoleMessage.MessageLevel.LOG;
                            break;
                        case 4:
                            messageLevel = ConsoleMessage.MessageLevel.TIP;
                            break;
                        case 5:
                            messageLevel = ConsoleMessage.MessageLevel.WARNING;
                            break;
                    }
                    consoleMessage2 = new android.webkit.ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), messageLevel);
                }
                boolean onConsoleMessage = xVar.onConsoleMessage(consoleMessage2);
                AppMethodBeat.o(207213);
                return onConsoleMessage;
            }
            boolean onConsoleMessage2 = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(207213);
            return onConsoleMessage2;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(207214);
            Log.i("X5WebView", "openFileChooser with three param");
            if (m.this.SEo != null) {
                m.this.SEo.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(207214);
                return;
            }
            valueCallback.onReceiveValue(null);
            AppMethodBeat.o(207214);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            AppMethodBeat.i(207215);
            Log.i("X5WebView", "onShowFileChooser last method");
            if (m.this.SEo != null) {
                boolean a2 = m.this.SEo.a(m.this.SEl, valueCallback, new g.d(fileChooserParams));
                AppMethodBeat.o(207215);
                return a2;
            }
            boolean onShowFileChooser = super.onShowFileChooser(webView, new a.d(valueCallback), fileChooserParams);
            AppMethodBeat.o(207215);
            return onShowFileChooser;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient, com.tencent.xweb.x5.b
        public final View getVideoLoadingProgressView() {
            AppMethodBeat.i(207216);
            if (m.this.SEo != null) {
                View videoLoadingProgressView = m.this.SEo.getVideoLoadingProgressView();
                AppMethodBeat.o(207216);
                return videoLoadingProgressView;
            }
            View videoLoadingProgressView2 = super.getVideoLoadingProgressView();
            AppMethodBeat.o(207216);
            return videoLoadingProgressView2;
        }
    };
    private c SFC = new c() {
        /* class com.tencent.xweb.x5.m.AnonymousClass3 */

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(207217);
            Log.i("X5WebView", "shouldOverrideUrlLoading " + webResourceRequest.getUrl().toString());
            if (m.this.SEn != null) {
                boolean e2 = m.this.SEn.e(m.this.SEl, new g.b(webResourceRequest));
                AppMethodBeat.o(207217);
                return e2;
            }
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            AppMethodBeat.o(207217);
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207218);
            if (d.bsN(str)) {
                AppMethodBeat.o(207218);
                return true;
            }
            Log.i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            if (m.this.SEn != null) {
                boolean a2 = m.this.SEn.a(m.this.SEl, str);
                AppMethodBeat.o(207218);
                return a2;
            }
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.o(207218);
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onPageStarted(com.tencent.smtt.sdk.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(207219);
            Log.i("X5WebView", "onPageStarted ".concat(String.valueOf(str)));
            if (m.this.SEn != null) {
                m.this.SEn.b(m.this.SEl, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            m.this.SFA = "";
            m.this.SEr = System.currentTimeMillis();
            h.bsH(str);
            h.hub();
            com.tencent.xweb.internal.h.htF().htA();
            AppMethodBeat.o(207219);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onPageFinished(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207220);
            Log.i("X5WebView", "onPageFinished ".concat(String.valueOf(str)));
            if (m.this.SEn != null) {
                m.this.SEn.b(m.this.SEl, str);
            } else {
                super.onPageFinished(webView, str);
            }
            if (m.this.SFA == null || !m.this.SFA.equals(str)) {
                com.tencent.xweb.internal.h.htF().htB();
            }
            h.OR(System.currentTimeMillis() - m.this.SEr);
            d.a(m.this.SEl);
            h.OT(System.currentTimeMillis() - m.this.SEr);
            AppMethodBeat.o(207220);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onLoadResource(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207221);
            if (m.this.SEn != null) {
                m.this.SEn.h(m.this.SEl, str);
                AppMethodBeat.o(207221);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.o(207221);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207222);
            if (m.this.SEn != null) {
                WebResourceResponse b2 = a.b(m.this.SEn.c(m.this.SEl, str));
                AppMethodBeat.o(207222);
                return b2;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.o(207222);
            return shouldInterceptRequest;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(207223);
            if (m.this.SEn != null) {
                WebResourceResponse b2 = a.b(m.this.SEn.a(m.this.SEl, new g.b(webResourceRequest)));
                AppMethodBeat.o(207223);
                return b2;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.o(207223);
            return shouldInterceptRequest;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(207224);
            if (m.this.SEn != null) {
                WebResourceResponse b2 = a.b(m.this.SEn.a(m.this.SEl, new g.b(webResourceRequest), bundle));
                AppMethodBeat.o(207224);
                return b2;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest, bundle);
            AppMethodBeat.o(207224);
            return shouldInterceptRequest;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onScaleChanged(com.tencent.smtt.sdk.WebView webView, float f2, float f3) {
            AppMethodBeat.i(207225);
            if (m.this.SEn != null) {
                m.this.SEn.a(m.this.SEl, f2, f3);
                AppMethodBeat.o(207225);
                return;
            }
            super.onScaleChanged(webView, f2, f3);
            AppMethodBeat.o(207225);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, String str, boolean z) {
            AppMethodBeat.i(207226);
            if (m.this.SEn != null) {
                m.this.SEn.b(m.this.SEl, str, z);
                AppMethodBeat.o(207226);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.o(207226);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(207227);
            if (m.this.SEn != null) {
                m.this.SEn.a(m.this.SEl, i2, str, str2);
            } else {
                super.onReceivedError(webView, i2, str, str2);
            }
            m.this.SFA = str2;
            h.htY();
            com.tencent.xweb.internal.h.htF().htG();
            h.huc();
            AppMethodBeat.o(207227);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onReceivedHttpAuthRequest(com.tencent.smtt.sdk.WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            AppMethodBeat.i(207228);
            Log.i("X5WebView", "onReceivedHttpAuthRequest host:" + str + ", realm:" + str2);
            if (m.this.SEn != null) {
                m.this.SEn.a(m.this.SEl, new g.f(httpAuthHandler), str, str2);
                AppMethodBeat.o(207228);
                return;
            }
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            AppMethodBeat.o(207228);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            android.net.http.SslError sslError2;
            AppMethodBeat.i(207229);
            Log.i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (m.this.SEn != null) {
                ac acVar = m.this.SEn;
                WebView webView2 = m.this.SEl;
                g.a aVar = new g.a(sslErrorHandler);
                if (sslError != null) {
                    sslError2 = new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate());
                } else {
                    sslError2 = null;
                }
                acVar.a(webView2, aVar, sslError2);
                AppMethodBeat.o(207229);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.o(207229);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.i(207230);
            Log.i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
            if (m.this.SEn != null) {
                m.this.SEn.a(m.this.SEl, new g.b(webResourceRequest), g.a(webResourceResponse));
                AppMethodBeat.o(207230);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.o(207230);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public final void onPageCommitVisible(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(207231);
            Log.i("X5WebView", "onPageCommitVisible s = ".concat(String.valueOf(str)));
            if (m.this.SEn != null) {
                m.this.SEn.e(m.this.SEl, str);
            }
            AppMethodBeat.o(207231);
        }
    };
    com.tencent.smtt.sdk.WebView SFr;
    j SFy;
    o SFz;

    class a extends com.tencent.smtt.sdk.WebView {
        public a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onScrollChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(153926);
            super.onScrollChanged(i2, i3, i4, i5);
            if (m.this.SEl != null) {
                m.this.SEl.onWebViewScrollChanged(i2, i3, i4, i5);
            }
            AppMethodBeat.o(153926);
        }
    }

    public m(WebView webView) {
        AppMethodBeat.i(153927);
        this.SEl = webView;
        this.SFr = new a(webView.getContext());
        this.SFr.setBackgroundColor(0);
        this.SFy = new j(this.SFr);
        this.SFr.setWebChromeClient(this.SFB);
        this.SFr.setWebViewClient(this.SFC);
        this.SFy.SFp = this.SFC;
        this.SFy.SFq = this.SFB;
        AppMethodBeat.o(153927);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Object getX5WebViewExtension() {
        AppMethodBeat.i(153928);
        IX5WebViewExtension x5WebViewExtension = this.SFr.getX5WebViewExtension();
        AppMethodBeat.o(153928);
        return x5WebViewExtension;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar) {
        AppMethodBeat.i(153929);
        if (aVar == null) {
            this.SFr.setWebViewClientExtension(new ProxyWebViewClientExtension() {
                /* class com.tencent.xweb.x5.m.AnonymousClass1 */

                @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                public final int getHostByName(String str, List<String> list) {
                    AppMethodBeat.i(207203);
                    if (X5WebFactory.getInstance().getExtensionCallback() != null) {
                        int hostByName = X5WebFactory.getInstance().getExtensionCallback().getHostByName(str, list);
                        AppMethodBeat.o(207203);
                        return hostByName;
                    }
                    int hostByName2 = super.getHostByName(str, list);
                    AppMethodBeat.o(207203);
                    return hostByName2;
                }
            });
            AppMethodBeat.o(153929);
            return;
        }
        this.SFr.setWebViewClientExtension(new ProxyWebViewSuperWrapper(aVar));
        AppMethodBeat.o(153929);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(153930);
        boolean super_onTouchEvent = this.SFr.super_onTouchEvent(motionEvent);
        AppMethodBeat.o(153930);
        return super_onTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(153931);
        boolean super_onInterceptTouchEvent = this.SFr.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(153931);
        return super_onInterceptTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(153932);
        this.SFr.super_onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(153932);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(153933);
        boolean super_dispatchTouchEvent = this.SFr.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(153933);
        return super_dispatchTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_computeScroll() {
        AppMethodBeat.i(153934);
        this.SFr.super_computeScroll();
        AppMethodBeat.o(153934);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(153935);
        this.SFr.super_onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(153935);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        AppMethodBeat.i(153936);
        boolean super_overScrollBy = this.SFr.super_overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
        AppMethodBeat.o(153936);
        return super_overScrollBy;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onResume() {
        AppMethodBeat.i(153937);
        this.SFr.onResume();
        AppMethodBeat.o(153937);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onPause() {
        AppMethodBeat.i(153938);
        this.SFr.onPause();
        AppMethodBeat.o(153938);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final z getSettings() {
        AppMethodBeat.i(153939);
        if (this.SFz != null) {
            o oVar = this.SFz;
            AppMethodBeat.o(153939);
            return oVar;
        } else if (this.SFr == null) {
            AppMethodBeat.o(153939);
            return null;
        } else {
            this.SFz = new o(this.SFr);
            o oVar2 = this.SFz;
            AppMethodBeat.o(153939);
            return oVar2;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getView() {
        AppMethodBeat.i(153940);
        View view = this.SFr.getView();
        AppMethodBeat.o(153940);
        return view;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ViewGroup getTopView() {
        AppMethodBeat.i(153941);
        ViewGroup viewGroup = (ViewGroup) this.SFr.getView();
        AppMethodBeat.o(153941);
        return viewGroup;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getWebViewUI() {
        return this.SFr;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClient(ac acVar) {
        this.SEn = acVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebChromeClient(x xVar) {
        this.SEo = xVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(153942);
        this.SFr.setDownloadListener(new a.C2233a(downloadListener));
        AppMethodBeat.o(153942);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setFindListener(WebView.FindListener findListener) {
        AppMethodBeat.i(153943);
        this.SFr.setFindListener(new a.b(findListener));
        AppMethodBeat.o(153943);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str) {
        AppMethodBeat.i(153944);
        this.SFr.loadUrl(str);
        AppMethodBeat.o(153944);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoBack() {
        AppMethodBeat.i(153945);
        boolean canGoBack = this.SFr.canGoBack();
        AppMethodBeat.o(153945);
        return canGoBack;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goBack() {
        AppMethodBeat.i(153946);
        this.SFr.goBack();
        AppMethodBeat.o(153946);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean hasEnteredFullscreen() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void leaveFullscreen() {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearView() {
        AppMethodBeat.i(153947);
        this.SFr.clearView();
        AppMethodBeat.o(153947);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void destroy() {
        AppMethodBeat.i(153948);
        this.SFr.destroy();
        AppMethodBeat.o(153948);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void disableVideoJsCallback(boolean z) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final u setVideoJsCallback(v vVar) {
        AppMethodBeat.i(153949);
        Log.i("X5WebView", "setVideoJsCallback not support");
        AppMethodBeat.o(153949);
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        AppMethodBeat.i(153950);
        this.SFr.evaluateJavascript(str, new a.d(valueCallback));
        AppMethodBeat.o(153950);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final e getDefalutOpProvider() {
        return this.SFy;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void reload() {
        AppMethodBeat.i(153951);
        this.SFr.reload();
        AppMethodBeat.o(153951);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearSslPreferences() {
        AppMethodBeat.i(153952);
        this.SFr.clearSslPreferences();
        AppMethodBeat.o(153952);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(153953);
        this.SFr.loadData(str, str2, str3);
        AppMethodBeat.o(153953);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getContentHeight() {
        AppMethodBeat.i(153954);
        int contentHeight = this.SFr.getContentHeight();
        AppMethodBeat.o(153954);
        return contentHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final float getScale() {
        AppMethodBeat.i(153955);
        float scale = this.SFr.getScale();
        AppMethodBeat.o(153955);
        return scale;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getVisibleTitleHeight() {
        AppMethodBeat.i(153956);
        int visibleTitleHeight = this.SFr.getVisibleTitleHeight();
        AppMethodBeat.o(153956);
        return visibleTitleHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(153957);
        boolean overlayHorizontalScrollbar = this.SFr.overlayHorizontalScrollbar();
        AppMethodBeat.o(153957);
        return overlayHorizontalScrollbar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(153958);
        this.SFr.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(153958);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomOut() {
        AppMethodBeat.i(153959);
        boolean zoomOut = this.SFr.zoomOut();
        AppMethodBeat.o(153959);
        return zoomOut;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomIn() {
        AppMethodBeat.i(153960);
        boolean zoomIn = this.SFr.zoomIn();
        AppMethodBeat.o(153960);
        return zoomIn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(153961);
        this.SFr.loadUrl(str, map);
        AppMethodBeat.o(153961);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(153962);
        this.SFr.addJavascriptInterface(obj, str);
        AppMethodBeat.o(153962);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getUrl() {
        AppMethodBeat.i(153963);
        String url = this.SFr.getUrl();
        AppMethodBeat.o(153963);
        return url;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(153964);
        this.SFr.removeJavascriptInterface(str);
        AppMethodBeat.o(153964);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void stopLoading() {
        AppMethodBeat.i(153965);
        this.SFr.stopLoading();
        AppMethodBeat.o(153965);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewCallbackClient(ab abVar) {
        AppMethodBeat.i(153966);
        this.SFr.setWebViewCallbackClient(new a.f(abVar));
        AppMethodBeat.o(153966);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.b getHitTestResult() {
        AppMethodBeat.i(153967);
        WebView.HitTestResult hitTestResult = this.SFr.getHitTestResult();
        WebView.b bVar = new WebView.b();
        bVar.mType = hitTestResult.getType();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(153967);
        return bVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getTitle() {
        AppMethodBeat.i(153968);
        String title = this.SFr.getTitle();
        AppMethodBeat.o(153968);
        return title;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearMatches() {
        AppMethodBeat.i(153969);
        this.SFr.clearMatches();
        AppMethodBeat.o(153969);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findNext(boolean z) {
        AppMethodBeat.i(153970);
        this.SFr.findNext(z);
        AppMethodBeat.o(153970);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findAllAsync(String str) {
        AppMethodBeat.i(153971);
        this.SFr.findAllAsync(str);
        AppMethodBeat.o(153971);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getVersionInfo() {
        AppMethodBeat.i(153972);
        if (this.SFr.getX5WebViewExtension() != null) {
            String str = "use x5 and x5 kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.hsv();
            AppMethodBeat.o(153972);
            return str;
        }
        String str2 = "use x5 wrapped sys kernel, sdk ver = " + com.tencent.xweb.WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + com.tencent.xweb.WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + JsRuntime.hsv();
        AppMethodBeat.o(153972);
        return str2;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getAbstractInfo() {
        AppMethodBeat.i(153973);
        String str = "webviewtype = x5, is using x5 core = " + (this.SFr.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.SEl.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.SEl.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.SEl.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.SEl.getContext());
        AppMethodBeat.o(153973);
        return str;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ac getCurWebviewClient() {
        return this.SEn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final x getCurWebChromeClient() {
        return this.SEo;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollY() {
        AppMethodBeat.i(153974);
        int webScrollY = this.SFr.getWebScrollY();
        AppMethodBeat.o(153974);
        return webScrollY;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollX() {
        AppMethodBeat.i(153975);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.o(153975);
        return scrollX;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isOverScrollStart() {
        AppMethodBeat.i(153976);
        if (getView().getScrollY() == 0) {
            AppMethodBeat.o(153976);
            return true;
        }
        AppMethodBeat.o(153976);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.a getFullscreenVideoKind() {
        return WebView.a.NOT_HOOK;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setJSExceptionListener(ae aeVar) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean savePage(String str, String str2, int i2) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearHistory() {
        AppMethodBeat.i(153977);
        this.SFr.clearHistory();
        AppMethodBeat.o(153977);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoForward() {
        AppMethodBeat.i(153978);
        boolean canGoForward = this.SFr.canGoForward();
        AppMethodBeat.o(153978);
        return canGoForward;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goForward() {
        AppMethodBeat.i(153979);
        this.SFr.goForward();
        AppMethodBeat.o(153979);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean supportFeature(int i2) {
        AppMethodBeat.i(153980);
        if (i2 == 2006) {
            int tbsVersion = QbSdk.getTbsVersion(this.SFr.getContext());
            if (tbsVersion >= 44900) {
                AppMethodBeat.o(153980);
                return true;
            } else if (tbsVersion <= 0 || getX5WebViewExtension() == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    AppMethodBeat.o(153980);
                    return true;
                }
                AppMethodBeat.o(153980);
                return false;
            }
        }
        AppMethodBeat.o(153980);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(153981);
        this.SFr.getView().setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(153981);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(153982);
        this.SFr.getView().setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(153982);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bundle invokeMiscMethod(String str, Bundle bundle) {
        AppMethodBeat.i(153983);
        if (this.SFr.getX5WebViewExtension() == null) {
            Log.d("X5WebView", "invokeMiscMethod  extension is null");
            AppMethodBeat.o(153983);
            return null;
        }
        Log.d("X5WebView", "invokeMiscMethod x5  extension");
        Object invokeMiscMethod = this.SFr.getX5WebViewExtension().invokeMiscMethod(str, bundle);
        if (invokeMiscMethod instanceof Bundle) {
            Bundle bundle2 = (Bundle) invokeMiscMethod;
            AppMethodBeat.o(153983);
            return bundle2;
        }
        Log.d("X5WebView", "invokeMiscMethod  extension is null");
        AppMethodBeat.o(153983);
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean getImageBitmapToFile(String str, String str2, String str3, i iVar) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bitmap captureBitmap() {
        AppMethodBeat.i(207233);
        if (!(getX5WebViewExtension() instanceof IX5WebViewExtension) || this.SEl.isSysKernel()) {
            Bitmap createBitmap = Bitmap.createBitmap(this.SFr.getWidth(), this.SFr.getHeight(), Bitmap.Config.ARGB_8888);
            this.SFr.draw(new Canvas(createBitmap));
            AppMethodBeat.o(207233);
            return createBitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(this.SFr.getWidth(), this.SFr.getHeight(), Bitmap.Config.ARGB_8888);
        ((IX5WebViewExtension) getX5WebViewExtension()).snapshotVisible(new Canvas(createBitmap2), false, false, false, false);
        AppMethodBeat.o(207233);
        return createBitmap2;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void captureBitmap(final IWebView.a aVar) {
        AppMethodBeat.i(153984);
        new Thread(new Runnable() {
            /* class com.tencent.xweb.x5.m.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(207232);
                m.this.SFr.draw(new Canvas(Bitmap.createBitmap(m.this.SFr.getWidth(), m.this.SFr.getHeight(), Bitmap.Config.ARGB_8888)));
                Log.d("X5WebView", "bitmapCaptureFinished");
                AppMethodBeat.o(207232);
            }
        }).start();
        AppMethodBeat.o(153984);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void smoothScroll(int i2, int i3, long j2) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setBottomHeight(int i2) {
        AppMethodBeat.i(153985);
        Log.e("X5WebView", "setBottomHeight not implement");
        AppMethodBeat.o(153985);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onShow() {
        AppMethodBeat.i(153986);
        this.SFr.onResume();
        AppMethodBeat.o(153986);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onHide() {
        AppMethodBeat.i(153987);
        this.SFr.onPause();
        AppMethodBeat.o(153987);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getScrollHeight() {
        AppMethodBeat.i(153988);
        int computeVerticalScrollRange = this.SFr.computeVerticalScrollRange();
        AppMethodBeat.o(153988);
        return computeVerticalScrollRange;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(207234);
        i iVar = new i(this.SFr.copyBackForwardList());
        AppMethodBeat.o(207234);
        return iVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207235);
        this.SFr.setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(207235);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207236);
        String[] httpAuthUsernamePassword = this.SFr.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207236);
        return httpAuthUsernamePassword;
    }
}
