package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class er extends IEvent {
    public a dHZ;

    public static final class a {
        public boolean brW;
        public String dGL;
        public byte[] dHR;
    }

    public er() {
        this((byte) 0);
    }

    private er(byte b2) {
        AppMethodBeat.i(116001);
        this.dHZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116001);
    }
}
