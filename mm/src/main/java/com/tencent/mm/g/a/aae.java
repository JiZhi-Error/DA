package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aae extends IEvent {
    public a egS;
    public b egT;

    public static final class a {
        public String egU;
    }

    public static final class b {
        public int status = -1;
    }

    public aae() {
        this((byte) 0);
    }

    private aae(byte b2) {
        AppMethodBeat.i(91231);
        this.egS = new a();
        this.egT = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91231);
    }
}
