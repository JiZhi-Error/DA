package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qn extends IEvent {
    public a dWV;
    public b dWW;

    public static final class a {
        public cz dWX;
        public int dWY = -1;
        public String dWZ;
        public int dXa = 0;
        public int opType = 1;
    }

    public static final class b {
        public boolean dFE;
    }

    public qn() {
        this((byte) 0);
    }

    private qn(byte b2) {
        AppMethodBeat.i(123933);
        this.dWV = new a();
        this.dWW = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(123933);
    }
}
