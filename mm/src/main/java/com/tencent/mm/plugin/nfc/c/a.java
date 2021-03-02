package com.tencent.mm.plugin.nfc.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static final char[] lOU = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] b(short s) {
        return new byte[]{(byte) ((s >>> 8) & 255), (byte) (s & 255)};
    }

    public static String byteArrayToHexString(byte[] bArr) {
        AppMethodBeat.i(26677);
        if (bArr == null) {
            AppMethodBeat.o(26677);
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            cArr[i2 * 2] = lOU[i3 >>> 4];
            cArr[(i2 * 2) + 1] = lOU[i3 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(26677);
        return str;
    }

    public static byte[] hexStringToByteArray(String str) {
        AppMethodBeat.i(26678);
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        AppMethodBeat.o(26678);
        return bArr;
    }
}
