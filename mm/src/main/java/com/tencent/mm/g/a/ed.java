package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ed extends IEvent {
    public a dHn;
    public b dHo;

    public static final class a {
        public String dHp;
        public String dHq;
        public String dHr;
        public long msgId;
    }

    public static final class b {
        public boolean dGX;
        public List dHs;
    }

    public ed() {
        this((byte) 0);
    }

    private ed(byte b2) {
        AppMethodBeat.i(115987);
        this.dHn = new a();
        this.dHo = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115987);
    }
}
