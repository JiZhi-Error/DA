package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class in extends IEvent {
    public a dNg;

    public static final class a {
        public String data;
    }

    public in() {
        this((byte) 0);
    }

    private in(byte b2) {
        AppMethodBeat.i(19810);
        this.dNg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19810);
    }
}
