package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ic extends IEvent {
    public a dMI;

    public static final class a {
        public long key;
    }

    public ic() {
        this((byte) 0);
    }

    private ic(byte b2) {
        AppMethodBeat.i(208808);
        this.dMI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208808);
    }
}
