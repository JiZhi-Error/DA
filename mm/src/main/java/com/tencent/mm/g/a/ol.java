package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ol extends IEvent {
    public a dUx;

    public static final class a {
        public int action = 0;
        public long dUy;
        public String username;
    }

    public ol() {
        this((byte) 0);
    }

    private ol(byte b2) {
        AppMethodBeat.i(131793);
        this.dUx = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131793);
    }
}
