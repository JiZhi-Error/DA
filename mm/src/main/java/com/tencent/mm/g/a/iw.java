package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iw extends IEvent {
    public a dNy;
    public b dNz;

    public static final class a {
        public int EX = 0;
        public String param;
    }

    public static final class b {
        public String dNA;
    }

    public iw() {
        this((byte) 0);
    }

    private iw(byte b2) {
        AppMethodBeat.i(89643);
        this.dNy = new a();
        this.dNz = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89643);
    }
}
