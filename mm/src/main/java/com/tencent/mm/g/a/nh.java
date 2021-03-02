package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class nh extends IEvent {
    public a dTr;
    public b dTs;

    public static final class a {
        public String dRj;
        public boolean dSQ = false;
    }

    public static final class b {
        public int dRN = 0;
        public LinkedList<cho> dTe;
    }

    public nh() {
        this((byte) 0);
    }

    private nh(byte b2) {
        AppMethodBeat.i(138164);
        this.dTr = new a();
        this.dTs = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(138164);
    }
}
