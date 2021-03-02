package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kr extends IEvent {
    public a dPL;

    public static final class a {
        public String dPI;
        public String dPM;
    }

    public kr() {
        this((byte) 0);
    }

    private kr(byte b2) {
        AppMethodBeat.i(121034);
        this.dPL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121034);
    }
}
