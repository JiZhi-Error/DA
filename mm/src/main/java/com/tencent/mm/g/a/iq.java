package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iq extends IEvent {
    public a dNl;

    public static final class a {
        public int scene;
    }

    public iq() {
        this((byte) 0);
    }

    private iq(byte b2) {
        AppMethodBeat.i(125616);
        this.dNl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125616);
    }
}
