package com.tencent.mm.media.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class b implements Runnable {
    private final /* synthetic */ a cuq;

    b(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(93739);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(93739);
    }
}
