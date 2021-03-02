package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.soter.core.c.d;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FaceidManagerProxy {
    public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
    private static final String TAG = "Soter.FaceidManagerProxy";

    FaceidManagerProxy() {
    }

    static /* synthetic */ CryptoObject access$000(FaceManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(88575);
        CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
        AppMethodBeat.o(88575);
        return unwrapCryptoObject;
    }

    private static FaceManager getFaceManager(Context context) {
        FaceManager faceManager;
        AppMethodBeat.i(88567);
        try {
            faceManager = (FaceManager) Class.forName(FACEMANAGER_FACTORY_CLASS_NAME).getDeclaredMethod("getFaceManager", Context.class).invoke(null, context);
        } catch (Exception e2) {
            d.e(TAG, "soter: FaceManager init failed, maybe not support." + e2.toString(), new Object[0]);
            faceManager = null;
        }
        AppMethodBeat.o(88567);
        return faceManager;
    }

    public static boolean hasEnrolledFaceids(Context context) {
        boolean z = false;
        AppMethodBeat.i(88568);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                z = faceManager.hasEnrolledFaces();
                AppMethodBeat.o(88568);
            } else {
                d.e(TAG, "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
                AppMethodBeat.o(88568);
            }
        } catch (Exception e2) {
            d.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(88568);
        }
        return z;
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.i(88569);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                z = faceManager.isHardwareDetected();
                AppMethodBeat.o(88569);
            } else {
                d.e(TAG, "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
                AppMethodBeat.o(88569);
            }
        } catch (Exception e2) {
            d.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(88569);
        }
        return z;
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i2, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.i(88570);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                faceManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i2, wrapCallback(authenticationCallback), handler);
                AppMethodBeat.o(88570);
                return;
            }
            d.e(TAG, "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
            AppMethodBeat.o(88570);
        } catch (Exception e2) {
            d.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(88570);
        }
    }

    private static FaceManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        AppMethodBeat.i(88571);
        if (cryptoObject == null) {
            AppMethodBeat.o(88571);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            FaceManager.CryptoObject cryptoObject2 = new FaceManager.CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(88571);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            FaceManager.CryptoObject cryptoObject3 = new FaceManager.CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(88571);
            return cryptoObject3;
        } else if (cryptoObject.getMac() != null) {
            FaceManager.CryptoObject cryptoObject4 = new FaceManager.CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(88571);
            return cryptoObject4;
        } else {
            AppMethodBeat.o(88571);
            return null;
        }
    }

    private static CryptoObject unwrapCryptoObject(FaceManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(88572);
        if (cryptoObject == null) {
            AppMethodBeat.o(88572);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            CryptoObject cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(88572);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            CryptoObject cryptoObject3 = new CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(88572);
            return cryptoObject3;
        } else if (cryptoObject.getMac() != null) {
            CryptoObject cryptoObject4 = new CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(88572);
            return cryptoObject4;
        } else {
            AppMethodBeat.o(88572);
            return null;
        }
    }

    private static FaceManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        AppMethodBeat.i(88573);
        AnonymousClass1 r0 = new FaceManager.AuthenticationCallback() {
            /* class com.tencent.soter.core.biometric.FaceidManagerProxy.AnonymousClass1 */

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public final void onAuthenticationError(int i2, CharSequence charSequence) {
                AppMethodBeat.i(88563);
                d.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                authenticationCallback.onAuthenticationError(i2, charSequence);
                AppMethodBeat.o(88563);
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                AppMethodBeat.i(88564);
                d.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                authenticationCallback.onAuthenticationHelp(i2, charSequence);
                AppMethodBeat.o(88564);
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public final void onAuthenticationSucceeded(FaceManager.AuthenticationResult authenticationResult) {
                AppMethodBeat.i(88565);
                d.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerProxy.access$000(authenticationResult.getCryptoObject())));
                AppMethodBeat.o(88565);
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public final void onAuthenticationFailed() {
                AppMethodBeat.i(88566);
                d.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                authenticationCallback.onAuthenticationFailed();
                AppMethodBeat.o(88566);
            }
        };
        AppMethodBeat.o(88573);
        return r0;
    }

    public static String getBiometricName(Context context) {
        String str = null;
        AppMethodBeat.i(88574);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                str = faceManager.getBiometricName(context);
                AppMethodBeat.o(88574);
            } else {
                d.e(TAG, "soter: faceid manager is null! no biometric name returned.", new Object[0]);
                AppMethodBeat.o(88574);
            }
        } catch (Exception e2) {
            d.e(TAG, "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(88574);
        }
        return str;
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

    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
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

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationFailed() {
        }
    }
}
