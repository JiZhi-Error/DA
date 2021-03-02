package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mh extends IEvent {
    public a dRG;

    public static final class a {
        public int dRH = 0;
    }

    public mh() {
        this((byte) 0);
    }

    private mh(byte b2) {
        AppMethodBeat.i(231466);
        this.dRG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(231466);
    }
}
