package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wy extends IEvent {
    public a edp;

    public static final class a {
        public int dJY;
        public String edq;
        public long edr;
        public String eds;
    }

    public wy() {
        this((byte) 0);
    }

    private wy(byte b2) {
        AppMethodBeat.i(116050);
        this.edp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116050);
    }
}
