package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IEvent;

public final class ig extends IEvent {
    public a dMR;

    public static final class a {
        public bds dMS;
        public int index;
    }

    public ig() {
        this((byte) 0);
    }

    private ig(byte b2) {
        AppMethodBeat.i(208810);
        this.dMR = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208810);
    }
}
