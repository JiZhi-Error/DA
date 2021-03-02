package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hl extends IEvent {
    public a dLU;

    public static final class a {
        public long feedId;
    }

    public hl() {
        this((byte) 0);
    }

    private hl(byte b2) {
        AppMethodBeat.i(241573);
        this.dLU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241573);
    }
}
