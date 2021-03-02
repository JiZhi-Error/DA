package com.bumptech.glide.load.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class g extends FilterInputStream {
    private static final byte[] aFe = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    private static final int aFf = 29;
    private static final int aFg = 31;
    private final byte aFh;
    private int position;

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        AppMethodBeat.i(76879);
        if (i2 < -1 || i2 > 8) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot add invalid orientation: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(76879);
            throw illegalArgumentException;
        }
        this.aFh = (byte) i2;
        AppMethodBeat.o(76879);
    }

    public final boolean markSupported() {
        return false;
    }

    public final void mark(int i2) {
        AppMethodBeat.i(76880);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(76880);
        throw unsupportedOperationException;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i2;
        AppMethodBeat.i(76881);
        if (this.position < 2 || this.position > aFg) {
            i2 = super.read();
        } else if (this.position == aFg) {
            i2 = this.aFh;
        } else {
            i2 = aFe[this.position - 2] & 255;
        }
        if (i2 != -1) {
            this.position++;
        }
        AppMethodBeat.o(76881);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int min;
        AppMethodBeat.i(76882);
        if (this.position > aFg) {
            min = super.read(bArr, i2, i3);
        } else if (this.position == aFg) {
            bArr[i2] = this.aFh;
            min = 1;
        } else if (this.position < 2) {
            min = super.read(bArr, i2, 2 - this.position);
        } else {
            min = Math.min(aFg - this.position, i3);
            System.arraycopy(aFe, this.position - 2, bArr, i2, min);
        }
        if (min > 0) {
            this.position += min;
        }
        AppMethodBeat.o(76882);
        return min;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        AppMethodBeat.i(76883);
        long skip = super.skip(j2);
        if (skip > 0) {
            this.position = (int) (((long) this.position) + skip);
        }
        AppMethodBeat.o(76883);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        AppMethodBeat.i(76884);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(76884);
        throw unsupportedOperationException;
    }
}
