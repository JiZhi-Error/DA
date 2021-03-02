package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ax extends IEvent {
    public a dDY;

    public static final class a {
        public long dDZ;
        public String filePath;
    }

    public ax() {
        this((byte) 0);
    }

    private ax(byte b2) {
        AppMethodBeat.i(115970);
        this.dDY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115970);
    }
}
