package com.tencent.xweb.x5;

import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.ab;
import java.util.Map;
import org.xwalk.core.Log;

public final class a {

    /* renamed from: com.tencent.xweb.x5.a$a  reason: collision with other inner class name */
    public static class C2233a implements DownloadListener {
        android.webkit.DownloadListener SES;

        public C2233a(android.webkit.DownloadListener downloadListener) {
            this.SES = downloadListener;
        }

        @Override // com.tencent.smtt.sdk.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            AppMethodBeat.i(153812);
            if (this.SES != null) {
                this.SES.onDownloadStart(str, str2, str3, str4, j2);
            }
            AppMethodBeat.o(153812);
        }
    }

    public static class f implements WebViewCallbackClient {
        ab SEX;

        public f(ab abVar) {
            this.SEX = abVar;
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(153823);
            if (this.SEX != null) {
                boolean B = this.SEX.B(motionEvent);
                AppMethodBeat.o(153823);
                return B;
            }
            AppMethodBeat.o(153823);
            return false;
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
            AppMethodBeat.i(153824);
            if (this.SEX != null) {
                boolean b2 = this.SEX.b(i2, i3, i4, i5, i6, i7, i8, i9, z);
                AppMethodBeat.o(153824);
                return b2;
            }
            AppMethodBeat.o(153824);
            return false;
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(153825);
            if (this.SEX != null) {
                boolean C = this.SEX.C(motionEvent);
                AppMethodBeat.o(153825);
                return C;
            }
            AppMethodBeat.o(153825);
            return false;
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final void computeScroll(View view) {
            AppMethodBeat.i(153826);
            if (this.SEX != null) {
                this.SEX.bLv();
            }
            AppMethodBeat.o(153826);
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
            AppMethodBeat.i(153827);
            if (this.SEX != null) {
                this.SEX.d(i2, i3, z, z2);
            }
            AppMethodBeat.o(153827);
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(153828);
            if (this.SEX != null) {
                boolean D = this.SEX.D(motionEvent);
                AppMethodBeat.o(153828);
                return D;
            }
            AppMethodBeat.o(153828);
            return false;
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
            AppMethodBeat.i(153829);
            if (this.SEX != null) {
                this.SEX.onScrollChanged(i2, i3, i4, i5, view);
            }
            AppMethodBeat.o(153829);
        }

        @Override // com.tencent.smtt.sdk.WebViewCallbackClient
        public final void invalidate() {
        }
    }

    public static class d<T> implements ValueCallback<T> {
        android.webkit.ValueCallback<T> SEV;

        public d(android.webkit.ValueCallback<T> valueCallback) {
            this.SEV = valueCallback;
        }

        @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
        public final void onReceiveValue(T t) {
            AppMethodBeat.i(153816);
            if (this.SEV != null) {
                this.SEV.onReceiveValue(t);
            }
            AppMethodBeat.o(153816);
        }
    }

    public static class b implements IX5WebViewBase.FindListener {
        WebView.FindListener SET;

        public b(WebView.FindListener findListener) {
            this.SET = findListener;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener
        public final void onFindResultReceived(int i2, int i3, boolean z) {
            AppMethodBeat.i(153813);
            if (this.SET != null) {
                this.SET.onFindResultReceived(i2, i3, z);
            }
            AppMethodBeat.o(153813);
        }
    }

    public static WebResourceResponse b(com.tencent.xweb.WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(153830);
        if (webResourceResponse == null) {
            AppMethodBeat.o(153830);
            return null;
        }
        if (webResourceResponse.SAc && Build.VERSION.SDK_INT >= 21) {
            try {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(webResourceResponse.mMimeType, webResourceResponse.mEncoding, webResourceResponse.mStatusCode, webResourceResponse.mReasonPhrase, webResourceResponse.mResponseHeaders, webResourceResponse.mInputStream);
                AppMethodBeat.o(153830);
                return webResourceResponse2;
            } catch (Exception e2) {
                Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e2.getMessage());
            }
        }
        WebResourceResponse webResourceResponse3 = new WebResourceResponse(webResourceResponse.mMimeType, webResourceResponse.mEncoding, webResourceResponse.mInputStream);
        if (webResourceResponse.mStatusCode > 100 && webResourceResponse.mReasonPhrase != null && !webResourceResponse.mReasonPhrase.isEmpty()) {
            webResourceResponse3.setStatusCodeAndReasonPhrase(webResourceResponse.mStatusCode, webResourceResponse.mReasonPhrase);
        }
        webResourceResponse3.setResponseHeaders(webResourceResponse.mResponseHeaders);
        AppMethodBeat.o(153830);
        return webResourceResponse3;
    }

    public static class e implements WebResourceRequest {
        public com.tencent.xweb.WebResourceRequest SEW;

        public static WebResourceRequest a(com.tencent.xweb.WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(153817);
            if (webResourceRequest == null) {
                AppMethodBeat.o(153817);
                return null;
            }
            e eVar = new e(webResourceRequest);
            AppMethodBeat.o(153817);
            return eVar;
        }

        private e(com.tencent.xweb.WebResourceRequest webResourceRequest) {
            this.SEW = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final Uri getUrl() {
            AppMethodBeat.i(153818);
            Uri url = this.SEW.getUrl();
            AppMethodBeat.o(153818);
            return url;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final boolean isForMainFrame() {
            AppMethodBeat.i(153819);
            boolean isForMainFrame = this.SEW.isForMainFrame();
            AppMethodBeat.o(153819);
            return isForMainFrame;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final boolean isRedirect() {
            return false;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final boolean hasGesture() {
            AppMethodBeat.i(153820);
            boolean hasGesture = this.SEW.hasGesture();
            AppMethodBeat.o(153820);
            return hasGesture;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final String getMethod() {
            AppMethodBeat.i(153821);
            String method = this.SEW.getMethod();
            AppMethodBeat.o(153821);
            return method;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public final Map<String, String> getRequestHeaders() {
            AppMethodBeat.i(153822);
            Map<String, String> requestHeaders = this.SEW.getRequestHeaders();
            AppMethodBeat.o(153822);
            return requestHeaders;
        }
    }

    public static class c implements JsResult {
        public com.tencent.xweb.JsResult SEU;

        public c(com.tencent.xweb.JsResult jsResult) {
            this.SEU = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public final void confirm() {
            AppMethodBeat.i(153814);
            this.SEU.confirm();
            AppMethodBeat.o(153814);
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public final void cancel() {
            AppMethodBeat.i(153815);
            this.SEU.cancel();
            AppMethodBeat.o(153815);
        }
    }
}
