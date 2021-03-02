package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaf extends IEvent {
    public a egV;
    public b egW;

    public static final class a {
        public String egX;
    }

    public static final class b {
        public int egY = -1;
        public int egZ = -1;
        public int eha = -1;
    }

    public aaf() {
        this((byte) 0);
    }

    private aaf(byte b2) {
        AppMethodBeat.i(116058);
        this.egV = new a();
        this.egW = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116058);
    }
}
