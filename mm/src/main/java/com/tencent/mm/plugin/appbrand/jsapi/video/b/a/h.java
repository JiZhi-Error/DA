package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h implements d, Comparator<f> {
    private long aID;
    public volatile long bGC;
    private final TreeSet<f> bGD = new TreeSet<>(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(f fVar, f fVar2) {
        AppMethodBeat.i(234694);
        f fVar3 = fVar;
        f fVar4 = fVar2;
        if (fVar3.bGr - fVar4.bGr == 0) {
            int d2 = fVar3.d(fVar4);
            AppMethodBeat.o(234694);
            return d2;
        } else if (fVar3.bGr < fVar4.bGr) {
            AppMethodBeat.o(234694);
            return -1;
        } else {
            AppMethodBeat.o(234694);
            return 1;
        }
    }

    public h(long j2) {
        AppMethodBeat.i(234689);
        this.bGC = j2;
        AppMethodBeat.o(234689);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.d
    public final void a(a aVar, long j2) {
        AppMethodBeat.i(234690);
        b(aVar, j2);
        AppMethodBeat.o(234690);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a.AbstractC0709a
    public final void a(a aVar, f fVar) {
        AppMethodBeat.i(234691);
        this.bGD.add(fVar);
        this.aID += fVar.length;
        b(aVar, 0);
        AppMethodBeat.o(234691);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a.AbstractC0709a
    public final void c(f fVar) {
        AppMethodBeat.i(234692);
        this.bGD.remove(fVar);
        this.aID -= fVar.length;
        AppMethodBeat.o(234692);
    }

    private void b(a aVar, long j2) {
        AppMethodBeat.i(234693);
        while (this.aID + j2 > this.bGC && !this.bGD.isEmpty()) {
            aVar.b(this.bGD.first());
        }
        AppMethodBeat.o(234693);
    }
}
