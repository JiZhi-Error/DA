package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    private int bpH;
    private int bpI;
    private int bpJ;
    private byte[] data;

    public n(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93182);
        l(bArr, i2, i3);
        AppMethodBeat.o(93182);
    }

    public final void l(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93183);
        this.data = bArr;
        this.bpI = i2;
        this.bpH = i3;
        this.bpJ = 0;
        uJ();
        AppMethodBeat.o(93183);
    }

    public final void xb() {
        AppMethodBeat.i(93184);
        int i2 = this.bpJ + 1;
        this.bpJ = i2;
        if (i2 == 8) {
            this.bpJ = 0;
            this.bpI = (fc(this.bpI + 1) ? 2 : 1) + this.bpI;
        }
        uJ();
        AppMethodBeat.o(93184);
    }

    public final void en(int i2) {
        AppMethodBeat.i(93185);
        int i3 = this.bpI;
        int i4 = i2 / 8;
        this.bpI += i4;
        this.bpJ = (i2 - (i4 * 8)) + this.bpJ;
        if (this.bpJ > 7) {
            this.bpI++;
            this.bpJ -= 8;
        }
        while (true) {
            i3++;
            if (i3 > this.bpI) {
                uJ();
                AppMethodBeat.o(93185);
                return;
            } else if (fc(i3)) {
                this.bpI++;
                i3 += 2;
            }
        }
    }

    public final boolean fb(int i2) {
        AppMethodBeat.i(93186);
        int i3 = this.bpI;
        int i4 = i2 / 8;
        int i5 = this.bpI + i4;
        int i6 = (this.bpJ + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        int i7 = i3 + 1;
        while (i7 <= i5 && i5 < this.bpH) {
            if (fc(i7)) {
                i5++;
                i7 += 2;
            }
            i7++;
        }
        if (i5 < this.bpH || (i5 == this.bpH && i6 == 0)) {
            AppMethodBeat.o(93186);
            return true;
        }
        AppMethodBeat.o(93186);
        return false;
    }

    public final boolean uI() {
        AppMethodBeat.i(93187);
        boolean z = (this.data[this.bpI] & (128 >> this.bpJ)) != 0;
        xb();
        AppMethodBeat.o(93187);
        return z;
    }

    public final int em(int i2) {
        int i3 = 2;
        AppMethodBeat.i(93188);
        this.bpJ += i2;
        int i4 = 0;
        while (this.bpJ > 8) {
            this.bpJ -= 8;
            i4 |= (this.data[this.bpI] & 255) << this.bpJ;
            this.bpI = (fc(this.bpI + 1) ? 2 : 1) + this.bpI;
        }
        int i5 = (i4 | ((this.data[this.bpI] & 255) >> (8 - this.bpJ))) & (-1 >>> (32 - i2));
        if (this.bpJ == 8) {
            this.bpJ = 0;
            int i6 = this.bpI;
            if (!fc(this.bpI + 1)) {
                i3 = 1;
            }
            this.bpI = i6 + i3;
        }
        uJ();
        AppMethodBeat.o(93188);
        return i5;
    }

    public final boolean xo() {
        boolean z;
        AppMethodBeat.i(93189);
        int i2 = this.bpI;
        int i3 = this.bpJ;
        int i4 = 0;
        while (this.bpI < this.bpH && !uI()) {
            i4++;
        }
        if (this.bpI == this.bpH) {
            z = true;
        } else {
            z = false;
        }
        this.bpI = i2;
        this.bpJ = i3;
        if (z || !fb((i4 * 2) + 1)) {
            AppMethodBeat.o(93189);
            return false;
        }
        AppMethodBeat.o(93189);
        return true;
    }

    public final int xp() {
        AppMethodBeat.i(93190);
        int xq = xq();
        int i2 = (xq % 2 == 0 ? -1 : 1) * ((xq + 1) / 2);
        AppMethodBeat.o(93190);
        return i2;
    }

    public final int xq() {
        int i2 = 0;
        AppMethodBeat.i(93191);
        int i3 = 0;
        while (!uI()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = em(i3);
        }
        int i5 = i4 + i2;
        AppMethodBeat.o(93191);
        return i5;
    }

    private boolean fc(int i2) {
        return 2 <= i2 && i2 < this.bpH && this.data[i2] == 3 && this.data[i2 + -2] == 0 && this.data[i2 + -1] == 0;
    }

    private void uJ() {
        AppMethodBeat.i(93192);
        a.checkState(this.bpI >= 0 && (this.bpI < this.bpH || (this.bpI == this.bpH && this.bpJ == 0)));
        AppMethodBeat.o(93192);
    }
}
