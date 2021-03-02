package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mc extends IEvent {
    public a dRB;

    public static final class a {
        public int opType;
    }

    public mc() {
        this((byte) 0);
    }

    private mc(byte b2) {
        AppMethodBeat.i(19817);
        this.dRB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19817);
    }
}
