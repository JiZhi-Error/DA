package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ze extends IEvent {
    public a efp;

    public static final class a {
        public String path;
    }

    public ze() {
        this((byte) 0);
    }

    private ze(byte b2) {
        AppMethodBeat.i(19846);
        this.efp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19846);
    }
}
