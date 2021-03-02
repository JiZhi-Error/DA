package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class su extends IEvent {
    public a dZn;

    public static final class a {
        public SnsObject dPc;
    }

    public su() {
        this((byte) 0);
    }

    private su(byte b2) {
        AppMethodBeat.i(125630);
        this.dZn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125630);
    }
}
