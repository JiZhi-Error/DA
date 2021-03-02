package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jm extends IEvent {
    public a dOn;

    public static final class a {
        public int dOo = 0;
        public boolean dOp = false;
    }

    public jm() {
        this((byte) 0);
    }

    private jm(byte b2) {
        AppMethodBeat.i(131790);
        this.dOn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(131790);
    }
}
