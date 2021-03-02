package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.plugin.n.d;
import com.tencent.mm.plugin.n.e;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;

public class VideoPlayerTextureView extends MMTextureView implements j {
    protected j.e KwA;
    private j.c KwB;
    protected int Kwz;
    protected boolean ZA;
    protected long buq;
    protected FileDescriptor fd;
    protected boolean guh;
    protected long length;
    protected boolean mEe;
    protected long mEm;
    protected boolean mEn;
    protected boolean mEo;
    private TextureView.SurfaceTextureListener mEq;
    protected Surface mSurface;
    protected int mVideoHeight;
    protected int mVideoWidth;
    protected w pMX;
    protected String path;
    protected com.tencent.mm.plugin.n.j rsl;
    protected boolean rsm;
    protected boolean rsn;
    protected j.a rso;
    protected j.d rsq;
    protected boolean rsr;
    protected boolean rss;
    protected boolean rst;
    protected d rsv;
    protected b zrF;

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(134040);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.Kwz = 0;
        this.ZA = false;
        this.rsm = true;
        this.mEm = 0;
        this.mEe = false;
        this.rsn = false;
        this.rsr = false;
        this.rss = false;
        this.rst = false;
        this.mEn = false;
        this.mEo = false;
        this.rsv = new d() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.n.d
            public final void tf() {
                AppMethodBeat.i(134030);
                Log.i("MicroMsg.VideoPlayerTextureView", "%s onPrepared, path:%s", Integer.valueOf(hashCode()), VideoPlayerTextureView.this.getVideoPath());
                VideoPlayerTextureView.this.ZA = true;
                VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.guh);
                if (VideoPlayerTextureView.this.rso != null) {
                    VideoPlayerTextureView.this.rso.tf();
                }
                VideoPlayerTextureView.this.requestLayout();
                AppMethodBeat.o(134030);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void onCompletion() {
                AppMethodBeat.i(134031);
                if (VideoPlayerTextureView.this.rso != null) {
                    VideoPlayerTextureView.this.rso.onCompletion();
                }
                AppMethodBeat.o(134031);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(134032);
                if (VideoPlayerTextureView.this.rso != null) {
                    VideoPlayerTextureView.this.rso.onError(i2, i3);
                }
                AppMethodBeat.o(134032);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void cJH() {
                AppMethodBeat.i(134033);
                if (VideoPlayerTextureView.this.KwB != null) {
                    VideoPlayerTextureView.this.KwB.fN(VideoPlayerTextureView.this.rsm);
                }
                if (!VideoPlayerTextureView.this.rsm) {
                    Log.i("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                    VideoPlayerTextureView.this.rsm = true;
                    AppMethodBeat.o(134033);
                    return;
                }
                if (VideoPlayerTextureView.this.rsl != null) {
                    Log.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", VideoPlayerTextureView.this.rsl.info());
                    VideoPlayerTextureView.this.rsl.start();
                }
                AppMethodBeat.o(134033);
            }

            @Override // com.tencent.mm.plugin.n.d
            public final void aa(int i2, int i3, int i4) {
                AppMethodBeat.i(134034);
                Log.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                VideoPlayerTextureView.this.pMX.reset();
                VideoPlayerTextureView.this.Kwz = i4;
                VideoPlayerTextureView.this.mVideoWidth = i2;
                VideoPlayerTextureView.this.mVideoHeight = i3;
                VideoPlayerTextureView.this.crn();
                if (VideoPlayerTextureView.this.rso != null) {
                    VideoPlayerTextureView.this.rso.eo(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
                }
                AppMethodBeat.o(134034);
            }
        };
        this.mEq = new TextureView.SurfaceTextureListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.AnonymousClass2 */

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(134035);
                VideoPlayerTextureView.this.b(surfaceTexture, i2, i3);
                AppMethodBeat.o(134035);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(134036);
                Log.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
                VideoPlayerTextureView.this.crn();
                AppMethodBeat.o(134036);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(134037);
                Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()));
                VideoPlayerTextureView.this.h(VideoPlayerTextureView.this.mSurface);
                VideoPlayerTextureView.this.mSurface = null;
                VideoPlayerTextureView.this.mEn = false;
                VideoPlayerTextureView.this.mEo = false;
                if (VideoPlayerTextureView.this.rsl == null) {
                    VideoPlayerTextureView.this.mEn = false;
                } else if (VideoPlayerTextureView.this.isPlaying()) {
                    VideoPlayerTextureView.this.mEn = true;
                    VideoPlayerTextureView.this.rsl.pause();
                }
                AppMethodBeat.o(134037);
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(134038);
                VideoPlayerTextureView.this.l(surfaceTexture);
                AppMethodBeat.o(134038);
            }
        };
        this.pMX = new w();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.mEq);
        setFocusable(true);
        setFocusableInTouchMode(true);
        AppMethodBeat.o(134040);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(134041);
        if (this.mSurface != null && this.mSurface.isValid()) {
            this.mSurface.release();
        }
        AppMethodBeat.o(134041);
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
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
        this.rsq = dVar;
    }

    public void setIOnlineCache(b bVar) {
        this.zrF = bVar;
    }

    public void setNeedResetExtractor(boolean z) {
        AppMethodBeat.i(134042);
        this.rsr = z;
        if (this.rsl != null) {
            this.rsl.setNeedResetExtractor(z);
        }
        AppMethodBeat.o(134042);
    }

    public void setIsOnlineVideoType(boolean z) {
        AppMethodBeat.i(134043);
        this.rss = z;
        if (this.rsl != null) {
            this.rsl.setIsOnlineVideoType(z);
        }
        AppMethodBeat.o(134043);
    }

    public void setUseMp4Extrator(boolean z) {
        if (this.rsl != null) {
            this.rst = z;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean isPlaying() {
        AppMethodBeat.i(134044);
        if (this.rsl != null) {
            boolean isPlaying = this.rsl.isPlaying();
            AppMethodBeat.o(134044);
            return isPlaying;
        }
        AppMethodBeat.o(134044);
        return false;
    }

    public final boolean YY() {
        AppMethodBeat.i(134045);
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar.zrS != null) {
                boolean Qv = e.Qv(jVar.zrS.state);
                AppMethodBeat.o(134045);
                return Qv;
            }
            AppMethodBeat.o(134045);
            return false;
        }
        AppMethodBeat.o(134045);
        return false;
    }

    public final boolean gsG() {
        if (this.mSurface != null && !this.mEo) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(134046);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        bLd();
        requestLayout();
        AppMethodBeat.o(134046);
    }

    public final void gsH() {
        AppMethodBeat.i(134047);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(hashCode()));
        if (this.rsl != null) {
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar.zrS != null) {
                jVar.zrS.ejn();
            }
        }
        AppMethodBeat.o(134047);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public String getVideoPath() {
        return this.path;
    }

    public void setOpenWithNoneSurface(boolean z) {
        this.rsn = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public boolean start() {
        boolean z;
        AppMethodBeat.i(134048);
        if (this.rsl == null || !this.ZA) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.rsl == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.ZA);
            Log.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", objArr);
            AppMethodBeat.o(134048);
            return false;
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(hashCode());
        objArr2[1] = Boolean.valueOf(this.mEo);
        objArr2[2] = Boolean.valueOf(this.mEn);
        objArr2[3] = Boolean.valueOf(this.mSurface != null);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", objArr2);
        if (this.mSurface == null) {
            this.mEn = true;
            AppMethodBeat.o(134048);
            return true;
        } else if (this.mEo) {
            this.mEn = true;
            this.mEo = false;
            setMute(this.guh);
            AppMethodBeat.o(134048);
            return true;
        } else {
            this.rsl.start();
            AppMethodBeat.o(134048);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        AppMethodBeat.i(134049);
        boolean start = start();
        AppMethodBeat.o(134049);
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void stop() {
        AppMethodBeat.i(134050);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", Integer.valueOf(hashCode()), Util.getStack());
        if (this.rsl != null) {
            this.rsl.zrT = null;
            this.rsl.stop();
            this.rsl.release();
            this.rsl = null;
        }
        this.Kwz = 0;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.pMX.reset();
        this.ZA = false;
        this.path = null;
        this.fd = null;
        this.mEm = 0;
        AppMethodBeat.o(134050);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void pause() {
        AppMethodBeat.i(134051);
        if (this.rsl != null && this.rsl.isPlaying()) {
            this.rsl.pause();
        }
        this.mEn = false;
        AppMethodBeat.o(134051);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void onDetach() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoCallback(j.a aVar) {
        this.rso = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(134052);
        if (this.rsl != null) {
            int ejm = this.rsl.ejm();
            AppMethodBeat.o(134052);
            return ejm;
        }
        AppMethodBeat.o(134052);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        if (this.rsl != null) {
            return (int) this.rsl.zrS.durationMs;
        }
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setThumb(Bitmap bitmap) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        return 0.0d;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void q(double d2) {
        AppMethodBeat.i(134053);
        if (this.rsl != null) {
            this.rsl.QC((int) d2);
        }
        AppMethodBeat.o(134053);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(134054);
        this.rsm = z;
        q(d2);
        AppMethodBeat.o(134054);
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
        AppMethodBeat.i(134055);
        this.guh = z;
        try {
            if (this.rsl != null) {
                Log.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z));
                this.rsl.setMute(z);
            }
            AppMethodBeat.o(134055);
        } catch (Exception e2) {
            AppMethodBeat.o(134055);
        }
    }

    /* access modifiers changed from: protected */
    public void bLd() {
        AppMethodBeat.i(134056);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s] [%s]", Integer.valueOf(hashCode()), this.path, this.mSurface);
        if (this.rsl != null) {
            this.rsl.zrT = null;
            this.rsl.stop();
            this.rsl.release();
            this.rsl = null;
        }
        if ((!Util.isNullOrNil(this.path) || (this.fd != null && this.fd.valid())) && this.mSurface != null) {
            try {
                this.ZA = false;
                this.rsl = new com.tencent.mm.plugin.n.j(Looper.getMainLooper());
                if (!Util.isNullOrNil(this.path)) {
                    this.rsl.setPath(this.path);
                } else if (this.fd != null && this.fd.valid()) {
                    com.tencent.mm.plugin.n.j jVar = this.rsl;
                    jVar.zrS.zsb.a(this.fd, this.buq, this.length);
                }
                this.rsl.setIOnlineCache(this.zrF);
                this.rsl.setNeedResetExtractor(this.rsr);
                this.rsl.setIsOnlineVideoType(this.rss);
                this.rsl.zrT = this.rsv;
                this.rsl.setSurface(this.mSurface);
                this.rsl.ra(this.rst);
                if (this.mSurface != null) {
                    this.rsl.prepare();
                    AppMethodBeat.o(134056);
                    return;
                }
                if (this.rsn) {
                    this.rsl.prepare();
                }
                AppMethodBeat.o(134056);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e2, "prepare async error %s", e2.getMessage());
                if (this.rso != null) {
                    this.rso.onError(-1, -1);
                }
                AppMethodBeat.o(134056);
            }
        } else {
            Log.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            AppMethodBeat.o(134056);
        }
    }

    public final void bLe() {
        AppMethodBeat.i(134057);
        if (!(this.rsl == null || !this.ZA || this.mSurface == null)) {
            Log.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", Integer.valueOf(hashCode()));
            com.tencent.mm.plugin.n.j jVar = this.rsl;
            if (jVar.zrS != null) {
                jVar.zrS.bLe();
            }
        }
        AppMethodBeat.o(134057);
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(134058);
        Log.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.mEn));
        try {
            gLi();
            h(this.mSurface);
            this.mSurface = new Surface(surfaceTexture);
            if (this.rsl == null || !this.ZA) {
                bLd();
            } else {
                this.rsl.i(this.mSurface);
                if (this.mEn) {
                    this.rsl.start();
                } else {
                    this.mEo = true;
                    this.mEm = 0;
                    this.rsl.setMute(true);
                    this.rsl.start();
                }
                this.mEn = false;
            }
            crn();
            if (this.rsq != null) {
                this.rsq.bgX();
            }
            AppMethodBeat.o(134058);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e2, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.o(134058);
        }
    }

    /* access modifiers changed from: protected */
    public void l(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(134059);
        if (this.mEo && this.mEm > 0 && this.rsl != null) {
            this.rsl.pause();
            this.rsl.setMute(this.guh);
            this.mEo = false;
        }
        if (this.mEm > 0 && this.KwA != null) {
            Log.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.KwA.bLh();
            this.KwA = null;
        }
        this.mEm = System.currentTimeMillis();
        AppMethodBeat.o(134059);
    }

    /* access modifiers changed from: protected */
    public final void h(final Surface surface) {
        AppMethodBeat.i(134060);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(134039);
                try {
                    if (surface != null && surface.isValid()) {
                        Log.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surface.hashCode()));
                        surface.release();
                    }
                    AppMethodBeat.o(134039);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e2, "release Surface error", new Object[0]);
                    AppMethodBeat.o(134039);
                }
            }
        });
        AppMethodBeat.o(134060);
    }

    /* access modifiers changed from: protected */
    public void crn() {
        AppMethodBeat.i(134061);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            if (Build.VERSION.SDK_INT < 23 || layoutParams.getRule(13) != -1) {
                layoutParams.addRule(13);
                setLayoutParams(layoutParams);
            } else {
                AppMethodBeat.o(134061);
                return;
            }
        }
        AppMethodBeat.o(134061);
    }

    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(134062);
        if (this.pMX.a(eVar)) {
            requestLayout();
        }
        AppMethodBeat.o(134062);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(134063);
        Log.d("MicroMsg.VideoPlayerTextureView", "onMeasure video size[%d, %d] spec[%d, %d]", Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(getDefaultSize(1, i2)), Integer.valueOf(getDefaultSize(1, i3)));
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            AppMethodBeat.o(134063);
            return;
        }
        this.pMX.y(getDefaultSize(1, i2), getDefaultSize(1, i3), this.mVideoWidth, this.mVideoHeight);
        int i4 = this.pMX.mEZ;
        int i5 = this.pMX.mFa;
        if (this.Kwz == 90 || this.Kwz == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i5) / 2.0f;
            float f4 = ((float) i5) / ((float) i4);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix.setScale(getScaleX(), getScaleY(), f2, f3);
            }
            matrix.postRotate((float) this.Kwz, f2, f3);
            matrix.postScale(1.0f / f4, f4, f2, f3);
            setTransform(matrix);
        }
        setMeasuredDimension(i4, i5);
        AppMethodBeat.o(134063);
    }
}
