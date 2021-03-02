package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APBytesUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class APLogEncryptor {
    private static String ENCRYPT_KEY = "}VjZtoJF;dE+7iJs";
    private static final byte MAGIC_END = 0;
    private static final byte MAGIC_START = 2;
    private static byte PROTOCOL_VERSION = 1;
    private static byte[] header = new byte[7];
    private Cipher encryptCipher = null;

    public static APLogEncryptor create() {
        AppMethodBeat.i(193431);
        APLogEncryptor aPLogEncryptor = new APLogEncryptor();
        aPLogEncryptor.init();
        AppMethodBeat.o(193431);
        return aPLogEncryptor;
    }

    private void init() {
        AppMethodBeat.i(193432);
        try {
            header[0] = 2;
            header[1] = PROTOCOL_VERSION;
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
            this.encryptCipher = Cipher.getInstance("AES/ECB/NoPadding");
            this.encryptCipher.init(1, secretKeySpec);
            AppMethodBeat.o(193432);
        } catch (NoSuchPaddingException e2) {
            AppMethodBeat.o(193432);
        } catch (NoSuchAlgorithmException e3) {
            AppMethodBeat.o(193432);
        } catch (InvalidKeyException e4) {
            AppMethodBeat.o(193432);
        }
    }

    public byte[] encrypt(byte[] bArr) {
        byte[] bArr2;
        AppMethodBeat.i(193433);
        int length = bArr.length;
        int i2 = length % 16;
        if (i2 != 0) {
            try {
                byte[] bArr3 = new byte[((16 - i2) + length)];
                System.arraycopy(bArr, 0, bArr3, 0, length);
                bArr = bArr3;
            } catch (IllegalBlockSizeException e2) {
                bArr2 = bArr;
            } catch (BadPaddingException e3) {
                bArr2 = bArr;
            }
        }
        bArr2 = this.encryptCipher.doFinal(bArr);
        byte[] assembleHeader = assembleHeader(length);
        byte[] bArr4 = new byte[(assembleHeader.length + bArr2.length + 1)];
        System.arraycopy(assembleHeader, 0, bArr4, 0, assembleHeader.length);
        System.arraycopy(bArr2, 0, bArr4, assembleHeader.length, bArr2.length);
        bArr4[bArr4.length - 1] = 0;
        AppMethodBeat.o(193433);
        return bArr4;
    }

    public void close() {
        this.encryptCipher = null;
    }

    public static void setEncryptKey(String str) {
        ENCRYPT_KEY = str;
    }

    public static void setProtocolVersion(byte b2) {
        PROTOCOL_VERSION = b2;
    }

    private static byte[] assembleHeader(int i2) {
        AppMethodBeat.i(193434);
        System.arraycopy(APBytesUtil.int2bytes(i2), 0, header, 3, 4);
        byte[] bArr = header;
        AppMethodBeat.o(193434);
        return bArr;
    }
}
