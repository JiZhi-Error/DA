package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mu extends IEvent {
    public a dSs;
    public b dSt;

    public static final class a {
        public int action;
    }

    public static final class b {
        public boolean isStart;
    }

    public mu() {
        this((byte) 0);
    }

    private mu(byte b2) {
        AppMethodBeat.i(149873);
        this.dSs = new a();
        this.dSt = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149873);
    }
}
