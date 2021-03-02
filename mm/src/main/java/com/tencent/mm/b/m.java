package com.tencent.mm.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class m {
    public static PublicKey o(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(str);
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            inputStream.close();
            return KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(new String(bArr).replace("\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0)));
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey, String str) {
        Cipher instance = Cipher.getInstance(str);
        instance.init(1, publicKey);
        return instance.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        Cipher instance = Cipher.getInstance(EncryptUtil.CIPHER_ALGORITHM);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }
}
