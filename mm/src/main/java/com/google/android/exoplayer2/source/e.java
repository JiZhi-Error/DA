package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e implements k, k.a {
    private final k bcG;
    private final ArrayList<d> bvA;
    private k.a bvB;
    private a bvC;
    private final long bvt;
    private final long bvu;
    private final boolean bvz;

    public e(k kVar, long j2, long j3) {
        this(kVar, j2, j3, (byte) 0);
    }

    private e(k kVar, long j2, long j3, byte b2) {
        AppMethodBeat.i(92633);
        com.google.android.exoplayer2.i.a.checkArgument(j2 >= 0);
        this.bcG = (k) com.google.android.exoplayer2.i.a.checkNotNull(kVar);
        this.bvt = j2;
        this.bvu = j3;
        this.bvz = true;
        this.bvA = new ArrayList<>();
        AppMethodBeat.o(92633);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void a(f fVar, k.a aVar) {
        AppMethodBeat.i(92634);
        this.bvB = aVar;
        this.bcG.a(fVar, this);
        AppMethodBeat.o(92634);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vt() {
        AppMethodBeat.i(92635);
        this.bcG.vt();
        AppMethodBeat.o(92635);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final j a(k.b bVar, b bVar2) {
        AppMethodBeat.i(92636);
        d dVar = new d(this.bcG.a(bVar, bVar2), this.bvz);
        this.bvA.add(dVar);
        dVar.h(this.bvC.bvt, this.bvC.bvu);
        AppMethodBeat.o(92636);
        return dVar;
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void b(j jVar) {
        AppMethodBeat.i(92637);
        com.google.android.exoplayer2.i.a.checkState(this.bvA.remove(jVar));
        this.bcG.b(((d) jVar).bcS);
        AppMethodBeat.o(92637);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vu() {
        AppMethodBeat.i(92638);
        this.bcG.vu();
        AppMethodBeat.o(92638);
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public final void a(w wVar, Object obj) {
        AppMethodBeat.i(92639);
        this.bvC = new a(wVar, this.bvt, this.bvu);
        this.bvB.a(this.bvC, obj);
        long j2 = this.bvC.bvt;
        long j3 = this.bvC.bvu == -9223372036854775807L ? Long.MIN_VALUE : this.bvC.bvu;
        int size = this.bvA.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bvA.get(i2).h(j2, j3);
        }
        AppMethodBeat.o(92639);
    }

    static final class a extends w {
        private final w bco;
        private final long bvt;
        private final long bvu;

        public a(w wVar, long j2, long j3) {
            AppMethodBeat.i(92628);
            com.google.android.exoplayer2.i.a.checkArgument(wVar.tD() == 1);
            com.google.android.exoplayer2.i.a.checkArgument(wVar.tE() == 1);
            w.b a2 = wVar.a(0, new w.b());
            com.google.android.exoplayer2.i.a.checkArgument(!a2.bex);
            j3 = j3 == Long.MIN_VALUE ? a2.bdJ : j3;
            if (a2.bdJ != -9223372036854775807L) {
                j3 = j3 > a2.bdJ ? a2.bdJ : j3;
                com.google.android.exoplayer2.i.a.checkArgument(j2 == 0 || a2.bew);
                com.google.android.exoplayer2.i.a.checkArgument(j2 <= j3);
            }
            com.google.android.exoplayer2.i.a.checkArgument(wVar.a(0, new w.a(), false).ben == 0);
            this.bco = wVar;
            this.bvt = j2;
            this.bvu = j3;
            AppMethodBeat.o(92628);
        }

        @Override // com.google.android.exoplayer2.w
        public final int tD() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.w
        public final int aZ(int i2, int i3) {
            AppMethodBeat.i(92629);
            int aZ = this.bco.aZ(i2, i3);
            AppMethodBeat.o(92629);
            return aZ;
        }

        @Override // com.google.android.exoplayer2.w
        public final w.b a(int i2, w.b bVar, boolean z, long j2) {
            long min;
            AppMethodBeat.i(92630);
            w.b a2 = this.bco.a(0, bVar, z, j2);
            a2.bdJ = this.bvu != -9223372036854775807L ? this.bvu - this.bvt : -9223372036854775807L;
            if (a2.beA != -9223372036854775807L) {
                a2.beA = Math.max(a2.beA, this.bvt);
                if (this.bvu == -9223372036854775807L) {
                    min = a2.beA;
                } else {
                    min = Math.min(a2.beA, this.bvu);
                }
                a2.beA = min;
                a2.beA -= this.bvt;
            }
            long v = com.google.android.exoplayer2.b.v(this.bvt);
            if (a2.beu != -9223372036854775807L) {
                a2.beu += v;
            }
            if (a2.bev != -9223372036854775807L) {
                a2.bev = v + a2.bev;
            }
            AppMethodBeat.o(92630);
            return a2;
        }

        @Override // com.google.android.exoplayer2.w
        public final int tE() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.w
        public final w.a a(int i2, w.a aVar, boolean z) {
            long j2 = -9223372036854775807L;
            AppMethodBeat.i(92631);
            w.a a2 = this.bco.a(0, aVar, z);
            if (this.bvu != -9223372036854775807L) {
                j2 = this.bvu - this.bvt;
            }
            a2.bdJ = j2;
            AppMethodBeat.o(92631);
            return a2;
        }

        @Override // com.google.android.exoplayer2.w
        public final int ae(Object obj) {
            AppMethodBeat.i(92632);
            int ae = this.bco.ae(obj);
            AppMethodBeat.o(92632);
            return ae;
        }
    }
}
