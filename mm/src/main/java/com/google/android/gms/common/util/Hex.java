package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Hex {
    private static final char[] zzaaa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] zzzz = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String bytesToColonDelimitedStringLowercase(byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(5228);
        if (bArr.length == 0) {
            String str = new String();
            AppMethodBeat.o(5228);
            return str;
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        for (int i3 = 0; i3 < bArr.length - 1; i3++) {
            int i4 = bArr[i3] & 255;
            int i5 = i2 + 1;
            cArr[i2] = zzaaa[i4 >>> 4];
            int i6 = i5 + 1;
            cArr[i5] = zzaaa[i4 & 15];
            i2 = i6 + 1;
            cArr[i6] = ':';
        }
        int i7 = bArr[bArr.length - 1] & 255;
        cArr[i2] = zzaaa[i7 >>> 4];
        cArr[i2 + 1] = zzaaa[i7 & 15];
        String str2 = new String(cArr);
        AppMethodBeat.o(5228);
        return str2;
    }

    public static String bytesToColonDelimitedStringUppercase(byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(5227);
        if (bArr.length == 0) {
            String str = new String();
            AppMethodBeat.o(5227);
            return str;
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        for (int i3 = 0; i3 < bArr.length - 1; i3++) {
            int i4 = bArr[i3] & 255;
            int i5 = i2 + 1;
            cArr[i2] = zzzz[i4 >>> 4];
            int i6 = i5 + 1;
            cArr[i5] = zzzz[i4 & 15];
            i2 = i6 + 1;
            cArr[i6] = ':';
        }
        int i7 = bArr[bArr.length - 1] & 255;
        cArr[i2] = zzzz[i7 >>> 4];
        cArr[i2 + 1] = zzzz[i7 & 15];
        String str2 = new String(cArr);
        AppMethodBeat.o(5227);
        return str2;
    }

    public static String bytesToStringLowercase(byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(5226);
        char[] cArr = new char[(bArr.length << 1)];
        for (byte b2 : bArr) {
            int i3 = b2 & 255;
            int i4 = i2 + 1;
            cArr[i2] = zzaaa[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = zzaaa[i3 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(5226);
        return str;
    }

    public static String bytesToStringUppercase(byte[] bArr) {
        AppMethodBeat.i(5224);
        String bytesToStringUppercase = bytesToStringUppercase(bArr, false);
        AppMethodBeat.o(5224);
        return bytesToStringUppercase;
    }

    public static String bytesToStringUppercase(byte[] bArr, boolean z) {
        AppMethodBeat.i(5225);
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        int i2 = 0;
        while (i2 < length && (!z || i2 != length - 1 || (bArr[i2] & 255) != 0)) {
            sb.append(zzzz[(bArr[i2] & 240) >>> 4]);
            sb.append(zzzz[bArr[i2] & 15]);
            i2++;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(5225);
        return sb2;
    }

    public static byte[] colonDelimitedStringToBytes(String str) {
        AppMethodBeat.i(5229);
        byte[] stringToBytes = stringToBytes(str.replace(":", ""));
        AppMethodBeat.o(5229);
        return stringToBytes;
    }

    public static byte[] stringToBytes(String str) {
        AppMethodBeat.i(5230);
        int length = str.length();
        if (length % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Hex string has odd number of characters");
            AppMethodBeat.o(5230);
            throw illegalArgumentException;
        }
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        AppMethodBeat.o(5230);
        return bArr;
    }
}
