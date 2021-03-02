package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class j extends IEvent {
    public a dCb;

    public static final class a {
        public int scene = 0;
    }

    public j() {
        this((byte) 0);
    }

    private j(byte b2) {
        AppMethodBeat.i(155363);
        this.dCb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155363);
    }
}
