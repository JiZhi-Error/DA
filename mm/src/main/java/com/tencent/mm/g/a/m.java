package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class m extends IEvent {
    public a dCj;
    public b dCk;

    public static final class a {
        public String dCl;
    }

    public static final class b {
        public int dCm;
    }

    public m() {
        this((byte) 0);
    }

    private m(byte b2) {
        AppMethodBeat.i(121047);
        this.dCj = new a();
        this.dCk = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121047);
    }
}
