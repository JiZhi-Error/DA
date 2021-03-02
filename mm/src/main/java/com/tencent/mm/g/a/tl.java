package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tl extends IEvent {
    public a dZU;

    public static final class a {
        public int cSx = 0;
    }

    public tl() {
        this((byte) 0);
    }

    private tl(byte b2) {
        AppMethodBeat.i(91040);
        this.dZU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91040);
    }
}
