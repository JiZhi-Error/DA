package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final class b implements Runnable {
    private final /* synthetic */ a cuq;

    public b(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(187348);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(187348);
    }
}