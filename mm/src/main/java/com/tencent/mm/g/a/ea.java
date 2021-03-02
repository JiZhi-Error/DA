package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ea extends IEvent {
    public a dHf;
    public b dHg;

    public static final class a {
        public boolean dGW = false;
    }

    public static final class b {
        public boolean dGX;
        public String dHh;
    }

    public ea() {
        this((byte) 0);
    }

    private ea(byte b2) {
        AppMethodBeat.i(115984);
        this.dHf = new a();
        this.dHg = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115984);
    }
}
