package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tq extends IEvent {
    public a ead;

    public static final class a {
        public byte[] buf;
        public int len;
    }

    public tq() {
        this((byte) 0);
    }

    private tq(byte b2) {
        AppMethodBeat.i(148369);
        this.ead = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(148369);
    }
}
