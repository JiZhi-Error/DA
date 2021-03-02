package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class up extends IEvent {
    public a eaS;

    public static final class a {
        public long dFm;
        public String dPu;
        public String dPv;
    }

    public up() {
        this((byte) 0);
    }

    private up(byte b2) {
        AppMethodBeat.i(93328);
        this.eaS = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93328);
    }
}
