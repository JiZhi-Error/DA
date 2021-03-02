package com.tencent.mm.plugin.wepkg.d;

import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class c extends FilterInputStream {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        return this.in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return this.in.read(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        return this.in.read(bArr, i2, i3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        return this.in.skip(j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        this.in.close();
    }

    public synchronized void mark(int i2) {
        this.in.mark(i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.in.reset();
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }
}
