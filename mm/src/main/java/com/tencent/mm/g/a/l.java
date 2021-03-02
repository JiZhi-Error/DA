package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class l extends IEvent {
    public a dCi;

    public static final class a {
        public boolean isActive;
    }

    public l() {
        this((byte) 0);
    }

    private l(byte b2) {
        AppMethodBeat.i(42650);
        this.dCi = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42650);
    }
}
