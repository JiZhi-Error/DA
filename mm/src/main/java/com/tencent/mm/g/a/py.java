package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class py extends IEvent {
    public a dWd;

    public static final class a {
        public String dWe;
        public int dWf;
    }

    public py() {
        this((byte) 0);
    }

    private py(byte b2) {
        AppMethodBeat.i(128847);
        this.dWd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(128847);
    }
}
