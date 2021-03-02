package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xz extends IEvent {
    public a eeo;

    public static final class a {
        public String userName;
    }

    public xz() {
        this((byte) 0);
    }

    private xz(byte b2) {
        AppMethodBeat.i(19842);
        this.eeo = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19842);
    }
}
