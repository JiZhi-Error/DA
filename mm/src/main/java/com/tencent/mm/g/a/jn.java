package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jn extends IEvent {
    public a dOq;

    public static final class a {
        public int dGy = 0;
    }

    public jn() {
        this((byte) 0);
    }

    private jn(byte b2) {
        AppMethodBeat.i(140987);
        this.dOq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140987);
    }
}
