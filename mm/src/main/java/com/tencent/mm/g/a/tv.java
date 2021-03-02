package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tv extends IEvent {
    public a eap;

    public static final class a {
        public ca dCM;
    }

    public tv() {
        this((byte) 0);
    }

    private tv(byte b2) {
        AppMethodBeat.i(149889);
        this.eap = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149889);
    }
}
