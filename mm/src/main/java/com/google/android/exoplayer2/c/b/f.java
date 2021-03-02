package com.google.android.exoplayer2.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f {
    private static final long[] bkr = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] biE = new byte[8];
    int length;
    private int state;

    public f() {
        AppMethodBeat.i(92032);
        AppMethodBeat.o(92032);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long a(com.google.android.exoplayer2.c.f fVar, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(92033);
        if (this.state == 0) {
            if (!fVar.a(this.biE, 0, 1, z)) {
                AppMethodBeat.o(92033);
                return -1;
            }
            this.length = ea(this.biE[0] & 255);
            if (this.length == -1) {
                IllegalStateException illegalStateException = new IllegalStateException("No valid varint length mask found");
                AppMethodBeat.o(92033);
                throw illegalStateException;
            }
            this.state = 1;
        }
        if (this.length > i2) {
            this.state = 0;
            AppMethodBeat.o(92033);
            return -2;
        }
        if (this.length != 1) {
            fVar.readFully(this.biE, 1, this.length - 1);
        }
        this.state = 0;
        long a2 = a(this.biE, this.length, z2);
        AppMethodBeat.o(92033);
        return a2;
    }

    public static int ea(int i2) {
        for (int i3 = 0; i3 < bkr.length; i3++) {
            if ((bkr[i3] & ((long) i2)) != 0) {
                return i3 + 1;
            }
        }
        return -1;
    }

    public static long a(byte[] bArr, int i2, boolean z) {
        long j2 = ((long) bArr[0]) & 255;
        if (z) {
            j2 &= bkr[i2 - 1] ^ -1;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }
}
