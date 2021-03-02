package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xg extends IEvent {
    public a edA;

    public static final class a {
        public boolean edB = false;
    }

    public xg() {
        this((byte) 0);
    }

    private xg(byte b2) {
        AppMethodBeat.i(91220);
        this.edA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91220);
    }
}
