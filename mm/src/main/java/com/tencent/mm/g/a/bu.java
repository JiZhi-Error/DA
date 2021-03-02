package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bu extends IEvent {
    public a dEZ;

    public static final class a {
        public boolean isStarted = false;
    }

    public bu() {
        this((byte) 0);
    }

    private bu(byte b2) {
        AppMethodBeat.i(114791);
        this.dEZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114791);
    }
}
