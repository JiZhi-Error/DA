package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ql extends IEvent {
    public a dWU;

    public static final class a {
        public String productId;
    }

    public ql() {
        this((byte) 0);
    }

    private ql(byte b2) {
        AppMethodBeat.i(104420);
        this.dWU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104420);
    }
}
