package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class et extends IEvent {
    public a dIb;

    public static final class a {
        public boolean dGW = false;
    }

    public et() {
        this((byte) 0);
    }

    private et(byte b2) {
        AppMethodBeat.i(116003);
        this.dIb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116003);
    }
}
