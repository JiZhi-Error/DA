package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xf extends IEvent {
    public a edz;

    public static final class a {
        public String productId;
    }

    public xf() {
        this((byte) 0);
    }

    private xf(byte b2) {
        AppMethodBeat.i(104421);
        this.edz = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104421);
    }
}
