package com.tencent.mm.plugin.mv.ui.b;

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
        AppMethodBeat.i(257075);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(257075);
    }
}
