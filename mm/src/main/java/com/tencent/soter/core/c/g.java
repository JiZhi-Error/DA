package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class g {
    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(88663);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(88663);
            return true;
        }
        AppMethodBeat.o(88663);
        return false;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static long OA(long j2) {
        AppMethodBeat.i(88664);
        long nanoTime = ((System.nanoTime() - j2) / 1000) / 1000;
        AppMethodBeat.o(88664);
        return nanoTime;
    }

    public static String getMessageDigest(byte[] bArr) {
        AppMethodBeat.i(88665);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            String str = new String(cArr2);
            AppMethodBeat.o(88665);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(88665);
            return null;
        }
    }
}
