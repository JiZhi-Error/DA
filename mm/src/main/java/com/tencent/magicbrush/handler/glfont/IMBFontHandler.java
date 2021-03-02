package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import java.nio.FloatBuffer;

@Keep
public interface IMBFontHandler {
    boolean checkAndFlushClearSignal();

    int[] checkAndFlushDirtySignal();

    FloatBuffer drawText(String str);

    void enableStroke(boolean z);

    Bitmap getBitmapAtlas();

    float getTextLineHeight(String str);

    void init(int i2, int i3);

    String loadFont(String str);

    float measureText(String str);

    void release();

    void setStrokeWidth(float f2);

    void useFont(String str, String str2, float f2, boolean z, boolean z2);
}
