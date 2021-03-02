package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rd extends IEvent {
    public a dXT;

    public static final class a {
        public int state = 0;
    }

    public rd() {
        this((byte) 0);
    }

    private rd(byte b2) {
        AppMethodBeat.i(149882);
        this.dXT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149882);
    }
}
