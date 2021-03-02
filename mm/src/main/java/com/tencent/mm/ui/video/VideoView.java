package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class VideoView extends SurfaceView {
    SurfaceHolder.Callback KwK;
    private MediaPlayer.OnPreparedListener QAX;
    private int QAY;
    private int QAZ;
    private a QBa;
    private int atU;
    public boolean cJi;
    private SurfaceHolder gQc;
    private MediaPlayer.OnCompletionListener juS;
    private MediaPlayer.OnErrorListener juT;
    public MediaPlayer mBq;
    MediaPlayer.OnPreparedListener mBr;
    MediaPlayer.OnVideoSizeChangedListener mBs;
    private MediaPlayer.OnCompletionListener mBt;
    private MediaPlayer.OnErrorListener mBw;
    private MediaPlayer.OnBufferingUpdateListener mBx;
    private Context mContext;
    private String mDV;
    public boolean mDW;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    public interface a {
    }

    static /* synthetic */ void q(VideoView videoView) {
        AppMethodBeat.i(39510);
        videoView.bLd();
        AppMethodBeat.o(39510);
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final void gYz() {
        int i2;
        int i3;
        AppMethodBeat.i(39498);
        if (this.mVideoHeight == 0 || this.mVideoWidth == 0) {
            AppMethodBeat.o(39498);
            return;
        }
        int i4 = this.mVideoWidth;
        int i5 = this.mVideoHeight;
        Log.v("MicroMsg.VideoView", "video size before:" + i4 + "   " + i5);
        Log.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
        int width = getWidth();
        int height = getHeight();
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (f2 > f3) {
            layoutParams.width = (int) (((float) i4) * f3);
            layoutParams.height = i3;
        } else {
            layoutParams.width = i2;
            layoutParams.height = (int) (((float) i5) * f2);
        }
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        invalidate();
        Log.v("MicroMsg.VideoView", "video size after:" + this.mBq.getVideoWidth() + "   " + this.mBq.getVideoHeight());
        Log.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        AppMethodBeat.o(39498);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(39499);
        this.mContext = context;
        gYA();
        AppMethodBeat.o(39499);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39500);
        this.gQc = null;
        this.mBq = null;
        this.mBs = new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass1 */

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(39490);
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                Log.v("MicroMsg.VideoView", "on size change size:( " + VideoView.this.mVideoWidth + " , " + VideoView.this.mVideoHeight + " )");
                VideoView.this.gYz();
                if (VideoView.this.mVideoWidth != 0) {
                    int unused = VideoView.this.mVideoHeight;
                }
                AppMethodBeat.o(39490);
            }
        };
        this.mBr = new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass2 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(39491);
                VideoView.this.mDW = true;
                if (VideoView.this.QAX != null) {
                    VideoView.this.QAX.onPrepared(VideoView.this.mBq);
                }
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoView.this.gYz();
                if (VideoView.this.mVideoWidth == 0 || VideoView.this.mVideoHeight == 0) {
                    if (VideoView.this.QAZ != 0) {
                        VideoView.this.mBq.seekTo(VideoView.this.QAZ);
                        VideoView.this.QAZ = 0;
                    }
                    if (VideoView.this.cJi) {
                        VideoView.this.mBq.start();
                        VideoView.this.cJi = false;
                    }
                } else {
                    if (VideoView.this.cJi) {
                        VideoView.this.mBq.start();
                        VideoView.this.cJi = false;
                    }
                    if (VideoView.this.mSurfaceWidth == VideoView.this.mVideoWidth && VideoView.this.mSurfaceHeight == VideoView.this.mVideoHeight) {
                        if (VideoView.this.QAZ != 0) {
                            VideoView.this.mBq.seekTo(VideoView.this.QAZ);
                            VideoView.this.QAZ = 0;
                        }
                        if (VideoView.this.cJi || VideoView.this.isPlaying() || VideoView.this.QAZ != 0 || VideoView.this.getCurrentPosition() > 0) {
                        }
                    }
                }
                if (VideoView.this.mBq.isPlaying() && VideoView.this.QBa != null) {
                    a unused = VideoView.this.QBa;
                    String unused2 = VideoView.this.mDV;
                }
                AppMethodBeat.o(39491);
            }
        };
        this.mBt = new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass3 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(39492);
                if (VideoView.this.juS != null) {
                    VideoView.this.juS.onCompletion(VideoView.this.mBq);
                }
                AppMethodBeat.o(39492);
            }
        };
        this.mBw = new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass4 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(39493);
                Log.d("MicroMsg.VideoView", "Error: " + i2 + "," + i3);
                if (VideoView.this.juT == null || !VideoView.this.juT.onError(VideoView.this.mBq, i2, i3)) {
                    VideoView.this.getWindowToken();
                    AppMethodBeat.o(39493);
                } else {
                    AppMethodBeat.o(39493);
                }
                return true;
            }
        };
        this.mBx = new MediaPlayer.OnBufferingUpdateListener() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass5 */

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                AppMethodBeat.i(39494);
                VideoView.this.QAY = i2;
                AppMethodBeat.o(39494);
            }
        };
        this.KwK = new SurfaceHolder.Callback() {
            /* class com.tencent.mm.ui.video.VideoView.AnonymousClass6 */

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                AppMethodBeat.i(39495);
                VideoView.this.mSurfaceWidth = i3;
                VideoView.this.mSurfaceHeight = i4;
                if (VideoView.this.mBq != null && VideoView.this.mDW && VideoView.this.mVideoWidth == i3 && VideoView.this.mVideoHeight == i4) {
                    if (VideoView.this.QAZ != 0) {
                        VideoView.this.mBq.seekTo(VideoView.this.QAZ);
                        VideoView.this.QAZ = 0;
                    }
                    VideoView.this.mBq.start();
                }
                AppMethodBeat.o(39495);
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(39496);
                VideoView.this.gQc = surfaceHolder;
                VideoView.q(VideoView.this);
                AppMethodBeat.o(39496);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(39497);
                VideoView.this.gQc = null;
                if (VideoView.this.mBq != null) {
                    VideoView.this.mBq.reset();
                    VideoView.this.mBq.release();
                    VideoView.this.mBq = null;
                }
                AppMethodBeat.o(39497);
            }
        };
        this.mContext = context;
        gYA();
        AppMethodBeat.o(39500);
    }

    private void gYA() {
        AppMethodBeat.i(39501);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.KwK);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        AppMethodBeat.o(39501);
    }

    public void setVideoURI(String str) {
        AppMethodBeat.i(39502);
        this.mDV = str;
        this.cJi = false;
        this.QAZ = 0;
        bLd();
        requestLayout();
        invalidate();
        AppMethodBeat.o(39502);
    }

    public String getVideoURI() {
        return this.mDV;
    }

    public void setLooping(boolean z) {
        AppMethodBeat.i(39503);
        if (this.mBq != null) {
            this.mBq.setLooping(z);
        }
        AppMethodBeat.o(39503);
    }

    public final void stopPlayback() {
        AppMethodBeat.i(39504);
        if (this.mBq != null) {
            this.mBq.stop();
            this.mBq.release();
            this.mBq = null;
        }
        AppMethodBeat.o(39504);
    }

    public int getVideoTimeLeft() {
        AppMethodBeat.i(39505);
        if (this.mBq == null) {
            AppMethodBeat.o(39505);
            return 0;
        }
        int duration = this.mBq.getDuration() - this.mBq.getCurrentPosition();
        AppMethodBeat.o(39505);
        return duration;
    }

    private void bLd() {
        AppMethodBeat.i(39506);
        if (this.mDV == null || this.gQc == null) {
            AppMethodBeat.o(39506);
            return;
        }
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        this.mContext.sendBroadcast(intent);
        if (this.mBq != null) {
            this.mBq.reset();
            this.mBq.release();
            this.mBq = null;
        }
        try {
            this.mBq = new k();
            this.mBq.setOnPreparedListener(this.mBr);
            this.mBq.setOnVideoSizeChangedListener(this.mBs);
            this.mDW = false;
            Log.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
            this.atU = -1;
            this.mBq.setOnCompletionListener(this.mBt);
            this.mBq.setOnErrorListener(this.mBw);
            this.mBq.setOnBufferingUpdateListener(this.mBx);
            this.QAY = 0;
            this.mBq.setDataSource(this.mDV);
            this.mBq.setDisplay(this.gQc);
            this.mBq.setAudioStreamType(3);
            this.mBq.setScreenOnWhilePlaying(true);
            this.mBq.prepareAsync();
            this.mVideoHeight = this.mBq.getVideoHeight();
            this.mVideoWidth = this.mBq.getVideoWidth();
            AppMethodBeat.o(39506);
        } catch (IOException e2) {
            AppMethodBeat.o(39506);
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(39506);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.QAX = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.juS = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.juT = onErrorListener;
    }

    public int getDuration() {
        AppMethodBeat.i(39507);
        if (this.mBq == null || !this.mDW) {
            this.atU = -1;
            int i2 = this.atU;
            AppMethodBeat.o(39507);
            return i2;
        } else if (this.atU > 0) {
            int i3 = this.atU;
            AppMethodBeat.o(39507);
            return i3;
        } else {
            this.atU = this.mBq.getDuration();
            int i4 = this.atU;
            AppMethodBeat.o(39507);
            return i4;
        }
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(39508);
        if (this.mBq == null || !this.mDW) {
            AppMethodBeat.o(39508);
            return 0;
        }
        int currentPosition = this.mBq.getCurrentPosition();
        AppMethodBeat.o(39508);
        return currentPosition;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(39509);
        if (this.mBq == null || !this.mDW) {
            AppMethodBeat.o(39509);
            return false;
        }
        boolean isPlaying = this.mBq.isPlaying();
        AppMethodBeat.o(39509);
        return isPlaying;
    }

    public int getBufferPercentage() {
        if (this.mBq != null) {
            return this.QAY;
        }
        return 0;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void setVideoViewIm(a aVar) {
        this.QBa = aVar;
    }
}
