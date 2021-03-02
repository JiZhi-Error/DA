package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    public final ByteBuffer cDi;
    private int cDj;

    public a(ByteBuffer byteBuffer) {
        this.cDi = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        AppMethodBeat.i(140473);
        int remaining = this.cDi.remaining();
        AppMethodBeat.o(140473);
        return remaining;
    }

    @Override // java.io.InputStream
    public final int read() {
        AppMethodBeat.i(140474);
        if (this.cDi.hasRemaining()) {
            int i2 = this.cDi.get() & 255;
            AppMethodBeat.o(140474);
            return i2;
        }
        AppMethodBeat.o(140474);
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(140475);
        if (!this.cDi.hasRemaining()) {
            AppMethodBeat.o(140475);
            return -1;
        }
        int min = Math.min(i3, this.cDi.remaining());
        this.cDi.get(bArr, i2, min);
        AppMethodBeat.o(140475);
        return min;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() {
        AppMethodBeat.i(140476);
        super.close();
        i(this.cDi);
        AppMethodBeat.o(140476);
    }

    public final synchronized void mark(int i2) {
        AppMethodBeat.i(140477);
        this.cDj = this.cDi.position();
        AppMethodBeat.o(140477);
    }

    public final synchronized void seek(int i2) {
        AppMethodBeat.i(140478);
        this.cDi.position(i2);
        AppMethodBeat.o(140478);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        AppMethodBeat.i(140479);
        this.cDi.position(this.cDj);
        AppMethodBeat.o(140479);
    }

    public final boolean markSupported() {
        return true;
    }

    public final long getLength() {
        AppMethodBeat.i(140480);
        long limit = (long) this.cDi.limit();
        AppMethodBeat.o(140480);
        return limit;
    }

    public final ByteBuffer Pf() {
        return this.cDi;
    }

    public static void i(ByteBuffer byteBuffer) {
        AppMethodBeat.i(140481);
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                org.a.a.gG(org.a.a.gG(byteBuffer).bvt("cleaner").object).bvt("clean");
                AppMethodBeat.o(140481);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(140481);
    }
}
