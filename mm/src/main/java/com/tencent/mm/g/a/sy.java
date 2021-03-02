package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sy extends IEvent {
    public a dZu;

    public static final class a {
        public long msgId;
    }

    public sy() {
        this((byte) 0);
    }

    private sy(byte b2) {
        AppMethodBeat.i(102633);
        this.dZu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(102633);
    }
}
