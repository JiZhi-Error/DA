package com.tencent.soter.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
@Deprecated
final class b {
    static FingerprintManager getFingerprintManager(Context context) {
        AppMethodBeat.i(88619);
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        AppMethodBeat.o(88619);
        return fingerprintManager;
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean z = false;
        AppMethodBeat.i(88620);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            AppMethodBeat.o(88620);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.hasEnrolledFingerprints();
                    AppMethodBeat.o(88620);
                } else {
                    d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
                    AppMethodBeat.o(88620);
                }
            } catch (SecurityException e2) {
                d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(88620);
            }
        }
        return z;
    }

    static int checkSelfPermission(Context context, String str) {
        AppMethodBeat.i(88621);
        if (context == null) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            AppMethodBeat.o(88621);
            return -1;
        } else if (g.isNullOrNil(str)) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            AppMethodBeat.o(88621);
            return -1;
        } else if (Build.VERSION.SDK_INT < 23) {
            d.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
            AppMethodBeat.o(88621);
            return 0;
        } else {
            int checkSelfPermission = context.checkSelfPermission(str);
            AppMethodBeat.o(88621);
            return checkSelfPermission;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.i(88622);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
            AppMethodBeat.o(88622);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.isHardwareDetected();
                    AppMethodBeat.o(88622);
                } else {
                    d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
                    AppMethodBeat.o(88622);
                }
            } catch (SecurityException e2) {
                d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(88622);
            }
        }
        return z;
    }

    public static class c {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public c(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public c(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public c(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    /* renamed from: com.tencent.soter.core.a.b$b  reason: collision with other inner class name */
    public static final class C2191b {
        c RPo;

        public C2191b(c cVar) {
            this.RPo = cVar;
        }
    }

    public static abstract class a {
        public void onAuthenticationError(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public void a(C2191b bVar) {
        }

        public void onAuthenticationFailed() {
        }
    }
}
