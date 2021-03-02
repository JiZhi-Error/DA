package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    public static byte[] hkP() {
        AppMethodBeat.i(138457);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int[] iArr = {-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i2 = 0; i2 < "http://pmir.3g.qq.com".length(); i2++) {
                stringBuffer.append((char) ("http://pmir.3g.qq.com".charAt(i2) + iArr[i2]));
            }
            byte[] bytes = stringBuffer.toString().getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(138457);
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(138457);
            return null;
        }
    }

    private static void b(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            iArr[i2] = bArr[i3] & 255;
            int i5 = i4 + 1;
            iArr[i2] = ((bArr[i4] & 255) << 8) | iArr[i2];
            int i6 = i5 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i5] & 255) << 16);
            iArr[i2] = iArr[i2] | ((bArr[i6] & 255) << 24);
            i2++;
            i3 = i6 + 1;
        }
        if (i3 < bArr.length) {
            int i7 = i3 + 1;
            iArr[i2] = bArr[i3] & 255;
            int i8 = 8;
            while (i7 < bArr.length) {
                iArr[i2] = iArr[i2] | ((bArr[i7] & 255) << i8);
                i7++;
                i8 += 8;
            }
        }
    }

    private static void a(int[] iArr, int i2, byte[] bArr) {
        int length = bArr.length >> 2;
        if (length > i2) {
            length = i2;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >>> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((iArr[i3] >>> 16) & 255);
            i4 = i7 + 1;
            bArr[i7] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        if (i2 > length && i4 < bArr.length) {
            int i8 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            int i9 = 8;
            while (i9 <= 24 && i8 < bArr.length) {
                bArr[i8] = (byte) ((iArr[i3] >>> i9) & 255);
                i9 += 8;
                i8++;
            }
        }
    }

    private static byte[] cW(byte[] bArr) {
        AppMethodBeat.i(138458);
        if (bArr != null && bArr.length > 16) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                bArr = instance.digest();
            } catch (NoSuchAlgorithmException e2) {
                bArr = null;
            }
        }
        AppMethodBeat.o(138458);
        return bArr;
    }

    public static byte[] n(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(138459);
        byte[] cW = cW(bArr2);
        if (bArr == null || cW == null || bArr.length == 0) {
            AppMethodBeat.o(138459);
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        b(bArr, iArr);
        iArr[length - 1] = bArr.length;
        int length2 = cW.length % 4 == 0 ? cW.length >>> 2 : (cW.length >>> 2) + 1;
        if (length2 < 4) {
            length2 = 4;
        }
        int[] iArr2 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            iArr2[i2] = 0;
        }
        b(cW, iArr2);
        int length3 = iArr.length - 1;
        int i3 = iArr[length3];
        int i4 = (52 / (length3 + 1)) + 6;
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 > 0) {
                i5 -= 1640531527;
                int i7 = (i5 >>> 2) & 3;
                int i8 = 0;
                while (i8 < length3) {
                    int i9 = iArr[i8 + 1];
                    i3 = (((i3 ^ iArr2[(i8 & 3) ^ i7]) + (i9 ^ i5)) ^ (((i3 >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i3 << 4)))) + iArr[i8];
                    iArr[i8] = i3;
                    i8++;
                }
                int i10 = iArr[0];
                i3 = iArr[length3] + (((iArr2[(i8 & 3) ^ i7] ^ i3) + (i10 ^ i5)) ^ (((i3 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i3 << 4))));
                iArr[length3] = i3;
                i4 = i6;
            } else {
                byte[] bArr3 = new byte[(iArr.length << 2)];
                a(iArr, iArr.length, bArr3);
                AppMethodBeat.o(138459);
                return bArr3;
            }
        }
    }

    public static byte[] o(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(138460);
        byte[] cW = cW(bArr2);
        if (bArr == null || cW == null || bArr.length == 0) {
            AppMethodBeat.o(138460);
            return bArr;
        } else if (bArr.length % 4 != 0 || bArr.length < 8) {
            AppMethodBeat.o(138460);
            return null;
        } else {
            int[] iArr = new int[(bArr.length >>> 2)];
            b(bArr, iArr);
            int length = cW.length % 4 == 0 ? cW.length >>> 2 : (cW.length >>> 2) + 1;
            if (length < 4) {
                length = 4;
            }
            int[] iArr2 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2] = 0;
            }
            b(cW, iArr2);
            int length2 = iArr.length - 1;
            int i3 = iArr[0];
            for (int i4 = ((52 / (length2 + 1)) + 6) * -1640531527; i4 != 0; i4 -= -1640531527) {
                int i5 = (i4 >>> 2) & 3;
                int i6 = length2;
                while (i6 > 0) {
                    int i7 = iArr[i6 - 1];
                    i3 = iArr[i6] - (((i3 ^ i4) + (i7 ^ iArr2[(i6 & 3) ^ i5])) ^ (((i7 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i7 << 4))));
                    iArr[i6] = i3;
                    i6--;
                }
                int i8 = iArr[length2];
                i3 = iArr[0] - (((iArr2[(i6 & 3) ^ i5] ^ i8) + (i3 ^ i4)) ^ (((i8 >>> 5) ^ (i3 << 2)) + ((i3 >>> 3) ^ (i8 << 4))));
                iArr[0] = i3;
            }
            int i9 = iArr[length2];
            if (i9 < 0 || i9 > ((iArr.length - 1) << 2)) {
                AppMethodBeat.o(138460);
                return null;
            }
            byte[] bArr3 = new byte[i9];
            a(iArr, iArr.length - 1, bArr3);
            AppMethodBeat.o(138460);
            return bArr3;
        }
    }
}
