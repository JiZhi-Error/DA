package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uh extends IEvent {
    public a eaG;

    public static final class a {
        public String dNA;
        public Boolean eaz;
    }

    public uh() {
        this((byte) 0);
    }

    private uh(byte b2) {
        AppMethodBeat.i(121037);
        this.eaG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121037);
    }
}
