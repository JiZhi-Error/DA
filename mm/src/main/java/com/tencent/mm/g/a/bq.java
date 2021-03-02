package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bq extends IEvent {
    public a dES;

    public static final class a {
        public int dDe = -1;
        public int dEO;
        public boolean dET;
        public boolean dEU;
        public int subType;
    }

    public bq() {
        this((byte) 0);
    }

    private bq(byte b2) {
        AppMethodBeat.i(149856);
        this.dES = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149856);
    }
}
