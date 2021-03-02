package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mp extends IEvent {
    public a dSe;

    public static final class a {
        public String dSf;
        public String username;
    }

    public mp() {
        this((byte) 0);
    }

    private mp(byte b2) {
        AppMethodBeat.i(149872);
        this.dSe = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149872);
    }
}
