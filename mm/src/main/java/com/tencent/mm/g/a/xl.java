package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xl extends IEvent {
    public a edI;

    public static final class a {
        public int status = 0;
    }

    public xl() {
        this((byte) 0);
    }

    private xl(byte b2) {
        AppMethodBeat.i(131795);
        this.edI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131795);
    }
}
