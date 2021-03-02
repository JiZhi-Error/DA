package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ga extends IEvent {
    public a dJF;
    public b dJG;

    public static final class a {
        public int op;
        public String username;
    }

    public static final class b {
        public boolean dFE = false;
        public String fileName;
    }

    public ga() {
        this((byte) 0);
    }

    private ga(byte b2) {
        AppMethodBeat.i(116020);
        this.dJF = new a();
        this.dJG = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116020);
    }
}
