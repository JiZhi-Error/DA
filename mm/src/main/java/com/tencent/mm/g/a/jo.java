package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jo extends IEvent {
    public a dOr;

    public static final class a {
        public boolean dOs = false;
    }

    public jo() {
        this((byte) 0);
    }

    private jo(byte b2) {
        AppMethodBeat.i(110506);
        this.dOr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(110506);
    }
}
