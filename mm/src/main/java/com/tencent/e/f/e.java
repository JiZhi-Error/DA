package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class e {
    public static byte[] bqe(String str) {
        AppMethodBeat.i(138474);
        if (str == null) {
            AppMethodBeat.o(138474);
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i3])) << 4));
        }
        AppMethodBeat.o(138474);
        return bArr;
    }

    public static final String bytesToHexString(byte[] bArr) {
        AppMethodBeat.i(138475);
        if (bArr == null) {
            AppMethodBeat.o(138475);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(138475);
        return stringBuffer2;
    }

    public static byte[] cX(byte[] bArr) {
        AppMethodBeat.i(138476);
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Exception | NoSuchAlgorithmException e2) {
        }
        AppMethodBeat.o(138476);
        return bArr2;
    }
}
