package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.render.d;

public final class g implements TextureView.SurfaceTextureListener, d {
    private TextureView cIM;
    private d.a gQa;

    public g(TextureView textureView) {
        AppMethodBeat.i(241722);
        this.cIM = textureView;
        this.cIM.setOpaque(false);
        this.cIM.setSurfaceTextureListener(this);
        AppMethodBeat.o(241722);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final Canvas lockCanvas() {
        AppMethodBeat.i(241723);
        Canvas lockCanvas = this.cIM.lockCanvas();
        AppMethodBeat.o(241723);
        return lockCanvas;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlockCanvasAndPost(Canvas canvas) {
        AppMethodBeat.i(241724);
        this.cIM.unlockCanvasAndPost(canvas);
        AppMethodBeat.o(241724);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.a aVar) {
        this.gQa = aVar;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(241725);
        this.cIM.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(241725);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final float atd() {
        AppMethodBeat.i(241726);
        float y = this.cIM.getY();
        AppMethodBeat.o(241726);
        return y;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlock() {
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.b bVar) {
        AppMethodBeat.i(241727);
        if (bVar != null) {
            bVar.l(null);
        }
        AppMethodBeat.o(241727);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(241728);
        this.cIM.setOpaque(false);
        if (this.gQa != null) {
            this.gQa.asg();
            this.gQa.ash();
        }
        AppMethodBeat.o(241728);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(241729);
        if (this.gQa != null) {
            this.gQa.ash();
        }
        AppMethodBeat.o(241729);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(241730);
        if (this.gQa != null) {
            this.gQa.asi();
        }
        AppMethodBeat.o(241730);
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
