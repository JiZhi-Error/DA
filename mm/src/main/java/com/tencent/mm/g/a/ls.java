package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ls extends IEvent {
    public a dRd;

    public static final class a {
        public String dRe;
        public int type = 0;
    }

    public ls() {
        this((byte) 0);
    }

    private ls(byte b2) {
        AppMethodBeat.i(89747);
        this.dRd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89747);
    }
}
