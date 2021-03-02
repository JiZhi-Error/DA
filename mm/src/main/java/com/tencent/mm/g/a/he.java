package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class he extends IEvent {
    public a dLG;

    public static final class a {
        public boolean dLH;
        public long feedId;
    }

    public he() {
        this((byte) 0);
    }

    private he(byte b2) {
        AppMethodBeat.i(241571);
        this.dLG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(241571);
    }
}
