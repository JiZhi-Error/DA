package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class on extends IEvent {
    public a dUC;

    public static final class a {
        public int errCode = 0;
        public String errMsg;
    }

    public on() {
        this((byte) 0);
    }

    private on(byte b2) {
        AppMethodBeat.i(130780);
        this.dUC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130780);
    }
}
