package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import java.util.Map;
import org.xwalk.core.Log;

public final class c {

    public static class e extends JsResult {
        public android.webkit.JsResult SEa;

        public e(android.webkit.JsResult jsResult) {
            this.SEa = jsResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(153664);
            if (this.SEa != null) {
                this.SEa.confirm();
            }
            AppMethodBeat.o(153664);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(153665);
            if (this.SEa != null) {
                this.SEa.cancel();
            }
            AppMethodBeat.o(153665);
        }
    }

    public static WebResourceResponse a(com.tencent.xweb.WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(153667);
        if (webResourceResponse == null) {
            AppMethodBeat.o(153667);
            return null;
        }
        if (webResourceResponse.SAc && Build.VERSION.SDK_INT >= 21) {
            try {
                WebResourceResponse webResourceResponse2 = new WebResourceResponse(webResourceResponse.mMimeType, webResourceResponse.mEncoding, webResourceResponse.mStatusCode, webResourceResponse.mReasonPhrase, webResourceResponse.mResponseHeaders, webResourceResponse.mInputStream);
                AppMethodBeat.o(153667);
                return webResourceResponse2;
            } catch (Exception e2) {
                Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + e2.getMessage());
            }
        }
        WebResourceResponse webResourceResponse3 = new WebResourceResponse(webResourceResponse.mMimeType, webResourceResponse.mEncoding, webResourceResponse.mInputStream);
        if (Build.VERSION.SDK_INT >= 21) {
            if (webResourceResponse.mStatusCode > 100 && webResourceResponse.mReasonPhrase != null && !webResourceResponse.mReasonPhrase.isEmpty()) {
                webResourceResponse3.setStatusCodeAndReasonPhrase(webResourceResponse.mStatusCode, webResourceResponse.mReasonPhrase);
            }
            webResourceResponse3.setResponseHeaders(webResourceResponse.mResponseHeaders);
        }
        AppMethodBeat.o(153667);
        return webResourceResponse3;
    }

    public static class d extends o {
        public JsPromptResult SDZ;

        public d(JsPromptResult jsPromptResult) {
            this.SDZ = jsPromptResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(153662);
            if (this.SDZ != null) {
                this.SDZ.confirm();
            }
            AppMethodBeat.o(153662);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(153663);
            if (this.SDZ != null) {
                this.SDZ.cancel();
            }
            AppMethodBeat.o(153663);
        }
    }

    /* renamed from: com.tencent.xweb.sys.c$c  reason: collision with other inner class name */
    public static class C2232c extends x.a {
        public WebChromeClient.FileChooserParams SDY;

        public C2232c(WebChromeClient.FileChooserParams fileChooserParams) {
            this.SDY = fileChooserParams;
        }

        @Override // com.tencent.xweb.x.a
        @TargetApi(21)
        public final int getMode() {
            AppMethodBeat.i(153659);
            if (this.SDY != null) {
                int mode = this.SDY.getMode();
                AppMethodBeat.o(153659);
                return mode;
            }
            AppMethodBeat.o(153659);
            return 0;
        }

        @Override // com.tencent.xweb.x.a
        @TargetApi(21)
        public final String[] getAcceptTypes() {
            AppMethodBeat.i(153660);
            if (this.SDY != null) {
                String[] acceptTypes = this.SDY.getAcceptTypes();
                AppMethodBeat.o(153660);
                return acceptTypes;
            }
            String[] strArr = new String[0];
            AppMethodBeat.o(153660);
            return strArr;
        }

        @Override // com.tencent.xweb.x.a
        @TargetApi(21)
        public final boolean isCaptureEnabled() {
            AppMethodBeat.i(153661);
            if (this.SDY != null) {
                boolean isCaptureEnabled = this.SDY.isCaptureEnabled();
                AppMethodBeat.o(153661);
                return isCaptureEnabled;
            }
            AppMethodBeat.o(153661);
            return false;
        }
    }

    public static class f implements WebResourceRequest {
        private Map<String, String> JZZ;
        private boolean SEb;
        private boolean SEc;
        com.tencent.xweb.a.a SEd;
        private String method;
        private Uri url;

        public f(android.webkit.WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(153666);
            if (Build.VERSION.SDK_INT >= 21) {
                this.url = webResourceRequest.getUrl();
                this.SEb = webResourceRequest.isForMainFrame();
                this.SEc = webResourceRequest.hasGesture();
                this.method = webResourceRequest.getMethod();
                this.JZZ = webResourceRequest.getRequestHeaders();
                this.SEd = new com.tencent.xweb.a.a(this);
            }
            AppMethodBeat.o(153666);
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public final Uri getUrl() {
            return this.url;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public final boolean isForMainFrame() {
            return this.SEb;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public final boolean hasGesture() {
            return this.SEc;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public final String getMethod() {
            return this.method;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public final Map<String, String> getRequestHeaders() {
            return this.JZZ;
        }
    }

    @JgClassChecked(author = 20001, fComment = "checked", lastDate = "20171024", reviewer = 20001, vComment = {EType.JSEXECUTECHECK})
    public static class a implements r {
        SslErrorHandler SDW;

        public a(SslErrorHandler sslErrorHandler) {
            this.SDW = sslErrorHandler;
        }

        @Override // com.tencent.xweb.r
        public final void proceed() {
            AppMethodBeat.i(153657);
            this.SDW.proceed();
            AppMethodBeat.o(153657);
        }

        @Override // com.tencent.xweb.r
        public final void cancel() {
            AppMethodBeat.i(153658);
            this.SDW.cancel();
            AppMethodBeat.o(153658);
        }
    }

    public static class b implements j {
        HttpAuthHandler SDX;

        public b(HttpAuthHandler httpAuthHandler) {
            this.SDX = httpAuthHandler;
        }

        @Override // com.tencent.xweb.j
        public final void cancel() {
            AppMethodBeat.i(207179);
            this.SDX.cancel();
            AppMethodBeat.o(207179);
        }
    }
}
