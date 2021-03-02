package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aao extends IEvent {
    public a ehA;

    public static final class a {
        public int dDe;
        public String[] ehB;
    }

    public aao() {
        this((byte) 0);
    }

    private aao(byte b2) {
        AppMethodBeat.i(104423);
        this.ehA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104423);
    }
}
