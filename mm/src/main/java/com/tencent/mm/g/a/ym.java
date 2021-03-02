package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.event.IEvent;

public final class ym extends IEvent {
    public a eeL;

    public static final class a {
        public czl eeM;
    }

    public ym() {
        this((byte) 0);
    }

    private ym(byte b2) {
        AppMethodBeat.i(134107);
        this.eeL = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(134107);
    }
}
