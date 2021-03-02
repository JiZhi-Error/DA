package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ge extends IEvent {
    public a dJP;
    public b dJQ;

    public static final class a {
        public int action;
        public long bqc;
        public long dJR;
        public long dJS;
    }

    public static final class b {
        public String config;
        public boolean dJT = false;
        public int dJU;
    }

    public ge() {
        this((byte) 0);
    }

    private ge(byte b2) {
        AppMethodBeat.i(116808);
        this.dJP = new a();
        this.dJQ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116808);
    }
}
