package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements j, j.a {
    public final j bcS;
    private j.a bvs;
    private long bvt = -9223372036854775807L;
    private long bvu = -9223372036854775807L;
    private a[] bvv = new a[0];
    private boolean bvw;

    public d(j jVar, boolean z) {
        AppMethodBeat.i(92615);
        this.bcS = jVar;
        this.bvw = z;
        AppMethodBeat.o(92615);
    }

    public final void h(long j2, long j3) {
        this.bvt = j2;
        this.bvu = j3;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void a(j.a aVar, long j2) {
        AppMethodBeat.i(92616);
        this.bvs = aVar;
        this.bcS.a(this, this.bvt + j2);
        AppMethodBeat.o(92616);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void vn() {
        AppMethodBeat.i(92617);
        this.bcS.vn();
        AppMethodBeat.o(92617);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final r vo() {
        AppMethodBeat.i(92618);
        r vo = this.bcS.vo();
        AppMethodBeat.o(92618);
        return vo;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long a(f[] fVarArr, boolean[] zArr, n[] nVarArr, boolean[] zArr2, long j2) {
        boolean z;
        boolean z2;
        n nVar;
        AppMethodBeat.i(92619);
        this.bvv = new a[nVarArr.length];
        n[] nVarArr2 = new n[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            this.bvv[i2] = (a) nVarArr[i2];
            if (this.bvv[i2] != null) {
                nVar = this.bvv[i2].bbF;
            } else {
                nVar = null;
            }
            nVarArr2[i2] = nVar;
        }
        long a2 = this.bcS.a(fVarArr, zArr, nVarArr2, zArr2, j2 + this.bvt);
        if (this.bvw) {
            if (this.bvt != 0) {
                int length = fVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        break;
                    }
                    f fVar = fVarArr[i3];
                    if (!(fVar == null || com.google.android.exoplayer2.i.j.bx(fVar.wz().bdq))) {
                        z2 = true;
                        break;
                    }
                    i3++;
                }
                if (z2) {
                    z = true;
                    this.bvw = z;
                }
            }
            z = false;
            this.bvw = z;
        }
        com.google.android.exoplayer2.i.a.checkState(a2 == this.bvt + j2 || (a2 >= this.bvt && (this.bvu == Long.MIN_VALUE || a2 <= this.bvu)));
        for (int i4 = 0; i4 < nVarArr.length; i4++) {
            if (nVarArr2[i4] == null) {
                this.bvv[i4] = null;
            } else if (nVarArr[i4] == null || this.bvv[i4].bbF != nVarArr2[i4]) {
                this.bvv[i4] = new a(this, nVarArr2[i4], this.bvt, this.bvu, this.bvw);
            }
            nVarArr[i4] = this.bvv[i4];
        }
        long j3 = a2 - this.bvt;
        AppMethodBeat.o(92619);
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final void V(long j2) {
        AppMethodBeat.i(92620);
        this.bcS.V(this.bvt + j2);
        AppMethodBeat.o(92620);
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long vp() {
        boolean z = false;
        AppMethodBeat.i(92621);
        if (this.bvw) {
            a[] aVarArr = this.bvv;
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    aVar.bvx = false;
                }
            }
            this.bvw = false;
            long vp = vp();
            if (vp != -9223372036854775807L) {
                AppMethodBeat.o(92621);
                return vp;
            }
            AppMethodBeat.o(92621);
            return 0;
        }
        long vp2 = this.bcS.vp();
        if (vp2 == -9223372036854775807L) {
            AppMethodBeat.o(92621);
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.i.a.checkState(vp2 >= this.bvt);
        if (this.bvu == Long.MIN_VALUE || vp2 <= this.bvu) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        long j2 = vp2 - this.bvt;
        AppMethodBeat.o(92621);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vq() {
        AppMethodBeat.i(92622);
        long vq = this.bcS.vq();
        if (vq == Long.MIN_VALUE || (this.bvu != Long.MIN_VALUE && vq >= this.bvu)) {
            AppMethodBeat.o(92622);
            return Long.MIN_VALUE;
        }
        long max = Math.max(0L, vq - this.bvt);
        AppMethodBeat.o(92622);
        return max;
    }

    @Override // com.google.android.exoplayer2.source.j
    public final long W(long j2) {
        boolean z = false;
        AppMethodBeat.i(92623);
        a[] aVarArr = this.bvv;
        for (a aVar : aVarArr) {
            if (aVar != null) {
                aVar.bvy = false;
            }
        }
        long W = this.bcS.W(this.bvt + j2);
        if (W == this.bvt + j2 || (W >= this.bvt && (this.bvu == Long.MIN_VALUE || W <= this.bvu))) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        long j3 = W - this.bvt;
        AppMethodBeat.o(92623);
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final long vr() {
        AppMethodBeat.i(92624);
        long vr = this.bcS.vr();
        if (vr == Long.MIN_VALUE || (this.bvu != Long.MIN_VALUE && vr >= this.bvu)) {
            AppMethodBeat.o(92624);
            return Long.MIN_VALUE;
        }
        long j2 = vr - this.bvt;
        AppMethodBeat.o(92624);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.source.j
    public final boolean X(long j2) {
        AppMethodBeat.i(92625);
        boolean X = this.bcS.X(this.bvt + j2);
        AppMethodBeat.o(92625);
        return X;
    }

    @Override // com.google.android.exoplayer2.source.j.a
    public final void a(j jVar) {
        AppMethodBeat.i(92626);
        com.google.android.exoplayer2.i.a.checkState((this.bvt == -9223372036854775807L || this.bvu == -9223372036854775807L) ? false : true);
        this.bvs.a((j) this);
        AppMethodBeat.o(92626);
    }

    static final class a implements n {
        final n bbF;
        private final j bcS;
        private final long bvt;
        private final long bvu;
        boolean bvx;
        boolean bvy;

        public a(j jVar, n nVar, long j2, long j3, boolean z) {
            this.bcS = jVar;
            this.bbF = nVar;
            this.bvt = j2;
            this.bvu = j3;
            this.bvx = z;
        }

        @Override // com.google.android.exoplayer2.source.n
        public final boolean isReady() {
            AppMethodBeat.i(92611);
            boolean isReady = this.bbF.isReady();
            AppMethodBeat.o(92611);
            return isReady;
        }

        @Override // com.google.android.exoplayer2.source.n
        public final void vs() {
            AppMethodBeat.i(92612);
            this.bbF.vs();
            AppMethodBeat.o(92612);
        }

        @Override // com.google.android.exoplayer2.source.n
        public final int b(k kVar, e eVar, boolean z) {
            AppMethodBeat.i(92613);
            if (this.bvx) {
                AppMethodBeat.o(92613);
                return -3;
            } else if (this.bvy) {
                eVar.flags = 4;
                AppMethodBeat.o(92613);
                return -4;
            } else {
                int b2 = this.bbF.b(kVar, eVar, z);
                if (this.bvu == Long.MIN_VALUE || ((b2 != -4 || eVar.timeUs < this.bvu) && !(b2 == -3 && this.bcS.vq() == Long.MIN_VALUE))) {
                    if (b2 == -4 && !eVar.ud()) {
                        eVar.timeUs -= this.bvt;
                    }
                    AppMethodBeat.o(92613);
                    return b2;
                }
                eVar.clear();
                eVar.flags = 4;
                this.bvy = true;
                AppMethodBeat.o(92613);
                return -4;
            }
        }

        @Override // com.google.android.exoplayer2.source.n
        public final void Y(long j2) {
            AppMethodBeat.i(92614);
            this.bbF.Y(this.bvt + j2);
            AppMethodBeat.o(92614);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.exoplayer2.source.o] */
    @Override // com.google.android.exoplayer2.source.o.a
    public final /* bridge */ /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(92627);
        this.bvs.a((o) this);
        AppMethodBeat.o(92627);
    }
}
