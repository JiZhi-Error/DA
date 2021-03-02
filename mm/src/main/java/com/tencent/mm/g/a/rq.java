package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rq extends IEvent {
    public a dYj;

    public static final class a {
        public int state = -1;
    }

    public rq() {
        this((byte) 0);
    }

    private rq(byte b2) {
        AppMethodBeat.i(125625);
        this.dYj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125625);
    }
}
