package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTimelineVideoView extends OfflineVideoView {
    private boolean FeD;
    public boolean vbV;

    public SnsAdTimelineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SnsAdTimelineVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.EtA = false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void start() {
        AppMethodBeat.i(179384);
        boolean fgf = fgf();
        Log.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.vbV + ", shouldPlayWhenPrepared=" + this.EtA + ", isPlaying=" + fgf);
        if (this.vbV || !this.EtA) {
            if (!fgf) {
                Log.i("MicroMsg.SnsAdTimelineVideoView", "do start");
                super.start();
            }
            AppMethodBeat.o(179384);
            return;
        }
        AppMethodBeat.o(179384);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void pause() {
        AppMethodBeat.i(179385);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "pause");
        super.fgd();
        AppMethodBeat.o(179385);
    }

    public void setShouldPlayWhenPrepared(boolean z) {
        AppMethodBeat.i(179386);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(z)));
        this.EtA = z;
        AppMethodBeat.o(179386);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(179387);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", getVideoPath(), Boolean.valueOf(this.EtA));
        if (this.EtA) {
            super.tf();
        }
        this.vbV = true;
        AppMethodBeat.o(179387);
    }

    public final void restart() {
        AppMethodBeat.i(179388);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.FeD);
        if (this.FeD) {
            super.aT(0, true);
        }
        AppMethodBeat.o(179388);
    }

    public final void clear() {
        AppMethodBeat.i(179389);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "clear");
        super.onDestroy();
        this.FeD = false;
        this.EtA = false;
        this.vbV = false;
        Log.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
        AppMethodBeat.o(179389);
    }

    public final void seekTo(int i2) {
        AppMethodBeat.i(179390);
        aT(i2, true);
        AppMethodBeat.o(179390);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void aT(int i2, boolean z) {
        AppMethodBeat.i(203988);
        super.aT(i2, z);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + i2 + ", afterSeekPlay=" + z);
        AppMethodBeat.o(203988);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(179391);
        String videoPath = getVideoPath();
        Log.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.FeD + ", path=" + str + ", oldPath=" + videoPath);
        if (!this.FeD || (str != null && !str.equals(videoPath))) {
            super.asy(str);
            this.FeD = true;
        }
        AppMethodBeat.o(179391);
    }

    public void setThumpViewScaleType(ImageView.ScaleType scaleType) {
        AppMethodBeat.i(203989);
        if (this.tiQ != null) {
            this.tiQ.setScaleType(scaleType);
        }
        AppMethodBeat.o(203989);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(179392);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(bitmap)));
        if (this.tiQ != null) {
            this.tiQ.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(179392);
    }

    public void setThumbDrawable(Drawable drawable) {
        AppMethodBeat.i(179393);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(drawable)));
        if (this.tiQ != null) {
            this.tiQ.setImageDrawable(drawable);
        }
        AppMethodBeat.o(179393);
    }

    public Drawable getThumbDrawable() {
        AppMethodBeat.i(179394);
        if (this.tiQ != null) {
            Drawable drawable = this.tiQ.getDrawable();
            AppMethodBeat.o(179394);
            return drawable;
        }
        AppMethodBeat.o(179394);
        return null;
    }

    public final boolean isError() {
        AppMethodBeat.i(179395);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.tmZ);
        boolean z = this.tmZ;
        AppMethodBeat.o(179395);
        return z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void showLoading() {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(179396);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.SnsAdTimelineVideoView", "onDetachedFromWindow");
        clear();
        AppMethodBeat.o(179396);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void startTimer() {
        AppMethodBeat.i(179397);
        super.startTimer();
        Log.i("MicroMsg.SnsAdTimelineVideoView", "startTimer:" + getTimerInterval());
        AppMethodBeat.o(179397);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void fgc() {
        AppMethodBeat.i(179398);
        super.fgc();
        Log.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
        AppMethodBeat.o(179398);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void d(boolean z, float f2) {
        AppMethodBeat.i(179399);
        super.d(z, f2);
        Log.i("MicroMsg.SnsAdTimelineVideoView", "switchVideoModel: thumVis=" + (this.tiQ.getVisibility() == 0));
        AppMethodBeat.o(179399);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView
    public final void Zz(int i2) {
        AppMethodBeat.i(179400);
        super.Zz(i2);
        Log.d("MicroMsg.SnsAdTimelineVideoView", "updateVideoUI: thumVis=" + (this.tiQ.getVisibility() == 0) + ", ms=" + i2 + ", second=" + (i2 / 1000));
        AppMethodBeat.o(179400);
    }

    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(203990);
        super.onError(i2, i3);
        h.INSTANCE.dN(1579, 7);
        AppMethodBeat.o(203990);
    }
}
