package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l {
    private static final byte[] mAa = {18, 52, 86, 120, -112, -85, -51, -17};
    private static String mAb = null;

    public static String F(String str, String str2, String str3) {
        AppMethodBeat.i(234887);
        String str4 = null;
        if (!str.isEmpty()) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 99346:
                    if (str.equals("des")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str4 = dS(str2, str3);
                    break;
            }
        }
        AppMethodBeat.o(234887);
        return str4;
    }

    public static String G(String str, String str2, String str3) {
        AppMethodBeat.i(234888);
        String str4 = null;
        if (!str.isEmpty()) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 99346:
                    if (str.equals("des")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str4 = dT(str2, str3);
                    break;
            }
        }
        AppMethodBeat.o(234888);
        return str4;
    }

    private static String dS(String str, String str2) {
        AppMethodBeat.i(234889);
        if (str == null || str.length() < 8) {
            Exception exc = new Exception("secret key is not available");
            AppMethodBeat.o(234889);
            throw exc;
        } else if (str2 == null || str2.isEmpty()) {
            AppMethodBeat.o(234889);
            return null;
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                h.log(3, "SecretUtils", "start encode milles time = ".concat(String.valueOf(currentTimeMillis)));
                SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(1, generateSecret, new IvParameterSpec(mAa));
                String encode = b.encode(instance.doFinal(str2.getBytes()));
                h.log(3, "SecretUtils", "end encode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(234889);
                return encode;
            } catch (Exception e2) {
                h.log(6, "SecretUtils", "encode des error" + h.i(e2));
                AppMethodBeat.o(234889);
                throw e2;
            }
        }
    }

    private static String dT(String str, String str2) {
        AppMethodBeat.i(234890);
        if (str == null || str.length() < 8) {
            Exception exc = new Exception("secret key is not available");
            AppMethodBeat.o(234890);
            throw exc;
        }
        byte[] decode = b.decode(str2);
        if (decode.length == 0) {
            AppMethodBeat.o(234890);
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            h.log(3, "SecretUtils", "start decode milles time = ".concat(String.valueOf(currentTimeMillis)));
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec(mAa));
            String str3 = new String(instance.doFinal(decode));
            h.log(3, "SecretUtils", "end decode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(234890);
            return str3;
        } catch (Exception e2) {
            h.log(6, "SecretUtils", "decode des error" + h.i(e2));
            AppMethodBeat.o(234890);
            throw e2;
        }
    }

    public static synchronized String bKg() {
        String str;
        synchronized (l.class) {
            AppMethodBeat.i(234891);
            if (mAb == null) {
                mAb = bKh();
            }
            str = mAb;
            AppMethodBeat.o(234891);
        }
        return str;
    }

    private static String bKh() {
        AppMethodBeat.i(234892);
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
            StringBuffer stringBuffer = new StringBuffer(40);
            for (int i2 = 0; i2 < 20; i2++) {
                byte b2 = bArr[i2];
                stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15)).append("0123456789ABCDEF".charAt(b2 & 15));
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(234892);
            return stringBuffer2;
        } catch (Exception e2) {
            AppMethodBeat.o(234892);
            return null;
        }
    }
}
