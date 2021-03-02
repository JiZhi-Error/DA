package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ie extends IEvent {
    public a dMM;

    public static final class a {
        public String dMN;
        public int dMO;
        public String dMP;
        public int scene;
    }

    public ie() {
        this((byte) 0);
    }

    private ie(byte b2) {
        AppMethodBeat.i(241575);
        this.dMM = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241575);
    }
}
