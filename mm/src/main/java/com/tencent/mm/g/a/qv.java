package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qv extends IEvent {
    public a dXn;

    public static final class a {
    }

    public qv() {
        this((byte) 0);
    }

    private qv(byte b2) {
        AppMethodBeat.i(19825);
        this.dXn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19825);
    }
}
