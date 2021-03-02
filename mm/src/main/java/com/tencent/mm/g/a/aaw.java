package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaw extends IEvent {
    public a ehM;

    public static final class a {
        public int result = 0;
    }

    public aaw() {
        this((byte) 0);
    }

    private aaw(byte b2) {
        AppMethodBeat.i(91237);
        this.ehM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91237);
    }
}
