package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yj extends IEvent {
    public a eeG;

    public static final class a {
        public String appId;
        public boolean dCs;
    }

    public yj() {
        this((byte) 0);
    }

    private yj(byte b2) {
        AppMethodBeat.i(201284);
        this.eeG = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201284);
    }
}
