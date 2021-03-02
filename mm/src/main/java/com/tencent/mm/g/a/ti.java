package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ti extends IEvent {
    public a dZN;

    public static final class a {
        public boolean dZO;
    }

    public ti() {
        this((byte) 0);
    }

    private ti(byte b2) {
        AppMethodBeat.i(91038);
        this.dZN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91038);
    }
}
