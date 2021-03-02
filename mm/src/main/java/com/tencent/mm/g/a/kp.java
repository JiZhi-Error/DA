package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kp extends IEvent {
    public a dPH;

    public static final class a {
        public String dPI;
        public String dPJ;
    }

    public kp() {
        this((byte) 0);
    }

    private kp(byte b2) {
        AppMethodBeat.i(121032);
        this.dPH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121032);
    }
}
