package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l extends f {
    private float dwT = 1.0f;
    private boolean dwU = true;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(136880);
        this.dwU = true;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                i7 += this.dwL[i8][i6];
            }
            boolean z = this.dwU;
            while (true) {
                i5 = (int) (this.dwT * ((float) i7));
                if (i5 <= this.MAX_VALUE) {
                    if (i5 >= this.MIN_VALUE) {
                        break;
                    }
                    this.dwT = ((float) this.MIN_VALUE) / ((float) i7);
                    if (this.dwT < 1.0f) {
                        this.dwT -= (1.0f - this.dwT) / 16.0f;
                    }
                    z = false;
                    i7 = i5;
                } else {
                    this.dwT = ((float) this.MAX_VALUE) / ((float) i7);
                    if (this.dwT < 1.0f) {
                        this.dwT -= (1.0f - this.dwT) / 16.0f;
                    }
                    z = false;
                    i7 = i5;
                }
            }
            if (z && i7 < this.MAX_VALUE && i7 > this.MIN_VALUE) {
                if (this.dwT < 1.0f) {
                    this.dwT += (1.0f - this.dwT) / 16.0f;
                }
                this.dwU = false;
            }
            this.dwO[i6] = jf(i5);
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136880);
        return ci;
    }
}
