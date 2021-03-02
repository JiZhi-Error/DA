package com.tencent.matrix.resource.c.b;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class a {
    public static short n(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) | read2);
        }
        throw new EOFException();
    }

    public static int o(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public static long p(InputStream inputStream) {
        byte[] bArr = new byte[8];
        a(inputStream, bArr, 8);
        return ((long) (bArr[7] & 255)) + (((long) bArr[0]) << 56) + (((long) (bArr[1] & 255)) << 48) + (((long) (bArr[2] & 255)) << 40) + (((long) (bArr[3] & 255)) << 32) + (((long) (bArr[4] & 255)) << 24) + ((long) ((bArr[5] & 255) << 16)) + ((long) ((bArr[6] & 255) << 8));
    }

    public static void a(InputStream inputStream, byte[] bArr, long j2) {
        int i2 = 0;
        while (((long) i2) < j2) {
            int read = inputStream.read(bArr, i2, (int) (j2 - ((long) i2)));
            if (read < 0) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    public static String q(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        int read = inputStream.read();
        while (read != 0) {
            sb.append((char) read);
            read = inputStream.read();
        }
        return sb.toString();
    }

    public static String b(InputStream inputStream, long j2) {
        byte[] bArr = new byte[((int) j2)];
        a(inputStream, bArr, j2);
        return new String(bArr, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
    }

    public static b a(InputStream inputStream, int i2) {
        byte[] bArr = new byte[i2];
        a(inputStream, bArr, (long) i2);
        return new b(bArr);
    }

    public static Object a(InputStream inputStream, c cVar, int i2) {
        switch (cVar) {
            case OBJECT:
                return a(inputStream, i2);
            case BOOLEAN:
                return Boolean.valueOf(inputStream.read() != 0);
            case CHAR:
                return Character.valueOf((char) n(inputStream));
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(o(inputStream)));
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(p(inputStream)));
            case BYTE:
                return Byte.valueOf((byte) inputStream.read());
            case SHORT:
                return Short.valueOf(n(inputStream));
            case INT:
                return Integer.valueOf(o(inputStream));
            case LONG:
                return Long.valueOf(p(inputStream));
            default:
                return null;
        }
    }

    public static void c(InputStream inputStream, long j2) {
        long j3 = 0;
        while (j3 < j2) {
            long skip = inputStream.skip(j2 - j3);
            if (skip < 0) {
                throw new EOFException();
            }
            j3 += skip;
        }
    }

    public static int b(InputStream inputStream, c cVar, int i2) {
        int size = cVar.getSize(i2);
        c(inputStream, (long) size);
        return size;
    }

    public static void a(OutputStream outputStream, int i2) {
        outputStream.write((i2 >>> 8) & 255);
        outputStream.write(i2 & 255);
    }

    public static void b(OutputStream outputStream, int i2) {
        outputStream.write((i2 >>> 24) & 255);
        outputStream.write((i2 >>> 16) & 255);
        outputStream.write((i2 >>> 8) & 255);
        outputStream.write(i2 & 255);
    }

    public static void a(OutputStream outputStream, long j2) {
        outputStream.write(new byte[]{(byte) ((int) (j2 >>> 56)), (byte) ((int) (j2 >>> 48)), (byte) ((int) (j2 >>> 40)), (byte) ((int) (j2 >>> 32)), (byte) ((int) (j2 >>> 24)), (byte) ((int) (j2 >>> 16)), (byte) ((int) (j2 >>> 8)), (byte) ((int) j2)}, 0, 8);
    }

    public static void b(OutputStream outputStream, long j2) {
        byte[] bArr = new byte[4096];
        for (int i2 = 0; ((long) i2) < (j2 >> 12); i2++) {
            outputStream.write(bArr);
        }
        outputStream.write(bArr, 0, (int) (4095 & j2));
    }

    public static void a(OutputStream outputStream, b bVar) {
        outputStream.write(bVar.cZp);
    }
}
