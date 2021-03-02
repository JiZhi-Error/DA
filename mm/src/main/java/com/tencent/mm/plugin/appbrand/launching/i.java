package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class i implements Runnable {
    private final /* synthetic */ a cuq;

    i(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(50756);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(50756);
    }
}
