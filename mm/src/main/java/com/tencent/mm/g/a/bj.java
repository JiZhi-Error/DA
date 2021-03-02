package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bj extends IEvent {
    public a dEB;

    public static final class a {
        public boolean dEC;
    }

    public bj() {
        this((byte) 0);
    }

    private bj(byte b2) {
        AppMethodBeat.i(114789);
        this.dEB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114789);
    }
}
