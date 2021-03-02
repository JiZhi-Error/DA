package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aal extends IEvent {
    public a ehk;

    public static final class a {
        public String activity;
        public long ehl;
        public int type;
    }

    public aal() {
        this((byte) 0);
    }

    private aal(byte b2) {
        AppMethodBeat.i(194256);
        this.ehk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194256);
    }
}
