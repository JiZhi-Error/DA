package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vc extends IEvent {
    public a ebu;

    public static final class a {
        public int ebv = 0;
    }

    public vc() {
        this((byte) 0);
    }

    private vc(byte b2) {
        AppMethodBeat.i(201820);
        this.ebu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201820);
    }
}
