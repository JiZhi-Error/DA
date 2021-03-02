package com.tencent.map.tools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAesUtils {
    private static final String CipherMode = "AES/CBC/PKCS5Padding";
    private static final String EMPTY_STRING = "";
    private static final byte[] EMPYT_BYTE_ARR = new byte[0];

    private static Cipher getCipher(String str, AlgorithmParameterSpec algorithmParameterSpec, int i2) {
        AppMethodBeat.i(193513);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "AES");
        Cipher instance = Cipher.getInstance(CipherMode);
        instance.init(i2, secretKeySpec, algorithmParameterSpec);
        AppMethodBeat.o(193513);
        return instance;
    }

    private static String EnDeCryptBase64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, int i2) {
        byte[] bArr;
        AppMethodBeat.i(193514);
        if (i2 != 1 && i2 != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(193514);
            throw illegalArgumentException;
        } else if (str == null || str.length() == 0) {
            AppMethodBeat.o(193514);
            return "";
        } else {
            if (i2 == 1) {
                try {
                    bArr = str.getBytes();
                } catch (Throwable th) {
                    AppMethodBeat.o(193514);
                    return "";
                }
            } else if (i2 == 2) {
                bArr = Base64.decode(str.getBytes(), 2);
            } else {
                bArr = null;
            }
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.o(193514);
                return "";
            }
            byte[] EnDeCrypt = EnDeCrypt(bArr, str2, algorithmParameterSpec, i2);
            if (i2 == 1) {
                String encodeToString = Base64.encodeToString(EnDeCrypt, 2);
                AppMethodBeat.o(193514);
                return encodeToString;
            } else if (i2 == 2) {
                String str3 = new String(EnDeCrypt);
                AppMethodBeat.o(193514);
                return str3;
            } else {
                AppMethodBeat.o(193514);
                return null;
            }
        }
    }

    private static byte[] EnDeCrypt(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec, int i2) {
        AppMethodBeat.i(193515);
        if (i2 != 1 && i2 != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(193515);
            throw illegalArgumentException;
        } else if (bArr == null || bArr.length == 0) {
            byte[] bArr2 = EMPYT_BYTE_ARR;
            AppMethodBeat.o(193515);
            return bArr2;
        } else {
            try {
                Cipher cipher = getCipher(str, algorithmParameterSpec, i2);
                if (cipher == null) {
                    byte[] bArr3 = EMPYT_BYTE_ARR;
                    AppMethodBeat.o(193515);
                    return bArr3;
                }
                byte[] doFinal = cipher.doFinal(bArr);
                AppMethodBeat.o(193515);
                return doFinal;
            } catch (Throwable th) {
                byte[] bArr4 = EMPYT_BYTE_ARR;
                AppMethodBeat.o(193515);
                return bArr4;
            }
        }
    }

    public static String encryptAes256Base64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec) {
        AppMethodBeat.i(193516);
        String EnDeCryptBase64 = EnDeCryptBase64(str, str2, algorithmParameterSpec, 1);
        AppMethodBeat.o(193516);
        return EnDeCryptBase64;
    }

    public static String decryptAes256Base64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec) {
        AppMethodBeat.i(193517);
        String EnDeCryptBase64 = EnDeCryptBase64(str, str2, algorithmParameterSpec, 2);
        AppMethodBeat.o(193517);
        return EnDeCryptBase64;
    }

    public static byte[] encryptAes256(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        AppMethodBeat.i(193518);
        byte[] EnDeCrypt = EnDeCrypt(bArr, str, algorithmParameterSpec, 1);
        AppMethodBeat.o(193518);
        return EnDeCrypt;
    }

    public static byte[] decryptAes256(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        AppMethodBeat.i(193519);
        byte[] EnDeCrypt = EnDeCrypt(bArr, str, algorithmParameterSpec, 2);
        AppMethodBeat.o(193519);
        return EnDeCrypt;
    }
}
