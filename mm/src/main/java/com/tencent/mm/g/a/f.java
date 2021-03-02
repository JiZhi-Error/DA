package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class f extends IEvent {
    public a dBS;

    public static final class a {
        public long dBT;
        public long id;
        public long localId;
    }

    public f() {
        this((byte) 0);
    }

    private f(byte b2) {
        AppMethodBeat.i(208799);
        this.dBS = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208799);
    }
}
