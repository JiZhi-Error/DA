package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ml extends IEvent {
    public a dRT;

    public static final class a {
        public boolean dRU = false;
        public int dRV;
        public boolean dRW = false;
        public int dRX;
        public boolean dRY = false;
        public int dRZ;
    }

    public ml() {
        this((byte) 0);
    }

    private ml(byte b2) {
        AppMethodBeat.i(155544);
        this.dRT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155544);
    }
}
