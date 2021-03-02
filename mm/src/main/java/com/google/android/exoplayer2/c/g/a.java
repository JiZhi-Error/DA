package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.g.c;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public final class a implements e, l {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.g.a.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92306);
            e[] eVarArr = {new a()};
            AppMethodBeat.o(92306);
            return eVarArr;
        }
    };
    private g bir;
    private m bky;
    private b bsP;
    private int bsQ;
    private int bsR;

    static {
        AppMethodBeat.i(92311);
        AppMethodBeat.o(92311);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92307);
        if (c.m(fVar) != null) {
            AppMethodBeat.o(92307);
            return true;
        }
        AppMethodBeat.o(92307);
        return false;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92308);
        this.bir = gVar;
        this.bky = gVar.dV(0);
        this.bsP = null;
        gVar.uy();
        AppMethodBeat.o(92308);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        this.bsR = 0;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        boolean z;
        AppMethodBeat.i(92309);
        if (this.bsP == null) {
            this.bsP = c.m(fVar);
            if (this.bsP == null) {
                o oVar = new o("Unsupported or unrecognized wav header.");
                AppMethodBeat.o(92309);
                throw oVar;
            }
            b bVar = this.bsP;
            this.bky.f(Format.a(null, "audio/raw", bVar.bgE * bVar.bgp * bVar.bsU, 32768, this.bsP.bgE, this.bsP.bgp, this.bsP.encoding, null, null, 0, null));
            this.bsQ = this.bsP.bsT;
        }
        b bVar2 = this.bsP;
        if (bVar2.bsV == 0 || bVar2.dataSize == 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            b bVar3 = this.bsP;
            com.google.android.exoplayer2.i.a.checkNotNull(fVar);
            com.google.android.exoplayer2.i.a.checkNotNull(bVar3);
            fVar.uv();
            com.google.android.exoplayer2.i.m mVar = new com.google.android.exoplayer2.i.m(8);
            c.a a2 = c.a.a(fVar, mVar);
            while (a2.id != x.bJ("data")) {
                new StringBuilder("Ignoring unknown WAV chunk: ").append(a2.id);
                long j2 = 8 + a2.size;
                if (a2.id == x.bJ("RIFF")) {
                    j2 = 12;
                }
                if (j2 > 2147483647L) {
                    o oVar2 = new o("Chunk is too large (~2GB+) to skip; id: " + a2.id);
                    AppMethodBeat.o(92309);
                    throw oVar2;
                }
                fVar.dP((int) j2);
                a2 = c.a.a(fVar, mVar);
            }
            fVar.dP(8);
            long position = fVar.getPosition();
            long j3 = a2.size;
            bVar3.bsV = position;
            bVar3.dataSize = j3;
            this.bir.a(this);
        }
        int a3 = this.bky.a(fVar, 32768 - this.bsR, true);
        if (a3 != -1) {
            this.bsR += a3;
        }
        int i2 = this.bsR / this.bsQ;
        if (i2 > 0) {
            long position2 = ((fVar.getPosition() - ((long) this.bsR)) * TimeUtil.SECOND_TO_US) / ((long) this.bsP.bsS);
            int i3 = i2 * this.bsQ;
            this.bsR -= i3;
            this.bky.a(position2, 1, i3, this.bsR, null);
        }
        if (a3 == -1) {
            AppMethodBeat.o(92309);
            return -1;
        }
        AppMethodBeat.o(92309);
        return 0;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        b bVar = this.bsP;
        return ((bVar.dataSize / ((long) bVar.bsT)) * TimeUtil.SECOND_TO_US) / ((long) bVar.bgp);
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return true;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        AppMethodBeat.i(92310);
        b bVar = this.bsP;
        long min = bVar.bsV + Math.min((((((long) bVar.bsS) * j2) / TimeUtil.SECOND_TO_US) / ((long) bVar.bsT)) * ((long) bVar.bsT), bVar.dataSize - ((long) bVar.bsT));
        AppMethodBeat.o(92310);
        return min;
    }
}
