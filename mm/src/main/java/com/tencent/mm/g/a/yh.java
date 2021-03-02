package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yh extends IEvent {
    public a eeC;

    public static final class a {
        public int eeD = 0;
        public int eeE = 0;
        public int eeF = 0;
        public int type = 0;
    }

    public yh() {
        this((byte) 0);
    }

    private yh(byte b2) {
        AppMethodBeat.i(140992);
        this.eeC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140992);
    }
}
