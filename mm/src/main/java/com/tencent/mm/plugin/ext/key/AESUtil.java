package com.tencent.mm.plugin.ext.key;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class AESUtil {
    private static char[] iNl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static SecretKey sMx = null;

    private static void cSo() {
        AppMethodBeat.i(24364);
        try {
            if (sMx == null) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(aha("aced00057372001f6a617661782e63727970746f2e737065632e5365637265744b6579537065635b470b66e230614d0200024c0009616c676f726974686d7400124c6a6176612f6c616e672f537472696e673b5b00036b65797400025b427870740003414553757200025b42acf317f8060854e0020000787000000010402a2173bd6f2542e5e71ee414b2e1e8")));
                sMx = (SecretKey) objectInputStream.readObject();
                objectInputStream.close();
            }
            AppMethodBeat.o(24364);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AESUtil", e2, "", new Object[0]);
            AppMethodBeat.o(24364);
        }
    }

    private static byte[] arn(String str) {
        AppMethodBeat.i(24365);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(24365);
            return null;
        }
        cSo();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, sMx);
        byte[] doFinal = instance.doFinal(str.getBytes("UTF8"));
        AppMethodBeat.o(24365);
        return doFinal;
    }

    public static String DC(long j2) {
        AppMethodBeat.i(24366);
        byte[] arn = arn(String.valueOf(j2));
        if (arn == null) {
            AppMethodBeat.o(24366);
            return null;
        }
        StringBuilder sb = new StringBuilder(arn.length * 2);
        for (int i2 = 0; i2 < arn.length; i2++) {
            sb.append(iNl[(arn[i2] & 240) >>> 4]);
            sb.append(iNl[arn[i2] & 15]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(24366);
        return sb2;
    }

    private static String ahb(String str) {
        AppMethodBeat.i(24367);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(24367);
            return null;
        }
        cSo();
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, sMx);
        String str2 = new String(instance.doFinal(aha(str)), "UTF8");
        AppMethodBeat.o(24367);
        return str2;
    }

    public static long aro(String str) {
        AppMethodBeat.i(24368);
        long longValue = Long.valueOf(ahb(str).trim()).longValue();
        AppMethodBeat.o(24368);
        return longValue;
    }

    private static byte[] aha(String str) {
        AppMethodBeat.i(24369);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(24369);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16);
        }
        AppMethodBeat.o(24369);
        return bArr;
    }
}
