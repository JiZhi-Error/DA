package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoSurfaceView extends SurfaceView implements j {
    SurfaceHolder.Callback KwK;
    private int atU;
    private boolean cJi;
    private SurfaceHolder gQc;
    private boolean guh;
    private MediaPlayer mBq;
    MediaPlayer.OnPreparedListener mBr;
    MediaPlayer.OnVideoSizeChangedListener mBs;
    private MediaPlayer.OnCompletionListener mBt;
    private MediaPlayer.OnErrorListener mBw;
    private String mDV;
    private boolean mDW;
    private int mVideoHeight;
    private int mVideoWidth;
    private j.a rso;

    static /* synthetic */ void j(VideoSurfaceView videoSurfaceView) {
        AppMethodBeat.i(116316);
        videoSurfaceView.bLd();
        AppMethodBeat.o(116316);
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(116301);
        this.gQc = null;
        this.mBq = null;
        this.mBs = new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.AnonymousClass1 */

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(116294);
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                Log.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.this.mVideoWidth + " , " + VideoSurfaceView.this.mVideoHeight + " )");
                VideoSurfaceView.c(VideoSurfaceView.this);
                AppMethodBeat.o(116294);
            }
        };
        this.mBr = new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.AnonymousClass2 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(116295);
                VideoSurfaceView.this.mDW = true;
                if (VideoSurfaceView.this.rso != null) {
                    VideoSurfaceView.this.rso.tf();
                }
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoSurfaceView.c(VideoSurfaceView.this);
                if (VideoSurfaceView.this.mVideoWidth == 0 || VideoSurfaceView.this.mVideoHeight == 0) {
                    if (VideoSurfaceView.this.cJi) {
                        VideoSurfaceView.this.mBq.start();
                        VideoSurfaceView.this.cJi = false;
                    }
                } else if (VideoSurfaceView.this.cJi) {
                    VideoSurfaceView.this.mBq.start();
                    VideoSurfaceView.this.cJi = false;
                    AppMethodBeat.o(116295);
                    return;
                }
                AppMethodBeat.o(116295);
            }
        };
        this.mBt = new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.AnonymousClass3 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(116296);
                if (VideoSurfaceView.this.rso != null) {
                    VideoSurfaceView.this.rso.fh(VideoSurfaceView.this.mBq.getCurrentPosition(), VideoSurfaceView.this.mBq.getDuration());
                    VideoSurfaceView.this.rso.onCompletion();
                }
                AppMethodBeat.o(116296);
            }
        };
        this.mBw = new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.AnonymousClass4 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(116297);
                Log.d("MicroMsg.VideoSurfaceView", "Error: " + i2 + "," + i3);
                if (VideoSurfaceView.this.rso != null) {
                    VideoSurfaceView.this.rso.onError(i2, i3);
                }
                AppMethodBeat.o(116297);
                return true;
            }
        };
        this.KwK = new SurfaceHolder.Callback() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.AnonymousClass5 */

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                AppMethodBeat.i(116298);
                Log.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i3), Integer.valueOf(i4));
                if (VideoSurfaceView.this.mBq != null && VideoSurfaceView.this.mDW && VideoSurfaceView.this.mVideoWidth == i3 && VideoSurfaceView.this.mVideoHeight == i4) {
                    VideoSurfaceView.this.mBq.start();
                }
                AppMethodBeat.o(116298);
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(116299);
                Log.i("MicroMsg.VideoSurfaceView", "on surface created");
                VideoSurfaceView.this.gQc = surfaceHolder;
                VideoSurfaceView.j(VideoSurfaceView.this);
                AppMethodBeat.o(116299);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(116300);
                Log.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
                VideoSurfaceView.this.gQc = null;
                if (VideoSurfaceView.this.mBq != null) {
                    VideoSurfaceView.this.rso.fh(VideoSurfaceView.this.mBq.getCurrentPosition(), VideoSurfaceView.this.mBq.getDuration());
                    VideoSurfaceView.this.mBq.reset();
                    VideoSurfaceView.this.mBq.release();
                    VideoSurfaceView.this.mBq = null;
                }
                AppMethodBeat.o(116300);
            }
        };
        this.guh = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.KwK);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.o(116301);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(116302);
        this.mDV = str;
        this.cJi = false;
        bLd();
        requestLayout();
        AppMethodBeat.o(116302);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public String getVideoPath() {
        return this.mDV;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(116303);
        if (this.mBq != null) {
            this.mBq.stop();
            this.mBq.release();
            this.mBq = null;
        }
        AppMethodBeat.o(116303);
    }

    private void bLd() {
        AppMethodBeat.i(116304);
        if (this.mDV == null || this.gQc == null) {
            AppMethodBeat.o(116304);
            return;
        }
        if (this.mBq != null) {
            this.mBq.stop();
            this.mBq.release();
            this.mBq = null;
        }
        try {
            this.mBq = new k();
            this.mBq.setOnPreparedListener(this.mBr);
            this.mBq.setOnVideoSizeChangedListener(this.mBs);
            this.mDW = false;
            Log.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
            this.atU = -1;
            this.mBq.setOnCompletionListener(this.mBt);
            this.mBq.setOnErrorListener(this.mBw);
            this.mBq.setDataSource(this.mDV);
            this.mBq.setDisplay(this.gQc);
            this.mBq.setAudioStreamType(3);
            this.mBq.setScreenOnWhilePlaying(true);
            this.mBq.prepareAsync();
            this.mVideoHeight = this.mBq.getVideoHeight();
            this.mVideoWidth = this.mBq.getVideoWidth();
            setMute(this.guh);
            AppMethodBeat.o(116304);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoSurfaceView", e2, "prepare async error %s", e2.getMessage());
            if (this.rso != null) {
                this.rso.onError(-1, -1);
            }
            AppMethodBeat.o(116304);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(116305);
        if (this.mBq != null && this.mDW && this.mBq.isPlaying()) {
            this.mBq.pause();
        }
        this.cJi = false;
        AppMethodBeat.o(116305);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(116306);
        if (this.mBq == null || !this.mDW) {
            this.atU = -1;
            int i2 = this.atU;
            AppMethodBeat.o(116306);
            return i2;
        } else if (this.atU > 0) {
            int i3 = this.atU;
            AppMethodBeat.o(116306);
            return i3;
        } else {
            this.atU = this.mBq.getDuration();
            int i4 = this.atU;
            AppMethodBeat.o(116306);
            return i4;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(116307);
        if (this.mBq == null || !this.mDW) {
            AppMethodBeat.o(116307);
            return 0;
        }
        int currentPosition = this.mBq.getCurrentPosition();
        AppMethodBeat.o(116307);
        return currentPosition;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        AppMethodBeat.i(116308);
        if (this.mBq == null || !this.mDW) {
            AppMethodBeat.o(116308);
            return false;
        }
        boolean isPlaying = this.mBq.isPlaying();
        AppMethodBeat.o(116308);
        return isPlaying;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
        AppMethodBeat.i(116309);
        if (this.mBq != null) {
            this.mBq.setLooping(z);
        }
        AppMethodBeat.o(116309);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoCallback(j.a aVar) {
        this.rso = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void onDetach() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        AppMethodBeat.i(116310);
        if (this.mBq == null || !this.mDW) {
            this.cJi = true;
        } else {
            this.mBq.start();
            this.cJi = false;
        }
        AppMethodBeat.o(116310);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        AppMethodBeat.i(116311);
        boolean start = start();
        AppMethodBeat.o(116311);
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setThumb(Bitmap bitmap) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        return 0.0d;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(116312);
        if (this.mBq != null) {
            Log.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(d2)));
            this.mBq.seekTo((int) d2);
            start();
        }
        AppMethodBeat.o(116312);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(116313);
        this.guh = z;
        if (this.mBq != null) {
            if (this.guh) {
                this.mBq.setVolume(0.0f, 0.0f);
                AppMethodBeat.o(116313);
                return;
            }
            this.mBq.setVolume(0.5f, 0.5f);
        }
        AppMethodBeat.o(116313);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(116314);
        q(d2);
        AppMethodBeat.o(116314);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOneTimeVideoTextureUpdateCallback(j.e eVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSeekCompleteCallback(j.c cVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnInfoCallback(j.b bVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
    }

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        int i2;
        int i3;
        AppMethodBeat.i(116315);
        if (videoSurfaceView.mVideoHeight == 0 || videoSurfaceView.mVideoWidth == 0) {
            AppMethodBeat.o(116315);
            return;
        }
        int i4 = videoSurfaceView.mVideoWidth;
        int i5 = videoSurfaceView.mVideoHeight;
        Log.v("MicroMsg.VideoSurfaceView", "video size before:" + i4 + "   " + i5);
        Log.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
        int width = videoSurfaceView.getWidth();
        int height = videoSurfaceView.getHeight();
        if (width <= 0) {
            i2 = i4;
        } else {
            i2 = width;
        }
        if (height <= 0) {
            i3 = i5;
        } else {
            i3 = height;
        }
        float f2 = (((float) i2) * 1.0f) / ((float) i4);
        float f3 = (((float) i3) * 1.0f) / ((float) i5);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoSurfaceView.getLayoutParams();
        if (f2 > f3) {
            layoutParams.width = (int) (((float) i4) * f3);
            layoutParams.height = i3;
        } else {
            layoutParams.width = i2;
            layoutParams.height = (int) (((float) i5) * f2);
        }
        layoutParams.addRule(13);
        videoSurfaceView.setLayoutParams(layoutParams);
        Log.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.mBq.getVideoWidth() + "   " + videoSurfaceView.mBq.getVideoHeight());
        Log.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.o(116315);
    }
}
