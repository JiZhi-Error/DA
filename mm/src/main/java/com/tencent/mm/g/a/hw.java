package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hw extends IEvent {
    public a dMx;

    public static final class a {
        public boolean dCs;
        public String dDJ;
    }

    public hw() {
        this((byte) 0);
    }

    private hw(byte b2) {
        AppMethodBeat.i(196070);
        this.dMx = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(196070);
    }
}
