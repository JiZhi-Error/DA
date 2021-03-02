package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class AbstractVideoTextureView extends TextureView implements a {
    private int atU;
    private float bdN;
    protected c cIV;
    private boolean cJi;
    private boolean guh;
    private boolean jqj;
    private String mDV;
    private boolean mDW;
    private a.AbstractC0719a mDX;
    private a.e mDY;
    private a.c mDZ;
    private a.b mEa;
    private a.d mEb;
    private long mEc;
    private int mEd;
    private boolean mEe;
    private c.i mEf;
    private c.g mEg;
    private c.h mEh;
    private c.a mEi;
    private c.f mEj;
    private c.b mEk;
    private c.e mEl;
    private long mEm;
    private boolean mEn;
    private boolean mEo;
    private boolean mEp;
    private TextureView.SurfaceTextureListener mEq;
    private b mEr;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private long startTime;

    /* access modifiers changed from: protected */
    public abstract c bLb();

    public AbstractVideoTextureView(Context context) {
        this(context, null);
    }

    public AbstractVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mSurface = null;
        this.cIV = null;
        this.startTime = 0;
        this.mEc = 0;
        this.mEd = 0;
        this.jqj = false;
        this.mEe = false;
        this.mEf = new c.i() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i
            public final void a(c cVar, int i2, int i3) {
                AppMethodBeat.i(235172);
                try {
                    if (cVar != AbstractVideoTextureView.this.cIV) {
                        Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", cVar, AbstractVideoTextureView.this.cIV);
                        AppMethodBeat.o(235172);
                        return;
                    }
                    AbstractVideoTextureView.this.mVideoWidth = cVar.getVideoWidth();
                    AbstractVideoTextureView.this.mVideoHeight = cVar.getVideoHeight();
                    Log.i("MicroMsg.Video.AbstractVideoTextureView", "on size change size:( " + AbstractVideoTextureView.this.mVideoWidth + " , " + AbstractVideoTextureView.this.mVideoHeight + " )");
                    if (AbstractVideoTextureView.this.mDX != null) {
                        AbstractVideoTextureView.this.mDX.eo(AbstractVideoTextureView.this.mVideoWidth, AbstractVideoTextureView.this.mVideoHeight);
                    }
                    AbstractVideoTextureView.g(AbstractVideoTextureView.this);
                    AppMethodBeat.o(235172);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "on video size changed error[%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            }
        };
        this.mEg = new c.g() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
            public final void a(c cVar) {
                AppMethodBeat.i(235173);
                if (cVar != AbstractVideoTextureView.this.cIV) {
                    Log.w("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", cVar, AbstractVideoTextureView.this.cIV);
                    AbstractVideoTextureView.a(AbstractVideoTextureView.this, cVar);
                    AppMethodBeat.o(235173);
                    return;
                }
                AbstractVideoTextureView.this.mDW = true;
                AbstractVideoTextureView.this.mVideoWidth = cVar.getVideoWidth();
                AbstractVideoTextureView.this.mVideoHeight = cVar.getVideoHeight();
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(AbstractVideoTextureView.this.mVideoWidth), Integer.valueOf(AbstractVideoTextureView.this.mVideoHeight), Boolean.valueOf(AbstractVideoTextureView.this.cJi));
                AbstractVideoTextureView.g(AbstractVideoTextureView.this);
                if (AbstractVideoTextureView.this.mVideoWidth == 0 || AbstractVideoTextureView.this.mVideoHeight == 0) {
                    if (AbstractVideoTextureView.this.cJi) {
                        AbstractVideoTextureView.this.cIV.start();
                        AbstractVideoTextureView.this.cJi = false;
                        AbstractVideoTextureView.this.cIV.setLooping(AbstractVideoTextureView.this.jqj);
                    }
                } else if (AbstractVideoTextureView.this.cJi) {
                    AbstractVideoTextureView.this.cIV.start();
                    AbstractVideoTextureView.this.cIV.setLooping(AbstractVideoTextureView.this.jqj);
                    AbstractVideoTextureView.this.cJi = false;
                }
                if (AbstractVideoTextureView.this.mDX != null) {
                    AbstractVideoTextureView.this.mDX.tf();
                }
                AppMethodBeat.o(235173);
            }
        };
        this.mEh = new c.h() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
            public final void b(c cVar) {
                AppMethodBeat.i(235174);
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(cVar.getCurrentPosition()), Boolean.valueOf(AbstractVideoTextureView.this.cJi), Boolean.valueOf(AbstractVideoTextureView.this.mEo));
                if (!AbstractVideoTextureView.this.cJi) {
                    AbstractVideoTextureView.this.pause();
                } else if (AbstractVideoTextureView.this.mEo) {
                    AppMethodBeat.o(235174);
                    return;
                } else {
                    AbstractVideoTextureView.this.start();
                }
                if (AbstractVideoTextureView.this.mDZ != null) {
                    AbstractVideoTextureView.this.mDZ.fN(AbstractVideoTextureView.this.cJi);
                }
                AbstractVideoTextureView.this.mEm = 0;
                AppMethodBeat.o(235174);
            }
        };
        this.mEi = new c.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
            public final void id(int i2) {
                AppMethodBeat.i(235175);
                Log.d("MicroMsg.Video.AbstractVideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i2));
                AbstractVideoTextureView.this.mEd = i2;
                AppMethodBeat.o(235175);
            }
        };
        this.mEj = new c.f() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f
            public final boolean cb(int i2, int i3) {
                AppMethodBeat.i(235176);
                Log.d("MicroMsg.Video.AbstractVideoTextureView", "onInfo [%d %d]", Integer.valueOf(i2), Integer.valueOf(i3));
                if (AbstractVideoTextureView.this.mEa != null) {
                    AbstractVideoTextureView.this.mEa.ep(i2, i3);
                }
                AppMethodBeat.o(235176);
                return false;
            }
        };
        this.mEk = new c.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
            public final void QA() {
                AppMethodBeat.i(235177);
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "video on completion");
                AbstractVideoTextureView.this.mEc = Util.nowSecond();
                if (AbstractVideoTextureView.this.mDX != null) {
                    AbstractVideoTextureView.this.mDX.onCompletion();
                }
                AppMethodBeat.o(235177);
            }
        };
        this.mEl = new c.e() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e
            public final boolean cc(int i2, int i3) {
                AppMethodBeat.i(235164);
                Log.w("MicroMsg.Video.AbstractVideoTextureView", "Error: " + i2 + "," + i3);
                if (AbstractVideoTextureView.this.mDX != null) {
                    AbstractVideoTextureView.this.mDX.onError(i2, i3);
                }
                AppMethodBeat.o(235164);
                return true;
            }
        };
        this.mEm = 0;
        this.mEn = false;
        this.mEo = false;
        this.mEp = false;
        this.mEq = new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass3 */

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(235165);
                Log.d("MicroMsg.Video.AbstractVideoTextureView", "on surface texture updated");
                if (AbstractVideoTextureView.this.mEo) {
                    if (AbstractVideoTextureView.this.cIV != null) {
                        AbstractVideoTextureView.this.cIV.pause();
                        if (AbstractVideoTextureView.this.guh) {
                            AbstractVideoTextureView.this.cIV.setVolume(0.0f, 0.0f);
                        } else {
                            AbstractVideoTextureView.this.cIV.setVolume(1.0f, 1.0f);
                        }
                    }
                    AbstractVideoTextureView.this.mEo = false;
                }
                if (AbstractVideoTextureView.this.mEm > 0 && AbstractVideoTextureView.this.mDY != null) {
                    AbstractVideoTextureView.this.mDY.bLh();
                    AbstractVideoTextureView.this.mDY = null;
                }
                AbstractVideoTextureView.this.mEm = System.currentTimeMillis();
                if (AbstractVideoTextureView.this.mEp) {
                    Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(AbstractVideoTextureView.this.getCurrentPosition()));
                    if (AbstractVideoTextureView.this.cIV != null) {
                        AbstractVideoTextureView.this.cIV.pause();
                        AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.this.guh);
                    }
                    AbstractVideoTextureView.this.mEp = false;
                }
                AppMethodBeat.o(235165);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(235166);
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "on texture size changed width : " + i2 + " height : " + i3);
                if (AbstractVideoTextureView.this.cIV != null && AbstractVideoTextureView.this.mDW && AbstractVideoTextureView.this.mVideoWidth == i2 && AbstractVideoTextureView.this.mVideoHeight == i3) {
                    AbstractVideoTextureView.this.cIV.start();
                }
                AppMethodBeat.o(235166);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(235167);
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Boolean.valueOf(AbstractVideoTextureView.this.mDW));
                AbstractVideoTextureView.this.h(AbstractVideoTextureView.this.mSurface);
                AbstractVideoTextureView.this.mSurface = null;
                if (AbstractVideoTextureView.this.cIV == null || !AbstractVideoTextureView.this.mDW) {
                    AbstractVideoTextureView.this.bLc();
                    AbstractVideoTextureView.this.mEn = false;
                } else if (AbstractVideoTextureView.this.isPlaying()) {
                    AbstractVideoTextureView.this.mEn = true;
                    AbstractVideoTextureView.this.cIV.pause();
                }
                AppMethodBeat.o(235167);
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(235168);
                AbstractVideoTextureView.this.h(AbstractVideoTextureView.this.mSurface);
                AbstractVideoTextureView.this.mSurface = new Surface(surfaceTexture);
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(AbstractVideoTextureView.this.mDW), Integer.valueOf(AbstractVideoTextureView.this.mSurface.hashCode()));
                if (AbstractVideoTextureView.this.cIV == null || !AbstractVideoTextureView.this.mDW) {
                    AbstractVideoTextureView.this.bLd();
                } else {
                    AbstractVideoTextureView.this.cIV.setSurface(AbstractVideoTextureView.this.mSurface);
                    if (AbstractVideoTextureView.this.mEn) {
                        AbstractVideoTextureView.this.cIV.start();
                    } else {
                        AbstractVideoTextureView.this.mEo = true;
                        AbstractVideoTextureView.this.cIV.setVolume(0.0f, 0.0f);
                        AbstractVideoTextureView.this.cIV.start();
                    }
                    AbstractVideoTextureView.this.mEn = false;
                }
                if (AbstractVideoTextureView.this.mEb != null) {
                    AbstractVideoTextureView.this.mEb.bgX();
                }
                AppMethodBeat.o(235168);
            }
        };
        this.guh = false;
        this.mEr = new b();
        this.bdN = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.mEq);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setOneTimeVideoTextureUpdateCallback(a.e eVar) {
        this.mDY = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setOnSeekCompleteCallback(a.c cVar) {
        this.mDZ = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setOnInfoCallback(a.b bVar) {
        this.mEa = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setOnSurfaceCallback(a.d dVar) {
        this.mEb = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setVideoPath(String str) {
        this.mDV = str;
        this.cJi = false;
        bLd();
        requestLayout();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public String getVideoPath() {
        return this.mDV;
    }

    public int getDownloadPercent() {
        return this.mEd;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final void stop() {
        long j2;
        SurfaceTexture surfaceTexture;
        long j3 = this.mEc > 0 ? this.mEc - this.startTime : 2147483647L;
        long nowSecond = Util.nowSecond() - this.startTime;
        if (j3 > nowSecond) {
            j2 = nowSecond;
        } else {
            j2 = j3;
        }
        if (((int) j2) * 1000 > getDuration()) {
            getDuration();
        }
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(nowSecond), Long.valueOf(j3));
        if (this.mDX != null) {
            getDuration();
        }
        bLc();
        this.mEr.reset();
        try {
            if (!(this.mSurface == null || !this.mDW || (surfaceTexture = getSurfaceTexture()) == null)) {
                Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
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
            Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "release surface", new Object[0]);
        }
        this.mDV = "";
        this.mEd = 0;
        this.mDW = false;
        this.cJi = false;
        this.mEm = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bLc() {
        boolean z = true;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.mDW);
        if (this.cIV != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", objArr);
        if (this.cIV != null) {
            this.cIV.a((c.e) null);
            this.cIV.a((c.i) null);
            try {
                this.cIV.stop();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "stop media player error", new Object[0]);
            }
            try {
                this.cIV.reset();
                this.cIV.release();
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e3, "reset media player error", new Object[0]);
            }
            this.cIV = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bLd() {
        if (Util.isNullOrNil(this.mDV) || this.mSurface == null) {
            Log.i("MicroMsg.Video.AbstractVideoTextureView", "openVideo, try later, url:%s, surface:%s", this.mDV, this.mSurface);
            return;
        }
        bLc();
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.mDV);
        try {
            this.cIV = bLb();
            this.cIV.a(this.mEg);
            this.cIV.a(this.mEf);
            this.mDW = false;
            this.atU = -1;
            this.mEd = 0;
            this.cIV.a(this.mEk);
            this.cIV.a(this.mEl);
            this.cIV.a(this.mEh);
            this.cIV.a(this.mEi);
            this.cIV.a(this.mEj);
            final AnonymousClass5 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(235170);
                    try {
                        AbstractVideoTextureView.this.cIV.setSurface(AbstractVideoTextureView.this.mSurface);
                        AbstractVideoTextureView.this.cIV.prepareAsync();
                        AbstractVideoTextureView.this.mVideoHeight = AbstractVideoTextureView.this.cIV.getVideoHeight();
                        AbstractVideoTextureView.this.mVideoWidth = AbstractVideoTextureView.this.cIV.getVideoWidth();
                        AbstractVideoTextureView.this.setMute(AbstractVideoTextureView.this.guh);
                        AbstractVideoTextureView.this.aO(AbstractVideoTextureView.this.bdN);
                        AppMethodBeat.o(235170);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "prepare async error path", new Object[0]);
                        if (AbstractVideoTextureView.this.mDX != null) {
                            AbstractVideoTextureView.this.mDX.onError(-1, -1);
                        }
                        AppMethodBeat.o(235170);
                    }
                }
            };
            if (!Util.isNullOrNil(this.mDV)) {
                this.cIV.a(this.mDV, null, new c.AbstractC0716c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.AbstractC0716c
                    public final void bKA() {
                        AppMethodBeat.i(235171);
                        Log.i("MicroMsg.Video.AbstractVideoTextureView", "onDataSourceSet#openVideo");
                        r0.run();
                        AppMethodBeat.o(235171);
                    }
                });
            } else {
                r0.run();
            }
            Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d open video success player[%s]", Integer.valueOf(hashCode()), Integer.valueOf(this.cIV.hashCode()));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "prepare async error path", new Object[0]);
            if (this.mDX != null) {
                this.mDX.onError(-1, -1);
            }
        }
    }

    public final void bLe() {
        if (this.cIV != null && this.mDW && this.mSurface != null && this.mSurface.isValid()) {
            Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.mEp = true;
            this.cIV.setVolume(0.0f, 0.0f);
            this.cIV.start();
        }
    }

    /* access modifiers changed from: protected */
    public final void h(final Surface surface) {
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(235169);
                try {
                    if (surface != null && surface.isValid()) {
                        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d release surface [%d]", Integer.valueOf(AbstractVideoTextureView.this.hashCode()), Integer.valueOf(surface.hashCode()));
                        surface.release();
                    }
                    AppMethodBeat.o(235169);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Video.AbstractVideoTextureView", e2, "release Surface error", new Object[0]);
                    AppMethodBeat.o(235169);
                }
            }
        });
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final void pause() {
        if (this.cIV != null && this.mDW && this.cIV.isPlaying()) {
            Log.d("MicroMsg.Video.AbstractVideoTextureView", "pause video.");
            this.cIV.pause();
        }
        this.cJi = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public int getDuration() {
        if (this.cIV == null || !this.mDW) {
            this.atU = -1;
            return this.atU;
        } else if (this.atU > 0) {
            return this.atU;
        } else {
            this.atU = this.cIV.getDuration();
            return this.atU;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public int getCurrentPosition() {
        if (this.cIV != null && this.mDW) {
            return this.cIV.getCurrentPosition();
        }
        if (this.cIV == null) {
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final boolean isPlaying() {
        boolean z;
        if (this.cIV == null || !this.mDW || this.mEo || this.mEp) {
            z = false;
        } else {
            z = this.cIV.isPlaying();
        }
        Log.d("MicroMsg.Video.AbstractVideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.mEo), Boolean.valueOf(this.mDW));
        return z;
    }

    public void setLoop(boolean z) {
        if (this.cIV != null) {
            this.cIV.setLooping(z);
        }
        this.jqj = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setVideoCallback(a.AbstractC0719a aVar) {
        this.mDX = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final boolean start() {
        if (this.mSurface == null) {
            Log.w("MicroMsg.Video.AbstractVideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.mEn = true;
            this.cJi = true;
            return false;
        }
        this.startTime = this.startTime == 0 ? Util.nowSecond() : this.startTime;
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b mediaPlayer %s", Long.valueOf(this.startTime), Boolean.valueOf(this.mDW), Boolean.valueOf(this.mEo), this.cIV);
        if (this.cIV != null && this.mDW) {
            if (this.mEo) {
                this.mEo = false;
                setMute(this.guh);
            }
            this.cIV.start();
            this.cJi = true;
            return true;
        } else if (this.cIV != null || !this.mDW) {
            this.cJi = true;
            return false;
        } else {
            this.cJi = true;
            bLd();
            requestLayout();
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final void q(double d2) {
        if (this.cIV != null) {
            this.cIV.seekTo((long) ((int) d2));
            this.cJi = true;
            Log.d("MicroMsg.Video.AbstractVideoTextureView", "seek to time: " + d2 + " curr pos : " + this.cIV.getCurrentPosition());
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public final void d(double d2, boolean z) {
        q(d2);
        this.cJi = z;
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return this.mEm;
    }

    public void setForceScaleFullScreen(boolean z) {
        this.mEe = z;
        this.mEr.mEe = this.mEe;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a
    public void setMute(boolean z) {
        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.guh = z;
        if (this.cIV == null) {
            return;
        }
        if (this.guh) {
            this.cIV.setVolume(0.0f, 0.0f);
        } else {
            this.cIV.setVolume(1.0f, 1.0f);
        }
    }

    public void setScaleType(e.h hVar) {
        b bVar = this.mEr;
        Log.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", bVar.mwG, hVar);
        bVar.mwG = hVar;
        bVar.reset();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.mEr.y(getDefaultSize(1, i2), getDefaultSize(1, i3), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.mEr.mEZ, this.mEr.mFa);
    }

    public final boolean aO(float f2) {
        if (f2 > 0.0f) {
            this.bdN = f2;
            this.cIV.aP(this.bdN);
        }
        return false;
    }

    static /* synthetic */ void g(AbstractVideoTextureView abstractVideoTextureView) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractVideoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        abstractVideoTextureView.setLayoutParams(layoutParams);
    }

    static /* synthetic */ void a(AbstractVideoTextureView abstractVideoTextureView, final c cVar) {
        new Thread() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.videoview.AbstractVideoTextureView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(235163);
                try {
                    if (cVar != null) {
                        Log.i("MicroMsg.Video.AbstractVideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(AbstractVideoTextureView.this.hashCode()), cVar);
                        cVar.stop();
                        cVar.release();
                    }
                    AppMethodBeat.o(235163);
                } catch (Exception e2) {
                    AppMethodBeat.o(235163);
                }
            }
        }.start();
    }
}
