package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jz extends IEvent {
    public a dOT;
    public b dOU;

    public static final class a {
        public String userName;
    }

    public static final class b {
    }

    public jz() {
        this((byte) 0);
    }

    private jz(byte b2) {
        AppMethodBeat.i(149865);
        this.dOT = new a();
        this.dOU = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149865);
    }
}
