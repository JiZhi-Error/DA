package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jq extends IEvent {
    public a dOw;
    public b dOx;

    public static final class a {
        public int dOy = 0;
    }

    public static final class b {
        public String dOA;
        public boolean dOz = false;
    }

    public jq() {
        this((byte) 0);
    }

    private jq(byte b2) {
        AppMethodBeat.i(91207);
        this.dOw = new a();
        this.dOx = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91207);
    }
}
