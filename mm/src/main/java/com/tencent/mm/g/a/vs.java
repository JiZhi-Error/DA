package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vs extends IEvent {
    public a ebS;

    public static final class a {
        public boolean ebT;
    }

    public vs() {
        this((byte) 0);
    }

    private vs(byte b2) {
        AppMethodBeat.i(125641);
        this.ebS = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125641);
    }
}
