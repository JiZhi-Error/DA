package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class av extends IEvent {
    public a dDS;

    public static final class a {
        public String dDT;
        public String dDU;
        public int dDV;
    }

    public av() {
        this((byte) 0);
    }

    private av(byte b2) {
        AppMethodBeat.i(91196);
        this.dDS = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91196);
    }
}
