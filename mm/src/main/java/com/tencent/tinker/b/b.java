package com.tencent.tinker.b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class b {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int read = inputStream.read(bArr, i2 + i4, i3 - i4);
            if (read < 0) {
                return false;
            }
            i4 += read;
        }
        return true;
    }

    public static byte[] R(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
