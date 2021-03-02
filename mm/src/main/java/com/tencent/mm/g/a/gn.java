package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gn extends IEvent {
    public a dKu;

    public static final class a {
        public String dDL;
        public String dDM;
        public int dDN;
        public int dKv;
        public boolean isKinda = false;
        public int type;
    }

    public gn() {
        this((byte) 0);
    }

    private gn(byte b2) {
        AppMethodBeat.i(91204);
        this.dKu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91204);
    }
}
