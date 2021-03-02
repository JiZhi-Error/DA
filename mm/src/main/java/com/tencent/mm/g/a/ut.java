package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ut extends IEvent {
    public a eba;

    public static final class a {
        public com.tencent.mm.plugin.wallet_core.model.a ebb;
    }

    public ut() {
        this((byte) 0);
    }

    private ut(byte b2) {
        AppMethodBeat.i(63292);
        this.eba = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(63292);
    }
}
