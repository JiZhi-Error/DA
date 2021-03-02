package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nq extends IEvent {
    public a dTN;

    public static final class a {
        public int position;
    }

    public nq() {
        this((byte) 0);
    }

    private nq(byte b2) {
        AppMethodBeat.i(125622);
        this.dTN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125622);
    }
}
