package com.tencent.mars.zstd;

import java.io.Closeable;

public class ZstdDictDecompress implements Closeable {
    private long nativePtr;

    private native void free();

    private native void init(byte[] bArr, int i2, int i3);

    public ZstdDictDecompress(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ZstdDictDecompress(byte[] bArr, int i2, int i3) {
        this.nativePtr = 0;
        if (bArr.length < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i2, i3);
        if (this.nativePtr == 0) {
            throw new IllegalStateException("ZSTD_createDDict failed");
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
