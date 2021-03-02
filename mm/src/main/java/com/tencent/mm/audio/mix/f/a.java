package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends f {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        short jf;
        AppMethodBeat.i(136834);
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (i6 < i2) {
                f2 = (float) (((double) f2) + (Math.pow((double) this.dwL[i6][i5], 2.0d) * ((double) Math.signum((float) this.dwL[i6][i5]))));
                i6++;
                f3 = ((float) Math.abs((int) this.dwL[i6][i5])) + f3;
            }
            int i7 = f3 == 0.0f ? 0 : (int) (f2 / f3);
            short[] sArr = this.dwO;
            if (f3 == 0.0f) {
                jf = 0;
            } else {
                jf = jf(i7);
            }
            sArr[i5] = jf;
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136834);
        return ci;
    }
}
