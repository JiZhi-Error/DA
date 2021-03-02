package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.event.IEvent;

public final class zk extends IEvent {
    public a efA;

    public static final class a {
        public ckj efB;
    }

    public zk() {
        this((byte) 0);
    }

    private zk(byte b2) {
        AppMethodBeat.i(256164);
        this.efA = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(256164);
    }
}
