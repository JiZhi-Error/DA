package com.tencent.mm.b;

import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static byte[] c(byte[] bArr, String str) {
        byte[] decode = Base64.decode(str.getBytes(), 0);
        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
        return instance.doFinal(bArr);
    }
}
