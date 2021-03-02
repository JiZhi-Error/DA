package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class so extends IEvent {
    public a dZf;

    public static final class a {
        public ca dCM;
    }

    public so() {
        this((byte) 0);
    }

    private so(byte b2) {
        AppMethodBeat.i(148368);
        this.dZf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(148368);
    }
}
