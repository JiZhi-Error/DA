package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.f.a.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92190);
            e[] eVarArr = {new a()};
            AppMethodBeat.o(92190);
            return eVarArr;
        }
    };
    private static final int bqj = x.bJ("ID3");
    private final long bqk;
    private final b bql;
    private final m bqm;
    private boolean bqn;

    static {
        AppMethodBeat.i(92196);
        AppMethodBeat.o(92196);
    }

    public a() {
        this(0);
    }

    public a(long j2) {
        AppMethodBeat.i(92191);
        this.bqk = j2;
        this.bql = new b();
        this.bqm = new m(2786);
        AppMethodBeat.o(92191);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92192);
        m mVar = new m(10);
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
        int i4 = i2;
        while (true) {
            fVar.b(mVar.data, 0, 5);
            mVar.setPosition(0);
            if (mVar.readUnsignedShort() != 2935) {
                fVar.uv();
                i4++;
                if (i4 - i2 >= 8192) {
                    AppMethodBeat.o(92192);
                    return false;
                }
                fVar.dQ(i4);
                i3 = 0;
            } else {
                i3++;
                if (i3 >= 4) {
                    AppMethodBeat.o(92192);
                    return true;
                }
                int n = com.google.android.exoplayer2.a.a.n(mVar.data);
                if (n == -1) {
                    AppMethodBeat.o(92192);
                    return false;
                }
                fVar.dQ(n - 5);
            }
        }
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92193);
        this.bql.a(gVar, new v.d(0, 1));
        gVar.uy();
        gVar.a(new l.a(-9223372036854775807L));
        AppMethodBeat.o(92193);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92194);
        this.bqn = false;
        this.bql.uK();
        AppMethodBeat.o(92194);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(92195);
        int read = fVar.read(this.bqm.data, 0, 2786);
        if (read == -1) {
            AppMethodBeat.o(92195);
            return -1;
        }
        this.bqm.setPosition(0);
        this.bqm.eY(read);
        if (!this.bqn) {
            this.bql.timeUs = this.bqk;
            this.bqn = true;
        }
        this.bql.t(this.bqm);
        AppMethodBeat.o(92195);
        return 0;
    }
}
