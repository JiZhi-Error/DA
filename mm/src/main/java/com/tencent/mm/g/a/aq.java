package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.sdk.event.IEvent;

public final class aq extends IEvent {
    public a dDA;

    public static final class a {
        public int dDB;
        public eqs dDC;
    }

    public aq() {
        this((byte) 0);
    }

    private aq(byte b2) {
        AppMethodBeat.i(175415);
        this.dDA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(175415);
    }
}
