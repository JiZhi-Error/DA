package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ay extends IEvent {
    public a dEa;

    public static final class a {
        public int dEb;
        public int scene = 0;
    }

    public ay() {
        this((byte) 0);
    }

    private ay(byte b2) {
        AppMethodBeat.i(120830);
        this.dEa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(120830);
    }
}
