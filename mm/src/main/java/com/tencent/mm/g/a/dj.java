package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dj extends IEvent {
    public a dGu;

    public static final class a {
        public int state = -1;
    }

    public dj() {
        this((byte) 0);
    }

    private dj(byte b2) {
        AppMethodBeat.i(104412);
        this.dGu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104412);
    }
}
