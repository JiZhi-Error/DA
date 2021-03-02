package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kj extends IEvent {
    public a dPt;

    public static final class a {
        public long dFm;
        public String dPu;
        public String dPv;
    }

    public kj() {
        this((byte) 0);
    }

    private kj(byte b2) {
        AppMethodBeat.i(93324);
        this.dPt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93324);
    }
}
