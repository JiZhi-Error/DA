package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uo extends IEvent {
    public a eaR;

    public static final class a {
        public String event;
    }

    public uo() {
        this((byte) 0);
    }

    private uo(byte b2) {
        AppMethodBeat.i(19835);
        this.eaR = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19835);
    }
}
