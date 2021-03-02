package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class br extends IEvent {
    public a dEV;

    public static final class a {
        public int dDe = -1;
        public int dEO;
        public boolean dEU;
        public int subType;
    }

    public br() {
        this((byte) 0);
    }

    private br(byte b2) {
        AppMethodBeat.i(149857);
        this.dEV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149857);
    }
}
