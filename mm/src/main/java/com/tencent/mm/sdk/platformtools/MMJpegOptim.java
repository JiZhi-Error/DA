package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;

/* access modifiers changed from: package-private */
public class MMJpegOptim {
    public static native boolean checkIntegrity(String str);

    public static native int compressByQuality(Bitmap bitmap, int i2, boolean z, String str);

    public static native int compressByQualityOptim(Bitmap bitmap, int i2, boolean z, String str);

    public static native int convertToProgressive(String str, String str2, int i2);

    public static native int decodeToBitmap(String str, Bitmap bitmap, int i2);

    public static native int isProgressiveFile(String str);

    public static native int queryQuality(String str);

    MMJpegOptim() {
    }
}
