package com.tencent.mars.cdn;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    public static final int STATE_APPBRAND = 1;
    public static final int STATE_CDN = 0;
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = new Object();
    private static o sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    public static final class CertVerifyStatusAndroid {
        public static final int EXPIRED = -3;
        public static final int FAILED = -1;
        public static final int INCORRECT_KEY_USAGE = -6;
        public static final int NOT_YET_VALID = -4;
        public static final int NO_TRUSTED_ROOT = -2;
        public static final int OK = 0;
        public static final int UNABLE_TO_PARSE = -5;
    }

    /* access modifiers changed from: package-private */
    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2);
    }

    static {
        boolean z;
        if (!X509Util.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
    }

    /* access modifiers changed from: package-private */
    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        public final void onReceive(Context context, Intent intent) {
            boolean equals;
            if (Build.VERSION.SDK_INT < 26) {
                equals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            } else if ("android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) || "android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction())) {
                equals = true;
            } else if (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)) {
                equals = false;
            } else {
                equals = true;
            }
            if (equals) {
                try {
                    X509Util.reloadDefaultTrustManager();
                } catch (CertificateException e2) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e2);
                } catch (KeyStoreException e3) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e3);
                } catch (NoSuchAlgorithmException e4) {
                    Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            this.mTrustManager = x509TrustManager;
        }

        @Override // com.tencent.mars.cdn.X509Util.X509TrustManagerImplementation
        public final List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }

        @Override // com.tencent.mars.cdn.X509Util.X509TrustManagerImplementation
        @SuppressLint({"NewApi"})
        public final List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            return this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    private static void ensureInitialized() {
        synchronized (sLock) {
            ensureInitializedLocked();
        }
    }

    private static void ensureInitializedLocked() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            if (sCertificateFactory == null) {
                sCertificateFactory = CertificateFactory.getInstance("X.509");
            }
            if (sDefaultTrustManager == null) {
                sDefaultTrustManager = createTrustManager(null);
            }
            if (!sLoadedSystemKeyStore) {
                try {
                    sSystemKeyStore = KeyStore.getInstance("AndroidCAStore");
                    try {
                        sSystemKeyStore.load(null);
                    } catch (IOException e2) {
                    }
                    sSystemCertificateDirectory = new o(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
                } catch (KeyStoreException e3) {
                }
                sLoadedSystemKeyStore = true;
            }
            if (sSystemTrustAnchorCache == null) {
                sSystemTrustAnchorCache = new HashSet();
            }
            if (sTestKeyStore == null) {
                sTestKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                try {
                    sTestKeyStore.load(null);
                } catch (IOException e4) {
                }
            }
            if (sTestTrustManager == null) {
                sTestTrustManager = createTrustManager(sTestKeyStore);
            }
            if (sTrustStorageListener == null) {
                sTrustStorageListener = new TrustStorageListener();
                IntentFilter intentFilter = new IntentFilter();
                if (Build.VERSION.SDK_INT >= 26) {
                    intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                    intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                    intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
                } else {
                    intentFilter.addAction("android.security.STORAGE_CHANGED");
                }
                MMApplicationContext.getContext().registerReceiver(sTrustStorageListener, intentFilter);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        return new X509TrustManagerJellyBean((X509TrustManager) trustManager);
                    }
                    return new X509TrustManagerIceCreamSandwich((X509TrustManager) trustManager);
                } catch (IllegalArgumentException e2) {
                    Log.e(TAG, "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e2);
                }
            }
        }
        Log.e(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void reloadTestTrustManager() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static void reloadDefaultTrustManager() {
        synchronized (sLock) {
            sDefaultTrustManager = null;
            sSystemTrustAnchorCache = null;
            ensureInitializedLocked();
        }
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void addTestRootCertificate(byte[] bArr) {
        ensureInitialized();
        X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
        synchronized (sLock) {
            sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), createCertificateFromBytes);
            reloadTestTrustManager();
        }
    }

    public static void clearTestRootCertificates() {
        ensureInitialized();
        synchronized (sLock) {
            try {
                sTestKeyStore.load(null);
                reloadTestTrustManager();
            } catch (IOException e2) {
            }
        }
    }

    private static String hashPrincipal(X500Principal x500Principal) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[i2 * 2] = HEX_DIGITS[(digest[3 - i2] >> 4) & 15];
            cArr[(i2 * 2) + 1] = HEX_DIGITS[digest[3 - i2] & 15];
        }
        return new String(cArr);
    }

    private static boolean isKnownRoot(X509Certificate x509Certificate) {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        } else if (sSystemKeyStore == null) {
            return false;
        } else {
            Pair<X500Principal, PublicKey> pair = new Pair<>(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
            if (sSystemTrustAnchorCache.contains(pair)) {
                return true;
            }
            String hashPrincipal = hashPrincipal(x509Certificate.getSubjectX500Principal());
            int i2 = 0;
            while (true) {
                String str = hashPrincipal + '.' + i2;
                if (!new o(sSystemCertificateDirectory, str).exists()) {
                    return false;
                }
                Certificate certificate = sSystemKeyStore.getCertificate("system:".concat(String.valueOf(str)));
                if (certificate != null) {
                    if (!(certificate instanceof X509Certificate)) {
                        Log.e(TAG, "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                    } else {
                        X509Certificate x509Certificate2 = (X509Certificate) certificate;
                        if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                            sSystemTrustAnchorCache.add(pair);
                            return true;
                        }
                    }
                }
                i2++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean verifyKeyUsage(java.security.cert.X509Certificate r5) {
        /*
            r1 = 1
            r2 = 0
            java.util.List r0 = r5.getExtendedKeyUsage()     // Catch:{ NullPointerException -> 0x000a }
            if (r0 != 0) goto L_0x000d
            r0 = r1
        L_0x0009:
            return r0
        L_0x000a:
            r0 = move-exception
            r0 = r2
            goto L_0x0009
        L_0x000d:
            java.util.Iterator r3 = r0.iterator()
        L_0x0011:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r4 = "1.3.6.1.5.5.7.3.1"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = "2.5.29.37.0"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = "2.16.840.1.113730.4.1"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0041
            java.lang.String r4 = "1.3.6.1.4.1.311.10.3.3"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0011
        L_0x0041:
            r0 = r1
            goto L_0x0009
        L_0x0043:
            r0 = r2
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mars.cdn.X509Util.verifyKeyUsage(java.security.cert.X509Certificate):boolean");
    }

    private static List<String> getSubjectAlternativeNames(X509Certificate x509Certificate) {
        int indexOf;
        Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (List<?> list : subjectAlternativeNames) {
            Object obj = list.get(1);
            if (obj instanceof String) {
                arrayList.add(((String) obj).toLowerCase());
            }
        }
        String trim = x509Certificate.getSubjectDN().getName().trim();
        int indexOf2 = trim.indexOf("CN=");
        String str = "";
        if (indexOf2 >= 0 && (indexOf = (str = trim.substring(indexOf2 + 3)).indexOf(",")) > 0) {
            str = str.substring(0, indexOf);
        }
        Log.i(TAG, "certificate dn %s cn %s", trim, str);
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean isHostMatched(List<String> list, String str) {
        if (list.contains(str)) {
            return true;
        }
        int indexOf = str.indexOf(".");
        int lastIndexOf = str.lastIndexOf(".");
        while (indexOf > 0 && indexOf < lastIndexOf) {
            String str2 = "*" + str.substring(indexOf);
            Log.i(TAG, "try match nhost ".concat(String.valueOf(str2)));
            if (list.contains(str2)) {
                return true;
            }
            indexOf = str.indexOf(".", indexOf + 1);
        }
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        return verifyServerCertificates(bArr, str, str2, 0, null);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, X509TrustManager x509TrustManager) {
        return verifyServerCertificates(bArr, str, str2, 0, x509TrustManager);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i2, X509TrustManager x509TrustManager) {
        boolean z;
        List<X509Certificate> checkServerTrusted;
        boolean z2;
        boolean z3 = false;
        Log.i(TAG, "verifyServerCertificates %s type %s", str2, str);
        if (bArr == null || bArr.length == 0 || bArr[0] == null) {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
        try {
            ensureInitialized();
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(createCertificateFromBytes(bArr[0]));
                try {
                    List<String> subjectAlternativeNames = getSubjectAlternativeNames((X509Certificate) arrayList.get(0));
                    Log.i(TAG, "check host %s in altnames %s", str2, subjectAlternativeNames.toString());
                    if (!isHostMatched(subjectAlternativeNames, str2)) {
                        Log.e(TAG, "hostname mismatch");
                        if (i2 != 1) {
                            return new AndroidCertVerifyResult(-1);
                        }
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                } catch (Exception e2) {
                    Log.e(TAG, "hostname verify failed " + e2.getLocalizedMessage());
                    if (i2 != 1) {
                        return new AndroidCertVerifyResult(-1);
                    }
                    z = false;
                }
                for (int i3 = 1; i3 < bArr.length; i3++) {
                    try {
                        arrayList.add(createCertificateFromBytes(bArr[i3]));
                    } catch (CertificateException e3) {
                        Log.w(TAG, "intermediate " + i3 + " failed parsing");
                    }
                }
                X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                try {
                    x509CertificateArr[0].checkValidity();
                    if (!verifyKeyUsage(x509CertificateArr[0])) {
                        return new AndroidCertVerifyResult(-6);
                    }
                    synchronized (sLock) {
                        if (sDefaultTrustManager == null && x509TrustManager == null) {
                            return new AndroidCertVerifyResult(-1);
                        } else if (x509TrustManager != null) {
                            try {
                                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                                return new AndroidCertVerifyResult(0, true, new ArrayList(), z);
                            } catch (CertificateException e4) {
                                Log.i(TAG, "Failed to validate the certificate chain use self trustmanager, error: " + e4.getMessage());
                                return new AndroidCertVerifyResult(-2);
                            }
                        } else {
                            try {
                                checkServerTrusted = sDefaultTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                            } catch (CertificateException e5) {
                                try {
                                    checkServerTrusted = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                } catch (CertificateException e6) {
                                    Log.i(TAG, "Failed to validate the certificate chain, error: " + e5.getMessage());
                                    return new AndroidCertVerifyResult(-2);
                                }
                            }
                            if (checkServerTrusted.size() > 0) {
                                z3 = isKnownRoot(checkServerTrusted.get(checkServerTrusted.size() - 1));
                            }
                            return new AndroidCertVerifyResult(0, z3, checkServerTrusted, z);
                        }
                    }
                } catch (CertificateExpiredException e7) {
                    return new AndroidCertVerifyResult(-3);
                } catch (CertificateNotYetValidException e8) {
                    return new AndroidCertVerifyResult(-4);
                } catch (CertificateException e9) {
                    return new AndroidCertVerifyResult(-1);
                }
            } catch (CertificateException e10) {
                return new AndroidCertVerifyResult(-5);
            }
        } catch (CertificateException e11) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
