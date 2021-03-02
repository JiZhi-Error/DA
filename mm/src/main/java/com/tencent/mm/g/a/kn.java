package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kn extends IEvent {
    public a dPD;

    public static final class a {
        public String dPE;
        public String dPF;
    }

    public kn() {
        this((byte) 0);
    }

    private kn(byte b2) {
        AppMethodBeat.i(149866);
        this.dPD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149866);
    }
}
