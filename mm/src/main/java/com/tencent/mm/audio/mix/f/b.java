package com.tencent.mm.audio.mix.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends f {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0016 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: short[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.audio.mix.f.f
    public final byte[] H(int i2, int i3, int i4) {
        short sqrt;
        AppMethodBeat.i(136835);
        for (int i5 = 0; i5 < i3; i5++) {
            short s = 1;
            int i6 = 0;
            while (i6 < i2) {
                if (i6 == 0) {
                    sqrt = this.dwL[i6][i5];
                } else {
                    sqrt = (int) (((double) (s + this.dwL[i6][i5])) / Math.sqrt(2.0d));
                }
                i6++;
                s = sqrt;
            }
            this.dwO[i5] = jf(s == 1 ? 1 : 0);
        }
        byte[] ci = ci(i4, i3);
        AppMethodBeat.o(136835);
        return ci;
    }
}
