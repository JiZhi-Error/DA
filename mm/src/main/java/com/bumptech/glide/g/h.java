package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class h extends FilterInputStream {
    private int aNU = Integer.MIN_VALUE;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    public final synchronized void mark(int i2) {
        AppMethodBeat.i(77755);
        super.mark(i2);
        this.aNU = i2;
        AppMethodBeat.o(77755);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        AppMethodBeat.i(77756);
        if (q(1) == -1) {
            AppMethodBeat.o(77756);
            return -1;
        }
        int read = super.read();
        r(1);
        AppMethodBeat.o(77756);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(77757);
        int q = (int) q((long) i3);
        if (q == -1) {
            AppMethodBeat.o(77757);
            return -1;
        }
        int read = super.read(bArr, i2, q);
        r((long) read);
        AppMethodBeat.o(77757);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        AppMethodBeat.i(77758);
        super.reset();
        this.aNU = Integer.MIN_VALUE;
        AppMethodBeat.o(77758);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(77759);
        long q = q(j2);
        if (q == -1) {
            AppMethodBeat.o(77759);
            return 0;
        }
        long skip = super.skip(q);
        r(skip);
        AppMethodBeat.o(77759);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        AppMethodBeat.i(77760);
        if (this.aNU == Integer.MIN_VALUE) {
            int available = super.available();
            AppMethodBeat.o(77760);
            return available;
        }
        int min = Math.min(this.aNU, super.available());
        AppMethodBeat.o(77760);
        return min;
    }

    private long q(long j2) {
        if (this.aNU == 0) {
            return -1;
        }
        if (this.aNU == Integer.MIN_VALUE || j2 <= ((long) this.aNU)) {
            return j2;
        }
        return (long) this.aNU;
    }

    private void r(long j2) {
        if (this.aNU != Integer.MIN_VALUE && j2 != -1) {
            this.aNU = (int) (((long) this.aNU) - j2);
        }
    }
}
