package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fq extends IEvent {
    public a dIO;

    public static final class a {
        public int op;
    }

    public fq() {
        this((byte) 0);
    }

    private fq(byte b2) {
        AppMethodBeat.i(116015);
        this.dIO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116015);
    }
}
