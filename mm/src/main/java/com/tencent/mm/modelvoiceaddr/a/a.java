package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int jwX = 0;
    private int jwY = 0;
    int jwZ = 0;
    private short[] jxa;

    public a(int i2) {
        AppMethodBeat.i(148600);
        this.jxa = new short[(i2 <= 1 ? 512 : i2)];
        AppMethodBeat.o(148600);
    }

    /* access modifiers changed from: package-private */
    public final int c(short[] sArr, int i2) {
        int i3;
        AppMethodBeat.i(148601);
        if (i2 > sArr.length) {
            i3 = sArr.length;
        } else {
            i3 = i2;
        }
        if (i3 == 0) {
            AppMethodBeat.o(148601);
            return 0;
        }
        int length = this.jxa.length;
        if (i3 >= this.jwZ) {
            i3 = this.jwZ;
        }
        if (i3 <= length - this.jwX) {
            System.arraycopy(this.jxa, this.jwX, sArr, 0, i3);
            this.jwX += i3;
            if (this.jwX >= length) {
                this.jwX = 0;
            }
        } else {
            int i4 = length - this.jwX;
            System.arraycopy(this.jxa, this.jwX, sArr, 0, i4);
            int i5 = i3 - i4;
            System.arraycopy(this.jxa, 0, sArr, i4, i5);
            this.jwX = i5;
        }
        this.jwZ -= i3;
        AppMethodBeat.o(148601);
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final int d(short[] sArr, int i2) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(148602);
        if (sArr.length < 0) {
            AppMethodBeat.o(148602);
            return 0;
        }
        if (i2 > sArr.length + 0) {
            i3 = sArr.length + 0;
        } else {
            i3 = i2;
        }
        if (i3 == 0) {
            AppMethodBeat.o(148602);
            return 0;
        }
        int length = this.jxa.length - this.jwZ;
        if (i3 > length && (i5 = i3 - length) != 0) {
            if (i5 >= this.jwZ) {
                i5 = this.jwZ;
            }
            if (i5 <= this.jxa.length - this.jwX) {
                this.jwX += i5;
                if (this.jwX >= this.jxa.length) {
                    this.jwX = 0;
                }
            } else {
                this.jwX = i5 - (this.jxa.length - this.jwX);
            }
            this.jwZ -= i5;
        }
        if (i3 > this.jxa.length) {
            i4 = (i3 - this.jxa.length) + 0;
            i3 = this.jxa.length;
        } else {
            i4 = 0;
        }
        if (i3 <= this.jxa.length - this.jwY) {
            System.arraycopy(sArr, i4, this.jxa, this.jwY, i3);
            this.jwY += i3;
            if (this.jwY >= this.jxa.length) {
                this.jwY = 0;
            }
        } else {
            int length2 = this.jxa.length - this.jwY;
            System.arraycopy(sArr, i4, this.jxa, this.jwY, length2);
            int i6 = i3 - length2;
            System.arraycopy(sArr, i4 + length2, this.jxa, 0, i6);
            this.jwY = i6;
        }
        this.jwZ += i3;
        AppMethodBeat.o(148602);
        return i3;
    }
}
