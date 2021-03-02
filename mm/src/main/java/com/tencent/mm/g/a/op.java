package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class op extends IEvent {
    public a dUD;

    public static final class a {
        public String dCl;
        public int dUE;
    }

    public op() {
        this((byte) 0);
    }

    private op(byte b2) {
        AppMethodBeat.i(121051);
        this.dUD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121051);
    }
}
