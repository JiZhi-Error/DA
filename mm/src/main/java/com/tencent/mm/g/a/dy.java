package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dy extends IEvent {
    public a dHa;
    public b dHb;

    public static final class a {
        public String dGL;
        public String dHc;
    }

    public static final class b {
        public boolean dGX;
    }

    public dy() {
        this((byte) 0);
    }

    private dy(byte b2) {
        AppMethodBeat.i(115982);
        this.dHa = new a();
        this.dHb = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115982);
    }
}
