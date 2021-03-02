package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class ua extends IEvent {
    public a eau;

    public static final class a {
        public ca dCM;
    }

    public ua() {
        this((byte) 0);
    }

    private ua(byte b2) {
        AppMethodBeat.i(42659);
        this.eau = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42659);
    }
}
