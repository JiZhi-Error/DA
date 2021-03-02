package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class en extends IEvent {
    public a dHU;

    public static final class a {
        public int op = 0;
    }

    public en() {
        this((byte) 0);
    }

    private en(byte b2) {
        AppMethodBeat.i(115997);
        this.dHU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115997);
    }
}
