package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vy extends IEvent {
    public a ecb;

    public static final class a {
        public long ecc = -1;
    }

    public vy() {
        this((byte) 0);
    }

    private vy(byte b2) {
        AppMethodBeat.i(125644);
        this.ecb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125644);
    }
}
