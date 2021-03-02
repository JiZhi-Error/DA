package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements j {
    private j.e KwA;
    private j.c KwB;
    private j.b KwM;
    private MediaPlayer.OnSeekCompleteListener KwN;
    private MediaPlayer.OnBufferingUpdateListener KwO;
    private MediaPlayer.OnInfoListener KwP;
    private int atU;
    private float bdN;
    protected long buq;
    private boolean cJi;
    protected FileDescriptor fd;
    private boolean guh;
    private boolean jqj;
    protected long length;
    private MediaPlayer mBq;
    MediaPlayer.OnPreparedListener mBr;
    MediaPlayer.OnVideoSizeChangedListener mBs;
    private MediaPlayer.OnCompletionListener mBt;
    private MediaPlayer.OnErrorListener mBw;
    private String mDV;
    private boolean mDW;
    private int mEX;
    private int mEY;
    private long mEc;
    private int mEd;
    private boolean mEe;
    private long mEm;
    private boolean mEn;
    private boolean mEo;
    private boolean mEp;
    TextureView.SurfaceTextureListener mEq;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private w pMX;
    private j.a rso;
    private j.d rsq;
    private long startTime;

    static /* synthetic */ void u(VideoTextureView videoTextureView) {
        AppMethodBeat.i(134100);
        videoTextureView.bLc();
        AppMethodBeat.o(134100);
    }

    static /* synthetic */ void v(VideoTextureView videoTextureView) {
        AppMethodBeat.i(134101);
        videoTextureView.bLd();
        AppMethodBeat.o(134101);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(134077);
        this.mSurface = null;
        this.mBq = null;
        this.startTime = 0;
        this.mEc = 0;
        this.mEX = 0;
        this.mEY = 0;
        this.mEd = 0;
        this.jqj = false;
        this.mEe = false;
        this.mBs = new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass3 */

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(134066);
                try {
                    if (mediaPlayer != VideoTextureView.this.mBq) {
                        Log.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, VideoTextureView.this.mBq);
                        AppMethodBeat.o(134066);
                        return;
                    }
                    VideoTextureView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                    VideoTextureView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                    Log.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.this.mVideoWidth + " , " + VideoTextureView.this.mVideoHeight + " )");
                    if (VideoTextureView.this.rso != null) {
                        VideoTextureView.this.rso.eo(VideoTextureView.this.mVideoWidth, VideoTextureView.this.mVideoHeight);
                    }
                    VideoTextureView.e(VideoTextureView.this);
                    AppMethodBeat.o(134066);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "on video size changed error[%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            }
        };
        this.mBr = new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass4 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                int i2;
                AppMethodBeat.i(134067);
                if (mediaPlayer == VideoTextureView.this.mBq || mediaPlayer == null) {
                    VideoTextureView.this.mDW = true;
                    VideoTextureView.this.mVideoWidth = mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0;
                    VideoTextureView videoTextureView = VideoTextureView.this;
                    if (mediaPlayer != null) {
                        i2 = mediaPlayer.getVideoHeight();
                    } else {
                        i2 = 0;
                    }
                    videoTextureView.mVideoHeight = i2;
                    Log.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(VideoTextureView.this.mVideoWidth), Integer.valueOf(VideoTextureView.this.mVideoHeight), Boolean.valueOf(VideoTextureView.this.cJi));
                    VideoTextureView.e(VideoTextureView.this);
                    if (VideoTextureView.this.mVideoWidth == 0 || VideoTextureView.this.mVideoHeight == 0) {
                        if (VideoTextureView.this.cJi) {
                            VideoTextureView.this.mBq.start();
                            VideoTextureView.this.cJi = false;
                            VideoTextureView.this.mBq.setLooping(VideoTextureView.this.jqj);
                        }
                    } else if (VideoTextureView.this.cJi) {
                        VideoTextureView.this.mBq.start();
                        VideoTextureView.this.mBq.setLooping(VideoTextureView.this.jqj);
                        VideoTextureView.this.cJi = false;
                    }
                    if (VideoTextureView.this.rso != null) {
                        VideoTextureView.this.rso.tf();
                    }
                    AppMethodBeat.o(134067);
                    return;
                }
                Log.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, VideoTextureView.this.mBq);
                VideoTextureView.a(VideoTextureView.this, mediaPlayer);
                AppMethodBeat.o(134067);
            }
        };
        this.KwN = new MediaPlayer.OnSeekCompleteListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass5 */

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(134068);
                Log.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1), Boolean.valueOf(VideoTextureView.this.cJi), Boolean.valueOf(VideoTextureView.this.mEo));
                if (!VideoTextureView.this.cJi) {
                    VideoTextureView.this.pause();
                } else if (VideoTextureView.this.mEo) {
                    AppMethodBeat.o(134068);
                    return;
                } else {
                    VideoTextureView.this.start();
                }
                if (VideoTextureView.this.KwB != null) {
                    VideoTextureView.this.KwB.fN(VideoTextureView.this.cJi);
                }
                VideoTextureView.this.mEm = 0;
                AppMethodBeat.o(134068);
            }
        };
        this.KwO = new MediaPlayer.OnBufferingUpdateListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass6 */

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                AppMethodBeat.i(134069);
                Log.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i2));
                VideoTextureView.this.mEd = i2;
                AppMethodBeat.o(134069);
            }
        };
        this.KwP = new MediaPlayer.OnInfoListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass7 */

            public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(134070);
                Log.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                if (VideoTextureView.this.KwM != null) {
                    VideoTextureView.this.KwM.ep(i2, i3);
                }
                AppMethodBeat.o(134070);
                return false;
            }
        };
        this.mBt = new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass8 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(134071);
                Log.i("MicroMsg.VideoTextureView", "video on completion");
                VideoTextureView.this.mEc = Util.nowSecond();
                if (VideoTextureView.this.rso != null) {
                    VideoTextureView.this.rso.onCompletion();
                }
                AppMethodBeat.o(134071);
            }
        };
        this.mBw = new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass9 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(134072);
                Log.w("MicroMsg.VideoTextureView", "Error: " + i2 + "," + i3);
                if (VideoTextureView.this.rso != null) {
                    VideoTextureView.this.rso.onError(i2, i3);
                }
                AppMethodBeat.o(134072);
                return true;
            }
        };
        this.mEm = 0;
        this.mEn = false;
        this.mEo = false;
        this.mEp = false;
        this.mEq = new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass10 */

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(134073);
                Log.d("MicroMsg.VideoTextureView", "on surface texture updated");
                if (VideoTextureView.this.mEo) {
                    if (VideoTextureView.this.mBq != null) {
                        VideoTextureView.this.mBq.pause();
                        if (VideoTextureView.this.guh) {
                            VideoTextureView.this.mBq.setVolume(0.0f, 0.0f);
                        } else {
                            VideoTextureView.this.mBq.setVolume(1.0f, 1.0f);
                        }
                    }
                    VideoTextureView.this.mEo = false;
                }
                if (VideoTextureView.this.mEm > 0 && VideoTextureView.this.KwA != null) {
                    VideoTextureView.this.KwA.bLh();
                    VideoTextureView.this.KwA = null;
                }
                VideoTextureView.this.mEm = System.currentTimeMillis();
                if (VideoTextureView.this.mEp) {
                    Log.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()));
                    if (VideoTextureView.this.mBq != null) {
                        VideoTextureView.this.mBq.pause();
                        VideoTextureView.this.setMute(VideoTextureView.this.guh);
                    }
                    VideoTextureView.this.mEp = false;
                }
                AppMethodBeat.o(134073);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(134074);
                Log.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i2 + " height : " + i3);
                if (VideoTextureView.this.mBq != null && VideoTextureView.this.mDW && VideoTextureView.this.mVideoWidth == i2 && VideoTextureView.this.mVideoHeight == i3) {
                    VideoTextureView.this.mBq.start();
                }
                AppMethodBeat.o(134074);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(134075);
                Log.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.this.mDW));
                VideoTextureView.this.h(VideoTextureView.this.mSurface);
                VideoTextureView.this.mSurface = null;
                if (VideoTextureView.this.mBq == null || !VideoTextureView.this.mDW) {
                    VideoTextureView.u(VideoTextureView.this);
                    VideoTextureView.this.mEn = false;
                } else if (VideoTextureView.this.isPlaying()) {
                    VideoTextureView.this.mEn = true;
                    VideoTextureView.this.mBq.pause();
                }
                AppMethodBeat.o(134075);
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(134076);
                VideoTextureView.this.mEX = i2;
                VideoTextureView.this.mEY = i3;
                VideoTextureView.this.gLi();
                VideoTextureView.this.h(VideoTextureView.this.mSurface);
                VideoTextureView.this.mSurface = new Surface(surfaceTexture);
                Log.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(VideoTextureView.this.mDW), Integer.valueOf(VideoTextureView.this.mSurface.hashCode()));
                if (VideoTextureView.this.mBq == null || !VideoTextureView.this.mDW) {
                    VideoTextureView.v(VideoTextureView.this);
                } else {
                    VideoTextureView.this.mBq.setSurface(VideoTextureView.this.mSurface);
                    if (VideoTextureView.this.mEn) {
                        VideoTextureView.this.mBq.start();
                    } else {
                        VideoTextureView.this.mEo = true;
                        VideoTextureView.this.mBq.setVolume(0.0f, 0.0f);
                        VideoTextureView.this.mBq.start();
                    }
                    VideoTextureView.this.mEn = false;
                }
                if (VideoTextureView.this.rsq != null) {
                    VideoTextureView.this.rsq.bgX();
                }
                AppMethodBeat.o(134076);
            }
        };
        this.guh = false;
        this.pMX = new w();
        this.bdN = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.mEq);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.o(134077);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOneTimeVideoTextureUpdateCallback(j.e eVar) {
        this.KwA = eVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSeekCompleteCallback(j.c cVar) {
        this.KwB = cVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnInfoCallback(j.b bVar) {
        this.KwM = bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
        this.rsq = dVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(134078);
        this.mDV = str;
        this.cJi = false;
        bLd();
        requestLayout();
        AppMethodBeat.o(134078);
    }

    public final void a(FileDescriptor fileDescriptor, long j2, long j3) {
        AppMethodBeat.i(208753);
        this.fd = fileDescriptor;
        this.buq = j2;
        this.length = j3;
        this.cJi = false;
        bLd();
        requestLayout();
        AppMethodBeat.o(208753);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public String getVideoPath() {
        return this.mDV;
    }

    public int getDownloadPercent() {
        return this.mEd;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        long j2;
        SurfaceTexture surfaceTexture;
        AppMethodBeat.i(134079);
        long j3 = this.mEc > 0 ? this.mEc - this.startTime : 2147483647L;
        long nowSecond = Util.nowSecond() - this.startTime;
        if (j3 > nowSecond) {
            j2 = nowSecond;
        } else {
            j2 = j3;
        }
        int i2 = ((int) j2) * 1000;
        if (i2 > getDuration()) {
            i2 = getDuration();
        }
        Log.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(nowSecond), Long.valueOf(j3));
        if (this.rso != null) {
            this.rso.fh(i2, getDuration());
        }
        bLc();
        this.pMX.reset();
        try {
            if (!(this.mSurface == null || !this.mDW || (surfaceTexture = getSurfaceTexture()) == null)) {
                Log.i("MicroMsg.VideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, null);
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                egl10.eglTerminate(eglGetDisplay);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "release surface", new Object[0]);
        }
        this.mDV = "";
        this.mEd = 0;
        this.mDW = false;
        this.cJi = false;
        this.mEm = 0;
        AppMethodBeat.o(134079);
    }

    private void bLc() {
        boolean z = true;
        AppMethodBeat.i(134080);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.mDW);
        if (this.mBq != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", objArr);
        if (this.mBq != null) {
            this.mBq.setOnErrorListener(null);
            this.mBq.setOnVideoSizeChangedListener(null);
            try {
                this.mBq.stop();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "stop media player error", new Object[0]);
            }
            try {
                this.mBq.reset();
                this.mBq.release();
                this.mBq.setOnBufferingUpdateListener(null);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.VideoTextureView", e3, "reset media player error", new Object[0]);
            }
        }
        this.mBq = null;
        AppMethodBeat.o(134080);
    }

    private void bLd() {
        AppMethodBeat.i(134081);
        if ((!Util.isNullOrNil(this.mDV) || (this.fd != null && this.fd.valid())) && this.mSurface != null) {
            bLc();
            Log.i("MicroMsg.VideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.mDV);
            try {
                this.mBq = new k();
                this.mBq.setOnPreparedListener(this.mBr);
                this.mBq.setOnVideoSizeChangedListener(this.mBs);
                this.mDW = false;
                Log.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.atU = -1;
                this.mEd = 0;
                this.mBq.setOnCompletionListener(this.mBt);
                this.mBq.setOnErrorListener(this.mBw);
                this.mBq.setOnSeekCompleteListener(this.KwN);
                this.mBq.setOnBufferingUpdateListener(this.KwO);
                this.mBq.setOnInfoListener(this.KwP);
                if (!Util.isNullOrNil(this.mDV)) {
                    this.mBq.setDataSource(this.mDV);
                } else if (this.fd != null) {
                    this.mBq.setDataSource(this.fd, this.buq, this.length);
                }
                this.mBq.setSurface(this.mSurface);
                this.mBq.setAudioStreamType(3);
                this.mBq.setScreenOnWhilePlaying(true);
                this.mBq.prepareAsync();
                this.mVideoHeight = this.mBq.getVideoHeight();
                this.mVideoWidth = this.mBq.getVideoWidth();
                setMute(this.guh);
                aO(this.bdN);
                Log.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", Integer.valueOf(hashCode()), Integer.valueOf(this.mBq.hashCode()));
                AppMethodBeat.o(134081);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "prepare async error path", new Object[0]);
                if (this.rso != null) {
                    this.rso.onError(-1, -1);
                }
                AppMethodBeat.o(134081);
            }
        } else {
            AppMethodBeat.o(134081);
        }
    }

    public final void bLe() {
        AppMethodBeat.i(134082);
        if (this.mBq != null && this.mDW && this.mSurface != null && this.mSurface.isValid()) {
            Log.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.mEp = true;
            this.mBq.setVolume(0.0f, 0.0f);
            this.mBq.start();
        }
        AppMethodBeat.o(134082);
    }

    /* access modifiers changed from: protected */
    public final void h(final Surface surface) {
        AppMethodBeat.i(134083);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(134065);
                try {
                    if (surface != null && surface.isValid()) {
                        Log.i("MicroMsg.VideoTextureView", "%d release surface [%d]", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(surface.hashCode()));
                        surface.release();
                    }
                    AppMethodBeat.o(134065);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "release Surface error", new Object[0]);
                    AppMethodBeat.o(134065);
                }
            }
        });
        AppMethodBeat.o(134083);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(134084);
        if (this.mBq != null && this.mDW && this.mBq.isPlaying()) {
            Log.d("MicroMsg.VideoTextureView", "pause video.");
            this.mBq.pause();
        }
        this.cJi = false;
        AppMethodBeat.o(134084);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(134085);
        if (this.mBq == null || !this.mDW) {
            this.atU = -1;
            int i2 = this.atU;
            AppMethodBeat.o(134085);
            return i2;
        } else if (this.atU > 0) {
            int i3 = this.atU;
            AppMethodBeat.o(134085);
            return i3;
        } else {
            this.atU = this.mBq.getDuration();
            int i4 = this.atU;
            AppMethodBeat.o(134085);
            return i4;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(134086);
        if (this.mBq != null && this.mDW) {
            int currentPosition = this.mBq.getCurrentPosition();
            AppMethodBeat.o(134086);
            return currentPosition;
        } else if (this.mBq == null) {
            AppMethodBeat.o(134086);
            return -1;
        } else {
            AppMethodBeat.o(134086);
            return 0;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(134087);
        if (this.mBq != null && this.mDW && !this.mEo && !this.mEp) {
            try {
                z = this.mBq.isPlaying();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "isPlaying", new Object[0]);
            }
            Log.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.mEo), Boolean.valueOf(this.mDW));
            AppMethodBeat.o(134087);
            return z;
        }
        z = false;
        Log.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.mEo), Boolean.valueOf(this.mDW));
        AppMethodBeat.o(134087);
        return z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
        AppMethodBeat.i(134088);
        if (this.mBq != null) {
            this.mBq.setLooping(z);
        }
        this.jqj = true;
        AppMethodBeat.o(134088);
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
        AppMethodBeat.i(134089);
        if (this.mSurface == null) {
            Log.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.mEn = true;
            this.cJi = true;
            AppMethodBeat.o(134089);
            return false;
        }
        this.startTime = this.startTime == 0 ? Util.nowSecond() : this.startTime;
        Log.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", Long.valueOf(this.startTime), Boolean.valueOf(this.mDW), Boolean.valueOf(this.mEo));
        if (this.mBq != null && this.mDW) {
            if (this.mEo) {
                this.mEo = false;
                setMute(this.guh);
            }
            this.mBq.start();
            this.cJi = true;
            AppMethodBeat.o(134089);
            return true;
        } else if (this.mBq != null || !this.mDW) {
            this.cJi = true;
            AppMethodBeat.o(134089);
            return false;
        } else {
            this.cJi = true;
            bLd();
            requestLayout();
            AppMethodBeat.o(134089);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        AppMethodBeat.i(134090);
        boolean start = start();
        AppMethodBeat.o(134090);
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
        AppMethodBeat.i(134091);
        if (this.mBq != null) {
            this.mBq.seekTo((int) d2);
            this.cJi = true;
            Log.d("MicroMsg.VideoTextureView", "seek to time: " + d2 + " curr pos : " + this.mBq.getCurrentPosition());
        }
        AppMethodBeat.o(134091);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(134092);
        q(d2);
        this.cJi = z;
        AppMethodBeat.o(134092);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public long getLastSurfaceUpdateTime() {
        return this.mEm;
    }

    public void setForceScaleFullScreen(boolean z) {
        this.mEe = z;
        this.pMX.mEe = this.mEe;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(134093);
        Log.i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.guh = z;
        if (this.mBq != null) {
            if (this.guh) {
                this.mBq.setVolume(0.0f, 0.0f);
                AppMethodBeat.o(134093);
                return;
            }
            this.mBq.setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.o(134093);
    }

    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(134094);
        this.pMX.a(eVar);
        requestLayout();
        AppMethodBeat.o(134094);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(134095);
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(134095);
            return;
        }
        this.pMX.y(getDefaultSize(1, i2), getDefaultSize(1, i3), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.pMX.mEZ, this.pMX.mFa);
        AppMethodBeat.o(134095);
    }

    public final boolean aO(float f2) {
        AppMethodBeat.i(134096);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(134096);
            return false;
        }
        this.bdN = f2;
        if (d.oD(23)) {
            boolean cj = cj(this.bdN);
            AppMethodBeat.o(134096);
            return cj;
        }
        AppMethodBeat.o(134096);
        return false;
    }

    private boolean cj(float f2) {
        AppMethodBeat.i(134097);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (this.mBq != null && d.oD(23)) {
                    PlaybackParams playbackParams = this.mBq.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.mBq.setPlaybackParams(playbackParams.setSpeed(f2));
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoTextureView", e2, "%s handle play rate error", Integer.valueOf(hashCode()));
                AppMethodBeat.o(134097);
                return false;
            }
        }
        AppMethodBeat.o(134097);
        return true;
    }

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        AppMethodBeat.i(134098);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
        AppMethodBeat.o(134098);
    }

    static /* synthetic */ void a(VideoTextureView videoTextureView, final MediaPlayer mediaPlayer) {
        AppMethodBeat.i(134099);
        new Thread() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(134064);
                try {
                    if (mediaPlayer != null) {
                        Log.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(VideoTextureView.this.hashCode()), mediaPlayer);
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    AppMethodBeat.o(134064);
                } catch (Exception e2) {
                    AppMethodBeat.o(134064);
                }
            }
        }.start();
        AppMethodBeat.o(134099);
    }
}
