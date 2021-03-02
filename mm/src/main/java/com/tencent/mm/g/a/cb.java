package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cb extends IEvent {
    public a dFh;

    public static final class a {
        public long dFi;
    }

    public cb() {
        this((byte) 0);
    }

    private cb(byte b2) {
        AppMethodBeat.i(149858);
        this.dFh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149858);
    }
}
