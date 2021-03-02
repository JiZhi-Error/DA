package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eo extends IEvent {
    public a dHV;

    public static final class a {
        public int dHW = -1;
    }

    public eo() {
        this((byte) 0);
    }

    private eo(byte b2) {
        AppMethodBeat.i(115998);
        this.dHV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115998);
    }
}
