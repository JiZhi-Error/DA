package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gh extends IEvent {
    public a dKc;
    public b dKd;

    public static final class a {
        public long msgId;
    }

    public static final class b {
        public String fileName;
    }

    public gh() {
        this((byte) 0);
    }

    private gh(byte b2) {
        AppMethodBeat.i(116025);
        this.dKc = new a();
        this.dKd = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116025);
    }
}
