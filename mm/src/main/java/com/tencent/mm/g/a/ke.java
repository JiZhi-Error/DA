package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ke extends IEvent {
    public a dPe;

    public static final class a {
        public int dKy = 0;
    }

    public ke() {
        this((byte) 0);
    }

    private ke(byte b2) {
        AppMethodBeat.i(125620);
        this.dPe = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125620);
    }
}
