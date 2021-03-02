package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cu extends IEvent {
    public a dFU;
    public b dFV;

    public static final class a {
        public long dFW = 0;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public cu() {
        this((byte) 0);
    }

    private cu(byte b2) {
        AppMethodBeat.i(127401);
        this.dFU = new a();
        this.dFV = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127401);
    }
}
