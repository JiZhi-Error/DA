package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tx extends IEvent {
    public a ear;

    public static final class a {
        public ca dCM;
    }

    public tx() {
        this((byte) 0);
    }

    private tx(byte b2) {
        AppMethodBeat.i(42657);
        this.ear = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42657);
    }
}
