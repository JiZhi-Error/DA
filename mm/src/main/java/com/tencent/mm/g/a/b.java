package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class b extends IEvent {
    public a dBM;

    public static final class a {
        public String dBN;
        public int resultCode = 0;
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b2) {
        AppMethodBeat.i(93321);
        this.dBM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(93321);
    }
}
