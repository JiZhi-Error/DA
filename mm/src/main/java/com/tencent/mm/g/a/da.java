package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class da extends IEvent {
    public a dGj;

    public static final class a {
        public int dGk = 0;
    }

    public da() {
        this((byte) 0);
    }

    private da(byte b2) {
        AppMethodBeat.i(91203);
        this.dGj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91203);
    }
}
