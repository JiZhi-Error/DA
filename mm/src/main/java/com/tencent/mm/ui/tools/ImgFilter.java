package com.tencent.mm.ui.tools;

import com.tencent.mm.pointers.PIntArray;

public final class ImgFilter {
    public static native boolean FilterInt(int i2, int[] iArr, int[][] iArr2, int i3, int i4, int i5, PIntArray pIntArray);

    private ImgFilter() {
    }
}
