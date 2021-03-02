package com.tencent.tbs.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static synchronized byte[] h(String str, String str2, byte[] bArr) {
        byte[] bytes;
        synchronized (a.class) {
            AppMethodBeat.i(174273);
            byte[] nJ = nJ(str, str2);
            if (nJ != null) {
                bytes = new byte[(bArr.length + nJ.length + 2)];
                System.arraycopy(bArr, 0, bytes, 0, bArr.length);
                int length = bArr.length + 0;
                System.arraycopy(nJ, 0, bytes, length, nJ.length);
                System.arraycopy(new byte[]{10, 10}, 0, bytes, nJ.length + length, 2);
                AppMethodBeat.o(174273);
            } else {
                bytes = str2.getBytes();
                AppMethodBeat.o(174273);
            }
        }
        return bytes;
    }

    private static byte[] nJ(String str, String str2) {
        AppMethodBeat.i(174274);
        try {
            byte[] bytes = str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "RC4"));
            byte[] update = instance.update(bytes);
            AppMethodBeat.o(174274);
            return update;
        } catch (Exception e2) {
            AppMethodBeat.o(174274);
            return null;
        }
    }

    private static byte[] nK(String str, String str2) {
        AppMethodBeat.i(174275);
        try {
            byte[] bytes = str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "RC4"));
            byte[] update = instance.update(bytes);
            AppMethodBeat.o(174275);
            return update;
        } catch (Exception e2) {
            AppMethodBeat.o(174275);
            return null;
        }
    }

    public static byte[] nL(String str, String str2) {
        AppMethodBeat.i(174276);
        try {
            byte[] nK = nK(str, str2);
            if (nK == null) {
                AppMethodBeat.o(174276);
                return null;
            }
            String format = String.format(Locale.US, "%03d", Integer.valueOf(nK.length));
            byte[] bArr = new byte[(nK.length + 3)];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(nK, 0, bArr, 3, nK.length);
            AppMethodBeat.o(174276);
            return bArr;
        } catch (Exception e2) {
            AppMethodBeat.o(174276);
            return null;
        }
    }
}
