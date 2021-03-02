package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wn extends IEvent {
    public a ecy;

    public static final class a {
        public String dJX;
        public int dKy;
        public boolean ecA;
        public int ecB;
        public int ecz;
    }

    public wn() {
        this((byte) 0);
    }

    private wn(byte b2) {
        AppMethodBeat.i(125650);
        this.ecy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125650);
    }
}
