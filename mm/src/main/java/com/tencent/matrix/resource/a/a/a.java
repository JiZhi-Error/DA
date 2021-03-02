package com.tencent.matrix.resource.a.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getMD5String(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                if (b2 < 0 || b2 > 15) {
                    sb.append(HEX_DIGITS[(b2 >> 4) & 15]).append(HEX_DIGITS[b2 & 15]);
                } else {
                    sb.append('0').append(HEX_DIGITS[b2]);
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
