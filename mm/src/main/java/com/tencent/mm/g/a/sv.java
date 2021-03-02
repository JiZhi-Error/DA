package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sv extends IEvent {
    public a dZo;

    public static final class a {
        public long msgId;
    }

    public sv() {
        this((byte) 0);
    }

    private sv(byte b2) {
        AppMethodBeat.i(187890);
        this.dZo = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(187890);
    }
}
