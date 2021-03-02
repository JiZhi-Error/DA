package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eh extends IEvent {
    public a dHC;
    public b dHD;

    public static final class a {
        public boolean dHB = false;
        public String dHE;
    }

    public static final class b {
        public boolean dHF = false;
    }

    public eh() {
        this((byte) 0);
    }

    private eh(byte b2) {
        AppMethodBeat.i(115991);
        this.dHC = new a();
        this.dHD = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115991);
    }
}
