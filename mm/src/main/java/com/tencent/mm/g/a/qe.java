package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qe extends IEvent {
    public a dWv;

    public static final class a {
        public int dCm;
        public boolean dEF;
        public String dQx;
        public String dWw;
        public long dWx;
    }

    public qe() {
        this((byte) 0);
    }

    private qe(byte b2) {
        AppMethodBeat.i(201273);
        this.dWv = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201273);
    }
}
