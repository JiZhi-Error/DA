package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iz extends IEvent {
    public a dND;
    public b dNE;

    public static final class a {
        public int EX = 0;
        public String url;
    }

    public static final class b {
        public String dNF;
        public boolean dNG = false;
    }

    public iz() {
        this((byte) 0);
    }

    private iz(byte b2) {
        AppMethodBeat.i(89645);
        this.dND = new a();
        this.dNE = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89645);
    }
}
