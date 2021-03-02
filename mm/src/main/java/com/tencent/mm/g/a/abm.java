package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abm extends IEvent {
    public a opX;

    public static final class a {
    }

    public abm() {
        this((byte) 0);
    }

    private abm(byte b2) {
        AppMethodBeat.i(263662);
        this.opX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(263662);
    }
}
