package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ai extends IEvent {
    public a dDh;

    public static final class a {
        public String dDi;
        public String dDj;
        public String dDk;
    }

    public ai() {
        this((byte) 0);
    }

    private ai(byte b2) {
        AppMethodBeat.i(19403);
        this.dDh = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19403);
    }
}
