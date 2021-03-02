package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dp extends IEvent {
    public a dGC;

    public static final class a {
        public String dGD;
        public String productId;
        public int progress = 0;
        public int status = 0;
    }

    public dp() {
        this((byte) 0);
    }

    private dp(byte b2) {
        AppMethodBeat.i(104416);
        this.dGC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104416);
    }
}
