package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gj extends IEvent {
    public a dKg;

    public static final class a {
        public int dKh;
        public int dKi;
        public int dKj;
        public int dKk;
        public String fileName;
        public int result;
    }

    public gj() {
        this((byte) 0);
    }

    private gj(byte b2) {
        AppMethodBeat.i(116027);
        this.dKg = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116027);
    }
}
