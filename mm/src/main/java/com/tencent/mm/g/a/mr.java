package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mr extends IEvent {
    public a dSi;

    public static final class a {
        public int dSj;
        public int dSk;
        public int dSl;
    }

    public mr() {
        this((byte) 0);
    }

    private mr(byte b2) {
        AppMethodBeat.i(19820);
        this.dSi = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19820);
    }
}
