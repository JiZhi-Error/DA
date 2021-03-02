package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aau extends IEvent {
    public a ehJ;

    public static final class a {
        public String ehK;
    }

    public aau() {
        this((byte) 0);
    }

    private aau(byte b2) {
        AppMethodBeat.i(77799);
        this.ehJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(77799);
    }
}
