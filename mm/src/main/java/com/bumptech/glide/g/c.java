package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class c extends FilterInputStream {
    private int aNM;
    private final long contentLength;

    public static InputStream a(InputStream inputStream, long j2) {
        AppMethodBeat.i(77728);
        c cVar = new c(inputStream, j2);
        AppMethodBeat.o(77728);
        return cVar;
    }

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.contentLength = j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        int max;
        AppMethodBeat.i(77729);
        max = (int) Math.max(this.contentLength - ((long) this.aNM), (long) this.in.available());
        AppMethodBeat.o(77729);
        return max;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        AppMethodBeat.i(77730);
        read = super.read();
        dq(read >= 0 ? 1 : -1);
        AppMethodBeat.o(77730);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        AppMethodBeat.i(77731);
        int read = read(bArr, 0, bArr.length);
        AppMethodBeat.o(77731);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) {
        int dq;
        AppMethodBeat.i(77732);
        dq = dq(super.read(bArr, i2, i3));
        AppMethodBeat.o(77732);
        return dq;
    }

    private int dq(int i2) {
        AppMethodBeat.i(77733);
        if (i2 >= 0) {
            this.aNM += i2;
        } else if (this.contentLength - ((long) this.aNM) > 0) {
            IOException iOException = new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.aNM);
            AppMethodBeat.o(77733);
            throw iOException;
        }
        AppMethodBeat.o(77733);
        return i2;
    }
}
