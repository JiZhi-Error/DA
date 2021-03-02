package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.sdk.event.IEvent;

public final class hs extends IEvent {
    public a dMm;

    public static final class a {
        public long commentId = 0;
        public long dMn = 0;
        public cd dMo;
        public long feedId;
        public int opType = 0;
    }

    public hs() {
        this((byte) 0);
    }

    private hs(byte b2) {
        AppMethodBeat.i(168881);
        this.dMm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168881);
    }
}
