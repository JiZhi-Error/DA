package com.tencent.thumbplayer.core.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class TPNativePlayerSurface extends Surface {
    private ITPNativePlayerSurfaceCallback mSurfaceCallback;

    public TPNativePlayerSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
    }

    public void setTPSurfaceCallback(ITPNativePlayerSurfaceCallback iTPNativePlayerSurfaceCallback) {
        this.mSurfaceCallback = iTPNativePlayerSurfaceCallback;
    }
}
