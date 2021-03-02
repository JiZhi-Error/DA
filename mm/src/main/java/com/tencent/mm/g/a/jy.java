package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jy extends IEvent {
    public a dOR;

    public static final class a {
        public int dOS;
    }

    public jy() {
        this((byte) 0);
    }

    private jy(byte b2) {
        AppMethodBeat.i(184504);
        this.dOR = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(184504);
    }
}
