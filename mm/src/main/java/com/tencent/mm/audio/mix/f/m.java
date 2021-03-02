package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends f {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        AppMethodBeat.i(136881);
        for (int i5 = 0; i5 < i3; i5++) {
            float f2 = 1.0f;
            for (int i6 = 0; i6 < i2; i6++) {
                if (i6 == 0) {
                    f2 = (float) this.dwL[i6][i5];
                } else {
                    float f3 = (float) this.dwL[i6][i5];
                    if (f2 < 0.0f && f3 < 0.0f) {
                        f2 = (f2 + f3) - ((f2 * f3) / ((float) this.MIN_VALUE));
                    } else if (f2 <= 0.0f || f3 <= 0.0f) {
                        f2 += f3;
                    } else {
                        f2 = (f2 + f3) - ((f2 * f3) / ((float) this.MAX_VALUE));
                    }
                }
            }
            this.dwO[i5] = jf((int) f2);
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136881);
        return ci;
    }
}
