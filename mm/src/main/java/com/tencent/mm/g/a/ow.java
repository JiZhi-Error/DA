package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ow extends IEvent {
    public a dUQ;
    public b dUR;

    public static final class a {
        public String dNQ;
        public int dUS = 0;
        public int dUT = 0;
        public Runnable dUU;
    }

    public static final class b {
        public int dNP = 0;
        public String dNR;
        public String dNS;
        public String dUV;
        public int dUW = 0;
        public int errCode = -1;
        public String errMsg;
    }

    public ow() {
        this((byte) 0);
    }

    private ow(byte b2) {
        AppMethodBeat.i(140935);
        this.dUQ = new a();
        this.dUR = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140935);
    }
}
