package com.tencent.mars.zstd;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZstdInputStream extends FilterInputStream {
    private static final int srcBuffSize = ((int) recommendedDInSize());
    private byte[] dict;
    private long dstPos;
    private ZstdDictDecompress fastDict;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private byte[] src;
    private long srcPos;
    private long srcSize;
    private long stream;

    private static native long createDStream();

    private native int decompressStream(long j2, byte[] bArr, int i2, byte[] bArr2, int i3);

    private static native int freeDStream(long j2);

    private native int initDStream(long j2);

    private native int initDStreamWithDict(long j2, byte[] bArr, int i2);

    private native int initDStreamWithFastDict(long j2, ZstdDictDecompress zstdDictDecompress);

    private static native long recommendedDInSize();

    private static native long recommendedDOutSize();

    public ZstdInputStream(InputStream inputStream) {
        super(inputStream);
        this.dstPos = 0;
        this.srcPos = 0;
        this.srcSize = 0;
        this.src = null;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.dict = null;
        this.fastDict = null;
        this.src = new byte[srcBuffSize];
        if (this.src == null) {
            throw new IOException("Error allocating the input buffer of size " + srcBuffSize);
        }
        this.stream = createDStream();
    }

    public ZstdInputStream setContinuous(boolean z) {
        this.isContinuous = z;
        return this;
    }

    public boolean getContinuous() {
        return this.isContinuous;
    }

    public ZstdInputStream setDict(byte[] bArr) {
        if (!this.frameFinished) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.dict = bArr;
        this.fastDict = null;
        return this;
    }

    public ZstdInputStream setDict(ZstdDictDecompress zstdDictDecompress) {
        if (!this.frameFinished) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.fastDict = zstdDictDecompress;
        this.dict = null;
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int initDStream;
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (this.frameFinished) {
            if (this.fastDict != null) {
                initDStream = initDStreamWithFastDict(this.stream, this.fastDict);
            } else if (this.dict != null) {
                initDStream = initDStreamWithDict(this.stream, this.dict, this.dict.length);
            } else {
                initDStream = initDStream(this.stream);
            }
            if (Zstd.isError((long) initDStream)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName((long) initDStream));
            }
        }
        if (i2 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException("Requested lenght " + i3 + " from offset " + i2 + " in buffer of size " + bArr.length);
        }
        int i4 = i2 + i3;
        this.dstPos = (long) i2;
        while (this.dstPos < ((long) i4)) {
            if (this.srcSize - this.srcPos == 0) {
                this.srcSize = (long) this.in.read(this.src, 0, srcBuffSize);
                this.srcPos = 0;
                if (this.srcSize < 0) {
                    this.srcSize = 0;
                    if (this.frameFinished) {
                        return -1;
                    }
                    if (this.isContinuous) {
                        return (int) (this.dstPos - ((long) i2));
                    }
                    throw new IOException("Read error or truncated source");
                }
                this.frameFinished = false;
            }
            int decompressStream = decompressStream(this.stream, bArr, i4, this.src, (int) this.srcSize);
            if (Zstd.isError((long) decompressStream)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName((long) decompressStream));
            } else if (decompressStream == 0) {
                this.frameFinished = true;
                return (int) (this.dstPos - ((long) i2));
            }
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read > 0) {
            return bArr[0] & 255;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (this.srcSize - this.srcPos > 0) {
            return (int) (this.srcSize - this.srcPos);
        } else {
            return this.in.available();
        }
    }

    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        int read;
        if (this.isClosed) {
            throw new IOException("Stream closed");
        } else if (j2 <= 0) {
            return 0;
        } else {
            int min = (int) Math.min(recommendedDOutSize(), j2);
            byte[] bArr = new byte[min];
            long j3 = j2;
            while (j3 > 0 && (read = read(bArr, 0, (int) Math.min((long) min, j3))) >= 0) {
                j3 -= (long) read;
            }
            return j2 - j3;
        }
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        if (!this.isClosed) {
            freeDStream(this.stream);
            this.in.close();
            this.isClosed = true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
    }
}
