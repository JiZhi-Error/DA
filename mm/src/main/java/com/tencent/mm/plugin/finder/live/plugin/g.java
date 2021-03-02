package com.tencent.mm.plugin.finder.live.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final class g implements Runnable {
    private final /* synthetic */ a cuq;

    public g(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(246403);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(246403);
    }
}
