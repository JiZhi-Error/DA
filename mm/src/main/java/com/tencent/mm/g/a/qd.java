package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qd extends IEvent {
    public a dWt;

    public static final class a {
        public boolean dWu;
    }

    public qd() {
        this((byte) 0);
    }

    private qd(byte b2) {
        AppMethodBeat.i(19824);
        this.dWt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19824);
    }
}
