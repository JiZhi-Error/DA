package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final char[] mzE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] mzF = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String encode(byte[] bArr) {
        AppMethodBeat.i(234835);
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        int i2 = length + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(mzE[(bArr[i3] & 240) >> 4]);
            sb.append(mzE[bArr[i3] & 15]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(234835);
        return sb2;
    }

    public static byte[] decode(String str) {
        AppMethodBeat.i(234836);
        byte[] bArr = new byte[(str.length() / 2)];
        int length = (str.length() / 2) * 2;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int i5 = mzF[str.charAt(i3)] << 4;
            i3 = i4 + 1;
            bArr[i2] = (byte) (i5 | mzF[str.charAt(i4)]);
            i2++;
        }
        AppMethodBeat.o(234836);
        return bArr;
    }
}
