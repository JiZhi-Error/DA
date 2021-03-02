package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hh extends IEvent {
    public a dLL;

    public static final class a {
        public int dLM;
        public String dLN;
    }

    public hh() {
        this((byte) 0);
    }

    private hh(byte b2) {
        AppMethodBeat.i(208800);
        this.dLL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208800);
    }
}
