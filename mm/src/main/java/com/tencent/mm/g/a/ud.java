package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ud extends IEvent {
    public a eax;

    public static final class a {
        public String dNA;
        public Boolean eay;
        public Boolean eaz;
    }

    public ud() {
        this((byte) 0);
    }

    private ud(byte b2) {
        AppMethodBeat.i(121035);
        this.eax = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121035);
    }
}
