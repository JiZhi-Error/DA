package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

@Keep
public class AnnocationText {
    public int anchorGravity = 2;
    public int firstNameCount = 0;
    public Bitmap iconBitmap;
    public float mAnchorPointX = 0.5f;
    public float mAnchorPointY = 0.5f;
    public float scale = 1.0f;
    public String text;
}
