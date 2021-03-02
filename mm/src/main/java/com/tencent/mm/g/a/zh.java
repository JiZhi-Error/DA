package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zh extends IEvent {
    public a efu;

    public static final class a {
        public boolean dya;
    }

    public zh() {
        this((byte) 0);
    }

    private zh(byte b2) {
        AppMethodBeat.i(140993);
        this.efu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140993);
    }
}
