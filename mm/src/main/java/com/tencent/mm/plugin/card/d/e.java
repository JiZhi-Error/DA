package com.tencent.mm.plugin.card.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class e {
    public static String fx(String str, String str2) {
        String str3;
        AppMethodBeat.i(113772);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.o(113772);
            return null;
        }
        g.aAf();
        try {
            byte[] be = be(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.getUin() + "_" + str).getBytes());
            byte[] ajV = ajV(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(be, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            str3 = new String(instance.doFinal(ajV));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e2, "", new Object[0]);
            str3 = null;
        }
        AppMethodBeat.o(113772);
        return str3;
    }

    public static String fy(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(113773);
        if (str2 == null || str2.length() <= 0) {
            AppMethodBeat.o(113773);
        } else {
            g.aAf();
            try {
                byte[] be = be(("CbW9HMPiil38ldOjZp5WkwlIfzvLwiX6_" + a.getUin() + "_" + str).getBytes());
                byte[] bytes = str2.getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(be, "AES");
                Cipher instance = Cipher.getInstance("AES");
                instance.init(1, secretKeySpec);
                str3 = bd(instance.doFinal(bytes));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e2, "", new Object[0]);
            }
            AppMethodBeat.o(113773);
        }
        return str3;
    }

    private static String bd(byte[] bArr) {
        AppMethodBeat.i(113774);
        if (bArr == null) {
            AppMethodBeat.o(113774);
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append("0123456789ABCDEF".charAt((bArr[i2] >> 4) & 15)).append("0123456789ABCDEF".charAt(bArr[i2] & 15));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(113774);
        return sb2;
    }

    private static byte[] ajV(String str) {
        AppMethodBeat.i(113775);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = Integer.valueOf(str.substring(i2 * 2, (i2 * 2) + 2), 16).byteValue();
        }
        AppMethodBeat.o(113775);
        return bArr;
    }

    private static byte[] be(byte[] bArr) {
        AppMethodBeat.i(113776);
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(128, instance2);
        byte[] encoded = instance.generateKey().getEncoded();
        AppMethodBeat.o(113776);
        return encoded;
    }

    public static String fz(String str, String str2) {
        AppMethodBeat.i(113777);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(113777);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(str);
        sb.append("&");
        sb.append(currentTimeMillis);
        sb.append("&");
        sb.append(str2);
        try {
            String fA = fA(sb.toString(), str2);
            sb2.append(str);
            sb2.append("&");
            sb2.append(currentTimeMillis);
            sb2.append("&");
            sb2.append(fA);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e2, "", new Object[0]);
        }
        String sb3 = sb2.toString();
        AppMethodBeat.o(113777);
        return sb3;
    }

    private static String fA(String str, String str2) {
        AppMethodBeat.i(113778);
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
            Log.i("MicroMsg.CardDymanicQrcodeOfflineHelper", "hash is: ".concat(String.valueOf(encodeToString)));
            AppMethodBeat.o(113778);
            return encodeToString;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardDymanicQrcodeOfflineHelper", e2, "", new Object[0]);
            AppMethodBeat.o(113778);
            return "";
        }
    }
}
