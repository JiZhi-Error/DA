package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dh extends IEvent {
    public a dGr;

    public static final class a {
        public int subType = 1;
    }

    public dh() {
        this((byte) 0);
    }

    private dh(byte b2) {
        AppMethodBeat.i(104410);
        this.dGr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104410);
    }
}
