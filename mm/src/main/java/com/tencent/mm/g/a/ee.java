package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ee extends IEvent {
    public a dHt;
    public b dHu;

    public static final class a {
        public String brandName;
        public String dGL;
        public String dHv;
        public int type;
    }

    public static final class b {
        public boolean dHw;
        public String dHx;
    }

    public ee() {
        this((byte) 0);
    }

    private ee(byte b2) {
        AppMethodBeat.i(115988);
        this.dHt = new a();
        this.dHu = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115988);
    }
}
