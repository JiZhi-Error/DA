package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ha extends IEvent {
    public a dLj;
    public b dLk;

    public static final class a {
        public String dLl;
    }

    public static final class b {
        public int dEq = 0;
        public int dEr = 0;
        public int dEs = 0;
        public int dEt = 0;
    }

    public ha() {
        this((byte) 0);
    }

    private ha(byte b2) {
        AppMethodBeat.i(106599);
        this.dLj = new a();
        this.dLk = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(106599);
    }
}
