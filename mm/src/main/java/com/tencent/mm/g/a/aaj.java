package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaj extends IEvent {
    public a ehg;

    public static final class a {
        public long dTS;
        public String dWG;
        public String ehh;
    }

    public aaj() {
        this((byte) 0);
    }

    private aaj(byte b2) {
        AppMethodBeat.i(117552);
        this.ehg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117552);
    }
}
