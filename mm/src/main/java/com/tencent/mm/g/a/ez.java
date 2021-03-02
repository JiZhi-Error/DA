package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ez extends IEvent {
    public a dIp;
    public b dIq;

    public static final class a {
        public String dGL;
        public String dIr;
        public int progress;
    }

    public static final class b {
    }

    public ez() {
        this((byte) 0);
    }

    private ez(byte b2) {
        AppMethodBeat.i(116009);
        this.dIp = new a();
        this.dIq = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116009);
    }
}
