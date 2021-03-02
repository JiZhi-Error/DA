package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pm extends IEvent {
    public a dVE;

    public static final class a {
        public int dDe;
    }

    public pm() {
        this((byte) 0);
    }

    private pm(byte b2) {
        AppMethodBeat.i(148770);
        this.dVE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(148770);
    }
}
