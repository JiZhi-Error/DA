package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vq extends IEvent {
    public a ebN;
    public b ebO;

    public static final class a {
        public String ebP;
    }

    public static final class b {
        public Object result;
    }

    public vq() {
        this((byte) 0);
    }

    private vq(byte b2) {
        AppMethodBeat.i(148771);
        this.ebN = new a();
        this.ebO = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(148771);
    }
}
