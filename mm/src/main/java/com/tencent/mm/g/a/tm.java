package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tm extends IEvent {
    public a dZV;

    public static final class a {
        public String dZW;
        public int type;
    }

    public tm() {
        this((byte) 0);
    }

    private tm(byte b2) {
        AppMethodBeat.i(149888);
        this.dZV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149888);
    }
}
