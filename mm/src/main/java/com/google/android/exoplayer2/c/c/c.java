package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c implements b.a {
    private final long bdJ;
    private final long[] bhI;
    private final long[] bkE;

    c(long[] jArr, long[] jArr2, long j2) {
        this.bhI = jArr;
        this.bkE = jArr2;
        this.bdJ = j2;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return true;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        AppMethodBeat.i(92046);
        long j3 = this.bkE[x.a(this.bhI, j2, true)];
        AppMethodBeat.o(92046);
        return j3;
    }

    @Override // com.google.android.exoplayer2.c.c.b.a
    public final long N(long j2) {
        AppMethodBeat.i(92047);
        long j3 = this.bhI[x.a(this.bkE, j2, true)];
        AppMethodBeat.o(92047);
        return j3;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.bdJ;
    }
}
