package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wo extends IEvent {
    public a ecC;
    public b ecD;

    public static final class a {
        public boolean ecE;
        public String ecF;
        public cz ecG;
        public String url;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public wo() {
        this((byte) 0);
    }

    private wo(byte b2) {
        AppMethodBeat.i(127410);
        this.ecC = new a();
        this.ecD = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127410);
    }
}
