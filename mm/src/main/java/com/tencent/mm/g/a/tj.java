package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tj extends IEvent {
    public a dZP;

    public static final class a {
        public int dDe;
    }

    public tj() {
        this((byte) 0);
    }

    private tj(byte b2) {
        AppMethodBeat.i(91039);
        this.dZP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91039);
    }
}
