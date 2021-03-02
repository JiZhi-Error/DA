package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hq extends IEvent {
    public a dMi;

    public static final class a {
        public String dMj;
        public int retCode;
    }

    public hq() {
        this((byte) 0);
    }

    private hq(byte b2) {
        AppMethodBeat.i(241574);
        this.dMi = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241574);
    }
}
