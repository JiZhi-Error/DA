package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class sw extends IEvent {
    public a dZp;

    public static final class a {
        public ca dTX;
        public String dZq;
        public ca dZr;
        public long dZs = 0;
        public long msgId = 0;
    }

    public sw() {
        this((byte) 0);
    }

    private sw(byte b2) {
        AppMethodBeat.i(94799);
        this.dZp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94799);
    }
}
