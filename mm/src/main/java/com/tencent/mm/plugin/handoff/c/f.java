package com.tencent.mm.plugin.handoff.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class f implements Runnable {
    private final /* synthetic */ a cuq;

    f(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(199192);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(199192);
    }
}