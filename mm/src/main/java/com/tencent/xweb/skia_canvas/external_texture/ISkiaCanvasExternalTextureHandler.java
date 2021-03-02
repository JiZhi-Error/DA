package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;

public interface ISkiaCanvasExternalTextureHandler {
    void onFrameAvailable();

    void onLoad(SurfaceTexture surfaceTexture, int i2, int i3);
}
