package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final class d implements Runnable {
    private final /* synthetic */ a cuq;

    public d(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(221356);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(221356);
    }
}
