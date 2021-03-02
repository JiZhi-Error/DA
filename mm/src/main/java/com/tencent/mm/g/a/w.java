package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class w extends IEvent {
    public a dCO;

    public static final class a {
        public boolean dCP = false;
        public int scene;
    }

    public w() {
        this((byte) 0);
    }

    private w(byte b2) {
        AppMethodBeat.i(149848);
        this.dCO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149848);
    }
}
