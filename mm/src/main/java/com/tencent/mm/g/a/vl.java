package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vl extends IEvent {
    public a ebH;

    public static final class a {
        public long dNa = 0;
        public boolean ebI = false;
    }

    public vl() {
        this((byte) 0);
    }

    private vl(byte b2) {
        AppMethodBeat.i(125635);
        this.ebH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125635);
    }
}
