package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rg extends IEvent {
    public a dXW;

    public static final class a {
        public boolean dXX = false;
    }

    public rg() {
        this((byte) 0);
    }

    private rg(byte b2) {
        AppMethodBeat.i(168780);
        this.dXW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168780);
    }
}
