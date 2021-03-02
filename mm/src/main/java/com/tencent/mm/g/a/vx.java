package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vx extends IEvent {
    public a ebX;

    public static final class a {
        public boolean ebY;
        public boolean ebZ;
        public boolean eca;
        public String username;
    }

    public vx() {
        this((byte) 0);
    }

    private vx(byte b2) {
        AppMethodBeat.i(125643);
        this.ebX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125643);
    }
}
