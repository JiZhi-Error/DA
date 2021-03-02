package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bk extends IEvent {
    public a dED;
    public b dEE;

    public static final class a {
    }

    public static final class b {
        public boolean dEF;
        public String msg;
    }

    public bk() {
        this((byte) 0);
    }

    private bk(byte b2) {
        AppMethodBeat.i(117354);
        this.dED = new a();
        this.dEE = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117354);
    }
}
