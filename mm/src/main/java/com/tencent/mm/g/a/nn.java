package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nn extends IEvent {
    public a dTH;

    public static final class a {
        public int type;
    }

    public nn() {
        this((byte) 0);
    }

    private nn(byte b2) {
        AppMethodBeat.i(116035);
        this.dTH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116035);
    }
}
