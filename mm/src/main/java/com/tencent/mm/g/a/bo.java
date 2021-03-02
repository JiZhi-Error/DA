package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bo extends IEvent {
    public a dEL;

    public static final class a {
        public int dEM = 0;
    }

    public bo() {
        this((byte) 0);
    }

    private bo(byte b2) {
        AppMethodBeat.i(131788);
        this.dEL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131788);
    }
}
