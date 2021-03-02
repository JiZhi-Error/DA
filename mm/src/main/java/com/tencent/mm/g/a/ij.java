package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ij extends IEvent {
    public a dMY;

    public static final class a {
        public boolean dMZ = false;
        public long dNa = 0;
    }

    public ij() {
        this((byte) 0);
    }

    private ij(byte b2) {
        AppMethodBeat.i(125615);
        this.dMY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125615);
    }
}
