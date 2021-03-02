package android.support.multidex;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* access modifiers changed from: package-private */
public final class c {

    /* access modifiers changed from: package-private */
    public static class a {
        long offset;
        long size;

        a() {
        }
    }

    static long m(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }

    private static a b(RandomAccessFile randomAccessFile) {
        long j2 = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j3 = length - 65536;
        if (j3 >= 0) {
            j2 = j3;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        long j4 = length;
        do {
            randomAccessFile.seek(j4);
            if (randomAccessFile.readInt() != reverseBytes) {
                j4--;
            } else {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & Util.MAX_32BIT_VALUE;
                aVar.offset = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & Util.MAX_32BIT_VALUE;
                return aVar;
            }
        } while (j4 >= j2);
        throw new ZipException("End Of Central Directory signature not found");
    }

    private static long a(RandomAccessFile randomAccessFile, a aVar) {
        CRC32 crc32 = new CRC32();
        long j2 = aVar.size;
        randomAccessFile.seek(aVar.offset);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j2 -= (long) read;
            if (j2 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
        }
        return crc32.getValue();
    }
}
