package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dx extends IEvent {
    public a dGY;
    public b dGZ;

    public static final class a {
        public String brandName;
        public String dGL;
        public boolean dGW = false;
    }

    public static final class b {
        public boolean dGX;
    }

    public dx() {
        this((byte) 0);
    }

    private dx(byte b2) {
        AppMethodBeat.i(115981);
        this.dGY = new a();
        this.dGZ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115981);
    }
}
