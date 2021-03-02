package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zy extends IEvent {
    public a egE;

    public static final class a {
        public String egF;
    }

    public zy() {
        this((byte) 0);
    }

    private zy(byte b2) {
        AppMethodBeat.i(91225);
        this.egE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91225);
    }
}
