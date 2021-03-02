package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bm extends IEvent {
    public a dEH;

    public static final class a {
        public boolean dEI = false;
        public boolean dEJ = false;
        public boolean dEK = false;
    }

    public bm() {
        this((byte) 0);
    }

    private bm(byte b2) {
        AppMethodBeat.i(149854);
        this.dEH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149854);
    }
}
