package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bd extends IEvent {
    public a dEm;

    public static final class a {
        public String dEn;
        public String username;
    }

    public bd() {
        this((byte) 0);
    }

    private bd(byte b2) {
        AppMethodBeat.i(116458);
        this.dEm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116458);
    }
}
