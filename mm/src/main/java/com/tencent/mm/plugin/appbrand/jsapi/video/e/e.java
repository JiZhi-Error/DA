package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.u.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e extends a {
    private MediaPlayer mBq = new k();
    private MediaPlayer.OnPreparedListener mBr = new MediaPlayer.OnPreparedListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass1 */

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(234935);
            e.this.mAT = 2;
            e.this.bKx();
            AppMethodBeat.o(234935);
        }
    };
    private MediaPlayer.OnVideoSizeChangedListener mBs = new MediaPlayer.OnVideoSizeChangedListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass2 */

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            AppMethodBeat.i(234936);
            e.this.ei(i2, i3);
            AppMethodBeat.o(234936);
        }
    };
    private MediaPlayer.OnCompletionListener mBt = new MediaPlayer.OnCompletionListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass3 */

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(234937);
            e.this.mAT = 6;
            e.this.bKy();
            AppMethodBeat.o(234937);
        }
    };
    private MediaPlayer.OnInfoListener mBu = new MediaPlayer.OnInfoListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass4 */

        public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            AppMethodBeat.i(234938);
            boolean ek = e.this.ek(i2, i3);
            AppMethodBeat.o(234938);
            return ek;
        }
    };
    private MediaPlayer.OnSeekCompleteListener mBv = new MediaPlayer.OnSeekCompleteListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass5 */

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.i(234939);
            e.this.bKz();
            AppMethodBeat.o(234939);
        }
    };
    private MediaPlayer.OnErrorListener mBw = new MediaPlayer.OnErrorListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass6 */

        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            AppMethodBeat.i(234940);
            boolean ej = e.this.ej(i2, i3);
            AppMethodBeat.o(234940);
            return ej;
        }
    };
    private MediaPlayer.OnBufferingUpdateListener mBx = new MediaPlayer.OnBufferingUpdateListener() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.video.e.e.AnonymousClass7 */

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            AppMethodBeat.i(234941);
            e.this.xF(i2);
            AppMethodBeat.o(234941);
        }
    };

    public e() {
        AppMethodBeat.i(234942);
        this.mBq.setScreenOnWhilePlaying(true);
        this.mBq.setAudioStreamType(3);
        this.mBq.setOnInfoListener(this.mBu);
        this.mBq.setOnErrorListener(this.mBw);
        this.mBq.setOnPreparedListener(this.mBr);
        this.mBq.setOnCompletionListener(this.mBt);
        this.mBq.setOnSeekCompleteListener(this.mBv);
        this.mBq.setOnVideoSizeChangedListener(this.mBs);
        this.mBq.setOnBufferingUpdateListener(this.mBx);
        AppMethodBeat.o(234942);
    }

    private boolean available() {
        return this.mBq != null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setDataSource(String str) {
        AppMethodBeat.i(234943);
        dU(str, null);
        AppMethodBeat.o(234943);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dU(String str, String str2) {
        AppMethodBeat.i(234944);
        try {
            if (available()) {
                if (str2 == null) {
                    this.mBq.setDataSource(str);
                } else {
                    Log.i("MicroMsg.SameLayer.SystemMediaPlayer", "setDataSource, referrer: ".concat(String.valueOf(str2)));
                    this.mBq.setDataSource(MMApplicationContext.getContext(), Uri.parse(str), d.aaG(str2));
                }
                this.mAT = 1;
            }
            AppMethodBeat.o(234944);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s setDataSource fail", Integer.valueOf(hashCode()));
            xG(-11);
            AppMethodBeat.o(234944);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(234945);
        try {
            if (available()) {
                this.mBq.setSurface(surface);
            }
            AppMethodBeat.o(234945);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s setSurface fail", Integer.valueOf(hashCode()));
            xG(-12);
            AppMethodBeat.o(234945);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setVolume(float f2, float f3) {
        AppMethodBeat.i(234946);
        try {
            if (available()) {
                this.mBq.setVolume(f2, f3);
            }
            AppMethodBeat.o(234946);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s setVolume fail", Integer.valueOf(hashCode()));
            xG(-13);
            AppMethodBeat.o(234946);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final boolean aP(float f2) {
        AppMethodBeat.i(234947);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(234947);
            return false;
        }
        try {
            if (!available() || Build.VERSION.SDK_INT < 23) {
                Log.w("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT));
                AppMethodBeat.o(234947);
                return false;
            }
            PlaybackParams playbackParams = this.mBq.getPlaybackParams();
            playbackParams.setSpeed(f2);
            if (!this.mBq.isPlaying()) {
                this.mBq.setPlaybackParams(playbackParams);
                this.mBq.pause();
            } else {
                this.mBq.setPlaybackParams(playbackParams);
            }
            AppMethodBeat.o(234947);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s setSpeed fail", Integer.valueOf(hashCode()));
            xG(-14);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setMute(boolean z) {
        AppMethodBeat.i(234948);
        if (available()) {
            if (z) {
                setVolume(0.0f, 0.0f);
                AppMethodBeat.o(234948);
                return;
            }
            setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.o(234948);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void setLooping(boolean z) {
        AppMethodBeat.i(234949);
        try {
            if (available()) {
                this.mBq.setLooping(z);
            }
            AppMethodBeat.o(234949);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s setLooping fail", Integer.valueOf(hashCode()));
            xG(-10);
            AppMethodBeat.o(234949);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(234950);
        try {
            if (!(!available() || this.mAT == -1 || this.mAT == -2 || this.mAT == 0 || this.mAT == 1)) {
                z = this.mBq.isPlaying();
                AppMethodBeat.o(234950);
                return z;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s isPlaying fail", Integer.valueOf(hashCode()));
            xG(-9);
        }
        AppMethodBeat.o(234950);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getCurrentPosition() {
        int i2 = 0;
        AppMethodBeat.i(234951);
        try {
            if (available() && (this.mAT == 2 || this.mAT == 3 || this.mAT == 4 || this.mAT == 6)) {
                i2 = this.mBq.getCurrentPosition();
                AppMethodBeat.o(234951);
                return i2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s getCurrentPosition fail", Integer.valueOf(hashCode()));
            xG(-15);
        }
        AppMethodBeat.o(234951);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getDuration() {
        int i2 = 0;
        AppMethodBeat.i(234952);
        try {
            if (!(!available() || this.mAT == -1 || this.mAT == 1 || this.mAT == 0)) {
                i2 = this.mBq.getDuration();
                AppMethodBeat.o(234952);
                return i2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s getDuration fail", Integer.valueOf(hashCode()));
            xG(-16);
        }
        AppMethodBeat.o(234952);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getVideoWidth() {
        int i2 = 0;
        AppMethodBeat.i(234953);
        try {
            if (available()) {
                i2 = this.mBq.getVideoWidth();
                AppMethodBeat.o(234953);
                return i2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s getVideoWidth fail", Integer.valueOf(hashCode()));
            xG(-17);
        }
        AppMethodBeat.o(234953);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final int getVideoHeight() {
        int i2 = 0;
        AppMethodBeat.i(234954);
        try {
            if (available()) {
                i2 = this.mBq.getVideoHeight();
                AppMethodBeat.o(234954);
                return i2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s getVideoHeight fail", Integer.valueOf(hashCode()));
            xG(-18);
        }
        AppMethodBeat.o(234954);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void prepareAsync() {
        AppMethodBeat.i(234955);
        try {
            if (available()) {
                this.mBq.prepareAsync();
            }
            AppMethodBeat.o(234955);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s prepareAsync fail", Integer.valueOf(hashCode()));
            xG(-6);
            AppMethodBeat.o(234955);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void start() {
        AppMethodBeat.i(234956);
        try {
            if (available() && (this.mAT == 2 || this.mAT == 4 || this.mAT == 6)) {
                this.mBq.start();
                this.mAT = 3;
            }
            AppMethodBeat.o(234956);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s start fail", Integer.valueOf(hashCode()));
            xG(-1);
            AppMethodBeat.o(234956);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void pause() {
        AppMethodBeat.i(234957);
        try {
            if (available() && (this.mAT == 2 || this.mAT == 3 || this.mAT == 6)) {
                this.mBq.pause();
                this.mAT = 4;
            }
            AppMethodBeat.o(234957);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s pause fail", Integer.valueOf(hashCode()));
            xG(-2);
            AppMethodBeat.o(234957);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void seekTo(long j2) {
        AppMethodBeat.i(234958);
        try {
            if (available() && (this.mAT == 2 || this.mAT == 3 || this.mAT == 4 || this.mAT == 6)) {
                this.mBq.seekTo((int) j2);
            }
            AppMethodBeat.o(234958);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s seekTo fail", Integer.valueOf(hashCode()));
            xG(-3);
            AppMethodBeat.o(234958);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void stop() {
        AppMethodBeat.i(234959);
        try {
            if (available() && (this.mAT == 2 || this.mAT == 3 || this.mAT == 4 || this.mAT == 6)) {
                this.mBq.stop();
                this.mAT = 5;
            }
            AppMethodBeat.o(234959);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s stop fail", Integer.valueOf(hashCode()));
            xG(-4);
            AppMethodBeat.o(234959);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void reset() {
        AppMethodBeat.i(234960);
        try {
            if (available()) {
                this.mBq.reset();
                this.mAT = 0;
            }
            AppMethodBeat.o(234960);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s reset fail", Integer.valueOf(hashCode()));
            xG(-7);
            AppMethodBeat.o(234960);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a, com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void release() {
        AppMethodBeat.i(234961);
        try {
            if (available()) {
                if (this.mBq != null) {
                    this.mBq.setOnInfoListener(null);
                    this.mBq.setOnErrorListener(null);
                    this.mBq.setOnPreparedListener(null);
                    this.mBq.setOnCompletionListener(null);
                    this.mBq.setOnSeekCompleteListener(null);
                    this.mBq.setOnBufferingUpdateListener(null);
                    this.mBq.setOnVideoSizeChangedListener(null);
                }
                this.mBq.release();
                this.mAT = -2;
                super.release();
            }
            AppMethodBeat.o(234961);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SameLayer.SystemMediaPlayer", e2, "%s release fail", Integer.valueOf(hashCode()));
            xG(-8);
            AppMethodBeat.o(234961);
        }
    }

    private void xG(int i2) {
        AppMethodBeat.i(234962);
        if (this.mBw != null) {
            this.mBw.onError(this.mBq, -1024, i2);
        }
        AppMethodBeat.o(234962);
    }
}
