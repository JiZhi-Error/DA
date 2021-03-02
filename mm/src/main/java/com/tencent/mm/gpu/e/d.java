package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private int[] hjo;
    private int[] hjp;
    private boolean hjq;
    private int size;
    int unit;

    public d(int i2) {
        AppMethodBeat.i(186202);
        this.hjq = true;
        this.size = 5;
        this.hjo = new int[5];
        this.hjp = new int[5];
        this.unit = 61166;
        this.hjq = false;
        AppMethodBeat.o(186202);
    }

    public final void J(int i2, int i3, int i4) {
        if (!this.hjq && i2 >= 0 && i2 < this.size) {
            this.hjo[i2] = i3;
            this.hjp[i2] = i4;
        }
    }

    public final int pB(int i2) {
        if (this.hjq) {
            return -1;
        }
        int i3 = 0;
        int i4 = this.size - 1;
        while (i3 <= i4) {
            int i5 = (i3 & i4) + ((i3 ^ i4) >> 1);
            int i6 = this.hjo[i5];
            int i7 = this.hjp[i5];
            if (i2 >= i6 && i2 <= i7) {
                return i5;
            }
            if (i2 < i6) {
                i4 = i5 - 1;
            } else {
                i3 = i5 + 1;
            }
        }
        return -1;
    }

    public final String toString() {
        AppMethodBeat.i(186203);
        if (this.hjq) {
            String obj = super.toString();
            AppMethodBeat.o(186203);
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.size; i2++) {
            int i3 = this.hjo[i2];
            sb.append("[").append(i3).append(", ").append(this.hjp[i2]).append(")\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(186203);
        return sb2;
    }
}
