package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sz extends IEvent {
    public a dZv;

    public static final class a {
        public String info;
    }

    public sz() {
        this((byte) 0);
    }

    private sz(byte b2) {
        AppMethodBeat.i(192279);
        this.dZv = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(192279);
    }
}
