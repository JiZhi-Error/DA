package com.tencent.soter.core.d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.soter.core.b.a;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import org.xwalk.core.XWalkAppVersion;

public class c extends b implements b {
    private static boolean RQa = false;
    protected String RQb = "SoterKeyStore";

    @SuppressLint({"PrivateApi"})
    public static void efp() {
        AppMethodBeat.i(88681);
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e2) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e3) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e4) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e5) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: InvocationTargetException", new Object[0]);
        } finally {
            RQa = true;
            AppMethodBeat.o(88681);
        }
    }

    public c(String str) {
        this.RQb = str;
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean lg(Context context) {
        AppMethodBeat.i(88682);
        efp();
        AppMethodBeat.o(88682);
        return true;
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hlj() {
        AppMethodBeat.i(88683);
        if (!RQa) {
            efp();
        }
        if (h.hlu()) {
            d.w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.o(88683);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
            AppMethodBeat.o(88683);
            return false;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith("SoterKeyStore")) {
                d.i("Soter.SoterCoreBeforeTreble", "soter: found soter provider", new Object[0]);
                AppMethodBeat.o(88683);
                return true;
            }
        }
        d.i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
        AppMethodBeat.o(88683);
        return false;
    }

    @Override // com.tencent.soter.core.d.b
    public f hlk() {
        AppMethodBeat.i(88684);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
        if (hlj()) {
            try {
                KeyStore.getInstance(this.RQb).load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance(EncryptUtil.KEY_ALGORITHM, "SoterKeyStore");
                instance.initialize(a.hw(e.hls().RPL + ".addcounter.auto_signed_when_get_pubkey_attk", 4).ac(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).ad("PSS").hlq());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", Long.valueOf(g.OA(nanoTime)));
                h.reset();
                f fVar = new f(0);
                AppMethodBeat.o(88684);
                return fVar;
            } catch (Exception e2) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + e2.toString(), new Object[0]);
                d.a("Soter.SoterCoreBeforeTreble", e2, "soter: generateAppGlobalSecureKey error");
                f fVar2 = new f(4, e2.toString());
                AppMethodBeat.o(88684);
                return fVar2;
            } catch (OutOfMemoryError e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when generate ASK!! maybe no attk inside");
                h.hlt();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            f fVar3 = new f(2);
            AppMethodBeat.o(88684);
            return fVar3;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final f hll() {
        AppMethodBeat.i(88685);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
        if (hlj()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.RQb);
                instance.load(null);
                instance.deleteEntry(e.hls().RPL);
                f fVar = new f(0);
                AppMethodBeat.o(88685);
                return fVar;
            } catch (Exception e2) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + e2.toString(), new Object[0]);
                f fVar2 = new f(5, e2.toString());
                AppMethodBeat.o(88685);
                return fVar2;
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            f fVar3 = new f(2);
            AppMethodBeat.o(88685);
            return fVar3;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hlm() {
        AppMethodBeat.i(88686);
        try {
            KeyStore instance = KeyStore.getInstance(this.RQb);
            instance.load(null);
            if (instance.getCertificate(e.hls().RPL) != null) {
                AppMethodBeat.o(88686);
                return true;
            }
            AppMethodBeat.o(88686);
            return false;
        } catch (Exception e2) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e2.toString(), new Object[0]);
            AppMethodBeat.o(88686);
            return false;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hln() {
        AppMethodBeat.i(88687);
        if (!hlm() || hlo() == null) {
            AppMethodBeat.o(88687);
            return false;
        }
        AppMethodBeat.o(88687);
        return true;
    }

    @Override // com.tencent.soter.core.d.b
    public i hlo() {
        i iVar = null;
        AppMethodBeat.i(88688);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
        if (hlj()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.RQb);
                instance.load(null);
                try {
                    Key key = instance.getKey(e.hls().RPL, "from_soter_ui".toCharArray());
                    if (key != null) {
                        h.reset();
                        iVar = cZ(key.getEncoded());
                        AppMethodBeat.o(88688);
                    } else {
                        d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(88688);
                    }
                } catch (ClassCastException e2) {
                    d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e2.toString(), new Object[0]);
                    AppMethodBeat.o(88688);
                }
            } catch (Exception e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: error when get ask");
            } catch (OutOfMemoryError e4) {
                d.a("Soter.SoterCoreBeforeTreble", e4, "soter: out of memory when getting ask!! maybe no attk inside");
                h.hlt();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            AppMethodBeat.o(88688);
        }
        return iVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00cd, code lost:
        com.tencent.soter.core.c.d.e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + r0.toString(), new java.lang.Object[0]);
        r0 = new com.tencent.soter.core.c.f(6, r0.toString());
        com.tencent.matrix.trace.core.AppMethodBeat.o(88689);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0126, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0127, code lost:
        com.tencent.soter.core.c.d.a("Soter.SoterCoreBeforeTreble", r0, "soter: out of memory when generate AuthKey!! maybe no attk inside");
        com.tencent.soter.core.c.h.hlt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0126 A[ExcHandler: OutOfMemoryError (r0v4 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:5:0x002c] */
    @Override // com.tencent.soter.core.d.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.soter.core.c.f bqg(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.soter.core.d.c.bqg(java.lang.String):com.tencent.soter.core.c.f");
    }

    @Override // com.tencent.soter.core.d.b
    public final f dE(String str, boolean z) {
        AppMethodBeat.i(88690);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            f fVar = new f(1, "no authKeyName");
            AppMethodBeat.o(88690);
            return fVar;
        }
        d.i("Soter.SoterCoreBeforeTreble", "soter: start remove key: ".concat(String.valueOf(str)), new Object[0]);
        if (hlj()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.RQb);
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    d.i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
                    if (hlm()) {
                        hll();
                    }
                }
                f fVar2 = new f(0);
                AppMethodBeat.o(88690);
                return fVar2;
            } catch (Exception e2) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + e2.toString(), new Object[0]);
                f fVar3 = new f(7, e2.toString());
                AppMethodBeat.o(88690);
                return fVar3;
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            f fVar4 = new f(2);
            AppMethodBeat.o(88690);
            return fVar4;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean bqh(String str) {
        AppMethodBeat.i(88691);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
            AppMethodBeat.o(88691);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance(this.RQb);
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                AppMethodBeat.o(88691);
                return true;
            }
            AppMethodBeat.o(88691);
            return false;
        } catch (Exception e2) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e2.toString(), new Object[0]);
            AppMethodBeat.o(88691);
            return false;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final SoterSessionResult nI(String str, String str2) {
        return null;
    }

    @Override // com.tencent.soter.core.d.b
    public final byte[] Oz(long j2) {
        return new byte[0];
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean bqi(String str) {
        AppMethodBeat.i(88692);
        d.i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", str, Boolean.TRUE), new Object[0]);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
            AppMethodBeat.o(88692);
            return false;
        }
        try {
            bqm(str);
            d.i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
            h.reset();
            AppMethodBeat.o(88692);
            return true;
        } catch (InvalidKeyException | UnrecoverableEntryException e2) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
            dE(str, false);
            AppMethodBeat.o(88692);
            return false;
        } catch (Exception e3) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", e3.toString());
            d.a("Soter.SoterCoreBeforeTreble", e3, "soter: occurs other exceptions");
            AppMethodBeat.o(88692);
            return false;
        } catch (OutOfMemoryError e4) {
            d.a("Soter.SoterCoreBeforeTreble", e4, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            h.hlt();
            AppMethodBeat.o(88692);
            return false;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final i bqj(String str) {
        i iVar = null;
        AppMethodBeat.i(88693);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(88693);
        } else if (hlj()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.RQb);
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    h.reset();
                    if (key != null) {
                        iVar = cZ(key.getEncoded());
                        AppMethodBeat.o(88693);
                    } else {
                        d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(88693);
                    }
                } catch (ClassCastException e2) {
                    d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e2.toString(), new Object[0]);
                    AppMethodBeat.o(88693);
                }
            } catch (Exception e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: error in get auth key model");
            } catch (OutOfMemoryError e4) {
                d.a("Soter.SoterCoreBeforeTreble", e4, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                h.hlt();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.RQb, new Object[0]);
            AppMethodBeat.o(88693);
        }
        return iVar;
    }

    @Override // com.tencent.soter.core.d.b
    public final Signature bqk(String str) {
        Signature signature = null;
        AppMethodBeat.i(88694);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(88694);
        } else if (hlj()) {
            try {
                h.reset();
                signature = bqm(str);
                AppMethodBeat.o(88694);
            } catch (InvalidKeyException | UnrecoverableEntryException e2) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
                AppMethodBeat.o(88694);
            } catch (Exception e3) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + e3.toString(), new Object[0]);
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: exception when getSignatureResult");
                AppMethodBeat.o(88694);
            } catch (OutOfMemoryError e4) {
                d.a("Soter.SoterCoreBeforeTreble", e4, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                h.hlt();
                AppMethodBeat.o(88694);
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.RQb, new Object[0]);
            AppMethodBeat.o(88694);
        }
        return signature;
    }

    public Signature bqm(String str) {
        AppMethodBeat.i(88695);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(88695);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance(this.RQb);
        instance2.load(null);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            AppMethodBeat.o(88695);
            return instance;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
        AppMethodBeat.o(88695);
        return null;
    }
}
