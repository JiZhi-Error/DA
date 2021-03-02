package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 15})
public final class d implements Runnable {
    private final /* synthetic */ a cuq;

    d(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(216870);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(216870);
    }
}
