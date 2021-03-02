package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static OutputStream f2146a = null;

    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        synchronized (LogFileUtils.class) {
            AppMethodBeat.i(54037);
            byte[] encrypt = encrypt(str, str2);
            if (encrypt != null) {
                str2 = null;
            } else {
                encrypt = null;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (f2146a == null) {
                    f2146a = new BufferedOutputStream(new FileOutputStream(file, z));
                }
                if (str2 != null) {
                    f2146a.write(str2.getBytes());
                } else {
                    f2146a.write(bArr);
                    f2146a.write(encrypt);
                    f2146a.write(new byte[]{10, 10});
                }
                if (f2146a != null) {
                    try {
                        f2146a.flush();
                        AppMethodBeat.o(54037);
                    } catch (Throwable th) {
                        new StringBuilder("writeDataToStorage outputStream.flush() exception:").append(th);
                        AppMethodBeat.o(54037);
                    }
                }
            } catch (Throwable th2) {
                new StringBuilder("writeDataToStorage outputStream.flush() exception:").append(th2);
                AppMethodBeat.o(54037);
            }
            AppMethodBeat.o(54037);
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        AppMethodBeat.i(54038);
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                AppMethodBeat.o(54038);
                return;
            }
        }
        AppMethodBeat.o(54038);
    }

    public static byte[] encrypt(String str, String str2) {
        AppMethodBeat.i(54039);
        try {
            byte[] bytes = str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "RC4"));
            byte[] update = instance.update(bytes);
            AppMethodBeat.o(54039);
            return update;
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            AppMethodBeat.o(54039);
            return null;
        }
    }

    public static String createKey() {
        AppMethodBeat.i(54040);
        String valueOf = String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(54040);
        return valueOf;
    }

    public static byte[] encryptKey(String str, String str2) {
        AppMethodBeat.i(54041);
        try {
            byte[] bytes = str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "RC4"));
            byte[] update = instance.update(bytes);
            AppMethodBeat.o(54041);
            return update;
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            AppMethodBeat.o(54041);
            return null;
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        AppMethodBeat.i(54042);
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[(encryptKey.length + 3)];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            AppMethodBeat.o(54042);
            return bArr;
        } catch (Exception e2) {
            AppMethodBeat.o(54042);
            return null;
        }
    }
}
