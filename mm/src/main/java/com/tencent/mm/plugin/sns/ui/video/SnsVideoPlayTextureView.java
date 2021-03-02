package com.tencent.mm.plugin.sns.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    public SnsVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100406);
        AppMethodBeat.o(100406);
    }

    public SnsVideoPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100407);
        AppMethodBeat.o(100407);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(100408);
        super.setVideoPath(str);
        AppMethodBeat.o(100408);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void bLd() {
        AppMethodBeat.i(100409);
        Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        synchronized (this.lock) {
            try {
                if (this.rsl != null) {
                    this.rsl.zrT = null;
                    this.rsl.stop();
                    this.rsl.release();
                    this.rsl = null;
                }
                if (Util.isNullOrNil(this.path)) {
                    Log.w("MicroMsg.Sns.SnsVideoPlayTextureView", "%d open video but path is null.", Integer.valueOf(hashCode()));
                    return;
                }
                try {
                    this.ZA = false;
                    this.rsl = new j(Looper.getMainLooper());
                    this.rsl.setPath(this.path);
                    this.rsl.setIOnlineCache(this.zrF);
                    this.rsl.setNeedResetExtractor(this.rsr);
                    this.rsl.setIsOnlineVideoType(this.rss);
                    this.rsl.zrT = this.rsv;
                    this.rsl.setSurface(this.mSurface);
                    this.rsl.ra(this.rst);
                    if (this.mSurface != null) {
                        this.rsl.prepare();
                    } else if (this.rsn) {
                        this.rsl.prepare();
                    }
                    AppMethodBeat.o(100409);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", e2, "prepare async error %s", e2.getMessage());
                    if (this.rso != null) {
                        this.rso.onError(-1, -1);
                    }
                    AppMethodBeat.o(100409);
                }
            } finally {
                AppMethodBeat.o(100409);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(100410);
        synchronized (this.lock) {
            try {
                super.stop();
            } finally {
                AppMethodBeat.o(100410);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        boolean start;
        AppMethodBeat.i(100411);
        synchronized (this.lock) {
            try {
                start = super.start();
            } finally {
                AppMethodBeat.o(100411);
            }
        }
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(100412);
        synchronized (this.lock) {
            try {
                super.pause();
            } finally {
                AppMethodBeat.o(100412);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(100413);
        synchronized (this.lock) {
            try {
                super.q(d2);
            } finally {
                AppMethodBeat.o(100413);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(100414);
        synchronized (this.lock) {
            try {
                super.setMute(z);
            } finally {
                AppMethodBeat.o(100414);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void b(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(100415);
        Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.mEn));
        try {
            gLi();
            this.mSurface = new Surface(surfaceTexture);
            if (this.rsl == null || !this.ZA) {
                bLd();
            } else {
                this.rsl.i(this.mSurface);
                if (d.oD(23)) {
                    if (this.mEn) {
                        this.rsl.start();
                    } else {
                        this.mEo = true;
                        this.mEm = 0;
                        this.rsl.setMute(true);
                        this.rsl.start();
                    }
                } else if (this.mEn) {
                    d((double) this.rsl.ejm(), true);
                } else {
                    d((double) this.rsl.ejm(), false);
                }
                this.mEn = false;
            }
            crn();
            if (this.rsq != null) {
                this.rsq.bgX();
            }
            AppMethodBeat.o(100415);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Sns.SnsVideoPlayTextureView", e2, "onSurfaceTextureAvailable failed", new Object[0]);
            AppMethodBeat.o(100415);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void l(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(100416);
        if (d.oD(23) && this.mEo && this.mEm > 0) {
            if (this.rsl != null) {
                this.rsl.pause();
                this.rsl.setMute(this.guh);
            }
            this.mEo = false;
        }
        if (this.mEm > 0 && this.KwA != null) {
            Log.i("MicroMsg.Sns.SnsVideoPlayTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
            this.KwA.bLh();
            this.KwA = null;
        }
        this.mEm = System.currentTimeMillis();
        AppMethodBeat.o(100416);
    }
}
