package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;

public interface f {
    void a(Camera.PreviewCallback previewCallback);

    void aqD(int i2);

    void autoFocus(Camera.AutoFocusCallback autoFocusCallback);

    void close();

    boolean dEO();

    int getCameraRotation();

    String getFocusMode();

    Point hkU();

    Point hkV();

    float hkW();

    boolean isOpen();

    void p(Point point);

    void r(SurfaceTexture surfaceTexture);

    void setFocusMode(String str);

    void stopPreview();
}
