package com.tencent.midas.comm;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class APMidasRSATools {
    private final String DEFAULT_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r";
    private RSAPublicKey publicKey;

    private byte[] hexStringToBytes(String str) {
        AppMethodBeat.i(193221);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(193221);
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (charToByte(charArray[i3 + 1]) | (charToByte(charArray[i3]) << 4));
        }
        AppMethodBeat.o(193221);
        return bArr;
    }

    private byte charToByte(char c2) {
        AppMethodBeat.i(193222);
        byte indexOf = (byte) "0123456789ABCDEF".indexOf(c2);
        AppMethodBeat.o(193222);
        return indexOf;
    }

    private byte[] getByte(String str) {
        AppMethodBeat.i(193223);
        byte[] hexStringToBytes = hexStringToBytes(str);
        AppMethodBeat.o(193223);
        return hexStringToBytes;
    }

    private void loadPublicKey(String str) {
        AppMethodBeat.i(193224);
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            AppMethodBeat.o(193224);
        } catch (Exception e2) {
            AppMethodBeat.o(193224);
        }
    }

    public String deCodeKey(String str) {
        AppMethodBeat.i(193225);
        try {
            getClass();
            loadPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r");
            String str2 = new String(decrypt(this.publicKey, getByte(str)));
            AppMethodBeat.o(193225);
            return str2;
        } catch (Exception e2) {
            AppMethodBeat.o(193225);
            return "";
        }
    }

    private byte[] decrypt(RSAPublicKey rSAPublicKey, byte[] bArr) {
        AppMethodBeat.i(193226);
        if (rSAPublicKey == null) {
            Exception exc = new Exception("解密私钥为空, 请设置");
            AppMethodBeat.o(193226);
            throw exc;
        }
        try {
            Cipher instance = Cipher.getInstance(EncryptUtil.KEY_ALGORITHM);
            instance.init(2, rSAPublicKey);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(193226);
            return doFinal;
        } catch (NoSuchAlgorithmException e2) {
            Exception exc2 = new Exception("没有这样的解密算法");
            AppMethodBeat.o(193226);
            throw exc2;
        } catch (InvalidKeyException e3) {
            Exception exc3 = new Exception("密钥无效，请检查确认");
            AppMethodBeat.o(193226);
            throw exc3;
        } catch (IllegalBlockSizeException e4) {
            Exception exc4 = new Exception("密文长度无效或者过长");
            AppMethodBeat.o(193226);
            throw exc4;
        } catch (BadPaddingException e5) {
            Exception exc5 = new Exception("密文数据已损坏");
            AppMethodBeat.o(193226);
            throw exc5;
        } catch (Exception e6) {
            APLog.i("APMidasRSATools exception", e6.toString());
            Exception exc6 = new Exception("其他错误");
            AppMethodBeat.o(193226);
            throw exc6;
        }
    }
}
