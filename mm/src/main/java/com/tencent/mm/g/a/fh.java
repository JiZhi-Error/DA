package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fh extends IEvent {
    public a dIE;
    public b dIF;

    public static final class a {
        public boolean dGW = false;
    }

    public static final class b {
        public boolean dGX;
    }

    public fh() {
        this((byte) 0);
    }

    private fh(byte b2) {
        AppMethodBeat.i(19800);
        this.dIE = new a();
        this.dIF = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19800);
    }
}
