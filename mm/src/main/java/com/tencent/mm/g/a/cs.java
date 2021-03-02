package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cs extends IEvent {
    public a dFQ;
    public b dFR;

    public static final class a {
        public String path;
    }

    public static final class b {
        public String[] dFS;
        public boolean isTimeout = false;
    }

    public cs() {
        this((byte) 0);
    }

    private cs(byte b2) {
        AppMethodBeat.i(192285);
        this.dFQ = new a();
        this.dFR = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(192285);
    }
}
