package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tp extends IEvent {
    public a dZZ;

    public static final class a {
        public boolean dDz;
        public int dEb;
        public String eaa;
        public String eab;
        public String eac;
        public int source = 0;
    }

    public tp() {
        this((byte) 0);
    }

    private tp(byte b2) {
        AppMethodBeat.i(120832);
        this.dZZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(120832);
    }
}
