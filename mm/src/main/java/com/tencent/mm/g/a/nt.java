package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nt extends IEvent {
    public a dTT;

    public static final class a {
        public String dOe;
        public String dTU;
        public int op = 0;
    }

    public nt() {
        this((byte) 0);
    }

    private nt(byte b2) {
        AppMethodBeat.i(181499);
        this.dTT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(181499);
    }
}
