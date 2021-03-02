package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class js extends IEvent {
    public a dOC;

    public static final class a {
        public String dOD;
        public int state;
    }

    public js() {
        this((byte) 0);
    }

    private js(byte b2) {
        AppMethodBeat.i(94811);
        this.dOC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94811);
    }
}
