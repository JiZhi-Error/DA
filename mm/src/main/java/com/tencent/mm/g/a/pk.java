package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pk extends IEvent {
    public a dVx;
    public b dVy;

    public static final class a {
        public boolean dVA = false;
        public boolean dVz = false;
        public int type;
    }

    public static final class b {
        public boolean dVB = false;
    }

    public pk() {
        this((byte) 0);
    }

    private pk(byte b2) {
        AppMethodBeat.i(130031);
        this.dVx = new a();
        this.dVy = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130031);
    }
}
