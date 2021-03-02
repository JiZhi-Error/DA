package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p extends w {
    private static final Object bxc = new Object();
    private final long beu;
    private final long bev;
    private final boolean bew;
    private final boolean bex;
    private final long bxd;
    private final long bxe;
    private final long bxf;
    private final long bxg;

    static {
        AppMethodBeat.i(92719);
        AppMethodBeat.o(92719);
    }

    public p(long j2, boolean z) {
        this(j2, j2, z);
        AppMethodBeat.i(92715);
        AppMethodBeat.o(92715);
    }

    private p(long j2, long j3, boolean z) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j3, 0, 0, z, false);
    }

    public p(long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2) {
        this.beu = j2;
        this.bev = j3;
        this.bxd = j4;
        this.bxe = j5;
        this.bxf = j6;
        this.bxg = j7;
        this.bew = z;
        this.bex = z2;
    }

    @Override // com.google.android.exoplayer2.w
    public final int tD() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.w
    public final w.b a(int i2, w.b bVar, boolean z, long j2) {
        AppMethodBeat.i(92716);
        a.bh(i2, 1);
        Object obj = z ? bxc : null;
        long j3 = this.bxg;
        if (this.bex) {
            j3 += j2;
            if (j3 > this.bxe) {
                j3 = -9223372036854775807L;
            }
        }
        long j4 = this.beu;
        long j5 = this.bev;
        boolean z2 = this.bew;
        boolean z3 = this.bex;
        long j6 = this.bxe;
        long j7 = this.bxf;
        bVar.bem = obj;
        bVar.beu = j4;
        bVar.bev = j5;
        bVar.bew = z2;
        bVar.bex = z3;
        bVar.beA = j3;
        bVar.bdJ = j6;
        bVar.bey = 0;
        bVar.bez = 0;
        bVar.beB = j7;
        AppMethodBeat.o(92716);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.w
    public final int tE() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.w
    public final w.a a(int i2, w.a aVar, boolean z) {
        Object obj;
        AppMethodBeat.i(92717);
        a.bh(i2, 1);
        if (z) {
            obj = bxc;
        } else {
            obj = null;
        }
        long j2 = this.bxd;
        aVar.bem = obj;
        aVar.bcT = obj;
        aVar.bdi = 0;
        aVar.bdJ = j2;
        aVar.ben = -this.bxf;
        aVar.beo = null;
        aVar.bep = null;
        aVar.beq = null;
        aVar.ber = null;
        aVar.bes = null;
        aVar.bet = -9223372036854775807L;
        AppMethodBeat.o(92717);
        return aVar;
    }

    @Override // com.google.android.exoplayer2.w
    public final int ae(Object obj) {
        AppMethodBeat.i(92718);
        if (bxc.equals(obj)) {
            AppMethodBeat.o(92718);
            return 0;
        }
        AppMethodBeat.o(92718);
        return -1;
    }
}
