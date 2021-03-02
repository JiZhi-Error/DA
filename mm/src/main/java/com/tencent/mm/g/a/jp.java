package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jp extends IEvent {
    public a dOt;

    public static final class a {
        public String dOu;
        public String dOv;
    }

    public jp() {
        this((byte) 0);
    }

    private jp(byte b2) {
        AppMethodBeat.i(117547);
        this.dOt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117547);
    }
}
