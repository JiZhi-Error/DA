package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ac extends IEvent {
    public a dDa;

    public static final class a {
        public String url;
    }

    public ac() {
        this((byte) 0);
    }

    private ac(byte b2) {
        AppMethodBeat.i(149850);
        this.dDa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149850);
    }
}
