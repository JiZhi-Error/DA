package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jt extends IEvent {
    public a dOE;
    public b dOF;

    public static final class a {
        public int dOG = -1;
    }

    public static final class b {
        public int dOH = 0;
    }

    public jt() {
        this((byte) 0);
    }

    private jt(byte b2) {
        AppMethodBeat.i(130778);
        this.dOE = new a();
        this.dOF = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130778);
    }
}
