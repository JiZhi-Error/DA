package com.tencent.luggage.xweb_ext.extendplugin.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a;

public interface c {
    com.tencent.luggage.xweb_ext.extendplugin.c QK();

    String a(String str, int i2, a aVar);

    void a(com.tencent.luggage.xweb_ext.extendplugin.a.c cVar);

    void a(com.tencent.luggage.xweb_ext.extendplugin.c cVar);

    void onPluginDestroy(String str, int i2);

    void onPluginReady(String str, int i2, SurfaceTexture surfaceTexture);

    void onPluginScreenshotTaken(String str, int i2, Bitmap bitmap);

    void onPluginTouch(String str, int i2, MotionEvent motionEvent);

    void p(String str, int i2);
}
