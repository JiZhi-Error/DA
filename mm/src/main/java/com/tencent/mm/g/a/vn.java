package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vn extends IEvent {
    public a ebK;

    public static final class a {
        public String dHp;
        public String dRS;
    }

    public vn() {
        this((byte) 0);
    }

    private vn(byte b2) {
        AppMethodBeat.i(125637);
        this.ebK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125637);
    }
}
