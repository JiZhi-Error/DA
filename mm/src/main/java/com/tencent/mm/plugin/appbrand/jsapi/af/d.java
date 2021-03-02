package com.tencent.mm.plugin.appbrand.jsapi.af;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.v;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b&\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016JR\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010&\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010'\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandXWVideoJsCallbackIMPL;", "Lcom/tencent/xweb/VideoJsCallback;", "()V", "webView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "getWebView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setWebView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "onVideoEmptied", "", "onVideoEnded", "onVideoEnterFullscreen", "isVideoTag", "", "id", "", "width", "", "height", "paused", "seeking", "currentTime", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "buffered", "", "onVideoError", "error", "", "msg", "", "onVideoExitFullscreen", "onVideoPause", "onVideoPlay", "onVideoPlaying", "onVideoSeeked", "onVideoSeeking", "onVideoSizeUpdate", "onVideoTimeUpdate", "onVideoWaiting", "Companion", "plugin-appbrand-integration_release"})
public abstract class d implements v {
    @Deprecated
    public static final a mHd = new a((byte) 0);
    private a mHc;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandXWVideoJsCallbackIMPL$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.xweb.v
    public final void onVideoPlaying() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoWaiting() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoSeeking() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoSeeked() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoPlay() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoPause() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoEnded() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoError(int i2, String str) {
        StringBuilder append = new StringBuilder("onVideoError error:").append(i2).append(" msg:").append(str).append(", view[");
        a aVar = this.mHc;
        Log.e("MicroMsg.AppBrandXWVideoJsCallbackIMPL", append.append(aVar != null ? aVar.hashCode() : 0).append(']').toString());
    }

    @Override // com.tencent.xweb.v
    public final void bLx() {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoEnterFullscreen(boolean z, long j2, double d2, double d3, boolean z2, boolean z3, double d4, double d5, double[] dArr) {
        StringBuilder append = new StringBuilder("onVideoEnterFullScreen isVideoTag:").append(z).append(", view[");
        a aVar = this.mHc;
        Log.i("MicroMsg.AppBrandXWVideoJsCallbackIMPL", append.append(aVar != null ? aVar.hashCode() : 0).append(']').toString());
    }

    @Override // com.tencent.xweb.v
    public final void onVideoExitFullscreen() {
        StringBuilder sb = new StringBuilder("onVideoExitFullscreen, view[");
        a aVar = this.mHc;
        Log.i("MicroMsg.AppBrandXWVideoJsCallbackIMPL", sb.append(aVar != null ? aVar.hashCode() : 0).append(']').toString());
    }

    @Override // com.tencent.xweb.v
    public final void onVideoTimeUpdate(double d2, double d3, double[] dArr) {
    }

    @Override // com.tencent.xweb.v
    public final void onVideoSizeUpdate(double d2, double d3) {
    }
}
