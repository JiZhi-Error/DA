package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

@Keep
class CommNativeBitmapStruct extends NativeBitmapStruct {
    @Keep
    private int nConfig = -1;
    @Keep
    private boolean premultiplyAlpha;

    public CommNativeBitmapStruct convertToCommonStruct() {
        int i2 = 0;
        int i3 = NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE;
        int i4 = this.nConfig;
        if (!(i4 == 4 || i4 == 3 || i4 == 2)) {
            i3 = 0;
        }
        this.glType = i3;
        int i5 = this.nConfig;
        if (i5 == 4) {
            i2 = NativeBitmapStruct.GLFormat.GL_RGBA;
        } else if (i5 == 3) {
            i2 = NativeBitmapStruct.GLFormat.GL_RGB;
        } else if (i5 == 2) {
            i2 = NativeBitmapStruct.GLFormat.GL_ALPHA;
        }
        this.glFormat = i2;
        return this;
    }
}
