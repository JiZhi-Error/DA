package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ex extends IEvent {
    public a dIj;
    public b dIk;

    public static final class a {
        public String brandName;
        public String dGL;
        public String data;
    }

    public static final class b {
        public boolean dGX;
    }

    public ex() {
        this((byte) 0);
    }

    private ex(byte b2) {
        AppMethodBeat.i(116007);
        this.dIj = new a();
        this.dIk = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116007);
    }
}
