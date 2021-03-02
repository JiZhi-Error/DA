package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public final class d {
    public static int a(RandomAccessFile randomAccessFile, File file, File file2, int i2) {
        AppMethodBeat.i(946);
        if (randomAccessFile.length() <= 0) {
            AppMethodBeat.o(946);
            return 3;
        } else if (file2.length() <= 0) {
            AppMethodBeat.o(946);
            return 2;
        } else {
            byte[] bArr = new byte[((int) file2.length())];
            e.a(new FileInputStream(file2), bArr, bArr.length);
            int a2 = a(randomAccessFile, (int) randomAccessFile.length(), bArr, bArr.length, file, i2);
            AppMethodBeat.o(946);
            return a2;
        }
    }

    private static int a(RandomAccessFile randomAccessFile, int i2, byte[] bArr, int i3, File file, int i4) {
        AppMethodBeat.i(947);
        if (randomAccessFile == null || i2 <= 0) {
            AppMethodBeat.o(947);
            return 3;
        } else if (file == null) {
            AppMethodBeat.o(947);
            return 4;
        } else if (i3 <= 0) {
            AppMethodBeat.o(947);
            return 2;
        } else {
            int i5 = (i2 - i4) - 2;
            if (i5 <= 2) {
                AppMethodBeat.o(947);
                return 3;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, i3));
            dataInputStream.skip(8);
            long readLong = dataInputStream.readLong();
            long readLong2 = dataInputStream.readLong();
            int readLong3 = (int) dataInputStream.readLong();
            dataInputStream.close();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i3);
            byteArrayInputStream.skip(32);
            DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr, 0, i3);
            byteArrayInputStream2.skip(32 + readLong);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr, 0, i3);
            byteArrayInputStream3.skip(readLong + readLong2 + 32);
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int i6 = 0;
            int[] iArr = new int[3];
            int i7 = 0;
            while (i7 < readLong3) {
                for (int i8 = 0; i8 <= 2; i8++) {
                    iArr[i8] = dataInputStream2.readInt();
                }
                if (iArr[0] + i7 > readLong3) {
                    fileOutputStream.close();
                    AppMethodBeat.o(947);
                    return 2;
                }
                byte[] bArr2 = new byte[iArr[0]];
                if (!e.a(gZIPInputStream, bArr2, iArr[0])) {
                    fileOutputStream.close();
                    AppMethodBeat.o(947);
                    return 2;
                }
                byte[] bArr3 = new byte[iArr[0]];
                if (randomAccessFile.read(bArr3, 0, iArr[0]) < iArr[0]) {
                    fileOutputStream.close();
                    AppMethodBeat.o(947);
                    return 2;
                }
                for (int i9 = 0; i9 < iArr[0]; i9++) {
                    if (i6 + i9 == i5) {
                        bArr3[i9] = 0;
                        bArr3[i9 + 1] = 0;
                    }
                    if (i6 + i9 >= 0 && i6 + i9 < i2) {
                        bArr2[i9] = (byte) (bArr2[i9] + bArr3[i9]);
                    }
                }
                fileOutputStream.write(bArr2);
                int i10 = iArr[0] + i7;
                int i11 = iArr[0] + i6;
                if (iArr[1] + i10 > readLong3) {
                    fileOutputStream.close();
                    AppMethodBeat.o(947);
                    return 2;
                }
                byte[] bArr4 = new byte[iArr[1]];
                if (!e.a(gZIPInputStream2, bArr4, iArr[1])) {
                    fileOutputStream.close();
                    AppMethodBeat.o(947);
                    return 2;
                }
                fileOutputStream.write(bArr4);
                fileOutputStream.flush();
                int i12 = i10 + iArr[1];
                i6 = iArr[2] + i11;
                randomAccessFile.seek((long) i6);
                i7 = i12;
            }
            dataInputStream2.close();
            gZIPInputStream.close();
            gZIPInputStream2.close();
            randomAccessFile.close();
            fileOutputStream.close();
            AppMethodBeat.o(947);
            return 1;
        }
    }
}
