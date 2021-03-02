package com.tencent.tinker.c.b;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;

public final class a {
    public static long ac(File file) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                long S = S(bufferedInputStream);
                b.closeQuietly(bufferedInputStream);
                return S;
            } catch (Throwable th2) {
                th = th2;
                b.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            b.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    private static long S(InputStream inputStream) {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return crc32.getValue();
            }
            crc32.update(bArr, 0, read);
        }
    }
}
