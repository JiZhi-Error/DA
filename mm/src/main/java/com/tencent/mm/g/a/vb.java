package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vb extends IEvent {
    public a ebt;

    public static final class a {
        public boolean isStart;
    }

    public vb() {
        this((byte) 0);
    }

    private vb(byte b2) {
        AppMethodBeat.i(125632);
        this.ebt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125632);
    }
}
