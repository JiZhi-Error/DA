package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xr extends IEvent {
    public a edW;

    public static final class a {
        public boolean edX = false;
        public boolean edY = false;
    }

    public xr() {
        this((byte) 0);
    }

    private xr(byte b2) {
        AppMethodBeat.i(149892);
        this.edW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149892);
    }
}
