package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class o extends IEvent {
    public a dCr;

    public static final class a {
        public String appId;
        public boolean dCs;
    }

    public o() {
        this((byte) 0);
    }

    private o(byte b2) {
        AppMethodBeat.i(201283);
        this.dCr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201283);
    }
}
