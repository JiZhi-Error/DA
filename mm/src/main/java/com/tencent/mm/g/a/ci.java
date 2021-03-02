package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ci extends IEvent {
    public a dFt;

    public static final class a {
        public boolean dFA = true;
        public int dFu;
        public String dFv;
        public String dFw;
        public String dFx;
        public String dFy;
        public String dFz;
        public long gY;
        public int source;
    }

    public ci() {
        this((byte) 0);
    }

    private ci(byte b2) {
        AppMethodBeat.i(91201);
        this.dFt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91201);
    }
}
