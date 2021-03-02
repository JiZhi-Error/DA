package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bc extends IEvent {
    public a dEl;

    public static final class a {
        public String username;
    }

    public bc() {
        this((byte) 0);
    }

    private bc(byte b2) {
        AppMethodBeat.i(116457);
        this.dEl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116457);
    }
}
