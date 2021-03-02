package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ks extends IEvent {
    public a dPN;

    public static final class a {
        public int delay;
        public int type;
    }

    public ks() {
        this((byte) 0);
    }

    private ks(byte b2) {
        AppMethodBeat.i(153184);
        this.dPN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153184);
    }
}
