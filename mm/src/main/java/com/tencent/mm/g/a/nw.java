package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nw extends IEvent {
    public a dTY;

    public static final class a {
        public boolean isVisible;
    }

    public nw() {
        this((byte) 0);
    }

    private nw(byte b2) {
        AppMethodBeat.i(200243);
        this.dTY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(200243);
    }
}
