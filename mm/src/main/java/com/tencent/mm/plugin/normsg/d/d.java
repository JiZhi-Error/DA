package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String L(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(149089);
        char[] cArr = new char[((i3 - i2) * 2)];
        int i4 = 0;
        while (i2 < i3) {
            byte b2 = bArr[i2];
            int i5 = i4 + 1;
            cArr[i4] = HEX_DIGITS[(b2 >>> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = HEX_DIGITS[b2 & 15];
            i2++;
        }
        String str = new String(cArr);
        AppMethodBeat.o(149089);
        return str;
    }

    public static String aIJ(String str) {
        AppMethodBeat.i(149090);
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 1;
        while (true) {
            int i3 = 0;
            try {
                i3 = str.charAt(i2 - 1) ^ str.charAt(i2);
                if (i2 + 1 == str.length()) {
                    try {
                        sb.append((char) i3);
                        String sb2 = sb.toString();
                        AppMethodBeat.o(149090);
                        return sb2;
                    } catch (Throwable th) {
                        String sb3 = sb.toString();
                        AppMethodBeat.o(149090);
                        return sb3;
                    }
                } else {
                    try {
                        sb.append((char) i3);
                        i2++;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                sb.append((char) i3);
                throw th3;
            } finally {
                AppMethodBeat.o(149090);
            }
        }
    }
}
