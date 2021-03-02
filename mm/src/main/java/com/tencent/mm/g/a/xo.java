package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xo extends IEvent {
    public a edO;

    public static final class a {
        public String viewId;
    }

    public xo() {
        this((byte) 0);
    }

    private xo(byte b2) {
        AppMethodBeat.i(162263);
        this.edO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(162263);
    }
}
