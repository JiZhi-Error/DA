package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wt extends IEvent {
    public a edh;

    public static final class a {
        public String edi;
    }

    public wt() {
        this((byte) 0);
    }

    private wt(byte b2) {
        AppMethodBeat.i(194254);
        this.edh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194254);
    }
}
