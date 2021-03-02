package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fl extends IEvent {
    public a dIL;

    public static final class a {
        public boolean isSuccess;
    }

    public fl() {
        this((byte) 0);
    }

    private fl(byte b2) {
        AppMethodBeat.i(116013);
        this.dIL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116013);
    }
}
