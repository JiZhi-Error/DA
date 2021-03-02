package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l {
    private int bpH;
    public int bpI;
    public int bpJ;
    public byte[] data;

    public l() {
    }

    public l(byte[] bArr) {
        this(bArr, bArr.length);
        AppMethodBeat.i(93155);
        AppMethodBeat.o(93155);
    }

    public l(byte[] bArr, int i2) {
        this.data = bArr;
        this.bpH = i2;
    }

    public final void n(byte[] bArr, int i2) {
        this.data = bArr;
        this.bpI = 0;
        this.bpJ = 0;
        this.bpH = i2;
    }

    public final int wZ() {
        return ((this.bpH - this.bpI) * 8) - this.bpJ;
    }

    public final int xa() {
        AppMethodBeat.i(93156);
        a.checkState(this.bpJ == 0);
        int i2 = this.bpI;
        AppMethodBeat.o(93156);
        return i2;
    }

    public final void setPosition(int i2) {
        AppMethodBeat.i(93157);
        this.bpI = i2 / 8;
        this.bpJ = i2 - (this.bpI * 8);
        uJ();
        AppMethodBeat.o(93157);
    }

    private void xb() {
        AppMethodBeat.i(93158);
        int i2 = this.bpJ + 1;
        this.bpJ = i2;
        if (i2 == 8) {
            this.bpJ = 0;
            this.bpI++;
        }
        uJ();
        AppMethodBeat.o(93158);
    }

    public final void en(int i2) {
        AppMethodBeat.i(93159);
        int i3 = i2 / 8;
        this.bpI += i3;
        this.bpJ = (i2 - (i3 * 8)) + this.bpJ;
        if (this.bpJ > 7) {
            this.bpI++;
            this.bpJ -= 8;
        }
        uJ();
        AppMethodBeat.o(93159);
    }

    public final boolean uI() {
        AppMethodBeat.i(93160);
        boolean z = (this.data[this.bpI] & (128 >> this.bpJ)) != 0;
        xb();
        AppMethodBeat.o(93160);
        return z;
    }

    public final int em(int i2) {
        AppMethodBeat.i(93161);
        if (i2 == 0) {
            AppMethodBeat.o(93161);
            return 0;
        }
        this.bpJ += i2;
        int i3 = 0;
        while (this.bpJ > 8) {
            this.bpJ -= 8;
            byte[] bArr = this.data;
            int i4 = this.bpI;
            this.bpI = i4 + 1;
            i3 |= (bArr[i4] & 255) << this.bpJ;
        }
        int i5 = (i3 | ((this.data[this.bpI] & 255) >> (8 - this.bpJ))) & (-1 >>> (32 - i2));
        if (this.bpJ == 8) {
            this.bpJ = 0;
            this.bpI++;
        }
        uJ();
        AppMethodBeat.o(93161);
        return i5;
    }

    public final void xc() {
        AppMethodBeat.i(93162);
        if (this.bpJ == 0) {
            AppMethodBeat.o(93162);
            return;
        }
        this.bpJ = 0;
        this.bpI++;
        uJ();
        AppMethodBeat.o(93162);
    }

    public final void p(byte[] bArr, int i2) {
        boolean z;
        AppMethodBeat.i(93163);
        if (this.bpJ == 0) {
            z = true;
        } else {
            z = false;
        }
        a.checkState(z);
        System.arraycopy(this.data, this.bpI, bArr, 0, i2);
        this.bpI += i2;
        uJ();
        AppMethodBeat.o(93163);
    }

    public final void uJ() {
        AppMethodBeat.i(93164);
        a.checkState(this.bpI >= 0 && (this.bpI < this.bpH || (this.bpI == this.bpH && this.bpJ == 0)));
        AppMethodBeat.o(93164);
    }
}
