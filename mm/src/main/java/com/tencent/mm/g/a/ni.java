package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ni extends IEvent {
    public a dTt;

    public static final class a {
        public IEvent dTu;
        public int errCode = 0;
        public String errMsg;
        public int errType = 0;
    }

    public ni() {
        this((byte) 0);
    }

    private ni(byte b2) {
        AppMethodBeat.i(149875);
        this.dTt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149875);
    }
}
