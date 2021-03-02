package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class db extends IEvent {
    public a dGl;

    public static final class a {
        public int action;
    }

    public db() {
        this((byte) 0);
    }

    private db(byte b2) {
        AppMethodBeat.i(225907);
        this.dGl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(225907);
    }
}
