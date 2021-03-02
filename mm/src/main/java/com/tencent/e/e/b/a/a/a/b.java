package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class b {
    public static Signature[] cQ(Context context, String str) {
        Signature[] signatureArr;
        AppMethodBeat.i(138437);
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Throwable th) {
            signatureArr = null;
        }
        AppMethodBeat.o(138437);
        return signatureArr;
    }

    public static String a(Signature signature, String str) {
        String str2 = null;
        AppMethodBeat.i(138438);
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (instance == null) {
                AppMethodBeat.o(138438);
                return str2;
            }
            byte[] digest = instance.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            str2 = sb.toString();
            AppMethodBeat.o(138438);
            return str2;
        } catch (NoSuchAlgorithmException e2) {
        }
    }
}
