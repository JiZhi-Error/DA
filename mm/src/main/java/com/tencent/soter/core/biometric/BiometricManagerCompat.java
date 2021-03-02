package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a;
import com.tencent.soter.core.biometric.FaceidManagerProxy;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import com.tencent.soter.core.c.d;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class BiometricManagerCompat {
    static final Map<Integer, IBiometricManager> IMPL_PROVIDER = new HashMap();
    private static final String TAG = "Soter.BiometricManagerCompat";
    private Integer mBiometricType;
    private Context mContext;

    /* access modifiers changed from: package-private */
    public interface IBiometricManager {
        void authenticate(Context context, CryptoObject cryptoObject, int i2, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        String getBiometricName(Context context);

        boolean hasEnrolledBiometric(Context context);

        boolean isHardwareDetected(Context context);
    }

    public static BiometricManagerCompat from(Context context, Integer num) {
        AppMethodBeat.i(88554);
        BiometricManagerCompat biometricManagerCompat = new BiometricManagerCompat(context, num);
        AppMethodBeat.o(88554);
        return biometricManagerCompat;
    }

    private BiometricManagerCompat(Context context, Integer num) {
        this.mContext = context;
        this.mBiometricType = num;
    }

    static {
        IBiometricManager legacyFingerprintManagerImpl;
        AppMethodBeat.i(88562);
        if (a.hlj()) {
            legacyFingerprintManagerImpl = new FingerprintManagerImpl();
        } else {
            legacyFingerprintManagerImpl = new LegacyFingerprintManagerImpl();
        }
        IMPL_PROVIDER.put(1, legacyFingerprintManagerImpl);
        if (a.hlj() && isNativeSupportFaceid()) {
            IMPL_PROVIDER.put(2, new FaceidManagerImpl());
        }
        AppMethodBeat.o(88562);
    }

    public static boolean isNativeSupportFaceid() {
        AppMethodBeat.i(88555);
        try {
            Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME);
            AppMethodBeat.o(88555);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(88555);
            return false;
        }
    }

    public boolean hasEnrolledBiometric() {
        AppMethodBeat.i(88556);
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            d.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.o(88556);
            return false;
        }
        boolean hasEnrolledBiometric = iBiometricManager.hasEnrolledBiometric(this.mContext);
        AppMethodBeat.o(88556);
        return hasEnrolledBiometric;
    }

    public String getBiometricName() {
        AppMethodBeat.i(88557);
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            d.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.o(88557);
            return null;
        }
        String biometricName = iBiometricManager.getBiometricName(this.mContext);
        AppMethodBeat.o(88557);
        return biometricName;
    }

    public boolean isHardwareDetected() {
        AppMethodBeat.i(88558);
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            d.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.o(88558);
            return false;
        }
        boolean isHardwareDetected = iBiometricManager.isHardwareDetected(this.mContext);
        AppMethodBeat.o(88558);
        return isHardwareDetected;
    }

    public boolean isCurrentFailTimeAvailable() {
        AppMethodBeat.i(88559);
        boolean isCurrentFailTimeAvailable = SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
        AppMethodBeat.o(88559);
        return isCurrentFailTimeAvailable;
    }

    public boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.i(88560);
        boolean isCurrentTweenTimeAvailable = SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
        AppMethodBeat.o(88560);
        return isCurrentTweenTimeAvailable;
    }

    public void authenticate(CryptoObject cryptoObject, int i2, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.i(88561);
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            d.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            authenticationCallback.onAuthenticationCancelled();
        }
        iBiometricManager.authenticate(this.mContext, cryptoObject, i2, cancellationSignal, authenticationCallback, handler);
        AppMethodBeat.o(88561);
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

        public void onAuthenticationCancelled() {
        }
    }

    static class LegacyFingerprintManagerImpl implements IBiometricManager {
        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            return null;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i2, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }
    }

    static class FingerprintManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";

        static /* synthetic */ boolean access$000(FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.i(88551);
            boolean shouldInformTooManyTrial = shouldInformTooManyTrial(authenticationCallback, context);
            AppMethodBeat.o(88551);
            return shouldInformTooManyTrial;
        }

        static /* synthetic */ CryptoObject access$100(FingerprintManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.i(88552);
            CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
            AppMethodBeat.o(88552);
            return unwrapCryptoObject;
        }

        static /* synthetic */ void access$200(FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88553);
            informTooManyTrial(authenticationCallback);
            AppMethodBeat.o(88553);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            AppMethodBeat.i(88543);
            boolean hasEnrolledFingerprints = FingerprintManagerProxy.hasEnrolledFingerprints(context);
            AppMethodBeat.o(88543);
            return hasEnrolledFingerprints;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            AppMethodBeat.i(88544);
            boolean isHardwareDetected = FingerprintManagerProxy.isHardwareDetected(context);
            AppMethodBeat.o(88544);
            return isHardwareDetected;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            return FingerprintManagerProxy.FINGERPRINT_SERVICE;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i2, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            AppMethodBeat.i(88545);
            FingerprintManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i2, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            AppMethodBeat.o(88545);
        }

        private static FingerprintManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            AppMethodBeat.i(88546);
            if (cryptoObject == null) {
                AppMethodBeat.o(88546);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                FingerprintManagerProxy.CryptoObject cryptoObject2 = new FingerprintManagerProxy.CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.o(88546);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                FingerprintManagerProxy.CryptoObject cryptoObject3 = new FingerprintManagerProxy.CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.o(88546);
                return cryptoObject3;
            } else if (cryptoObject.getMac() != null) {
                FingerprintManagerProxy.CryptoObject cryptoObject4 = new FingerprintManagerProxy.CryptoObject(cryptoObject.getMac());
                AppMethodBeat.o(88546);
                return cryptoObject4;
            } else {
                AppMethodBeat.o(88546);
                return null;
            }
        }

        private static CryptoObject unwrapCryptoObject(FingerprintManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.i(88547);
            if (cryptoObject == null) {
                AppMethodBeat.o(88547);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                CryptoObject cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.o(88547);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                CryptoObject cryptoObject3 = new CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.o(88547);
                return cryptoObject3;
            } else if (cryptoObject.getMac() != null) {
                CryptoObject cryptoObject4 = new CryptoObject(cryptoObject.getMac());
                AppMethodBeat.o(88547);
                return cryptoObject4;
            } else {
                AppMethodBeat.o(88547);
                return null;
            }
        }

        private static FingerprintManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88548);
            AnonymousClass1 r0 = new FingerprintManagerProxy.AuthenticationCallback() {
                /* class com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl.AnonymousClass1 */
                private boolean mMarkPermanentlyCallbacked = false;

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public final void onAuthenticationError(int i2, CharSequence charSequence) {
                    AppMethodBeat.i(88539);
                    while (true) {
                        d.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationError", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.o(88539);
                            return;
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        if (i2 == 5 || i2 == 10) {
                            d.i(FingerprintManagerImpl.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                            authenticationCallback.onAuthenticationCancelled();
                            AppMethodBeat.o(88539);
                        } else if (i2 == 7 || i2 == 9) {
                            d.i(FingerprintManagerImpl.TAG, "soter: system call too many trial.", new Object[0]);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                                SoterBiometricAntiBruteForceStrategy.freeze(context);
                            }
                            this.mMarkPermanentlyCallbacked = false;
                            if (i2 == 7) {
                                i2 = 10308;
                                charSequence = "Too many failed times";
                            } else {
                                i2 = 10309;
                                charSequence = "Too many failed times";
                            }
                        } else {
                            authenticationCallback.onAuthenticationError(i2, charSequence);
                            AppMethodBeat.o(88539);
                            return;
                        }
                    }
                    d.i(FingerprintManagerImpl.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                    authenticationCallback.onAuthenticationCancelled();
                    AppMethodBeat.o(88539);
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                    AppMethodBeat.i(88540);
                    d.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationHelp", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88540);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        authenticationCallback.onAuthenticationHelp(i2, charSequence);
                    }
                    AppMethodBeat.o(88540);
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public final void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal authenticationResultInternal) {
                    AppMethodBeat.i(88541);
                    d.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88541);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerImpl.access$100(authenticationResultInternal.getCryptoObject())));
                    }
                    AppMethodBeat.o(88541);
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public final void onAuthenticationFailed() {
                    AppMethodBeat.i(88542);
                    d.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88542);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                                d.w(FingerprintManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                                SoterBiometricAntiBruteForceStrategy.freeze(context);
                                FingerprintManagerImpl.access$200(this);
                                AppMethodBeat.o(88542);
                                return;
                            }
                        }
                        authenticationCallback.onAuthenticationFailed();
                    }
                    AppMethodBeat.o(88542);
                }
            };
            AppMethodBeat.o(88548);
            return r0;
        }

        private static boolean shouldInformTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.i(88549);
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                d.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.o(88549);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    d.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                AppMethodBeat.o(88549);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                d.v(TAG, "soter: failure time available", new Object[0]);
                AppMethodBeat.o(88549);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                AppMethodBeat.o(88549);
                return true;
            }
        }

        private static void informTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88550);
            d.w(TAG, "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.o(88550);
        }
    }

    static class FaceidManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Faceid";

        static /* synthetic */ boolean access$300(FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.i(88536);
            boolean shouldInformTooManyTrial = shouldInformTooManyTrial(authenticationCallback, context);
            AppMethodBeat.o(88536);
            return shouldInformTooManyTrial;
        }

        static /* synthetic */ CryptoObject access$400(FaceidManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.i(88537);
            CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
            AppMethodBeat.o(88537);
            return unwrapCryptoObject;
        }

        static /* synthetic */ void access$500(FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88538);
            informTooManyTrial(authenticationCallback);
            AppMethodBeat.o(88538);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            AppMethodBeat.i(88527);
            boolean hasEnrolledFaceids = FaceidManagerProxy.hasEnrolledFaceids(context);
            AppMethodBeat.o(88527);
            return hasEnrolledFaceids;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            AppMethodBeat.i(88528);
            boolean isHardwareDetected = FaceidManagerProxy.isHardwareDetected(context);
            AppMethodBeat.o(88528);
            return isHardwareDetected;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            AppMethodBeat.i(88529);
            String biometricName = FaceidManagerProxy.getBiometricName(context);
            AppMethodBeat.o(88529);
            return biometricName;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i2, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            AppMethodBeat.i(88530);
            FaceidManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i2, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            AppMethodBeat.o(88530);
        }

        private static FaceidManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            AppMethodBeat.i(88531);
            if (cryptoObject == null) {
                AppMethodBeat.o(88531);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                FaceidManagerProxy.CryptoObject cryptoObject2 = new FaceidManagerProxy.CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.o(88531);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                FaceidManagerProxy.CryptoObject cryptoObject3 = new FaceidManagerProxy.CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.o(88531);
                return cryptoObject3;
            } else if (cryptoObject.getMac() != null) {
                FaceidManagerProxy.CryptoObject cryptoObject4 = new FaceidManagerProxy.CryptoObject(cryptoObject.getMac());
                AppMethodBeat.o(88531);
                return cryptoObject4;
            } else {
                AppMethodBeat.o(88531);
                return null;
            }
        }

        private static CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.i(88532);
            if (cryptoObject == null) {
                AppMethodBeat.o(88532);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                CryptoObject cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.o(88532);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                CryptoObject cryptoObject3 = new CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.o(88532);
                return cryptoObject3;
            } else if (cryptoObject.getMac() != null) {
                CryptoObject cryptoObject4 = new CryptoObject(cryptoObject.getMac());
                AppMethodBeat.o(88532);
                return cryptoObject4;
            } else {
                AppMethodBeat.o(88532);
                return null;
            }
        }

        private static FaceidManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88533);
            AnonymousClass1 r0 = new FaceidManagerProxy.AuthenticationCallback() {
                /* class com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl.AnonymousClass1 */
                private boolean mMarkPermanentlyCallbacked = false;

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public final void onAuthenticationError(int i2, CharSequence charSequence) {
                    AppMethodBeat.i(88523);
                    d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] entered.", Integer.valueOf(i2), charSequence);
                    if (this.mMarkPermanentlyCallbacked) {
                        d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", Integer.valueOf(i2), charSequence);
                        AppMethodBeat.o(88523);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i2 == 5) {
                        d.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", Integer.valueOf(i2), charSequence);
                        authenticationCallback.onAuthenticationCancelled();
                        AppMethodBeat.o(88523);
                    } else if (i2 == 7) {
                        d.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", Integer.valueOf(i2), charSequence);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                        }
                        authenticationCallback.onAuthenticationError(10308, "Too many failed times");
                        AppMethodBeat.o(88523);
                    } else {
                        d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", Integer.valueOf(i2), charSequence);
                        authenticationCallback.onAuthenticationError(i2, charSequence);
                        AppMethodBeat.o(88523);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
                    AppMethodBeat.i(88524);
                    d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", Integer.valueOf(i2), charSequence);
                    System.currentTimeMillis();
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88524);
                        return;
                    }
                    if (!FaceidManagerImpl.access$300(this, context)) {
                        authenticationCallback.onAuthenticationHelp(i2, charSequence);
                    }
                    AppMethodBeat.o(88524);
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public final void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult authenticationResult) {
                    AppMethodBeat.i(88525);
                    d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88525);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.access$300(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerImpl.access$400(authenticationResult.getCryptoObject())));
                    }
                    AppMethodBeat.o(88525);
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public final void onAuthenticationFailed() {
                    AppMethodBeat.i(88526);
                    d.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.o(88526);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.access$300(this, context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                        SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                            d.w(FaceidManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                            FaceidManagerImpl.access$500(this);
                            AppMethodBeat.o(88526);
                            return;
                        }
                    }
                    authenticationCallback.onAuthenticationFailed();
                    AppMethodBeat.o(88526);
                }
            };
            AppMethodBeat.o(88533);
            return r0;
        }

        private static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.i(88534);
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                d.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.o(88534);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    d.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                AppMethodBeat.o(88534);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                d.v(TAG, "soter: failure time available", new Object[0]);
                AppMethodBeat.o(88534);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                AppMethodBeat.o(88534);
                return true;
            }
        }

        private static void informTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.i(88535);
            d.w(TAG, "soter: too many fail callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.o(88535);
        }
    }
}
