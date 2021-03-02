package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.o;
import com.tencent.xweb.q;
import com.tencent.xweb.r;
import java.io.File;
import java.util.Map;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLongScreenshotCallback;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

public final class g {

    public static class a implements WebChromeClient.CustomViewCallback {
        CustomViewCallback SGR;

        a(CustomViewCallback customViewCallback) {
            this.SGR = customViewCallback;
        }

        public final void onCustomViewHidden() {
            AppMethodBeat.i(154265);
            this.SGR.onCustomViewHidden();
            AppMethodBeat.o(154265);
        }
    }

    public static class c extends JsResult {
        public XWalkJavascriptResult SGT;

        public c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.SGT = xWalkJavascriptResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
            AppMethodBeat.i(154267);
            this.SGT.confirmWithResult(str);
            AppMethodBeat.o(154267);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(154268);
            this.SGT.confirm();
            AppMethodBeat.o(154268);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(154269);
            this.SGT.cancel();
            AppMethodBeat.o(154269);
        }
    }

    public static class e extends o {
        public XWalkJavascriptResult SGT;

        public e(XWalkJavascriptResult xWalkJavascriptResult) {
            this.SGT = xWalkJavascriptResult;
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirmWithResult(String str) {
            AppMethodBeat.i(154275);
            this.SGT.confirmWithResult(str);
            AppMethodBeat.o(154275);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void confirm() {
            AppMethodBeat.i(154276);
            this.SGT.confirm();
            AppMethodBeat.o(154276);
        }

        @Override // org.xwalk.core.XWalkJavascriptResult
        public final void cancel() {
            AppMethodBeat.i(154277);
            this.SGT.cancel();
            AppMethodBeat.o(154277);
        }
    }

    public static class f extends XWalkDownloadListener {
        DownloadListener SES;

        public f(Context context, DownloadListener downloadListener) {
            super(context);
            this.SES = downloadListener;
        }

        @Override // org.xwalk.core.XWalkDownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            AppMethodBeat.i(154278);
            if (this.SES != null) {
                this.SES.onDownloadStart(str, str2, str3, str4, j2);
            }
            AppMethodBeat.o(154278);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.g$g  reason: collision with other inner class name */
    public static class C2236g extends XWalkFindListener {
        WebView.FindListener SET;

        public C2236g(WebView.FindListener findListener) {
            this.SET = findListener;
        }

        @Override // org.xwalk.core.XWalkFindListener
        public final void onFindResultReceived(int i2, int i3, boolean z) {
            AppMethodBeat.i(154279);
            if (this.SET != null) {
                this.SET.onFindResultReceived(i2, i3, z);
            }
            AppMethodBeat.o(154279);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] SGQ = new int[XWalkUIClient.ConsoleMessageType.values().length];

        static {
            AppMethodBeat.i(154264);
            try {
                SGQ[XWalkUIClient.ConsoleMessageType.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                SGQ[XWalkUIClient.ConsoleMessageType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                SGQ[XWalkUIClient.ConsoleMessageType.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                SGQ[XWalkUIClient.ConsoleMessageType.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                SGQ[XWalkUIClient.ConsoleMessageType.WARNING.ordinal()] = 5;
                AppMethodBeat.o(154264);
            } catch (NoSuchFieldError e6) {
                AppMethodBeat.o(154264);
            }
        }
    }

    public static class i implements WebResourceRequest {
        private boolean Isw;
        private Map<String, String> JZZ;
        private boolean SEb;
        private boolean SEc;
        com.tencent.xweb.a.a SEd;
        private String method;
        private Uri url;

        public i(XWalkWebResourceRequest xWalkWebResourceRequest) {
            AppMethodBeat.i(154282);
            this.url = xWalkWebResourceRequest.getUrl();
            this.SEb = xWalkWebResourceRequest.isForMainFrame();
            this.SEc = xWalkWebResourceRequest.hasGesture();
            this.method = xWalkWebResourceRequest.getMethod();
            this.JZZ = xWalkWebResourceRequest.getRequestHeaders();
            this.SEd = new com.tencent.xweb.a.a(this);
            AppMethodBeat.o(154282);
        }

        public i(String str, String str2, boolean z, boolean z2, boolean z3) {
            AppMethodBeat.i(154283);
            try {
                this.url = Uri.parse(str);
            } catch (Exception e2) {
                Log.e("WebResourceRequestImpl", "parse url failed , url = ".concat(String.valueOf(str)));
            }
            this.SEb = z;
            this.SEc = z2;
            this.method = str2;
            this.Isw = z3;
            AppMethodBeat.o(154283);
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

    public static WebResourceResponse a(XWalkWebResourceResponse xWalkWebResourceResponse) {
        AppMethodBeat.i(154284);
        if (xWalkWebResourceResponse == null) {
            AppMethodBeat.o(154284);
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData());
        AppMethodBeat.o(154284);
        return webResourceResponse;
    }

    public static class b implements GeolocationPermissions.Callback {
        XWalkGeolocationPermissionsCallback SGS;

        public b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.SGS = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(154266);
            if (this.SGS != null) {
                this.SGS.invoke(str, z, z2);
            }
            AppMethodBeat.o(154266);
        }
    }

    public static class h implements r {
        ValueCallback<Boolean> SGV;

        public h(ValueCallback<Boolean> valueCallback) {
            this.SGV = valueCallback;
        }

        @Override // com.tencent.xweb.r
        public final void proceed() {
            AppMethodBeat.i(154280);
            this.SGV.onReceiveValue(Boolean.TRUE);
            AppMethodBeat.o(154280);
        }

        @Override // com.tencent.xweb.r
        public final void cancel() {
            AppMethodBeat.i(154281);
            this.SGV.onReceiveValue(Boolean.FALSE);
            AppMethodBeat.o(154281);
        }
    }

    public static class d extends XWalkLongScreenshotCallback {
        private q SGU;

        public d(q qVar) {
            this.SGU = qVar;
        }

        @Override // org.xwalk.core.XWalkLongScreenshotCallback, com.tencent.xweb.q
        public final void onLongScreenshotFinished(int i2, String str) {
            AppMethodBeat.i(154270);
            this.SGU.onLongScreenshotFinished(i2, str);
            AppMethodBeat.o(154270);
        }

        @Override // org.xwalk.core.XWalkLongScreenshotCallback, com.tencent.xweb.q
        public final File getCacheFileDir() {
            AppMethodBeat.i(154271);
            File cacheFileDir = this.SGU.getCacheFileDir();
            AppMethodBeat.o(154271);
            return cacheFileDir;
        }

        @Override // org.xwalk.core.XWalkLongScreenshotCallback, com.tencent.xweb.q
        public final File getResultFileDir() {
            AppMethodBeat.i(154272);
            File resultFileDir = this.SGU.getResultFileDir();
            AppMethodBeat.o(154272);
            return resultFileDir;
        }

        @Override // org.xwalk.core.XWalkLongScreenshotCallback, com.tencent.xweb.q
        public final Bitmap overrideScreenshot(Bitmap bitmap) {
            AppMethodBeat.i(154273);
            Bitmap overrideScreenshot = this.SGU.overrideScreenshot(bitmap);
            AppMethodBeat.o(154273);
            return overrideScreenshot;
        }

        @Override // org.xwalk.core.XWalkLongScreenshotCallback, com.tencent.xweb.q
        public final int getMaxHeightSupported() {
            AppMethodBeat.i(154274);
            int maxHeightSupported = this.SGU.getMaxHeightSupported();
            AppMethodBeat.o(154274);
            return maxHeightSupported;
        }
    }

    public static class j implements com.tencent.xweb.j {
        XWalkHttpAuthHandler SGW;

        public j(XWalkHttpAuthHandler xWalkHttpAuthHandler) {
            this.SGW = xWalkHttpAuthHandler;
        }

        @Override // com.tencent.xweb.j
        public final void cancel() {
            AppMethodBeat.i(207289);
            this.SGW.cancel();
            AppMethodBeat.o(207289);
        }
    }
}
