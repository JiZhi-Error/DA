package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aax extends IEvent {
    public a ehN;

    public static final class a {
        public String ehO;
        public String ehP;
        public String ehQ;
        public String ehR;
        public int ehS;
        public String ehT;
        public String ehU;
        public int ehV;
        public int ehW;
        public int ehX;
        public String ehY;
        public String ehZ;
        public String eia;
        public int eib;
        public String eic;
        public String url;
    }

    public aax() {
        this((byte) 0);
    }

    private aax(byte b2) {
        AppMethodBeat.i(116060);
        this.ehN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116060);
    }
}
