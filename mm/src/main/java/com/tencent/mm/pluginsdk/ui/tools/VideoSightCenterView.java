package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VideoSightCenterView extends VideoSightView {
    private volatile boolean KwD = false;
    private MediaMetadataRetriever KwE;
    private boolean isStart = false;
    private int zaD = 0;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView, com.tencent.mm.plugin.sight.decode.a.a
    public void setDrawableWidth(int i2) {
        AppMethodBeat.i(116253);
        super.setDrawableWidth(i2);
        crn();
        AppMethodBeat.o(116253);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView, com.tencent.mm.plugin.sight.decode.a.a
    public final void im(int i2, int i3) {
        AppMethodBeat.i(116254);
        super.im(i2, i3);
        crn();
        AppMethodBeat.o(116254);
    }

    private void crn() {
        AppMethodBeat.i(116255);
        if (getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(116255);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView
    public final void init() {
        AppMethodBeat.i(116256);
        if (Util.nullAs(ae.gKE.gHE, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            Log.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            uE(true);
        }
        setOnCompletionListener(new b.e() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sight.decode.a.b.e
            public final void c(b bVar, int i2) {
                AppMethodBeat.i(116251);
                if (-1 == i2) {
                    Log.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", Boolean.valueOf(VideoSightCenterView.this.KwD));
                    if (VideoSightCenterView.this.rso != null && !VideoSightCenterView.this.KwD) {
                        VideoSightCenterView.this.rso.onError(0, 0);
                        AppMethodBeat.o(116251);
                        return;
                    }
                } else if (i2 == 0) {
                    Log.i("MicroMsg.VideoSightCenterView", "normal stop");
                    VideoSightCenterView.this.KwD = true;
                    if (VideoSightCenterView.this.rso != null) {
                        VideoSightCenterView.this.rso.onCompletion();
                    }
                }
                AppMethodBeat.o(116251);
            }
        });
        AppMethodBeat.o(116256);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(116257);
        if (z) {
            setOnDecodeDurationListener(new b.f() {
                /* class com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                public final void b(b bVar, long j2) {
                    AppMethodBeat.i(116252);
                    if (VideoSightCenterView.this.duration == 0) {
                        VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
                    }
                    if (VideoSightCenterView.this.rso != null) {
                        Log.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j2), Integer.valueOf(VideoSightCenterView.this.duration));
                        VideoSightCenterView.this.zaD = (int) (1000 * j2);
                        VideoSightCenterView.this.rso.fh((int) j2, VideoSightCenterView.this.duration);
                    }
                    AppMethodBeat.o(116252);
                }
            });
            AppMethodBeat.o(116257);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(116257);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView, com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(116258);
        Log.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!Util.isNullOrNil(this.cJp)) {
            try {
                if (this.KwE == null) {
                    this.KwE = new d();
                    this.KwE.setDataSource(this.cJp);
                }
                int intValue = Integer.valueOf(this.KwE.extractMetadata(9)).intValue();
                Log.i("MicroMsg.VideoSightCenterView", "getDuration: %s", Integer.valueOf(intValue));
                AppMethodBeat.o(116258);
                return intValue;
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", e2.getMessage());
            }
        }
        int duration = super.getDuration();
        AppMethodBeat.o(116258);
        return duration;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(116259);
        Log.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", Integer.valueOf(this.zaD));
        int i2 = this.zaD;
        AppMethodBeat.o(116259);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        AppMethodBeat.i(116260);
        Log.v("MicroMsg.VideoSightCenterView", "start");
        this.isStart = true;
        boolean start = super.start();
        AppMethodBeat.o(116260);
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(116261);
        Log.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.zaD = 0;
        this.isStart = false;
        AppMethodBeat.o(116261);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(116262);
        Log.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
        AppMethodBeat.o(116262);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        AppMethodBeat.i(116263);
        double lastProgresstime = super.getLastProgresstime();
        AppMethodBeat.o(116263);
        return lastProgresstime;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(116264);
        Log.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", Double.valueOf(d2), Boolean.valueOf(this.isStart), Integer.valueOf(this.zaD), Double.valueOf(getLastProgresstime()));
        if (this.isStart && getLastProgresstime() > 0.0d) {
            super.q(d2 / 1000.0d);
        }
        AppMethodBeat.o(116264);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoSightView, com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        AppMethodBeat.i(116265);
        Log.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", Boolean.valueOf(this.isStart), Integer.valueOf(this.zaD));
        boolean z = this.isStart;
        AppMethodBeat.o(116265);
        return z;
    }
}
