package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rf extends IEvent {
    public a dXV;

    public static final class a {
        public int action;
    }

    public rf() {
        this((byte) 0);
    }

    private rf(byte b2) {
        AppMethodBeat.i(19826);
        this.dXV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19826);
    }
}
