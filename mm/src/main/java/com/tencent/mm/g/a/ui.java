package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ui extends IEvent {
    public a eaH;

    public static final class a {
        public String dNA;
        public long eaB;
        public Boolean eaz;
    }

    public ui() {
        this((byte) 0);
    }

    private ui(byte b2) {
        AppMethodBeat.i(194253);
        this.eaH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194253);
    }
}
