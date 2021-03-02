package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nk extends IEvent {
    public a dTy;

    public static final class a {
        public boolean dTA = false;
        public String dTB;
        public int dTz = 0;
        public int status = 0;
    }

    public nk() {
        this((byte) 0);
    }

    private nk(byte b2) {
        AppMethodBeat.i(131792);
        this.dTy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131792);
    }
}
