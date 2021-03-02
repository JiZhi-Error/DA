package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pd extends IEvent {
    public a dVh;

    public static final class a {
        public int count;
        public String dVi;
        public String dVj;
        public int ret;
    }

    public pd() {
        this((byte) 0);
    }

    private pd(byte b2) {
        AppMethodBeat.i(42655);
        this.dVh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42655);
    }
}
