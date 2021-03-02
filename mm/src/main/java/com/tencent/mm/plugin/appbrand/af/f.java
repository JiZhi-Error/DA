package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class f extends IEvent {
    public a ojR;

    public static final class a {
    }

    public f() {
        this((byte) 0);
    }

    private f(byte b2) {
        AppMethodBeat.i(49345);
        this.ojR = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(49345);
    }
}
