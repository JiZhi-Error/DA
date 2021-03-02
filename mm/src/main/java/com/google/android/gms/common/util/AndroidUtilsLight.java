package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
    public static final String DIGEST_ALGORITHM_SHA1 = "SHA1";
    public static final String DIGEST_ALGORITHM_SHA512 = "SHA-512";

    public static MessageDigest getMessageDigest(String str) {
        AppMethodBeat.i(5016);
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    AppMethodBeat.o(5016);
                    return instance;
                }
            } catch (NoSuchAlgorithmException e2) {
            }
        }
        AppMethodBeat.o(5016);
        return null;
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        AppMethodBeat.i(5015);
        byte[] packageCertificateHashBytes = getPackageCertificateHashBytes(context, str, DIGEST_ALGORITHM_SHA1);
        AppMethodBeat.o(5015);
        return packageCertificateHashBytes;
    }

    public static byte[] getPackageCertificateHashBytes(Context context, String str, String str2) {
        MessageDigest messageDigest;
        AppMethodBeat.i(5014);
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1 || (messageDigest = getMessageDigest(str2)) == null) {
            AppMethodBeat.o(5014);
            return null;
        }
        byte[] digest = messageDigest.digest(packageInfo.signatures[0].toByteArray());
        AppMethodBeat.o(5014);
        return digest;
    }
}
