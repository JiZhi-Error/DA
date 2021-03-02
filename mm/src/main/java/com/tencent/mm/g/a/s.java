package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class s extends IEvent {
    public a dCF;

    public static final class a {
        public String dCl;
        public int dCm;
    }

    public s() {
        this((byte) 0);
    }

    private s(byte b2) {
        AppMethodBeat.i(121049);
        this.dCF = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121049);
    }
}
