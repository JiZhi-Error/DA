package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fm extends IEvent {
    public a dIM;

    public static final class a {
        public String brandName;
    }

    public fm() {
        this((byte) 0);
    }

    private fm(byte b2) {
        AppMethodBeat.i(116014);
        this.dIM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116014);
    }
}
