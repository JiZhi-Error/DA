package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class k implements f, Comparator<g> {
    private long aID;
    private final long bGC;
    private final TreeSet<g> bGD = new TreeSet<>(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(g gVar, g gVar2) {
        AppMethodBeat.i(93004);
        g gVar3 = gVar;
        g gVar4 = gVar2;
        if (gVar3.bGr - gVar4.bGr == 0) {
            int d2 = gVar3.d(gVar4);
            AppMethodBeat.o(93004);
            return d2;
        } else if (gVar3.bGr < gVar4.bGr) {
            AppMethodBeat.o(93004);
            return -1;
        } else {
            AppMethodBeat.o(93004);
            return 1;
        }
    }

    public k(long j2) {
        AppMethodBeat.i(196063);
        this.bGC = j2;
        AppMethodBeat.o(196063);
    }

    @Override // com.google.android.exoplayer2.h.a.f
    public final void a(a aVar, long j2) {
        AppMethodBeat.i(92999);
        b(aVar, j2);
        AppMethodBeat.o(92999);
    }

    @Override // com.google.android.exoplayer2.h.a.a.b
    public final void a(a aVar, g gVar) {
        AppMethodBeat.i(93000);
        this.bGD.add(gVar);
        this.aID += gVar.length;
        b(aVar, 0);
        AppMethodBeat.o(93000);
    }

    @Override // com.google.android.exoplayer2.h.a.a.b
    public final void c(g gVar) {
        AppMethodBeat.i(93001);
        this.bGD.remove(gVar);
        this.aID -= gVar.length;
        AppMethodBeat.o(93001);
    }

    @Override // com.google.android.exoplayer2.h.a.a.b
    public final void a(a aVar, g gVar, g gVar2) {
        AppMethodBeat.i(93002);
        c(gVar);
        a(aVar, gVar2);
        AppMethodBeat.o(93002);
    }

    private void b(a aVar, long j2) {
        AppMethodBeat.i(93003);
        while (this.aID + j2 > this.bGC && !this.bGD.isEmpty()) {
            try {
                aVar.b(this.bGD.first());
            } catch (a.C0112a e2) {
            }
        }
        AppMethodBeat.o(93003);
    }
}
