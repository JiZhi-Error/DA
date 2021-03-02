package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gx extends IEvent {
    public a dLa;

    public static final class a {
        public Object dDg;
        public long dFW;
        public String dLb;
        public int dLc;
        public Object dLd;
        public String dLe;
    }

    public gx() {
        this((byte) 0);
    }

    private gx(byte b2) {
        AppMethodBeat.i(19809);
        this.dLa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19809);
    }
}
