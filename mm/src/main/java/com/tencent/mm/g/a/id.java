package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class id extends IEvent {
    public a dMJ;

    public static final class a {
        public boolean dMK = false;
        public int dML = -1;
        public int scene = -1;
    }

    public id() {
        this((byte) 0);
    }

    private id(byte b2) {
        AppMethodBeat.i(196973);
        this.dMJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(196973);
    }
}
