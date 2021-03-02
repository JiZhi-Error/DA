package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pq extends IEvent {
    public a dVG;

    public static final class a {
        public byte[] content;
    }

    public pq() {
        this((byte) 0);
    }

    private pq(byte b2) {
        AppMethodBeat.i(149878);
        this.dVG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149878);
    }
}
