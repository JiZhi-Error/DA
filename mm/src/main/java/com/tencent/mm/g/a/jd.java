package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jd extends IEvent {
    public a dNM;
    public b dNN;

    public static final class a {
        public boolean dNO = false;
        public int dNP = 0;
        public String dNQ;
    }

    public static final class b {
        public String dNR;
        public String dNS;
        public boolean isSuccess = false;
    }

    public jd() {
        this((byte) 0);
    }

    private jd(byte b2) {
        AppMethodBeat.i(91206);
        this.dNM = new a();
        this.dNN = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91206);
    }
}
