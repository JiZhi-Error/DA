package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class am extends IEvent {
    public a dDo;
    public b dDp;

    public static final class a {
        public int dDq = 0;
    }

    public static final class b {
        public int ret = 0;
    }

    public am() {
        this((byte) 0);
    }

    private am(byte b2) {
        AppMethodBeat.i(42651);
        this.dDo = new a();
        this.dDp = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42651);
    }
}
