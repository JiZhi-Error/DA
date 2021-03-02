package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iu extends IEvent {
    public a dNu;

    public static final class a {
        public String countryCode;
        public int dNv;
        public int dNw;
    }

    public iu() {
        this((byte) 0);
    }

    private iu(byte b2) {
        AppMethodBeat.i(89641);
        this.dNu = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89641);
    }
}
