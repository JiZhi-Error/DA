package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public interface b extends Serializable {
    void a(Canvas canvas, TextPaint textPaint, float f2);

    int aqs(int i2);

    int getEnd();

    float getHeight();

    float getPrimaryHorizontal(int i2);

    int getStart();

    float getWidth();

    float[] hiI();

    RectF hiJ();

    RectF hiK();

    float hiL();

    boolean hiM();

    float hiN();

    float hiO();
}
