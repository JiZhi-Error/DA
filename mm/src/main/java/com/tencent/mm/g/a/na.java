package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class na extends IEvent {
    public a dSK;

    public static final class a {
        public String businessType;
        public String dSJ;
        public int errCode;
    }

    public na() {
        this((byte) 0);
    }

    private na(byte b2) {
        AppMethodBeat.i(43442);
        this.dSK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(43442);
    }
}
