package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class du extends IEvent {
    public a dGN;
    public b dGO;

    public static final class a {
        public String dGL;
        public String dGP;
    }

    public static final class b {
        public boolean dGQ;
    }

    public du() {
        this((byte) 0);
    }

    private du(byte b2) {
        AppMethodBeat.i(115978);
        this.dGN = new a();
        this.dGO = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115978);
    }
}
