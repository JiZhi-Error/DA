package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ii extends IEvent {
    public a dMV;

    public static final class a {
        public String dMW;
        public int dMX;
    }

    public ii() {
        this((byte) 0);
    }

    private ii(byte b2) {
        AppMethodBeat.i(208812);
        this.dMV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208812);
    }
}
