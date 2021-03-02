package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abl extends IEvent {
    public a opW;

    public static final class a {
        public String username;
    }

    public abl() {
        this((byte) 0);
    }

    private abl(byte b2) {
        AppMethodBeat.i(261880);
        this.opW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(261880);
    }
}
