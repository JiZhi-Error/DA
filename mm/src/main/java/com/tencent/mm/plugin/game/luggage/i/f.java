package com.tencent.mm.plugin.game.luggage.i;

import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f {
    boolean xzG;
    boolean xzH;
    LinkedList<d> xzI = new LinkedList<>();
    LinkedList<g> xzJ = new LinkedList<>();
    com.tencent.luggage.d.f xzo;

    public f(com.tencent.luggage.d.f fVar) {
        AppMethodBeat.i(187021);
        this.xzo = fVar;
        AppMethodBeat.o(187021);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(187022);
        Log.i("MicroMsg.Page2JsCoreMsgDispatch", "dispatchEvent, hasDestroyed = %b, hasReady = %b", Boolean.valueOf(this.xzH), Boolean.valueOf(this.xzG));
        if (this.xzH) {
            AppMethodBeat.o(187022);
        } else if (!this.xzG) {
            this.xzI.add(dVar);
            AppMethodBeat.o(187022);
        } else {
            this.xzo.a(dVar);
            AppMethodBeat.o(187022);
        }
    }
}
