package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ku extends IEvent {
    public a dPP;

    public static final class a {
        public int dDe = 0;
        public String dPQ;
        public String dPR;
        public String dPS;
        public String dPT;
        public String dPU;
    }

    public ku() {
        this((byte) 0);
    }

    private ku(byte b2) {
        AppMethodBeat.i(149867);
        this.dPP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149867);
    }
}
