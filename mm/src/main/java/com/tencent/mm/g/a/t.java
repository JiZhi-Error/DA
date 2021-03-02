package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class t extends IEvent {
    public a dCG;

    public static final class a {
        public boolean dCH = false;
        public boolean dCI = false;
    }

    public t() {
        this((byte) 0);
    }

    private t(byte b2) {
        AppMethodBeat.i(223483);
        this.dCG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(223483);
    }
}
