package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bh extends IEvent {
    public a dEw;

    public static final class a {
        public boolean result = false;
    }

    public bh() {
        this((byte) 0);
    }

    private bh(byte b2) {
        AppMethodBeat.i(155365);
        this.dEw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155365);
    }
}
