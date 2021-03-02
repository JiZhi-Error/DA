package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cw extends IEvent {
    public a dFY;

    public static final class a {
        public int packageType = -1;
    }

    public cw() {
        this((byte) 0);
    }

    private cw(byte b2) {
        AppMethodBeat.i(149860);
        this.dFY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149860);
    }
}
