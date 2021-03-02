package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FingerprintManagerProxy {
    public static final String FINGERPRINT_SERVICE = "fingerprint";
    private static final String TAG = "Soter.FingerprintManagerProxy";

    FingerprintManagerProxy() {
    }

    static /* synthetic */ CryptoObject access$000(FingerprintManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(88588);
        CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
        AppMethodBeat.o(88588);
        return unwrapCryptoObject;
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        AppMethodBeat.i(88580);
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FINGERPRINT_SERVICE);
        AppMethodBeat.o(88580);
        return fingerprintManager;
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean z = false;
        AppMethodBeat.i(88581);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
            AppMethodBeat.o(88581);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.hasEnrolledFingerprints();
                    AppMethodBeat.o(88581);
                } else {
                    d.e(TAG, "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
                    AppMethodBeat.o(88581);
                }
            } catch (SecurityException e2) {
                d.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(88581);
            }
        }
        return z;
    }

    private static int checkSelfPermission(Context context, String str) {
        AppMethodBeat.i(88582);
        if (context == null) {
            d.e(TAG, "soter: check self permission: context is null", new Object[0]);
            AppMethodBeat.o(88582);
            return -1;
        } else if (g.isNullOrNil(str)) {
            d.e(TAG, "soter: requested permission is null or nil", new Object[0]);
            AppMethodBeat.o(88582);
            return -1;
        } else if (Build.VERSION.SDK_INT < 23) {
            d.d(TAG, "soter: below 23. directly return.", new Object[0]);
            AppMethodBeat.o(88582);
            return 0;
        } else {
            int checkSelfPermission = context.checkSelfPermission(str);
            AppMethodBeat.o(88582);
            return checkSelfPermission;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.i(88583);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: isHardwareDetected", new Object[0]);
            AppMethodBeat.o(88583);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.isHardwareDetected();
                    AppMethodBeat.o(88583);
                } else {
                    d.e(TAG, "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
                    AppMethodBeat.o(88583);
                }
            } catch (SecurityException e2) {
                d.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(88583);
            }
        }
        return z;
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i2, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.i(88584);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            AppMethodBeat.o(88584);
            return;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                fingerprintManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i2, wrapCallback(authenticationCallback), handler);
                AppMethodBeat.o(88584);
                return;
            }
            d.e(TAG, "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            AppMethodBeat.o(88584);
        } catch (SecurityException e2) {
            d.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(88584);
        }
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        AppMethodBeat.i(88585);
        if (cryptoObject == null) {
            AppMethodBeat.o(88585);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            FingerprintManager.CryptoObject cryptoObject2 = new FingerprintManager.CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(88585);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            FingerprintManager.CryptoObject cryptoObject3 = new FingerprintManager.CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(88585);
            return cryptoObject3;
        } else if (cryptoObject.getMac() != null) {
            FingerprintManager.CryptoObject cryptoObject4 = new FingerprintManager.CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(88585);
            return cryptoObject4;
        } else {
            AppMethodBeat.o(88585);
            return null;
        }
    }

    private static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(88586);
        if (cryptoObject == null) {
            AppMethodBeat.o(88586);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            CryptoObject cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(88586);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            CryptoObject cryptoObject3 = new CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(88586);
            return cryptoObject3;
        } else if (cryptoObject.getMac() != null) {
            CryptoObject cryptoObject4 = new CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(88586);
            return cryptoObject4;
        } else {
            AppMethodBeat.o(88586);
            return null;
        }
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        AppMethodBeat.i(88587);
        AnonymousClass1 r0 = new FingerprintManager.AuthenticationCallback() {
            /* class com.tencent.soter.core.biometric.FingerprintManagerProxy.AnonymousClass1 */

            public final void onAuthenticationError(int i2, CharSequence charSequence) {
                AppMethodBeat.i(88576);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                authenticationCallback.onAuthenticationError(i2, charSequence);
                AppMethodBeat.o(88576);
            }

            public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                AppMethodBeat.i(88577);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                authenticationCallback.onAuthenticationHelp(i2, charSequence);
                AppMethodBeat.o(88577);
            }

            public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AppMethodBeat.i(88578);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.access$000(authenticationResult.getCryptoObject())));
                AppMethodBeat.o(88578);
            }

            public final void onAuthenticationFailed() {
                AppMethodBeat.i(88579);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                authenticationCallback.onAuthenticationFailed();
                AppMethodBeat.o(88579);
            }
        };
        AppMethodBeat.o(88587);
        return r0;
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }
    }

    public static final class AuthenticationResultInternal {
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public final CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void onAuthenticationFailed() {
        }
    }
}
