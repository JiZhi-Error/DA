package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;

public interface f {
    void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture);

    void onSurfaceTextureDestroy(SurfaceTexture surfaceTexture);
}
