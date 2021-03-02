package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fd extends IEvent {
    public b dIA;
    public a dIz;

    public static final class a {
        public boolean dGW = false;
        public String mac;
    }

    public static final class b {
        public boolean dGX;
    }

    public fd() {
        this((byte) 0);
    }

    private fd(byte b2) {
        AppMethodBeat.i(19796);
        this.dIz = new a();
        this.dIA = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19796);
    }
}
