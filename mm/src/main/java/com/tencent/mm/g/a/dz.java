package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dz extends IEvent {
    public a dHd;

    public static final class a {
        public boolean dHe = false;
    }

    public dz() {
        this((byte) 0);
    }

    private dz(byte b2) {
        AppMethodBeat.i(115983);
        this.dHd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115983);
    }
}
