package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rn extends IEvent {
    public a dYd;

    public static final class a {
        public boolean dGX = false;
        public int dYe = 0;
    }

    public rn() {
        this((byte) 0);
    }

    private rn(byte b2) {
        AppMethodBeat.i(63291);
        this.dYd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(63291);
    }
}
