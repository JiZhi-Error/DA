package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class i extends IEvent {
    public a dBY;

    public static final class a {
        public boolean dBZ = false;
        public long dCa;
        public int scene;
    }

    public i() {
        this((byte) 0);
    }

    private i(byte b2) {
        AppMethodBeat.i(149846);
        this.dBY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149846);
    }
}
