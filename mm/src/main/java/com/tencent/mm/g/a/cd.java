package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cd extends IEvent {
    public a dFn;

    public static final class a {
        public String dFk;
        public String dFl;
        public long dFm;
    }

    public cd() {
        this((byte) 0);
    }

    private cd(byte b2) {
        AppMethodBeat.i(91200);
        this.dFn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91200);
    }
}
