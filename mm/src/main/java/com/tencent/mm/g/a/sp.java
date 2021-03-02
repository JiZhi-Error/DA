package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class sp extends IEvent {
    public a dZg;

    public static final class a {
        public ca dCM;
    }

    public sp() {
        this((byte) 0);
    }

    private sp(byte b2) {
        AppMethodBeat.i(19829);
        this.dZg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19829);
    }
}
