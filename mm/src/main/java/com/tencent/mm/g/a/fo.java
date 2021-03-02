package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fo extends IEvent {
    public a dIN;

    public static final class a {
        public String username;
    }

    public fo() {
        this((byte) 0);
    }

    private fo(byte b2) {
        AppMethodBeat.i(55661);
        this.dIN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(55661);
    }
}
