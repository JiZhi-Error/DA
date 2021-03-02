package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zn extends IEvent {
    public a efE;

    public static final class a {
        public int mode = 0;
    }

    public zn() {
        this((byte) 0);
    }

    private zn(byte b2) {
        AppMethodBeat.i(256166);
        this.efE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(256166);
    }
}
