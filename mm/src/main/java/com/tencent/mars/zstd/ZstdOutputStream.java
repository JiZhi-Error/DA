package com.tencent.mars.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ZstdOutputStream extends FilterOutputStream {
    private static final int dstSize = ((int) recommendedCOutSize());
    private boolean closeFrameOnFlush;
    private byte[] dict;
    private byte[] dst;
    private long dstPos;
    private ZstdDictCompress fastDict;
    private boolean frameClosed;
    private boolean isClosed;
    private int level;
    private long srcPos;
    private long stream;
    private boolean useChecksum;

    private native int compressStream(long j2, byte[] bArr, int i2, byte[] bArr2, int i3);

    private static native long createCStream();

    private native int endStream(long j2, byte[] bArr, int i2);

    private native int flushStream(long j2, byte[] bArr, int i2);

    private static native int freeCStream(long j2);

    private native int initCStream(long j2, int i2, int i3);

    private native int initCStreamWithDict(long j2, byte[] bArr, int i2, int i3, int i4);

    private native int initCStreamWithFastDict(long j2, ZstdDictCompress zstdDictCompress, int i2);

    private static native long recommendedCOutSize();

    public ZstdOutputStream(OutputStream outputStream, int i2, boolean z, boolean z2) {
        super(outputStream);
        this.srcPos = 0;
        this.dstPos = 0;
        this.dst = null;
        this.isClosed = false;
        this.frameClosed = true;
        this.dict = null;
        this.fastDict = null;
        this.closeFrameOnFlush = z;
        this.level = i2;
        this.useChecksum = z2;
        this.stream = createCStream();
        this.dst = new byte[dstSize];
    }

    public ZstdOutputStream(OutputStream outputStream, int i2, boolean z) {
        this(outputStream, i2, z, false);
    }

    public ZstdOutputStream(OutputStream outputStream, int i2) {
        this(outputStream, i2, false);
    }

    public ZstdOutputStream(OutputStream outputStream) {
        this(outputStream, 3, false);
    }

    public ZstdOutputStream setChecksum(boolean z) {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.useChecksum = z;
        return this;
    }

    public ZstdOutputStream setDict(byte[] bArr) {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.fastDict = null;
        this.dict = bArr;
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress zstdDictCompress) {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.dict = null;
        this.fastDict = zstdDictCompress;
        return this;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int initCStream;
        int i4 = 1;
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (this.frameClosed) {
            if (this.fastDict != null) {
                long j2 = this.stream;
                ZstdDictCompress zstdDictCompress = this.fastDict;
                if (!this.useChecksum) {
                    i4 = 0;
                }
                initCStream = initCStreamWithFastDict(j2, zstdDictCompress, i4);
            } else if (this.dict != null) {
                initCStream = initCStreamWithDict(this.stream, this.dict, this.dict.length, this.level, this.useChecksum ? 1 : 0);
            } else {
                long j3 = this.stream;
                int i5 = this.level;
                if (!this.useChecksum) {
                    i4 = 0;
                }
                initCStream = initCStream(j3, i5, i4);
            }
            if (Zstd.isError((long) initCStream)) {
                throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName((long) initCStream));
            }
            this.frameClosed = false;
        }
        int i6 = i2 + i3;
        this.srcPos = (long) i2;
        while (this.srcPos < ((long) i6)) {
            int compressStream = compressStream(this.stream, this.dst, dstSize, bArr, i6);
            if (Zstd.isError((long) compressStream)) {
                throw new IOException("Compression error: " + Zstd.getErrorName((long) compressStream));
            } else if (this.dstPos > 0) {
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(int i2) {
        write(new byte[]{(byte) i2}, 0, 1);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.Flushable
    public void flush() {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (!this.frameClosed) {
            if (this.closeFrameOnFlush) {
                int endStream = endStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) endStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                }
                this.frameClosed = true;
            } else {
                int flushStream = flushStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) flushStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) flushStream));
                }
            }
            this.out.write(this.dst, 0, (int) this.dstPos);
            this.out.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
    public void close() {
        if (!this.isClosed) {
            if (!this.frameClosed) {
                int endStream = endStream(this.stream, this.dst, dstSize);
                if (Zstd.isError((long) endStream)) {
                    throw new IOException("Compression error: " + Zstd.getErrorName((long) endStream));
                }
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
            freeCStream(this.stream);
            this.out.close();
            this.isClosed = true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
    }
}
