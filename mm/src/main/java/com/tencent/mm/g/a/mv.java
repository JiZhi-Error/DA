package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mv extends IEvent {
    public a dSu;

    public static final class a {
        public boolean dSv;
    }

    public mv() {
        this((byte) 0);
    }

    private mv(byte b2) {
        AppMethodBeat.i(116032);
        this.dSu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116032);
    }
}
