package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class e implements Runnable {
    private final /* synthetic */ a cuq;

    e(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(130751);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(130751);
    }
}
