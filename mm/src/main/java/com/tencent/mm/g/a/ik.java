package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ik extends IEvent {
    public a dNb;

    public static final class a {
        public String dNc;
        public int opType;
    }

    public ik() {
        this((byte) 0);
    }

    private ik(byte b2) {
        AppMethodBeat.i(208813);
        this.dNb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208813);
    }
}
