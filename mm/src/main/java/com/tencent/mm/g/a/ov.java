package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ov extends IEvent {
    public a dUP;

    public static final class a {
        public int retCode;
    }

    public ov() {
        this((byte) 0);
    }

    private ov(byte b2) {
        AppMethodBeat.i(130928);
        this.dUP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130928);
    }
}
