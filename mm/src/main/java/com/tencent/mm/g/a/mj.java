package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mj extends IEvent {
    public a dRJ;

    public static final class a {
        public boolean dgZ;
        public long progress;
        public long total;
    }

    public mj() {
        this((byte) 0);
    }

    private mj(byte b2) {
        AppMethodBeat.i(19819);
        this.dRJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19819);
    }
}
