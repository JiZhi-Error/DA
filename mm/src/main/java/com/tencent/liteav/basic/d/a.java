package com.tencent.liteav.basic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f346a = EncryptUtil.KEY_ALGORITHM;

    public static byte[] a(byte[] bArr, PrivateKey privateKey) {
        byte[] doFinal;
        AppMethodBeat.i(222044);
        Cipher instance = Cipher.getInstance(EncryptUtil.CIPHER_ALGORITHM);
        instance.init(2, privateKey);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; length - i2 > 0; i2 = instance.getBlockSize() + i2) {
            if (length - i2 >= instance.getBlockSize()) {
                doFinal = instance.doFinal(bArr, i2, instance.getBlockSize());
            } else {
                doFinal = instance.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        AppMethodBeat.o(222044);
        return byteArray;
    }

    public static PrivateKey a(byte[] bArr) {
        AppMethodBeat.i(222045);
        PrivateKey generatePrivate = KeyFactory.getInstance(f346a).generatePrivate(new PKCS8EncodedKeySpec(bArr));
        AppMethodBeat.o(222045);
        return generatePrivate;
    }
}
