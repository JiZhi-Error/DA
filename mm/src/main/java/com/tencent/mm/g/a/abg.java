package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abg extends IEvent {
    public a eiA;

    public static final class a {
        public boolean success = false;
    }

    public abg() {
        this((byte) 0);
    }

    private abg(byte b2) {
        AppMethodBeat.i(149896);
        this.eiA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149896);
    }
}
