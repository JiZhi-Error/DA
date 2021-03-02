package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class ly extends IEvent {
    public a dRv;
    public b dRw;

    public static final class a {
        public ca dCM;
        public int dRq = 0;
        public boolean dRx = false;
        public String language;
    }

    public static final class b {
        public String dNk;
        public String dRy;
    }

    public ly() {
        this((byte) 0);
    }

    private ly(byte b2) {
        AppMethodBeat.i(55664);
        this.dRv = new a();
        this.dRw = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(55664);
    }
}
