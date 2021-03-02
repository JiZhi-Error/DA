package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wf extends IEvent {
    public a ecp;

    public static final class a {
        public int sourceType = 0;
    }

    public wf() {
        this((byte) 0);
    }

    private wf(byte b2) {
        AppMethodBeat.i(131794);
        this.ecp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131794);
    }
}
