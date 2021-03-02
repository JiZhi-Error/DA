package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nl extends IEvent {
    public a dTC;

    public static final class a {
        public int dTD;
    }

    public nl() {
        this((byte) 0);
    }

    private nl(byte b2) {
        AppMethodBeat.i(116033);
        this.dTC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116033);
    }
}
