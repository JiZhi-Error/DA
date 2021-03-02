package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xw extends IEvent {
    public a eeh;

    public static final class a {
        public long gY = 0;
    }

    public xw() {
        this((byte) 0);
    }

    private xw(byte b2) {
        AppMethodBeat.i(94819);
        this.eeh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94819);
    }
}
