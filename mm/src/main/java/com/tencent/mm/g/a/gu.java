package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gu extends IEvent {
    public a dKP;

    public static final class a {
        public boolean isActive;
    }

    public gu() {
        this((byte) 0);
    }

    private gu(byte b2) {
        AppMethodBeat.i(19808);
        this.dKP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19808);
    }
}
