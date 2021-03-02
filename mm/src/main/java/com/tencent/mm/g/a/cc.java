package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cc extends IEvent {
    public a dFj;

    public static final class a {
        public String dFk;
        public String dFl;
        public long dFm;
    }

    public cc() {
        this((byte) 0);
    }

    private cc(byte b2) {
        AppMethodBeat.i(91199);
        this.dFj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91199);
    }
}
