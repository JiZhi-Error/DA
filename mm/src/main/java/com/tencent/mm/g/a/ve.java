package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ve extends IEvent {
    public a ebB;

    public static final class a {
        public int ebC = 0;
    }

    public ve() {
        this((byte) 0);
    }

    private ve(byte b2) {
        AppMethodBeat.i(201822);
        this.ebB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201822);
    }
}
