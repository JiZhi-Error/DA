package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rv extends IEvent {
    public a dYq;

    public static final class a {
        public int scene = 1;
    }

    public rv() {
        this((byte) 0);
    }

    private rv(byte b2) {
        AppMethodBeat.i(19828);
        this.dYq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19828);
    }
}
