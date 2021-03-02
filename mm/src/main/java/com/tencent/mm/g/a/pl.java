package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pl extends IEvent {
    public a dVC;
    public b dVD;

    public static final class a {
        public int type;
    }

    public static final class b {
        public boolean dVB = false;
    }

    public pl() {
        this((byte) 0);
    }

    private pl(byte b2) {
        AppMethodBeat.i(130032);
        this.dVC = new a();
        this.dVD = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130032);
    }
}
