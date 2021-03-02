package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zt extends IEvent {
    public a efM;
    public b efN;

    public static final class a {
        public String scene;
    }

    public static final class b {
        public String content;
        public String efO;
        public String url;
    }

    public zt() {
        this((byte) 0);
    }

    private zt(byte b2) {
        AppMethodBeat.i(91223);
        this.efM = new a();
        this.efN = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91223);
    }
}
