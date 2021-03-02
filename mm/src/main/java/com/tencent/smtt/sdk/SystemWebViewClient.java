package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.o;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* access modifiers changed from: package-private */
@SuppressLint({"NewApi", "Override"})
public class SystemWebViewClient extends WebViewClient {

    /* renamed from: c  reason: collision with root package name */
    private static String f1754c = null;

    /* renamed from: a  reason: collision with root package name */
    private WebViewClient f1755a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f1756b;

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.f1756b = webView;
        this.f1755a = webViewClient;
    }

    public void onLoadResource(WebView webView, String str) {
        AppMethodBeat.i(54693);
        this.f1756b.a(webView);
        this.f1755a.onLoadResource(this.f1756b, str);
        AppMethodBeat.o(54693);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        AppMethodBeat.i(54694);
        if (str == null || this.f1756b.showDebugView(str)) {
            AppMethodBeat.o(54694);
            return true;
        }
        this.f1756b.a(webView);
        boolean shouldOverrideUrlLoading = this.f1755a.shouldOverrideUrlLoading(this.f1756b, str);
        AppMethodBeat.o(54694);
        return shouldOverrideUrlLoading;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(54695);
        String str = null;
        if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
            str = webResourceRequest.getUrl().toString();
        }
        if (str == null || this.f1756b.showDebugView(str)) {
            AppMethodBeat.o(54695);
            return true;
        }
        this.f1756b.a(webView);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = k.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
            }
        }
        boolean shouldOverrideUrlLoading = this.f1755a.shouldOverrideUrlLoading(this.f1756b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        AppMethodBeat.o(54695);
        return shouldOverrideUrlLoading;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        AppMethodBeat.i(54696);
        if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(54696);
            return null;
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.f1755a.shouldInterceptRequest(this.f1756b, str);
        if (shouldInterceptRequest == null) {
            AppMethodBeat.o(54696);
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        AppMethodBeat.o(54696);
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(54697);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54697);
            return null;
        } else if (webResourceRequest == null) {
            AppMethodBeat.o(54697);
            return null;
        } else {
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 24) {
                Object a2 = k.a(webResourceRequest, "isRedirect");
                if (a2 instanceof Boolean) {
                    z = ((Boolean) a2).booleanValue();
                }
            }
            com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.f1755a.shouldInterceptRequest(this.f1756b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            if (shouldInterceptRequest == null) {
                AppMethodBeat.o(54697);
                return null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
            webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
            int statusCode = shouldInterceptRequest.getStatusCode();
            String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
            if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
            }
            AppMethodBeat.o(54697);
            return webResourceResponse;
        }
    }

    class e implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {

        /* renamed from: b  reason: collision with root package name */
        private String f1765b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1766c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1767d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1768e;

        /* renamed from: f  reason: collision with root package name */
        private String f1769f;

        /* renamed from: g  reason: collision with root package name */
        private Map<String, String> f1770g;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.f1765b = str;
            this.f1766c = z;
            this.f1767d = z2;
            this.f1768e = z3;
            this.f1769f = str2;
            this.f1770g = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            AppMethodBeat.i(54362);
            Uri parse = Uri.parse(this.f1765b);
            AppMethodBeat.o(54362);
            return parse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f1766c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f1767d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f1768e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f1769f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f1770g;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.i(54698);
        this.f1756b.a(webView);
        boolean shouldOverrideKeyEvent = this.f1755a.shouldOverrideKeyEvent(this.f1756b, keyEvent);
        AppMethodBeat.o(54698);
        return shouldOverrideKeyEvent;
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        AppMethodBeat.i(54699);
        this.f1756b.a(webView);
        this.f1755a.onFormResubmission(this.f1756b, message, message2);
        AppMethodBeat.o(54699);
    }

    public void onPageFinished(WebView webView, String str) {
        o a2;
        AppMethodBeat.i(54700);
        TbsLog.v("TbsPerfTest", "PageLoadFinished!");
        if (f1754c == null && (a2 = o.a()) != null) {
            a2.a(true);
            f1754c = Boolean.toString(true);
        }
        this.f1756b.a(webView);
        this.f1756b.f1914a++;
        this.f1755a.onPageFinished(this.f1756b, str);
        TbsLog.d("sdkreport", "SystemWebViewclient.onPageFinished--Pv=" + this.f1756b.f1914a);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.f1756b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!TbsShareManager.mHasQueryed && this.f1756b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f1756b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() {
                /* class com.tencent.smtt.sdk.SystemWebViewClient.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(55114);
                    if (!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.f1756b.getContext()) && TbsDownloader.needDownload(SystemWebViewClient.this.f1756b.getContext(), false)) {
                        TbsDownloader.startDownload(SystemWebViewClient.this.f1756b.getContext());
                    }
                    AppMethodBeat.o(55114);
                }
            }).start();
        }
        if (this.f1756b.getContext() != null && !TbsLogReport.getInstance(this.f1756b.getContext()).getShouldUploadEventReport()) {
            TbsLogReport.getInstance(this.f1756b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.f1756b.getContext()).dailyReport();
        }
        AppMethodBeat.o(54700);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(54701);
        this.f1756b.a(webView);
        this.f1755a.onPageStarted(this.f1756b, str, bitmap);
        AppMethodBeat.o(54701);
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        AppMethodBeat.i(54702);
        this.f1756b.a(webView);
        this.f1755a.onReceivedError(this.f1756b, i2, str, str2);
        AppMethodBeat.o(54702);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        f fVar;
        AnonymousClass2 r0 = null;
        AppMethodBeat.i(54703);
        this.f1756b.a(webView);
        if (webResourceRequest != null) {
            fVar = new f(webResourceRequest);
        } else {
            fVar = null;
        }
        if (webResourceError != null) {
            r0 = new com.tencent.smtt.export.external.interfaces.WebResourceError() {
                /* class com.tencent.smtt.sdk.SystemWebViewClient.AnonymousClass2 */

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public CharSequence getDescription() {
                    AppMethodBeat.i(54935);
                    CharSequence description = webResourceError.getDescription();
                    AppMethodBeat.o(54935);
                    return description;
                }

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public int getErrorCode() {
                    AppMethodBeat.i(54936);
                    int errorCode = webResourceError.getErrorCode();
                    AppMethodBeat.o(54936);
                    return errorCode;
                }
            };
        }
        this.f1755a.onReceivedError(this.f1756b, fVar, r0);
        AppMethodBeat.o(54703);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(54704);
        this.f1756b.a(webView);
        this.f1755a.onReceivedHttpError(this.f1756b, new f(webResourceRequest), new g(webResourceResponse));
        AppMethodBeat.o(54704);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.i(54705);
        this.f1756b.a(webView);
        this.f1755a.onReceivedHttpAuthRequest(this.f1756b, new b(httpAuthHandler), str, str2);
        AppMethodBeat.o(54705);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        AppMethodBeat.i(54706);
        this.f1756b.a(webView);
        this.f1755a.doUpdateVisitedHistory(this.f1756b, str, z);
        AppMethodBeat.o(54706);
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        AppMethodBeat.i(54707);
        if (Build.VERSION.SDK_INT >= 12) {
            this.f1756b.a(webView);
            this.f1755a.onReceivedLoginRequest(this.f1756b, str, str2, str3);
        }
        AppMethodBeat.o(54707);
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AppMethodBeat.i(54708);
        if (Build.VERSION.SDK_INT >= 8) {
            this.f1756b.a(webView);
            this.f1755a.onReceivedSslError(this.f1756b, new c(sslErrorHandler), new d(sslError));
        }
        AppMethodBeat.o(54708);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(54709);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1756b.a(webView);
            this.f1755a.onReceivedClientCertRequest(this.f1756b, new a(clientCertRequest));
        }
        AppMethodBeat.o(54709);
    }

    static class a extends com.tencent.smtt.export.external.interfaces.ClientCertRequest {

        /* renamed from: a  reason: collision with root package name */
        private ClientCertRequest f1760a;

        public a(ClientCertRequest clientCertRequest) {
            this.f1760a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            AppMethodBeat.i(55053);
            this.f1760a.cancel();
            AppMethodBeat.o(55053);
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            AppMethodBeat.i(55054);
            String host = this.f1760a.getHost();
            AppMethodBeat.o(55054);
            return host;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            AppMethodBeat.i(55055);
            String[] keyTypes = this.f1760a.getKeyTypes();
            AppMethodBeat.o(55055);
            return keyTypes;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            AppMethodBeat.i(55056);
            int port = this.f1760a.getPort();
            AppMethodBeat.o(55056);
            return port;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            AppMethodBeat.i(55057);
            Principal[] principals = this.f1760a.getPrincipals();
            AppMethodBeat.o(55057);
            return principals;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            AppMethodBeat.i(55058);
            this.f1760a.ignore();
            AppMethodBeat.o(55058);
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            AppMethodBeat.i(55059);
            this.f1760a.proceed(privateKey, x509CertificateArr);
            AppMethodBeat.o(55059);
        }
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        AppMethodBeat.i(54710);
        this.f1756b.a(webView);
        this.f1755a.onScaleChanged(this.f1756b, f2, f3);
        AppMethodBeat.o(54710);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        AppMethodBeat.i(54711);
        this.f1756b.a(webView);
        this.f1755a.onTooManyRedirects(this.f1756b, message, message2);
        AppMethodBeat.o(54711);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        AppMethodBeat.i(54712);
        this.f1756b.a(webView);
        this.f1755a.onUnhandledKeyEvent(this.f1756b, keyEvent);
        AppMethodBeat.o(54712);
    }

    static class b implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler {

        /* renamed from: a  reason: collision with root package name */
        private HttpAuthHandler f1761a;

        b(HttpAuthHandler httpAuthHandler) {
            this.f1761a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            AppMethodBeat.i(54322);
            this.f1761a.proceed(str, str2);
            AppMethodBeat.o(54322);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            AppMethodBeat.i(54323);
            this.f1761a.cancel();
            AppMethodBeat.o(54323);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            AppMethodBeat.i(54324);
            boolean useHttpAuthUsernamePassword = this.f1761a.useHttpAuthUsernamePassword();
            AppMethodBeat.o(54324);
            return useHttpAuthUsernamePassword;
        }
    }

    static class c implements com.tencent.smtt.export.external.interfaces.SslErrorHandler {

        /* renamed from: a  reason: collision with root package name */
        SslErrorHandler f1762a;

        c(SslErrorHandler sslErrorHandler) {
            this.f1762a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            AppMethodBeat.i(55028);
            this.f1762a.proceed();
            AppMethodBeat.o(55028);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            AppMethodBeat.i(55029);
            this.f1762a.cancel();
            AppMethodBeat.o(55029);
        }
    }

    static class d implements com.tencent.smtt.export.external.interfaces.SslError {

        /* renamed from: a  reason: collision with root package name */
        SslError f1763a;

        d(SslError sslError) {
            this.f1763a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            AppMethodBeat.i(55181);
            SslCertificate certificate = this.f1763a.getCertificate();
            AppMethodBeat.o(55181);
            return certificate;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i2) {
            AppMethodBeat.i(55182);
            boolean addError = this.f1763a.addError(i2);
            AppMethodBeat.o(55182);
            return addError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i2) {
            AppMethodBeat.i(55183);
            boolean hasError = this.f1763a.hasError(i2);
            AppMethodBeat.o(55183);
            return hasError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            AppMethodBeat.i(55184);
            int primaryError = this.f1763a.getPrimaryError();
            AppMethodBeat.o(55184);
            return primaryError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            AppMethodBeat.i(55185);
            String url = this.f1763a.getUrl();
            AppMethodBeat.o(55185);
            return url;
        }
    }

    static class f implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {

        /* renamed from: a  reason: collision with root package name */
        WebResourceRequest f1771a;

        f(WebResourceRequest webResourceRequest) {
            this.f1771a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            AppMethodBeat.i(55007);
            String method = this.f1771a.getMethod();
            AppMethodBeat.o(55007);
            return method;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            AppMethodBeat.i(55008);
            Map<String, String> requestHeaders = this.f1771a.getRequestHeaders();
            AppMethodBeat.o(55008);
            return requestHeaders;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            AppMethodBeat.i(55009);
            Uri url = this.f1771a.getUrl();
            AppMethodBeat.o(55009);
            return url;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            AppMethodBeat.i(55010);
            boolean hasGesture = this.f1771a.hasGesture();
            AppMethodBeat.o(55010);
            return hasGesture;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            AppMethodBeat.i(55011);
            boolean isForMainFrame = this.f1771a.isForMainFrame();
            AppMethodBeat.o(55011);
            return isForMainFrame;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            boolean z;
            AppMethodBeat.i(55012);
            if (Build.VERSION.SDK_INT >= 24) {
                Object a2 = k.a(this.f1771a, "isRedirect");
                if (a2 instanceof Boolean) {
                    z = ((Boolean) a2).booleanValue();
                    AppMethodBeat.o(55012);
                    return z;
                }
            }
            z = false;
            AppMethodBeat.o(55012);
            return z;
        }
    }

    static class g extends com.tencent.smtt.export.external.interfaces.WebResourceResponse {

        /* renamed from: a  reason: collision with root package name */
        WebResourceResponse f1772a;

        public g(WebResourceResponse webResourceResponse) {
            this.f1772a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            AppMethodBeat.i(55361);
            InputStream data = this.f1772a.getData();
            AppMethodBeat.o(55361);
            return data;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            AppMethodBeat.i(55362);
            String encoding = this.f1772a.getEncoding();
            AppMethodBeat.o(55362);
            return encoding;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            AppMethodBeat.i(55363);
            String mimeType = this.f1772a.getMimeType();
            AppMethodBeat.o(55363);
            return mimeType;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            AppMethodBeat.i(55364);
            String reasonPhrase = this.f1772a.getReasonPhrase();
            AppMethodBeat.o(55364);
            return reasonPhrase;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            AppMethodBeat.i(55365);
            Map<String, String> responseHeaders = this.f1772a.getResponseHeaders();
            AppMethodBeat.o(55365);
            return responseHeaders;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            AppMethodBeat.i(55366);
            int statusCode = this.f1772a.getStatusCode();
            AppMethodBeat.o(55366);
            return statusCode;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            AppMethodBeat.i(55367);
            this.f1772a.setData(inputStream);
            AppMethodBeat.o(55367);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            AppMethodBeat.i(55368);
            this.f1772a.setEncoding(str);
            AppMethodBeat.o(55368);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            AppMethodBeat.i(55369);
            this.f1772a.setMimeType(str);
            AppMethodBeat.o(55369);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            AppMethodBeat.i(55370);
            this.f1772a.setResponseHeaders(map);
            AppMethodBeat.o(55370);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i2, String str) {
            AppMethodBeat.i(55371);
            this.f1772a.setStatusCodeAndReasonPhrase(i2, str);
            AppMethodBeat.o(55371);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        AppMethodBeat.i(54713);
        this.f1756b.a(webView);
        this.f1755a.onPageCommitVisible(this.f1756b, str);
        AppMethodBeat.o(54713);
    }
}
