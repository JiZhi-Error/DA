package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sx extends IEvent {
    public a dZt;

    public static final class a {
        public long msgId = 0;
    }

    public sx() {
        this((byte) 0);
    }

    private sx(byte b2) {
        AppMethodBeat.i(94800);
        this.dZt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94800);
    }
}
