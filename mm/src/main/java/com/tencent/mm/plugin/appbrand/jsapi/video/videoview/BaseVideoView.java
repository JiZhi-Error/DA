package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class BaseVideoView extends AbstractVideoView {
    protected boolean bzP;
    private boolean jqj = false;
    protected int mwI;
    protected int mwp = 0;
    protected String url;

    /* access modifiers changed from: protected */
    public abstract a ea(Context context);

    public BaseVideoView(Context context) {
        super(context);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void c(boolean z, String str, int i2) {
        this.bzP = z;
        this.url = str;
        this.mwI = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void bIW() {
        if (this.mEE != null) {
            Log.i("MicroMsg.Video.BaseVideoView", "%s preloadVideo url:%s, path:%s", bgQ(), this.url, this.mEE.getVideoPath());
            if (Util.isNullOrNil(this.mEE.getVideoPath())) {
                this.mEE.setVideoPath(this.url);
                this.mEK = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
    public final a dZ(Context context) {
        return ea(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void start() {
        if (this.mEE != null) {
            Log.i("MicroMsg.Video.BaseVideoView", "%s start path [%s] [%s]", bgQ(), this.mEE.getVideoPath(), Util.getStack());
            if (Util.isNullOrNil(this.mEE.getVideoPath())) {
                this.mEE.setVideoPath(this.url);
                this.mEK = true;
                showLoading();
                return;
            }
            this.mEK = true;
            play();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setScaleType(e.h hVar) {
        if (this.mEE instanceof AbstractVideoTextureView) {
            ((AbstractVideoTextureView) this.mEE).setScaleType(hVar);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean aO(float f2) {
        Log.i("MicroMsg.Video.BaseVideoView", "%s set play rate [%f]", bgQ(), Float.valueOf(f2));
        if (this.mEE instanceof AbstractVideoTextureView) {
            return ((AbstractVideoTextureView) this.mEE).aO(f2);
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getVideoDurationSec() {
        if (this.mwI <= 0) {
            return super.getVideoDurationSec();
        }
        return this.mwI;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCacheTimeSec() {
        try {
            if (this.mEE instanceof AbstractVideoTextureView) {
                return (int) (((((float) ((AbstractVideoTextureView) this.mEE).getDownloadPercent()) * 1.0f) / 100.0f) * ((float) super.getVideoDurationSec()));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Video.BaseVideoView", e2, "%s get cache time sec error", bgQ());
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setVideoSource(int i2) {
        this.mwp = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
    public int getVideoSource() {
        return this.mwp;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
    public final void hideLoading() {
        super.hideLoading();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean c(double d2, boolean z) {
        if (!isLive()) {
            return super.c(d2, z);
        }
        Log.w("MicroMsg.Video.BaseVideoView", "%s it is live, don't seek ", bgQ());
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIResume() {
        boolean z = this.mEw;
        super.onUIResume();
        if (this.mEE != null && (this.mEE instanceof AbstractVideoTextureView)) {
            if (this.mEI) {
                play();
                return;
            }
            boolean isShown = isShown();
            Log.i("MicroMsg.Video.BaseVideoView", "onUIResume, oldIsUIAvailable: %b, isShown: %b", Boolean.valueOf(z), Boolean.valueOf(isShown));
            if (!z && isShown) {
                ((AbstractVideoTextureView) this.mEE).bLe();
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView, com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIPause() {
        super.onUIPause();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.b
    public final void ep(int i2, int i3) {
        Log.i("MicroMsg.Video.BaseVideoView", "%s onInfo [%d %d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 701) {
            showLoading();
        } else if (i2 == 702) {
            super.hideLoading();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.AbstractC0719a, com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoView
    public final void onCompletion() {
        if (isLive()) {
            Log.i("MicroMsg.Video.BaseVideoView", "%s it is live video, do not completion", bgQ());
            stop();
            start();
            return;
        }
        super.onCompletion();
        if (this.jqj) {
            c(0.0d, true);
        }
    }

    public void setLoop(boolean z) {
        this.jqj = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isLive() {
        boolean asa = asa();
        int duration = this.mEE != null ? this.mEE.getDuration() : 0;
        if (this.bzP) {
            return true;
        }
        return asa && duration <= 0;
    }
}
