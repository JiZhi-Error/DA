package com.tencent.xweb.x5;

import android.net.Uri;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import java.util.Map;

@JgClassChecked(author = 20001, fComment = "checked", lastDate = "20171020", reviewer = 20001, vComment = {EType.JSEXECUTECHECK})
public final class g {

    public static class c implements WebChromeClient.CustomViewCallback {
        IX5WebChromeClient.CustomViewCallback SFd;

        c(IX5WebChromeClient.CustomViewCallback customViewCallback) {
            this.SFd = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.i(153849);
            this.SFd.onCustomViewHidden();
            AppMethodBeat.o(153849);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$g  reason: collision with other inner class name */
    public static class C2234g extends JsResult {
        public com.tencent.smtt.export.external.interfaces.JsResult SFh;

        public C2234g(com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
            this.SFh = jsResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(153854);
            this.SFh.confirm();
            AppMethodBeat.o(153854);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(153855);
            this.SFh.cancel();
            AppMethodBeat.o(153855);
        }
    }

    public static class h extends o {
        public JsPromptResult SFi;

        public h(JsPromptResult jsPromptResult) {
            this.SFi = jsPromptResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(153856);
            this.SFi.confirm();
            AppMethodBeat.o(153856);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(153857);
            this.SFi.cancel();
            AppMethodBeat.o(153857);
        }
    }

    /* renamed from: com.tencent.xweb.x5.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] SFb = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            AppMethodBeat.i(153845);
            try {
                SFb[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                SFb[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                SFb[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                SFb[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                SFb[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 5;
                AppMethodBeat.o(153845);
            } catch (NoSuchFieldError e6) {
                AppMethodBeat.o(153845);
            }
        }
    }

    public static WebResourceResponse a(com.tencent.smtt.export.external.interfaces.WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(153858);
        if (webResourceResponse == null) {
            AppMethodBeat.o(153858);
            return null;
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
        AppMethodBeat.o(153858);
        return webResourceResponse2;
    }

    public static class b implements WebResourceRequest {
        private Map<String, String> JZZ;
        private boolean SEb;
        private boolean SEc;
        private String method;
        private Uri url;

        public b(com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(153848);
            this.url = webResourceRequest.getUrl();
            this.SEb = webResourceRequest.isForMainFrame();
            this.SEc = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            this.JZZ = webResourceRequest.getRequestHeaders();
            AppMethodBeat.o(153848);
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

    public static class e implements GeolocationPermissions.Callback {
        GeolocationPermissionsCallback SFf;

        public e(GeolocationPermissionsCallback geolocationPermissionsCallback) {
            this.SFf = geolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(153853);
            if (this.SFf != null) {
                this.SFf.invoke(str, z, z2);
            }
            AppMethodBeat.o(153853);
        }
    }

    public static class d extends x.a {
        public WebChromeClient.FileChooserParams SFe;

        public d(WebChromeClient.FileChooserParams fileChooserParams) {
            this.SFe = fileChooserParams;
        }

        @Override // com.tencent.xweb.x.a
        public final int getMode() {
            AppMethodBeat.i(153850);
            if (this.SFe != null) {
                int mode = this.SFe.getMode();
                AppMethodBeat.o(153850);
                return mode;
            }
            AppMethodBeat.o(153850);
            return 0;
        }

        @Override // com.tencent.xweb.x.a
        public final String[] getAcceptTypes() {
            AppMethodBeat.i(153851);
            if (this.SFe != null) {
                String[] acceptTypes = this.SFe.getAcceptTypes();
                AppMethodBeat.o(153851);
                return acceptTypes;
            }
            String[] strArr = new String[0];
            AppMethodBeat.o(153851);
            return strArr;
        }

        @Override // com.tencent.xweb.x.a
        public final boolean isCaptureEnabled() {
            AppMethodBeat.i(153852);
            if (this.SFe != null) {
                boolean isCaptureEnabled = this.SFe.isCaptureEnabled();
                AppMethodBeat.o(153852);
                return isCaptureEnabled;
            }
            AppMethodBeat.o(153852);
            return false;
        }
    }

    public static class a implements r {
        SslErrorHandler SFc;

        public a(SslErrorHandler sslErrorHandler) {
            this.SFc = sslErrorHandler;
        }

        @Override // com.tencent.xweb.r
        public final void proceed() {
            AppMethodBeat.i(153846);
            this.SFc.proceed();
            AppMethodBeat.o(153846);
        }

        @Override // com.tencent.xweb.r
        public final void cancel() {
            AppMethodBeat.i(153847);
            this.SFc.cancel();
            AppMethodBeat.o(153847);
        }
    }

    public static class f implements j {
        HttpAuthHandler SFg;

        public f(HttpAuthHandler httpAuthHandler) {
            this.SFg = httpAuthHandler;
        }

        @Override // com.tencent.xweb.j
        public final void cancel() {
            AppMethodBeat.i(207189);
            this.SFg.cancel();
            AppMethodBeat.o(207189);
        }
    }
}
