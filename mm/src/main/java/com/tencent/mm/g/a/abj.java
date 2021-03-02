package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abj extends IEvent {
    public a opV;

    public static final class a {
        public int action;
        public long commentId;
    }

    public abj() {
        this((byte) 0);
    }

    private abj(byte b2) {
        AppMethodBeat.i(258813);
        this.opV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(258813);
    }
}
