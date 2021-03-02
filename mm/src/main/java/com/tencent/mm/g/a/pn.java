package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pn extends IEvent {
    public a dVF;

    public static final class a {
        public int action = 0;
    }

    public pn() {
        this((byte) 0);
    }

    private pn(byte b2) {
        AppMethodBeat.i(91037);
        this.dVF = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91037);
    }
}
