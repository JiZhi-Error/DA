package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class il extends IEvent {
    public a dNd;

    public static final class a {
        public float dNe = 0.0f;
        public float dNf = 0.0f;
    }

    public il() {
        this((byte) 0);
    }

    private il(byte b2) {
        AppMethodBeat.i(140986);
        this.dNd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140986);
    }
}
