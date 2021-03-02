package com.tencent.mm.plugin.wear.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    public static final HashMap<String, Object> fWi() {
        AppMethodBeat.i(131327);
        KeyPairGenerator instance = KeyPairGenerator.getInstance(EncryptUtil.KEY_ALGORITHM);
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        HashMap<String, Object> hashMap = new HashMap<>(2);
        hashMap.put("RSAPublicKey", (RSAPublicKey) generateKeyPair.getPublic());
        hashMap.put("RSAPrivateKey", (RSAPrivateKey) generateKeyPair.getPrivate());
        AppMethodBeat.o(131327);
        return hashMap;
    }

    public static final byte[] j(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(131328);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.o(131328);
        return doFinal;
    }

    public static final byte[] fWj() {
        AppMethodBeat.i(131329);
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            byte[] encoded = instance.generateKey().getEncoded();
            AppMethodBeat.o(131329);
            return encoded;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(131329);
            return null;
        }
    }
}
