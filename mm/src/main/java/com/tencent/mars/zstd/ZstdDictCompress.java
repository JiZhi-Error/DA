package com.tencent.mars.zstd;

import java.io.Closeable;

public class ZstdDictCompress implements Closeable {
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i2, int i3, int i4);

    public ZstdDictCompress(byte[] bArr, int i2) {
        this(bArr, 0, bArr.length, i2);
    }

    public ZstdDictCompress(byte[] bArr, int i2, int i3, int i4) {
        this.nativePtr = 0;
        if (bArr.length - i2 < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i2, i3, i4);
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createCDict failed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        free();
        this.nativePtr = 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
    }
}
