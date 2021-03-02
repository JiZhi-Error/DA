package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ct extends IEvent {
    public a dFT;

    public static final class a {
        public long localId = -1;
    }

    public ct() {
        this((byte) 0);
    }

    private ct(byte b2) {
        AppMethodBeat.i(127400);
        this.dFT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127400);
    }
}
