package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gv extends IEvent {
    public a dKQ;

    public static final class a {
        public String url;
    }

    public gv() {
        this((byte) 0);
    }

    private gv(byte b2) {
        AppMethodBeat.i(133846);
        this.dKQ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(133846);
    }
}
