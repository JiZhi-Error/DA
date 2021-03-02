package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.io.File;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b extends a {
    private byte[] Iys;
    private byte[] Iyt;
    private byte[] sessionKey;

    public final byte[] getSessionKey() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(30067);
        if (this.Iyt == null || this.Iys == null || this.sessionKey == null) {
            Log.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                fWg();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "loadAllKey", new Object[0]);
            }
            Object[] objArr = new Object[3];
            if (this.Iyt != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(this.Iys != null);
            if (this.sessionKey == null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", objArr);
        }
        byte[] bArr = this.sessionKey;
        AppMethodBeat.o(30067);
        return bArr;
    }

    private void fWg() {
        AppMethodBeat.i(30068);
        File file = new File(com.tencent.mm.loader.j.b.aKC(), "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (!file2.exists() || !file3.exists() || !file4.exists()) {
            Log.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            HashMap<String, Object> fWi = a.fWi();
            this.Iyt = ((RSAPublicKey) fWi.get("RSAPublicKey")).getEncoded();
            this.Iys = ((RSAPrivateKey) fWi.get("RSAPrivateKey")).getEncoded();
            this.sessionKey = a.fWj();
            s.f(file2.getAbsolutePath(), this.Iys, this.Iys.length);
            s.f(file3.getAbsolutePath(), this.Iyt, this.Iyt.length);
            s.f(file4.getAbsolutePath(), this.sessionKey, this.sessionKey.length);
        } else {
            Log.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.Iyt = s.aW(file3.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.Iys = s.aW(file2.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.sessionKey = s.aW(file4.getAbsolutePath(), 0, Integer.MAX_VALUE);
        }
        Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", MD5Util.getMD5String(this.Iyt), MD5Util.getMD5String(this.Iys), MD5Util.getMD5String(this.sessionKey));
        AppMethodBeat.o(30068);
    }

    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30069);
        ArrayList arrayList = new ArrayList();
        arrayList.add(10001);
        arrayList.add(10002);
        AppMethodBeat.o(30069);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(30070);
        switch (i2) {
            case 10001:
                Log.i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.Iyt == null || this.Iys == null || this.sessionKey == null) {
                    Log.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        fWg();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e2, "loadAllKey", new Object[0]);
                    }
                }
                Object[] objArr = new Object[3];
                if (this.Iyt != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Boolean.valueOf(this.Iys != null);
                if (this.sessionKey == null) {
                    z2 = false;
                }
                objArr[2] = Boolean.valueOf(z2);
                Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", objArr);
                byte[] bArr2 = this.Iyt;
                AppMethodBeat.o(30070);
                return bArr2;
            case 10002:
                try {
                    PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.Iys);
                    KeyFactory instance = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM);
                    PrivateKey generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    byte[] doFinal = instance2.doFinal(bArr);
                    byte[] j2 = a.j(this.sessionKey, doFinal);
                    Log.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", Integer.valueOf(i2), MD5Util.getMD5String(doFinal));
                    AppMethodBeat.o(30070);
                    return j2;
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", e3, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        AppMethodBeat.o(30070);
        return null;
    }
}
