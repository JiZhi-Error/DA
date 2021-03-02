package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uf extends IEvent {
    public a eaC;

    public static final class a {
        public String dNA;
        public long eaB;
        public Boolean eaz;
    }

    public uf() {
        this((byte) 0);
    }

    private uf(byte b2) {
        AppMethodBeat.i(194252);
        this.eaC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194252);
    }
}
