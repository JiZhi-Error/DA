package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dq extends IEvent {
    public a dGE;

    public static final class a {
        public boolean enable;
    }

    public dq() {
        this((byte) 0);
    }

    private dq(byte b2) {
        AppMethodBeat.i(115974);
        this.dGE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115974);
    }
}
