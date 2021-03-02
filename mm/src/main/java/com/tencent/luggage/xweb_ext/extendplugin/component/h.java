package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView;

public interface h {
    Bitmap getBitmap();

    SurfaceTexture getSurfaceTexture();

    void setImageBitmap(Bitmap bitmap);

    void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener);
}
