package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements l {
    private final long bdJ;
    public final int[] bhG;
    public final long[] bhH;
    public final long[] bhI;
    public final int length;
    public final long[] offsets;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(91954);
        this.bhG = iArr;
        this.offsets = jArr;
        this.bhH = jArr2;
        this.bhI = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.bdJ = jArr2[this.length - 1] + jArr3[this.length - 1];
            AppMethodBeat.o(91954);
            return;
        }
        this.bdJ = 0;
        AppMethodBeat.o(91954);
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return true;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.bdJ;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        AppMethodBeat.i(91956);
        long j3 = this.offsets[x.a(this.bhI, j2, true)];
        AppMethodBeat.o(91956);
        return j3;
    }
}
