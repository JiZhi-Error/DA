package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class h implements Runnable {
    private final /* synthetic */ a cuq;

    h(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(190861);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(190861);
    }
}
