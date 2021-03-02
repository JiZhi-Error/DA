package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aad extends IEvent {
    public a egQ;
    public b egR;

    public static final class a {
    }

    public static final class b {
    }

    public aad() {
        this((byte) 0);
    }

    private aad(byte b2) {
        AppMethodBeat.i(91230);
        this.egQ = new a();
        this.egR = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91230);
    }
}
