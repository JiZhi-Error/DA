package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.event.IEvent;

public final class zl extends IEvent {
    public a efC;

    public static final class a {
        public ckj efB;
    }

    public zl() {
        this((byte) 0);
    }

    private zl(byte b2) {
        AppMethodBeat.i(256165);
        this.efC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(256165);
    }
}
