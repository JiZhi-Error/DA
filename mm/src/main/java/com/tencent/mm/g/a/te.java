package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class te extends IEvent {
    public a dZD;
    public b dZE;

    public static final class a {
        public String userName;
    }

    public static final class b {
    }

    public te() {
        this((byte) 0);
    }

    private te(byte b2) {
        AppMethodBeat.i(19833);
        this.dZD = new a();
        this.dZE = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19833);
    }
}
