package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zs extends IEvent {
    public a efL;

    public static final class a {
        public String uri;
    }

    public zs() {
        this((byte) 0);
    }

    private zs(byte b2) {
        AppMethodBeat.i(116057);
        this.efL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116057);
    }
}
