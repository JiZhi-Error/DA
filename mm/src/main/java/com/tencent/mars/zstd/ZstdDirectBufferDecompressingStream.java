package com.tencent.mars.zstd;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ZstdDirectBufferDecompressingStream implements Closeable {
    private boolean closed = false;
    private int consumed;
    private byte[] dict = null;
    private ZstdDictDecompress fastDict = null;
    private boolean finishedFrame = false;
    private boolean initialized = false;
    private int produced;
    private ByteBuffer source;
    private final long stream;
    private boolean streamEnd = false;

    private static native long createDStream();

    private native long decompressStream(long j2, ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5);

    private static native int freeDStream(long j2);

    private native int initDStream(long j2);

    private native int initDStreamWithDict(long j2, byte[] bArr, int i2);

    private native int initDStreamWithFastDict(long j2, ZstdDictDecompress zstdDictDecompress);

    private static native int recommendedDOutSize();

    /* access modifiers changed from: protected */
    public ByteBuffer refill(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public ZstdDirectBufferDecompressingStream(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Source buffer should be a direct buffer");
        }
        this.source = byteBuffer;
        this.stream = createDStream();
    }

    public boolean hasRemaining() {
        return !this.streamEnd && (this.source.hasRemaining() || !this.finishedFrame);
    }

    public static int recommendedTargetBufferSize() {
        return recommendedDOutSize();
    }

    public ZstdDirectBufferDecompressingStream setDict(byte[] bArr) {
        if (this.initialized) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.dict = bArr;
        this.fastDict = null;
        return this;
    }

    public ZstdDirectBufferDecompressingStream setDict(ZstdDictDecompress zstdDictDecompress) {
        if (this.initialized) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.fastDict = zstdDictDecompress;
        this.dict = null;
        return this;
    }

    private void initStream() {
        int initDStream;
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
        this.initialized = true;
    }

    public int read(ByteBuffer byteBuffer) {
        boolean z = false;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Target buffer should be a direct buffer");
        } else if (this.closed) {
            throw new IOException("Stream closed");
        } else if (this.streamEnd) {
            return 0;
        } else {
            if (!this.initialized) {
                initStream();
            }
            long decompressStream = decompressStream(this.stream, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), this.source, this.source.position(), this.source.remaining());
            if (Zstd.isError(decompressStream)) {
                throw new IOException(Zstd.getErrorName(decompressStream));
            }
            this.source.position(this.source.position() + this.consumed);
            byteBuffer.position(byteBuffer.position() + this.produced);
            if (!this.source.hasRemaining()) {
                this.source = refill(this.source);
                if (!this.source.isDirect()) {
                    throw new IllegalArgumentException("Source buffer should be a direct buffer");
                }
            }
            if (decompressStream == 0) {
                z = true;
            }
            this.finishedFrame = z;
            if (this.finishedFrame) {
                if (this.source.hasRemaining()) {
                    initStream();
                } else {
                    this.streamEnd = true;
                }
            }
            return this.produced;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            try {
                if (this.initialized) {
                    freeDStream(this.stream);
                }
            } finally {
                this.closed = true;
                this.initialized = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        if (!this.closed && this.initialized) {
            freeDStream(this.stream);
        }
        this.source = null;
    }
}
