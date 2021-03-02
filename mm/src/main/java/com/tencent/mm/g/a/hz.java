package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hz extends IEvent {
    public a dMB;

    public static final class a {
        public long id;
    }

    public hz() {
        this((byte) 0);
    }

    private hz(byte b2) {
        AppMethodBeat.i(208805);
        this.dMB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208805);
    }
}
