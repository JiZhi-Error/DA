package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uy extends IEvent {
    public a ebn;

    public static final class a {
        public int ebo = 0;
        public int ebp = 0;
        public int scrollX = 0;
        public int scrollY = 0;
    }

    public uy() {
        this((byte) 0);
    }

    private uy(byte b2) {
        AppMethodBeat.i(201819);
        this.ebn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201819);
    }
}
