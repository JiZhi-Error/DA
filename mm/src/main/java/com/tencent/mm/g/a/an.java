package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class an extends IEvent {
    public a dDr;

    public static final class a {
        public String userName;
    }

    public an() {
        this((byte) 0);
    }

    private an(byte b2) {
        AppMethodBeat.i(5530);
        this.dDr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(5530);
    }
}
