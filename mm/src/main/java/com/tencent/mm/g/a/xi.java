package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xi extends IEvent {
    public a edC;

    public static final class a {
        public int dJY = 0;
        public String edD;
    }

    public xi() {
        this((byte) 0);
    }

    private xi(byte b2) {
        AppMethodBeat.i(149890);
        this.edC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149890);
    }
}
