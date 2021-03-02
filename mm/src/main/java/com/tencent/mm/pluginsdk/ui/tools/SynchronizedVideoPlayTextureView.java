package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.n.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SynchronizedVideoPlayTextureView extends VideoPlayerTextureView {
    private final Object lock = new Object();

    static /* synthetic */ void b(SynchronizedVideoPlayTextureView synchronizedVideoPlayTextureView) {
        AppMethodBeat.i(169169);
        super.stop();
        AppMethodBeat.o(169169);
    }

    public SynchronizedVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.i(169157);
        AppMethodBeat.o(169157);
    }

    public SynchronizedVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(169158);
        AppMethodBeat.o(169158);
    }

    public SynchronizedVideoPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(169159);
        AppMethodBeat.o(169159);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(169160);
        synchronized (this.lock) {
            try {
                super.setVideoPath(str);
            } finally {
                AppMethodBeat.o(169160);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void bLd() {
        AppMethodBeat.i(169161);
        Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        synchronized (this.lock) {
            try {
                if (this.rsl != null) {
                    this.rsl.zrT = null;
                    this.rsl.stop();
                    this.rsl.release();
                    this.rsl = null;
                }
                if (Util.isNullOrNil(this.path)) {
                    Log.w("MicroMsg.SynchronizedVideoPlayTextureView", "%d open video but path is null.", Integer.valueOf(hashCode()));
                    return;
                }
                try {
                    this.ZA = false;
                    this.rsl = new j(Looper.getMainLooper(), getBusinessType());
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
                    AppMethodBeat.o(169161);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", e2, "prepare async error %s", e2.getMessage());
                    if (this.rso != null) {
                        this.rso.onError(-1, -1);
                    }
                    AppMethodBeat.o(169161);
                }
            } finally {
                AppMethodBeat.o(169161);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public void stop() {
        AppMethodBeat.i(169162);
        synchronized (this.lock) {
            try {
                super.stop();
            } finally {
                AppMethodBeat.o(169162);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean start() {
        boolean start;
        AppMethodBeat.i(169163);
        synchronized (this.lock) {
            try {
                this.rsm = true;
                start = super.start();
            } finally {
                AppMethodBeat.o(169163);
            }
        }
        return start;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void pause() {
        AppMethodBeat.i(169164);
        synchronized (this.lock) {
            try {
                super.pause();
                this.rsm = false;
            } finally {
                AppMethodBeat.o(169164);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(169165);
        synchronized (this.lock) {
            try {
                super.q(d2);
            } finally {
                AppMethodBeat.o(169165);
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(169166);
        synchronized (this.lock) {
            try {
                super.setMute(z);
            } finally {
                AppMethodBeat.o(169166);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void b(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(169167);
        synchronized (this.lock) {
            try {
                Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.mEn));
                try {
                    gLi();
                    super.h(this.mSurface);
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
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SynchronizedVideoPlayTextureView", e2, "onSurfaceTextureAvailable failed", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(169167);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void l(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(169168);
        synchronized (this.lock) {
            try {
                if (d.oD(23) && this.mEo && this.mEm > 0) {
                    if (this.rsl != null) {
                        this.rsl.pause();
                        this.rsl.setMute(this.guh);
                    }
                    this.mEo = false;
                }
                if (this.mEm > 0 && this.KwA != null) {
                    Log.i("MicroMsg.SynchronizedVideoPlayTextureView", "%d notify surface update", Integer.valueOf(hashCode()));
                    this.KwA.bLh();
                    this.KwA = null;
                }
                this.mEm = System.currentTimeMillis();
            } finally {
                AppMethodBeat.o(169168);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getBusinessType() {
        return 0;
    }
}
