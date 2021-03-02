package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lx extends IEvent {
    public a dRu;

    public static final class a {
        public int dEO;
        public int dEP;
        public boolean dEQ = false;
        public String filePath;
        public int subType;
    }

    public lx() {
        this((byte) 0);
    }

    private lx(byte b2) {
        AppMethodBeat.i(149869);
        this.dRu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149869);
    }
}
