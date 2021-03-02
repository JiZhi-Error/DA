package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mt extends IEvent {
    public a dSq;

    public static final class a {
        public int dSr;
        public String id;
        public int type;
    }

    public mt() {
        this((byte) 0);
    }

    private mt(byte b2) {
        AppMethodBeat.i(200242);
        this.dSq = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(200242);
    }
}
