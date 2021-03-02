package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aay extends IEvent {
    public a eid;

    public static final class a {
        public int eie;
    }

    public aay() {
        this((byte) 0);
    }

    private aay(byte b2) {
        AppMethodBeat.i(116061);
        this.eid = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116061);
    }
}
