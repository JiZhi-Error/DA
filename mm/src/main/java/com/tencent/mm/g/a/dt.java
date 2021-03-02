package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dt extends IEvent {
    public a dGM;

    public static final class a {
        public boolean dor;
    }

    public dt() {
        this((byte) 0);
    }

    private dt(byte b2) {
        AppMethodBeat.i(115977);
        this.dGM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115977);
    }
}
