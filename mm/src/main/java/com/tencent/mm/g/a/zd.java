package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zd extends IEvent {
    public a efn;

    public static final class a {
        public boolean efo;
    }

    public zd() {
        this((byte) 0);
    }

    private zd(byte b2) {
        AppMethodBeat.i(19845);
        this.efn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19845);
    }
}
