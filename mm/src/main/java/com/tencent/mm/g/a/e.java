package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class e extends IEvent {
    public a dBR;

    public static final class a {
        public boolean active;
        public String className;
    }

    public e() {
        this((byte) 0);
    }

    private e(byte b2) {
        AppMethodBeat.i(140984);
        this.dBR = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140984);
    }
}
