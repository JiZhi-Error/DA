package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aah extends IEvent {
    public a ehe;

    public static final class a {
        public int result;
    }

    public aah() {
        this((byte) 0);
    }

    private aah(byte b2) {
        AppMethodBeat.i(91232);
        this.ehe = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91232);
    }
}
