package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vo extends IEvent {
    public a ebL;

    public static final class a {
        public String dHp;
        public String dRS;
    }

    public vo() {
        this((byte) 0);
    }

    private vo(byte b2) {
        AppMethodBeat.i(125638);
        this.ebL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125638);
    }
}
