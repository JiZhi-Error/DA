package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends f {
    private float A = ((float) (this.dwY / this.dwZ));
    private float B = 1.0f;
    private float dwV = 128.0f;
    private float dwW = 128.0f;
    private float dwX = 128.0f;
    private int dwY = 44100;
    private int dwZ = ((int) ((((0.02f * ((float) this.dwY)) * 2.0f) * 16.0f) / 8.0f));

    public k() {
        AppMethodBeat.i(136878);
        AppMethodBeat.o(136878);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        AppMethodBeat.i(136879);
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 += this.dwL[i7][i5];
                if (i6 > this.MAX_VALUE) {
                    this.dwV *= 32768.0f / ((float) i6);
                } else if (i6 < this.MIN_VALUE) {
                    this.dwV *= 32768.0f / ((float) i6);
                }
            }
            if (this.dwV >= this.dwW) {
                this.dwV = ((this.A * (this.dwW + 1.0f)) + (this.B * this.dwV)) / (this.A + this.B);
            } else {
                this.dwV = (this.dwW + this.dwV) / 2.0f;
            }
            this.dwW = this.dwV;
            if ((((int) (this.dwV * 128.0f)) >> 7) != 128) {
                i6 = ((int) (((double) ((this.dwX * this.dwV) / 128.0f)) * ((double) i6))) / 128;
            }
            this.dwO[i5] = jf(i6);
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136879);
        return ci;
    }
}
