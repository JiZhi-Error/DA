package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yk extends IEvent {
    public a eeH;

    public static final class a {
        public String countryCode;
    }

    public yk() {
        this((byte) 0);
    }

    private yk(byte b2) {
        AppMethodBeat.i(19843);
        this.eeH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19843);
    }
}
