package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lz extends IEvent {
    public a dRz;

    public static final class a {
        public String content;
        public String url;
    }

    public lz() {
        this((byte) 0);
    }

    private lz(byte b2) {
        AppMethodBeat.i(155372);
        this.dRz = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155372);
    }
}
