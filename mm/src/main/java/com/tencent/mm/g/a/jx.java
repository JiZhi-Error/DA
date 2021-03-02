package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jx extends IEvent {
    public a dOQ;

    public static final class a {
        public int scene = 1;
    }

    public jx() {
        this((byte) 0);
    }

    private jx(byte b2) {
        AppMethodBeat.i(155369);
        this.dOQ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155369);
    }
}
