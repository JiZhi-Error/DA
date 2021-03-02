package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hj extends IEvent {
    public a dLP;

    public static final class a {
        public boolean dLD;
        public boolean dLQ;
        public boolean dLR;
        public int dLS;
        public long feedId;
    }

    public hj() {
        this((byte) 0);
    }

    private hj(byte b2) {
        AppMethodBeat.i(241572);
        this.dLP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241572);
    }
}
