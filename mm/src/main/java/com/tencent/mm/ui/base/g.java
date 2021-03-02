package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.PointF;

public interface g {

    public interface a {
        void aj(float f2, float f3);
    }

    PointF a(PointF pointF, int i2, int i3);

    void at(float f2, float f3);

    void au(float f2, float f3);

    PointF c(PointF pointF);

    void gKA();

    void gKB();

    boolean gKw();

    boolean gKx();

    void gKy();

    void gKz();

    float getDoubleTabScale();

    int getImageHeight();

    Matrix getImageMatrix();

    PointF getImageViewMatrixScale();

    PointF getImageViewMatrixTranslation();

    int getImageWidth();

    float getScale();

    float getScaleRate();

    void l(float f2, float f3, float f4);

    void r(float f2, float f3, float f4);

    void setCustomScaleRate(Float f2);

    void setImageViewMatrix(Matrix matrix);

    void setMaxZoomLimit(float f2);

    void setOnZoomScaleChangedListener(a aVar);

    float y(float f2, float f3);
}
