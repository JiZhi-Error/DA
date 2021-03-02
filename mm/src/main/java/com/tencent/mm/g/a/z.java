package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class z extends IEvent {
    public a dCX;

    public static final class a {
        public int mode;
    }

    public z() {
        this((byte) 0);
    }

    private z(byte b2) {
        AppMethodBeat.i(149849);
        this.dCX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149849);
    }
}
