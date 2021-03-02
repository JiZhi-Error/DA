package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2encoder;
import java.io.UnsupportedEncodingException;

public class HexUtil {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public static String byte2HexStr(byte b2) {
        AppMethodBeat.i(109737);
        char[] cArr = new char[2];
        cArr[1] = digits[b2 & 15];
        cArr[0] = digits[((byte) (b2 >>> 4)) & 15];
        String str = new String(cArr);
        AppMethodBeat.o(109737);
        return str;
    }

    public static String bytes2HexStr(byte[] bArr) {
        AppMethodBeat.i(109738);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(109738);
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            cArr[(i2 * 2) + 1] = digits[b2 & 15];
            cArr[(i2 * 2) + 0] = digits[((byte) (b2 >>> 4)) & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(109738);
        return str;
    }

    public static byte hexStr2Byte(String str) {
        AppMethodBeat.i(109739);
        if (str == null || str.length() != 1) {
            AppMethodBeat.o(109739);
            return 0;
        }
        byte char2Byte = char2Byte(str.charAt(0));
        AppMethodBeat.o(109739);
        return char2Byte;
    }

    public static byte char2Byte(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return (byte) (c2 - '0');
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (byte) ((c2 - 'a') + 10);
        }
        if (c2 < 'A' || c2 > 'F') {
            return 0;
        }
        return (byte) ((c2 - 'A') + 10);
    }

    public static byte[] hexStr2Bytes(String str) {
        AppMethodBeat.i(109740);
        if (str == null || str.equals("")) {
            byte[] bArr = emptybytes;
            AppMethodBeat.o(109740);
            return bArr;
        }
        byte[] bArr2 = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr2[i2] = (byte) ((char2Byte(str.charAt(i2 * 2)) * v2encoder.enumCODEC_vcodec2) + char2Byte(str.charAt((i2 * 2) + 1)));
        }
        AppMethodBeat.o(109740);
        return bArr2;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.i(109741);
        try {
            System.out.println(bytes2HexStr("Hello WebSocket World?".getBytes("gbk")));
            AppMethodBeat.o(109741);
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(109741);
        }
    }
}
