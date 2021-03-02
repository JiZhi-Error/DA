package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hu extends IEvent {
    public a dMq;

    public static final class a {
        public int dJY;
        public long localId;
    }

    public hu() {
        this((byte) 0);
    }

    private hu(byte b2) {
        AppMethodBeat.i(208803);
        this.dMq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208803);
    }
}
