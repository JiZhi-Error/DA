package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a {
    private static final char[] UiK = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] UiL;

    static {
        AppMethodBeat.i(40575);
        int[] iArr = new int[256];
        UiL = iArr;
        Arrays.fill(iArr, -1);
        int length = UiK.length;
        for (int i2 = 0; i2 < length; i2++) {
            UiL[UiK[i2]] = i2;
        }
        UiL[61] = 0;
        AppMethodBeat.o(40575);
    }

    public static final char[] dy(byte[] bArr) {
        int i2 = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i3 = (length / 3) * 3;
        int i4 = (((length - 1) / 3) + 1) << 2;
        int i5 = i4 + (((i4 - 1) / 76) << 1);
        char[] cArr = new char[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < i3) {
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i9] & 255) << 8) | ((bArr[i8] & 255) << 16);
            i8 = i10 + 1;
            int i12 = i11 | (bArr[i10] & 255);
            int i13 = i7 + 1;
            cArr[i7] = UiK[(i12 >>> 18) & 63];
            int i14 = i13 + 1;
            cArr[i13] = UiK[(i12 >>> 12) & 63];
            int i15 = i14 + 1;
            cArr[i14] = UiK[(i12 >>> 6) & 63];
            i7 = i15 + 1;
            cArr[i15] = UiK[i12 & 63];
            i6++;
            if (i6 == 19 && i7 < i5 - 2) {
                int i16 = i7 + 1;
                cArr[i7] = '\r';
                i7 = i16 + 1;
                cArr[i16] = '\n';
                i6 = 0;
            }
        }
        int i17 = length - i3;
        if (i17 > 0) {
            int i18 = (bArr[i3] & 255) << 10;
            if (i17 == 2) {
                i2 = (bArr[length - 1] & 255) << 2;
            }
            int i19 = i2 | i18;
            cArr[i5 - 4] = UiK[i19 >> 12];
            cArr[i5 - 3] = UiK[(i19 >>> 6) & 63];
            cArr[i5 - 2] = i17 == 2 ? UiK[i19 & 63] : '=';
            cArr[i5 - 1] = '=';
        }
        return cArr;
    }
}
