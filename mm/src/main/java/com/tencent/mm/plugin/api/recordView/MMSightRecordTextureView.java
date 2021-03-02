package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView extends MMTextureView implements TextureView.SurfaceTextureListener {
    private d kyk;
    private c kyl;
    private int surfaceHeight;
    private int surfaceWidth;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(89210);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(89210);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(89211);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(89211);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(89212);
        Log.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        this.kyk = new d();
        this.kyl = new c(surfaceTexture, this.kyk);
        this.kyk.dL(i2, i3);
        this.kyl.kym = true;
        this.kyl.start();
        AppMethodBeat.o(89212);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(89213);
        Log.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        this.kyk.dL(i2, i3);
        AppMethodBeat.o(89213);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(89214);
        this.kyl.kym = false;
        try {
            this.kyl.join();
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e2, "onSurfaceTextureDestroyed error: %s", e2.getMessage());
        }
        this.kyl = null;
        AppMethodBeat.o(89214);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
