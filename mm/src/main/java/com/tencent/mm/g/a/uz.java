package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uz extends IEvent {
    public a ebq;

    public static final class a {
        public String ebr;
        public int state;
    }

    public uz() {
        this((byte) 0);
    }

    private uz(byte b2) {
        AppMethodBeat.i(94813);
        this.ebq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94813);
    }
}
