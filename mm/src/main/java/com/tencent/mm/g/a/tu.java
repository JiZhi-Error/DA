package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tu extends IEvent {
    public a eao;

    public static final class a {
        public boolean dOs = false;
    }

    public tu() {
        this((byte) 0);
    }

    private tu(byte b2) {
        AppMethodBeat.i(110507);
        this.eao = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(110507);
    }
}
