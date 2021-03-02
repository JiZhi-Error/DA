package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mi extends IEvent {
    public a dRI;

    public static final class a {
        public boolean result;
    }

    public mi() {
        this((byte) 0);
    }

    private mi(byte b2) {
        AppMethodBeat.i(131791);
        this.dRI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131791);
    }
}
