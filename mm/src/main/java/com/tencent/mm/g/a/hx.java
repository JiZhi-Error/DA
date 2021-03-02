package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hx extends IEvent {
    public a dMy;

    public static final class a {
        public boolean dMz;
        public boolean isStart;
    }

    public hx() {
        this((byte) 0);
    }

    private hx(byte b2) {
        AppMethodBeat.i(223485);
        this.dMy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(223485);
    }
}
