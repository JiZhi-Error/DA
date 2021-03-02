package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sb extends IEvent {
    public a dYE;

    public static final class a {
        public byte[] buffer;
    }

    public sb() {
        this((byte) 0);
    }

    private sb(byte b2) {
        AppMethodBeat.i(187544);
        this.dYE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(187544);
    }
}
