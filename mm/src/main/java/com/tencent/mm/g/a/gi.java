package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gi extends IEvent {
    public a dKe;

    public static final class a {
        public int dKf;
        public String fileName;
        public int scene;
    }

    public gi() {
        this((byte) 0);
    }

    private gi(byte b2) {
        AppMethodBeat.i(116026);
        this.dKe = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116026);
    }
}
