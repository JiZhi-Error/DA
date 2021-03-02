package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class rr extends IEvent {
    public a dYk;

    public static final class a {
        public SnsAdClick dYl;
    }

    public rr() {
        this((byte) 0);
    }

    private rr(byte b2) {
        AppMethodBeat.i(125626);
        this.dYk = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125626);
    }
}
