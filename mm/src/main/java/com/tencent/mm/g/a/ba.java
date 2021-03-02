package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ba extends IEvent {
    public a dEe;
    public b dEf;

    public static final class a {
        public String dEg;
        public boolean dEh;
        public boolean dEi;
        public boolean dEj;
    }

    public static final class b {
        public boolean result;
    }

    public ba() {
        this((byte) 0);
    }

    private ba(byte b2) {
        AppMethodBeat.i(91198);
        this.dEe = new a();
        this.dEf = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91198);
    }
}
