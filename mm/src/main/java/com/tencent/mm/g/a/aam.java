package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aam extends IEvent {
    public a ehm;

    public static final class a {
        public int ehn;
        public boolean eho;
        public int ehp;
    }

    public aam() {
        this((byte) 0);
    }

    private aam(byte b2) {
        AppMethodBeat.i(192280);
        this.ehm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(192280);
    }
}
