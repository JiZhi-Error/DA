package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aac extends IEvent {
    public a egO;
    public b egP;

    public static final class a {
    }

    public static final class b {
    }

    public aac() {
        this((byte) 0);
    }

    private aac(byte b2) {
        AppMethodBeat.i(91229);
        this.egO = new a();
        this.egP = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91229);
    }
}
