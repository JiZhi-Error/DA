package com.tencent.mm.media.widget.camerarecordview.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class d implements Runnable {
    private final /* synthetic */ a cuq;

    d(a aVar) {
        this.cuq = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(94338);
        p.g(this.cuq.invoke(), "invoke(...)");
        AppMethodBeat.o(94338);
    }
}
