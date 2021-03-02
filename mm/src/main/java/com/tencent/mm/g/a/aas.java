package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aas extends IEvent {
    public a ehH;

    public static final class a {
        public int result;
    }

    public aas() {
        this((byte) 0);
    }

    private aas(byte b2) {
        AppMethodBeat.i(117616);
        this.ehH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117616);
    }
}
