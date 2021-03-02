package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vt extends IEvent {
    public a ebU;

    public static final class a {
        public boolean ebV;
        public int key;
        public int value;
    }

    public vt() {
        this((byte) 0);
    }

    private vt(byte b2) {
        AppMethodBeat.i(125642);
        this.ebU = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125642);
    }
}
