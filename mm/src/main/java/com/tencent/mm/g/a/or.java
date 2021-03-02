package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class or extends IEvent {
    public a dUI;

    public static final class a {
        public int bDZ;
        public String dGL;
        public int dHO;
        public String dRD;
        public int op = 0;
        public String url;
    }

    public or() {
        this((byte) 0);
    }

    private or(byte b2) {
        AppMethodBeat.i(116038);
        this.dUI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116038);
    }
}
