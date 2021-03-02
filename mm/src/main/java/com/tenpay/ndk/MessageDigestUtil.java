package com.tenpay.ndk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessageDigestUtil {
    private native byte[] doSHA256(byte[] bArr);

    public static String bytesToHex(byte[] bArr) {
        AppMethodBeat.i(73325);
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(73325);
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString.toUpperCase());
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(73325);
        return sb2;
    }

    public String getSHA256Hex(byte[] bArr) {
        AppMethodBeat.i(73326);
        String str = null;
        if (bArr != null) {
            try {
                byte[] doSHA256 = doSHA256(bArr);
                if (doSHA256 != null) {
                    str = bytesToHex(doSHA256);
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(73326);
        return str;
    }
}
