package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ja extends IEvent {
    public a dNH;

    public static final class a {
        public String dNI;
    }

    public ja() {
        this((byte) 0);
    }

    private ja(byte b2) {
        AppMethodBeat.i(123476);
        this.dNH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(123476);
    }
}
