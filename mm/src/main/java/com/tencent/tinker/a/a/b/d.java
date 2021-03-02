package com.tencent.tinker.a.a.b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d {
    public static byte[] r(InputStream inputStream) {
        return c(inputStream, 32768);
    }

    public static byte[] c(InputStream inputStream, int i2) {
        if (i2 <= 0) {
            i2 = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
