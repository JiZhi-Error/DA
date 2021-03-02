package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaq extends IEvent {
    public a ehD;

    public static final class a {
        public int dDe;
    }

    public aaq() {
        this((byte) 0);
    }

    private aaq(byte b2) {
        AppMethodBeat.i(114793);
        this.ehD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114793);
    }
}
