package com.tencent.tinker.c.b;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class b {
    public static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static void closeQuietly(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof AutoCloseable) {
                    ((AutoCloseable) obj).close();
                } else if (obj instanceof ZipFile) {
                    ((ZipFile) obj).close();
                }
            } catch (Throwable th) {
            }
        }
    }
}
