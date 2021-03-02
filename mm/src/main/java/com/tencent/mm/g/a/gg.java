package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gg extends IEvent {
    public a dKa;
    public b dKb;

    public static final class a {
        public String fileName;
    }

    public static final class b {
        public long msgId = 0;
    }

    public gg() {
        this((byte) 0);
    }

    private gg(byte b2) {
        AppMethodBeat.i(116024);
        this.dKa = new a();
        this.dKb = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116024);
    }
}
