package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class i {
    private final int bpH;
    int bpI;
    int bpJ;
    private final byte[] data;

    public i(byte[] bArr) {
        AppMethodBeat.i(92167);
        this.data = bArr;
        this.bpH = bArr.length;
        AppMethodBeat.o(92167);
    }

    public final boolean uI() {
        AppMethodBeat.i(92168);
        boolean z = (((this.data[this.bpI] & 255) >> this.bpJ) & 1) == 1;
        en(1);
        AppMethodBeat.o(92168);
        return z;
    }

    public final int em(int i2) {
        AppMethodBeat.i(92169);
        int i3 = this.bpI;
        int min = Math.min(i2, 8 - this.bpJ);
        int i4 = i3 + 1;
        int i5 = ((this.data[i3] & 255) >> this.bpJ) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.data[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        en(i2);
        AppMethodBeat.o(92169);
        return i6;
    }

    public final void en(int i2) {
        AppMethodBeat.i(92170);
        int i3 = i2 / 8;
        this.bpI += i3;
        this.bpJ = (i2 - (i3 * 8)) + this.bpJ;
        if (this.bpJ > 7) {
            this.bpI++;
            this.bpJ -= 8;
        }
        uJ();
        AppMethodBeat.o(92170);
    }

    private void uJ() {
        AppMethodBeat.i(92171);
        a.checkState(this.bpI >= 0 && (this.bpI < this.bpH || (this.bpI == this.bpH && this.bpJ == 0)));
        AppMethodBeat.o(92171);
    }
}
