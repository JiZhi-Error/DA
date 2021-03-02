package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanYuvUtils;", "", "()V", "encodeYUV420SP", "", "yuv420sp", "", "argb", "", "width", "", "height", "getNV21", "inputWidth", "inputHeight", "scaled", "Landroid/graphics/Bitmap;", "plugin-scan_release"})
public final class o {
    public static final o CUB = new o();

    static {
        AppMethodBeat.i(161063);
        AppMethodBeat.o(161063);
    }

    private o() {
    }

    public static final byte[] getNV21(int i2, int i3, Bitmap bitmap) {
        int i4;
        int i5;
        AppMethodBeat.i(161062);
        if (bitmap == null) {
            AppMethodBeat.o(161062);
            return null;
        }
        int[] iArr = new int[(i2 * i3)];
        bitmap.getPixels(iArr, 0, i2, 0, 0, i2, i3);
        byte[] bArr = new byte[(((i2 * i3) * 3) / 2)];
        int i6 = i2 * i3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < i3) {
            int i10 = 0;
            int i11 = i8;
            int i12 = i7;
            while (i10 < i2) {
                int i13 = (iArr[i11] & 16711680) >> 16;
                int i14 = (iArr[i11] & 65280) >> 8;
                int i15 = (iArr[i11] & 255) >> 0;
                int i16 = (((((i13 * 66) + (i14 * 129)) + (i15 * 25)) + 128) >> 8) + 16;
                int i17 = (((((i13 * -38) - (i14 * 74)) + (i15 * 112)) + 128) >> 8) + 128;
                int i18 = (((((i13 * 112) - (i14 * 94)) - (i15 * 18)) + 128) >> 8) + 128;
                int i19 = i12 + 1;
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 255) {
                    i16 = 255;
                }
                bArr[i12] = (byte) i16;
                if (i9 % 2 == 0 && i11 % 2 == 0) {
                    int i20 = i6 + 1;
                    bArr[i6] = (byte) (i18 < 0 ? 0 : i18 > 255 ? 255 : i18);
                    int i21 = i20 + 1;
                    if (i17 < 0) {
                        i5 = 0;
                    } else {
                        i5 = i17 > 255 ? 255 : i17;
                    }
                    bArr[i20] = (byte) i5;
                    i4 = i21;
                } else {
                    i4 = i6;
                }
                i10++;
                i11++;
                i12 = i19;
                i6 = i4;
            }
            i9++;
            i8 = i11;
            i7 = i12;
        }
        bitmap.recycle();
        AppMethodBeat.o(161062);
        return bArr;
    }
}
