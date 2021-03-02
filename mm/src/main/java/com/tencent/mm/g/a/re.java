package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class re extends IEvent {
    public a dXU;

    public static final class a {
        public int type = 0;
        public String username;
    }

    public re() {
        this((byte) 0);
    }

    private re(byte b2) {
        AppMethodBeat.i(184120);
        this.dXU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(184120);
    }
}
