package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mz extends IEvent {
    public a dSI;

    public static final class a {
        public String businessType;
        public String dSJ;
        public int errCode;
    }

    public mz() {
        this((byte) 0);
    }

    private mz(byte b2) {
        AppMethodBeat.i(149874);
        this.dSI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149874);
    }
}
