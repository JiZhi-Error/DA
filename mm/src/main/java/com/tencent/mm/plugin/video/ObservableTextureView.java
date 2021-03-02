package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements TextureView.SurfaceTextureListener {
    protected b GwU;
    private boolean GwV = false;
    protected SurfaceTexture surfaceTexture;

    public ObservableTextureView(Context context) {
        super(context);
        AppMethodBeat.i(127133);
        init();
        AppMethodBeat.o(127133);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(127134);
        init();
        AppMethodBeat.o(127134);
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void init() {
        AppMethodBeat.i(127135);
        setSurfaceTextureListener(this);
        this.surfaceTexture = getSurfaceTexture();
        AppMethodBeat.o(127135);
    }

    public boolean isAvailable() {
        return this.GwV;
    }

    public void setTextureChangeCallback(b bVar) {
        this.GwU = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(127136);
        Log.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        gLi();
        this.GwV = true;
        if (this.GwU != null) {
            this.GwU.f(surfaceTexture2);
        }
        AppMethodBeat.o(127136);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i2, int i3) {
        AppMethodBeat.i(127137);
        Log.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.o(127137);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
        AppMethodBeat.i(127138);
        Log.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.GwV = false;
        AppMethodBeat.o(127138);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
    }
}
