package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.f.c.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92203);
            e[] eVarArr = {new c()};
            AppMethodBeat.o(92203);
            return eVarArr;
        }
    };
    private static final int bqj = x.bJ("ID3");
    private final long bqk;
    private boolean bqn;
    private final d bqu;
    private final m bqv;

    static {
        AppMethodBeat.i(92209);
        AppMethodBeat.o(92209);
    }

    public c() {
        this(0);
    }

    public c(long j2) {
        AppMethodBeat.i(92204);
        this.bqk = j2;
        this.bqu = new d();
        this.bqv = new m(200);
        AppMethodBeat.o(92204);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92205);
        m mVar = new m(10);
        l lVar = new l(mVar.data);
        int i2 = 0;
        while (true) {
            fVar.b(mVar.data, 0, 10);
            mVar.setPosition(0);
            if (mVar.xf() != bqj) {
                break;
            }
            mVar.eZ(3);
            int xj = mVar.xj();
            i2 += xj + 10;
            fVar.dQ(xj);
        }
        fVar.uv();
        fVar.dQ(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        while (true) {
            fVar.b(mVar.data, 0, 2);
            mVar.setPosition(0);
            if ((mVar.readUnsignedShort() & 65526) != 65520) {
                fVar.uv();
                i5++;
                if (i5 - i2 >= 8192) {
                    AppMethodBeat.o(92205);
                    return false;
                }
                fVar.dQ(i5);
                i3 = 0;
                i4 = 0;
            } else {
                i3++;
                if (i3 < 4 || i4 <= 188) {
                    fVar.b(mVar.data, 0, 4);
                    lVar.setPosition(14);
                    int em = lVar.em(13);
                    if (em <= 6) {
                        AppMethodBeat.o(92205);
                        return false;
                    }
                    fVar.dQ(em - 6);
                    i4 += em;
                } else {
                    AppMethodBeat.o(92205);
                    return true;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92206);
        this.bqu.a(gVar, new v.d(0, 1));
        gVar.uy();
        gVar.a(new l.a(-9223372036854775807L));
        AppMethodBeat.o(92206);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92207);
        this.bqn = false;
        this.bqu.uN();
        AppMethodBeat.o(92207);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(92208);
        int read = fVar.read(this.bqv.data, 0, 200);
        if (read == -1) {
            AppMethodBeat.o(92208);
            return -1;
        }
        this.bqv.setPosition(0);
        this.bqv.eY(read);
        if (!this.bqn) {
            this.bqu.timeUs = this.bqk;
            this.bqn = true;
        }
        this.bqu.t(this.bqv);
        AppMethodBeat.o(92208);
        return 0;
    }
}
