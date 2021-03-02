package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e {
    final m bin = new m(8);
    int bkq;

    public e() {
        AppMethodBeat.i(92030);
        AppMethodBeat.o(92030);
    }

    /* access modifiers changed from: package-private */
    public final long d(f fVar) {
        AppMethodBeat.i(92031);
        fVar.b(this.bin.data, 0, 1);
        int i2 = this.bin.data[0] & 255;
        if (i2 == 0) {
            AppMethodBeat.o(92031);
            return Long.MIN_VALUE;
        }
        int i3 = 0;
        int i4 = 128;
        while ((i2 & i4) == 0) {
            i4 >>= 1;
            i3++;
        }
        int i5 = (i4 ^ -1) & i2;
        fVar.b(this.bin.data, 1, i3);
        for (int i6 = 0; i6 < i3; i6++) {
            i5 = (i5 << 8) + (this.bin.data[i6 + 1] & 255);
        }
        this.bkq += i3 + 1;
        long j2 = (long) i5;
        AppMethodBeat.o(92031);
        return j2;
    }
}
