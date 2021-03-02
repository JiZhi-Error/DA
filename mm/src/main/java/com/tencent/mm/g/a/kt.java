package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kt extends IEvent {
    public a dPO;

    public static final class a {
        public int currentIndex;
    }

    public kt() {
        this((byte) 0);
    }

    private kt(byte b2) {
        AppMethodBeat.i(204058);
        this.dPO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(204058);
    }
}
