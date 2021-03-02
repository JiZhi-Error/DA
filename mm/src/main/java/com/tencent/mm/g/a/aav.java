package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aav extends IEvent {
    public a ehL;

    public static final class a {
        public String dvn;
    }

    public aav() {
        this((byte) 0);
    }

    private aav(byte b2) {
        AppMethodBeat.i(91236);
        this.ehL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91236);
    }
}
