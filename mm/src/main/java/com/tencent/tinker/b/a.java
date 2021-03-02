package com.tencent.tinker.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public final class a {
    /* JADX INFO: finally extract failed */
    public static int a(InputStream inputStream, InputStream inputStream2, File file) {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] R = b.R(inputStream);
        byte[] R2 = b.R(inputStream2);
        int length = R.length;
        int length2 = R2.length;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(R2, 0, length2));
        dataInputStream.skip(8);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(R2, 0, length2);
        byteArrayInputStream.skip(32);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(R2, 0, length2);
        byteArrayInputStream2.skip(32 + readLong);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(R2, 0, length2);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr = new byte[readLong3];
        int i2 = 0;
        int[] iArr = new int[3];
        int i3 = 0;
        while (i3 < readLong3) {
            for (int i4 = 0; i4 <= 2; i4++) {
                iArr[i4] = dataInputStream2.readInt();
            }
            if (iArr[0] + i3 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            } else if (!b.a(gZIPInputStream, bArr, i3, iArr[0])) {
                throw new IOException("Corrupt by wrong patch file.");
            } else {
                for (int i5 = 0; i5 < iArr[0]; i5++) {
                    if (i2 + i5 >= 0 && i2 + i5 < length) {
                        int i6 = i3 + i5;
                        bArr[i6] = (byte) (bArr[i6] + R[i2 + i5]);
                    }
                }
                int i7 = iArr[0] + i3;
                int i8 = iArr[0] + i2;
                if (iArr[1] + i7 > readLong3) {
                    throw new IOException("Corrupt by wrong patch file.");
                } else if (!b.a(gZIPInputStream2, bArr, i7, iArr[1])) {
                    throw new IOException("Corrupt by wrong patch file.");
                } else {
                    int i9 = i7 + iArr[1];
                    i2 = iArr[2] + i8;
                    i3 = i9;
                }
            }
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return 1;
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }
}
