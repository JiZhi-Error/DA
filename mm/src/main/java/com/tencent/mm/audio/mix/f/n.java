package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n extends f {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        AppMethodBeat.i(136882);
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 += this.dwL[i7][i5];
            }
            this.dwO[i5] = (short) (i6 / i2);
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136882);
        return ci;
    }
}
