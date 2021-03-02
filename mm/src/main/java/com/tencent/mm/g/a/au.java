package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sp;
import com.tencent.mm.sdk.event.IEvent;

public final class au extends IEvent {
    public a dDQ;

    public static final class a {
        public sp dDR;
    }

    public au() {
        this((byte) 0);
    }

    private au(byte b2) {
        AppMethodBeat.i(199082);
        this.dDQ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(199082);
    }
}
