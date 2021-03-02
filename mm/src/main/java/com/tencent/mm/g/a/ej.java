package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ej extends IEvent {
    public a dHN;

    public static final class a {
        public String brandName;
        public String dGL;
        public int dHO;
    }

    public ej() {
        this((byte) 0);
    }

    private ej(byte b2) {
        AppMethodBeat.i(115993);
        this.dHN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115993);
    }
}
