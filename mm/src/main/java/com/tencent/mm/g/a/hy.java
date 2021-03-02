package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hy extends IEvent {
    public a dMA;

    public static final class a {
        public double lat;
        public double lng;
    }

    public hy() {
        this((byte) 0);
    }

    private hy(byte b2) {
        AppMethodBeat.i(208804);
        this.dMA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208804);
    }
}
