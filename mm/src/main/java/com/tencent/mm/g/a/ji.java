package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ji extends IEvent {
    public a dOb;

    public static final class a {
        public boolean dOc = false;
    }

    public ji() {
        this((byte) 0);
    }

    private ji(byte b2) {
        AppMethodBeat.i(93323);
        this.dOb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93323);
    }
}
