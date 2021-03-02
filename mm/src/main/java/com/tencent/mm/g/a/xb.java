package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xb extends IEvent {
    public a edv;

    public static final class a {
        public boolean edw = false;
        public long edx = 0;
    }

    public xb() {
        this((byte) 0);
    }

    private xb(byte b2) {
        AppMethodBeat.i(118479);
        this.edv = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(118479);
    }
}
