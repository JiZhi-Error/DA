package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lv extends IEvent {
    public a dRl;

    public static final class a {
        public boolean dMz;
        public boolean dRm;
        public boolean dRn;
        public boolean isStart;
    }

    public lv() {
        this((byte) 0);
    }

    private lv(byte b2) {
        AppMethodBeat.i(223486);
        this.dRl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(223486);
    }
}
