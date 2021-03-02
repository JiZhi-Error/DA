package com.tencent.mars.zstd;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Zstd {
    public static native long compress(byte[] bArr, byte[] bArr2, int i2);

    public static native long compressBound(long j2);

    public static native long compressByteArray(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5, int i6);

    public static native long compressDirectByteBuffer(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5, int i6);

    public static native long compressDirectByteBufferFastDict(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5, ZstdDictCompress zstdDictCompress);

    public static native long compressDirectByteBufferUsingDict(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5, byte[] bArr, int i6);

    public static native long compressFastDict(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, ZstdDictCompress zstdDictCompress);

    public static native long compressUsingDict(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, byte[] bArr3, int i5);

    public static native long decompress(byte[] bArr, byte[] bArr2);

    public static native long decompressByteArray(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5);

    public static native long decompressDirectByteBuffer(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5);

    public static native long decompressDirectByteBufferFastDict(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5, ZstdDictDecompress zstdDictDecompress);

    public static native long decompressDirectByteBufferUsingDict(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5, byte[] bArr);

    public static native long decompressFastDict(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, ZstdDictDecompress zstdDictDecompress);

    public static native long decompressUsingDict(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, byte[] bArr3);

    public static native long decompressedDirectByteBufferSize(ByteBuffer byteBuffer, int i2, int i3);

    public static native long decompressedSize(byte[] bArr);

    public static native String getErrorName(long j2);

    public static native boolean isError(long j2);

    public static native long trainFromBuffer(byte[][] bArr, byte[] bArr2, boolean z);

    public static native long trainFromBufferDirect(ByteBuffer byteBuffer, int[] iArr, ByteBuffer byteBuffer2, boolean z);

    public static long trainFromBuffer(byte[][] bArr, byte[] bArr2) {
        return trainFromBuffer(bArr, bArr2, false);
    }

    public static long trainFromBufferDirect(ByteBuffer byteBuffer, int[] iArr, ByteBuffer byteBuffer2) {
        return trainFromBufferDirect(byteBuffer, iArr, byteBuffer2, false);
    }

    public static byte[] compress(byte[] bArr) {
        return compress(bArr, 3);
    }

    public static byte[] compress(byte[] bArr, int i2) {
        long compressBound = compressBound((long) bArr.length);
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        byte[] bArr2 = new byte[((int) compressBound)];
        long compress = compress(bArr2, bArr, i2);
        if (!isError(compress)) {
            return Arrays.copyOfRange(bArr2, 0, (int) compress);
        }
        throw new RuntimeException(getErrorName(compress));
    }

    public static int compress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i2) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuf must be a direct buffer");
        } else {
            long compressDirectByteBuffer = compressDirectByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position(), i2);
            if (isError(compressDirectByteBuffer)) {
                throw new RuntimeException(getErrorName(compressDirectByteBuffer));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.position(byteBuffer.position() + ((int) compressDirectByteBuffer));
            return (int) compressDirectByteBuffer;
        }
    }

    public static ByteBuffer compress(ByteBuffer byteBuffer, int i2) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        }
        long compressBound = compressBound((long) (byteBuffer.limit() - byteBuffer.position()));
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) compressBound);
        long compressDirectByteBuffer = compressDirectByteBuffer(allocateDirect, 0, (int) compressBound, byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), i2);
        if (isError(compressDirectByteBuffer)) {
            throw new RuntimeException(getErrorName(compressDirectByteBuffer));
        }
        byteBuffer.position(byteBuffer.limit());
        allocateDirect.limit((int) compressDirectByteBuffer);
        return allocateDirect;
    }

    public static byte[] compress(byte[] bArr, ZstdDictCompress zstdDictCompress) {
        long compressBound = compressBound((long) bArr.length);
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        byte[] bArr2 = new byte[((int) compressBound)];
        long compressFastDict = compressFastDict(bArr2, 0, bArr, 0, bArr.length, zstdDictCompress);
        if (!isError(compressFastDict)) {
            return Arrays.copyOfRange(bArr2, 0, (int) compressFastDict);
        }
        throw new RuntimeException(getErrorName(compressFastDict));
    }

    @Deprecated
    public static long compressUsingDict(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        return compressUsingDict(bArr, 0, bArr2, 0, bArr2.length, bArr3, i2);
    }

    public static byte[] compressUsingDict(byte[] bArr, byte[] bArr2, int i2) {
        long compressBound = compressBound((long) bArr.length);
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        byte[] bArr3 = new byte[((int) compressBound)];
        long compressUsingDict = compressUsingDict(bArr3, 0, bArr, 0, bArr.length, bArr2, i2);
        if (!isError(compressUsingDict)) {
            return Arrays.copyOfRange(bArr3, 0, (int) compressUsingDict);
        }
        throw new RuntimeException(getErrorName(compressUsingDict));
    }

    public static long compress(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        return compressUsingDict(bArr, 0, bArr2, 0, bArr2.length, bArr3, i2);
    }

    public static int compress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, byte[] bArr, int i2) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuf must be a direct buffer");
        } else {
            long compressDirectByteBufferUsingDict = compressDirectByteBufferUsingDict(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position(), bArr, i2);
            if (isError(compressDirectByteBufferUsingDict)) {
                throw new RuntimeException(getErrorName(compressDirectByteBufferUsingDict));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.limit((int) compressDirectByteBufferUsingDict);
            return (int) compressDirectByteBufferUsingDict;
        }
    }

    public static ByteBuffer compress(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        }
        long compressBound = compressBound((long) (byteBuffer.limit() - byteBuffer.position()));
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) compressBound);
        long compressDirectByteBufferUsingDict = compressDirectByteBufferUsingDict(allocateDirect, 0, (int) compressBound, byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), bArr, i2);
        if (isError(compressDirectByteBufferUsingDict)) {
            throw new RuntimeException(getErrorName(compressDirectByteBufferUsingDict));
        }
        byteBuffer.position(byteBuffer.limit());
        allocateDirect.limit((int) compressDirectByteBufferUsingDict);
        return allocateDirect;
    }

    public static int compress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ZstdDictCompress zstdDictCompress) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuf must be a direct buffer");
        } else {
            long compressDirectByteBufferFastDict = compressDirectByteBufferFastDict(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position(), zstdDictCompress);
            if (isError(compressDirectByteBufferFastDict)) {
                throw new RuntimeException(getErrorName(compressDirectByteBufferFastDict));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.limit((int) compressDirectByteBufferFastDict);
            return (int) compressDirectByteBufferFastDict;
        }
    }

    public static ByteBuffer compress(ByteBuffer byteBuffer, ZstdDictCompress zstdDictCompress) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        }
        long compressBound = compressBound((long) (byteBuffer.limit() - byteBuffer.position()));
        if (compressBound > 2147483647L) {
            throw new RuntimeException("Max output size is greater than MAX_INT");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) compressBound);
        long compressDirectByteBufferFastDict = compressDirectByteBufferFastDict(allocateDirect, 0, (int) compressBound, byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), zstdDictCompress);
        if (isError(compressDirectByteBufferFastDict)) {
            throw new RuntimeException(getErrorName(compressDirectByteBufferFastDict));
        }
        byteBuffer.position(byteBuffer.limit());
        allocateDirect.limit((int) compressDirectByteBufferFastDict);
        return allocateDirect;
    }

    public static byte[] decompress(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        long decompress = decompress(bArr2, bArr);
        if (isError(decompress)) {
            throw new RuntimeException(getErrorName(decompress));
        } else if (decompress != ((long) i2)) {
            return Arrays.copyOfRange(bArr2, 0, (int) decompress);
        } else {
            return bArr2;
        }
    }

    public static int decompress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuf must be a direct buffer");
        } else {
            long decompressDirectByteBuffer = decompressDirectByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position());
            if (isError(decompressDirectByteBuffer)) {
                throw new RuntimeException(getErrorName(decompressDirectByteBuffer));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.position(byteBuffer.position() + ((int) decompressDirectByteBuffer));
            return (int) decompressDirectByteBuffer;
        }
    }

    public static ByteBuffer decompress(ByteBuffer byteBuffer, int i2) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuf must be a direct buffer");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        long decompressDirectByteBuffer = decompressDirectByteBuffer(allocateDirect, 0, i2, byteBuffer, byteBuffer.position(), byteBuffer.limit());
        if (isError(decompressDirectByteBuffer)) {
            throw new RuntimeException(getErrorName(decompressDirectByteBuffer));
        }
        byteBuffer.position(byteBuffer.limit());
        return allocateDirect;
    }

    public static byte[] decompress(byte[] bArr, ZstdDictDecompress zstdDictDecompress, int i2) {
        byte[] bArr2 = new byte[i2];
        long decompressFastDict = decompressFastDict(bArr2, 0, bArr, 0, bArr.length, zstdDictDecompress);
        if (isError(decompressFastDict)) {
            throw new RuntimeException(getErrorName(decompressFastDict));
        } else if (decompressFastDict != ((long) i2)) {
            return Arrays.copyOfRange(bArr2, 0, (int) decompressFastDict);
        } else {
            return bArr2;
        }
    }

    @Deprecated
    public static long decompressUsingDict(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return decompressUsingDict(bArr, 0, bArr2, 0, bArr2.length, bArr3);
    }

    public static long decompress(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return decompressUsingDict(bArr, 0, bArr2, 0, bArr2.length, bArr3);
    }

    public static byte[] decompress(byte[] bArr, byte[] bArr2, int i2) {
        byte[] bArr3 = new byte[i2];
        long decompressUsingDict = decompressUsingDict(bArr3, 0, bArr, 0, bArr.length, bArr2);
        if (isError(decompressUsingDict)) {
            throw new RuntimeException(getErrorName(decompressUsingDict));
        } else if (decompressUsingDict != ((long) i2)) {
            return Arrays.copyOfRange(bArr3, 0, (int) decompressUsingDict);
        } else {
            return bArr3;
        }
    }

    public static long decompressedSize(ByteBuffer byteBuffer) {
        return decompressedDirectByteBufferSize(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    public static int decompress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, byte[] bArr) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuff must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuff must be a direct buffer");
        } else {
            long decompressDirectByteBufferUsingDict = decompressDirectByteBufferUsingDict(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position(), bArr);
            if (isError(decompressDirectByteBufferUsingDict)) {
                throw new RuntimeException(getErrorName(decompressDirectByteBufferUsingDict));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.position(byteBuffer.position() + ((int) decompressDirectByteBufferUsingDict));
            return (int) decompressDirectByteBufferUsingDict;
        }
    }

    public static ByteBuffer decompress(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuff must be a direct buffer");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        long decompressDirectByteBufferUsingDict = decompressDirectByteBufferUsingDict(allocateDirect, 0, i2, byteBuffer, byteBuffer.position(), byteBuffer.limit(), bArr);
        if (isError(decompressDirectByteBufferUsingDict)) {
            throw new RuntimeException(getErrorName(decompressDirectByteBufferUsingDict));
        }
        byteBuffer.position(byteBuffer.limit());
        return allocateDirect;
    }

    public static int decompress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ZstdDictDecompress zstdDictDecompress) {
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuff must be a direct buffer");
        } else if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuff must be a direct buffer");
        } else {
            long decompressDirectByteBufferFastDict = decompressDirectByteBufferFastDict(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position(), zstdDictDecompress);
            if (isError(decompressDirectByteBufferFastDict)) {
                throw new RuntimeException(getErrorName(decompressDirectByteBufferFastDict));
            }
            byteBuffer2.position(byteBuffer2.limit());
            byteBuffer.position(byteBuffer.position() + ((int) decompressDirectByteBufferFastDict));
            return (int) decompressDirectByteBufferFastDict;
        }
    }

    public static ByteBuffer decompress(ByteBuffer byteBuffer, ZstdDictDecompress zstdDictDecompress, int i2) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("srcBuff must be a direct buffer");
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        long decompressDirectByteBufferFastDict = decompressDirectByteBufferFastDict(allocateDirect, 0, i2, byteBuffer, byteBuffer.position(), byteBuffer.limit(), zstdDictDecompress);
        if (isError(decompressDirectByteBufferFastDict)) {
            throw new RuntimeException(getErrorName(decompressDirectByteBufferFastDict));
        }
        byteBuffer.position(byteBuffer.limit());
        return allocateDirect;
    }
}
