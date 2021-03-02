package com.tencent.map.lib;

public interface JNIInterfaceCallback {
    Object callback(int i2, int i3, String str, byte[] bArr, Object obj);

    int callbackGetGLContext();

    boolean onJniCallbackRenderMapFrame(int i2);

    void onMapCameraChangeStopped();

    void onMapCameraChanged();

    void onMapLoaded();
}
