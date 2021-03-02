package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;

public interface IX5CoreOptimizedBitmap {
    Bitmap createX5OptimizedBitmap(int i2, int i3, Bitmap.Config config, boolean z);

    boolean pinBitmap(Bitmap bitmap, boolean z);

    void unpinBitmap(Bitmap bitmap);
}
