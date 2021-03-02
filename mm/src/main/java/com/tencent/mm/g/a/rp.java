package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rp extends IEvent {
    public a dYf;

    public static final class a {
        public String dDM;
        public String dQp;
        public int dYg;
        public String dYh;
        public int dYi;
    }

    public rp() {
        this((byte) 0);
    }

    private rp(byte b2) {
        AppMethodBeat.i(91216);
        this.dYf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91216);
    }
}
