package com.tencent.soter.core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import org.xwalk.core.XWalkAppVersion;

public final class a extends c {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.soter.core.d.c, com.tencent.soter.core.d.b
    public final f hlk() {
        AppMethodBeat.i(88678);
        d.i("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
        if (hlj()) {
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance(EncryptUtil.KEY_ALGORITHM, this.RQb);
                instance.initialize(com.tencent.soter.core.b.a.hw(e.hls().RPL + ".addcounter.auto_signed_when_get_pubkey_attk", 16).ac(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).ad("PSS").hlq());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                d.i("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", Long.valueOf(g.OA(nanoTime)));
                h.reset();
                f fVar = new f(0);
                AppMethodBeat.o(88678);
                return fVar;
            } catch (Exception e2) {
                d.e("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + e2.toString(), new Object[0]);
                d.a("Soter.CertSoterCore", e2, "soter: generateAppGlobalSecureKey error");
                f fVar2 = new f(4, e2.toString());
                AppMethodBeat.o(88678);
                return fVar2;
            } catch (OutOfMemoryError e3) {
                d.a("Soter.CertSoterCore", e3, "soter: out of memory when generate ASK!! maybe no attk inside");
                h.hlt();
            }
        } else {
            d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            f fVar3 = new f(2);
            AppMethodBeat.o(88678);
            return fVar3;
        }
    }

    @Override // com.tencent.soter.core.d.c, com.tencent.soter.core.d.b
    public final i hlo() {
        AppMethodBeat.i(88679);
        d.i("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (hlj()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.RQb);
                instance.load(null);
                try {
                    Certificate[] certificateChain = instance.getCertificateChain(e.hls().RPL);
                    if (certificateChain != null) {
                        h.reset();
                        i iVar = new i(certificateChain);
                        AppMethodBeat.o(88679);
                        return iVar;
                    }
                    d.e("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
                    AppMethodBeat.o(88679);
                    return null;
                } catch (ClassCastException e2) {
                    d.e("Soter.CertSoterCore", "soter: cast error: " + e2.toString(), new Object[0]);
                    AppMethodBeat.o(88679);
                    return null;
                }
            } catch (Exception e3) {
                d.a("Soter.CertSoterCore", e3, "soter: error when get ask");
            } catch (OutOfMemoryError e4) {
                d.a("Soter.CertSoterCore", e4, "soter: out of memory when getting ask!! maybe no attk inside");
                h.hlt();
            }
        } else {
            d.e("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
            AppMethodBeat.o(88679);
            return null;
        }
    }

    @Override // com.tencent.soter.core.d.c
    public final Signature bqm(String str) {
        AppMethodBeat.i(88680);
        d.d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
        if (g.isNullOrNil(str)) {
            d.e("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(88680);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS");
        KeyStore instance2 = KeyStore.getInstance(this.RQb);
        instance2.load(null);
        Key key = instance2.getKey(str, null);
        if (key != null) {
            instance.initSign((PrivateKey) key);
            AppMethodBeat.o(88680);
            return instance;
        }
        d.e("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
        AppMethodBeat.o(88680);
        return null;
    }
}
