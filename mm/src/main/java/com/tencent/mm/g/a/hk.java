package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hk extends IEvent {
    public a dLT;

    public static final class a {
        public long localId;
        public int progress;
    }

    public hk() {
        this((byte) 0);
    }

    private hk(byte b2) {
        AppMethodBeat.i(168879);
        this.dLT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168879);
    }
}
