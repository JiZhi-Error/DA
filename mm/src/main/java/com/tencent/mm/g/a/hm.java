package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hm extends IEvent {
    public a dLV;

    public static final class a {
        public long id;
        public int stickyTime;
        public int type;
    }

    public hm() {
        this((byte) 0);
    }

    private hm(byte b2) {
        AppMethodBeat.i(208802);
        this.dLV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208802);
    }
}
