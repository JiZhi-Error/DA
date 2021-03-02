package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

public interface TXBeautyManager {
    void enableSharpnessEnhancement(boolean z);

    void setBeautyLevel(int i2);

    void setBeautyStyle(int i2);

    void setChinLevel(int i2);

    void setEyeAngleLevel(int i2);

    void setEyeDistanceLevel(int i2);

    void setEyeLightenLevel(int i2);

    void setEyeScaleLevel(int i2);

    void setFaceBeautyLevel(int i2);

    void setFaceShortLevel(int i2);

    void setFaceSlimLevel(int i2);

    void setFaceVLevel(int i2);

    void setFilter(Bitmap bitmap);

    void setFilterStrength(float f2);

    void setForeheadLevel(int i2);

    void setGreenScreenFile(String str);

    void setLipsThicknessLevel(int i2);

    void setMotionMute(boolean z);

    void setMotionTmpl(String str);

    void setMouthShapeLevel(int i2);

    void setNosePositionLevel(int i2);

    void setNoseSlimLevel(int i2);

    void setNoseWingLevel(int i2);

    void setPounchRemoveLevel(int i2);

    void setPreprocessor(d dVar);

    void setRuddyLevel(int i2);

    void setSmileLinesRemoveLevel(int i2);

    void setToothWhitenLevel(int i2);

    void setWhitenessLevel(int i2);

    void setWrinkleRemoveLevel(int i2);
}
