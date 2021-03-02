package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class g extends IEvent {
    public a dBU;

    public static final class a {
        public String dBV;
    }

    public g() {
        this((byte) 0);
    }

    private g(byte b2) {
        AppMethodBeat.i(115968);
        this.dBU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115968);
    }
}
