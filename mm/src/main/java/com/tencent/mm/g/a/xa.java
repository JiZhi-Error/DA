package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xa extends IEvent {
    public a edt;

    public static final class a {
        public boolean edu = true;
    }

    public xa() {
        this((byte) 0);
    }

    private xa(byte b2) {
        AppMethodBeat.i(19839);
        this.edt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19839);
    }
}
