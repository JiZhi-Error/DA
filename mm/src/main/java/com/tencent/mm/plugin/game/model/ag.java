package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.protobuf.dx;

public final class ag extends x {
    public dx xHx;

    public ag(a aVar) {
        AppMethodBeat.i(41554);
        if (aVar == null) {
            this.xHx = new dx();
            AppMethodBeat.o(41554);
            return;
        }
        this.xHx = (dx) aVar;
        AppMethodBeat.o(41554);
    }
}
