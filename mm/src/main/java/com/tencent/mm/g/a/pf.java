package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pf extends IEvent {
    public a dVk;

    public static final class a {
        public String dVl;
        public String dVm;
        public int dVn;
    }

    public pf() {
        this((byte) 0);
    }

    private pf(byte b2) {
        AppMethodBeat.i(206895);
        this.dVk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(206895);
    }
}
