package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class u extends IEvent {
    public a dCJ;

    public static final class a {
        public String dCK;
        public int percentage;
        public int status;
    }

    public u() {
        this((byte) 0);
    }

    private u(byte b2) {
        AppMethodBeat.i(104408);
        this.dCJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104408);
    }
}
