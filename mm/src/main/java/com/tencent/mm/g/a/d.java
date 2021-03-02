package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class d extends IEvent {
    public a dBP;

    public static final class a {
        public boolean dBQ;
    }

    public d() {
        this((byte) 0);
    }

    private d(byte b2) {
        AppMethodBeat.i(140983);
        this.dBP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140983);
    }
}
