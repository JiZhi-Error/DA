package com.tencent.thumbplayer.g;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.c;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.ITPSurfaceListener;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurface;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;

public final class e implements ITPSurface {
    TPNativePlayerSurface Sbr = null;
    private ITPSurfaceListener Sbs = null;
    private ITPNativePlayerSurfaceCallback Sbt = new ITPNativePlayerSurfaceCallback() {
        /* class com.tencent.thumbplayer.g.e.AnonymousClass1 */

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback
        public final void onRenderInfo(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo) {
            AppMethodBeat.i(189515);
            ITPSurfaceListener iTPSurfaceListener = e.this.Sbs;
            if (iTPSurfaceListener != null) {
                iTPSurfaceListener.onRenderInfo(c.a(tPNativePlayerSurfaceRenderInfo));
            }
            AppMethodBeat.o(189515);
        }
    };

    public e(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(189516);
        this.Sbr = new TPNativePlayerSurface(surfaceTexture);
        this.Sbr.setTPSurfaceCallback(this.Sbt);
        AppMethodBeat.o(189516);
    }

    @Override // com.tencent.thumbplayer.api.ITPSurface
    public final void setSurfaceListener(ITPSurfaceListener iTPSurfaceListener) {
        this.Sbs = iTPSurfaceListener;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(189517);
        this.Sbr.release();
        super.finalize();
        AppMethodBeat.o(189517);
    }
}
