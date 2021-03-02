package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class qs extends IEvent {
    public a dXi;

    public static final class a {
        public ca dCM;
    }

    public qs() {
        this((byte) 0);
    }

    private qs(byte b2) {
        AppMethodBeat.i(42656);
        this.dXi = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42656);
    }
}
