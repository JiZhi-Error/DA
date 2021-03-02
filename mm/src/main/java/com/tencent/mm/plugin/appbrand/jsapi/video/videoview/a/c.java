package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.tav.core.AssetExtension;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0001J\t\u0010\b\u001a\u00020\u0007H\u0001J\t\u0010\t\u001a\u00020\u0007H\u0001J\t\u0010\n\u001a\u00020\u0007H\u0001J\t\u0010\u000b\u001a\u00020\u0007H\u0001J\u0011\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u0001J\t\u0010\u0012\u001a\u00020\u0010H\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0001J\t\u0010\u0015\u001a\u00020\u0014H\u0001J\t\u0010\u0016\u001a\u00020\u0014H\u0001J\t\u0010\u0017\u001a\u00020\u0010H\u0001J\t\u0010\u0018\u001a\u00020\u0010H\u0001J\t\u0010\u0019\u001a\u00020\u0014H\u0001J\t\u0010\u001a\u001a\u00020\u0014H\u0001J\u0011\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0001J\u0019\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0001J\u0019\u0010\u001f\u001a\u00020\u00142\u000e\u0010 \u001a\n \u000e*\u0004\u0018\u00010!0!H\u0001J\u0011\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0007H\u0001J\u0019\u0010$\u001a\u00020\u00142\u000e\u0010%\u001a\n \u000e*\u0004\u0018\u00010&0&H\u0001J\u0011\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0010H\u0001J\u0011\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0010H\u0001J\u0011\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0001J\u0019\u0010.\u001a\u00020\u00142\u000e\u0010/\u001a\n \u000e*\u0004\u0018\u00010000H\u0001J\u0019\u00101\u001a\u00020\u00142\u000e\u00102\u001a\n \u000e*\u0004\u0018\u00010303H\u0001J)\u00104\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u00105\u001a\n \u000e*\u0004\u0018\u000106062\u0006\u00107\u001a\u00020\u0007H\u0001J\u0011\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0007H\u0001J\t\u0010:\u001a\u00020\u0014H\u0001J\t\u0010;\u001a\u00020\u0014H\u0001R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/exo/AppBrandExoVideoViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;", "context", "Landroid/content/Context;", "videoView", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView;)V", "getCacheTimeSec", "", "getCurrPosMs", "getCurrPosSec", "getPlayerType", "getVideoDurationSec", "getView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isLive", "", "isPlaying", "onSingleTap", "onUIDestroy", "", "onUIPause", "onUIResume", "pause", AssetExtension.SCENE_PLAY, "preloadVideo", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "setCover", "bitmap", "Landroid/graphics/Bitmap;", "setFullDirection", TencentLocation.EXTRA_DIRECTION, "setIMMVideoViewCallback", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPlayRate", "playRate", "", "setScaleType", "scaleType", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$ScaleType;", "setVideoFooterView", "footer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoFooter;", "setVideoPath", "url", "", "durationSec", "setVideoSource", "videoSource", "start", "stop", "luggage-commons-jsapi-video-ext_release"})
public final class c implements e {
    private final e mwC;

    public c(Context context, byte b2) {
        this(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean aO(float f2) {
        AppMethodBeat.i(235271);
        boolean aO = this.mwC.aO(f2);
        AppMethodBeat.o(235271);
        return aO;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void bIW() {
        AppMethodBeat.i(235263);
        this.mwC.bIW();
        AppMethodBeat.o(235263);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(235274);
        this.mwC.c(z, str, i2);
        AppMethodBeat.o(235274);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(235265);
        boolean c2 = this.mwC.c(d2, z);
        AppMethodBeat.o(235265);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCacheTimeSec() {
        AppMethodBeat.i(235251);
        int cacheTimeSec = this.mwC.getCacheTimeSec();
        AppMethodBeat.o(235251);
        return cacheTimeSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCurrPosMs() {
        AppMethodBeat.i(235252);
        int currPosMs = this.mwC.getCurrPosMs();
        AppMethodBeat.o(235252);
        return currPosMs;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCurrPosSec() {
        AppMethodBeat.i(235253);
        int currPosSec = this.mwC.getCurrPosSec();
        AppMethodBeat.o(235253);
        return currPosSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getPlayerType() {
        AppMethodBeat.i(235254);
        int playerType = this.mwC.getPlayerType();
        AppMethodBeat.o(235254);
        return playerType;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getVideoDurationSec() {
        AppMethodBeat.i(235255);
        int videoDurationSec = this.mwC.getVideoDurationSec();
        AppMethodBeat.o(235255);
        return videoDurationSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final View getView() {
        AppMethodBeat.i(235256);
        View view = this.mwC.getView();
        AppMethodBeat.o(235256);
        return view;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isLive() {
        AppMethodBeat.i(235257);
        boolean isLive = this.mwC.isLive();
        AppMethodBeat.o(235257);
        return isLive;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isPlaying() {
        AppMethodBeat.i(235258);
        boolean isPlaying = this.mwC.isPlaying();
        AppMethodBeat.o(235258);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIDestroy() {
        AppMethodBeat.i(235259);
        this.mwC.onUIDestroy();
        AppMethodBeat.o(235259);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIPause() {
        AppMethodBeat.i(235260);
        this.mwC.onUIPause();
        AppMethodBeat.o(235260);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIResume() {
        AppMethodBeat.i(235261);
        this.mwC.onUIResume();
        AppMethodBeat.o(235261);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean p(double d2) {
        AppMethodBeat.i(235264);
        boolean p = this.mwC.p(d2);
        AppMethodBeat.o(235264);
        return p;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean pause() {
        AppMethodBeat.i(235262);
        boolean pause = this.mwC.pause();
        AppMethodBeat.o(235262);
        return pause;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setCover(Bitmap bitmap) {
        AppMethodBeat.i(235266);
        this.mwC.setCover(bitmap);
        AppMethodBeat.o(235266);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setFullDirection(int i2) {
        AppMethodBeat.i(235267);
        this.mwC.setFullDirection(i2);
        AppMethodBeat.o(235267);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setIMMVideoViewCallback(e.c cVar) {
        AppMethodBeat.i(235268);
        this.mwC.setIMMVideoViewCallback(cVar);
        AppMethodBeat.o(235268);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(235269);
        this.mwC.setIsShowBasicControls(z);
        AppMethodBeat.o(235269);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setMute(boolean z) {
        AppMethodBeat.i(235270);
        this.mwC.setMute(z);
        AppMethodBeat.o(235270);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setScaleType(e.h hVar) {
        AppMethodBeat.i(235272);
        this.mwC.setScaleType(hVar);
        AppMethodBeat.o(235272);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setVideoFooterView(e.b bVar) {
        AppMethodBeat.i(235273);
        this.mwC.setVideoFooterView(bVar);
        AppMethodBeat.o(235273);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setVideoSource(int i2) {
        AppMethodBeat.i(235275);
        this.mwC.setVideoSource(i2);
        AppMethodBeat.o(235275);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void start() {
        AppMethodBeat.i(235276);
        this.mwC.start();
        AppMethodBeat.o(235276);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void stop() {
        AppMethodBeat.i(235277);
        this.mwC.stop();
        AppMethodBeat.o(235277);
    }

    private c(e eVar) {
        p.h(eVar, "videoView");
        AppMethodBeat.i(235249);
        this.mwC = eVar;
        AppMethodBeat.o(235249);
    }

    private /* synthetic */ c(Context context) {
        this(new b(context));
        AppMethodBeat.i(235250);
        AppMethodBeat.o(235250);
    }
}
