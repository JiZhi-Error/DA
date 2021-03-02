package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class no extends IEvent {
    public a dTI;

    public static final class a {
        public int dTJ = 0;
        public int dTK = 0;
    }

    public no() {
        this((byte) 0);
    }

    private no(byte b2) {
        AppMethodBeat.i(19822);
        this.dTI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19822);
    }
}
