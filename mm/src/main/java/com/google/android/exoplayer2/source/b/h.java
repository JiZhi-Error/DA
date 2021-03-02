package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.b.a.b;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.d;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class h implements e.AbstractC0115e, k {
    private k.a bvB;
    private final int bvE;
    private e bxz;
    private final d byk;
    private final b.a byl;
    private final Uri bys;
    private final u.a<c> byt;

    static {
        AppMethodBeat.i(62860);
        j.bb("goog.exo.hls");
        AppMethodBeat.o(62860);
    }

    public h(Uri uri, g.a aVar, Handler handler, b bVar) {
        this(uri, aVar, handler, bVar, (byte) 0);
    }

    private h(Uri uri, g.a aVar, Handler handler, b bVar, byte b2) {
        this(uri, new b(aVar), handler, bVar);
        AppMethodBeat.i(62851);
        AppMethodBeat.o(62851);
    }

    private h(Uri uri, d dVar, Handler handler, b bVar) {
        this(uri, dVar, 3, handler, bVar, new d());
        AppMethodBeat.i(62852);
        AppMethodBeat.o(62852);
    }

    private h(Uri uri, d dVar, int i2, Handler handler, b bVar, u.a<c> aVar) {
        AppMethodBeat.i(193637);
        this.bys = uri;
        this.byk = dVar;
        this.bvE = 3;
        this.byt = aVar;
        this.byl = new b.a(handler, bVar);
        AppMethodBeat.o(193637);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void a(f fVar, k.a aVar) {
        AppMethodBeat.i(62854);
        a.checkState(this.bxz == null);
        this.bxz = new e(this.bys, this.byk, this.byl, this.bvE, this, this.byt);
        this.bvB = aVar;
        e eVar = this.bxz;
        eVar.bzM.a(new u(eVar.byk.vO(), eVar.bzH, eVar.byt), eVar, eVar.bzI);
        AppMethodBeat.o(62854);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vt() {
        AppMethodBeat.i(62855);
        e eVar = this.bxz;
        if (eVar.bzN != null) {
            eVar.d(eVar.bzN);
        }
        AppMethodBeat.o(62855);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final com.google.android.exoplayer2.source.j a(k.b bVar, com.google.android.exoplayer2.h.b bVar2) {
        AppMethodBeat.i(62856);
        a.checkArgument(bVar.bwx == 0);
        g gVar = new g(this.bxz, this.byk, this.bvE, this.byl, bVar2);
        AppMethodBeat.o(62856);
        return gVar;
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void b(com.google.android.exoplayer2.source.j jVar) {
        AppMethodBeat.i(62857);
        g gVar = (g) jVar;
        gVar.bxz.listeners.remove(gVar);
        gVar.byn.removeCallbacksAndMessages(null);
        j[] jVarArr = gVar.byp;
        for (j jVar2 : jVarArr) {
            boolean a2 = jVar2.bvK.a(jVar2);
            if (jVar2.bcY && !a2) {
                for (m mVar : jVar2.bvQ) {
                    mVar.vL();
                }
            }
            jVar2.handler.removeCallbacksAndMessages(null);
            jVar2.released = true;
        }
        AppMethodBeat.o(62857);
    }

    @Override // com.google.android.exoplayer2.source.k
    public final void vu() {
        AppMethodBeat.i(62858);
        if (this.bxz != null) {
            e eVar = this.bxz;
            eVar.bzM.a(null);
            for (e.a aVar : eVar.bzJ.values()) {
                aVar.bzR.a(null);
            }
            eVar.bzK.removeCallbacksAndMessages(null);
            eVar.bzJ.clear();
            this.bxz = null;
        }
        this.bvB = null;
        AppMethodBeat.o(62858);
    }

    @Override // com.google.android.exoplayer2.source.b.a.e.AbstractC0115e
    public final void a(com.google.android.exoplayer2.source.b.a.b bVar) {
        p pVar;
        boolean z;
        long j2;
        AppMethodBeat.i(62859);
        long j3 = bVar.byY ? 0 : -9223372036854775807L;
        long v = bVar.byY ? com.google.android.exoplayer2.b.v(bVar.bxn) : -9223372036854775807L;
        long j4 = bVar.byR;
        if (this.bxz.bzP) {
            long j5 = bVar.byX ? bVar.bdJ + bVar.bxn : -9223372036854775807L;
            List<b.a> list = bVar.segments;
            if (j4 == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j2 = 0;
                } else {
                    j2 = list.get(Math.max(0, list.size() - 3)).bzb;
                }
                j4 = j2;
            }
            long j6 = bVar.bdJ;
            long j7 = bVar.bxn;
            if (!bVar.byX) {
                z = true;
            } else {
                z = false;
            }
            pVar = new p(j3, v, j5, j6, j7, j4, true, z);
        } else {
            if (j4 == -9223372036854775807L) {
                j4 = 0;
            }
            pVar = new p(j3, v, bVar.bxn + bVar.bdJ, bVar.bdJ, bVar.bxn, j4, true, false);
        }
        this.bvB.a(pVar, new e(this.bxz.bxQ, bVar));
        AppMethodBeat.o(62859);
    }
}
