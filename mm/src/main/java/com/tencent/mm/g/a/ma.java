package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ma extends IEvent {
    public a dRA;

    public static final class a {
        public int bDZ = 0;
        public int status = 0;
    }

    public ma() {
        this((byte) 0);
    }

    private ma(byte b2) {
        AppMethodBeat.i(116031);
        this.dRA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116031);
    }
}
