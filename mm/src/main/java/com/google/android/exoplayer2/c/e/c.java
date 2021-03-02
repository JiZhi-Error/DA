package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.e.c.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92149);
            e[] eVarArr = {new c()};
            AppMethodBeat.o(92149);
            return eVarArr;
        }
    };
    private h boT;
    private g bph;
    private boolean bpi;

    static {
        AppMethodBeat.i(92154);
        AppMethodBeat.o(92154);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92150);
        try {
            boolean j2 = j(fVar);
            AppMethodBeat.o(92150);
            return j2;
        } catch (o e2) {
            AppMethodBeat.o(92150);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        this.bph = gVar;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92151);
        if (this.boT != null) {
            this.boT.f(j2, j3);
        }
        AppMethodBeat.o(92151);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(92152);
        if (this.boT == null) {
            if (!j(fVar)) {
                o oVar = new o("Failed to determine bitstream type");
                AppMethodBeat.o(92152);
                throw oVar;
            }
            fVar.uv();
        }
        if (!this.bpi) {
            m dV = this.bph.dV(0);
            this.bph.uy();
            this.boT.a(this.bph, dV);
            this.bpi = true;
        }
        h hVar = this.boT;
        switch (hVar.state) {
            case 0:
                int l = hVar.l(fVar);
                AppMethodBeat.o(92152);
                return l;
            case 1:
                fVar.dP((int) hVar.bpB);
                hVar.state = 2;
                AppMethodBeat.o(92152);
                return 0;
            case 2:
                int b2 = hVar.b(fVar, kVar);
                AppMethodBeat.o(92152);
                return b2;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(92152);
                throw illegalStateException;
        }
    }

    private boolean j(f fVar) {
        AppMethodBeat.i(92153);
        e eVar = new e();
        if (!eVar.c(fVar, true) || (eVar.type & 2) != 2) {
            AppMethodBeat.o(92153);
            return false;
        }
        int min = Math.min(eVar.bpu, 8);
        com.google.android.exoplayer2.i.m mVar = new com.google.android.exoplayer2.i.m(min);
        fVar.b(mVar.data, 0, min);
        mVar.setPosition(0);
        if (b.r(mVar)) {
            this.boT = new b();
        } else {
            mVar.setPosition(0);
            if (j.r(mVar)) {
                this.boT = new j();
            } else {
                mVar.setPosition(0);
                if (g.r(mVar)) {
                    this.boT = new g();
                } else {
                    AppMethodBeat.o(92153);
                    return false;
                }
            }
        }
        AppMethodBeat.o(92153);
        return true;
    }
}
