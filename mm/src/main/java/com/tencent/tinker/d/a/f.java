package com.tencent.tinker.d.a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public final class f {
    private static AtomicReference<byte[]> SkI = new AtomicReference<>();

    public static int T(InputStream inputStream) {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) != -1) {
            return bArr[0] & 255;
        }
        return -1;
    }

    public static void b(InputStream inputStream, byte[] bArr, int i2, int i3) {
        if (i3 != 0) {
            if (inputStream == null) {
                throw new NullPointerException("in == null");
            } else if (bArr == null) {
                throw new NullPointerException("dst == null");
            } else {
                b.checkOffsetAndCount(bArr.length, 0, i3);
                while (i3 > 0) {
                    int read = inputStream.read(bArr, i2, i3);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i2 += read;
                    i3 -= read;
                }
            }
        }
    }
}
