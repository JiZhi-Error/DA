package com.tencent.recovery.wx.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class EncryptUtil {
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    public static final int DECRYPTION = 1;
    public static final int ENCRYPTION = 0;
    public static final String KEY_ALGORITHM = "RSA";
    public static final String KEY_E = "010001";
    public static final String KEY_N = "DFE56EEE6506E5F9796B4F12C3A48121B84E548E9999D834E2C037E3CD276E9C4A2B1758C582A67F6D12895CE5525DDE51D0B92D32B8BE7B2C85827729C3571DCC14B581877BC634BCC7F9DA3825C97A25B341A64295098303C4B584EC579ECCA7C8B96782F65D650039EE7A0772C195DBEFC4488BDFB0B9A58C5C058E3AB04D";
    public static final int LATEST_RBCRYPT_PACK_VERSION = 1001;
    private static final int MAX_DECRYPT_BLOCK = 128;
    public static final int RBCPR_ERR_DECRYPT_WITH_DES_KEY = 12;
    public static final int RBCPR_ERR_DECRYPT_WITH_RSA_PRIVKEY = 10;
    public static final int RBCPR_ERR_ENCRYPT_WITH_DES_KEY = 11;
    public static final int RBCPR_ERR_ENCRYPT_WITH_RSA_PUBKEY = 8;
    public static final int RBCPR_ERR_GENERAL = 1;
    public static final int RBCPR_ERR_INVALID_ARG = 2;
    public static final int RBCPR_ERR_INVALID_RSA_KEY_E = 7;
    public static final int RBCPR_ERR_INVALID_RSA_KEY_N = 6;
    public static final int RBCPR_ERR_LOAD_RSA_PRIVATE_KEY = 9;
    public static final int RBCPR_ERR_NO_MEMORY = 14;
    public static final int RBCPR_ERR_NO_REFERENCE_INFO = 13;
    public static final int RBCPR_ERR_NO_SEQ = 15;
    public static final int RBCPR_ERR_PACK_CORRUPTED = 3;
    public static final int RBCPR_ERR_UNSUPPORTED_ALGORITHM = 5;
    public static final int RBCPR_ERR_UNSUPPORTED_VERSION = 4;
    public static final int RBCPR_OK = 0;
    public static final int RBCPTS_CryptedBuf = 302;
    public static final int RBCPTS_ReferenceInfo = 303;
    public static final int RBCPTS_Seq = 304;
    public static final int RBCPTS_Version = 301;
    public static final int RBCRYPT_PACK_VERSION_1 = 1001;
    public static final int RSA_PKCS_V15 = 0;
    public static final int RSA_PKCS_V21 = 1;
    public static final int RSA_PRIVATE = 1;
    public static final int RSA_PUBLIC = 0;
    private static final String TAG = "Recovery.EncryptUtil";

    public static byte[] decryptByPublicKey(byte[] bArr, String str) {
        byte[] doFinal;
        PublicKey generatePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance(CIPHER_ALGORITHM);
        instance.init(2, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        int i3 = 0;
        while (length - i3 > 0) {
            if (length - i3 > 128) {
                doFinal = instance.doFinal(bArr, i3, 128);
            } else {
                doFinal = instance.doFinal(bArr, i3, length - i3);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            int i4 = i2 + 1;
            i3 = i4 * 128;
            i2 = i4;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static final String getMessageDigest(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            return new String(cArr2);
        } catch (Exception e2) {
            return null;
        }
    }

    public static int DESEncrypt(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (pByteArray == null || bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int length = 8 - (bArr.length % 8);
        byte[] bArr3 = new byte[(bArr.length + length)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2] = bArr[i2];
        }
        for (int i3 = 0; i3 < length; i3++) {
            bArr3[bArr.length + i3] = (byte) length;
        }
        pByteArray.value = new byte[(bArr.length + length + 32)];
        if (MyDES.Using_DES(pByteArray.value, bArr3, (long) bArr3.length, bArr2.length, bArr2, 0) == 0) {
            return 11;
        }
        byte[] bArr4 = new byte[(bArr.length + length + 8)];
        for (int i4 = 0; i4 < bArr4.length; i4++) {
            bArr4[i4] = pByteArray.value[i4];
        }
        pByteArray.value = bArr4;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[SYNTHETIC, Splitter:B:14:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[SYNTHETIC, Splitter:B:31:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.util.EncryptUtil.compress(byte[]):byte[]");
    }
}
