package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ce extends IEvent {
    public a dFo;
    public b dFp;

    public static final class a {
        public int dFq = 0;
    }

    public static final class b {
        public int retCode = 0;
    }

    public ce() {
        this((byte) 0);
    }

    private ce(byte b2) {
        AppMethodBeat.i(140934);
        this.dFo = new a();
        this.dFp = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140934);
    }
}
