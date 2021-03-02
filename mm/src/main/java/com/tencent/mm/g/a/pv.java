package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pv extends IEvent {
    public a dVV;

    public static final class a {
        public int scene;
        public String sessionId;
    }

    public pv() {
        this((byte) 0);
    }

    private pv(byte b2) {
        AppMethodBeat.i(117615);
        this.dVV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117615);
    }
}
