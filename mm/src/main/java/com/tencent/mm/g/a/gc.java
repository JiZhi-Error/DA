package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gc extends IEvent {
    public a dJH;
    public b dJI;

    public static final class a {
        public Runnable doJ;
        public int duration;
        public String filePath;
        public int op;
    }

    public static final class b {
        public boolean dFE = false;
        public int dJJ;
    }

    public gc() {
        this((byte) 0);
    }

    private gc(byte b2) {
        AppMethodBeat.i(116021);
        this.dJH = new a();
        this.dJI = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116021);
    }
}
