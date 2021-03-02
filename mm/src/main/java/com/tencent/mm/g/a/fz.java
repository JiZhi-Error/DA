package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.sdk.event.IEvent;

public final class fz extends IEvent {
    public a dJA;
    public b dJB;

    public static final class a {
        public boolean dJC = false;
        public k.a dJD;
        public k.b dJE;
        public boolean dtE;
        public String fileName;
        public int op;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public fz() {
        this((byte) 0);
    }

    private fz(byte b2) {
        AppMethodBeat.i(116019);
        this.dJA = new a();
        this.dJB = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116019);
    }
}
