package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yc extends IEvent {
    public a eev;
    public b eew;

    public static final class a {
        public String id;
    }

    public static final class b {
        public boolean eex;
    }

    public yc() {
        this((byte) 0);
    }

    private yc(byte b2) {
        AppMethodBeat.i(116054);
        this.eev = new a();
        this.eew = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116054);
    }
}
