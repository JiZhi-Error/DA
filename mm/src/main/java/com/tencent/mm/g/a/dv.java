package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dv extends IEvent {
    public a dGR;
    public b dGS;

    public static final class a {
        public String dGL;
        public String dGP;
    }

    public static final class b {
        public boolean dGT;
    }

    public dv() {
        this((byte) 0);
    }

    private dv(byte b2) {
        AppMethodBeat.i(115979);
        this.dGR = new a();
        this.dGS = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115979);
    }
}
