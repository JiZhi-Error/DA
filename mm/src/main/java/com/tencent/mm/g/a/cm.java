package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cm extends IEvent {
    public a dFH;

    public static final class a {
        public int resultCode = 0;
    }

    public cm() {
        this((byte) 0);
    }

    private cm(byte b2) {
        AppMethodBeat.i(91202);
        this.dFH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91202);
    }
}
