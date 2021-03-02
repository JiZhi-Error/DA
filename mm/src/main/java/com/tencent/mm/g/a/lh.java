package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lh extends IEvent {
    public a dQy;

    public static final class a {
        public int action;
    }

    public lh() {
        this((byte) 0);
    }

    private lh(byte b2) {
        AppMethodBeat.i(194249);
        this.dQy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194249);
    }
}
