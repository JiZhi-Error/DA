package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.a;
import com.tencent.mm.media.j.d;
import org.xwalk.core.Log;

public final class c extends a {
    private a ltH = null;
    private boolean ltv = false;
    private int mSurfaceHeight = 0;
    private int mSurfaceWidth = 0;

    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.a, com.tencent.magicbrush.ui.h
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, final int i2, final int i3) {
        AppMethodBeat.i(45269);
        Log.i("MicroMsg.ScreenView", "onSurfaceTextureAvailable, surface:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        try {
            this.ltH = new d() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.c.AnonymousClass1 */

                @Override // com.tencent.mm.media.j.a
                public final com.tencent.mm.media.j.b.a aEC() {
                    AppMethodBeat.i(45267);
                    com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
                    AppMethodBeat.o(45267);
                    return cVar;
                }
            };
            this.ltH.cZ(i2, i3);
            this.ltH.cY(i2, i3);
            setPreviewRenderer(new d() {
                /* class com.tencent.mm.plugin.appbrand.game.f.a.c.AnonymousClass2 */

                @Override // com.tencent.mm.media.j.a
                public final com.tencent.mm.media.j.b.a aEC() {
                    AppMethodBeat.i(45268);
                    com.tencent.mm.media.j.b.c cVar = new com.tencent.mm.media.j.b.c(i2, i3, i2, i3, 1, 1);
                    AppMethodBeat.o(45268);
                    return cVar;
                }
            });
            synchronized (this) {
                try {
                    this.ltv = true;
                    this.mSurfaceWidth = i2;
                    this.mSurfaceHeight = i3;
                } catch (Throwable th) {
                    AppMethodBeat.o(45269);
                    throw th;
                }
            }
            super.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
            AppMethodBeat.o(45269);
        } catch (Exception e2) {
            Log.i("MicroMsg.ScreenView", "onSurfaceTextureAvailable, error:" + e2.getMessage());
            AppMethodBeat.o(45269);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.a, com.tencent.magicbrush.ui.h
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(45270);
        Log.i("MicroMsg.ScreenView", "onSurfaceTextureSizeChanged, surface:" + surfaceTexture + ", width:" + i2 + ", height:" + i3);
        super.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        AppMethodBeat.o(45270);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.a, com.tencent.magicbrush.ui.h
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(45271);
        Log.i("MicroMsg.ScreenView", "onSurfaceTextureDestroyed, surface:".concat(String.valueOf(surfaceTexture)));
        if (this.ltH != null) {
            this.ltH.release(true);
        }
        boolean onSurfaceTextureDestroyed = super.onSurfaceTextureDestroyed(surfaceTexture);
        AppMethodBeat.o(45271);
        return onSurfaceTextureDestroyed;
    }

    @Override // com.tencent.magicbrush.ui.h
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(45272);
        super.onSurfaceTextureUpdated(surfaceTexture);
        AppMethodBeat.o(45272);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final boolean isAvailable() {
        return this.ltv;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a.d
    public final a getAbsSurfaceRenderer() {
        return this.ltH;
    }
}
