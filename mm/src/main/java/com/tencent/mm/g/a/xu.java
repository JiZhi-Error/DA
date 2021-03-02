package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xu extends IEvent {
    public a eee;

    public static final class a {
        public int dLS;
        public int eef;
    }

    public xu() {
        this((byte) 0);
    }

    private xu(byte b2) {
        AppMethodBeat.i(241576);
        this.eee = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241576);
    }
}
