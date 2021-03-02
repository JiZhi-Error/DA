package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qa extends IEvent {
    public a dWj;
    public b dWk;

    public static final class a {
        public int cSx = 0;
        public String dWl;
        public String scanResult;
    }

    public static final class b {
        public int ret = 0;
    }

    public qa() {
        this((byte) 0);
    }

    private qa(byte b2) {
        AppMethodBeat.i(149880);
        this.dWj = new a();
        this.dWk = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149880);
    }
}
