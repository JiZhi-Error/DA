package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qo extends IEvent {
    public a dXb;

    public static final class a {
        public long msgId;
    }

    public qo() {
        this((byte) 0);
    }

    private qo(byte b2) {
        AppMethodBeat.i(231467);
        this.dXb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(231467);
    }
}
