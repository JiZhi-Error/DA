package com.tencent.liteav.basic.c;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.egl.EGLContext;

public interface m {
    void a();

    void a(int i2, boolean z);

    void a(int i2, boolean z, int i3, int i4, int i5, boolean z2);

    void a(Runnable runnable);

    void a(boolean z);

    void a(byte[] bArr);

    EGLContext getGLContext();

    SurfaceTexture getSurfaceTexture();

    void setRendMirror(int i2);

    void setRendMode(int i2);

    void setSurfaceTextureListener(n nVar);
}
