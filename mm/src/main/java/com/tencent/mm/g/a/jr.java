package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jr extends IEvent {
    public a dOB;

    public static final class a {
        public int dNv;
    }

    public jr() {
        this((byte) 0);
    }

    private jr(byte b2) {
        AppMethodBeat.i(123478);
        this.dOB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(123478);
    }
}
