package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ad extends IEvent {
    public a dDb;

    public static final class a {
        public boolean dDc;
    }

    public ad() {
        this((byte) 0);
    }

    private ad(byte b2) {
        AppMethodBeat.i(155364);
        this.dDb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155364);
    }
}
