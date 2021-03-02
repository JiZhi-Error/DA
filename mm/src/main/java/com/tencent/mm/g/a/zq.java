package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zq extends IEvent {
    public a efK;

    public static final class a {
        public int result = 0;
    }

    public zq() {
        this((byte) 0);
    }

    private zq(byte b2) {
        AppMethodBeat.i(91222);
        this.efK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91222);
    }
}
