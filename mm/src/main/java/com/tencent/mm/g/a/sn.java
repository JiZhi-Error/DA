package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sn extends IEvent {
    public a dZd;

    public static final class a {
        public int dZe = -1;
    }

    public sn() {
        this((byte) 0);
    }

    private sn(byte b2) {
        AppMethodBeat.i(116046);
        this.dZd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116046);
    }
}
