package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mn extends IEvent {
    public a dSa;
    public b dSb;

    public static final class a {
        public int action;
        public int dSc;
        public String filePath;
    }

    public static final class b {
    }

    public mn() {
        this((byte) 0);
    }

    private mn(byte b2) {
        AppMethodBeat.i(149871);
        this.dSa = new a();
        this.dSb = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149871);
    }
}
