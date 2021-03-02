package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.as;

public final class mq extends IEvent {
    public a dSg;

    public static final class a {
        public as dSh;
    }

    public mq() {
        this((byte) 0);
    }

    private mq(byte b2) {
        AppMethodBeat.i(42653);
        this.dSg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42653);
    }
}
