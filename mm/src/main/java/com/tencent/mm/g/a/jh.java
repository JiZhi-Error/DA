package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jh extends IEvent {
    public a dOa;

    public static final class a {
        public String appId;
    }

    public jh() {
        this((byte) 0);
    }

    private jh(byte b2) {
        AppMethodBeat.i(149862);
        this.dOa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149862);
    }
}
