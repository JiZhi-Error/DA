package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kq extends IEvent {
    public a dPK;

    public static final class a {
        public String dPI;
        public String sessionId;
    }

    public kq() {
        this((byte) 0);
    }

    private kq(byte b2) {
        AppMethodBeat.i(121033);
        this.dPK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121033);
    }
}
