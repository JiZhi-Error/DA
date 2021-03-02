package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class us extends IEvent {
    public a eaU;
    public b eaV;

    public static final class a {
        public boolean eaW;
    }

    public static final class b {
        public boolean eaX;
        public boolean eaY;
        public boolean eaZ;
    }

    public us() {
        this((byte) 0);
    }

    private us(byte b2) {
        AppMethodBeat.i(153185);
        this.eaU = new a();
        this.eaV = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153185);
    }
}
