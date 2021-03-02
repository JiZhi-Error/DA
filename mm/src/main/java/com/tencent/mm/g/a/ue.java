package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ue extends IEvent {
    public a eaA;

    public static final class a {
        public String dNA;
        public long eaB;
        public Boolean eaz;
    }

    public ue() {
        this((byte) 0);
    }

    private ue(byte b2) {
        AppMethodBeat.i(194251);
        this.eaA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194251);
    }
}
