package com.tencent.mm.b;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.Log;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    private Cipher dgJ;
    private Cipher encryptCipher;

    public d(String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            IvParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.encryptCipher.init(1, generateSecret, ivParameterSpec);
            this.dgJ = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.dgJ.init(2, generateSecret, ivParameterSpec);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.DESUtil", e2, "", new Object[0]);
        }
    }

    public final String fa(String str) {
        try {
            return new String(this.dgJ.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e2) {
            return "[des]" + str + "|" + e2.toString();
        }
    }
}
