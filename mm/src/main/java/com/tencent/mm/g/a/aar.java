package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aar extends IEvent {
    public a ehE;
    public b ehF;

    public static final class a {
        public int dDe;
        public String username;
    }

    public static final class b {
        public int ehG;
    }

    public aar() {
        this((byte) 0);
    }

    private aar(byte b2) {
        AppMethodBeat.i(19850);
        this.ehE = new a();
        this.ehF = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19850);
    }
}
