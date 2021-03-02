package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jw extends IEvent {
    public a dOP;

    public static final class a {
        public String url;
    }

    public jw() {
        this((byte) 0);
    }

    private jw(byte b2) {
        AppMethodBeat.i(149864);
        this.dOP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149864);
    }
}
