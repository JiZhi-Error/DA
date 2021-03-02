package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ty extends IEvent {
    public a eas;

    public static final class a {
        public String dYs;
        public int msgType = 0;
    }

    public ty() {
        this((byte) 0);
    }

    private ty(byte b2) {
        AppMethodBeat.i(19834);
        this.eas = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19834);
    }
}
