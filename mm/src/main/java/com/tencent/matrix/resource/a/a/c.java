package com.tencent.matrix.resource.a.a;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class c {
    public static void closeQuietly(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof ZipFile) {
                    ((ZipFile) obj).close();
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(File file, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        byte[] bArr = new byte[4096];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        closeQuietly(bufferedInputStream);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }
}
