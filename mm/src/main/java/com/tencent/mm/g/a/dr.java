package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;

public final class dr extends IEvent {
    public a dGF;
    public b dGG;

    public static final class a {
        public String dGH;
        public int dGI = 0;
        public q dGJ;
        public int opType = 0;
    }

    public static final class b {
        public q dGJ;
    }

    public dr() {
        this((byte) 0);
    }

    private dr(byte b2) {
        AppMethodBeat.i(115975);
        this.dGF = new a();
        this.dGG = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115975);
    }
}
