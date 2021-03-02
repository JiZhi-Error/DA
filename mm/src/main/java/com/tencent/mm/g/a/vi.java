package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vi extends IEvent {
    public a ebE;

    public static final class a {
        public String dRS;
        public String ebF;
    }

    public vi() {
        this((byte) 0);
    }

    private vi(byte b2) {
        AppMethodBeat.i(125633);
        this.ebE = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125633);
    }
}
