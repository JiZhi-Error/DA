package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* access modifiers changed from: package-private */
public final class s {
    private final List<Format> bqG;
    private final m[] bqJ;

    public s(List<Format> list) {
        AppMethodBeat.i(92282);
        this.bqG = list;
        this.bqJ = new m[list.size()];
        AppMethodBeat.o(92282);
    }

    public final void a(g gVar, v.d dVar) {
        AppMethodBeat.i(92283);
        for (int i2 = 0; i2 < this.bqJ.length; i2++) {
            dVar.uW();
            m dV = gVar.dV(dVar.getTrackId());
            Format format = this.bqG.get(i2);
            String str = format.bdq;
            a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            dV.f(Format.a(format.id != null ? format.id : dVar.uX(), str, format.bdD, format.language, format.bdE));
            this.bqJ[i2] = dV;
        }
        AppMethodBeat.o(92283);
    }

    public final void a(long j2, com.google.android.exoplayer2.i.m mVar) {
        AppMethodBeat.i(92284);
        com.google.android.exoplayer2.f.a.g.a(j2, mVar, this.bqJ);
        AppMethodBeat.o(92284);
    }
}
