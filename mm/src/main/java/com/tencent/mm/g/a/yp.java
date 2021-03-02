package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yp extends IEvent {
    public a eeQ;

    public static final class a {
        public int eeR;
        public boolean eeS = false;
        public boolean eeT = false;
        public String title;
    }

    public yp() {
        this((byte) 0);
    }

    private yp(byte b2) {
        AppMethodBeat.i(153188);
        this.eeQ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(153188);
    }
}
