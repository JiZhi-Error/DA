package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.xwalk.core.Log;

public final class a {
    private static String TAG = "AESUtil";

    public static SecretKey bsz(String str) {
        AppMethodBeat.i(156983);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bsA(str), "AES");
            AppMethodBeat.o(156983);
            return secretKeySpec;
        } catch (Throwable th) {
            Log.e(TAG, "makekey exp:" + th.getMessage());
            AppMethodBeat.o(156983);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, SecretKey secretKey) {
        AppMethodBeat.i(156984);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(156984);
            return doFinal;
        } catch (Throwable th) {
            Log.e(TAG, "decrypt exp:" + th.getMessage());
            AppMethodBeat.o(156984);
            return null;
        }
    }

    public static String a(String str, SecretKey secretKey) {
        AppMethodBeat.i(156985);
        byte[] a2 = a(bsA(str), secretKey);
        if (a2 == null) {
            AppMethodBeat.o(156985);
            return "";
        }
        String str2 = new String(a2);
        AppMethodBeat.o(156985);
        return str2;
    }

    public static byte[] bsA(String str) {
        AppMethodBeat.i(156986);
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        AppMethodBeat.o(156986);
        return bArr;
    }
}
