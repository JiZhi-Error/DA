package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gs extends IEvent {
    public a dKL;
    public b dKM;

    public static final class a {
        public int state = -1;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public gs() {
        this((byte) 0);
    }

    private gs(byte b2) {
        AppMethodBeat.i(116028);
        this.dKL = new a();
        this.dKM = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116028);
    }
}
