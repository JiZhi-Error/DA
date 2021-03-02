package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bb extends IEvent {
    public a dEk;

    public static final class a {
        public int index;
    }

    public bb() {
        this((byte) 0);
    }

    private bb(byte b2) {
        AppMethodBeat.i(115971);
        this.dEk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115971);
    }
}
