package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ki extends IEvent {
    public a dPs;

    public static final class a {
        public int errorCode;
    }

    public ki() {
        this((byte) 0);
    }

    private ki(byte b2) {
        AppMethodBeat.i(104418);
        this.dPs = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104418);
    }
}
