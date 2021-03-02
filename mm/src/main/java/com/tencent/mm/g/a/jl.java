package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jl extends IEvent {
    public a dOk;
    public b dOl;

    public static final class a {
        public String dOm;
    }

    public static final class b {
        public String userName;
    }

    public jl() {
        this((byte) 0);
    }

    private jl(byte b2) {
        AppMethodBeat.i(155368);
        this.dOk = new a();
        this.dOl = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155368);
    }
}
