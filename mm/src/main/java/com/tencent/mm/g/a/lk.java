package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lk extends IEvent {
    public a dQI;

    public static final class a {
        public int dIZ;
        public String dNI;
        public String returnKey;
    }

    public lk() {
        this((byte) 0);
    }

    private lk(byte b2) {
        AppMethodBeat.i(128845);
        this.dQI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(128845);
    }
}
