package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ht extends IEvent {
    public a dMp;

    public static final class a {
        public int errCode;
        public String errMsg;
    }

    public ht() {
        this((byte) 0);
    }

    private ht(byte b2) {
        AppMethodBeat.i(168629);
        this.dMp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168629);
    }
}
