package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

/* renamed from: com.tencent.mm.g.a.if  reason: invalid class name */
public final class Cif extends IEvent {
    public a dMQ;

    /* renamed from: com.tencent.mm.g.a.if$a */
    public static final class a {
        public int dLS;
    }

    public Cif() {
        this((byte) 0);
    }

    private Cif(byte b2) {
        AppMethodBeat.i(208809);
        this.dMQ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208809);
    }
}
